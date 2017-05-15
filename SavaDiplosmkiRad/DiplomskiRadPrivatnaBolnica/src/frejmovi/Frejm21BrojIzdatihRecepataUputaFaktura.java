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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frejm21BrojIzdatihRecepataUputaFaktura extends JFrame {

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
					Frejm21BrojIzdatihRecepataUputaFaktura frame = new Frejm21BrojIzdatihRecepataUputaFaktura(null);
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
	public Frejm21BrojIzdatihRecepataUputaFaktura(String jmbgLekar) {
		setTitle("Izve\u0161taj broj izdatih recepata, uputa i faktura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMolimoVasUnesite = new JLabel("Molimo vas unesite \u017Eeljeni vremenski interval, format datuma je (godina-mesec-dan)");
		lblMolimoVasUnesite.setBounds(26, 43, 477, 14);
		contentPane.add(lblMolimoVasUnesite);
		
		txtOD = new JTextField();
		txtOD.setBounds(101, 86, 142, 20);
		contentPane.add(txtOD);
		txtOD.setColumns(10);
		
		txtDO = new JTextField();
		txtDO.setBounds(340, 86, 142, 20);
		contentPane.add(txtDO);
		txtDO.setColumns(10);
		
		JLabel lblOd = new JLabel("OD");
		lblOd.setBounds(44, 89, 46, 14);
		contentPane.add(lblOd);
		
		JLabel lblDo = new JLabel("DO");
		lblDo.setBounds(283, 89, 46, 14);
		contentPane.add(lblDo);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm18Izvestaji Izvestaji = new Frejm18Izvestaji(jmbgLekar);
				Izvestaji.setVisible(true);
			}
		});
		btnNazad.setBounds(101, 225, 142, 23);
		contentPane.add(btnNazad);
		
		JButton btnNewButton = new JButton("Prika\u017Ei izve\u0161taj");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
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
						
						int RezultatIzvestajaRecepti=msbp.IzvestajBrojIzdatihRecepata(datumOD,datumDO);
						
						int RezultatIzvestajaUputi=msbp.IzvestajBrojIzdatihUputa(datumOD,datumDO);
						
						int RezultatIzvestajaFakture=msbp.IzvestajBrojIzdatihFaktura(datumOD,datumDO);
																
						dispose();
						Frejm21BrojIzdatihRecepataUputaFakturaPrikaz PrikazIzvestaja= new Frejm21BrojIzdatihRecepataUputaFakturaPrikaz(jmbgLekar, RezultatIzvestajaRecepti, RezultatIzvestajaUputi, RezultatIzvestajaFakture);
						PrikazIzvestaja.setVisible(true);
						
			}
		});
		btnNewButton.setBounds(340, 225, 142, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm21BrojIzdatihRecepataUputaFaktura.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 575, 300);
		contentPane.add(lblNewLabel);
	}

}
