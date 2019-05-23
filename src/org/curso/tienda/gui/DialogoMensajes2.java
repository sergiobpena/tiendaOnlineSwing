package org.curso.tienda.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class DialogoMensajes2 extends JDialog {

	/**
	 * Launch the application.
	 */
	private final JScrollPane contentPanel = new JScrollPane();

	/**
	 * Create the dialog.
	 */
	/*
	 * public DialogoMensajes2(String mensaje, boolean error) { setBounds(100, 100,
	 * 450, 300); JTextArea lblMensaje = new JTextArea();
	 * 
	 * if(error){ lblMensaje.setForeground(Color.RED); } lblMensaje.setFont(new
	 * Font("Tahoma", Font.BOLD, 40)); lblMensaje.setText(mensaje);
	 * 
	 * 
	 * JScrollPane contentPanel= new JScrollPane(lblMensaje);
	 * getContentPane().setLayout(new BorderLayout()); contentPanel.setBorder(new
	 * EmptyBorder(5, 5, 5, 5));
	 * getContentPane().add(contentPanel,BorderLayout.CENTER);
	 * 
	 * /*{ JTextArea lblMensaje = new JTextArea(); JPanel buttonPane = new JPanel();
	 * buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	 * getContentPane().add(buttonPane, BorderLayout.SOUTH); { JButton okButton =
	 * new JButton("OK"); okButton.setActionCommand("OK"); buttonPane.add(okButton);
	 * getRootPane().setDefaultButton(okButton); } { JButton cancelButton = new
	 * JButton("Cancel"); cancelButton.setActionCommand("Cancel");
	 * buttonPane.add(cancelButton); } }
	 */

	{
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		{
			JLabel lblMensaje = new JLabel("New label");
			lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
			lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 40));
			panel.add(lblMensaje);
		}
		setVisible(true);
	}

}
