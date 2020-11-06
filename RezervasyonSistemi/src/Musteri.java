
public class Musteri {
		
	    private String ad;
	    private String soyad;
	    private String  telefon;
	    private String  kimlik;
	    private String parola;
	    private int id;
	    
		public Musteri(String ad, String soyad, String telefon, String kimlik, String parola) {
			this.ad = ad;
			this.soyad = soyad;
			this.telefon = telefon;
			this.kimlik = kimlik;
			this.parola = parola;
		}
		
		
		public Musteri(String ad, String soyad, String telefon, String kimlik, int id) {
			this.ad = ad;
			this.soyad = soyad;
			this.telefon = telefon;
			this.kimlik = kimlik;
			this.id=id;
		}
		
		
		public Musteri(String ad, String soyad, String telefon, String kimlik) {
			this.ad = ad;
			this.soyad = soyad;
			this.telefon = telefon;
			this.kimlik = kimlik;
		}      

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return ad.toUpperCase() + " " + soyad.toUpperCase() + " --> "+kimlik+" --> "+telefon;
		}

		public String getAd() {
			return ad;
		}
		public void setAd(String ad) {
			this.ad = ad;
		}
		public String getSoyad() {
			return soyad;
		}
		public void setSoyad(String soyad) {
			this.soyad = soyad;
		}
		public String getTelefon() {
			return telefon;
		}
		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}
		public String getKimlik() {
			return kimlik;
		}
		public void setKimlik(String kimlik) {
			this.kimlik = kimlik;
		}
		public String getParola() {
			return parola;
		}
		public void setParola(String parola) {
			this.parola = parola;
		}


}
