package org.curso.tienda.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EescuchadorVerCarrito implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String carrito = VentanaPrincipal.getInstance().getFacade().listarcarrito();
				new DialogoMensajes(carrito);

	}

}
