package TeamRocket.Reader;

import java.util.ArrayList;

import TeamRocket.MainObjects.*;

public class ReadPlatform extends MainReader {
	ArrayList<Object> travelList;

	public ReadPlatform(String filePath, String delimiter, ArrayList<Object> objectList) {
		super(filePath, delimiter);
		travelList = objectList;
	}
	
	public Travel findTravelByNo(int travelNo ) {
		Travel travel = null;
		for (Object travelItem : travelList) {
			Travel tempTravel =  (Travel) travelItem;
			if (tempTravel.getTravelNo()== travelNo) {
				travel = tempTravel;
			}
		}
		return travel;
	}	

public ArrayList<Object> getListOfObject() {
	  	String[] tempArr;	 
		ArrayList<String> listofLines = new ArrayList();
		ArrayList<Object> listOfUniquePlatform = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			 if (!idAllreadyExist(Integer.parseInt(tempArr[0]),listOfUniquePlatform)) {
				 ArrayList<Travel> travelList = getListofTravel(tempArr[0],listofLines );
				 listOfUniquePlatform.add(new Platform(Integer.parseInt(tempArr[0]), Integer.parseInt(tempArr[1]), travelList));
			 }
           }
		return listOfUniquePlatform;
	}

public ArrayList<Travel> getListofTravel(String platformNo, ArrayList<String> listofLines ){
	String[] tempArr;
	ArrayList<Travel> temptravelList = new ArrayList<Travel>();
	for (int i = 1; i < listofLines.size(); i++) {
		tempArr = listofLines.get(i).split(getdelimiter());
		if (tempArr[0].equals(platformNo)){
			String travelNo = tempArr[2];
			for (Object item : travelList) {
				Travel travel = (Travel) item;
				if (travel.getTravelNo() == Integer.parseInt(travelNo)){
					temptravelList.add(travel);
				}
			}
		}	
	}
return temptravelList;
}

public boolean idAllreadyExist(int no, ArrayList<Object> listOfObject) {
	boolean ReturnValue = false;
	for (Object object : listOfObject) {
		Platform platform =  (Platform) object;
		 if (platform.getPlatformNo() != no) {
			 ReturnValue = false;
		 }
		 else {
			 ReturnValue = true;
		 }
		 
	}
	return ReturnValue;
	
}

}
