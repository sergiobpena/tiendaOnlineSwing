package org.curso.tienda.gui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ContenidoRegistro extends JPanel {
	private JTextField txtLogin;
	private JPasswordField txtClave1;
	private JPasswordField txtClave2;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDniNumero;
	private JTextField txtLetra;
	private JTextField txtDireccion;
	private JTextField txtFechNacDia;
	private JTextField txtFechNacMes;
	private JTextField txtFechaNacAnho;
	private JButton btnRegistrar;
	
	
	

	public JPasswordField getTxtClave1() {
		return txtClave1;
	}




	public void setTxtClave1(JPasswordField txtClave1) {
		this.txtClave1 = txtClave1;
	}




	public JTextField getTxtLogin() {
		return txtLogin;
	}




	public JPasswordField getTxtClave2() {
		return txtClave2;
	}




	public JTextField getTxtNombre() {
		return txtNombre;
	}




	public JTextField getTxtApellidos() {
		return txtApellidos;
	}




	public JTextField getTxtDniNumero() {
		return txtDniNumero;
	}




	public JTextField getTxtLetra() {
		return txtLetra;
	}




	public JTextField getTxtDireccion() {
		return txtDireccion;
	}




	public JTextField getTxtFechNacDia() {
		return txtFechNacDia;
	}




	public JTextField getTxtFechNacMes() {
		return txtFechNacMes;
	}




	public JTextField getTxtFechaNacAnho() {
		return txtFechaNacAnho;
	}




	/**
	 * Create the panel.
	 */
	public ContenidoRegistro() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(48, 25, 46, 14);
		add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(148, 22, 220, 20);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		txtClave1 = new JPasswordField();
		txtClave1.setColumns(10);
		txtClave1.setBounds(148, 50, 220, 20);
		add(txtClave1);
		
		JLabel lblClave1 = new JLabel("Clave");
		lblClave1.setBounds(48, 53, 46, 14);
		add(lblClave1);
		
		JLabel lblRepetirClave = new JLabel("Repetir Clave");
		lblRepetirClave.setBounds(48, 84, 90, 14);
		add(lblRepetirClave);
		
		txtClave2 = new JPasswordField();
		txtClave2.setColumns(10);
		txtClave2.setBounds(148, 81, 220, 20);
		add(txtClave2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(148, 112, 220, 20);
		add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(48, 115, 90, 14);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(48, 146, 90, 14);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(148, 143, 220, 20);
		add(txtApellidos);
		
		txtDniNumero = new JTextField();
		txtDniNumero.setColumns(10);
		txtDniNumero.setBounds(148, 171, 180, 20);
		add(txtDniNumero);
		
		JLabel lblDni = new JLabel(" Dni");
		lblDni.setBounds(48, 174, 90, 14);
		add(lblDni);
		
		txtLetra = new JTextField();
		txtLetra.setColumns(10);
		txtLetra.setBounds(338, 171, 30, 20);
		add(txtLetra);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(148, 202, 220, 20);
		add(txtDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(48, 205, 90, 14);
		add(lblDireccion);
		
		JLabel lblFechaNac = new JLabel("Fecha Nacimiento");
		lblFechaNac.setBounds(48, 236, 90, 14);
		add(lblFechaNac);
		
		txtFechNacDia = new JTextField();
		txtFechNacDia.setColumns(10);
		txtFechNacDia.setBounds(148, 233, 50, 20);
		add(txtFechNacDia);
		
		txtFechNacMes = new JTextField();
		txtFechNacMes.setColumns(10);
		txtFechNacMes.setBounds(224, 233, 50, 20);
		add(txtFechNacMes);
		
		txtFechaNacAnho = new JTextField();
		txtFechaNacAnho.setColumns(10);
		txtFechaNacAnho.setBounds(298, 233, 70, 20);
		add(txtFechaNacAnho);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(206, 264, 89, 23);
		btnRegistrar.addActionListener(new EscuchadorRegistrar());
		add(btnRegistrar);

	}

}
