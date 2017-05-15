package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entiteti.Lekar;
import metode.ManipulacijaSaBazom;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frejm9AžuriranjeLekara extends JFrame {

	public JPanel contentPane;
	public JComboBox ComboBoxLekar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm9AžuriranjeLekara frame = new Frejm9AžuriranjeLekara(null);
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
	public Frejm9AžuriranjeLekara(String jmbgLekar) {
		setTitle("A\u017Euriranje lekara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ComboBoxLekar = new JComboBox(ManipulacijaSaBazom.SpisakLekara());
		ComboBoxLekar.setBounds(70, 59, 335, 20);
		contentPane.add(ComboBoxLekar);
		
		JLabel lblMolimoVasOdaberite = new JLabel("Molimo Vas odaberite jmbg Lekara kojeg \u017Eelite da a\u017Eurirate");
		lblMolimoVasOdaberite.setBounds(70, 21, 426, 14);
		contentPane.add(lblMolimoVasOdaberite);
		
		JButton btnNewButton = new JButton("Dalje");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom msbp = new ManipulacijaSaBazom();
				
				String PodaciIzKomboBoksa=ComboBoxLekar.getSelectedItem().toString();
				
				String JmbgLekara= PodaciIzKomboBoksa.substring(0,13);
				
				Lekar dr= new Lekar();
				dr.setJmbgLekar(JmbgLekara);
				
				
				Lekar lekar=msbp.SelektovanjeLekara(dr);
				
				
				dispose();
				Frejmb10AžuriranjeLekara Napred = new Frejmb10AžuriranjeLekara(lekar,jmbgLekar);
				Napred.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(160, 260, 140, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm2GlavniMeni Nazad = new Frejm2GlavniMeni(jmbgLekar);
				Nazad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(160, 293, 140, 20);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Frejm9AžuriranjeLekara.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 458, 340);
		contentPane.add(lblNewLabel);
	}

}
