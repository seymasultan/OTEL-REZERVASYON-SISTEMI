import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class UyeOl {

	JFrame frmyeOlmaEkran;
	private JTextField ad_ekran�;
	private JTextField soyad_ekran�;
	private JTextField telefon_ekran�;
	private JTextField kimlik_ekran�;
	private JPasswordField parola_ekran�;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeOl window = new UyeOl();
					window.frmyeOlmaEkran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UyeOl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmyeOlmaEkran = new JFrame();
		frmyeOlmaEkran.setTitle("\u00DCYE OLMA EKRANI");
		frmyeOlmaEkran.setBounds(100, 100, 487, 337);
		frmyeOlmaEkran.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADI:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 40, 97, 27);
		frmyeOlmaEkran.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SOYADI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 80, 97, 16);
		frmyeOlmaEkran.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CEP TELEFONU:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 109, 97, 20);
		frmyeOlmaEkran.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("K\u0130ML\u0130K NO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 142, 97, 29);
		frmyeOlmaEkran.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PAROLA:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(12, 203, 97, 27);
		frmyeOlmaEkran.getContentPane().add(lblNewLabel_4);
		
		ad_ekran� = new JTextField();
		ad_ekran�.setBounds(151, 42, 116, 22);
		frmyeOlmaEkran.getContentPane().add(ad_ekran�);
		ad_ekran�.setColumns(10);
		
		soyad_ekran� = new JTextField();
		soyad_ekran�.setBounds(151, 77, 116, 22);
		frmyeOlmaEkran.getContentPane().add(soyad_ekran�);
		soyad_ekran�.setColumns(10);
		
		telefon_ekran� = new JTextField();
		telefon_ekran�.setBounds(151, 108, 116, 22);
		frmyeOlmaEkran.getContentPane().add(telefon_ekran�);
		telefon_ekran�.setColumns(10);
		
		kimlik_ekran� = new JTextField();
		kimlik_ekran�.setBounds(151, 145, 116, 22);
		frmyeOlmaEkran.getContentPane().add(kimlik_ekran�);
		kimlik_ekran�.setColumns(10);
		
		JButton uyeOlBtn = new JButton("\u00DCYE OL");
		uyeOlBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        String ad�=ad_ekran�.getText();
			        String soyad�=soyad_ekran�.getText();
			        String telefon=telefon_ekran�.getText();
			        String kimlik= kimlik_ekran�.getText();
			        String parola=String.valueOf(parola_ekran�.getPassword());
			        if(telefon.length()==11 && kimlik.length()==11) {
			        	  DAO.getInstance().sifreAl(ad�, soyad�, telefon, kimlik, parola);
					        JOptionPane.showMessageDialog(null,"�YE OLUNDU!!");
					        frmyeOlmaEkran.dispose();
					}else
						JOptionPane.showMessageDialog(null,"K�ML�K VEYA TELEFON B�LG�S� HATALI!!!");
			    
			}
		}); 
		uyeOlBtn.setBounds(197, 238, 97, 25);
		frmyeOlmaEkran.getContentPane().add(uyeOlBtn);
		
		parola_ekran� = new JPasswordField();
		parola_ekran�.setBounds(151, 205, 116, 21);
		frmyeOlmaEkran.getContentPane().add(parola_ekran�); 
		
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		frmyeOlmaEkran.getContentPane().add(label);
	}
}
