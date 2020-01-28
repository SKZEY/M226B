package TeamRocket.UserInterface;

/**
 * The Class PlatformNotFoundException.
 * 
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class PlatformNotFoundException extends Exception {

	/**
	 * Instantiates a new platform not found exception.
	 *
	 * @param errormessage the errormessage
	 */
	public PlatformNotFoundException(String errormessage) {
		super(errormessage);
	}
}
