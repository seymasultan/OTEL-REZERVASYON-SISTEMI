import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YoneticiEkrani extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiEkrani frame = new YoneticiEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YoneticiEkrani() {
		setTitle("Y\u00D6NET\u0130C\u0130 EKRANI ");
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMteriBilgileriYnetme = new JButton("M\u00DC\u015ETER\u0130 B\u0130LG\u0130LER\u0130N\u0130 Y\u00D6NETME");
		btnMteriBilgileriYnetme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusterýYonetim frame = new MusterýYonetim();
				frame.setVisible(true);
			}
		});
		btnMteriBilgileriYnetme.setBounds(203, 95, 255, 25);
		contentPane.add(btnMteriBilgileriYnetme);
		
		JButton btnOtelBilgileriniYnetme = new JButton("OTEL B\u0130LG\u0130LER\u0130N\u0130 Y\u00D6NETME");
		btnOtelBilgileriniYnetme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtelYonetim frame = new OtelYonetim();
				frame.setVisible(true);
			}
		});
		btnOtelBilgileriniYnetme.setBounds(203, 145, 255, 25);
		contentPane.add(btnOtelBilgileriniYnetme);
		
		JButton btnNewButton = new JButton("\u015EEH\u0130R B\u0130LG\u0130LER\u0130N\u0130 Y\u00D6NETME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehirYonetim frame = new SehirYonetim();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(201, 191, 257, 25);
		contentPane.add(btnNewButton);
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		contentPane.add(label);
	}
}
