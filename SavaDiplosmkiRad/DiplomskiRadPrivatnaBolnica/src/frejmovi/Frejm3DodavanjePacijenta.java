package frejmovi;

import java.sql.Date;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.ParseConversionEvent;

import entiteti.Mesto;
import entiteti.Pacijent;
import metode.ManipulacijaSaBazom;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Frejm3DodavanjePacijenta extends JFrame {
	
	
	public JPanel contentPane;
	private JTextField brtel;
	private JTextField ulicaibr;
	private JTextField jmbg;
	private JTextField ime;
	private JTextField imeoca;
	private JTextField prezime;
	private JTextField datrodj;
	private JComboBox region;
	private JComboBox mesto;
	private JTextField BrZdrKnjiz;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm3DodavanjePacijenta frame = new Frejm3DodavanjePacijenta(null);
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
	 * @param jmbglekar 
	 */
	public Frejm3DodavanjePacijenta(String jmbgLekar) {
		setTitle("Unos pacijenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Broj telefona");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(323, 159, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		brtel = new JTextField();
		brtel.setBounds(403, 159, 128, 20);
		contentPane.add(brtel);
		brtel.setColumns(10);
		
		
		JButton btnUnesitePacijenta = new JButton("Unesite pacijenta");
		btnUnesitePacijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				
				String JmbgPacijent=jmbg.getText();
				String Ime=ime.getText();
				String ImeOca=imeoca.getText();
				String Prezime=prezime.getText();
				
				//parsiranje datum iz java util u my sql date
				java.util.Date DatumRodjenja = null;
				Date datum=null;
					try{DatumRodjenja=df.parse(datrodj.getText());
						datum = new Date (DatumRodjenja.getTime());
					}catch(Exception e){
						e.printStackTrace();
					}
				
				int BrZdravstveneKnjizice=Integer.parseInt(BrZdrKnjiz.getText());				
				
				String NazivMesta=mesto.getSelectedItem().toString();
				
				int PTT=Integer.parseInt(msbp.UzimanjeIDnaOsnovuNazivaMesta(NazivMesta));
				
				String UlicaIBroj= ulicaibr.getText();
				String BrojTelefona= brtel.getText();
				
				Pacijent pacijent = new Pacijent();
				
				try {
					
				pacijent.setJmbgPacijent(JmbgPacijent);
				pacijent.setPTT(PTT);
				pacijent.setImeOca(ImeOca);
				pacijent.setIme(Ime);
				pacijent.setPrezime(Prezime);
				pacijent.setDatumRodjenja((java.sql.Date) datum);
				pacijent.setBrojTelefona(BrojTelefona);
				pacijent.setUlicaiBroj(UlicaIBroj);
				pacijent.setBrojZdravstveneKnjizice(BrZdravstveneKnjizice);
				
	
				boolean Dodavanje=msbp.UnosPacijenta(pacijent);
				
				if (Dodavanje){
					JOptionPane.showMessageDialog(null, "Uspešno ste uneli pacijenta");
					dispose();
					Frejm2GlavniMeni Azuriran = new Frejm2GlavniMeni(jmbgLekar);
					Azuriran.setVisible(true);
				}
				}catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Greska prilikom unosa pacijenta molimo Vas ponovo unesite podatke", "Greška", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnUnesitePacijenta.setBackground(Color.BLACK);
		btnUnesitePacijenta.setForeground(Color.WHITE);
		btnUnesitePacijenta.setBounds(409, 283, 139, 23);
		contentPane.add(btnUnesitePacijenta);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				Frejm2GlavniMeni Nazad = new Frejm2GlavniMeni(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNazad.setBounds(409, 317, 139, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNazivMesta = new JLabel("Mesto");
		lblNazivMesta.setForeground(Color.BLACK);
		lblNazivMesta.setBounds(323, 61, 73, 14);
		contentPane.add(lblNazivMesta);
		
		JLabel lblUlicaIBroj = new JLabel("Ulica i broj");
		lblUlicaIBroj.setForeground(Color.BLACK);
		lblUlicaIBroj.setBounds(323, 109, 107, 14);
		contentPane.add(lblUlicaIBroj);
		
		ulicaibr = new JTextField();
		ulicaibr.setBounds(403, 106, 199, 20);
		contentPane.add(ulicaibr);
		ulicaibr.setColumns(10);
		
		
		
		mesto = new JComboBox();
		mesto.setBounds(403, 58, 139, 20);
		contentPane.add(mesto);
		
		Panel panel = new Panel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(21, 20, 288, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Jmbg");
		label.setForeground(Color.BLACK);
		label.setBounds(10, 14, 46, 14);
		panel.add(label);
		
		jmbg = new JTextField();
		jmbg.setColumns(10);
		jmbg.setBounds(159, 11, 119, 20);
		panel.add(jmbg);
		
		JLabel label_1 = new JLabel("Ime");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(10, 62, 46, 14);
		panel.add(label_1);
		
		ime = new JTextField();
		ime.setColumns(10);
		ime.setBounds(159, 59, 119, 20);
		panel.add(ime);
		
		JLabel label_2 = new JLabel("Ime oca");
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(10, 112, 46, 14);
		panel.add(label_2);
		
		imeoca = new JTextField();
		imeoca.setColumns(10);
		imeoca.setBounds(159, 109, 119, 20);
		panel.add(imeoca);
		
		JLabel label_3 = new JLabel("Prezime");
		label_3.setForeground(Color.BLACK);
		label_3.setBackground(new Color(255, 255, 51));
		label_3.setBounds(10, 166, 73, 14);
		panel.add(label_3);
		
		prezime = new JTextField();
		prezime.setColumns(10);
		prezime.setBounds(159, 163, 119, 20);
		panel.add(prezime);
		
		JLabel label_4 = new JLabel("Datum rodjenja");
		label_4.setForeground(Color.BLACK);
		label_4.setBounds(10, 224, 86, 14);
		panel.add(label_4);
		
		datrodj = new JTextField();
		datrodj.setColumns(10);
		datrodj.setBounds(159, 221, 119, 20);
		panel.add(datrodj);
		
		JLabel lblNewLabel = new JLabel("Broj zdravstvene knjizice");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 278, 146, 14);
		panel.add(lblNewLabel);
		
		BrZdrKnjiz = new JTextField();
		BrZdrKnjiz.setBounds(159, 275, 119, 20);
		panel.add(BrZdrKnjiz);
		BrZdrKnjiz.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Frejm3DodavanjePacijenta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 288, 320);
		panel.add(lblNewLabel_2);
		
		region = new JComboBox(ManipulacijaSaBazom.SpisakRegiona());
		region.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String NazivRegion=region.getSelectedItem().toString();
				int RegionID = Integer.parseInt(ManipulacijaSaBazom.VracanjeRegionID (NazivRegion));
				
				Vector<Mesto> SpisakMesta = ManipulacijaSaBazom.SpisakNazivaMesta(RegionID);
				mesto.setModel(new DefaultComboBoxModel(SpisakMesta));
				
			}
		});
		region.setBounds(403, 20, 139, 20);
		contentPane.add(region);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setForeground(Color.BLACK);
		lblRegion.setBounds(323, 20, 73, 14);
		contentPane.add(lblRegion);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Frejm3DodavanjePacijenta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 630, 364);
		contentPane.add(lblNewLabel_1);
		
		String NazivRegion=region.getSelectedItem().toString();
		int RegionID = Integer.parseInt(ManipulacijaSaBazom.VracanjeRegionID (NazivRegion));
			
		Vector<Mesto> SpisakMesta = ManipulacijaSaBazom.SpisakNazivaMesta(RegionID);
		mesto.setModel(new DefaultComboBoxModel(SpisakMesta));
	}
}
