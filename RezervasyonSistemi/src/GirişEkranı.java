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

public class Giri�Ekran� {

	private JFrame frmGiriEkran;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giri�Ekran� window = new Giri�Ekran�();
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
	public Giri�Ekran�() {
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
		
		JButton �yeOlButon = new JButton("\u00DCYE OL");
		�yeOlButon.addActionListener(new ActionListener() {
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
		
		�yeOlButon.setBounds(177, 85, 210, 43);
		frmGiriEkran.getContentPane().add(�yeOlButon);
		
		JButton �yeGiri�iButon = new JButton("\u00DCYE G\u0130R\u0130\u015E\u0130");
		�yeGiri�iButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		});
		�yeGiri�iButon.setBounds(177, 141, 210, 42);
		frmGiriEkran.getContentPane().add(�yeGiri�iButon);
		
		JButton y�neticiButon = new JButton("Y\u00D6NET\u0130C\u0130 G\u0130R\u0130\u015E\u0130");
		y�neticiButon.addActionListener(new ActionListener() {
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
		y�neticiButon.setBounds(177, 207, 210, 39);
		frmGiriEkran.getContentPane().add(y�neticiButon);
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,582, 353);
		frmGiriEkran.getContentPane().add(label);
		
		
	}
}
