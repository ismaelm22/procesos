package edu.uclm.esi.iso2.multas.funcionario.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.status.StatusLogger;
import org.hibernate.Session;

import edu.uclm.esi.iso2.multas.dao.DriverDao;
import edu.uclm.esi.iso2.multas.dao.HibernateFactory;
import edu.uclm.esi.iso2.multas.domain.Driver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CambiarPropietarioInterface {
	
	static{
		StatusLogger.getLogger().setLevel(Level.OFF);
	}
	public JFrame frmCambiarPropietario;
	private JTextField txtFieldNuevo;
	private JLabel lblActualPropietario;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JTextField txtFieldActual;
	private JLabel lblNuevoPropietario;
	private static String nombreCompleto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarPropietarioInterface window = new CambiarPropietarioInterface(nombreCompleto);
					window.frmCambiarPropietario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CambiarPropietarioInterface(String nombreCompleto) {
		this.nombreCompleto=nombreCompleto;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCambiarPropietario = new JFrame();
		frmCambiarPropietario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCambiarPropietario.setResizable(false);
		frmCambiarPropietario.setTitle("Cambiar Propietario");
		frmCambiarPropietario.setBounds(100, 100, 450, 300);
		frmCambiarPropietario.getContentPane().setLayout(null);
		
		lblActualPropietario = new JLabel("Actual Propietario: ");
		lblActualPropietario.setBounds(32, 47, 142, 15);
		frmCambiarPropietario.getContentPane().add(lblActualPropietario);

		lblNuevoPropietario = new JLabel("Nuevo Propietario:");
		lblNuevoPropietario.setBounds(32, 86, 142, 15);
		frmCambiarPropietario.getContentPane().add(lblNuevoPropietario);
		
		txtFieldActual = new JTextField();
		txtFieldActual.setEditable(false);
		txtFieldActual.setBounds(192, 45, 223, 19);
		frmCambiarPropietario.getContentPane().add(txtFieldActual);
		txtFieldActual.setColumns(10);
		txtFieldActual.setText(nombreCompleto);
		
		txtFieldNuevo = new JTextField();
		txtFieldNuevo.setBounds(192, 84, 223, 19);
		frmCambiarPropietario.getContentPane().add(txtFieldNuevo);
		txtFieldNuevo.setColumns(10);
		txtFieldNuevo.setText(null);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtFieldNuevo.getText()==""){
					JOptionPane.showMessageDialog(null, "Por favor, rellena un nuevo propietario.");
				}else{
					JOptionPane.showMessageDialog(null, "Propietario Cambiado Correctamente!");
					frmCambiarPropietario.dispose();
				}
			}
		});
	
		btnConfirmar.setBounds(45, 157, 146, 44);
		frmCambiarPropietario.getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCambiarPropietario.dispose();
			}
		});
		btnCancelar.setBounds(230, 157, 146, 44);
		frmCambiarPropietario.getContentPane().add(btnCancelar);
	}

}
