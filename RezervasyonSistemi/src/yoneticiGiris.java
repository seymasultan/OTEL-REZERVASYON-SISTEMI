import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class yoneticiGiris extends JFrame {

	private JPanel contentPane;
	private JTextField ad_ekran�;
	private JPasswordField parola_ekran�;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yoneticiGiris frame = new yoneticiGiris();
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
	public yoneticiGiris() {
		setTitle("Y\u00D6NET\u0130C\u0130 G\u0130R\u0130\u015E EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ad_ekran� = new JTextField();
		ad_ekran�.setBounds(161, 85, 116, 22);
		contentPane.add(ad_ekran�);
		ad_ekran�.setColumns(10);
		
		JLabel lblYneticiAd = new JLabel("Y\u00F6netici Ad\u0131:");
		lblYneticiAd.setBounds(34, 88, 85, 16);
		contentPane.add(lblYneticiAd);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setBounds(34, 133, 56, 16);
		contentPane.add(lblParola);
		
		parola_ekran� = new JPasswordField();
		parola_ekran�.setBounds(162, 133, 115, 22);
		contentPane.add(parola_ekran�);
		
		JButton btnGiriYap = new JButton("G\u0130R\u0130\u015E YAP ");
		btnGiriYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = ad_ekran�.getText();
				String parola= String.valueOf(parola_ekran�.getPassword()); //getPassword char ald���ndan Stringe d�n��t�r�yoruz
			        
				DAO dao= DAO.getInstance();
			        
				Yonetici yonetici=dao.yoneticiGiris(ad,parola);  
				if(yonetici!=null) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								YoneticiEkrani frame=new YoneticiEkrani();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace(); 
							}
						}
					});			
				}
				else
				       JOptionPane.showMessageDialog(null, "�sim veya parola yanl��!");
				dispose();			
			}
		});
		btnGiriYap.setBounds(92, 179, 97, 25);
		contentPane.add(btnGiriYap);
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		contentPane.add(label);
	}
}
