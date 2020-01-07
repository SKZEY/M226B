package persistence;

public class Gate {
	private int typ;
	private int groesse;
	private int nummer;
	private Fahrt fahrt;

	public void ankommen(Fahrt fahrt) {

	}

	public void fahrtStarten() {

	}

	public boolean istFrei() {
		return false;
	}

	public int getGroesse() {
		return groesse;
	}

	public int getTyp() {
		return typ;
	}

	public Fahrt getFahrt() {
		return fahrt;
	}

	public Bus getBus() {
		return getFahrt().getBus();
	}

}
