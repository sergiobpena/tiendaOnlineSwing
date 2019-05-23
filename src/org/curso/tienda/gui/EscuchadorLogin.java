package org.curso.tienda.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuchadorLogin implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		ContenidoLogin contenido = (ContenidoLogin) VentanaPrincipal.getInstance().getContenido();
		boolean encontrado = VentanaPrincipal.getInstance().getFacade().login(contenido.getLogin(), contenido.getClave());
		if (encontrado) {
			VentanaPrincipal.getInstance().cambiarContenido(new ContenidoTienda());
		}else {
			new DialogoMensajes("Login ou clave incorrectos");
		}
		
		
	}
	

}
