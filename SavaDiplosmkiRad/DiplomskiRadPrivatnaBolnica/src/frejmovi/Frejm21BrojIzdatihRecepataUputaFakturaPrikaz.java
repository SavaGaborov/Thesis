package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Frejm21BrojIzdatihRecepataUputaFakturaPrikaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtUputiRez;
	private JTextField txtReceptiRez;
	private JTextField txtFaktureRez;
	private JLabel lblNewLabel_1;
	private JLabel lblUputi;
	private JLabel lblFakture;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm21BrojIzdatihRecepataUputaFakturaPrikaz frame = new Frejm21BrojIzdatihRecepataUputaFakturaPrikaz(null, 0, 0, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param rezultatIzvestajaRecepti 
	 * @param jmbgLekar 
	 * @param rezultatIzvestajaUputi 
	 * @param rezultatIzvestajaFakture 
	 */
	public Frejm21BrojIzdatihRecepataUputaFakturaPrikaz(String jmbgLekar, int rezultatIzvestajaRecepti, int rezultatIzvestajaUputi, int rezultatIzvestajaFakture) {
		setTitle("Prikaz izve\u0161taja broja izdatih recepata, uputa i faktura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Broj izdatih recepata, uputa i faktura za odabrani vremenski interval je:");
		lblNewLabel.setBounds(29, 26, 461, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm21BrojIzdatihRecepataUputaFaktura IzdatiReceptiUputiFakture = new Frejm21BrojIzdatihRecepataUputaFaktura(jmbgLekar);
				IzdatiReceptiUputiFakture.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(181, 233, 89, 23);
		contentPane.add(btnNewButton);
		
		txtUputiRez = new JTextField();
		txtUputiRez.setBounds(181, 114, 86, 20);
		contentPane.add(txtUputiRez);
		txtUputiRez.setColumns(10);
		
		txtReceptiRez = new JTextField();
		txtReceptiRez.setBounds(29, 114, 86, 20);
		contentPane.add(txtReceptiRez);
		txtReceptiRez.setColumns(10);
		
		txtFaktureRez = new JTextField();
		txtFaktureRez.setBounds(338, 113, 86, 20);
		contentPane.add(txtFaktureRez);
		txtFaktureRez.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Recepti");
		lblNewLabel_1.setBounds(54, 93, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		lblUputi = new JLabel("Uputi");
		lblUputi.setBounds(203, 93, 89, 14);
		contentPane.add(lblUputi);
		
		lblFakture = new JLabel("Fakture");
		lblFakture.setBounds(359, 93, 85, 14);
		contentPane.add(lblFakture);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Frejm21BrojIzdatihRecepataUputaFakturaPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 461, 306);
		contentPane.add(lblNewLabel_2);
		
		txtReceptiRez.setText(Integer.toString(rezultatIzvestajaRecepti));
		txtUputiRez.setText(Integer.toString(rezultatIzvestajaUputi));
		txtFaktureRez.setText(Integer.toString(rezultatIzvestajaFakture));
	}

}
