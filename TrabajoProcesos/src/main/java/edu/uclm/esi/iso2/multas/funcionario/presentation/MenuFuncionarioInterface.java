package edu.uclm.esi.iso2.multas.funcionario.presentation;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.uclm.esi.iso2.multas.domain.Inquiry;
import edu.uclm.esi.iso2.multas.domain.Sanction;
import edu.uclm.esi.iso2.multas.radar.*;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;

public class MenuFuncionarioInterface {
	private Carretera carretera;
	private JFrame frameMenu;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnEncenderRadar;
	private JButton btnApagarRadar;
	private JButton btnCambioPropietario;
	private JButton btnListaInfractores;
	private JButton btnPagoSan;
	private JList listInfractores;
	private JRadioButton rdbtnUrbano;
	private JRadioButton rdbtnCarretera;
	private JRadioButton rdbtnAutovia;
	private ArrayList<Inquiry> infracciones = new ArrayList<Inquiry>();
	private DefaultListModel modelLista = new DefaultListModel();
	private Radar radar;
	private Sanction san=new Sanction();
	/**
	 * Launch the application.
	 */
	
	static final Logger logger = LogManager.getLogger(MenuFuncionarioInterface.class.getName());
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFuncionarioInterface window = new MenuFuncionarioInterface();
					window.frameMenu.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public boolean doIt() {
	    logger.entry();
	    logger.error("Did it again!");
	    return logger.exit(false);
	  }
	public MenuFuncionarioInterface() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameMenu = new JFrame();
		frameMenu.setResizable(false);
		frameMenu.setTitle("Menú Principal DGT");
		frameMenu.setBounds(100, 100, 585, 440);
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.getContentPane().setLayout(null);

