import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import oracle.sql.DATE;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;

public class RezervasyonEkraný {

	JFrame frmRezervasyonEkran;
	private List<Otel> oteller;
	private List<Sehir> sehirler;
	private List<Oda> odalar;
	JComboBox<Sehir> sehirler_ekraný;
	JComboBox<Otel> oteller_ekraný;
	protected JDatePickerImpl datePicker;
	protected JDatePickerImpl datePicker2;
	private JTextField topFiyat;
	private JTextField tekGece;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervasyonEkraný window = new RezervasyonEkraný();
					window.frmRezervasyonEkran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RezervasyonEkraný() {
		initialize();

		DAO dao = DAO.getInstance();

		sehirler_ekraný = new JComboBox<>();
		sehirler_ekraný.setBounds(133, 63, 185, 22);
		frmRezervasyonEkran.getContentPane().add(sehirler_ekraný);
		
		tekGece = new JTextField();
		tekGece.setEditable(false);
		tekGece.setColumns(10);
		tekGece.setBounds(518, 98, 104, 22);
		frmRezervasyonEkran.getContentPane().add(tekGece);
		
		topFiyat = new JTextField();
		topFiyat.setEditable(false);
		topFiyat.setBounds(518, 133, 104, 22);
		frmRezervasyonEkran.getContentPane().add(topFiyat);
		topFiyat.setColumns(10);
		
		JComboBox oda_ekraný = new JComboBox<String>();
		oda_ekraný.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int[] fiyatListesi = {150,250,400,500};
				int i = oda_ekraný.getSelectedIndex();
				tekGece.setText(""+ fiyatListesi[i]);
			}
		});
		oda_ekraný.setBounds(133, 133, 185, 22);
		frmRezervasyonEkran.getContentPane().add(oda_ekraný);
		oda_ekraný.addItem("Tek Kiþilik");
		oda_ekraný.addItem("Ýki Kiþilik");
		oda_ekraný.addItem("Üç Kiþilik");
		oda_ekraný.addItem("Dört Kiþilik");

		oteller_ekraný = new JComboBox<>();
		oteller_ekraný.setBounds(133, 98, 185, 22);
		frmRezervasyonEkran.getContentPane().add(oteller_ekraný);
		
		JLabel lblehirler = new JLabel("\u015EEH\u0130RLER:");
		lblehirler.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblehirler.setBounds(12, 66, 109, 22);
		frmRezervasyonEkran.getContentPane().add(lblehirler);
		
		JLabel lblOteller = new JLabel("OTELLER:");
		lblOteller.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOteller.setBounds(12, 101, 81, 16);
		frmRezervasyonEkran.getContentPane().add(lblOteller);
		
		JLabel lblOdaTipi = new JLabel("ODA T\u0130P\u0130:");
		lblOdaTipi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOdaTipi.setBounds(12, 135, 81, 19);
		frmRezervasyonEkran.getContentPane().add(lblOdaTipi);
		
		JLabel lblGiriTarihi = new JLabel("G\u0130R\u0130\u015E TAR\u0130H\u0130:");
		lblGiriTarihi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiriTarihi.setBounds(12, 206, 109, 29);
		frmRezervasyonEkran.getContentPane().add(lblGiriTarihi);
		
		JLabel lblkTarihi = new JLabel("\u00C7IKI\u015E TAR\u0130H\u0130:");
		lblkTarihi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblkTarihi.setBounds(12, 264, 109, 29);
		frmRezervasyonEkran.getContentPane().add(lblkTarihi);
		
		UtilDateModel model = new UtilDateModel();
		Calendar cal = Calendar.getInstance();
		model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		model.setSelected(true);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) datePicker.getModel().getValue()); 
				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime((Date) datePicker2.getModel().getValue());
				
				int fark = (int) ((cal2.getTimeInMillis() - cal.getTimeInMillis()) / 86400000);
				int ucret = fark * Integer.parseInt(tekGece.getText());
				topFiyat.setText(""+ ucret);
			}
		});
		datePicker.setBounds(138, 206, 180, 29);
		datePicker.getJFormattedTextField().setBounds(0, 0, 152, 149);
		getContentPane().add(datePicker);
		
		UtilDateModel model2 = new UtilDateModel();
		Calendar cal2 = Calendar.getInstance();
		model2.setDate(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DAY_OF_MONTH));
		model2.setSelected(true);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, new Properties());
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) datePicker.getModel().getValue()); 
				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime((Date) datePicker2.getModel().getValue());
				
				int fark = (int) ((cal2.getTimeInMillis() - cal.getTimeInMillis()) / 86400000);
				int ucret = fark * Integer.parseInt(tekGece.getText());
				topFiyat.setText(""+ ucret);
			}
		});
		datePicker2.setBounds(138, 264, 180, 29);
		datePicker2.getJFormattedTextField().setBounds(0, 0, 152, 149);
		getContentPane().add(datePicker2);
		
		JButton btnRezervasyonYap = new JButton("REZERVASYON YAP");
		btnRezervasyonYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sehir = sehirler_ekraný.getSelectedIndex();
				int otel = oteller_ekraný.getSelectedIndex();
				String oda = oda_ekraný.getSelectedItem().toString();
								
				
				Calendar cal = Calendar.getInstance();
			    cal.setTime((Date) datePicker.getModel().getValue()); 
				String girisTarihi = cal.get(Calendar.YEAR) +"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime((Date) datePicker2.getModel().getValue());
				String cýkýsTarihi = cal2.get(Calendar.YEAR) +"-"+(cal2.get(Calendar.MONTH)+1)+"-"+cal2.get(Calendar.DAY_OF_MONTH);
					
				
				boolean bosMu = dao.rezervasyonAl(sehirler.get(sehir),oteller.get(otel),girisTarihi,cýkýsTarihi,oda);
				if(bosMu) 
					JOptionPane.showMessageDialog(null, "Rezervasyon Alýndý.");				
				else
					JOptionPane.showMessageDialog(null, "Seçtiðiniz tarih dolu.");
			}
		});
		btnRezervasyonYap.setBounds(435, 222, 157, 38);
		frmRezervasyonEkran.getContentPane().add(btnRezervasyonYap);
		
		JLabel lblToplamFiyat = new JLabel("TOPLAM F\u0130YAT:");
		lblToplamFiyat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblToplamFiyat.setBounds(376, 129, 101, 31);
		frmRezervasyonEkran.getContentPane().add(lblToplamFiyat);
		
		
		
		JLabel lblTekGeceFiyat = new JLabel("TEK GECE F\u0130YATI : ");
		lblTekGeceFiyat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTekGeceFiyat.setBounds(376, 98, 121, 16);
		frmRezervasyonEkran.getContentPane().add(lblTekGeceFiyat);
		
		JLabel lblHogeldiniz = new JLabel("HO\u015EGELD\u0130N\u0130Z...");
		lblHogeldiniz.setForeground(new Color(0, 0, 128));
		lblHogeldiniz.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblHogeldiniz.setBounds(64, 13, 162, 22);
		frmRezervasyonEkran.getContentPane().add(lblHogeldiniz);
		
		

		sehirler = dao.sehirleriCek();
		for (int i = 0; i < sehirler.size(); i++) {
			sehirler_ekraný.addItem(sehirler.get(i));		
		}

		sehirler_ekraný.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {				
				oteller_ekraný.removeAllItems();
				int sehir = sehirler_ekraný.getSelectedIndex();
				oteller = dao.otelleriCek(sehirler.get(sehir).getId());
				for (int i = 0; i < oteller.size(); i++) {
					oteller_ekraný.addItem(oteller.get(i));

				}
			}
		});
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		frmRezervasyonEkran.getContentPane().add(label);
	}

	private void initialize() {
		frmRezervasyonEkran = new JFrame();
		frmRezervasyonEkran.setForeground(new Color(0, 0, 0));
		frmRezervasyonEkran.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmRezervasyonEkran.setTitle("REZERVASYON EKRANI");
		frmRezervasyonEkran.setBounds(100, 100, 700, 400);
		frmRezervasyonEkran.getContentPane().setLayout(null);
		

		
	}
	private Container getContentPane() {
		// TODO Auto-generated method stub
		return frmRezervasyonEkran.getContentPane();
	}
}
