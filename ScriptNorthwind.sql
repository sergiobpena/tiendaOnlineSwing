-- nombres das categoriaws
SELECT CategoryName FROM Category AS Categorias;

--nombre e descripcion das categorias que comezan por c
SELECT Categoryname,description
FROM Category 
WHERE CategoryName LIKE 'C%';

-- nombres dos (company name) clientes de Francia
SELECT Companyname AS nombre
FROM customer
where country = 'france';

-- nombres e paises dos (company name) clientes de Francia e españa
SELECT Companyname AS nombre, country AS pais
FROM customer
where country = 'france' OR country='spain'
ORDER BY companyname DESC;

SELECT Companyname AS nombre, country AS pais
FROM customer
where country IN ('france','spain')
ORDER BY companyname DESC;

-- FECHA (ORDERDATE)pedidos realizados no ano 1997

SELECT orderid, orderdate
FROM orders
where orderdate like '1997%';

SELECT orderid, orderdate
FROM orders
where orderdate between '1997-01-01' and '1997-12-31';

--ORDERDATE DOS PEDIDOS QUE NON SE ENVIARION

select orderdate 
from orders
where shippedDate IS null;

--NOMBRE DOS PRODUCTOS DA CATEGORIA CONFECTIONS

select productname
from product P join category C on P.categoryid = C.categoryid
where categoryname = 'confections';


-- nome dos empleados e nome dos seus xefes correspondentes
select  concat(empleado.firstname,' ',empleado.lastname) as "Empleado" , jefe.firstname as "Xefe"
from employee as empleado join employee as jefe on empleado.reportsto=jefe.employeeID ;

--orderid dos pedidos enviados o cliente "Rancho grande" polo employee nancy

select orderid , firstname , companyname
from customer C join orders O on C.customerid=O.customerid 
	join employee E  on E.employeeID=O.employeeID
where companyname ='rancho grande' and firstname='nancy';--falla

--telefono dos shippers dos que lle envian os pedidos a rancho grande
select S.companyname , S.phone , c.companyname
from shipper S join orders O on s.shipperID=o.shipvia
	join customer c on o.customerid=c.customerid
where c.companyname='rancho grande'

--importetotal do pedido 10916
select sum(unitprice*quantity) as precio_total
from orderdetail
where orderid=10916

--importe total de cada pedido de rancho grande
select sum(OD.unitprice*OD.quantity)
from customer C join orders O on C.customerID = O customerID
	join orderdetail OD on O.orderID=OD.orderID
where c.companyname = 'rancho grande'
group by OD.orderID



select order id 
from custumer  C  join orders O on C.custumerid= O custumerid
where namecompany = 'rancho grande' and orderid in (
	select orderid
	from orders O join employee E on E.employeeid=O.employeeid
	where lastname='nancy'
)





--obtener el id pedido y el importe total en los que el totel es superior a mil
select orderid, sum(unitprice*quantity) as total
from orderdetail
group by orderid
having total >1000

--que producto ten un coste 

select distinct p.productname , od.unitprice PrecioAntes , p.unitprice as PrecioActual
from product P join orderdetail OD on p.productid=OD.productid
where OD.unitprice < p.unitprice

--telefono do cliente que mais productos mercou
select max


select sum(quantity)as totales ,c.customerid, c.phone,contactname
	from orderdetail OD join orders O on OD.orderid=O.orderid
	join customer C on O.customerID=C.customerID
	group by c.customerid 
	order by totales desc limit 1
-- o pais que mais confections compra
select country, sum(quantity) as total
from category as CAT join product PR on CAT.categoryid=PR.categoryid
	join orderdetail OD ON PR.productID=OD.productiD
		join orders O on OD.orderId=O.orderId
			join customer C on O.customerId=C.customerId
	where CAT.categoryname = 'confections'
	group by country
	order by total desc limit 1
--cantos productos se venderon do producto mais seleccionado
select sum(quantity) as total
from orderdetail
group by productid
order by total desc limit 1

