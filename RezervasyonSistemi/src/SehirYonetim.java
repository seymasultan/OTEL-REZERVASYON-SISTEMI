import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SehirYonetim extends JFrame {

	private JPanel contentPane;
	private JTextField sehirEkraný;
	JList sehirList;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SehirYonetim frame = new SehirYonetim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SehirYonetim() {
		setTitle("\u015EEH\u0130R Y\u00D6NET\u0130M EKRANI");
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 34, 292, 193);
		contentPane.add(scrollPane);
		
	    sehirList = new JList();
		scrollPane.setViewportView(sehirList);
		
		JLabel lblehirAd = new JLabel("\u015Eehir Ad\u0131:");
		lblehirAd.setBounds(385, 108, 72, 16);
		contentPane.add(lblehirAd);
		
		sehirEkraný = new JTextField();
		sehirEkraný.setBounds(514, 105, 116, 22);
		contentPane.add(sehirEkraný);
		sehirEkraný.setColumns(10);
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String sehir=sehirEkraný.getText();
					DAO.getInstance().sehirEkle(sehir.toUpperCase());
					sehirGuncelle(DAO.getInstance().sehirleriCek()); 
					JOptionPane.showMessageDialog(null, "Seçtiðiniz þehir eklendi!!");
			}
		});
		btnEkle.setBounds(385, 163, 97, 25);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sehir sehir=(Sehir)sehirList.getSelectedValue();
				int id=sehir.getId();
				DAO.getInstance().sehirSil(id);
				sehirGuncelle(DAO.getInstance().sehirleriCek());
				JOptionPane.showMessageDialog(null, "Seçtiðiniz þehir silindi!!");
			}
		});
		btnSil.setBounds(519, 163, 97, 25);
		contentPane.add(btnSil);
		
		sehirGuncelle(DAO.getInstance().sehirleriCek());
		
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		contentPane.add(label);
	}
	private void sehirGuncelle (List<Sehir> liste) { 
		DefaultListModel<Sehir> listModel = new DefaultListModel<Sehir>() {

			private static final long serialVersionUID = -5820179847193350577L;

			public int getSize() {
				return liste.size();
			}                            //bu fonksiyon her çaðrýldýðýnda müsteri listesi güncellenir.

			public Sehir getElementAt(int i) {
				return liste.get(i);
			}
		};
		sehirList.setModel(listModel);
	}
}
