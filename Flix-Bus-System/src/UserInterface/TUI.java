package UserInterface;
import java.text.*;
import java.util.*;

import javax.swing.text.AbstractDocument.BranchElement;

import MainObjects.*;

public class TUI implements output {
	ArrayList<Object> listOfPlatform;
	ArrayList<Object> listOfBus;
	ArrayList<Object> listOfTravel;
	
	Platform platform;
	String eingabe = null; 
	Scanner sc = new Scanner(System.in);
	
	public TUI (ArrayList<Object> listOfPlatform, ArrayList<Object> listOfTravel,ArrayList<Object> listOfBus) {
		this.listOfPlatform = listOfPlatform;
		this.listOfTravel = listOfTravel;
		this.listOfBus = listOfBus;
		
	}

	public void printListOfTravel() {
			
	}

	public void printListOfPlatforms() {
		// TODO Auto-generated method stub
		
	}

	public void PrintTravelByDestionation() {
		// TODO Auto-generated method stub
		
	}

	public void mainMenu() {
		do {
			System.out.println("---Flix-Bus-System---");
			System.out.println("");
			System.out.println("");
			System.out.println("Abfahrtszeiten der Busse per <P>latform");
			System.out.println("<R>eiseplan");
			System.out.println("Anlegen einer <n>euen Reise");
			System.out.println("Bus fährt <e>in");
			System.out.println("Bus fährt <l>os");
			System.out.println("Ist Platform <v>erfügbar");
			System.out.println("Programm <b>eenden");
			eingabe = sc.nextLine();
			switch (eingabe.toUpperCase()) {
			case "P":
				eingabe = "";
				travelMenu();
				break;
			case "R":
				printScheduleOfTravels();
				break;
			case "N":
				createNewTravel();
				break;
			case"E":
				BusArrives();
				break;
			case "L":
				BusLeaves();
				break;
			case "V":
				isPlatformOccupied();
				break;
			}
			
		} while (!eingabe.equalsIgnoreCase("b"));
	}
	
	public void isPlatformOccupied() {
		String platformNo;
		boolean find = false;
		System.out.println("Bitte geben sie die Platformnummer ein: ");
		platformNo = sc.nextLine();
		Platform platformTemp = null;
		
		for (Object object : listOfPlatform) {
			Platform platform = (Platform) object;
			if(platform.getPlatformNo() == Integer.parseInt(platformNo)) {
				platformTemp = platform;
				find = true;
				break;
			}
		}
		if(find == true) {
			if(platformTemp.isPlatformOccupied() == 0) {
			System.out.println("Platform ist verfügbar");
			}
			else {
				System.out.println("Platform ist besetzt");
			}
		}else {
			System.out.println("Platform wurde nicht gefunden");
		}
	}
	
	public void	BusLeaves() {
		System.out.println("Welcher Bus fährt raus");
		String busNo;
		boolean find = false;
		busNo = sc.nextLine();
		Platform platformTemp = null;
		
		for (Object object : listOfPlatform) {
			Platform platform = (Platform) object;
			ArrayList<Travel> travelList = platform.getTravelList();
			for (Travel travel : travelList) {
				if (travel.getBus().getBusNo() == Integer.parseInt(busNo)) {
					find = true;
					platformTemp = platform;
					break;
				}	
			}
		}
		if (find == true) {
			System.out.println("Bus Nummer " + busNo + " hat die Platform" + platformTemp.getPlatformNo() + " verlassen." );
			for (Object object : listOfPlatform) {
				Platform platform = (Platform) object; 
				if(platform == platformTemp) {
					platform.busLeaveFromPlatform();
				}
			}
		}
		else {
			System.out.println("Bus wurde nicht gefunden.");
		}
	}
	
	
	public void BusArrives() {
		System.out.println("Welcher Bus fährt ein: ");
		String busNo;
		boolean find = false;
		busNo = sc.nextLine();
		Platform platformTemp = null;
		
		for (Object object : listOfPlatform) {
			Platform platform = (Platform) object;
			ArrayList<Travel> travelList = platform.getTravelList();
			for (Travel travel : travelList) {
				if (travel.getBus().getBusNo() == Integer.parseInt(busNo)) {
					find = true;
					platformTemp = platform;
					break;
				}	
			}
		}
		if (find == true) {
			System.out.println("Bus Nummer " + busNo + " ist auf der PLatform " + platformTemp.getPlatformNo() + " angekommen." );
			for (Object object : listOfPlatform) {
				Platform platform = (Platform) object; 
				if(platform == platformTemp) {
					platform.busArriveInPlatform();
				}
			}
		}
		else {
			System.out.println("Bus wurde nicht gefunden.");
		}
	}
	
