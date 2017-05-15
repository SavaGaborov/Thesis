package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Bolest;
import entiteti.Dijagnoza;
import entiteti.Faktura;
import entiteti.IzvrseneUsluge;
import entiteti.Pacijent;
import entiteti.Pregled;
import entiteti.StavkaFakture;
import entiteti.Usluga;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;

public class Frejm6aPregled extends JFrame {

	public JPanel contentPane;
	private JTextField TxtIzlecivo;
	private JTextField TxtIme;
	private JTextField TxtPrezime;
	public JTable TabelaBolesti;
	public JComboBox ComboBoxUsluga;
	public JComboBox ComboBoxBolest;
	public int BrojacDodatihUsluga;
	public int BrojacDodatihBolesti;
	public JTable TabelaUsluge;
	public int CenaUsluge;
	private JButton btnIzdavanjeUputa;
	public static DefaultTableModel DodateBolesti;
	public static DefaultTableModel DodateUsluge;
	public static int brojacUsluga = 0;					// brojac je static i uvek kad se vrati na ovaj frejm ostaje isti broj da nije static resetovao bi se ma nula
	public static int brojacBolest = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm6aPregled frame = new Frejm6aPregled(null, null, 0, 0, null, null, null);
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
	 * @param dodateUsluge2 
	 * @param fakturaID2 
	 * @param pregledID2 
	 * @param String nazivLeka 
	 * @param iznosFakture 
	 */																															
	public Frejm6aPregled(Pacijent pacijent, String jmbgLekar, int pregledID,  int fakturaID, String nazivLeka, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
				
		setTitle("Pregled");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setForeground(Color.BLACK);
		lblIme.setBounds(22, 26, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setForeground(Color.BLACK);
		lblPrezime.setBounds(22, 84, 112, 14);
		contentPane.add(lblPrezime);
		
		ComboBoxBolest = new JComboBox(ManipulacijaSaBazom.SpisakBolesti());
		ComboBoxBolest.setBounds(243, 109, 292, 20);
		contentPane.add(ComboBoxBolest);
		
		JLabel lblBolest = new JLabel("Bolest");
		lblBolest.setForeground(Color.BLACK);
		lblBolest.setBounds(243, 84, 46, 14);
		contentPane.add(lblBolest);
		
		TxtIzlecivo = new JTextField();
		TxtIzlecivo.setEditable(false);
		TxtIzlecivo.setBounds(22, 406, 360, 20);
		contentPane.add(TxtIzlecivo);
		TxtIzlecivo.setColumns(10);
		
		ComboBoxUsluga = new JComboBox(ManipulacijaSaBazom.SpisakUsluga());
		ComboBoxUsluga.setBounds(243, 53, 292, 20);
		contentPane.add(ComboBoxUsluga);
		
		JLabel lblUsluga = new JLabel("Usluga");
		lblUsluga.setForeground(Color.BLACK);
		lblUsluga.setBounds(246, 26, 46, 14);
		contentPane.add(lblUsluga);
		
		btnIzdavanjeUputa = new JButton("Izdavanje uputa");
		btnIzdavanjeUputa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();										
				Frejmb16IzdavanjeUputa Uput = new Frejmb16IzdavanjeUputa(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, DodateBolesti, DodateUsluge);
				Uput.setVisible(true);
			}
		});
		btnIzdavanjeUputa.setForeground(Color.WHITE);
		btnIzdavanjeUputa.setBackground(Color.BLACK);
		btnIzdavanjeUputa.setBounds(22, 437, 151, 23);
		contentPane.add(btnIzdavanjeUputa);
		
		JButton btnIzdavanjeRecepta = new JButton("Izdavanje recepta");
		btnIzdavanjeRecepta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				Frejm17IzdavanjeRecepta Recept = new Frejm17IzdavanjeRecepta(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, null, DodateBolesti, DodateUsluge);
				Recept.setVisible(true);
			}
		});
		btnIzdavanjeRecepta.setForeground(Color.WHITE);
		btnIzdavanjeRecepta.setBackground(Color.BLACK);
		btnIzdavanjeRecepta.setBounds(178, 437, 151, 23);
		contentPane.add(btnIzdavanjeRecepta);
		
		TxtIme = new JTextField();
		TxtIme.setEditable(false);
		TxtIme.setBounds(24, 53, 112, 20);
		contentPane.add(TxtIme);
		TxtIme.setColumns(10);
		
		TxtPrezime = new JTextField();
		TxtPrezime.setEditable(false);
		TxtPrezime.setBounds(22, 109, 112, 20);
		contentPane.add(TxtPrezime);
		TxtPrezime.setColumns(10);
		
		JButton btnNewButton = new JButton("Zaklju\u010Divanje pregleda");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
				Frejm15IzdavanjeFakture Faktura = new Frejm15IzdavanjeFakture(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, DodateBolesti, DodateUsluge);
				Faktura.setVisible(true);
			}
		});
		btnNewButton.setBounds(536, 405, 168, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// treba da obrisem prvo 1dijagnozue 2izvrsene 3stavkuFakture 4Fakturu 5PRegled
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				
				//zbog stranih kljuceva brisem ovim redosledom 
				
				Pregled pregled = new Pregled();
				Faktura faktura = new Faktura();
				
				
				pregled.setPregledID(pregledID);
				faktura.setFakturaID(fakturaID);
				
				boolean BrisanjeDijagnoza = msbp.BrisanjeDijagnoza(pregled);
				if(BrisanjeDijagnoza){System.out.println("true");}
				
				boolean BrisanjeIzvrsenihUsluga = msbp.BrisanjeIzvrsenihUsluga(pregled);
				if(BrisanjeIzvrsenihUsluga){System.out.println();}
				
				boolean BrisanjeStavkiFakture = msbp.BrisanjeStavkiFakture(faktura);
				if(BrisanjeStavkiFakture){System.out.println();}
				
				boolean BrisanjeFakture = msbp.BrisanjeFakture(pregled);
				if(BrisanjeFakture){System.out.println();}
				
				boolean BrisanjePregleda = msbp.BrisanjePregleda(pregled);
				if(BrisanjePregleda){System.out.println();}

				brojacBolest = 0;
				brojacUsluga = 0;
				
				
				
				dispose();
				Frejm6PregledOdabirPacijenta Nazad = new Frejm6PregledOdabirPacijenta(jmbgLekar);
				Nazad.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(592, 437, 112, 23);
		contentPane.add(btnNewButton_1);
	
		
		TabelaBolesti = new JTable();
		TabelaBolesti.setBounds(22, 172, 222, 175);
		contentPane.add(TabelaBolesti);
		
		JLabel lblBolest_1 = new JLabel("Bolest");
		lblBolest_1.setBounds(22, 158, 46, 14);
		contentPane.add(lblBolest_1);
		
		JLabel lblUsluga_1 = new JLabel("Usluga");
		lblUsluga_1.setBounds(246, 158, 46, 14);
		contentPane.add(lblUsluga_1);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setBounds(461, 158, 46, 14);
		contentPane.add(lblIznos);
		
		JButton btnNewButton_3 = new JButton("Dodaj bolest");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ManipulacijaSaBazom msbp= new ManipulacijaSaBazom();
				
				brojacBolest+=1;
				
				
				String NazivBolesti=ComboBoxBolest.getSelectedItem().toString();
				int BolestID=ManipulacijaSaBazom.VracanjeBolestID(NazivBolesti);
				
				Dijagnoza dijagnoza = new Dijagnoza();
				
				dijagnoza.setPregledID(pregledID);
				dijagnoza.setRedniBroj(brojacBolest);
				dijagnoza.setBolestID(BolestID);
				
				boolean DodavanjeBolesti=msbp.EvidentiranjeDijagnoze(dijagnoza);
				
				boolean Izlecivo=ManipulacijaSaBazom.ProveraIzlecivosti(BolestID);
				
				
				
				if (DodavanjeBolesti){
					
					DodateBolesti=ManipulacijaSaBazom.SelektovanjeBolestiZaTabelu(pregledID);
					
					TabelaBolesti.setModel(DodateBolesti);
					
					if (!Izlecivo){
						TxtIzlecivo.setText("Potrebno poslati pacijenta u drugu zdravstvenu ustanovu");
						btnIzdavanjeUputa.setEnabled(true);
					}else{
						TxtIzlecivo.setText("");
						btnIzdavanjeUputa.setEnabled(false);
					}
				}
				
				}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(592, 108, 112, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnObriiteStavku = new JButton("Obri\u0161ite bolest");
		btnObriiteStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//System.out.println("Row and column: " + TabelaBolesti.getSelectedRows() + " " + TabelaBolesti.getSelectedColumns() + " " + TabelaBolesti.getModel().getValueAt(TabelaBolesti.getSelectedRow(), TabelaBolesti.getSelectedColumn()).toString());
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				String NazivBolesti=TabelaBolesti.getModel().getValueAt(TabelaBolesti.getSelectedRow(), TabelaBolesti.getSelectedColumn()).toString();
				System.out.println("Obrisana bolest je " + NazivBolesti);
				
				int BolestID=msbp.SelektovanjeBolestIDnaOsnovuNazivaBolesti(NazivBolesti);
				System.out.println("Selektovana bolest ID" + BolestID);
				
				boolean ObirsanaBolestIzTabele=msbp.BrisanjeSelektovaneBolestiUTabeliSaPregledaIzBaze(BolestID, pregledID);
				
				if (ObirsanaBolestIzTabele){
					System.out.println("stavka obrisana upsesno");
					}
				
				if(TabelaBolesti.getSelectedRow() != -1 ) 
					((DefaultTableModel)TabelaBolesti.getModel()).removeRow(TabelaBolesti.getSelectedRow());
				
			}
		});
		btnObriiteStavku.setForeground(Color.WHITE);
		btnObriiteStavku.setBackground(Color.BLACK);
		btnObriiteStavku.setBounds(22, 372, 139, 23);
		contentPane.add(btnObriiteStavku);
		
		JButton btnNewButton_2 = new JButton("Dodaj uslugu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				brojacUsluga+=1;
				String NazivUsluge=ComboBoxUsluga.getSelectedItem().toString();
				
				int UslugaID=ManipulacijaSaBazom.SlektovanjeUslugeID(NazivUsluge);
				
				int CenaUsluge=ManipulacijaSaBazom.SelektovanjeCene(UslugaID);	
				
				
				
				IzvrseneUsluge izvrseneUsluge = new IzvrseneUsluge();
				
				izvrseneUsluge.setPregledID(pregledID);
				izvrseneUsluge.setRedniBroj(brojacUsluga);
				izvrseneUsluge.setUslugaID(UslugaID);
				
				boolean DodavanjeUsluge= ManipulacijaSaBazom.EvidentiranjeUsluga(izvrseneUsluge);

				if(DodavanjeUsluge){
					
					DodateUsluge=ManipulacijaSaBazom.SelektovanjeUslugaZaTabelu(pregledID);
					
					TabelaUsluge.setModel(DodateUsluge);
					
				}
				
				StavkaFakture stavkaFakture = new StavkaFakture();
				
				stavkaFakture.setFakutraID(fakturaID);
				stavkaFakture.setRedniBroj(brojacUsluga);
				stavkaFakture.setUslugaID(UslugaID);
				stavkaFakture.setCena(CenaUsluge);
				
				boolean DodavanjeStavkeFakture=msbp.EvidentiranjeStavkeFakture(stavkaFakture);
				
				if(DodavanjeStavkeFakture){}
				
				
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(592, 52, 112, 23);
		contentPane.add(btnNewButton_2);
		
		
		
		
		TxtIme.setText(pacijent.getIme());
		TxtPrezime.setText(pacijent.getPrezime());
		
		TabelaUsluge = new JTable();
		TabelaUsluge.setBounds(242, 172, 462, 175);
		contentPane.add(TabelaUsluge);
		
		JButton btnNewButton_4 = new JButton("Istorijat le\u010Denja");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Frejm7IstorijatLecenja ElektronskiKarton = new Frejm7IstorijatLecenja(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, DodateBolesti, DodateUsluge);
				ElektronskiKarton.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(335, 436, 148, 25);
		contentPane.add(btnNewButton_4);
		
		BrojacDodatihUsluga=brojacUsluga;
		BrojacDodatihBolesti=brojacBolest;

		if(dodateBolesti != null)
			TabelaBolesti.setModel(dodateBolesti);
		
		if(dodateUsluge != null)
			TabelaUsluge.setModel(dodateUsluge);
		
		btnIzdavanjeUputa.setEnabled(false);
		
		JButton btnNewButton_5 = new JButton("Obri\u0161ite uslugu");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManipulacijaSaBazom msbp= new ManipulacijaSaBazom();
				
				String NazivUsluge=TabelaUsluge.getModel().getValueAt(TabelaUsluge.getSelectedRow(), TabelaUsluge.getSelectedColumn()).toString();
				System.out.println("Obrisana usluga je je " + NazivUsluge);
				
				int UslugaID=msbp.SelektovanjeUslugaIDnaOsnovuNazivUsluge(NazivUsluge);
				System.out.println("Selektovana usluga ID" + UslugaID);
				
				boolean ObirsanaUslugaIzTabele=msbp.BrisanjeSelektovaneUslugeUTabelisaPregledaizBaze(UslugaID, pregledID);
				
				if(ObirsanaUslugaIzTabele){}
				
				System.out.println("Faktura ID je" + fakturaID);
				boolean ObrisanaStavkaFaktureIzTabele=msbp.BrisanjeSelektovaneStakveFaktureUTabeli(UslugaID, fakturaID);
				
				if(ObrisanaStavkaFaktureIzTabele){}

				
				if(TabelaUsluge.getSelectedRow() != -1)
				((DefaultTableModel)TabelaUsluge.getModel()).removeRow(TabelaUsluge.getSelectedRow());
				
			}
		});
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(243, 372, 139, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm6aPregled.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 727, 471);
		contentPane.add(lblNewLabel);
	}
}
