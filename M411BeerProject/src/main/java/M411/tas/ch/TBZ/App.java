package M411.tas.ch.TBZ;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.JsonIOException;

public class App 
{
    public static void main( String[] args ) throws Throwable, JsonIOException, FileNotFoundException
    {
    	int specialBierKey = 5;
    	String value = null;
    	int input = 0;
    	
    	Scanner sc = new Scanner(System.in);
    	
    	BeerAdmin basicBeer = new BeerAdmin();
    	BeerAdmin specialBeer = new BeerAdmin();

    	do {
    	System.out.println("***************************************************");
    	System.out.println("BIER-WEBSERVICE");
    	System.out.println("***************************************************");
    	System.out.println();
    	System.out.println("-Benutzermenü-");
    	System.out.println();
    	System.out.println("<1>. Laden der Standard Biere (loadBeerStyles())");
    	System.out.println("<2>. Ausgeben der Standard Biere (printBeerStyles())");
    	System.out.println("<3>. Suchen in der Standardbierliste (printBeerStyles(String search))");
    	System.out.println();
    	System.out.println("<4>. Laden der Spezialbiere (getBeerListForStyle(int idStyle))");
    	System.out.println("<5>. Ausgeben der Spezialbiere (printBeerList())");
    	System.out.println("<6>. Suchen nach ID in der Spezialbierliste (printBeer(String id))");
    	System.out.println();
    	System.out.println("<0>. Programm beenden");
    	
    	input = Integer.parseInt(sc.nextLine());
    	
    	switch (input) {
		case 1:
			basicBeer.loadBeerStyles();
			System.out.println("Die Standardbiere wurden erfolgreich geladen");
			break;
		case 2:
			basicBeer.printBeerStyles();
			break;
		case 3:
			System.out.println("Suchbegriff (Name) : )");
			value = sc.nextLine();
			basicBeer.printBeerStyles(value);
			break;
		case 4:
			specialBeer.getBeerListForStyle(specialBierKey);
			System.out.println("Die Spezialbiere wurden erfolgreich geladen");
			break;
		case 5:
			specialBeer.printBeerList();
			break;
		case 6:
			System.out.println("Suchbegriff (ID) : ");
			value = sc.nextLine();
			specialBeer.printBeer(value);
			break;
		}
    	
    	}while(input != 0 );
    } 
}
