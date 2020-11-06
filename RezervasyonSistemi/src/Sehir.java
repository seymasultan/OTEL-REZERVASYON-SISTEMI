
public class Sehir {
	
	private int id;
	private String ad;
	
	public Sehir(int id, String ad) {
		this.id = id;
		this.ad = ad;
	}
	
	@Override
	public String toString() {
		return ad.toUpperCase();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
}