--descripcion de la region del empleado donde mas productos se venden

select regiondescription , sum(quantity) as total
from orderdetail OD join orders ORD on OD.orderID=ORD.orderId
	join employee EM on ORD.employeeId=EM.employeeId
	join employeeterritory ET on EM.employeeId=ET.employeeId
	join territory T on ET.territoryid=T.territoryid
	join region R on T.regionID=R.regionId
group by R.regionid, regiondescription
order by total desc limit 1;

-- en que ano o proveedor bigfoot breweries mandou mais productos a USA
select year(orderdate) , sum(quantity) total
from customer C join orders O on C.customerId=O.customerId
	join orderdetail OD on O.orderid=OD.orderId
	join product p on p.productid=od.productid
	join supplier S on S.supplierid=p.supplierid
where S.companyname='Bigfoot breweries' AND C.country='USA'
group by year(orderdate)
order by total desc limit 1


select address,orderdate, firstname 
from employee EM join orders O on em.employeeid=o.employeeid
	join orderdetail OD on O.orderid=od.orderid
	join product P on OD.productid=p.productid
	join category C on P.categoryid = c.categoryID
where categoryname='confections'	
order by orderdate asc limit 1
	
-- precio medio dos pedidos de cada cliente
select avg(total) as mediapedidos, companyname
from (select sum(od.unitprice*od.quantity)total, c.companyname, OD.orderid
	from customer c join orders o on c.customerid=o.customerid
		join orderdetail od on o.orderid=od.orderid
	group by od.orderid, companyname)as totales
group by companyname

-- cantos descontos se lle aplicaron a cada cliente
select count(discount),c.companyname
from customer c join orders o on c.customerid=o.customerid
	join orderdetail od on o.orderid=od.orderid
where od.discount>0
group by c.customerid,c.companyname

--clientes que non fixeron pedidos subconsultas
select companyname
from customer
where customerid not in  (select distinct customerid
						from orders);
--
select companyname
from customer C left join orders o on c.customerid=o.customerid 
where o.orderid is null

-- aumentar en 0.2 el precio de los productos subministrados por "Ma Maison"

select p.productname, s.companyname,unitprice
from supplier S join product p on s.supplierid=p.supplierid
where s.companyname ='Ma Maison'

update product
set unitprice = unitprice + 0.2
where supplierid IN (select supplierid
					from supplier
					where companyname= 'Ma Maison')
-- importe total vendido polo empleado mais antigo da empresa
select sum(unitprice*quantity)as totalPedido , e.employeeid, e.firstname , hiredate
from employee e join orders o on e.employeeid=o.employeeid
	join orderdetail od on o.orderid=od.orderid
group by e.employeeid, firstname
order by hiredate  limit 1 


--cuantos productos de cada categoria vende cada empleado
select categoryname , firstname, sum(quantity)
from employee EM join orders O on em.employeeid=o.employeeid
	join orderdetail OD on O.orderid=od.orderid
	join product P on OD.productid=p.productid
	join category C on P.categoryid = c.categoryID
group by C.categoryname , EM.firstname

--top 3 de productos comprados desde españa
select productname , sum(quantity) total
from orderdetail od join orders o on o.orderid = od.orderid
	join customer c on c.customerid = o.customerid
	join product p on p.productid = od.productid
where c.country='spain'
group by p.productid
order by total desc limit 4
--% sobre o total de empleados que ten o cargo cada supervisor reportsto

select count(*)/(select count(*)from employee)as porcentaje , J.firstname
from employee E join employee J on E.reportsto=J.employeeid
group by E.reportsto

--el mejor cliente de cada empleado por importe de ventas
select max(total), empid
from(
	select O.employeeid as empid, O.customerid, sum(quantity*unitprice) total 
	from orderdetail od join orders o on o.orderid=od.orderid
	group by o.employeeid, o.customerid 
	order by o.employeeid , o.customerid) totales
group by totales.empid
	







