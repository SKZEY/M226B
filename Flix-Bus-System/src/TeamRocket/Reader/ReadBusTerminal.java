<<<<<<< HEAD:Flix-Bus-System/src/TeamRocket/Reader/ReadBusTerminal.java
package TeamRocket.Reader;

import java.util.ArrayList;

import TeamRocket.MainObjects.BusTerminal;
import TeamRocket.MainObjects.Platform;

public class ReadBusTerminal extends MainReader {
	ArrayList<Object> objectList;


public ReadBusTerminal(String filePath, String delimiter, ArrayList<Object> objectList) {
		super(filePath, delimiter);
		this.objectList = objectList;
	}

private ArrayList<Platform> changeListType () {
	ArrayList<Platform> platformList = new ArrayList<Platform>();
	for (Object object : objectList) {
		Platform tempPlatform = (Platform) object;
		platformList.add(tempPlatform);	
	}
	return platformList;
	
}

public ArrayList<Object> getListOfObject() {
	  	String[] tempArr;	 
		ArrayList<Object> listOfBusTerminal = new ArrayList();
		ArrayList<String> listofLines = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			listOfBusTerminal.add(new BusTerminal(tempArr[0], changeListType()));
            }
		return listOfBusTerminal;
	}
}

=======
package Reader;

import java.util.ArrayList;

import MainObjects.BusTerminal;
import MainObjects.Platform;

/*
 *  @author melvin 
 * */
/**
 * The Class ReadBusTerminal.
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
>>>>>>> origin/master:Flix-Bus-System/src/Reader/ReadBusTerminal.java
