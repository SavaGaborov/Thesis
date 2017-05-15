package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Pacijent;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frejm4AžuriranjePacijenta extends JFrame {

	
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm4AžuriranjePacijenta frame = new Frejm4AžuriranjePacijenta(null);
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
	public Frejm4AžuriranjePacijenta(String jmbgLekar) {
		setTitle("A\u017Euriranje pacijenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMolimoVasOdaberite = new JLabel("Molimo Vas odaberite jmbg  pacijenta kog \u017Eelite da a\u017Eurirate");
		lblMolimoVasOdaberite.setBounds(69, 11, 371, 14);
		contentPane.add(lblMolimoVasOdaberite);
		
		JComboBox CmbPacijent = new JComboBox(ManipulacijaSaBazom.SpisakPacijenata());
		CmbPacijent.setBounds(69, 36, 340, 20);
		contentPane.add(CmbPacijent);
		
		JButton btnDalje = new JButton("Dalje");
		btnDalje.setBackground(Color.BLACK);
		btnDalje.setForeground(Color.WHITE);
		btnDalje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				String PodaciPacijenta= CmbPacijent.getSelectedItem().toString();
				String JmbgIzabranogPacijenta = PodaciPacijenta.substring(0,13);
				
				Pacijent pac = new Pacijent();	// napravi se jedna instanca klase pacijent koja ce primiti ID pacijenta
				
				pac.setJmbgPacijent(JmbgIzabranogPacijenta);	// postavi se selektovani ID na osnovu koga ce se seltkovati u bazi zeljeni pacijent
				
				Pacijent pacijent=msbp.SelektovanjePacijenta(pac);	//nova instanca koja ce setovati selektovane vrednosti a parametar je objekat sa gde je selektovan ID
				
				
				dispose();
				Frejm5AžuriranjePacijenta Napred = new Frejm5AžuriranjePacijenta(pacijent,jmbgLekar);		//prosledi se u sledeci frejm objekat sa selektovanim vrednostima
				Napred.setVisible(true);
			}
		});
		btnDalje.setBounds(161, 212, 140, 23);
		contentPane.add(btnDalje);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm2GlavniMeni Nazad = new Frejm2GlavniMeni(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNewButton.setBounds(161, 254, 140, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Frejm4AžuriranjePacijenta.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 452, 301);
		contentPane.add(lblNewLabel);
	}
}
