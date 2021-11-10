public class Booking {

    Room room;
    Animals animals;


    @Override
    public String toString() {
        return "Booking { " +
                "Room_number = " + room  + " " +
                ", Animals_details = " + animals +
                '}';
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Animals getAnimals() {
        return animals;
    }

    public void setAnimals(Animals animals) {
        this.animals = animals;
    }



}

