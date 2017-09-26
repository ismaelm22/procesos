package edu.uclm.esi.iso2.multas.funcionario.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SancionarInterface {

	public JFrame frmSancionarConductor;
	private JTextField txtFieldConductor;
	private JTextField txtFieldVehiculo;
	private JTextField txtFieldVelocidad;
	private JTextField txtFieldImporte;
	private JTextField txtFieldPuntos;
	private JTextField txtFieldLocalizacion;
	private JTextField txtFieldVMax;
	private String nombreSancionado;
	private String vehiculo;
	private String localizacion;
	private double velocidad;
	private double velocidadMax;
	private double importe;
	private int puntos;
	private JButton btnSancionar;

	/**
	 * Create the application.
	 */
	public SancionarInterface(String nombreSancionado, String vehiculo, String localizacion, double velocidad,
			double velocidadMax, double importe, int puntos) {
		this.nombreSancionado = nombreSancionado;
		this.vehiculo = vehiculo;
		this.localizacion = localizacion;
		this.velocidad = velocidad;
		this.velocidadMax = velocidadMax;
		this.importe = importe;
		this.puntos = puntos;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSancionarConductor = new JFrame();
		frmSancionarConductor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSancionarConductor.setResizable(false);
		frmSancionarConductor.setTitle("Sancionar Conductor");
		frmSancionarConductor.setBounds(100, 100, 450, 390);
		frmSancionarConductor.getContentPane().setLayout(null);

		JLabel lblConductor = new JLabel("Conductor");
		lblConductor.setBounds(28, 44, 83, 15);
		frmSancionarConductor.getContentPane().add(lblConductor);

		txtFieldConductor = new JTextField();
		txtFieldConductor.setEditable(false);
		txtFieldConductor.setBounds(129, 44, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldConductor);
		txtFieldConductor.setColumns(10);
		txtFieldConductor.setText(nombreSancionado);
		JLabel lblVehculo = new JLabel("Vehículo");
		lblVehculo.setBounds(28, 75, 70, 15);
		frmSancionarConductor.getContentPane().add(lblVehculo);

		txtFieldVehiculo = new JTextField();
		txtFieldVehiculo.setEditable(false);
		txtFieldVehiculo.setBounds(129, 75, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldVehiculo);
		txtFieldVehiculo.setColumns(10);
		txtFieldVehiculo.setText(vehiculo);

		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setBounds(28, 134, 70, 15);
		frmSancionarConductor.getContentPane().add(lblVelocidad);

		txtFieldVelocidad = new JTextField();
		txtFieldVelocidad.setEditable(false);
		txtFieldVelocidad.setBounds(129, 134, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldVelocidad);
		txtFieldVelocidad.setColumns(10);
		txtFieldVelocidad.setText(String.valueOf(velocidad));
		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setBounds(28, 192, 70, 15);
		frmSancionarConductor.getContentPane().add(lblImporte);

		txtFieldImporte = new JTextField();
		txtFieldImporte.setEditable(false);
		txtFieldImporte.setBounds(129, 192, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldImporte);
		txtFieldImporte.setColumns(10);
		txtFieldImporte.setText(String.valueOf(importe));

		JLabel lblPuntosARetirar = new JLabel("Puntos");
		lblPuntosARetirar.setBounds(28, 223, 70, 15);
		frmSancionarConductor.getContentPane().add(lblPuntosARetirar);

		txtFieldPuntos = new JTextField();
		txtFieldPuntos.setEditable(false);
		txtFieldPuntos.setBounds(129, 223, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldPuntos);
		txtFieldPuntos.setColumns(10);
		txtFieldPuntos.setText(String.valueOf(puntos));

		btnSancionar = new JButton("Sancionar");
		btnSancionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Conductor Sancionado!");
				frmSancionarConductor.dispose();
			}
		});
		btnSancionar.setBounds(28, 259, 117, 25);
		frmSancionarConductor.getContentPane().add(btnSancionar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSancionarConductor.dispose();
			}
		});
		btnCancelar.setBounds(187, 259, 117, 25);
		frmSancionarConductor.getContentPane().add(btnCancelar);

		JLabel lblLocalizacion = new JLabel("Localización");
		lblLocalizacion.setBounds(28, 104, 83, 15);
		frmSancionarConductor.getContentPane().add(lblLocalizacion);

		txtFieldLocalizacion = new JTextField();
		txtFieldLocalizacion.setText(localizacion);
		txtFieldLocalizacion.setEditable(false);
		txtFieldLocalizacion.setColumns(10);
		txtFieldLocalizacion.setBounds(129, 104, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldLocalizacion);

		JLabel lblVMxima = new JLabel("V. máxima");
		lblVMxima.setBounds(28, 163, 83, 15);
		frmSancionarConductor.getContentPane().add(lblVMxima);

		txtFieldVMax = new JTextField();
		txtFieldVMax.setText(String.valueOf(velocidadMax));
		txtFieldVMax.setEditable(false);
		txtFieldVMax.setColumns(10);
		txtFieldVMax.setBounds(129, 163, 221, 19);
		frmSancionarConductor.getContentPane().add(txtFieldVMax);
	}
}
