package TeamRocket.MainObjects;

import java.util.ArrayList;

import TeamRocket.Reader.ReadBus;
import TeamRocket.Reader.ReadBusTerminal;
import TeamRocket.Reader.ReadPlatform;
import TeamRocket.Reader.ReadTravel;
import TeamRocket.UserInterface.TUI;

/**
 * Main class of the App.
 * 
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class Starter {

	/**
	 * starts the App
	 *
	 * @param args Arguments (default: none)
	 */
	public static void main(String[] args) {

		// Data Path
		String filePath = System.getProperty("user.dir") + pathBuilder() + "data";
		// Bus
		ArrayList<Object> listOfBus = new ArrayList<>();
		ReadBus readBus = new ReadBus(null, ";");
		readBus.setFilePath(pathBuilder(), pathBuilder() + "bus.csv");
		listOfBus = readBus.getListOfObject();

		// Travel
		ArrayList<Object> listOfTravel = new ArrayList<>();
		ReadTravel readTravel = new ReadTravel(
				filePath + pathBuilder() + "travel.csv", ";", listOfBus);
		listOfTravel = readTravel.getListOfObject();

		// Platform
		ArrayList<Object> listOfPlatform = new ArrayList<>();
		ReadPlatform readPlatform = new ReadPlatform(
				filePath + pathBuilder() + "platform.csv", ";", listOfTravel);
		listOfPlatform = readPlatform.getListOfObject();

		// BusTerminal
		ArrayList<Object> listOfBusTerminal = new ArrayList<>();
		ReadBusTerminal readBusTerminal = new ReadBusTerminal(
				filePath + pathBuilder() + "busTerminal.csv", ";", listOfPlatform);
		listOfBusTerminal = readBusTerminal.getListOfObject();

		TUI tui = new TUI(listOfPlatform, listOfTravel, listOfBus, listOfBusTerminal);
		tui.mainMenu();

	}

	/**
	 * returns the system's delimiting character
	 *
	 * @return String (either "/" or "\")
	 */
	static String pathBuilder() {
		String os = System.getProperty("os.name"); // check os type
		if (os.startsWith("Windows")) {
			return "\\";
		} else { // in case of unix-os
			return "/";
		}

	}
}
