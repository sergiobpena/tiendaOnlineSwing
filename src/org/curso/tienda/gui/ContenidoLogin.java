package org.curso.tienda.gui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class ContenidoLogin extends JPanel {
	
	private JTextField txtLogin;
	private JPasswordField txtClave;
	
	

	public JTextField getTxtLogin() {
		return txtLogin;
	}



	public JTextField getTxtClave() {
		return txtClave;
	}



	/**
	 * Create the panel.
	 */
	public ContenidoLogin() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(61, 76, 50, 14);
		add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(158, 73, 227, 20);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClave.setBounds(61, 127, 61, 14);
		add(lblClave);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(158, 124, 227, 20);
		add(txtClave);
		txtClave.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(272, 221, 113, 23);
		btnLogin.addActionListener(new EscuchadorLogin());
		add(btnLogin);
		
		JButton btnNewClient = new JButton("Nuevo Cliente");
		btnNewClient.setBounds(61, 221, 113, 23);
		btnNewClient.addActionListener(new EscuchadorNuevoCliente());
		add(btnNewClient);

	}
	public String getLogin() {
		return this.txtLogin.getText();
				
	}
	public String getClave (){
		return new String(this.txtClave.getPassword());
	}
}
