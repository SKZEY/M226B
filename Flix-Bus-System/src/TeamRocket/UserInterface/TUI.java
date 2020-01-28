package TeamRocket.UserInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import TeamRocket.MainObjects.Bus;
import TeamRocket.MainObjects.Platform;
import TeamRocket.MainObjects.Travel;

/**
 * The Class TUI.
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class TUI implements output {

	/** The list of platform. */
	ArrayList<Object> listOfPlatform;

	/** The list of bus. */
	ArrayList<Object> listOfBus;

	/** The list of travel. */
	ArrayList<Object> listOfTravel;

	/** The platform. */
	Platform platform;

	/** The eingabe. */
	String eingabe = null;

	/** The sc. */
	Scanner sc = new Scanner(System.in);

	/**
	 * Instantiates a new tui.
	 *
	 * @param listOfPlatform the list of platform
	 * @param listOfTravel   the list of travel
	 * @param listOfBus      the list of bus
	 */
	public TUI(ArrayList<Object> listOfPlatform, ArrayList<Object> listOfTravel,
			ArrayList<Object> listOfBus) {
		this.listOfPlatform = listOfPlatform;
		this.listOfTravel = listOfTravel;
		this.listOfBus = listOfBus;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see UserInterface.output#printListOfTravel()
	 */
	public void printListOfTravel() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see UserInterface.output#printListOfPlatforms()
	 */
	public void printListOfPlatforms() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see UserInterface.output#PrintTravelByDestionation()
	 */
	public void PrintTravelByDestionation() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see UserInterface.output#mainMenu()
	 */
	public void mainMenu() {
		do {
			System.out.println("");
			System.out.println(" _____  _      ____  __ __         ____   __ __  _____      _____ __ __  _____ ______    ___  ___ ___");
			System.out.println("|     || |    |    ||  |  |       |    \\ |  |  |/ ___/     / ___/|  |  |/ ___/|      |  /  _]|   |   |");
			System.out.println("|   __|| |     |  | |  |  | _____ |  o  )|  |  (   \\_     (   \\_ |  |  (   \\_ |      | /  [_ | _   _ |");
			System.out.println("|  |_  | |___  |  | |_   _||     ||     ||  |  |\\__  |     \\__  ||  ~  |\\__  ||_|  |_||    _]|  \\_/  |");
			System.out.println("|   _] |     | |  | |     ||_____||  O  ||  :  |/  \\ |     /  \\ ||___, |/  \\ |  |  |  |   [_ |   |   |");
			System.out.println("|  |   |     | |  | |  |  |       |     ||     |\\    |     \\    ||     |\\    |  |  |  |     ||   |   |");
			System.out.println("|__|   |_____||____||__|__|       |_____| \\__,_| \\___|      \\___||____/  \\___|  |__|  |_____||___|___|");
			System.out.println("");
			System.out.println("");
			System.out.println("(1) Abfahrtszeiten der Busse per Plattform");
			System.out.println("(2) Reiseplan");
			System.out.println("(3) Anlegen einer neuen Reise");
			System.out.println("(4) Bus fährt ein");
			System.out.println("(5) Bus fährt los");
			System.out.println("(6) Ist Plattform verfügbar");
			System.out.println("(x) Programm beenden");
			eingabe = sc.nextLine();
			switch (eingabe.toUpperCase()) {
			case "1":
				eingabe = "";
				travelMenu();
				break;
			case "2":
				printScheduleOfTravels();
				break;
			case "3":
				createNewTravel();
				break;
			case "4":
				BusArrives();
				break;
			case "5":
				BusLeaves();
				break;
			case "6":
				try {
					isPlatformOccupied();
				} catch (PlatformNotFoundException e) {
					System.out.println("Plattform wurde nicht gefunden");
				}
				break;
			}

		} while (!eingabe.equalsIgnoreCase("x"));
	}

	/**
	 * Checks if is platform occupied.
	 * @throws PlatformNotFoundException
	 */
	public void isPlatformOccupied() throws PlatformNotFoundException {
		String platformNo;
		boolean find = false;
		System.out.println("Bitte geben sie die Plattformnummer ein: ");
		platformNo = sc.nextLine();
		Platform platformTemp = null;

		for (Object object : listOfPlatform) {
			Platform platform = (Platform) object;
			if (platform.getPlatformNo() == Integer.parseInt(platformNo)) {
				platformTemp = platform;
				find = true;
				break;
			}
		}
		if (find == true) {
			if (platformTemp.isPlatformOccupied() == 0) {
				System.out.println("Plattform ist verfügbar");
			} else {
				System.out.println("Plattform ist besetzt");
			}
		} else {
			throw new PlatformNotFoundException("Plattform wurde nicht gefunden.");
//			System.out.println("Platform wurde nicht gefunden");
		}
	}

	/**
	 * Bus leaves.
	 */
	public void BusLeaves() {
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
			System.out.println("Bus Nummer " + busNo + " hat die Plattform"
					+ platformTemp.getPlatformNo() + " verlassen.");
			for (Object object : listOfPlatform) {
				Platform platform = (Platform) object;
				if (platform == platformTemp) {
					platform.busLeaveFromPlatform();
				}
			}
		} else {
			System.out.println("Bus wurde nicht gefunden.");
		}
	}

	/**
	 * Bus arrives.
	 */
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
			System.out.println("Bus Nummer " + busNo + " ist auf der Plattform "
					+ platformTemp.getPlatformNo() + " angekommen.");
			for (Object object : listOfPlatform) {
				Platform platform = (Platform) object;
				if (platform == platformTemp) {
					platform.busArriveInPlatform();
				}
			}
		} else {
			System.out.println("Bus wurde nicht gefunden.");
		}
	}

	/**
	 * Travel menu.
	 */
	public void travelMenu() {
		do {
			System.out.println("--- Abfahrtszeiten --- ");
			System.out.println("");
			System.out.println("Bitte geben Sie die Plattformnummer ein:");
			System.out.println("");
			System.out.println("Mit <Z> gelangen Sie zurück ins Hauptmenu");
			eingabe = sc.nextLine();

			if (isStringInteger(eingabe)) {
				platform = getPlatformByNumber(Integer.parseInt(eingabe));
				if (platform == null) {
					System.out.println("Es wurde keine Plattform mit der Nummer "
							+ eingabe + " gefunden.");
				} else {
					printListOfTravelbyPlatform(platform);
				}

			} else {
				System.out.println("Bitte geben Sie einen gültigen Wert ein.");
			}

		} while (!eingabe.equalsIgnoreCase("z"));
	}

	/**
	 * Checks if is string integer.
	 *
	 * @param number the number
	 * @return true, if is string integer
	 */
	public boolean isStringInteger(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the platform by number.
	 *
	 * @param platformNo the platform no
	 * @return the platform by number
	 */
	public Platform getPlatformByNumber(int platformNo) {
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

	/**
	 * Prints the schedule of travels.
	 */
	public void printScheduleOfTravels() {
		System.out.println(
				"Platform\tBus\t\tAbfahrt\t\tAnkunft\t\tZiel\t\tKlasse");
		String line = null;
		for (Object platformItem : listOfPlatform) {
			line = null;
			Platform tempPlatform = (Platform) platformItem;
			ArrayList<Travel> travelList = tempPlatform.getTravelList();
			Collections.sort(travelList, Travel.travelAbfahrtComparator);
			for (Travel travelItem : travelList) {
				line = "" + Integer.toString(travelItem.getBus().getBusNo())
						+ "\t\t";
				line = line + (getTimeByString(travelItem.getDepartureTime()))
						+ "\t\t";
				line = line + getTimeByString(travelItem.getArrivalTime())
						+ "\t\t";
				line = line + travelItem.getDestination() + "";
				if (travelItem.getBus().getComfort() == 0) {
					line = line + "\t\t2.Klasse";
				} else {
					line = line + "\t\t1.Klasse";
				}

				System.out
						.println(tempPlatform.getPlatformNo() + "\t\t" + line);

			}
		}

	}

	/**
	 * Prints the list of travelby platform.
	 *
	 * @param platfrom the platfrom
	 */
	public void printListOfTravelbyPlatform(Platform platfrom) {

		ArrayList<Travel> travelList = platfrom.getTravelList();

		System.out.println("No\tAbfahrtszeit\tBus\tZiel");
		Collections.sort(travelList, Travel.travelAbfahrtComparator);
		for (Travel travel : travelList) {
			System.out.println(platfrom.getPlatformNo() + "\t"
					+ getTimeByString(travel.getDepartureTime()) + "\t"
					+ travel.getBus().getBusNo() + "\t"
					+ travel.getDestination());
		}
		System.out.println();
	}

	/**
	 * Gets the time by string.
	 *
	 * @param strTime the str time
	 * @return the time by string
	 */
	public Date getTimeByString(String strTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = sdf.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Gets the time by string.
	 *
	 * @param date the date
	 * @return the time by string
	 */
	public String getTimeByString(Date date) {
		String strDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		strDate = formatter.format(date);
		return strDate;
	}

	/**
	 * Creates the new travel.
	 */
	public void createNewTravel() {
		System.out.println("Neue Reise anlegen");
		Bus bus = generateNewBus();
		boolean travelCreated = false;
		Travel travel = generatenewTravel(bus);
		for (Object object : listOfPlatform) {
			Platform platform = (Platform) object;
			if (platform.getPlatformSize() == 0 && bus.getType() == 1) {
				continue;
			}
			boolean isPlatformInUse = isPlatformInUse(platform,
					travel.getArrivalTime(), travel.getDepartureTime());
			if (isPlatformInUse == false) {
				platform.getTravelList().add(travel);
				listOfBus.add(bus);
				listOfTravel.add(travel);
				System.err.println("Die neue Reise wurde an der Plattform "
						+ platform.getPlatformNo() + " angelegt.");
				travelCreated = true;
				break;
			}
		}
		if (travelCreated == false) {
			System.out.println(
					"Leider konnte die Reise nicht angelegt werden, da keine Plattform zu den angegebenen Zeiten zur Verfügung steht.");
		}

	}

	/**
	 * Checks if is platform in use.
	 *
	 * @param platform          the platform
	 * @param arrivalTimeDate   the arrival time date
	 * @param departureTimeDate the departure time date
	 * @return true, if is platform in use
	 */
	public boolean isPlatformInUse(Platform platform, Date arrivalTimeDate,
			Date departureTimeDate) {
		boolean returnValue = false;
		ArrayList<Travel> travelList = platform.getTravelList();
		Long arrivalTimeNew = arrivalTimeDate.getTime();
		Long departureTimeNew = departureTimeDate.getTime();
		for (Travel travel : travelList) {
			Long arrvivalTime = travel.getArrivalTime().getTime();
			Long deputureTime = travel.getDepartureTime().getTime();
			if ((between(arrivalTimeNew, arrvivalTime, deputureTime))
					| (between(departureTimeNew, arrvivalTime, deputureTime))) {
				if (returnValue == false) {
					returnValue = true;
				}
			}
		}
		return returnValue;
	}

	/**
	 * Between.
	 *
	 * @param i                 the i
	 * @param minValueInclusive the min value inclusive
	 * @param maxValueInclusive the max value inclusive
	 * @return true, if successful
	 */
	public static boolean between(Long i, Long minValueInclusive,
			Long maxValueInclusive) {
		if (i >= minValueInclusive && i <= maxValueInclusive)
			return true;
		else
			return false;
	}

	/**
	 * Generatenew travel.
	 *
	 * @param bus the bus
	 * @return the travel
	 */
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

		travel = new Travel(getNextTravelNo(), destination,
				getTimeByString(arrivalTime), getTimeByString(departureTime),
				bus);

		return travel;
	}

	/**
	 * Generate new bus.
	 *
	 * @return the bus
	 */
	public Bus generateNewBus() {

		Scanner sc = new Scanner(System.in);
		int type;
		int comfort;
		int capacity;
		int petrolTankCapacity;
		Bus bus;
		System.out.println("Geben sie bitte den Bus-Typen an");
		System.out.println("");
		System.out.println("'0'-Singledecker:");
		System.out.println("");
		System.out.println("___________________");
		System.out.println("|,-----.,-----.,---.\\");
		System.out.println("||     ||     ||    \\\\");
		System.out.println("|`-----'|-----||-----\\`----.");
		System.out.println("[       |    -||-   _|    (|");
		System.out.println("[  ,--. |_____||___/.--.   |");
		System.out.println("=-(( `))-----------(( `))-==");
		System.out.println("   `--'             `--'");
		System.out.println("");
		System.out.println("");
		System.out.println("'1'-Doubledecker:");
		System.out.println("");
		System.out.println("    .---------------------------.");
		System.out.println("   /,--..---..---..---..---..--. `.");
		System.out.println("  //___||___||___||___||___||___\\_|");
		System.out.println("  [j__ ######################## [_|");
		System.out.println("     \\============================|");
		System.out.println("  .==|  |\"\"\"||\"\"\"||\"\"\"||\"\"\"| |\"\"\"||");
		System.out.println(" /======\"---\"\"---\"\"---\"\"---\"=|  =||");
		System.out.println(" |____    []*          ____  | ==||");
		System.out.println(" //  \\               //  \\ |===||");
		System.out.println(" \"__/\"---------------\"__/\"-+---+'");
		type = Integer.parseInt(sc.nextLine());
		System.out.println("");
		System.out.println("Bitte geben sie die Bus Komfortabilität an ('0'-2.Klasse, '1'-1.Klasse) : ");
		comfort = Integer.parseInt(sc.nextLine());

		if (type == 0) {
			capacity = 100;
			petrolTankCapacity = 200;
		} else {
			capacity = 200;
			petrolTankCapacity = 300;
		}

		bus = new Bus(getNextBusNo(), type, comfort, capacity,
				petrolTankCapacity);

		return bus;
	}

	/**
	 * Gets the next bus no.
	 *
	 * @return the next bus no
	 */
	public int getNextBusNo() {
		Bus tempBus;
		int max = Integer.MIN_VALUE;
		for (Object busItem : listOfBus) {
			tempBus = (Bus) busItem;
			if (tempBus.getBusNo() > max) {
				max = tempBus.getBusNo();
			}
		}
		return max + 1;
	}

	/**
	 * Gets the next travel no.
	 *
	 * @return the next travel no
	 */
	public int getNextTravelNo() {
		Travel tempTravel;
		int max = Integer.MIN_VALUE;
		for (Object travelItem : listOfTravel) {
			tempTravel = (Travel) travelItem;
			if (tempTravel.getTravelNo() > max) {
				max = tempTravel.getTravelNo();
			}
		}
		return max + 1;
	}
}
