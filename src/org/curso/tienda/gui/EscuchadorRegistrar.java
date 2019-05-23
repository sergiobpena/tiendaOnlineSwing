package org.curso.tienda.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import org.curso.tienda.modelo.Cliente;
import org.curso.tienda.modelo.Dni;
import org.curso.tienda.modelo.exception.LetraDniIncorrectaException;

public class EscuchadorRegistrar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ContenidoRegistro contenido = (ContenidoRegistro) VentanaPrincipal.getInstance().getContenido();
		String clave1 = new String (contenido.getTxtClave1().getPassword());
		String clave2 = new String (contenido.getTxtClave2().getPassword()) ;//teño que pasar o cadro da contraseña....
		
		if(clave1.equals(clave2)){
			String login = contenido.getTxtLogin().getText();

			String nombre = contenido.getTxtNombre().getText();
			String apellidos= contenido.getTxtApellidos().getText();
			String direccion = contenido.getTxtDireccion().getText();
			int numeroDni= Integer.parseInt(contenido.getTxtDniNumero().getText());
			char letraDNi=contenido.getTxtLetra().getText().charAt(0);
			int dia= Integer.parseInt(contenido.getTxtFechNacDia().getText());
			int mes = Integer.parseInt(contenido.getTxtFechNacMes().getText());
			int ano= Integer.parseInt(contenido.getTxtFechaNacAnho().getText());
			

			
			
			try {
				
				Dni d = new Dni (numeroDni, letraDNi);
				Calendar fecha = Calendar.getInstance();
				fecha.set(dia, mes,ano);
				Cliente c = new Cliente (d,login,clave1,nombre,apellidos,direccion, fecha);	
				VentanaPrincipal.getInstance().getFacade().guardarCliente(c);
				VentanaPrincipal.getInstance().getFacade().guardarClientes("Fichero.dat");
				new DialogoMensajes("Cliente" + login + "rexistrado");
				VentanaPrincipal.getInstance().cambiarContenido(new ContenidoLogin());
				
				
			} catch (LetraDniIncorrectaException ex) {
				new DialogoMensajes("La letra del DNI no es correcta");
				
			} 
		}else {
				new DialogoMensajes("Las contraseñas introducidas no coinciden ");
			}
		
		
		
	}
	

}
