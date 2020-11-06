
public class Oda {
	
	private int oda_id;
	private String odaTipi;
	private int fiyat;
	
	public Oda(int oda_id, String odaTipi, int fiyat) {
		this.oda_id = oda_id;
		this.odaTipi = odaTipi;
		this.fiyat = fiyat;
	}

	@Override
	public String toString() {
		return odaTipi + "--> " + fiyat + " TL" ;
	}

	public int getOda_id() {
		return oda_id;
	}

	public void setOda_id(int oda_id) {
		this.oda_id = oda_id;
	}

	public String getOdaTipi() {
		return odaTipi;
	}

	public void setOdaTipi(String odaTipi) {
		this.odaTipi = odaTipi;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	
	
	
}
