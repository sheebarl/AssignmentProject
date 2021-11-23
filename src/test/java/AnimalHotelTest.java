import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnimalHotelTest {


    @Test
    void bookingMethod() {
        Animals animalstest=new Animals("Kitty","Fish","Play");
        Booking bookinglist=new Booking();
        bookinglist.setAnimals(animalstest);
        assertEquals(animalstest.toString(),bookinglist.getAnimals().toString());
    }

    @Test
    void roomAvailabilityMethod() {
        AnimalHotel animalHotel=new AnimalHotel();
        Room roomTest=new LightRoom("LightRoom","R001","100x100",2,true);
        Booking bookinglist=new Booking();
        bookinglist.setRoom(roomTest);
        int quantity=bookinglist.getRoom().getRoom_quantity()-1;
        Assertions.assertTrue(animalHotel.room1.getRoom_type().equals("LightRoom")&& roomTest.getRoom_type().equalsIgnoreCase("LightRoom"));
        Assertions.assertTrue(animalHotel.room1.getRoom_number().equals("R001")&& roomTest.getRoom_number().equalsIgnoreCase("R001"));
        Assertions.assertEquals(1,quantity);

    }



    @Test
    void filterBookings() {
        Animals animalstest=new Animals("Kitty","Fish","Play");
        Booking bookinglist = new Booking();
        bookinglist.setAnimals(animalstest);
        assertTrue(animalstest.getAnimal_name().contains("K"));
        assertEquals("Kitty", bookinglist.getAnimals().getAnimal_name());

    }
}