package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Lekar;
import metode.ManipulacijaSaBazom;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JPasswordField;

public class Frejm1Logovanje extends JFrame {

	public static Frejm1Logovanje frameLogovanje;
	public JPanel contentPane;
	private JTextField textField_KorisnickoIme;
	private JPasswordField passfieldSifra;
	public Frejm2GlavniMeni GlavniMeni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameLogovanje = new Frejm1Logovanje();
					frameLogovanje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frejm1Logovanje() {
		setTitle("Dobro do\u0161li");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManipulacijaSaBazom mnbp= new ManipulacijaSaBazom();
				
				String KorisnickoIme=textField_KorisnickoIme.getText();
				int Sifra= Integer.parseInt(passfieldSifra.getText());
				
				
				Lekar lekar = new Lekar();
				
				lekar.setKorisnicnoIme(KorisnickoIme);
				lekar.setSifra(Sifra);
				
				boolean Ulogovan=mnbp.Logovanje(lekar);
				
				if (Ulogovan){
					
					String JmbgLekar=ManipulacijaSaBazom.SelektovanjeJmbgLekara(KorisnickoIme,Sifra);
					
					dispose();
					GlavniMeni = new Frejm2GlavniMeni(JmbgLekar);
					GlavniMeni.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Pogre�no korisnicko ime ili �ifra molimo Vas ponovo unesite podatke", "Gre�ka", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Frejm1Logovanje.class.getResource("/frejmovi/Login.png")));
		btnNewButton.setBounds(179, 121, 80, 26);
		contentPane.add(btnNewButton);
		
		textField_KorisnickoIme = new JTextField();
		textField_KorisnickoIme.setBounds(33, 71, 86, 20);
		contentPane.add(textField_KorisnickoIme);
		textField_KorisnickoIme.setColumns(10);
		
		JLabel label = new JLabel("Korisni\u010Dko ime");
		label.setBounds(33, 46, 86, 14);
		contentPane.add(label);
		label.setForeground(Color.WHITE);
		
		JLabel label_1 = new JLabel("\u0160ifra");
		label_1.setBounds(33, 102, 86, 14);
		contentPane.add(label_1);
		label_1.setForeground(Color.WHITE);
		
		passfieldSifra = new JPasswordField();
		passfieldSifra.setBounds(33, 127, 86, 20);
		contentPane.add(passfieldSifra);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Frejm1Logovanje.class.getResource("/frejmovi/Background1.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
	}
}
