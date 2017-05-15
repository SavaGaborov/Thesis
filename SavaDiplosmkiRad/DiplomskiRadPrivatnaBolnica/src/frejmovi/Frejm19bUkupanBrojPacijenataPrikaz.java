package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metode.ManipulacijaSaBazom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Frejm19bUkupanBrojPacijenataPrikaz extends JFrame {

	private JPanel contentPane;
	private JTextField TxtRezultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm19bUkupanBrojPacijenataPrikaz frame = new Frejm19bUkupanBrojPacijenataPrikaz(null);
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
	public Frejm19bUkupanBrojPacijenataPrikaz(String jmbgLekar) {
		setTitle("Prikaz izve\u0161taja ukupnog broja pacijenata");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrojObavljenihPregleda = new JLabel("Ukupan broj pacijenata za odabrani vremenski interval je:");
		lblBrojObavljenihPregleda.setBounds(48, 34, 402, 14);
		contentPane.add(lblBrojObavljenihPregleda);
		
		TxtRezultat = new JTextField();
		TxtRezultat.setBounds(154, 108, 86, 20);
		contentPane.add(TxtRezultat);
		TxtRezultat.setColumns(10);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm18Izvestaji Izvestaji = new Frejm18Izvestaji(jmbgLekar);
				Izvestaji.setVisible(true);
			}
		});
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setBounds(154, 214, 89, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm19bUkupanBrojPacijenataPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 311);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		int UkupanBrojPacijenata=ManipulacijaSaBazom.IzvestajUkupanBrojPacijenata();
		TxtRezultat.setText(Integer.toString(UkupanBrojPacijenata));
	}

}
