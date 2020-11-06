import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MusterýYonetim extends JFrame {

	private JPanel contentPane;
	private JTextField mstAd;
	private JTextField mstSoyadý;
	private JTextField mstTelefon;
	private JTextField mstKimlik;
	private JList rezervasyonList;
	private JList musteriList;
	private JTextField kimlikEkraný;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusterýYonetim frame = new MusterýYonetim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MusterýYonetim() {
		setTitle("M\u00DC\u015ETER\u0130 Y\u00D6NET\u0130M EKRANI");
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMteriAd = new JLabel("M\u00FC\u015Fteri Ad\u0131:");
		lblMteriAd.setBounds(404, 39, 94, 16);
		contentPane.add(lblMteriAd);
		
		JLabel lblMteriSoyad = new JLabel("M\u00FC\u015Fteri Soyad\u0131:");
		lblMteriSoyad.setBounds(404, 68, 94, 16);
		contentPane.add(lblMteriSoyad);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(404, 97, 56, 16);
		contentPane.add(lblTelefon);
		
		JLabel lblKimlik = new JLabel("Kimlik:");
		lblKimlik.setBounds(404, 126, 56, 16);
		contentPane.add(lblKimlik);
		
		mstAd = new JTextField();
		mstAd.setBounds(542, 36, 116, 22);
		contentPane.add(mstAd);
		mstAd.setColumns(10);
		
		mstSoyadý = new JTextField();
		mstSoyadý.setBounds(542, 65, 116, 22);
		contentPane.add(mstSoyadý);
		mstSoyadý.setColumns(10);
		
		mstTelefon = new JTextField();
		mstTelefon.setBounds(542, 94, 116, 22);
		contentPane.add(mstTelefon);
		mstTelefon.setColumns(10);
		
		mstKimlik = new JTextField();
		mstKimlik.setBounds(542, 126, 116, 22);
		contentPane.add(mstKimlik);
		mstKimlik.setColumns(10);
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Musteri musteri = (Musteri) musteriList.getSelectedValue();
				DAO.getInstance().musteriSil(musteri.getId());
				musteriGuncelle(DAO.getInstance().musteriListele());
				JOptionPane.showMessageDialog(null,"MÜÞTERÝ SÝLÝNDÝ!!!");
			}
		});
		btnSil.setBounds(542, 171, 97, 25);
		contentPane.add(btnSil);
		
		JButton btnGncelle = new JButton("G\u00DCNCELLE");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Musteri musteri = (Musteri) musteriList.getSelectedValue();
				String ad = mstAd.getText();
				String soyadý = mstSoyadý.getText();
				String telefon = mstTelefon.getText();
				String kimlik = mstKimlik.getText();
				if(telefon.length()==11 && kimlik.length()==11) {
				
					DAO.getInstance().musteriGuncelle(musteri.getId(), ad, soyadý, telefon, kimlik);
					musteriGuncelle(DAO.getInstance().musteriListele());
					JOptionPane.showMessageDialog(null,"MÜÞTERÝ GÜNCELLENDÝ!!!");
				}else
					JOptionPane.showMessageDialog(null,"KÝMLÝK VEYA TELEFON BÝLGÝSÝ HATALI!!!");
			}
		});
		btnGncelle.setBounds(401, 171, 97, 25);
		contentPane.add(btnGncelle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 36, 377, 214);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 262, 377, 50);
		contentPane.add(scrollPane_1);
		rezervasyonList = new JList();
		scrollPane_1.setViewportView(rezervasyonList);
		
		
		musteriList = new JList();
		musteriList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Musteri musteri = (Musteri) musteriList.getSelectedValue();
				musteri=DAO.getInstance().musteriCek(musteri.getId());
				mstAd.setText(musteri.getAd());
				mstSoyadý.setText(musteri.getSoyad());
				mstTelefon.setText(musteri.getTelefon());
				mstKimlik.setText(musteri.getKimlik());
				ArrayList<Rezervasyon> rez = DAO.getInstance().rezervasyonGoruntule(((Musteri) musteriList.getSelectedValue()).getId());
				rezervasyonGüncelle(rez);
			}
		});
		scrollPane.setViewportView(musteriList);
		
		
		
		
		JButton btnAra = new JButton("ARA");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Musteri> musteri=DAO.getInstance().musteriListele();
				String kimlik=kimlikEkraný.getText();
				for(int i=0;i<musteri.size();i++) {
					if(musteri.get(i).getKimlik().equals(kimlik))
						musteriList.setSelectedIndex(i);
				}
			}
		});
		btnAra.setBounds(452, 261, 97, 25);
		contentPane.add(btnAra);
		
		JLabel lblTc = new JLabel("TC K\u0130ML\u0130K:");
		lblTc.setBounds(404, 232, 76, 16);
		contentPane.add(lblTc);
		
		kimlikEkraný = new JTextField();
		kimlikEkraný.setBounds(542, 229, 116, 22);
		contentPane.add(kimlikEkraný);
		kimlikEkraný.setColumns(10);
		
		musteriGuncelle(DAO.getInstance().musteriListele());
		
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		contentPane.add(label);
		
	}
	
	private void musteriGuncelle (List<Musteri> liste) { 
		DefaultListModel<Musteri> listModel = new DefaultListModel<Musteri>() {

			private static final long serialVersionUID = -5820179847193350577L;

			public int getSize() {
				return liste.size();
			}                            //bu fonksiyon her çaðrýldýðýnda müsteri listesi güncellenir.

			public Musteri getElementAt(int i) {
				return liste.get(i);
			}
		};
		musteriList.setModel(listModel);
	}
	
	private void rezervasyonGüncelle(List<Rezervasyon> liste) { 
		DefaultListModel<Rezervasyon> listModel = new DefaultListModel<Rezervasyon>() {
			private static final long serialVersionUID = 6034188603117271249L;

			public int getSize() {
				return liste.size();
			}                       //bu fonksiyon her çaðrýldýðýnda rezervasyon  listesi güncellenir.

			public Rezervasyon getElementAt(int i) {
				return liste.get(i);
			}
		};
		rezervasyonList.setModel(listModel);
	}
}
