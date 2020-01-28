package TeamRocket.MainObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import TeamRocket.Reader.ReadBus;
import TeamRocket.Reader.ReadBusTerminal;
import TeamRocket.Reader.ReadPlatform;
import TeamRocket.Reader.ReadTravel;
import TeamRocket.UserInterface.TUI;

/**
 * The Class Starter.
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class Starter {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// Data Path
		String filePath = System.getProperty("user.dir") + pathBuilder()
				+ "data";
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
				filePath + pathBuilder() + "busTerminal.csv", ";",
				listOfPlatform);
		listOfBusTerminal = readBusTerminal.getListOfObject();

		TUI tui = new TUI(listOfPlatform, listOfTravel, listOfBus);
		tui.mainMenu();

	}

	/**
	 * Name.
	 *
	 * @param test the test
	 */
	public void name(int test) {

	}

	/**
	 * Name.
	 *
	 * @param test the test
	 */
	public void name(String test) {

	}

	/**
	 * Test.
	 */
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

	/**
	 * Path builder.
	 *
	 * @return the string
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
