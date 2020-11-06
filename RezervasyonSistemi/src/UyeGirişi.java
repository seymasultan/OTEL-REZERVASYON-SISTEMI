import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UyeGiri�i {

	JFrame frmyeGiriEkran;
	private JTextField kimlik_giri�;
	private JPasswordField parola_giri�;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeGiri�i window = new UyeGiri�i();
					window.frmyeGiriEkran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UyeGiri�i() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmyeGiriEkran = new JFrame();
		frmyeGiriEkran.setTitle("\u00DCYE G\u0130R\u0130\u015E EKRANI");
		frmyeGiriEkran.setBounds(100, 100, 450, 300);
		frmyeGiriEkran.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("K\u0130ML\u0130K NO:");
		lblNewLabel.setBounds(27, 69, 86, 27);
		frmyeGiriEkran.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PAROLA:");
		lblNewLabel_1.setBounds(27, 109, 86, 27);
		frmyeGiriEkran.getContentPane().add(lblNewLabel_1);
		
		kimlik_giri� = new JTextField();
		kimlik_giri�.setBounds(144, 71, 116, 22);
		frmyeGiriEkran.getContentPane().add(kimlik_giri�);
		kimlik_giri�.setColumns(10);
		
		parola_giri� = new JPasswordField();
		parola_giri�.setBounds(144, 111, 116, 25);
		frmyeGiriEkran.getContentPane().add(parola_giri�);
		
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E YAP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String kimlik = kimlik_giri�.getText();
				String parola= String.valueOf(parola_giri�.getPassword()); //getPassword char ald���ndan Stringe d�n��t�r�yoruz
			        
				DAO dao= DAO.getInstance();
			        
				Musteri musteri=dao.girisYap(kimlik, parola); 
				if(musteri!=null) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								RezervasyonEkran� window = new RezervasyonEkran�();
								window.frmRezervasyonEkran.setVisible(true);   
							} catch (Exception e) {
								e.printStackTrace(); 
							}
						}
					});			
				}
				else
				 JOptionPane.showMessageDialog(null, "T.C. kimlik veya parola yanl��!");

			}
		});
		btnNewButton.setBounds(81, 173, 97, 25);
		frmyeGiriEkran.getContentPane().add(btnNewButton);
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		frmyeGiriEkran.getContentPane().add(label);
	}

}
