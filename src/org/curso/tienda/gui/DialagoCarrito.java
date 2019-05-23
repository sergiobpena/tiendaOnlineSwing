package org.curso.tienda.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class DialagoCarrito  extends JDialog {
	
	
	public DialagoCarrito (String mensaje) {
		
		setBounds(100,100,600,300);
		
		JTextArea lblMensaje=new JTextArea("");
		
		lblMensaje.setFont(new Font("Bookmark Old Style", Font.BOLD,14));
		lblMensaje.setText(mensaje);
		
		JScrollPane contentPanel = new JScrollPane(lblMensaje);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}
	

}
