package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Mesto;
import entiteti.Pacijent;
import entiteti.Region;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.awt.event.ItemEvent;

public class Frejm5AžuriranjePacijenta extends JFrame {

	public JPanel contentPane;
	public JTextField TxtImeOca;
	private JTextField TxtPrezime;
	private JTextField TxtIme;
	private JTextField TxtBrojTelefona;
	private JTextField TxtUlicaIBroj;
	private JComboBox ComboRegion;
	private JComboBox ComboMesto;
	private JTextField TxtBrojZdravstveneKnjizice;
	public String JmbgPacijent;
	public String PocetniNazivRegiona;
	public String PocetniNazivMesta;
	public int PTT;
	public int RegionID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm5AžuriranjePacijenta frame = new Frejm5AžuriranjePacijenta(null,null);
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
	 * @param pac 
	 */

	public Frejm5AžuriranjePacijenta(Pacijent pacijent, String jmbgLekar) {
		
		setTitle("A\u017Euriranje pacijenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(25, 30, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(25, 172, 68, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblImeOca = new JLabel("Ime oca");
		lblImeOca.setBounds(25, 100, 46, 14);
		contentPane.add(lblImeOca);
		
		TxtImeOca = new JTextField();
		TxtImeOca.setEditable(false);
		TxtImeOca.setBounds(25, 125, 117, 20);
		contentPane.add(TxtImeOca);
		TxtImeOca.setColumns(10);
		
		TxtPrezime = new JTextField();
		TxtPrezime.setBounds(25, 197, 117, 20);
		contentPane.add(TxtPrezime);
		TxtPrezime.setColumns(10);
		
		TxtIme = new JTextField();
		TxtIme.setEditable(false);
		TxtIme.setBounds(25, 55, 117, 20);
		contentPane.add(TxtIme);
		TxtIme.setColumns(10);
		
		TxtBrojTelefona = new JTextField();
		TxtBrojTelefona.setBounds(255, 263, 125, 20);
		contentPane.add(TxtBrojTelefona);
		TxtBrojTelefona.setColumns(10);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona");
		lblBrojTelefona.setBounds(255, 238, 86, 14);
		contentPane.add(lblBrojTelefona);
		
		
		JButton btnAurirajPacijenta = new JButton("A\u017Euriraj pacijenta");
		btnAurirajPacijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				String NazivMesta =  ComboMesto.getSelectedItem().toString();
				
				int PTTAzuriranje = Integer.parseInt(ManipulacijaSaBazom.UzimanjeIDnaOsnovuNazivaMesta(NazivMesta));
				
				
				
				Pacijent AzuriranPacijent = new Pacijent(); // napravi se nova instanca i getuju je vrednosti ponovo iz razloga ukoliko je doslo do neke promene
				
				try {
					
				
				
				AzuriranPacijent.setPTT(PTTAzuriranje);
				AzuriranPacijent.setJmbgPacijent(JmbgPacijent);
				AzuriranPacijent.setIme(TxtIme.getText());
				AzuriranPacijent.setPrezime(TxtPrezime.getText());
				AzuriranPacijent.setImeOca(TxtImeOca.getText());
				AzuriranPacijent.setBrojTelefona(TxtBrojTelefona.getText());
				AzuriranPacijent.setUlicaiBroj(TxtUlicaIBroj.getText());
				AzuriranPacijent.setBrojZdravstveneKnjizice(Integer.parseInt(TxtBrojZdravstveneKnjizice.getText()));
				
				boolean UspesnoAzuriranje = msbp.AzuriranjePacijenta(AzuriranPacijent);
				
				if (UspesnoAzuriranje) {
					JOptionPane.showMessageDialog(null, "Uspešno ste ažurirali podatke o pacijentu");
					dispose();
					Frejm2GlavniMeni Azuriran = new Frejm2GlavniMeni(jmbgLekar);
					Azuriran.setVisible(true);
				}} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Molimo Vas ponovo unesti podatke", "Greška", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}

			private int String(String vracanjePTT) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		btnAurirajPacijenta.setForeground(Color.WHITE);
		btnAurirajPacijenta.setBackground(Color.BLACK);
		btnAurirajPacijenta.setBounds(255, 371, 146, 23);
		contentPane.add(btnAurirajPacijenta);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm4AžuriranjePacijenta Nazad = new Frejm4AžuriranjePacijenta(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		

		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setBounds(255, 405, 146, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel = new JLabel("Region");
		lblNewLabel.setBounds(255, 30, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ulica i broj");
		lblNewLabel_1.setBounds(255, 172, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		TxtUlicaIBroj = new JTextField();
		TxtUlicaIBroj.setBounds(255, 197, 199, 20);
		contentPane.add(TxtUlicaIBroj);
		TxtUlicaIBroj.setColumns(10);
		
		ComboRegion = new JComboBox(ManipulacijaSaBazom.SpisakRegiona());
		ComboRegion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String NazivRegion = ComboRegion.getSelectedItem().toString();
				int RegionID = Integer.parseInt(ManipulacijaSaBazom.VracanjeRegionID(NazivRegion));		
	
				
				Vector<Mesto> SpisakMesta = ManipulacijaSaBazom.SpisakNazivaMesta(RegionID);
				ComboMesto.setModel(new DefaultComboBoxModel<>(SpisakMesta));
			}
		});
		ComboRegion.setBounds(255, 55, 135, 20);
		contentPane.add(ComboRegion);
		
		ComboMesto = new JComboBox();
		ComboMesto.setBounds(255, 125, 135, 20);
		contentPane.add(ComboMesto);
		
		JLabel lblNewLabel_2 = new JLabel("Mesto");
		lblNewLabel_2.setBounds(255, 100, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
		TxtBrojZdravstveneKnjizice = new JTextField();
		TxtBrojZdravstveneKnjizice.setBounds(255, 318, 146, 20);
		contentPane.add(TxtBrojZdravstveneKnjizice);
		TxtBrojZdravstveneKnjizice.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Broj zdravstvene knjizice");
		lblNewLabel_3.setBounds(255, 294, 172, 14);
		contentPane.add(lblNewLabel_3);
		
		// postavljanje pocetnih vrednosti za frejm na osnovu vrednosti instance koja je prosledjena kao i postavljanje 
		//PocetniRegion=ManipulacijaSaBazom
		PTT=pacijent.getPTT();
		
		
		RegionID=ManipulacijaSaBazom.SelektovanjeRegionID(PTT); // ocitavanje redion id-ja na osnovu ptt-a
		PocetniNazivRegiona=ManipulacijaSaBazom.SelektovanjeNazivaRegionaNaOsnovuID(RegionID);  // ocitavanje naziva regiona id-ja na osnovu ptt-a
		ComboRegion.getModel().setSelectedItem(PocetniNazivRegiona); // nacin za postavljanje default vrednosti za kombo box
		
		PocetniNazivMesta=ManipulacijaSaBazom.VracanjeNazivaMestaNaOsnovuPTT(PTT); // ocitavanje naziva mesta id-ja na osnovu ptt-a
		ComboMesto.getModel().setSelectedItem(PocetniNazivMesta);
		
		
		
		
		JmbgPacijent=pacijent.getJmbgPacijent();
		TxtIme.setText(pacijent.getIme());
		TxtImeOca.setText(pacijent.getImeOca());
		TxtPrezime.setText(pacijent.getPrezime());
		TxtUlicaIBroj.setText(pacijent.getUlicaiBroj());
		TxtBrojTelefona.setText(pacijent.getBrojTelefona());
		TxtBrojZdravstveneKnjizice.setText(Integer.toString(pacijent.getBrojZdravstveneKnjizice()));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Frejm5AžuriranjePacijenta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_4.setBounds(0, 0, 478, 439);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
