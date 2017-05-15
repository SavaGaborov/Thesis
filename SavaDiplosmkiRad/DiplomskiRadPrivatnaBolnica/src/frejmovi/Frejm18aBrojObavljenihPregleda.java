package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metode.ManipulacijaSaBazom;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Frejm18aBrojObavljenihPregleda extends JFrame {

	private JPanel contentPane;
	private JTextField TxtOD;
	private JTextField txtDO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm18aBrojObavljenihPregleda frame = new Frejm18aBrojObavljenihPregleda(null);
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
	public Frejm18aBrojObavljenihPregleda(String jmbgLekar) {
		setTitle("Izve\u0161taj broj obavljenih pregleda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrikaiIzvetaj = new JButton("Prika\u017Ei izve\u0161taj");
		btnPrikaiIzvetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom msbp= new ManipulacijaSaBazom();
				
				//ocitani datumi datumi koji ce se koristiti za upit izvestaja
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date PocetniDatum = null;
				Date datumOD=null;
					try{PocetniDatum=df.parse(TxtOD.getText());
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
						
						int RezultatIzvestaja=msbp.IzvestajBrojObavljenihPregleda(datumOD,datumDO);
				
				dispose();
				Frejm18aBrojObavljenihPregledaPrikaz PrikazIzvestaja= new Frejm18aBrojObavljenihPregledaPrikaz(jmbgLekar,RezultatIzvestaja);
				PrikazIzvestaja.setVisible(true);
				
			}
		});
		btnPrikaiIzvetaj.setBackground(Color.BLACK);
		btnPrikaiIzvetaj.setForeground(Color.WHITE);
		btnPrikaiIzvetaj.setBounds(340, 225, 142, 23);
		contentPane.add(btnPrikaiIzvetaj);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Frejm18Izvestaji Izvestaji = new Frejm18Izvestaji(jmbgLekar);
				Izvestaji.setVisible(true);
			}
		});
		btnNazad.setBounds(101, 225, 142, 23);
		contentPane.add(btnNazad);
		
		JLabel lblMolimoVasUnesite = new JLabel("Molimo vas unesite \u017Eeljeni vremenski interval, format datuma je (godina-mesec-dan)");
		lblMolimoVasUnesite.setBounds(44, 43, 546, 14);
		contentPane.add(lblMolimoVasUnesite);
		
		TxtOD = new JTextField();
		TxtOD.setBounds(101, 86, 142, 20);
		contentPane.add(TxtOD);
		TxtOD.setColumns(10);
		
		txtDO = new JTextField();
		txtDO.setBounds(340, 86, 142, 20);
		contentPane.add(txtDO);
		txtDO.setColumns(10);
		
		JLabel lblOd = new JLabel("OD");
		lblOd.setBounds(67, 89, 35, 14);
		contentPane.add(lblOd);
		
		JLabel lblDo = new JLabel("DO");
		lblDo.setBounds(283, 89, 46, 14);
		contentPane.add(lblDo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm18aBrojObavljenihPregleda.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 571, 291);
		contentPane.add(lblNewLabel);
	}
}
