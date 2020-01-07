package MainObjects;
import java.util.*;


public class BusTerminal {

	private ArrayList<Platform> platformList = new ArrayList<Platform>();
	private String nameOfTerminal;
	
	public BusTerminal(String nameOfTerminal, ArrayList<Platform> platformList) {
		this.nameOfTerminal = nameOfTerminal;
		this.platformList = platformList;
	}
	
	public void setNameOfTerminal(String nameOfTerminal) {
		this.nameOfTerminal = nameOfTerminal;
	}
	
	public void addPlatform(Platform platform) {
		this.platformList.add(platform);
	}
	
	public void closePlatform(Platform platformToClose) {
				platformList.remove(platformToClose);
	}
	
	public String getNameOfTerminal() {
		return nameOfTerminal;
	}
	public ArrayList<Platform> getPlatformList() {
		return platformList;
	}
	
}
