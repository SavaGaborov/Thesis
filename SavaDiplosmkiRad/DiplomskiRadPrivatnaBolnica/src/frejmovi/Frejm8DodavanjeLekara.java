package frejmovi;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Lekar;
import entiteti.Mesto;
import entiteti.Zvanje;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Frejm8DodavanjeLekara extends JFrame {

	public JPanel contentPane;
	private JTextField ime;;
	private JTextField prezime;
	private JTextField korime;
	private JTextField sifra;
	private JTextField datrodj;
	private JTextField brtel;
	private JTextField ulicaibr;
	private JTextField jmbg;
	private JComboBox CmbMesto;
	private JComboBox CmbRegion;
	private JComboBox CmbZvanje;
	
	
	public String SelektovanRegion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm8DodavanjeLekara frame = new Frejm8DodavanjeLekara(null);
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
	public Frejm8DodavanjeLekara(String jmbgLekar) {
		setTitle("Unos lekara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setForeground(Color.BLACK);
		lblIme.setBounds(34, 87, 46, 14);
		contentPane.add(lblIme);
		
		ime = new JTextField();
		ime.setBounds(34, 112, 99, 20);
		contentPane.add(ime);
		ime.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setForeground(Color.BLACK);
		lblPrezime.setBounds(34, 160, 79, 14);
		contentPane.add(lblPrezime);
		
		prezime = new JTextField();
		prezime.setBounds(34, 185, 99, 20);
		contentPane.add(prezime);
		prezime.setColumns(10);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime");
		lblKorisnikoIme.setForeground(Color.BLACK);
		lblKorisnikoIme.setBounds(277, 87, 99, 14);
		contentPane.add(lblKorisnikoIme);
		
		korime = new JTextField();
		korime.setBounds(253, 112, 113, 20);
		contentPane.add(korime);
		korime.setColumns(10);
		
		JLabel lblifra = new JLabel("\u0160ifra");
		lblifra.setForeground(Color.BLACK);
		lblifra.setBounds(295, 160, 46, 14);
		contentPane.add(lblifra);
		
		sifra = new JTextField();
		sifra.setBounds(253, 185, 113, 20);
		contentPane.add(sifra);
		sifra.setColumns(10);
		
		JLabel lblDatumRoenja = new JLabel("Datum ro\u0111enja");
		lblDatumRoenja.setForeground(Color.BLACK);
		lblDatumRoenja.setBounds(34, 234, 86, 14);
		contentPane.add(lblDatumRoenja);
		
		datrodj = new JTextField();
		datrodj.setBounds(34, 259, 99, 20);
		contentPane.add(datrodj);
		datrodj.setColumns(10);
		
		JLabel lblZvanje = new JLabel("Zvanje");
		lblZvanje.setForeground(Color.BLACK);
		lblZvanje.setBounds(466, 115, 46, 14);
		contentPane.add(lblZvanje);
		
		JLabel lblNewLabel = new JLabel("Broj telefona");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(466, 178, 97, 14);
		contentPane.add(lblNewLabel);
		
		brtel = new JTextField();
		brtel.setBounds(466, 203, 150, 20);
		contentPane.add(brtel);
		brtel.setColumns(10);
		
		JButton btnNewButton = new JButton("Unesite lekara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				
				
				String jmbgLekar=jmbg.getText();
				String imeLekar=ime.getText();
				String prezimeLekar=prezime.getText();
				String korisnickoimeLekar=korime.getText();
				int sifraLekar=Integer.parseInt(sifra.getText());
				
				java.util.Date DatumRodjenja=null;
				Date datum=null;
				
				try{
					DatumRodjenja=df.parse(datrodj.getText());
					datum= new Date(DatumRodjenja.getTime());		
				}catch(Exception e){
					e.printStackTrace();
				}
				
				String brojTelefonaLekar=brtel.getText();
				String ulicaIbrojLekar=ulicaibr.getText();
				
				
				String NazivMesta=CmbMesto.getSelectedItem().toString();
				int PTT=Integer.parseInt(ManipulacijaSaBazom.UzimanjeIDnaOsnovuNazivaMesta(NazivMesta));
				
				
				String Zvanje=CmbZvanje.getSelectedItem().toString();
				int ZvanjeID=Integer.parseInt(ManipulacijaSaBazom.UzimanjeZvanjaIDnaOsnovuProsledjenogNazivaZvanja(Zvanje));
				
				
				Lekar lekar= new Lekar();
				
				try {
					
				
				
				lekar.setJmbgLekar(jmbgLekar);
				lekar.setIme(imeLekar);
				lekar.setPrezime(prezimeLekar);
				lekar.setKorisnicnoIme(korisnickoimeLekar);
				lekar.setSifra(sifraLekar);
				lekar.setDatumRodjenja(datum);
				lekar.setUlicaiBroj(ulicaIbrojLekar);
				lekar.setBrojTelefona(brojTelefonaLekar);
				lekar.setZvanjeID(ZvanjeID);
				lekar.setPTT(PTT);
				
				
				
				boolean Ubacen=msbp.UnosLekara(lekar);
				
				if(Ubacen){
					JOptionPane.showMessageDialog(null, "Uspešno ste uneli lekara");
					dispose();
					Frejm2GlavniMeni Dodat = new Frejm2GlavniMeni(jmbgLekar);
					Dodat.setVisible(true);
				}

				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Molimo Vas ponovo unesite podatke o lekaru", "Greška", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(466, 333, 203, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm2GlavniMeni Nazad = new Frejm2GlavniMeni(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(466, 367, 203, 23);
		contentPane.add(btnNewButton_1);
		
		CmbZvanje = new JComboBox(ManipulacijaSaBazom.SpisakZvanja());
		CmbZvanje.setBounds(466, 133, 242, 20);
		contentPane.add(CmbZvanje);
		
		JLabel lblJmbg = new JLabel("Jmbg");
		lblJmbg.setBackground(new Color(240, 240, 240));
		lblJmbg.setForeground(Color.BLACK);
		lblJmbg.setBounds(34, 11, 46, 14);
		contentPane.add(lblJmbg);
		
		JLabel lblNewLabel_1 = new JLabel("Region");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(466, 21, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		
		CmbMesto = new JComboBox();
		CmbMesto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		CmbMesto.setBounds(466, 84, 136, 20);
		contentPane.add(CmbMesto);
		
		JLabel lblNewLabel_2 = new JLabel("Ulica i broj");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(466, 234, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		ulicaibr = new JTextField();
		ulicaibr.setBounds(466, 259, 203, 20);
		contentPane.add(ulicaibr);
		ulicaibr.setColumns(10);
		
		jmbg = new JTextField();
		jmbg.setBounds(34, 36, 99, 20);
		contentPane.add(jmbg);
		jmbg.setColumns(10);
		
		CmbRegion = new JComboBox(ManipulacijaSaBazom.SpisakRegiona());
		CmbRegion.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				
				String NazivRegion=CmbRegion.getSelectedItem().toString();	
				int RegionID = Integer.parseInt(ManipulacijaSaBazom.VracanjeRegionID(NazivRegion));
				
				Vector<Mesto> SpisakMesta = ManipulacijaSaBazom.SpisakNazivaMesta(RegionID);
				CmbMesto.setModel(new DefaultComboBoxModel<>(SpisakMesta));
			}
		});
		CmbRegion.setBounds(466, 36, 136, 20);
		contentPane.add(CmbRegion);
		
		JLabel lblMesto = new JLabel("Mesto");
		lblMesto.setBounds(466, 67, 46, 14);
		contentPane.add(lblMesto);
		
		
		String NazivRegion=CmbRegion.getSelectedItem().toString();	
		int RegionID = Integer.parseInt(ManipulacijaSaBazom.VracanjeRegionID(NazivRegion));
		
		Vector<Mesto> SpisakMesta = ManipulacijaSaBazom.SpisakNazivaMesta(RegionID);
		CmbMesto.setModel(new DefaultComboBoxModel<>(SpisakMesta));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Frejm8DodavanjeLekara.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_3.setBounds(0, 0, 718, 413);
		contentPane.add(lblNewLabel_3);
	
	}
}
