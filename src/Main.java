
import java.util.Calendar;

import org.curso.tienda.modelo.Carrito;
import org.curso.tienda.modelo.CarritoCollections;
import org.curso.tienda.modelo.Cliente;
import org.curso.tienda.modelo.Dni;
import org.curso.tienda.modelo.TiendaFacade;
import org.curso.tienda.modelo.Libro;
import org.curso.tienda.modelo.Pelicula;
import org.curso.tienda.modelo.exception.CarritoLlenoException;
import org.curso.tienda.modelo.exception.LetraDniIncorrectaException;

public class Main {

	public static void main(String[] args) {
		
		try {
			//Cliente 1			
		Dni d1 = new Dni (0,'T');
		Calendar fecha1=Calendar.getInstance();
		fecha1.set(1950,11,10);
		Cliente c1= new Cliente ( d1,"1234", "rafa","Rafael", "Martinez" , "Mi calle nº3", fecha1);
		
		//Cliente 2
		
		Dni d2 = new Dni (1,'R');
		Calendar fecha2=Calendar.getInstance();
		fecha2.set(1950,11,10);
		Cliente c2= new Cliente ( d2,"1234", "gabi","gabriel", "Rodriguez" , "Mi calle nº8", fecha2);
		
		//Cliente 3
		
		Dni d3 = new Dni (2,'W');
		Calendar fecha3=Calendar.getInstance();
		fecha3.set(1950,11,10);
		Cliente c3= new Cliente ( d3,"1234", "rafa","Rafael", "Martinez" , "Mi calle nº3", fecha3);	
		
		
		TiendaFacade gc = new TiendaFacade();
		gc.guardarCliente(c1);
		gc.guardarCliente(c2);
		gc.guardarCliente(c3);
		
		System.out.println(gc.imprimirClientes());
		System.out.println("Eliminando cliente 2");
		gc.eliminarCliente(d2);
		System.out.println(gc.imprimirClientes());
		// TODO Auto-generated method stub
			
			
		//CREACION NOVOS CLIENTES

		/*

		System.out.println(gc.imprimirClientes());
		}catch(LetraDniIncorrectaException e) {
			System.out.println(e.getMessage());
		}
		*/
		
			
		
		
		CarritoCollections carrito2= new CarritoCollections(c1);
		
		Libro l1= new Libro (12345,"Libro 1","Terror",4.95,1989,"Autor 1","34567");
		Libro l2= new Libro (5678,"Libro 2","Comedia",9.67,1955,"Autor 2","55567");

		Pelicula p1= new Pelicula (91011,"Pelicula1","Comedia",22.30 ,2017,"Director 1 ","p");
		
		Pelicula p2= new Pelicula (91012,"Pelicula2","Terror",20.50 ,2006,"Director 2 ","k");

	
		carrito2.meterEnCarrito(p2);
		carrito2.meterEnCarrito(p1);
		carrito2.meterEnCarrito(l2);
		carrito2.meterEnCarrito(l1);
		
		
		
		System.out.println(carrito2.toString());
		carrito2.vaciarCarrito();
		

		 
		} catch (CarritoLlenoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}catch (LetraDniIncorrectaException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		/*catch (PosicionFueraCarritoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		catch (ProcutoNoEncontrado ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		}*/
		
		
	
	}
}
