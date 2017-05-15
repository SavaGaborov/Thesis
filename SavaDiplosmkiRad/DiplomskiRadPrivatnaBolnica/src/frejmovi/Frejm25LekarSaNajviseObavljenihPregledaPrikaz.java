package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frejm25LekarSaNajviseObavljenihPregledaPrikaz extends JFrame {

	private JPanel contentPane;
	private JTable TabelaLekaraPregledi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm25LekarSaNajviseObavljenihPregledaPrikaz frame = new Frejm25LekarSaNajviseObavljenihPregledaPrikaz(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param spisakLekaraSaNajvisePregleda 
	 * @param jmbgLekar 
	 */
	public Frejm25LekarSaNajviseObavljenihPregledaPrikaz(String jmbgLekar, DefaultTableModel spisakLekaraSaNajvisePregleda) {
		setTitle("Prikaz izve\u0161taja lekara sa najvi\u0161e obavljenih pregleda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pet lekara sa najvi\u0161e obavljenih pregleda za odabrani vremenski interval je:");
		lblNewLabel.setBounds(23, 33, 467, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm25LekarSaNajviseObavljenihPregleda lekarSaNajvisePregledaNazad = new Frejm25LekarSaNajviseObavljenihPregleda(jmbgLekar);
				lekarSaNajvisePregledaNazad.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(325, 222, 89, 23);
		contentPane.add(btnNewButton);
		
		TabelaLekaraPregledi = new JTable();
		TabelaLekaraPregledi.setBounds(23, 103, 397, 80);
		contentPane.add(TabelaLekaraPregledi);
		
		TabelaLekaraPregledi.setModel(spisakLekaraSaNajvisePregleda);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(23, 78, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(153, 78, 75, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblBrojPregleda = new JLabel("Broj pregleda");
		lblBrojPregleda.setBounds(289, 78, 99, 14);
		contentPane.add(lblBrojPregleda);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Frejm25LekarSaNajviseObavljenihPregledaPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 466, 260);
		contentPane.add(lblNewLabel_1);
	}
}
