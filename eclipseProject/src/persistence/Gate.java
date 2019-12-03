package persistence;

public class Gate {
	private int typ;
	private int groesse;
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

	public String getTyp() {
		switch (typ) {
			case 1:
				return "";
			case 2:
				return "";
			default:
				return "false";
		}
	}

	public Fahrt getFahrt() {
		return fahrt;
	}

	public Bus getBus() {
		return getFahrt().getBus();
	}

}
