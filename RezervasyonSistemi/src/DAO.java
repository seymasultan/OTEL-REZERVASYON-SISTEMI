
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class DAO {

	private static DAO instance = null;

	private DAO() {

	}

	public static DAO getInstance() {
		if (instance == null)
			instance = new DAO();
		return instance;
	}

	int musteriID;

	public List<Oda> odaCek(int otel_id) {

		Connection con = OracleBaglanti.getInstance().getCon();
		List<Oda> odalar = new ArrayList<>();

		try {

			Statement statement = null;

			String sorgu = "SELECT oda_ýd, oda_tipi, fýyat FROM oteller,odalar WHERE odalar.otel_ýd=oteller.otel_ýd AND odalar.otel_ýd="
					+ otel_id;

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {

					String odaTipi = rs.getString("oda_tipi");
					int odaId = rs.getInt("oda_ýd");
					int fiyat = rs.getInt("fýyat");
					odalar.add(new Oda(odaId, odaTipi, fiyat));

				}

			} catch (SQLException ex) {
				ex.printStackTrace();

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return odalar;
	}

	public List<Otel> otelleriCek(int sehirId) {

		Connection con = OracleBaglanti.getInstance().getCon();

		List<Otel> oteller = new ArrayList<>();

		try {

			Statement statement = null;

			String sorgu = "SELECT otel_adý, oteller.otel_ýd FROM oteller,sehýrler WHERE oteller.sehýr_ýd=sehýrler.sehýr_ýd AND oteller.sehýr_ýd="
					+ sehirId;

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {
					int id = rs.getInt("otel_ýd");
					String isim = rs.getString("otel_adý");
					oteller.add(new Otel(id, isim));

				}

			} catch (SQLException ex) {
				ex.printStackTrace();

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return oteller;
	}

	public List<Sehir> sehirleriCek() {
		Connection con = OracleBaglanti.getInstance().getCon();
		List<Sehir> sehirler = new ArrayList<>();

		try {

			Statement statement = null;

			String sorgu = "SELECT sehýr_ýd,sehýr_adý FROM sehýrler ";

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {
					int id = rs.getInt("sehýr_ýd");
					String isim = rs.getString("sehýr_adý");
					sehirler.add(new Sehir(id, isim));
				}

			} catch (SQLException ex) {
				ex.printStackTrace();

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return sehirler;

	}

	public void sifreAl(String adý, String soyadý, String telefon, String kimlik, String parola) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Insert Into musterýler(ad,soyad,telefon,kýmlýk,parola) VALUES(?,?,?,?,?)";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.setString(1, adý);
				preparedStatement.setString(2, soyadý);
				preparedStatement.setString(3, telefon);
				preparedStatement.setString(4, kimlik);
				preparedStatement.setString(5, parola);

				preparedStatement.executeUpdate();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void musteriGuncelle(int id, String adý, String soyadý, String telefon, String kimlik) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "UPDATE musterýler SET ad=?,soyad=?,telefon=?,kýmlýk=? WHERE musterý_ýd=?";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.setString(1, adý);
				preparedStatement.setString(2, soyadý);
				preparedStatement.setString(3, telefon);
				preparedStatement.setString(4, kimlik);
				preparedStatement.setInt(5, id);
				preparedStatement.executeUpdate();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Musteri girisYap(String kimlik, String parola) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Select*From musterýler where kýmlýk=? and parola=?"; // veritabanýnda girilen kimlik ve
																					// parola var mý?
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1, kimlik);
				preparedStatement.setString(2, parola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					// veritabanýndaki tablo üzerinde gezilir.

					String isim = rs.getString("ad");
					String soyisim = rs.getString("soyad"); // müþterinin bilgileri alýnýr
					String telefon = rs.getString("telefon");
					String tc_kimlik = rs.getString("kýmlýk");
					musteriID = rs.getInt("musteri_ýd");

					Musteri musteri = new Musteri(isim, soyisim, telefon, tc_kimlik);

					return musteri; // rezervasyon ekranýnda müþterinin bilgilerini tutmak için döndürülür

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean rezervasyonAl(Sehir sehir, Otel otel, String girisTarihi, String cikisTarihi, String odaTipi) {

		Connection con = OracleBaglanti.getInstance().getCon();
		ArrayList<Integer> odaList = new ArrayList<>();

		System.out.println(girisTarihi + " - " + cikisTarihi);

		int oda_id = 0;

		try {

			PreparedStatement preparedStatement = null;
            
            
			String sorgu1 = "SELECT oda_ýd FROM odalar, oteller WHERE odalar.otel_ýd = oteller.otel_ýd AND oteller.otel_adý=? AND odalar.oda_týpý = ?";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu1);
				preparedStatement.setString(1, otel.getOtelAdi());
				preparedStatement.setString(2, odaTipi);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					oda_id = rs.getInt("oda_ýd");
					odaList.add(oda_id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(odaList.size());

			int i = 0;
			boolean bosOdaBulundu = false;
			while (i < odaList.size() && !bosOdaBulundu) {

				String sorgu2 = "(SELECT * FROM rezervasyonlar WHERE oda_id=? AND gýrýs_tarýhý BETWEEN ? AND ? )"
						+ "UNION (SELECT * FROM rezervasyonlar WHERE oda_id=? AND cýkýs_tarýhý BETWEEN ? AND ?)"
						+ "UNION (SELECT * FROM rezervasyonlar WHERE oda_id=? AND gýrýs_tarýhý < ? AND cýkýs_tarýhý > ?)";
				try {
					preparedStatement = (PreparedStatement) con.prepareStatement(sorgu2);
					preparedStatement.setInt(1, odaList.get(i));
					preparedStatement.setString(2, girisTarihi);
					preparedStatement.setString(3, cikisTarihi);
					preparedStatement.setInt(4, odaList.get(i));
					preparedStatement.setString(5, girisTarihi);
					preparedStatement.setString(6, cikisTarihi);
					preparedStatement.setInt(7, odaList.get(i));
					preparedStatement.setString(8, girisTarihi);
					preparedStatement.setString(9, cikisTarihi);

					ResultSet rs = preparedStatement.executeQuery();

					if (rs.next())
						bosOdaBulundu = false;
					else
						bosOdaBulundu = true;

				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}
			if (bosOdaBulundu) {
			
				//String sorgu3 = "Insert Into rezervasyonlar(gýrýs_tarýhý,cýkýs_tarýhý,oda_ýd,musterý_ýd) VALUES(?,?,?,?)";
				// yeni rezervasyon veritabanýna ekler.

			/*	preparedStatement = (PreparedStatement) con.prepareStatement(sorgu3);
				preparedStatement.setString(1, girisTarihi);
				preparedStatement.setString(2, cikisTarihi);
				preparedStatement.setInt(3, oda_id);
				preparedStatement.setInt(4, musteriID);
				preparedStatement.executeUpdate();  */
				
				CallableStatement cs=con.prepareCall("{call pr_rezervasyon(?,?,?,?)");
				
				cs.setString("p_gýrýs_tarýhý",girisTarihi);
				cs.setString("p_cýkýs_tarýhý",cikisTarihi);
				cs.setInt("p_oda_ýd",oda_id);
			    cs.setInt("p_musterý_ýd",musteriID);
			    
			    cs.executeQuery();
			    
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Musteri> musteriListele() {

		Connection con = OracleBaglanti.getInstance().getCon();

		ArrayList<Musteri> musteriler = new ArrayList<>();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Select*From musterýler";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					String isim = rs.getString("ad");
					String soyisim = rs.getString("soyad");
					String telefon = rs.getString("telefon");
					String kimlik = rs.getString("kimlik");
					int id = rs.getInt("musterý_ýd");

					Musteri musteri = new Musteri(isim, soyisim, telefon, kimlik, id);
					musteriler.add(musteri); // musteri bilgileri müþteriler listesine eklenir.

				}
				return musteriler;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return musteriler;
	}

	public List<Otel> otelleriListele() {

		Connection con = OracleBaglanti.getInstance().getCon();

		List<Otel> oteller = new ArrayList<>();

		try {

			Statement statement = null;

			String sorgu = "SELECT* FROM oteller";

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {
					int id = rs.getInt("otel_ýd");
					String isim = rs.getString("otel_adý");
					int sehir = rs.getInt("sehýr_ýd");
					oteller.add(new Otel(id, isim,sehir));
				}

			} catch (SQLException ex) {
				ex.printStackTrace();

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return oteller;
	}
	
	public Musteri musteriCek(int id) {

		Connection con = OracleBaglanti.getInstance().getCon();

		Musteri musteri = null;
		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Select ad,soyad,telefon,kýmlýk From musterýler Where musterý_ýd=" + id;
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					String isim = rs.getString("ad");
					String soyisim = rs.getString("soyad");
					String telefon = rs.getString("telefon");
					String kimlik = rs.getString("kimlik");

					musteri = new Musteri(isim, soyisim, telefon, kimlik);
					return musteri;
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return musteri;

	}

	public void musteriSil(int id) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "DELETE musterýler Where musterý_ýd=" + id;
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.executeQuery();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Rezervasyon> rezervasyonGoruntule(int musteri_id) {

		Connection con = OracleBaglanti.getInstance().getCon();

		Otel otel = null;

		ArrayList<Rezervasyon> rezervasyonlar = new ArrayList<>();
		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "SELECT * FROM rezervasyonlar Where musterý_ýd=" + musteri_id;
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {

					String girisTarihi = rs.getString("giris_tarihi");
					String cikisTarihi = rs.getString("cikis_tarihi");
					int oda_id = rs.getInt("oda_id");
					int müsteri_id = rs.getInt("musteri_id");

					otel = otelBul(oda_id);
					String sehirAd = sehirBul(otel.getSehir_id());

					Rezervasyon rezervasyon = new Rezervasyon(girisTarihi, cikisTarihi, oda_id, müsteri_id,
							otel.getOtelAdi(), sehirAd);
					rezervasyonlar.add(rezervasyon);

				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rezervasyonlar;

	}

	public Otel otelBul(int oda_id) {

		Connection con = OracleBaglanti.getInstance().getCon();

		Otel otel = null;
		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "SELECT otel_adý,sehir_ýd From oteller,odalar Where odalar.oda_id=" + oda_id
					+ " AND oteller.otel_id=odalar.otel_id";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String otelAdý = rs.getString("otel_adý");
				int sehir_id = rs.getInt("sehir_id");

				otel = new Otel(otelAdý, sehir_id);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otel;
	}

	public String sehirBul(int sehir_id) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "SELECT sehir_adý From sehirler Where sehir_id=" + sehir_id;
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String sehirAdý = rs.getString("sehir_adý");

				return sehirAdý;

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void otelEkle(String otelAdý, int sehirId) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "INSERT INTO oteller(otel_adý,sehir_ýd) VALUES(?,?)";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
                
				preparedStatement.setString(1, otelAdý);
				preparedStatement.setInt(2,sehirId);
				
				preparedStatement.executeQuery();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void otelSil(int otelId) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "DELETE oteller Where otel_ýd=" + otelId;
			//DEVAMI OLABÝLÝR ODA SÝLME VS.
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.executeQuery();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void odaEkle(String odaTipi, int fiyat,int otel_id) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			//PreparedStatement preparedStatement = null;

			//String sorgu = "INSERT INTO odalar(oda_tipi,otel_id,fiyat) VALUES(?,?,?)";
			try {
			/*	preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
                
				preparedStatement.setString(1, odaTipi);
				preparedStatement.setInt(2,otel_id);
				preparedStatement.setInt(3,fiyat);
				
				preparedStatement.executeQuery(); */
				System.out.println(otel_id);
				CallableStatement cs=con.prepareCall("{call pr_odaEkle(?,?,?)}");
				cs.setString("p_odaTipi",odaTipi);		
                cs.setInt("p_fiyat",fiyat);
                cs.setInt("p_otelid",otel_id);
                
                cs.executeQuery();
                
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void odaSil(int odaId) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "DELETE odalar Where oda_ýd=" + odaId;
			
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.executeQuery();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void sehirEkle(String sehirAdý) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "INSERT INTO sehirler(sehir_adý) VALUES(?)";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
                
				preparedStatement.setString(1,sehirAdý);
				preparedStatement.executeQuery();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void sehirSil(int sehirId) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "DELETE sehirler Where sehir_ýd=" + sehirId;
			
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.executeQuery();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public Yonetici yoneticiGiris(String ad, String parola) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Select*From yonetici where yonetici_adý=? and parola=?"; // veritabanýnda girilen ad ve
																					// parola var mý?
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1, ad);
				preparedStatement.setString(2, parola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					// veritabanýndaki tablo üzerinde gezilir.

					String isim = rs.getString("yonetici_adý");
					String sifre = rs.getString("parola"); // yönetici bilgileri alýnýr
					

					Yonetici yonetici = new Yonetici(isim,sifre);

					return yonetici; 

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}