	public void travelMenu() {
		do {
			System.out.println("--- Abfahrtszeiten --- ");
			System.out.println("");
			System.out.println("Bitte geben Sie die Plattform Nummer ein:");
			System.out.println("");
			System.out.println("Mit <Z> gelangen Sie zurück ins Hauptmenu");
			eingabe = sc.nextLine();
			
			if (isStringInteger(eingabe)) {
				platform = getPlatformByNumber(Integer.parseInt(eingabe));
				if (platform == null) {
					System.out.println("Es wurde keine Platform mit der Nummer "+eingabe+ " gefunden.");
				}
				else {
					printListOfTravelbyPlatform(platform);
				}
				
			}
			else {
				System.out.println("Bitte geben Sie einen gültigen Wert ein.");
			}

		} while (!eingabe.equalsIgnoreCase("z"));
	}
	
	public  boolean isStringInteger(String number ){
	    try{
	        Integer.parseInt(number);
	    }catch(Exception e ){
	        return false;
	    }
	    return true;
	}
	
	public Platform getPlatformByNumber(int platformNo){
		Platform platform = null;
		for (Object object : listOfPlatform) {
			Platform tempPlatform = (Platform) object;
			 if (tempPlatform.getPlatformNo() == platformNo) {
				 platform = tempPlatform;
				 return platform;
			 }
		}
		return platform;
		
	}
	
	public void printScheduleOfTravels() {
		System.out.println("Platform\tBus\t\tAbfahrt\t\tAnkunft\t\tZiel\t\tKlasse");
		String line = null;
		for (Object platformItem : listOfPlatform) {
			line = null;
			Platform tempPlatform = (Platform) platformItem;
			ArrayList<Travel> travelList = tempPlatform.getTravelList();
			Collections.sort(travelList, Travel.travelAbfahrtComparator);
			for (Travel travelItem : travelList) {
				line = "" +Integer.toString(travelItem.getBus().getBusNo())+"\t\t"; 
				line =  line + (getTimeByString(travelItem.getDepartureTime()))+"\t\t";
				line =  line + getTimeByString(travelItem.getArrivalTime())+"\t\t";
				line =  line + travelItem.getDestination()+"";
				if (travelItem.getBus().getComfort() == 0) {
					line = line + "\t\t2.Klasse";
				}else {
					line = line + "\t\t1.Klasse";
				}
				
				System.out.println(tempPlatform.getPlatformNo() + "\t\t" + line );	
				
			}
		}
		
	}
	
