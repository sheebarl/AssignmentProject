import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getRoom_number() {
        Room roomtest1=new Room("DarkRoom","R002","150x150",2,true);
             Assertions.assertEquals("R002",roomtest1.getRoom_number());
    }



}