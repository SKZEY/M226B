package TeamRocket.Reader;

import java.util.ArrayList;

import TeamRocket.MainObjects.BusTerminal;
import TeamRocket.MainObjects.Platform;

/**
 * The Class ReadBusTerminal.
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class ReadBusTerminal extends MainReader {

	/** The object list. */
	ArrayList<Object> objectList;

	/**
	 * Instantiates a new read bus terminal.
	 *
	 * @param filePath   the file path
	 * @param delimiter  the delimiter
	 * @param objectList the object list
	 */
	public ReadBusTerminal(String filePath, String delimiter,
			ArrayList<Object> objectList) {
		super(filePath, delimiter);
		this.objectList = objectList;
	}

	/**
	 * Change list type.
	 *
	 * @return the array list
	 */
	private ArrayList<Platform> changeListType() {
		ArrayList<Platform> platformList = new ArrayList<Platform>();
		for (Object object : objectList) {
			Platform tempPlatform = (Platform) object;
			platformList.add(tempPlatform);
		}
		return platformList;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Reader.MainReader#getListOfObject()
	 */
	public ArrayList<Object> getListOfObject() {
		String[] tempArr;
		ArrayList<Object> listOfBusTerminal = new ArrayList();
		ArrayList<String> listofLines = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			listOfBusTerminal
					.add(new BusTerminal(tempArr[0], changeListType()));
		}
		return listOfBusTerminal;
	}
}
