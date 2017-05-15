package frejmovi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Frejm24NajcescaOboljenjaPrikaz extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frejm24NajcescaOboljenjaPrikaz frame = new Frejm24NajcescaOboljenjaPrikaz(null, null);
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
	 * @param spisakNajcescihOboljenja 
	 */
	public Frejm24NajcescaOboljenjaPrikaz(String jmbgLekar, DefaultTableModel spisakNajcescihOboljenja) {
		setTitle("Prikaz izve\u0161taja naj\u010De\u0161\u0107ih oboljenja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZaDa = new JLabel("Naj\u010De\u0161\u0107a oboljenja za odabrani vremenski interval su:");
		lblZaDa.setBounds(54, 32, 404, 14);
		contentPane.add(lblZaDa);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				Frejm24NajcescaOboljenja NajcescaOboljenja = new Frejm24NajcescaOboljenja(jmbgLekar);
				NajcescaOboljenja.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(414, 277, 111, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(54, 68, 471, 165);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(spisakNajcescihOboljenja);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frejm24NajcescaOboljenjaPrikaz.class.getResource("/frejmovi/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 562, 335);
		contentPane.add(lblNewLabel);
	}
	

}
