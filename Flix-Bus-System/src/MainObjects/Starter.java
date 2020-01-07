package MainObjects;
import UserInterface.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.w3c.dom.ls.LSInput;

import Reader.MainReader;
import Reader.ReadBus;
import Reader.ReadBusTerminal;
import Reader.ReadPlatform;
import Reader.ReadTravel;

public class Starter {

	public static void main(String[] args) {
		
		//Data Path
		String filePath = System.getProperty("user.dir")+"\\data";
		//Bus
		ArrayList<Object> listOfBus = new ArrayList();
		ReadBus readBus =  new ReadBus(null,";");
		readBus.setFilePath("\\bus.csv");
		listOfBus = readBus.getListOfObject();
		
		//Travle
		ArrayList<Object> listOfTravel = new ArrayList();
		ReadTravel  readTravel=  new ReadTravel(filePath+"\\travel.csv",";", listOfBus);
		listOfTravel = readTravel.getListOfObject();
		
		//Platform
		ArrayList<Object> listOfPlatform = new ArrayList();
		ReadPlatform  readPlatform=  new ReadPlatform(filePath+"\\platform.csv",";", listOfTravel);
		listOfPlatform = readPlatform.getListOfObject();
		
		
		//BusTerminal
		ArrayList<Object> listOfBusTerminal = new ArrayList();
		ReadBusTerminal  readBusTerminal=  new ReadBusTerminal(filePath+"\\busTerminal.csv",";", listOfPlatform);
		listOfBusTerminal = readBusTerminal.getListOfObject();
		
		
		TUI tui = new TUI(listOfPlatform, listOfTravel, listOfBus);
		tui.mainMenu();
		
		
		
		
		
		/*Bus bus1 = (Bus) listOfBus.get(2);
		
		System.out.println(bus1.getBusNo() + " " + bus1.getType() + " " + bus1.getComfort() + " " + bus1.getPassengerCapacity() + " " + bus1.getPetrolTankCapacity());
	
		Travel travel = (Travel) listOfTravel.get(1);
		
		System.out.println(travel.getDestination() + " " + travel.getArrivalTime()+ " "+ travel.getDepartureTime() + " " + travel.getBus().getBusNo());
		
		Platform platform = (Platform) listOfPlatform.get(0);
		System.out.println("Platform: "+ platform.getPlatformNo());
		ArrayList<Travel> travelList = platform.getTravelList();
		for (Travel item : travelList) {
			System.out.println(item.getTravelNo());
		}
		
		//System.out.println(platform.getPlatformNo() + " " + platform.getPlatformSize() + " " + platform.isPlatformOccupied() + " " + platform.getTravel().getTravelNo());
		test();
		
		BusTerminal busTerminal = (BusTerminal) listOfBusTerminal.get(0);
		//System.out.println(busTerminal.getNameOfTerminal() + " " + busTerminal.getPlatformList().get(0).getTravel().getBus().getBusNo());
		
		*/
	}
	
	
	public void name(int test) {
		
	}
	
	public void name(String test) {
		
	}
	

	
	
	public static void test() {

	    String myTime = "10:30:54";
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    Date date = null;
	    try {
	        date = sdf.parse(myTime);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    String formattedTime = sdf.format(date);

	    System.out.println(formattedTime);

	}

}
