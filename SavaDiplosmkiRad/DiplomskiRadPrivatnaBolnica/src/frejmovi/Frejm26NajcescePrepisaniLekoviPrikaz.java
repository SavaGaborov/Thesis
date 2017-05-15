package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Frejm26NajcescePrepisaniLekoviPrikaz extends JFrame {

	private JPanel contentPane;
	private JTable TabelaLekoviIzvestaj;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm26NajcescePrepisaniLekoviPrikaz frame = new Frejm26NajcescePrepisaniLekoviPrikaz(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param spisakNajcescePrepisivanihLekova 
	 * @param jmbgLekar 
	 */
	public Frejm26NajcescePrepisaniLekoviPrikaz(String jmbgLekar, DefaultTableModel spisakNajcescePrepisivanihLekova) {
		setTitle("Prikaz izve\u0161taja naj\u010De\u0161\u0107e prepisanih lekova");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naj\u010De\u0161\u0107e prepisani lekovi za odabrani vremenski interval je:");
		lblNewLabel.setBounds(47, 38, 436, 14);
		contentPane.add(lblNewLabel);
		
		scrollPane_1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(47, 87, 468, 132);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		TabelaLekoviIzvestaj = new JTable();
		scrollPane.setViewportView(TabelaLekoviIzvestaj);
		
		TabelaLekoviIzvestaj.setModel(spisakNajcescePrepisivanihLekova);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm26NajcescePrepisaniLekovi nazad = new Frejm26NajcescePrepisaniLekovi(jmbgLekar);
				nazad.setVisible(true);
			}
		});
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBounds(426, 254, 89, 23);
		contentPane.add(btnNazad);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Frejm26NajcescePrepisaniLekoviPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 563, 317);
		contentPane.add(lblNewLabel_1);
	}

}
