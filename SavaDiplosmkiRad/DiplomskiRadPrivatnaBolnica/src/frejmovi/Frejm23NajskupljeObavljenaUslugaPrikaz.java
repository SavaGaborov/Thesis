package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Frejm23NajskupljeObavljenaUslugaPrikaz extends JFrame {

	private JPanel contentPane;
	private JTable TabelaRezultata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm23NajskupljeObavljenaUslugaPrikaz frame = new Frejm23NajskupljeObavljenaUslugaPrikaz(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param spisakNajskupljeObavljenihUsluga 
	 * @param jmbgLekar 
	 */
	public Frejm23NajskupljeObavljenaUslugaPrikaz(String jmbgLekar, DefaultTableModel spisakNajskupljeObavljenihUsluga) {
		setTitle("Prikaz izve\u0161taja najskuplje obaveljene usluge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetNajskupljeIzvrenih = new JLabel("Deset najskuplje izvr\u0161enih usluga za zadati interval je:");
		lblPetNajskupljeIzvrenih.setBounds(37, 23, 387, 14);
		contentPane.add(lblPetNajskupljeIzvrenih);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm23NajskupljeObavljenaUsluga ProsecanIznosFakture = new Frejm23NajskupljeObavljenaUsluga(jmbgLekar);
				ProsecanIznosFakture.setVisible(true);
			}
		});
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBounds(399, 267, 89, 23);
		contentPane.add(btnNazad);
		
		TabelaRezultata = new JTable();
		TabelaRezultata.setBounds(37, 86, 451, 158);
		contentPane.add(TabelaRezultata);
		
		TabelaRezultata.setModel(spisakNajskupljeObavljenihUsluga);
		
		JLabel lblNay = new JLabel("Naziv usluge");
		lblNay.setBounds(37, 61, 134, 14);
		contentPane.add(lblNay);
		
		JLabel lblCenaUslugeU = new JLabel("Cena usluga u dinarima");
		lblCenaUslugeU.setBounds(262, 61, 159, 14);
		contentPane.add(lblCenaUslugeU);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm23NajskupljeObavljenaUslugaPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, -2, 528, 317);
		contentPane.add(lblNewLabel);
	}
}
