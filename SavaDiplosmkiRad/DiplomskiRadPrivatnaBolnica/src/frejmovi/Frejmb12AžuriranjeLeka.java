package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Lek;
import entiteti.Mesto;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Frejmb12AžuriranjeLeka extends JFrame {

	public JPanel contentPane;
	public JComboBox CmbLek;
	public JComboBox CmbProizvodjac;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejmb12AžuriranjeLeka frame = new Frejmb12AžuriranjeLeka(null);
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
	public Frejmb12AžuriranjeLeka(String jmbgLekar) {
		setTitle("A\u017Euriranje leka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMolimoVasOdaberite = new JLabel("Molimo Vas odaberite proizvo\u0111a\u010Da leka koji \u017Eelite da a\u017Eurirate");
		lblMolimoVasOdaberite.setForeground(new Color(0, 0, 0));
		lblMolimoVasOdaberite.setBounds(20, 30, 385, 14);
		contentPane.add(lblMolimoVasOdaberite);
		
		CmbLek = new JComboBox(ManipulacijaSaBazom.SpisakNazivaLekova());
		CmbLek.setBounds(67, 123, 270, 20);
		contentPane.add(CmbLek);
		
		JButton btnNewButton = new JButton("Dalje");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom mnbp = new ManipulacijaSaBazom();
				
				String NazivProizvodjaca= CmbProizvodjac.getSelectedItem().toString();
				int ProizvodjacID=Integer.parseInt(ManipulacijaSaBazom.SelektovanjeProizvodjacIDnaOsnovuImenaProizvodjaca(NazivProizvodjaca));
				String NazivLeka=CmbLek.getSelectedItem().toString();
				
				Lek lek=new Lek();
				
				lek.setProizvodjacID(ProizvodjacID);
				lek.setNazivLeka(NazivLeka);
				
				Lek lekovi=mnbp.SelektovanjeLekaZaAzuriranje(lek);
				
				lekovi.setLekID(lek.getLekID());
				lekovi.setProizvodjacID(ProizvodjacID);
				lekovi.setNazivLeka(NazivLeka);
				lekovi.setJacina(lek.getJacina());
				
				dispose();
				Frejmb13AžuriranjeLeka Napred = new Frejmb13AžuriranjeLeka(lekovi, NazivProizvodjaca, jmbgLekar);
				Napred.setVisible(true);
			}
		});
		btnNewButton.setBounds(125, 277, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm2GlavniMeni Nazad = new Frejm2GlavniMeni(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(125, 311, 135, 23);
		contentPane.add(btnNewButton_1);
		
		CmbProizvodjac = new JComboBox(ManipulacijaSaBazom.SpisakProizvodjaca());
		CmbProizvodjac.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				//uslovno punjenje drugog kombo boksa naziva proizovodjaca
				String NazivProizvodjaca= CmbProizvodjac.getSelectedItem().toString();
				int ProizvodjacID=Integer.parseInt(ManipulacijaSaBazom.SelektovanjeProizvodjacIDnaOsnovuImenaProizvodjaca(NazivProizvodjaca));
				
				
				Vector<Lek> SpisakLekova = ManipulacijaSaBazom.SpisakUslovnihNazivaLekova(ProizvodjacID);
				CmbLek.setModel(new DefaultComboBoxModel<>(SpisakLekova));	
			}
		});
		CmbProizvodjac.setBounds(67, 55, 270, 20);
		contentPane.add(CmbProizvodjac);
		
		JLabel lblMolimoVasOdaberite_1 = new JLabel("Molimo Vas odaberite naziv leka koji \u017Eelite da a\u017Eurirate");
		lblMolimoVasOdaberite_1.setForeground(Color.BLACK);
		lblMolimoVasOdaberite_1.setBounds(36, 98, 309, 14);
		contentPane.add(lblMolimoVasOdaberite_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejmb12AžuriranjeLeka.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 405, 357);
		contentPane.add(lblNewLabel);
		
		
		String NazivProizvodjaca= CmbProizvodjac.getSelectedItem().toString();
		int ProizvodjacID=Integer.parseInt(ManipulacijaSaBazom.SelektovanjeProizvodjacIDnaOsnovuImenaProizvodjaca(NazivProizvodjaca));
		
		
		Vector<Lek> SpisakLekova = ManipulacijaSaBazom.SpisakUslovnihNazivaLekova(ProizvodjacID);
		CmbLek.setModel(new DefaultComboBoxModel<>(SpisakLekova));	
		
		
	}
}
