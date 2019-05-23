package org.curso.tienda.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class DialogoMensajes extends JDialog {

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DialogoMensajes(String mensaje) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblMensaje = new JLabel(mensaje);
				lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
				lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 40));
				panel.add(lblMensaje);
			}
		}
		setVisible(true);
	}


}
