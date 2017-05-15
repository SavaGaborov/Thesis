package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Pacijent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frejm15IzdavanjeFakture extends JFrame {

	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtAdresa;
	private JTextField txtPrivatnaBolnica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm15IzdavanjeFakture frame = new Frejm15IzdavanjeFakture(null, null, 0, 0, 0, 0, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param fakturaID 
	 * @param pregledID 
	 * @param brojacBolest 
	 * @param brojacUsluga 
	 * @param jmbgLekar 
	 * @param pacijent 
	 * @param dodateUsluge 
	 * @param dodateBolesti 
	 
	 */
	public Frejm15IzdavanjeFakture(Pacijent pacijent, String jmbgLekar, int brojacUsluga, int brojacBolest, int pregledID, int fakturaID, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
		setTitle("Izdavanje fakture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIme = new JTextField();
		txtIme.setEditable(false);
		txtIme.setBounds(84, 25, 112, 20);
		contentPane.add(txtIme);
		txtIme.setColumns(10);
		
		txtPrezime = new JTextField();
		txtPrezime.setEditable(false);
		txtPrezime.setBounds(84, 65, 112, 20);
		contentPane.add(txtPrezime);
		txtPrezime.setColumns(10);
		
		txtJmbg = new JTextField();
		txtJmbg.setEditable(false);
		txtJmbg.setBounds(84, 105, 112, 20);
		contentPane.add(txtJmbg);
		txtJmbg.setColumns(10);
		
		txtAdresa = new JTextField();
		txtAdresa.setEditable(false);
		txtAdresa.setBounds(84, 145, 149, 20);
		contentPane.add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(28, 25, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(28, 65, 59, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("Jmbg");
		lblJmbg.setBounds(28, 108, 46, 14);
		contentPane.add(lblJmbg);
		
		JLabel lblNewLabel = new JLabel("Adresa");
		lblNewLabel.setBounds(28, 148, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ustanova koja izdaje fakturu");
		lblNewLabel_1.setBounds(28, 215, 216, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPrivatnaBolnica = new JTextField();
		txtPrivatnaBolnica.setEditable(false);
		txtPrivatnaBolnica.setText("Privatna bolnica \"Sveti Jovan\" ");
		txtPrivatnaBolnica.setBounds(28, 240, 216, 20);
		contentPane.add(txtPrivatnaBolnica);
		txtPrivatnaBolnica.setColumns(10);
		
		JButton btnNewButton = new JButton("Dalje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejmb15StampanjeFakture nazad = new Frejmb15StampanjeFakture(pacijent, jmbgLekar, 0, 0, pregledID, fakturaID, dodateBolesti, dodateUsluge);
				nazad.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(335, 319, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
				Frejm6aPregled nazad = new Frejm6aPregled(pacijent, jmbgLekar, pregledID, fakturaID, null, dodateBolesti, dodateUsluge);
				nazad.setVisible(true);
			}
		});
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBounds(23, 319, 89, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Frejm15IzdavanjeFakture.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 448, 367);
		contentPane.add(lblNewLabel_2);
		
		txtIme.setText(pacijent.getIme());
		txtPrezime.setText(pacijent.getPrezime());
		txtAdresa.setText(pacijent.getUlicaiBroj());
		txtJmbg.setText(pacijent.getJmbgPacijent());
	}
}
