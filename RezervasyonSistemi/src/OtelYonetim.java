import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OtelYonetim extends JFrame {

	private JPanel contentPane;
	private JTextField otelAd�Ekran�;
	JList otelList;
	JList odaList;
	private JTextField fiyatEkran�;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtelYonetim frame = new OtelYonetim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OtelYonetim() {
		setTitle("OTEL Y\u00D6NET\u0130M EKRANI");

		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOtelAd = new JLabel("Otel Ad\u0131:");
		lblOtelAd.setBounds(399, 30, 94, 16);
		contentPane.add(lblOtelAd);
		
		otelAd�Ekran� = new JTextField();
		otelAd�Ekran�.setColumns(10);
		otelAd�Ekran�.setBounds(537, 27, 116, 22);
		contentPane.add(otelAd�Ekran�);

		JComboBox sehirAdEkran� = new JComboBox();
		sehirAdEkran�.setBounds(537, 62, 116, 22);
		contentPane.add(sehirAdEkran�);
		
		List<Sehir> sehirler=DAO.getInstance().sehirleriCek();
		  for(int i=0;i<sehirler.size();i++)
			  sehirAdEkran�.addItem(sehirler.get(i));
		
		JLabel lblehirAd = new JLabel("\u015Eehir Ad\u0131: ");
		lblehirAd.setBounds(399, 59, 94, 16);
		contentPane.add(lblehirAd);
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String otelAd=otelAd�Ekran�.getText();
				int sehirID = ((Sehir) sehirAdEkran�.getSelectedItem()).getId();
				DAO.getInstance().otelEkle(otelAd, sehirID);				
				JOptionPane.showMessageDialog(null, "Yeni otel eklendi!!");
				otelGuncelle(DAO.getInstance().otelleriListele());
				
			}
		});
		btnEkle.setBounds(409, 125, 97, 25);
		contentPane.add(btnEkle);
		
		JButton button_1 = new JButton("S\u0130L");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int otelId = ((Otel) otelList.getSelectedValue()).getOtel_id();
				DAO.getInstance().otelSil(otelId);
				otelGuncelle(DAO.getInstance().otelleriListele());
				JOptionPane.showMessageDialog(null, "Se�ti�iniz otel silindi!!");
			}
		});
		button_1.setBounds(533, 125, 97, 25);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 30, 375, 130);
		contentPane.add(scrollPane);
		
		otelList = new JList();
		otelList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Otel otel = (Otel) otelList.getSelectedValue();
				otelAd�Ekran�.setText(otel.getOtelAdi());
				int sehirID = otel.getSehir_id();
				for(int i=0 ; i<sehirAdEkran�.getItemCount() ; i++) {
					if(((Sehir) sehirAdEkran�.getItemAt(i)).getId() == sehirID)
						sehirAdEkran�.setSelectedIndex(i);
				}	
				
				
				List<Oda> odaListe=DAO.getInstance().odaCek(otel.getOtel_id());
				odaGuncelle(odaListe);
				
				
			}
		});
		scrollPane.setViewportView(otelList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 198, 375, 130);
		contentPane.add(scrollPane_1);
		
		odaList = new JList();
		
		scrollPane_1.setViewportView(odaList);
		
		JLabel lblOdaAd = new JLabel("Oda Tipi:");
		lblOdaAd.setBounds(409, 207, 56, 16);
		contentPane.add(lblOdaAd);
		
		JComboBox<String> odaTipiEkran� = new JComboBox<>();
		odaTipiEkran�.setBounds(537, 204, 116, 22);
		contentPane.add(odaTipiEkran�);
		odaTipiEkran�.addItem("Tek Ki�ilik");
		odaTipiEkran�.addItem("�ki Ki�ilik");
		odaTipiEkran�.addItem("�� Ki�ilik");
		odaTipiEkran�.addItem("D�rt Ki�ilik");
		
		
		JButton btnNewButton = new JButton("EKLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String odaTipi=(String) odaTipiEkran�.getSelectedItem();
				int fiyat=Integer.parseInt(fiyatEkran�.getText());
				Otel otel = (Otel) otelList.getSelectedValue();
				int otel_id=otel.getOtel_id();
				DAO.getInstance().odaEkle(odaTipi, fiyat, otel_id);
				odaGuncelle(DAO.getInstance().odaCek(otel_id));
				JOptionPane.showMessageDialog(null, "Se�ti�iniz oda eklendi!!");
			}
		});
		btnNewButton.setBounds(399, 291, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Otel otel = (Otel) otelList.getSelectedValue();
				int otel_id=otel.getOtel_id();
				int odaId = ((Oda)odaList.getSelectedValue()).getOda_id();
				DAO.getInstance().odaSil(odaId);
				odaGuncelle(DAO.getInstance().odaCek(otel_id));
				fiyatEkran�.setText("");
				JOptionPane.showMessageDialog(null, "Se�ti�iniz oda silindi!!");

			}
		});
		btnSil.setBounds(533, 291, 97, 25);
		contentPane.add(btnSil);
		
		JLabel lblFiyat = new JLabel("Fiyat:");
		lblFiyat.setBounds(409, 251, 56, 16);
		contentPane.add(lblFiyat);
		
		fiyatEkran� = new JTextField();
		fiyatEkran�.setBounds(537, 256, 116, 22);
		contentPane.add(fiyatEkran�);
		fiyatEkran�.setColumns(10);
		
		
		otelGuncelle(DAO.getInstance().otelleriListele());
		
		ImageIcon pp = new ImageIcon(getClass().getResource("/tatil.jpg"));
	    JLabel label = new JLabel(pp);
		label.setBounds(0, 0,700,400);
		contentPane.add(label);
	}
	
	
	private void otelGuncelle (List<Otel> liste) { 
		DefaultListModel<Otel> listModel = new DefaultListModel<Otel>() {

			private static final long serialVersionUID = -5820179847193350577L;

			public int getSize() {
				return liste.size();
			}                            //bu fonksiyon her �a�r�ld���nda m�steri listesi g�ncellenir.

			public Otel getElementAt(int i) {
				return liste.get(i);
			}
		};
		otelList.setModel(listModel);
	}
	private void odaGuncelle (List<Oda> liste) { 
		DefaultListModel<Oda> listModel = new DefaultListModel<Oda>() {

			private static final long serialVersionUID = -5820179847193350577L;

			public int getSize() {
				return liste.size();
			}                            //bu fonksiyon her �a�r�ld���nda m�steri listesi g�ncellenir.

			public Oda getElementAt(int i) {
				return liste.get(i);
			}
		};
		odaList.setModel(listModel);
	}
}
