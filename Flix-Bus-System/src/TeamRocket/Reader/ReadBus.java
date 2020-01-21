package TeamRocket.Reader;

import java.util.*;
import TeamRocket.MainObjects.*;

public class ReadBus extends MainReader {
	
public ReadBus(String filePath, String delimiter) {
		super(filePath, delimiter);
	}

@Override
public void setFilePath (String pathBuilder, String path) {
	this.filePath = System.getProperty("user.dir")+ pathBuilder + "data"+ path;
}
public ArrayList<Object> getListOfObject() {
	  	String[] tempArr;	 
		ArrayList<Object> listOfBus = new ArrayList();
		ArrayList<String> listofLines = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			listOfBus.add(new Bus(Integer.parseInt(tempArr[0]), Integer.parseInt(tempArr[1]), 
					Integer.parseInt(tempArr[2]), Integer.parseInt(tempArr[3]), Integer.parseInt(tempArr[4])));
            }
		
		return listOfBus;
	}
}

