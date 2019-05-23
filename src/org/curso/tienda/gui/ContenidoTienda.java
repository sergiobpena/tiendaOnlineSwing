package org.curso.tienda.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.curso.tienda.modelo.Producto;
import org.curso.tienda.modelo.Libro;
import javax.swing.JScrollPane;

public class ContenidoTienda extends JPanel {
	
	
	
	private JTable tblProductos;
	private JComboBox<Object> cmbProductos;

	/**
	 * Create the panel.
	 */
	public ContenidoTienda() {
		
		setLayout(new BorderLayout(0, 0));
		
		tblProductos = new JTable();
		
		List <Producto> listaproductos = VentanaPrincipal.getInstance().getFacade().listarproductos();
		String[] rotulosColumnas = { "ID","TIPO","Tiulo","Genero","Año","Precio"};
		String[] [] datos = new String [listaproductos.size()][6];		
		
		for (int i = 0 ; i<listaproductos.size();i++) {
			Producto p = listaproductos.get(i);
			datos[i][0]=Integer.toString(p.getidProducto());
			datos[i][1]= p instanceof Libro ? "Libro" : "Pelicula";
			datos[i][2]=p.getTitulo();
			datos[i][3]=p.getGenero();
			datos[i][4]=Integer.toString(p.getAnho());
			datos[i][5]=Double.toString(p.getPrecio());
			}
		
		TableModel modelo = new DefaultTableModel(datos,rotulosColumnas);
		tblProductos.setModel(modelo);
		//combobox ten que ser atributo
		
		tblProductos.setEnabled(true);

		JScrollPane contentPane = new JScrollPane(tblProductos);
		add(contentPane, BorderLayout.CENTER);
		
		
		JPanel panelCarrito= new JPanel();
		this.cmbProductos = new JComboBox<>(listaproductos.toArray());
		
		
		panelCarrito.add(cmbProductos);
		JButton btnañ= new JButton("Añadir o carrito");
		panelCarrito.add(btnañ);
		
		
		
		


	


		}
	
	//metodo a encasquetar para escoitador
	public Producto getProductoSeleccionado() {
		return (Producto) this.cmbProductos.getSelectedItem();
	}
		
	}

