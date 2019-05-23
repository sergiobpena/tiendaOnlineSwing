package org.curso.tienda.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.curso.tienda.modelo.TiendaFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel contenido;
	private static VentanaPrincipal instancia;
	private  TiendaFacade fachada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = VentanaPrincipal.getInstance();

					frame.getFacade().cargarClientes("Fichero.dat");
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("Choponline");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		this.contenido= new ContenidoLogin ();
		
		contentPane.add(this.contenido , BorderLayout.CENTER);
		this.fachada=new TiendaFacade();
	}
	public TiendaFacade getFacade() {
		return this.fachada;
		
	}
	public static VentanaPrincipal getInstance () {
		if (instancia == null) {
			instancia = new VentanaPrincipal();
		}
		return instancia;
	}
	
	public void cambiarContenido (JPanel contenido) {
		contentPane.remove(this.contenido);
		this.contenido=contenido;
		contentPane.add(this.contenido, BorderLayout.CENTER);
		this.validate();
		
	}
	public JPanel getContenido() {
		return this.contenido;
	}
}
