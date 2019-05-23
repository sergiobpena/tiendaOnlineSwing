package org.curso.tienda.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuchadorNuevoCliente implements ActionListener {

	
	public void actionPerformed(ActionEvent arg0) {
		
		VentanaPrincipal.getInstance().cambiarContenido(new ContenidoRegistro());
		
	
		
	}
	

}
