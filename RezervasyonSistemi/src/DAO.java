
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

			String sorgu = "SELECT oda_�d, oda_tipi, f�yat FROM oteller,odalar WHERE odalar.otel_�d=oteller.otel_�d AND odalar.otel_�d="
					+ otel_id;

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {

					String odaTipi = rs.getString("oda_tipi");
					int odaId = rs.getInt("oda_�d");
					int fiyat = rs.getInt("f�yat");
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

			String sorgu = "SELECT otel_ad�, oteller.otel_�d FROM oteller,seh�rler WHERE oteller.seh�r_�d=seh�rler.seh�r_�d AND oteller.seh�r_�d="
					+ sehirId;

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {
					int id = rs.getInt("otel_�d");
					String isim = rs.getString("otel_ad�");
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

			String sorgu = "SELECT seh�r_�d,seh�r_ad� FROM seh�rler ";

			try {
				statement = (Statement) con.createStatement();

				ResultSet rs = statement.executeQuery(sorgu);

				while (rs.next()) {
					int id = rs.getInt("seh�r_�d");
					String isim = rs.getString("seh�r_ad�");
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

	public void sifreAl(String ad�, String soyad�, String telefon, String kimlik, String parola) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Insert Into muster�ler(ad,soyad,telefon,k�ml�k,parola) VALUES(?,?,?,?,?)";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.setString(1, ad�);
				preparedStatement.setString(2, soyad�);
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

	public void musteriGuncelle(int id, String ad�, String soyad�, String telefon, String kimlik) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "UPDATE muster�ler SET ad=?,soyad=?,telefon=?,k�ml�k=? WHERE muster�_�d=?";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.setString(1, ad�);
				preparedStatement.setString(2, soyad�);
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

			String sorgu = "Select*From muster�ler where k�ml�k=? and parola=?"; // veritaban�nda girilen kimlik ve
																					// parola var m�?
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1, kimlik);
				preparedStatement.setString(2, parola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					// veritaban�ndaki tablo �zerinde gezilir.

					String isim = rs.getString("ad");
					String soyisim = rs.getString("soyad"); // m��terinin bilgileri al�n�r
					String telefon = rs.getString("telefon");
					String tc_kimlik = rs.getString("k�ml�k");
					musteriID = rs.getInt("musteri_�d");

					Musteri musteri = new Musteri(isim, soyisim, telefon, tc_kimlik);

					return musteri; // rezervasyon ekran�nda m��terinin bilgilerini tutmak i�in d�nd�r�l�r

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
            
            
			String sorgu1 = "SELECT oda_�d FROM odalar, oteller WHERE odalar.otel_�d = oteller.otel_�d AND oteller.otel_ad�=? AND odalar.oda_t�p� = ?";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu1);
				preparedStatement.setString(1, otel.getOtelAdi());
				preparedStatement.setString(2, odaTipi);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					oda_id = rs.getInt("oda_�d");
					odaList.add(oda_id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(odaList.size());

			int i = 0;
			boolean bosOdaBulundu = false;
			while (i < odaList.size() && !bosOdaBulundu) {

				String sorgu2 = "(SELECT * FROM rezervasyonlar WHERE oda_id=? AND g�r�s_tar�h� BETWEEN ? AND ? )"
						+ "UNION (SELECT * FROM rezervasyonlar WHERE oda_id=? AND c�k�s_tar�h� BETWEEN ? AND ?)"
						+ "UNION (SELECT * FROM rezervasyonlar WHERE oda_id=? AND g�r�s_tar�h� < ? AND c�k�s_tar�h� > ?)";
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
			
				//String sorgu3 = "Insert Into rezervasyonlar(g�r�s_tar�h�,c�k�s_tar�h�,oda_�d,muster�_�d) VALUES(?,?,?,?)";
				// yeni rezervasyon veritaban�na ekler.

			/*	preparedStatement = (PreparedStatement) con.prepareStatement(sorgu3);
				preparedStatement.setString(1, girisTarihi);
				preparedStatement.setString(2, cikisTarihi);
				preparedStatement.setInt(3, oda_id);
				preparedStatement.setInt(4, musteriID);
				preparedStatement.executeUpdate();  */
				
				CallableStatement cs=con.prepareCall("{call pr_rezervasyon(?,?,?,?)");
				
				cs.setString("p_g�r�s_tar�h�",girisTarihi);
				cs.setString("p_c�k�s_tar�h�",cikisTarihi);
				cs.setInt("p_oda_�d",oda_id);
			    cs.setInt("p_muster�_�d",musteriID);
			    
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

			String sorgu = "Select*From muster�ler";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					String isim = rs.getString("ad");
					String soyisim = rs.getString("soyad");
					String telefon = rs.getString("telefon");
					String kimlik = rs.getString("kimlik");
					int id = rs.getInt("muster�_�d");

					Musteri musteri = new Musteri(isim, soyisim, telefon, kimlik, id);
					musteriler.add(musteri); // musteri bilgileri m��teriler listesine eklenir.

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
					int id = rs.getInt("otel_�d");
					String isim = rs.getString("otel_ad�");
					int sehir = rs.getInt("seh�r_�d");
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

			String sorgu = "Select ad,soyad,telefon,k�ml�k From muster�ler Where muster�_�d=" + id;
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

			String sorgu = "DELETE muster�ler Where muster�_�d=" + id;
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

			String sorgu = "SELECT * FROM rezervasyonlar Where muster�_�d=" + musteri_id;
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {

					String girisTarihi = rs.getString("giris_tarihi");
					String cikisTarihi = rs.getString("cikis_tarihi");
					int oda_id = rs.getInt("oda_id");
					int m�steri_id = rs.getInt("musteri_id");

					otel = otelBul(oda_id);
					String sehirAd = sehirBul(otel.getSehir_id());

					Rezervasyon rezervasyon = new Rezervasyon(girisTarihi, cikisTarihi, oda_id, m�steri_id,
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

			String sorgu = "SELECT otel_ad�,sehir_�d From oteller,odalar Where odalar.oda_id=" + oda_id
					+ " AND oteller.otel_id=odalar.otel_id";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String otelAd� = rs.getString("otel_ad�");
				int sehir_id = rs.getInt("sehir_id");

				otel = new Otel(otelAd�, sehir_id);

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

			String sorgu = "SELECT sehir_ad� From sehirler Where sehir_id=" + sehir_id;
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String sehirAd� = rs.getString("sehir_ad�");

				return sehirAd�;

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void otelEkle(String otelAd�, int sehirId) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "INSERT INTO oteller(otel_ad�,sehir_�d) VALUES(?,?)";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
                
				preparedStatement.setString(1, otelAd�);
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

			String sorgu = "DELETE oteller Where otel_�d=" + otelId;
			//DEVAMI OLAB�L�R ODA S�LME VS.
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

			String sorgu = "DELETE odalar Where oda_�d=" + odaId;
			
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
	public void sehirEkle(String sehirAd�) {

		Connection con = OracleBaglanti.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "INSERT INTO sehirler(sehir_ad�) VALUES(?)";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
                
				preparedStatement.setString(1,sehirAd�);
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

			String sorgu = "DELETE sehirler Where sehir_�d=" + sehirId;
			
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

			String sorgu = "Select*From yonetici where yonetici_ad�=? and parola=?"; // veritaban�nda girilen ad ve
																					// parola var m�?
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1, ad);
				preparedStatement.setString(2, parola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					// veritaban�ndaki tablo �zerinde gezilir.

					String isim = rs.getString("yonetici_ad�");
					String sifre = rs.getString("parola"); // y�netici bilgileri al�n�r
					

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