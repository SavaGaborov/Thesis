package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Faktura;
import entiteti.Pacijent;
import entiteti.Recept;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Frejm17IzdavanjeRecepta extends JFrame {

	private JPanel contentPane;
	private JTextField textImePacijenta;
	private JTextField textPrezimePacijenta;
	private JTextField IzdavaocRecepta;
	private String UstanovaKojaIzdajeRecept;
	private java.sql.Date DatumIzdavanjaRecepta;
	private JComboBox CmbNazivLeka;
	public String NazivLeka;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm17IzdavanjeRecepta frame = new Frejm17IzdavanjeRecepta(null, null, 0, 0, 0, 0, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param pacijent 
	 * @param jmbgLekar 
	 * @param brojacBolest 
	 * @param brojacUsluga 
	 * @param pregledID 
	 * @param nazivLeka 
	 * @param dodateBolesti 
	 * @param dodateUsluge 
	 * @param iznosFakture 
	 */
	public Frejm17IzdavanjeRecepta(Pacijent pacijent, String jmbgLekar, int brojacBolest, int brojacUsluga, int pregledID, int fakturaID, String nazivLeka, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
		setTitle("Izdavanje recepta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNazivUstanoveKoja = new JLabel("Izdavaoc recepta");
		lblNazivUstanoveKoja.setForeground(Color.BLACK);
		lblNazivUstanoveKoja.setBounds(31, 150, 98, 14);
		contentPane.add(lblNazivUstanoveKoja);
		
		JLabel lblNazivLeka = new JLabel("Naziv leka");
		lblNazivLeka.setForeground(Color.BLACK);
		lblNazivLeka.setBounds(31, 200, 86, 14);
		contentPane.add(lblNazivLeka);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				Frejm6aPregled Nazad = new Frejm6aPregled(pacijent, jmbgLekar, pregledID, fakturaID, null, dodateBolesti, dodateUsluge);
				Nazad.setVisible(true);
			}
		});
		btnNewButton.setBounds(124, 312, 171, 20);
		contentPane.add(btnNewButton);
		
		JButton btntampajRecept = new JButton("Dalje");
		btntampajRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NazivLeka=CmbNazivLeka.getSelectedItem().toString();
				
				dispose();
				Frejm17StampanjeRecepta StampajRecept = new Frejm17StampanjeRecepta(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, NazivLeka, dodateBolesti, dodateUsluge);
				StampajRecept.setVisible(true);
				
			}
		});
		btntampajRecept.setBackground(Color.BLACK);
		btntampajRecept.setForeground(Color.WHITE);
		btntampajRecept.setBounds(124, 281, 171, 20);
		contentPane.add(btntampajRecept);
		
		CmbNazivLeka = new JComboBox(ManipulacijaSaBazom.SpisakNazivaLekova());
		CmbNazivLeka.setBounds(153, 197, 218, 20);
		contentPane.add(CmbNazivLeka);
		
		JLabel lblImePacijenta = new JLabel("Ime");
		lblImePacijenta.setForeground(Color.BLACK);
		lblImePacijenta.setBounds(31, 21, 98, 14);
		contentPane.add(lblImePacijenta);
		
		textImePacijenta = new JTextField();
		textImePacijenta.setEditable(false);
		textImePacijenta.setBounds(31, 35, 107, 20);
		contentPane.add(textImePacijenta);
		textImePacijenta.setColumns(10);
		
		JLabel lblPrezimePacijenta = new JLabel("Prezime");
		lblPrezimePacijenta.setForeground(Color.BLACK);
		lblPrezimePacijenta.setBounds(31, 66, 107, 14);
		contentPane.add(lblPrezimePacijenta);
		
		textPrezimePacijenta = new JTextField();
		textPrezimePacijenta.setEditable(false);
		textPrezimePacijenta.setBounds(31, 79, 107, 20);
		contentPane.add(textPrezimePacijenta);
		textPrezimePacijenta.setColumns(10);
		
		IzdavaocRecepta = new JTextField();
		IzdavaocRecepta.setText("Privatna bolnica \"Sveti Jovan\"");
		IzdavaocRecepta.setEditable(false);
		IzdavaocRecepta.setBounds(153, 147, 218, 20);
		contentPane.add(IzdavaocRecepta);
		IzdavaocRecepta.setColumns(10);
		
		
		String UstanovaKojaIzdaje=("Privatna bolnica "  + "''Sveti Jovan''");
	
		IzdavaocRecepta.setText(UstanovaKojaIzdaje);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Frejm17IzdavanjeRecepta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 399, 343);
		contentPane.add(lblNewLabel);
		
		textImePacijenta.setText(pacijent.getIme());
		textPrezimePacijenta.setText(pacijent.getPrezime());
		UstanovaKojaIzdajeRecept=IzdavaocRecepta.getText();
		
		
		   
	}

	
}
