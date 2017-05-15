package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Faktura;
import entiteti.Pacijent;
import entiteti.Uput;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frejmb16IzdavanjeUputa extends JFrame {

	public JPanel contentPane;
	private JTextField txtPrezime;
	private JTextField txtIme;
	private JTextField IzdavaocUputa;
	private JComboBox CmbZaKojuUstanovuSeIzdajeUput;
	private String NazivUstanoveZaKojuSeIzdajeUput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Pacijent pacijent, int pregledID) {
				try {
					Frejmb16IzdavanjeUputa frame = new Frejmb16IzdavanjeUputa(null, null, 0, 0, 0, 0, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
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
	 * @param dodateBolesti 
	 * @param dodateUsluge 
	 * @param iznosFakture  
	 */																							
	public Frejmb16IzdavanjeUputa(Pacijent pacijent, String jmbgLekar, int brojacBolest, int brojacUsluga, int pregledID, int fakturaID, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
		setTitle("Izdavanje uputa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUstanovaKojaIzdaje = new JLabel("Ustanova za koju se izdaje uput");
		lblUstanovaKojaIzdaje.setBounds(10, 209, 206, 14);
		contentPane.add(lblUstanovaKojaIzdaje);
		
		JLabel lblUstanovaKojaIzdaje_1 = new JLabel("Ustanova koja izdaje uput");
		lblUstanovaKojaIzdaje_1.setBounds(10, 142, 206, 14);
		contentPane.add(lblUstanovaKojaIzdaje_1);
		
		txtPrezime = new JTextField();
		txtPrezime.setEditable(false);
		txtPrezime.setBounds(86, 57, 129, 20);
		contentPane.add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JButton btntampajUput = new JButton("Dalje");
		btntampajUput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NazivUstanoveZaKojuSeIzdajeUput=CmbZaKojuUstanovuSeIzdajeUput.getSelectedItem().toString();
				
				dispose();
				Frejmb16StampanjeUputa StampaUputa = new Frejmb16StampanjeUputa(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, NazivUstanoveZaKojuSeIzdajeUput, dodateBolesti, dodateUsluge);
				StampaUputa.setVisible(true);
					
			}
		});
		btntampajUput.setBackground(Color.BLACK);
		btntampajUput.setForeground(Color.WHITE);
		btntampajUput.setBounds(143, 334, 180, 22);
		contentPane.add(btntampajUput);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				Frejm6aPregled Nazad = new Frejm6aPregled(pacijent, jmbgLekar, pregledID, fakturaID, null, dodateBolesti, dodateUsluge);
				Nazad.setVisible(true);
			}
		});
		btnNazad.setBounds(143, 368, 180, 22);
		contentPane.add(btnNazad);
		
		CmbZaKojuUstanovuSeIzdajeUput = new JComboBox(ManipulacijaSaBazom.SpisakZdravstvenihUstanova());
		CmbZaKojuUstanovuSeIzdajeUput.setBounds(10, 234, 313, 20);
		contentPane.add(CmbZaKojuUstanovuSeIzdajeUput);
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setBounds(10, 35, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime");
		lblNewLabel_1.setBounds(10, 60, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		txtIme = new JTextField();
		txtIme.setEditable(false);
		txtIme.setBounds(86, 32, 129, 20);
		contentPane.add(txtIme);
		txtIme.setColumns(10);
		
		IzdavaocUputa = new JTextField();
		IzdavaocUputa.setText("Privatna bolnica \"Sveti Jovan\"");
		IzdavaocUputa.setEditable(false);
		IzdavaocUputa.setBounds(10, 167, 313, 20);
		contentPane.add(IzdavaocUputa);
		IzdavaocUputa.setColumns(10);
		
		final String UstanovaKojaIzdaje;
		
		UstanovaKojaIzdaje=("Privatna bolnica "  + "''Sveti Jovan''");
	
		IzdavaocUputa.setText(UstanovaKojaIzdaje);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Frejmb16IzdavanjeUputa.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 447, 404);
		contentPane.add(lblNewLabel_2);
		
		txtIme.setText(pacijent.getIme());
		txtPrezime.setText(pacijent.getPrezime());
		
	}
}
