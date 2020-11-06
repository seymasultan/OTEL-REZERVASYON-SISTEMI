
public class Otel {
	
	private int otel_id;
	private String otelAdi;
	private int sehir_id;
	
	
	public Otel(int otel_id, String otelAdi) {
		this.otel_id = otel_id;
		this.otelAdi = otelAdi;
	}
	
	public Otel(String otelAdi, int sehir_id) {
		this.otelAdi = otelAdi;
		this.sehir_id = sehir_id;
	}

	public Otel(int otel_id, String otelAdi, int sehir_id) {
		this.otel_id = otel_id;
		this.otelAdi = otelAdi;
		this.sehir_id = sehir_id;
	}

	@Override
	public String toString() {
		return otelAdi.toUpperCase();
	}
	public int getOtel_id() {
		return otel_id;
	}
	public void setOtel_id(int otel_id) {
		this.otel_id = otel_id;
	}
	public String getOtelAdi() {
		return otelAdi;
	}
	public void setOtelAdi(String otelAdi) {
		this.otelAdi = otelAdi;
	}

	public int getSehir_id() {
		return sehir_id;
	}

	public void setSehir_id(int sehir_id) {
		this.sehir_id = sehir_id;
	}
	
}
