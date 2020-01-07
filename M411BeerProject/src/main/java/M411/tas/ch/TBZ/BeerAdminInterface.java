package M411.tas.ch.TBZ;

import java.io.IOException;
import java.util.HashMap;

import com.google.gson.JsonSyntaxException;

public interface BeerAdminInterface {
	//String 1 Key=id 
	//String 2 Value=name
	
	public HashMap<String, String> beerMap = new HashMap<String, String>();
	public HashMap<String, SpecialBeer> SpecialBeerMap = new HashMap<String, SpecialBeer>();
	public void loadBeerStyles() throws JsonSyntaxException, ClassNotFoundException, IOException;
	public void printBeerStyles() throws JsonSyntaxException, ClassNotFoundException, IOException;
	public void printBeerStyles(String search) throws JsonSyntaxException, ClassNotFoundException, IOException;
	public void getBeerListForStyle(int idStyle) throws JsonSyntaxException, ClassNotFoundException, IOException;
	public void printBeerList() throws JsonSyntaxException, ClassNotFoundException, IOException;
	public void printBeer(String id) throws JsonSyntaxException, ClassNotFoundException, IOException;
	
	
}

