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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Frejm22ProsecanIznosFakture extends JFrame {

	private JPanel contentPane;
	private JTextField txtOD;
	private JTextField txtDO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm22ProsecanIznosFakture frame = new Frejm22ProsecanIznosFakture(null);
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
	public Frejm22ProsecanIznosFakture(String jmbgLekar) {
		setTitle("Izve\u0161taj prose\u010Dan iznos fakture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Molimo vas unesite \u017Eeljeni vremenski interval, format datuma je (godina-mesec-dan)");
		lblNewLabel.setBounds(33, 40, 499, 14);
		contentPane.add(lblNewLabel);
		
		txtOD = new JTextField();
		txtOD.setBounds(101, 89, 142, 20);
		contentPane.add(txtOD);
		txtOD.setColumns(10);
		
		txtDO = new JTextField();
		txtDO.setColumns(10);
		txtDO.setBounds(327, 89, 142, 20);
		contentPane.add(txtDO);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm18Izvestaji Izvestaji = new Frejm18Izvestaji(jmbgLekar);
				Izvestaji.setVisible(true);
			}
		});
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.setBounds(101, 225, 142, 23);
		contentPane.add(btnNazad);
		
		JButton btnPrikaiIzvetaj = new JButton("Prika\u017Ei izve\u0161taj");
		btnPrikaiIzvetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom msbp= new ManipulacijaSaBazom();
				
				//ocitani datumi datumi koji ce se koristiti za upit izvestaja
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date PocetniDatum = null;
				Date datumOD=null;
					try{PocetniDatum=df.parse(txtOD.getText());
						datumOD = new Date (PocetniDatum.getTime());
					}catch(Exception e1){
						e1.printStackTrace();
					}
					
					
					java.util.Date KranjiDatum = null;
					Date datumDO=null;
						try{KranjiDatum=df.parse(txtDO.getText());
							datumDO = new Date (KranjiDatum.getTime());
						}catch(Exception e2){
							e2.printStackTrace();
						}
						
						int RezultatIzvestaja=msbp.IzvestajProsecanIznosFakture(datumOD,datumDO);
				
				dispose();
				Frejm22ProsecanIznosFakturePrikaz PrikazIzvestaja = new Frejm22ProsecanIznosFakturePrikaz(jmbgLekar, RezultatIzvestaja);
				PrikazIzvestaja.setVisible(true);
			}
		});
		btnPrikaiIzvetaj.setBackground(Color.BLACK);
		btnPrikaiIzvetaj.setForeground(Color.WHITE);
		btnPrikaiIzvetaj.setBounds(327, 225, 142, 23);
		contentPane.add(btnPrikaiIzvetaj);
		
		JLabel lblOd = new JLabel("OD");
		lblOd.setBounds(60, 89, 46, 14);
		contentPane.add(lblOd);
		
		JLabel lblDo = new JLabel("DO");
		lblDo.setBounds(286, 89, 46, 14);
		contentPane.add(lblDo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Frejm22ProsecanIznosFakture.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 569, 288);
		contentPane.add(lblNewLabel_1);
	}

}