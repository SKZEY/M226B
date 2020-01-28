package TeamRocket.Reader;

import java.util.ArrayList;

import TeamRocket.MainObjects.Platform;
import TeamRocket.MainObjects.Travel;

/**
 * The Class ReadPlatform.
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class ReadPlatform extends MainReader {

	/** The travel list. */
	ArrayList<Object> travelList;

	/**
	 * Instantiates a new read platform.
	 *
	 * @param filePath   the file path
	 * @param delimiter  the delimiter
	 * @param objectList the object list
	 */
	public ReadPlatform(String filePath, String delimiter,
			ArrayList<Object> objectList) {
		super(filePath, delimiter);
		travelList = objectList;
	}

	/**
	 * Find travel by no.
	 *
	 * @param travelNo the travel no
	 * @return the travel
	 */
	public Travel findTravelByNo(int travelNo) {
		Travel travel = null;
		for (Object travelItem : travelList) {
			Travel tempTravel = (Travel) travelItem;
			if (tempTravel.getTravelNo() == travelNo) {
				travel = tempTravel;
			}
		}
		return travel;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Reader.MainReader#getListOfObject()
	 */
	public ArrayList<Object> getListOfObject() {
		String[] tempArr;
		ArrayList<String> listofLines = new ArrayList();
		ArrayList<Object> listOfUniquePlatform = new ArrayList();
		listofLines = getFileLines();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			if (!idAllreadyExist(Integer.parseInt(tempArr[0]),
					listOfUniquePlatform)) {
				ArrayList<Travel> travelList = getListofTravel(tempArr[0],
						listofLines);
				listOfUniquePlatform
						.add(new Platform(Integer.parseInt(tempArr[0]),
								Integer.parseInt(tempArr[1]), travelList));
			}
		}
		return listOfUniquePlatform;
	}

	/**
	 * Gets the listof travel.
	 *
	 * @param platformNo  the platform no
	 * @param listofLines the listof lines
	 * @return the listof travel
	 */
	public ArrayList<Travel> getListofTravel(String platformNo,
			ArrayList<String> listofLines) {
		String[] tempArr;
		ArrayList<Travel> temptravelList = new ArrayList<Travel>();
		for (int i = 1; i < listofLines.size(); i++) {
			tempArr = listofLines.get(i).split(getdelimiter());
			if (tempArr[0].equals(platformNo)) {
				String travelNo = tempArr[2];
				for (Object item : travelList) {
					Travel travel = (Travel) item;
					if (travel.getTravelNo() == Integer.parseInt(travelNo)) {
						temptravelList.add(travel);
					}
				}
			}
		}
		return temptravelList;
	}

	/**
	 * Id allready exist.
	 *
	 * @param no           the no
	 * @param listOfObject the list of object
	 * @return true, if successful
	 */
	public boolean idAllreadyExist(int no, ArrayList<Object> listOfObject) {
		boolean ReturnValue = false;
		for (Object object : listOfObject) {
			Platform platform = (Platform) object;
			if (platform.getPlatformNo() != no) {
				ReturnValue = false;
			} else {
				ReturnValue = true;
			}

		}
		return ReturnValue;

	}

}
