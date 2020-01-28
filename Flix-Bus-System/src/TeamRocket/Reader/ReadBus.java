package TeamRocket.Reader;

import java.util.ArrayList;

import TeamRocket.MainObjects.Bus;

/**
 * The Class ReadBus.
 * 
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class ReadBus extends MainReader {

	/**
	 * Instantiates a new read bus.
	 *
	 * @param filePath  the file path
	 * @param delimiter the delimiter
	 */
	public ReadBus(String filePath, String delimiter) {
		super(filePath, delimiter);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Reader.MainReader#setFilePath(java.lang.String, java.lang.String)
	 */
	@Override
	public void setFilePath(String pathBuilder, String path) {
		this.filePath = System.getProperty("user.dir") + pathBuilder + "data"
				+ path;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Reader.MainReader#getListOfObject()
	 */
	public ArrayList<Object> getListOfObject() {
		String[] tempArr;
		ArrayList<Object> listOfBus = new ArrayList<>();
		ArrayList<String> listofLines = new ArrayList<>();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			listOfBus.add(new Bus(Integer.parseInt(tempArr[0]),
					Integer.parseInt(tempArr[1]), Integer.parseInt(tempArr[2]),
					Integer.parseInt(tempArr[3]), Integer.parseInt(tempArr[4])));
		}

		return listOfBus;
	}
}