	public void printListOfTravelbyPlatform(Platform platfrom) {
		
		ArrayList<Travel> travelList = platfrom.getTravelList();
		
		System.out.println("No\tAbfahrtszeit\tBus\tZiel");
		Collections.sort(travelList, Travel.travelAbfahrtComparator);
		for (Travel travel : travelList) {
			System.out.println(platfrom.getPlatformNo() +"\t"+ getTimeByString(travel.getDepartureTime()) + "\t" + travel.getBus().getBusNo() + "\t" + travel.getDestination());
		}
		System.out.println();
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
	
	public  String  getTimeByString(Date date) {
	    String strDate = null;
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");  
	    strDate = formatter.format(date);
	    return strDate;
	}
	
	
	
	public void createNewTravel() {
		System.out.println("Neue Reise anlegen");
		Bus bus = generateNewBus();
		boolean travelCreated = false;
		Travel travel = generatenewTravel(bus); 
		for (Object object : listOfPlatform) {
			Platform platform = (Platform) object;
			if(platform.getPlatformSize() == 0 && bus.getType() == 1) {
				continue;
			}
			boolean isPlatformInUse = isPlatformInUse(platform, travel.getArrivalTime(),travel.getDepartureTime());			
			if (isPlatformInUse == false) {
				platform.getTravelList().add(travel);
				listOfBus.add(bus);
				listOfTravel.add(travel);
				System.err.println("Die neue Reise wurde an der Platform " + platform.getPlatformNo() + " angelegt.");
				travelCreated = true;
				break;
			}
		}
		if (travelCreated == false) {
			System.out.println("Leider konnte die Reiese nicht angelegt werden, da keine Platform zu den angegebenen Zeiten zur Verfügung steht.");
		}
		
		
		
	}
	
	public boolean isPlatformInUse(Platform platform,  Date arrivalTimeDate, Date departureTimeDate) {
		boolean returnValue = false;
		ArrayList<Travel> travelList = platform.getTravelList();
		Long arrivalTimeNew = arrivalTimeDate.getTime();
		Long departureTimeNew = departureTimeDate.getTime();
		for (Travel travel : travelList) {
			Long arrvivalTime = travel.getArrivalTime().getTime();
			Long deputureTime = travel.getDepartureTime().getTime();
			if ((between(arrivalTimeNew, arrvivalTime, deputureTime)) | 
					(between(departureTimeNew, arrvivalTime, deputureTime))){
				if(returnValue == false) {
					returnValue = true;
				}
			}
		}
		return returnValue;
	}
	
	public static boolean between(Long i, Long minValueInclusive, Long maxValueInclusive) {
	    if (i >= minValueInclusive && i <= maxValueInclusive)
	        return true;
	    else
	        return false;
	}
	
	public Travel generatenewTravel(Bus bus) {
		
		Scanner sc = new Scanner(System.in); 
		
		String destination;
		String arrivalTime;
		String departureTime;
		
		Travel travel; 
		
		System.out.println("Geben sie bitte ihr Reiseziel an: ");
		destination = sc.nextLine();
		System.out.println("Bitte geben sie die Ankunftszeit an (HH:MM): ");
		arrivalTime = sc.nextLine();
		System.out.println("Bitte geben sie die Abfahrtszeit an (HH:MM): ");
		departureTime = sc.nextLine();
		
		travel = new Travel(getNextTravelNo(), destination, getTimeByString(arrivalTime), getTimeByString(departureTime), bus);
		
		
		return travel;
	}
	
	public Bus generateNewBus() {
		
		Scanner sc = new Scanner(System.in); 
		int type;
		int comfort;
		int capacity;
		int petrolTankCapacity;
		Bus bus; 
		System.out.println("Geben sie bitte den Bus-Typen an ('0'-Singledecker,'1'-Doubledecker) : ");
		type = Integer.parseInt(sc.nextLine());
		System.out.println("Bitte geben sie die Bus Komfortabilität an ('0'-2.Klasse, '1'-1.Klasse) : ");
		comfort = Integer.parseInt(sc.nextLine());
		
		if(type == 0) {
			capacity = 100;
			petrolTankCapacity = 200;
		} else {
			capacity = 200;
			petrolTankCapacity = 300;
		}
		
		bus = new Bus(getNextBusNo(), type, comfort, capacity, petrolTankCapacity);
		
		
		return bus;
	}
	
	public int getNextBusNo() {
		Bus tempBus;
		int max = Integer.MIN_VALUE;
		for (Object busItem : listOfBus) {
			tempBus = (Bus) busItem;
			 if(tempBus.getBusNo() > max){
		            max = tempBus.getBusNo();
		        }
		}
		return max+1; 
	}
	
	public int getNextTravelNo() {
		Travel tempTravel;
		int max = Integer.MIN_VALUE;
		for (Object travelItem : listOfTravel) {
			tempTravel = (Travel) travelItem;
			 if(tempTravel.getTravelNo() > max){
		            max = tempTravel.getTravelNo();
		        }
		}
		return max+1; 
	}
}
