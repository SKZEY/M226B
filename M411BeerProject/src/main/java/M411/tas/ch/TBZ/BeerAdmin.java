package M411.tas.ch.TBZ;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Map;

import com.google.gson.JsonSyntaxException;

public class BeerAdmin implements BeerAdminInterface {
	
	String url = "http://api.brewerydb.com/v2/beers/?";
	String key ="1511d0db4a1d6841481c672455358cff";

	public void loadBeerStyles() throws JsonSyntaxException, ClassNotFoundException, IOException {
		Json json = new Json(url, key);
    	Object object = json.createJavaObjectFromJson(Result.class);
    	Result result = (Result) object;
    	for (SpecialBeer beer : result.data) {
    		beerMap.put(beer.getID() , beer.getName());
		}
	}

	public void printBeerStyles() throws JsonSyntaxException, ClassNotFoundException, IOException {
		if (beerMap.size() == 0) {
			loadBeerStyles();
		}
		beerMap.entrySet().forEach(entry->{
			System.out.println(entry.getKey() + "::" + entry.getValue());
		});
	}

	public void printBeerStyles(String search) throws JsonSyntaxException, ClassNotFoundException, IOException {
		ArrayList<String> listOfKeys = new ArrayList();
		if (beerMap.size() == 0) {
			loadBeerStyles();
		}
		String value;
		for (Map.Entry<String, String> entry : beerMap.entrySet()) 
		{
			// Check if value matches with given value
			value = entry.getValue().toUpperCase();
			
			if (value.indexOf(search.toUpperCase()) !=-1){
				listOfKeys.add(entry.getKey());
			}
		}
		for (String key : listOfKeys) {
			System.out.println(key +"::" + beerMap.get(key));
		}
		
	}

	public void getBeerListForStyle(int idStyle) throws JsonSyntaxException, ClassNotFoundException, IOException {
		Json json = new Json(url, key,idStyle);
    	Object object = json.createJavaObjectFromJson(Result.class);
    	Result result = (Result) object;
    	for (SpecialBeer beer : result.data) {
    		SpecialBeerMap.put(beer.getID() , beer);
		}
		
	}

	public void printBeerList() throws JsonSyntaxException, ClassNotFoundException, IOException {
		if (SpecialBeerMap.size() == 0) {
			getBeerListForStyle(5);
		}
		SpecialBeerMap.entrySet().forEach(entry->{
			SpecialBeer beer = entry.getValue();
			System.out.println("ID: "+beer.getID() + " Name:"+beer.getName());
		});
		
		
	}

	public void printBeer(String id) throws JsonSyntaxException, ClassNotFoundException, IOException {
		if (SpecialBeerMap.size() == 0) {
			getBeerListForStyle(5);
		}
		SpecialBeerMap.entrySet().forEach(entry->{
			SpecialBeer beer = entry.getValue();
			if(beer.getID().equalsIgnoreCase(id)) {
				System.out.println("ID: "+beer.getID() + " Name:"+beer.getName());
				System.out.println("Description: "+beer.getDescription());
			}
			
		});
		
	}
	
}
