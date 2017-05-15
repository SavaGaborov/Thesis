package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Pacijent;
import entiteti.Recept;
import metode.ManipulacijaSaBazom;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Frejm17StampanjeRecepta extends JFrame {

	private JPanel contentPane;
	private JLabel LbLIme;
	private JLabel lblPrezime;
	private JLabel lblJMBG;
	private JLabel lblDatumIzdavanja;
	private JLabel lblBrojZdravstveneKnjizice;
	private JLabel lblJmbgLekara;
	private JLabel lblDrzava;
	private JLabel lblNazivLeka;
	private String Ime;
	private String Prezime;
	private JLabel lblImeLekara;
	private JLabel LblPrezimeLekara;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm17StampanjeRecepta frame = new Frejm17StampanjeRecepta(null, null, 0, 0, 0, 0, null, null, null);
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
	 * @param nazivLeka 
	 * @param dodateUsluge 
	 * @param dodateBolesti 
	 */
	public Frejm17StampanjeRecepta(Pacijent pacijent, String jmbgLekar, int brojacUsluga, int brojacBolest, int pregledID, int fakturaID, String nazivLeka, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
		setTitle("\u0160tampanje i evidentiranje recepta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0160tampaj i evidentiraj recept");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				Recept recept = new Recept();
				
		
				
				int LekID=ManipulacijaSaBazom.SelektovanjeLekIDnaOsnovuNazivaLeka(nazivLeka);
				
				
				recept.setLekID(LekID);
				recept.setPregledID(pregledID);
				
				boolean EvidentiranjeRecepta=msbp.EvidentiranjeRecepta(recept);
				
				if(EvidentiranjeRecepta){
				}
				 
				
				dispose();
				Frejm6aPregled Nazad = new Frejm6aPregled(pacijent, jmbgLekar, pregledID, fakturaID, null, dodateBolesti, dodateUsluge);
				Nazad.setVisible(true);
			}
		});
		btnNewButton.setBounds(137, 574, 230, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBackground(Color.BLACK);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();																							
				Frejm17IzdavanjeRecepta Nazad = new Frejm17IzdavanjeRecepta(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, nazivLeka, dodateBolesti, dodateUsluge);
				Nazad.setVisible(true);
			}
		});
		btnNazad.setBounds(20, 574, 107, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel = new JLabel("\"Privatna bolnica Sveti Jovan\"");
		lblNewLabel.setBounds(91, 63, 211, 14);
		contentPane.add(lblNewLabel);
		
		LbLIme = new JLabel("");
		LbLIme.setBounds(120, 89, 81, 14);
		contentPane.add(LbLIme);
		
		lblPrezime = new JLabel("");
		lblPrezime.setBounds(200, 89, 92, 14);
		contentPane.add(lblPrezime);
		
		LbLIme.setText(pacijent.getIme());
		lblPrezime.setText(pacijent.getPrezime());
		
		lblJMBG = new JLabel("");
		lblJMBG.setBounds(70, 114, 92, 14);
		contentPane.add(lblJMBG);
		
		lblDatumIzdavanja = new JLabel("");
		lblDatumIzdavanja.setBounds(152, 164, 92, 14);
		contentPane.add(lblDatumIzdavanja);
		

		lblBrojZdravstveneKnjizice = new JLabel("");
		lblBrojZdravstveneKnjizice.setBounds(109, 139, 81, 14);
		contentPane.add(lblBrojZdravstveneKnjizice);
		
		
		lblJmbgLekara = new JLabel("");
		lblJmbgLekara.setBounds(137, 188, 97, 14);
		contentPane.add(lblJmbgLekara);

		lblDrzava = new JLabel("RS");
		lblDrzava.setBounds(263, 139, 46, 14);
		contentPane.add(lblDrzava);
		
		lblNazivLeka = new JLabel("");
		lblNazivLeka.setBounds(70, 236, 122, 14);
		contentPane.add(lblNazivLeka);
		
		Ime=ManipulacijaSaBazom.SelektovanjeImenaILekara(jmbgLekar);
		Prezime=ManipulacijaSaBazom.SelektovanjePrezimenaILekara(jmbgLekar);
		
		lblImeLekara = new JLabel("New label");
		lblImeLekara.setBounds(170, 432, 62, 14);
		contentPane.add(lblImeLekara);
		
		LblPrezimeLekara = new JLabel("New label");
		LblPrezimeLekara.setBounds(236, 432, 73, 14);
		contentPane.add(LblPrezimeLekara);
		
		
		LbLIme.setText(pacijent.getIme());
		lblPrezime.setText(pacijent.getPrezime());
		lblJMBG.setText(pacijent.getJmbgPacijent());
		lblBrojZdravstveneKnjizice.setText(Integer.toString(pacijent.getBrojZdravstveneKnjizice()));
		lblJmbgLekara.setText(jmbgLekar);
		lblNazivLeka.setText(nazivLeka);
		lblImeLekara.setText(Ime);
		LblPrezimeLekara.setText(Prezime);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Frejm17StampanjeRecepta.class.getResource("/frejmovi/SlikaRecepta.jpg")));
		lblNewLabel_1.setBounds(46, 11, 272, 552);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Frejm17StampanjeRecepta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 381, 607);
		contentPane.add(lblNewLabel_2);
		
		Calendar cal = new GregorianCalendar();
		int day= cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		
		lblDatumIzdavanja.setText(day + "/" + month + "/" + year);
		
		
		
	}
}
