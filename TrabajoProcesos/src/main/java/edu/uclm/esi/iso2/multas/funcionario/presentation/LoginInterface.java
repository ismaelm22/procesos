package edu.uclm.esi.iso2.multas.funcionario.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.ImageIcon;


public class LoginInterface {

	public static JFrame framePrincipal;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JButton btnLogin;
	private JButton btnExit;
	private JTextField txtFieldUser;
	private JTextField txtFieldPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface window = new LoginInterface();
					window.framePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePrincipal = new JFrame();
		framePrincipal.setResizable(false);
		framePrincipal.setTitle("DGT by ESISolutions");
		framePrincipal.setBounds(100, 100, 450, 300);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(55, 197, 112, 25);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((txtFieldUser.getText().equals("esi"))&&(txtFieldPassword.getText().equals("esi"))){
					//MenuFuncionarioInterface frameMenu=new MenuFuncionarioInterface();
					MenuFuncionarioInterface.main(null);
				}else{
					JOptionPane.showMessageDialog(null,"Error, Usuario/Contraseña Incorrecta :-(");
				}
			}
		});
		framePrincipal.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Bienvenido al programa de seguimiento DGT ");
		lblTitulo.setBounds(76, 6, 318, 15);
		framePrincipal.getContentPane().add(lblTitulo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(55, 103, 55, 15);
		framePrincipal.getContentPane().add(lblUsuario);
		
		txtFieldUser = new JTextField();
		txtFieldUser.setBounds(172, 101, 114, 19);
		framePrincipal.getContentPane().add(txtFieldUser);
		txtFieldUser.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(55, 127, 112, 15);
		framePrincipal.getContentPane().add(lblContrasea);
		
		txtFieldPassword = new JTextField();
		txtFieldPassword.setBounds(172, 125, 114, 19);
		framePrincipal.getContentPane().add(txtFieldPassword);
		txtFieldPassword.setColumns(10);
		framePrincipal.getContentPane().add(btnLogin);
		
		btnExit = new JButton("Salir");
		btnExit.setBounds(239, 197, 66, 25);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				framePrincipal.dispose();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		framePrincipal.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Ayuda");
		lblNewLabel.setBounds(362, 150, 61, 16);
		framePrincipal.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginInterface.class.getResource("/presentacion/Logo-DGT.png")));
		lblNewLabel_1.setBounds(172, 31, 133, 58);
		framePrincipal.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "El usuario es 'esi'\nla contraseña es 'esi'");
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(LoginInterface.class.getResource("/presentacion/Ayuda.png")));
		lblNewLabel_2.setBounds(362, 103, 32, 39);
		framePrincipal.getContentPane().add(lblNewLabel_2);
	}
}
