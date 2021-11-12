import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnimalHotelTest {


    @Test
    void roomAvailabilityMethod() {
        Room roomTest=new LightRoom("LightRoom","R001","100x100",1,true);
        Assertions.assertEquals("LightRoom",roomTest.getRoom_type());
    }


}