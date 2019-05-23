package org.curso.tienda.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuchadorAnadirCarrito implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		ContenidoTienda contenido = (ContenidoTienda)VentanaPrincipal.getInstance().getContenido();
		VentanaPrincipal.getInstance().getFacade().meterEnCarrito(contenido.getProductoSeleccionado());
		
		
		

	}

}
