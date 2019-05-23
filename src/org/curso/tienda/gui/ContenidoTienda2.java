package org.curso.tienda.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.curso.tienda.modelo.Libro;
import org.curso.tienda.modelo.Producto;

public class ContenidoTienda2 extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ContenidoTienda2() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblContenidoTienda = new JLabel("Contenido Tienda");
		add(lblContenidoTienda, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JButton btnengcarrito = new JButton("\"A\u00F1adir al carrito\"");
		panel.add(btnengcarrito);
		
		JButton btnVerCarrito = new JButton("Ver Carrito");
		panel.add(btnVerCarrito);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JTable tblProductos = new JTable();
		scrollPane.setViewportView(table);
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
		
		List <Producto> listaproductos2 = VentanaPrincipal.getInstance().getFacade().listarproductos();
		
		

	}
//	public Producto getProductoSeleccionado() {
//		return (Producto) this.cmbProductos.getSelectedItem();
//	}

}
