package TeamRocket.MainObjects;

import java.util.ArrayList;

/*
 *  @author melvin 
 * */
/**
 * The Class BusTerminal.
 */
public class BusTerminal {

	/** The platform list. */
	private ArrayList<Platform> platformList = new ArrayList<Platform>();

	/** The name of terminal. */
	private String nameOfTerminal;

	/**
	 * Instantiates a new bus terminal.
	 *
	 * @param nameOfTerminal the name of terminal
	 * @param platformList   the platform list
	 */
	public BusTerminal(String nameOfTerminal,
			ArrayList<Platform> platformList) {
		this.nameOfTerminal = nameOfTerminal;
		this.platformList = platformList;
	}

	/**
	 * Sets the name of terminal.
	 *
	 * @param nameOfTerminal the new name of terminal
	 */
	public void setNameOfTerminal(String nameOfTerminal) {
		this.nameOfTerminal = nameOfTerminal;
	}

	/**
	 * Adds the platform.
	 *
	 * @param platform the platform
	 */
	public void addPlatform(Platform platform) {
		this.platformList.add(platform);
	}

	/**
	 * Close platform.
	 *
	 * @param platformToClose the platform to close
	 */
	public void closePlatform(Platform platformToClose) {
		platformList.remove(platformToClose);
	}

	/**
	 * Gets the name of terminal.
	 *
	 * @return the name of terminal
	 */
	public String getNameOfTerminal() {
		return nameOfTerminal;
	}

	/**
	 * Gets the platform list.
	 *
	 * @return the platform list
	 */
	public ArrayList<Platform> getPlatformList() {
		return platformList;
	}

}