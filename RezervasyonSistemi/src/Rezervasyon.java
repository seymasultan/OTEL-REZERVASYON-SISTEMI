
public class Rezervasyon {
	
        private String girisTarihi;
        private String cikisTarihi;
        private int oda_id;
        private int musteri_id;
        private String otel_adý;
        private String sehir_adý;
        
		public Rezervasyon(String girisTarihi, String cikisTarihi, int oda_id, int musteri_id, String otel_adý,String sehir_adý) {
			
			this.girisTarihi = girisTarihi;
			this.cikisTarihi = cikisTarihi;
			this.oda_id = oda_id;
			this.musteri_id = musteri_id;
			this.otel_adý = otel_adý;
			this.sehir_adý = sehir_adý;
		}

		@Override
		public String toString() {
			return girisTarihi+"---> "+cikisTarihi+"-->"+otel_adý+"--->"+sehir_adý;
		}
		
		public String getGirisTarihi() {
			return girisTarihi;
		}

		public void setGirisTarihi(String girisTarihi) {
			this.girisTarihi = girisTarihi;
		}

		public String getCikisTarihi() {
			return cikisTarihi;
		}

		public void setCikisTarihi(String cikisTarihi) {
			this.cikisTarihi = cikisTarihi;
		}

		public int getOda_id() {
			return oda_id;
		}

		public void setOda_id(int oda_id) {
			this.oda_id = oda_id;
		}

		public int getMusteri_id() {
			return musteri_id;
		}

		public void setMusteri_id(int musteri_id) {
			this.musteri_id = musteri_id;
		}
        
        
}
