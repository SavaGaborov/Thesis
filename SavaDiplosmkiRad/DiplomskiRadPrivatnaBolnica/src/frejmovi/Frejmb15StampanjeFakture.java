package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entiteti.Faktura;
import entiteti.Pacijent;
import metode.ManipulacijaSaBazom;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class Frejmb15StampanjeFakture extends JFrame {

	private JPanel contentPane;
	private JLabel LblImePacijenta;
	private JLabel LblPrezimePacijenta;
	private JLabel LbLJmbg;
	private JLabel LblPTT;
	private JLabel LbLMestoStanovanja;
	private JLabel LbLUlicaIbroj;
	private JLabel LbLFakturaID;
	private JLabel lblBrojTelefona;
	private JLabel LblDatum;
	private JLabel LblUkupno;
	private JLabel LblUkupnoIznos;
	private JTable TabelaStavkiFakture;
	int UkupanIznos;
	private JLabel lblNewLabel_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejmb15StampanjeFakture frame = new Frejmb15StampanjeFakture(null, null, 0, 0, 0, 0, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param fakturaID 
	 * @param pregledID 
	 * @param brojacBolest 
	 * @param brojacUsluga 
	 * @param jmbgLekar 
	 * @param pacijent 
	 * @param dodateUsluge 
	 * @param dodateBolesti 
	 */
	public Frejmb15StampanjeFakture(Pacijent pacijent, String jmbgLekar, int brojacUsluga, int brojacBolest, int pregledID, int fakturaID, DefaultTableModel dodateBolesti, DefaultTableModel dodateUsluge) {
		setTitle("\u0160tampanje i evidentiranje fakture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setBackground(Color.BLACK);
		btnNazad.setForeground(Color.WHITE);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				dispose();																								
				Frejm15IzdavanjeFakture Faktura = new Frejm15IzdavanjeFakture(pacijent, jmbgLekar, brojacUsluga, brojacBolest, pregledID, fakturaID, dodateBolesti, dodateUsluge);
				Faktura.setVisible(true);
			}
		});
		btnNazad.setBounds(58, 573, 89, 23);
		contentPane.add(btnNazad);
		
		JButton btntampajIEvidentiraj = new JButton("\u0160tampaj i evidentiraj fakturu");
		btntampajIEvidentiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManipulacijaSaBazom mnbp = new ManipulacijaSaBazom();
				
				Faktura faktura = new Faktura();
				
				faktura.setFakturaID(fakturaID);
				faktura.setPregledID(pregledID);
				faktura.setIznosFakture(UkupanIznos);
				
				boolean IspostavljenaFaktura=ManipulacijaSaBazom.IspostavljanjeFakture(faktura);
				
				
				dispose();
				Frejm2GlavniMeni GlavniMeni = new Frejm2GlavniMeni(jmbgLekar);
				GlavniMeni.setVisible(true);
				
			}
		});
		btntampajIEvidentiraj.setBackground(Color.BLACK);
		btntampajIEvidentiraj.setForeground(Color.WHITE);
		btntampajIEvidentiraj.setBounds(407, 573, 198, 23);
		contentPane.add(btntampajIEvidentiraj);
		
		LblImePacijenta = new JLabel("New label");
		LblImePacijenta.setBounds(204, 228, 89, 14);
		contentPane.add(LblImePacijenta);
		
		LblPrezimePacijenta = new JLabel("New label");
		LblPrezimePacijenta.setBounds(284, 228, 89, 14);
		contentPane.add(LblPrezimePacijenta);
		
		LbLJmbg = new JLabel("New label");
		LbLJmbg.setBounds(166, 247, 151, 14);
		contentPane.add(LbLJmbg);
		
		LblPTT = new JLabel("");
		LblPTT.setBounds(204, 265, 109, 14);
		contentPane.add(LblPTT);
		
		LbLMestoStanovanja = new JLabel("New label");
		LbLMestoStanovanja.setBounds(310, 265, 85, 14);
		contentPane.add(LbLMestoStanovanja);
		
		LbLUlicaIbroj = new JLabel("New label");
		LbLUlicaIbroj.setBounds(176, 280, 151, 14);
		contentPane.add(LbLUlicaIbroj);
		
		LbLFakturaID = new JLabel("New label");
		LbLFakturaID.setBounds(548, 96, 46, 14);
		contentPane.add(LbLFakturaID);
		
		
		lblBrojTelefona = new JLabel("");
		lblBrojTelefona.setBounds(152, 298, 141, 14);
		contentPane.add(lblBrojTelefona);
		
		LblImePacijenta.setText(pacijent.getIme());
		LblPrezimePacijenta.setText(pacijent.getPrezime());
		LbLJmbg.setText(pacijent.getJmbgPacijent());
		LblPTT.setText(Integer.toString(pacijent.getPTT()));
		
		int PTT=pacijent.getPTT();
		String NazivMesta=ManipulacijaSaBazom.VracanjeNazivaMestaNaOsnovuPTT(PTT);
		LbLMestoStanovanja.setText(NazivMesta);
		
		
		LbLUlicaIbroj.setText(pacijent.getUlicaiBroj());
		LbLFakturaID.setText(Integer.toString(fakturaID));
		
		lblBrojTelefona.setText(pacijent.getBrojTelefona());
		
		LblDatum = new JLabel("");
		LblDatum.setBounds(529, 113, 76, 14);
		contentPane.add(LblDatum);
		
		LblUkupno = new JLabel("Ukupno:");
		LblUkupno.setFont(new Font("Tahoma", Font.BOLD, 11));
		LblUkupno.setBounds(481, 524, 76, 14);
		contentPane.add(LblUkupno);
		
		LblUkupnoIznos = new JLabel("");
		LblUkupnoIznos.setBounds(529, 524, 82, 14);
		contentPane.add(LblUkupnoIznos);
		
		TabelaStavkiFakture = new JTable();
		TabelaStavkiFakture.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		TabelaStavkiFakture.setBackground(Color.WHITE);
		TabelaStavkiFakture.setToolTipText("");
		TabelaStavkiFakture.setBounds(70, 347, 519, 166);
		contentPane.add(TabelaStavkiFakture);
		
		Calendar cal = new GregorianCalendar();
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		
		LblDatum.setText(day + "/" + month + "/" + year);
		
		DefaultTableModel StavkeFakture=ManipulacijaSaBazom.SelektovanjeUslugaZaTabelu(pregledID);
		TabelaStavkiFakture.setModel(StavkeFakture);
		
		UkupanIznos=ManipulacijaSaBazom.ObracunUkupnogIznosaFakture(pregledID, fakturaID);
		LblUkupnoIznos.setText(Integer.toString(UkupanIznos));
		
		JLabel lblNewLabel_2 = new JLabel("Stavke fakture:");
		lblNewLabel_2.setBounds(70, 332, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejmb15StampanjeFakture.class.getResource("/frejmovi/FakturaTemplateSlika.png")));
		lblNewLabel.setBounds(58, 41, 554, 508);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Frejmb15StampanjeFakture.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 639, 618);
		contentPane.add(lblNewLabel_1);
	}
}
