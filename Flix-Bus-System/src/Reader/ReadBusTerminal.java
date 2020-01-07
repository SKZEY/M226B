package Reader;

import java.util.ArrayList;

import MainObjects.Bus;
import MainObjects.BusTerminal;
import MainObjects.Platform;

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

