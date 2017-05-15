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

public class Frejm22ProsecanIznosFakturePrikaz extends JFrame {

	private JPanel contentPane;
	private JTextField TxtRezProsecanIznos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm22ProsecanIznosFakturePrikaz frame = new Frejm22ProsecanIznosFakturePrikaz(null, 0);
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
	 * @param rezultatIzvestaja 
	 */
	public Frejm22ProsecanIznosFakturePrikaz(String jmbgLekar, int rezultatIzvestaja) {
		setTitle("Prikaz izve\u0161taja prose\u010Dan iznos fakture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrojObavljenihPregleda = new JLabel("Prose\u010Dan iznos fakture za odabrani vremenski interval je:");
		lblBrojObavljenihPregleda.setBounds(48, 34, 362, 14);
		contentPane.add(lblBrojObavljenihPregleda);
		
		TxtRezProsecanIznos = new JTextField();
		TxtRezProsecanIznos.setBounds(151, 98, 108, 20);
		contentPane.add(TxtRezProsecanIznos);
		TxtRezProsecanIznos.setColumns(10);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm22ProsecanIznosFakture PrometUsluga = new Frejm22ProsecanIznosFakture(jmbgLekar);
				PrometUsluga.setVisible(true);
			}
		});
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBounds(151, 198, 108, 23);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm22ProsecanIznosFakturePrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 410, 287);
		contentPane.add(lblNewLabel);
		
		TxtRezProsecanIznos.setText(Integer.toString(rezultatIzvestaja) + " dinara");
	}

}
