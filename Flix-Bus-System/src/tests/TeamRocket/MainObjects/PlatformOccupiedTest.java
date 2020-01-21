package TeamRocket.MainObjects;

import TeamRocket.Reader.ReadBus;
import TeamRocket.Reader.ReadTravel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlatformOccupiedTest {

    @org.junit.jupiter.api.Test
    void isPlatformOccupied() {
        ArrayList<Travel> testList = new ArrayList<>();
        Platform test = new Platform(7, 4, testList);

        // isPlatformOccupied testen
        test.busArriveInPlatform();
        assertEquals(1, test.isPlatformOccupied(), "occupied must be 1");

        // getPlatformNom testen
        assertEquals(7, test.getPlatformNo(), "Platformnumber must be 7");
    }
}