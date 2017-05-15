package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Faktura;
import entiteti.Pacijent;
import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Frejm7IstorijatLecenja extends JFrame {

	public JPanel contentPane;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTable TebelaBolesti;
	private JTable TabelaUsluga;
	private String JmbgPacijent;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Pacijent Pacijent) {
				try {
					Frejm7IstorijatLecenja frame = new Frejm7IstorijatLecenja(null, null, 0, 0, 0, 0, null, null);
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
	 * @param dodateUsluge 
	 * @param dodateBolesti 
	 * @param fakturaID 
	 * @param pregledID 
	 * @param brojacBolest 
	 * @param brojacUsluga 
	 * @param jmbgLekar 
	 * @param pacijent 
	 * @param dodateUsluge 
	 * @param dodateBolesti 
	 * @param fakturaID 
	 * @param pregledID 
	 * @param jmbgLekar 
	 * @param pacijent 
	  
	  
	 */
	public Frejm7IstorijatLecenja(Pacijent pacijent, String jmbgLekar, int brojacUsluga, int brojacBolest, int pregledID, int fakturaID, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
		setTitle("Istorijat le\u010Denja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(10, 21, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(10, 58, 103, 14);
		contentPane.add(lblPrezime);
		
		textIme = new JTextField();
		textIme.setEditable(false);
		textIme.setBounds(10, 34, 103, 20);
		contentPane.add(textIme);
		textIme.setColumns(10);
		
		textPrezime = new JTextField();
		textPrezime.setEditable(false);
		textPrezime.setBounds(10, 73, 103, 20);
		contentPane.add(textPrezime);
		textPrezime.setColumns(10);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				Frejm6aPregled Nazad = new Frejm6aPregled(pacijent, jmbgLekar, pregledID, fakturaID, null , dodateBolesti, dodateUsluge);
				Nazad.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(500, 386, 89, 23);
		contentPane.add(btnNewButton);
		
		textIme.setText(pacijent.getIme());
		textPrezime.setText(pacijent.getPrezime());
		
		JmbgPacijent=pacijent.getJmbgPacijent();
		
		DefaultTableModel IstorijatBolesti=ManipulacijaSaBazom.SelektovanjeBolestiZaIstorijatLecenja(JmbgPacijent);	
		
		DefaultTableModel IstorijatUsluga=ManipulacijaSaBazom.SelektovanjeUslugaZaIstorijatLecenja(JmbgPacijent);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 112, 475, 135);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		TebelaBolesti = new JTable();
		scrollPane.setViewportView(TebelaBolesti);
		TebelaBolesti.setModel(IstorijatBolesti);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 274, 475, 135);
		contentPane.add(scrollPane_3);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_3.setViewportView(scrollPane_2);
		
		TabelaUsluga = new JTable();
		scrollPane_2.setViewportView(TabelaUsluga);
		TabelaUsluga.setModel(IstorijatUsluga);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm7IstorijatLecenja.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 599, 428);
		contentPane.add(lblNewLabel);
		
		
			}
}
