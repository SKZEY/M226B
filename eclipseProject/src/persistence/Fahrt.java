package persistence;

public class Fahrt {
	private int nummer;
	private String startzeit;
	private String endzeit;
	private Bus bus;

	public Bus getBus() {
		return bus;
	}

	public int getFahrtnummer() {
		return nummer;
	}

	public String getStartzeit() {
		return startzeit;
	}

	public String getEndzeit() {
		return endzeit;
	}
	
	public boolean istNational() {
		return (getFahrtnummer() < 1000);
	}
}
