package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXB;
import javax.xml.bind.ParseConversionEvent;

import entiteti.Faktura;
import entiteti.Pacijent;
import entiteti.Pregled;
import metode.ManipulacijaSaBazom;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frejm6PregledOdabirPacijenta extends JFrame {

	public Frejm6PregledOdabirPacijenta HideDisposeSetVisibleFalse;
	public JPanel contentPane;
	public JComboBox CmbPacijent;
	public int PregledID;
	private java.sql.Date TrenutniDatum;
	private String JmbgIzabranogPacijenta;
	public int FakturaID;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm6PregledOdabirPacijenta frame = new Frejm6PregledOdabirPacijenta(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param jmbgLekar 
	 */
	public Frejm6PregledOdabirPacijenta(String JmbgLekar) {
		setTitle("Pregled");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CmbPacijent = new JComboBox(ManipulacijaSaBazom.SpisakPacijenata());
		CmbPacijent.setBounds(35, 36, 305, 20);
		contentPane.add(CmbPacijent);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm2GlavniMeni Nazad = new Frejm2GlavniMeni(JmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNewButton.setBounds(121, 278, 124, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dalje");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom	msbp = new ManipulacijaSaBazom();
				
				String PodaciPacijenta= CmbPacijent.getSelectedItem().toString();
				String JmbgIzabranogPacijenta = PodaciPacijenta.substring(0,13);
				
				Pacijent pac = new Pacijent();	// napravi se jedna instanca klase pacijent koja ce primiti ID pacijenta
				
				pac.setJmbgPacijent(JmbgIzabranogPacijenta);	// postavi se selektovani ID na osnovu koga ce se seltkovati u bazi zeljeni pacijent
				
				Pacijent pacijent=msbp.SelektovanjePacijenta(pac);
				// dobijanje trenutnog datuma 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				   Date date = new Date();
				   java.sql.Date TrenutniDatum = new java.sql.Date(date.getTime());
				
				
				Pregled pregled= new Pregled();
				
				
				pregled.setJmbgLekar(JmbgLekar);
				pregled.setJmbgPacijent(JmbgIzabranogPacijenta);
				pregled.setDatumPregleda(TrenutniDatum);
				
				boolean UnosPregleda=msbp.EvidentiranjePregelda(pregled);
				
				if(UnosPregleda){
					
					
					
					PregledID=ManipulacijaSaBazom.SelektovanjePregledID(TrenutniDatum, JmbgIzabranogPacijenta);
					
					//insertovati pocetnu blanko fakturu a naknadno se dodaju stavke
					Faktura faktura = new Faktura();
					
					
					int IznosFakture=0;
					
					faktura.setPregledID(PregledID);
					faktura.setIznosFakture(IznosFakture);
					
					
				boolean UnosFakture=msbp.EvidentiranjeFakture(faktura);
				
				if(UnosFakture)
					
					FakturaID=ManipulacijaSaBazom.SelektovanjeFaktureID(PregledID);
					
					
					
					dispose();
					Frejm6aPregled Napred = new Frejm6aPregled(pacijent, JmbgLekar, PregledID, FakturaID, null, null, null);
					Napred.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Greska prilikom evidentiranja pregleda");
				}
				
				
			
			}
		});
		btnNewButton_1.setBounds(121, 241, 124, 20);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMolimoVasOdaberite = new JLabel("Molimo Vas odaberite \u017Eeljenog pacijenta");
		lblMolimoVasOdaberite.setBounds(66, 11, 305, 14);
		contentPane.add(lblMolimoVasOdaberite);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Frejm6PregledOdabirPacijenta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 356, 338);
		contentPane.add(lblNewLabel_2);
		
		
		
		
	}
	
}
