import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class GiriþEkraný {

	private JFrame frmGiriEkran;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiriþEkraný window = new GiriþEkraný();
					window.frmGiriEkran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiriþEkraný() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGiriEkran = new JFrame();
		frmGiriEkran.setTitle("G\u0130R\u0130\u015E EKRANI");
		frmGiriEkran.setBounds(100, 100,600,400); 
		frmGiriEkran.getContentPane().setLayout(null); 
		
		JButton üyeOlButon = new JButton("\u00DCYE OL");
		üyeOlButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		});
		
		üyeOlButon.setBounds(177, 85, 210, 43);
		frmGiriEkran.getContentPane().add(üyeOlButon);
		
		JButton üyeGiriþiButon = new JButton("\u00DCYE G\u0130R\u0130\u015E\u0130");
		üyeGiriþiButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UyeGiriþi window = new UyeGiriþi();
							window.frmyeGiriEkran.setVisible(true); 
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		üyeGiriþiButon.setBounds(177, 141, 210, 42);
		frmGiriEkran.getContentPane().add(üyeGiriþiButon);
		
		JButton yöneticiButon = new JButton("Y\u00D6NET\u0130C\u0130 G\u0130R\u0130\u015E\u0130");
		yöneticiButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		yöneticiButon.setBounds(177, 207, 210, 39);
		frmGiriEkran.getContentPane().add(yöneticiButon);
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,582, 353);
		frmGiriEkran.getContentPane().add(label);
		
		
	}
}
