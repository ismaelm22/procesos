package edu.uclm.esi.iso2.multas.funcionario.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaInfractoresInterface {
	private DefaultListModel modelLista = new DefaultListModel();
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	private JList listInfractores;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaInfractoresInterface window = new ListaInfractoresInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListaInfractoresInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 34, 490, 324);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblListaDeInfracciones = new JLabel("Lista de Infracciones");
		lblListaDeInfracciones.setBounds(12, 12, 205, 15);
		frame.getContentPane().add(lblListaDeInfracciones);
		
		final JButton btnSancionar = new JButton("Sancionar");
		btnSancionar.setBounds(12, 370, 240, 38);
		frame.getContentPane().add(btnSancionar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(254, 370, 248, 38);
		frame.getContentPane().add(btnSalir);
		
		scrollPane.setViewportView(listInfractores);
		listInfractores.setModel(modelLista);
		listInfractores.setEnabled(false);
		ImageIcon imagen=new ImageIcon("/presentacion/descarga.png");
		listInfractores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnSancionar.setEnabled(true);
				
			}
		});
	}
}
