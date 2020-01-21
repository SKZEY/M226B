package Reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import MainObjects.Bus;
import MainObjects.Travel;

/*
 *  @author melvin 
 * */
/**
 * The Class ReadTravel.
 */
public class ReadTravel extends MainReader {

	/** The bus liste. */
	ArrayList<Object> busListe;

	/**
	 * Instantiates a new read travel.
	 *
	 * @param filePath   the file path
	 * @param delimiter  the delimiter
	 * @param objectList the object list
	 */
	public ReadTravel(String filePath, String delimiter,
			ArrayList<Object> objectList) {
		super(filePath, delimiter);
		busListe = objectList;
	}

	/**
	 * Find bus by no.
	 *
	 * @param busNo the bus no
	 * @return the bus
	 */
	public Bus findBusByNo(int busNo) {
		Bus bus = null;
		for (Object object : busListe) {
			Bus tembus = (Bus) object;
			if (tembus.getBusNo() == busNo) {
				bus = tembus;
			}
		}

		return bus;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Reader.MainReader#getListOfObject()
	 */
	public ArrayList<Object> getListOfObject() {
		String[] tempArr;
		ArrayList<Object> listOfTravel = new ArrayList();
		ArrayList<String> listofLines = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			listOfTravel.add(new Travel(Integer.parseInt(tempArr[0]),
					tempArr[1], getTimeByString(tempArr[2]),
					getTimeByString(tempArr[3]),
					findBusByNo(Integer.parseInt(tempArr[4]))));
		}

		return listOfTravel;
	}

	/**
	 * Gets the time by string.
	 *
	 * @param strTime the str time
	 * @return the time by string
	 */
	public Date getTimeByString(String strTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = sdf.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}