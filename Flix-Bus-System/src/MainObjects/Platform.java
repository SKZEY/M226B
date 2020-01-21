package MainObjects;

import java.util.ArrayList;

/*
 *  @author melvin 
 * */
/**
 * The Class Platform.
 */
public class Platform {

	/** The platform no. */
	private int platformNo;

	/** The platform size. */
	private int platformSize;

	/** The travel list. */
	private ArrayList<Travel> travelList;

	/** The occupied. */
	private int occupied;

	/**
	 * Instantiates a new platform.
	 *
	 * @param platformNo   the platform no
	 * @param platformSize the platform size
	 * @param travelList   the travel list
	 */
	public Platform(int platformNo, int platformSize,
			ArrayList<Travel> travelList) {
		this.platformNo = platformNo;
		this.platformSize = platformSize;
		this.travelList = travelList;
	}

	/**
	 * Bus arrive in platform.
	 */
	public void busArriveInPlatform() {
		this.occupied = 1;
	}

	/**
	 * Bus leave from platform.
	 */
	public void busLeaveFromPlatform() {
		this.occupied = 0;
	}

	/**
	 * Checks if is platform occupied.
	 *
	 * @return the int
	 */
	public int isPlatformOccupied() {
		return occupied;
	}

	/**
	 * Gets the platform no.
	 *
	 * @return the platform no
	 */
	public int getPlatformNo() {
		return platformNo;
	}

	/**
	 * Gets the platform size.
	 *
	 * @return the platform size
	 */
	public int getPlatformSize() {
		return platformSize;
	}

	/**
	 * Gets the travel list.
	 *
	 * @return the travel list
	 */
	public ArrayList<Travel> getTravelList() {
		return travelList;
	}

}
