package TeamRocket.Reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import TeamRocket.MainObjects.*;
import TeamRocket.MainObjects.Travel;

public class ReadTravel  extends MainReader {
	
	ArrayList<Object> busListe; 
	
public ReadTravel(String filePath, String delimiter, ArrayList<Object> objectList) {
		super(filePath, delimiter);
		busListe =objectList;
	}


public Bus findBusByNo(int busNo ) {
	Bus bus = null;
	for (Object object : busListe) {
		Bus tembus =  (Bus) object;
		if (tembus.getBusNo()== busNo) {
			bus = tembus;
		}
	}
	
	return bus;
	
}

public ArrayList<Object> getListOfObject() {
	  	String[] tempArr;	 
		ArrayList<Object> listOfTravel = new ArrayList();
		ArrayList<String> listofLines = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			listOfTravel.add(new Travel(Integer.parseInt(tempArr[0]), tempArr[1], getTimeByString(tempArr[2]), getTimeByString(tempArr[3]), findBusByNo(Integer.parseInt(tempArr[4]))));
            }
		
		return listOfTravel;
	}



public  Date getTimeByString(String strTime) {
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