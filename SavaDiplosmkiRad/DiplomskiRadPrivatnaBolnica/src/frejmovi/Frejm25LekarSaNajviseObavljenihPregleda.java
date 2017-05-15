package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class Frejm25LekarSaNajviseObavljenihPregleda extends JFrame {

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
					Frejm25LekarSaNajviseObavljenihPregleda frame = new Frejm25LekarSaNajviseObavljenihPregleda(null);
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
	public Frejm25LekarSaNajviseObavljenihPregleda(String jmbgLekar) {
		setTitle("Izve\u0161taj lekari sa najvi\u0161e obavljenih pregleda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Molimo vas unesite \u017Eeljeni vremenski interval, format datuma je (godina-mesec-dan)");
		lblNewLabel.setBounds(64, 44, 501, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblOd = new JLabel("OD");
		lblOd.setBounds(64, 92, 46, 14);
		contentPane.add(lblOd);
		
		JLabel lblDo = new JLabel("DO");
		lblDo.setBounds(275, 92, 46, 14);
		contentPane.add(lblDo);
		
		txtOD = new JTextField();
		txtOD.setBounds(101, 89, 142, 20);
		contentPane.add(txtOD);
		txtOD.setColumns(10);
		
		txtDO = new JTextField();
		txtDO.setBounds(340, 89, 142, 20);
		contentPane.add(txtDO);
		txtDO.setColumns(10);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Frejm18Izvestaji Izvestaji = new Frejm18Izvestaji(jmbgLekar);
				Izvestaji.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(101, 225, 142, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Prika\u017Ei izve\u0161taj");
		btnNewButton_1.addActionListener(new ActionListener() {
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
						
						DefaultTableModel SpisakLekaraSaNajvisePregleda=msbp.IzvestajLekariSaNajvisePregleda(datumOD,datumDO);
						
				
				dispose();
				Frejm25LekarSaNajviseObavljenihPregledaPrikaz IzvestajiNajcescaOboljenja = new Frejm25LekarSaNajviseObavljenihPregledaPrikaz(jmbgLekar, SpisakLekaraSaNajvisePregleda);
				IzvestajiNajcescaOboljenja.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(340, 225, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Frejm25LekarSaNajviseObavljenihPregleda.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 565, 306);
		contentPane.add(lblNewLabel_1);
	}

}
