package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Lek;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Frejmb13AžuriranjeLeka extends JFrame {

	public JPanel contentPane;
	private JButton btnAurirajLek;
	private JButton btnNazad;
	private JTextField TxtNazivLeka;
	private JTextField TxtJacinaLeka;
	private JLabel lblNewLabel;
	private JComboBox ComboBoxProizvodjac;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Lek lekovi, String NazivProizvodjaca) {
				try {
					Frejmb13AžuriranjeLeka frame = new Frejmb13AžuriranjeLeka(lekovi, NazivProizvodjaca, null);
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
	 * @param lekovi 
	 * @param nazivProizvodjaca 
	 * @param jmbgLekar 
	 */
	public Frejmb13AžuriranjeLeka(Lek lekovi, String nazivProizvodjaca, String jmbgLekar) {
		setTitle("A\u017Euriranje leka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAurirajLek = new JButton("A\u017Euriraj lek");
		btnAurirajLek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManipulacijaSaBazom mnbp = new ManipulacijaSaBazom();
				
				Lek LekAzuriranje = new Lek();
				
				try {
					
				
				LekAzuriranje.setLekID(lekovi.getLekID());
				LekAzuriranje.setLekID(lekovi.getLekID());
				LekAzuriranje.setNazivLeka(TxtNazivLeka.getText());
				LekAzuriranje.setJacina(TxtJacinaLeka.getText());
				
				boolean AzuriranLek=ManipulacijaSaBazom.AzuriranjeLeka(LekAzuriranje);
				
				if(AzuriranLek)
					JOptionPane.showMessageDialog(null, "Uspešno ste ažurirali podatke o leku");
					dispose();
					Frejm2GlavniMeni Azuriran = new Frejm2GlavniMeni(jmbgLekar);
					Azuriran.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Greška prilikom ažuriranja leka");
				}
					
			}
		});
		btnAurirajLek.setForeground(Color.WHITE);
		btnAurirajLek.setBackground(Color.BLACK);
		btnAurirajLek.setBounds(105, 257, 146, 20);
		contentPane.add(btnAurirajLek);
		
		btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejmb12AžuriranjeLeka Nazad = new Frejmb12AžuriranjeLeka(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setBounds(105, 288, 146, 20);
		contentPane.add(btnNazad);
		
		ComboBoxProizvodjac = new JComboBox(ManipulacijaSaBazom.SpisakProizvodjaca());
		ComboBoxProizvodjac.setBounds(75, 176, 207, 20);
		contentPane.add(ComboBoxProizvodjac);
		
		JLabel label_2 = new JLabel("Proizvo\u0111a\u010D");
		label_2.setBounds(152, 151, 84, 14);
		contentPane.add(label_2);
		label_2.setForeground(Color.BLACK);
		
		TxtJacinaLeka = new JTextField();
		TxtJacinaLeka.setBounds(105, 110, 146, 20);
		contentPane.add(TxtJacinaLeka);
		TxtJacinaLeka.setColumns(10);
		
		JLabel label_1 = new JLabel("Ja\u010Dina");
		label_1.setBounds(161, 85, 46, 14);
		contentPane.add(label_1);
		label_1.setForeground(Color.BLACK);
		
		JLabel label = new JLabel("Naziv leka");
		label.setBounds(152, 27, 84, 14);
		contentPane.add(label);
		label.setForeground(Color.BLACK);
		
		TxtNazivLeka = new JTextField();
		TxtNazivLeka.setBounds(75, 52, 207, 20);
		contentPane.add(TxtNazivLeka);
		TxtNazivLeka.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Frejmb13AžuriranjeLeka.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 360, 319);
		contentPane.add(lblNewLabel);
		
		TxtNazivLeka.setText(lekovi.getNazivLeka());
		TxtJacinaLeka.setText(lekovi.getJacina());
		//TxtJacinaLeka.setText("100mg");
		ComboBoxProizvodjac.setSelectedItem(nazivProizvodjaca);
		
	}
}