		btnEncenderRadar = new JButton("Encender Radar");
		btnEncenderRadar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				btnApagarRadar.setEnabled(true);
				listInfractores.setEnabled(true);
				modelLista.removeAllElements();
				btnEncenderRadar.setEnabled(false);
				rdbtnUrbano.setEnabled(false);
				rdbtnCarretera.setEnabled(false);
				rdbtnAutovia.setEnabled(false);
				Radar radar = new Radar(carretera);
				radar.encenderRadar();
				infracciones = radar.generarInfracciones();
				for (int i = 0; i < infracciones.size(); i++) {
					modelLista.addElement("Matricula: " + infracciones.get(i).getLicense() + " DNI:"
							+ infracciones.get(i).getOwner().getDni()+" Nombre: "
							+ infracciones.get(i).getOwner().getName() + " "
							+ infracciones.get(i).getOwner().getLastName());

				}

			}
		});
		btnEncenderRadar.setEnabled(false);
		btnEncenderRadar.setBounds(27, 23, 162, 89);
		frameMenu.getContentPane().add(btnEncenderRadar);

		rdbtnUrbano = new JRadioButton("Urbano");
		rdbtnUrbano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEncenderRadar.setEnabled(true);
				carretera = carretera.URBANA;
			}
		});
		buttonGroup.add(rdbtnUrbano);
		rdbtnUrbano.setBounds(222, 23, 149, 23);
		frameMenu.getContentPane().add(rdbtnUrbano);

		rdbtnCarretera = new JRadioButton("Carretera Nacional");
		rdbtnCarretera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEncenderRadar.setEnabled(true);
				carretera = carretera.NACIONAL;
			}
		});
		buttonGroup.add(rdbtnCarretera);
		rdbtnCarretera.setBounds(222, 56, 168, 23);
		frameMenu.getContentPane().add(rdbtnCarretera);

		rdbtnAutovia = new JRadioButton("Autovía");
		rdbtnAutovia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEncenderRadar.setEnabled(true);
				carretera = carretera.AUTOVIA;
			}
		});
		buttonGroup.add(rdbtnAutovia);
		rdbtnAutovia.setBounds(222, 89, 149, 23);
		frameMenu.getContentPane().add(rdbtnAutovia);

		btnApagarRadar = new JButton("Apagar Radar");
		btnApagarRadar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCambioPropietario.setEnabled(false);
				btnPagoSan.setEnabled(false);
				btnListaInfractores.setEnabled(false);
				btnEncenderRadar.setEnabled(true);
				btnApagarRadar.setEnabled(false);
				rdbtnUrbano.setEnabled(true);
				rdbtnCarretera.setEnabled(true);
				rdbtnAutovia.setEnabled(true);

			}
		});
		btnApagarRadar.setEnabled(false);
		btnApagarRadar.setBounds(409, 23, 162, 89);
		frameMenu.getContentPane().add(btnApagarRadar);

		JLabel lblNewLabel = new JLabel("Expedientes de Infractores");
		lblNewLabel.setBounds(27, 126, 268, 15);
		frameMenu.getContentPane().add(lblNewLabel);

		btnCambioPropietario = new JButton("Cambiar\nPropietario\n");
		btnCambioPropietario.setEnabled(false);
		btnCambioPropietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listInfractores.getSelectedIndex();
				String cambioPropietario = infracciones.get(index).getOwner().getName() + " "
						+ infracciones.get(index).getOwner().getLastName();
				System.out.println(cambioPropietario);
				CambiarPropietarioInterface ventanaCambio = new CambiarPropietarioInterface(cambioPropietario);
				ventanaCambio.frmCambiarPropietario.setVisible(true);

			}
		});
		btnCambioPropietario.setBounds(393, 309, 178, 90);
		frameMenu.getContentPane().add(btnCambioPropietario);

		btnListaInfractores = new JButton("Listar\n Infractores\n");
		btnListaInfractores.setEnabled(false);
		btnListaInfractores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaInfractoresInterface lii=new ListaInfractoresInterface();
				lii.frame.setVisible(true);
				int index = listInfractores.getSelectedIndex();
				/*Sanction sancion = infracciones.get(index).createSanctionFor(infracciones.get(index).getOwner().getDni());
				String nombreSancionado = infracciones.get(index).getOwner().getName() + " "
						+ infracciones.get(index).getOwner().getLastName();
				String vehiculo = infracciones.get(index).getLicense();
				String localizacion = infracciones.get(index).getLocation();
				double velocidad = infracciones.get(index).getSpeed();
				double velocidadMax = infracciones.get(index).getMaxSpeed();
				double importe = sancion.getAmount();
				int puntos = sancion.getPoints();

				SancionarInterface ventanaCambio = new SancionarInterface(nombreSancionado, vehiculo, localizacion, velocidad, velocidadMax, importe, puntos);
				ventanaCambio.frmSancionarConductor.setVisible(true);*/
				btnPagoSan.setEnabled(true);
			}
		});
		btnListaInfractores.setBounds(22, 309, 178, 90);
		frameMenu.getContentPane().add(btnListaInfractores);

		btnPagoSan = new JButton("Pago Sanción");
		btnPagoSan.setEnabled(false);
		btnPagoSan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(san.isEstaPagada()==false){
				JOptionPane.showMessageDialog(null, "Sanción Pagada!");
				}else{
					JOptionPane.showMessageDialog(null, "Esta Sancion Ya Está Pagada Anteriormente!");
				}
			}
		});
		btnPagoSan.setBounds(207, 309, 180, 90);
		frameMenu.getContentPane().add(btnPagoSan);

		JLabel lblCaracteristicasMenu = new JLabel("Control de Mando Funcionario DGT");
		lblCaracteristicasMenu.setBounds(159, 291, 263, 15);
		frameMenu.getContentPane().add(lblCaracteristicasMenu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 153, 549, 130);
		frameMenu.getContentPane().add(scrollPane);
								
		listInfractores = new JList();
		scrollPane.setViewportView(listInfractores);
		listInfractores.setModel(modelLista);
		listInfractores.setEnabled(false);
		ImageIcon imagen=new ImageIcon("/presentacion/descarga.png");
		listInfractores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnPagoSan.setEnabled(false);
				btnListaInfractores.setEnabled(true);
				btnCambioPropietario.setEnabled(true);
			}
		});
	}

	
}
