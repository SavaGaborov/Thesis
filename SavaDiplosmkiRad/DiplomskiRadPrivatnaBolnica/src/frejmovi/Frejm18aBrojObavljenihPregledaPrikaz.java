package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frejm18aBrojObavljenihPregledaPrikaz extends JFrame {

	private JPanel contentPane;
	private JTextField textRezultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm18aBrojObavljenihPregledaPrikaz frame = new Frejm18aBrojObavljenihPregledaPrikaz(null, 0);
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
	public Frejm18aBrojObavljenihPregledaPrikaz(String jmbgLekar, int rezultatIzvestaja) {
		setTitle("Prikaz izve\u0161taja broja obavljenih pregleda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrojObavljenihPregleda = new JLabel("Broj obavljenih pregleda za odabrani vremenski interval je:");
		lblBrojObavljenihPregleda.setBounds(48, 34, 400, 14);
		contentPane.add(lblBrojObavljenihPregleda);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm18aBrojObavljenihPregleda BrObavljenihPregleda = new Frejm18aBrojObavljenihPregleda(jmbgLekar);
				BrObavljenihPregleda.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(154, 214, 89, 23);
		contentPane.add(btnNewButton);
		
		textRezultat = new JTextField();
		textRezultat.setBounds(154, 99, 86, 20);
		contentPane.add(textRezultat);
		textRezultat.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm18aBrojObavljenihPregledaPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 428, 298);
		contentPane.add(lblNewLabel);
		
		textRezultat.setText(Integer.toString(rezultatIzvestaja));
	}

}
