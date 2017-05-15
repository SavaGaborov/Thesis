package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frejm20bPrometUslugaPrikaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtRezultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm20bPrometUslugaPrikaz frame = new Frejm20bPrometUslugaPrikaz(null,0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param rezultatIzvestaja 
	 * @param jmbgLekar 
	 */
	public Frejm20bPrometUslugaPrikaz(String jmbgLekar, int rezultatIzvestaja) {
		setTitle("Prikaz izve\u0161taja promet usluga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrojObavljenihPregleda = new JLabel("Promet usluga za odabrani vremenski interval je:");
		lblBrojObavljenihPregleda.setBounds(81, 52, 326, 14);
		contentPane.add(lblBrojObavljenihPregleda);
		
		txtRezultat = new JTextField();
		txtRezultat.setBounds(145, 108, 128, 20);
		contentPane.add(txtRezultat);
		txtRezultat.setColumns(10);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm20PrometUsluga PrometUsluga = new Frejm20PrometUsluga(jmbgLekar);
				PrometUsluga.setVisible(true);
			}
		});
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBounds(145, 215, 128, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm20bPrometUslugaPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
		
		txtRezultat.setText(rezultatIzvestaja + " dinara");
	}

}
