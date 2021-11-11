import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
//In this class AnimalHotel we do room Booking, room Editing,checkin  and checkout details of Animals.

public class AnimalHotel implements Serializable{

    public AnimalHotel() {
        RoomArray.add(room1);
        RoomArray.add(room2);
        RoomArray.add(room3);
    }

    ArrayList<Room> RoomArray=new ArrayList<Room>();
    ArrayList<Booking> bookingList=new ArrayList<Booking>();
    Animals animals;
    Booking booking=new Booking();

    Room room1=new LightRoom("LightRoom","R001","100x100",2,true);
    Room room2=new DarkRoom("DarkRoom","R002","150x150",1,true);
    Room room3=new NestedRoom("NestedRoom","R003","100x100",1,true);



    //This method only prints the menu
    public void PrintMenu(){
        System.out.println("Hej ! Welcome to the Animal Hotel");
        System.out.println("**********************************");
        System.out.println("Select the Menu");
        System.out.println("1.Booking");
        System.out.println("2.Edit Booking");
        System.out.println("3.Check_In");
        System.out.println("4.Check_Out");
        System.out.println("5.Exit");
        System.out.println("**********************************");
    }

    //In this start() method according to the user choice it goes to switch case and  call the particular method and perform that

    public void start(){
        //FileMethod();
        boolean menuOption=true;
        while(menuOption){
            PrintMenu();
            System.out.print("Enter your Choice > ");
            int menuChoice=getUserInt();
            switch(menuChoice){
                case 1:
                    System.out.println("Hotel Booking");
                    System.out.println("****************************");
                    BookingMethod();
                    break;
                case 2:
                    System.out.println("Edit Booking");
                    System.out.println("*****************************");
                    EditMethod();
                    break;
                case 3:
                    System.out.println("Check_In Details");
                    System.out.println("******************************");
                    CheckInMethod();
                    break;
                case 4:
                    System.out.println("Check_Out Details");
                    System.out.println("*******************************");
                    CancelMethod();
                    break;
                case 5:
                    System.out.println("Exit from Booking");
                    System.out.println("*******************************");
                    System.out.println("You selected to exit");
                    System.out.println("*** Thanks for Visiting Us! ***");
                    menuOption=false;
                    break;
                default:
                    System.out.println("You entered wrong option ");
                    break;
            }
        }
    }

    //This method is used to get integer input from user
    public int getUserInt(){
        int values=0;
        try {
            Scanner scan = new Scanner(System.in);
             values = scan.nextInt();
        }catch (Exception e){
            System.out.println("Error : " + e);
        }
        return values;
    }

    //In this method we get String input from user
    public String getUserString(){
        String myString="";
        try {
            Scanner scan = new Scanner(System.in);
            myString = scan.nextLine();
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
        return myString;
    }

    //In this Booking method we get input from user and do booking for particular animal.
    public void BookingMethod(){

        System.out.print("Enter the name : ");
        String name=getUserString();
        System.out.print("Enter your Favourite Food : ");
        String food=getUserString();
        System.out.print("Enter your Favourite activity : ");
        String activity=getUserString();
        animals = new Animals(name,food, activity);
        animals.setAnimal_name(name);
        animals.setFavourite_food(food);
        animals.setFavourite_activity(activity);
        RoomAvailabilityMethod();

    }

    //In this method we are checking how many number of rooms are available for the particular room whether it is booked or not.
    public void RoomAvailabilityMethod() {
        int quantity;
        String desc;


        System.out.println("Room Details");
        System.out.println("***********************************************************************");

        for (int i = 0; i < 3; i++) {
            System.out.print(RoomArray.get(i).room_number + " ");
            System.out.print(RoomArray.get(i).room_type + " ");
            System.out.println(RoomArray.get(i).describe());
        }

        System.out.println("***********************************************************************");
        System.out.println("Select the Room Type");
        System.out.println("*************************");
        System.out.println("1.LightRoom");
        System.out.println("2.DarkRoom");
        System.out.println("3.NestedRoom");
        System.out.println("**************************");
        System.out.print("Enter the Room Name : ");
        String roomChoice=getUserString();
        System.out.print("Enter the  Room Number: ");
        String number = getUserString();
        Booking booking;

        boolean validateRoom =false;

        for (int i = 0; i < RoomArray.size(); i++) {

                if (RoomArray.get(i).room_number.equalsIgnoreCase(number)) {
                    validateRoom = true;
                    if (RoomArray.get(i).room_type.equalsIgnoreCase(roomChoice)) {
                        while (RoomArray.get(i).RoomChecking) {
                            if (RoomArray.get(i).room_quantity > 0) {
                                System.out.println("Rooms are available.You can Book now ");
                                quantity = RoomArray.get(i).room_quantity - 1;
                                RoomArray.get(i).setRoom_quantity(quantity);
                                desc = RoomArray.get(i).describe();
                                booking = new Booking();
                                booking.setRoom(RoomArray.get(i));
                                booking.setAnimals(animals);
                                bookingList.add(booking);

                                //Adding to file
                                writeBooking(bookingList);
                                //System.out.println(RoomArray.get(i).getRoom_quantity());
                                 if(RoomArray.get(i).getRoom_quantity()== 0) {
                                     RoomArray.get(i).setRoomChecking(false);
                                 }
                                //System.out.println(RoomArray.get(i).getRoomChecking());
                                System.out.println("Your " + booking.toString());
                                break;
                            } else {
                                System.out.println("You cannot book.Rooms are already booked");
                                //bookingList.remove(i);

                                break;
                            }
                        }
                        //RoomArray.get(i).setRoomChecking(true);
                    } else {
                        System.out.println("Sorry,this Room is not available");
                        break;
                    }
                }




        }
            if (validateRoom== false)
                System.out.println("You entered a wrong room number");

        }


    //In this method we can change the room for animals according to their selected activity
    public void EditMethod() {

        System.out.print("Enter the name : ");
        String name = getUserString();
        System.out.print("Enter your Favourite Food : ");
        String food=getUserString();
        System.out.print("Do you want to change your favourite activity? : ");
        String s1 = getUserString();
        String activity;
        if (s1.equalsIgnoreCase("Yes")) {
            System.out.print("Enter your Favourite Activity : ");
            activity = getUserString();

            if (activity.equalsIgnoreCase("Play")) {


               ArrayList<Booking> bookingList = new ArrayList<Booking>();
               //reading the data from file
                bookingList =readBooking();

                for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getAnimals().getAnimal_name().equalsIgnoreCase(name)) {
                            bookingList.get(i).setRoom(room1);
                            bookingList.get(i).getAnimals().setFavourite_food(food);
                            bookingList.get(i).getAnimals().setFavourite_activity(activity);
                            writeBooking(bookingList);
                       // if(bookingList.get(i).getRoom().getRoom_quantity()<= 0){
                         //   System.out.println("No rooms are available");
                          //  break;
                        //}
                    }
                }
               // } else
                //System.out.println("No room available for activity "+ activity);
            } else if (activity.equalsIgnoreCase("Sleep")) {

                    for (int i = 0; i < bookingList.size(); i++) {
                        if (bookingList.get(i).getAnimals().getAnimal_name().equals(name)) {
                            // if (RoomArray.get(i).getRoom_quantity() > 0) {

                            bookingList.get(i).setRoom(room2);
                            bookingList.get(i).getAnimals().setFavourite_food(food);
                            bookingList.get(i).getAnimals().setFavourite_activity(activity);
                            writeBooking(bookingList);
                        }
                    }
                                          //bookingList.remove(i).getRoom();
                            //bookingList.get(i).getRoom();
                            //bookingList.get(i).setRoom();

                       /* } else {
                            System.out.println("No rooms are available");
                            break;
                        }*/


            } else if (activity.equalsIgnoreCase("MakingNest")) {
                //if(checkRoomAvailability(activity)) {

                    for (int i = 0; i < bookingList.size(); i++) {
                        if (bookingList.get(i).getAnimals().getAnimal_name().equalsIgnoreCase(name)) {
                            //System.out.println(RoomArray.get(i).RoomChecking);
                            //if(RoomArray.get(i).getRoomChecking()==true){
                            bookingList.get(i).setRoom(room3);
                            bookingList.get(i).getAnimals().setFavourite_food(food);
                            bookingList.get(i).getAnimals().setFavourite_activity(activity);
                            writeBooking(bookingList);
                        //}else
                          //      System.out.println("No rooms are available");

                        }
                }
                    }

            } else {
                System.out.println("No Changes");
            }
            System.out.println("Updated Booking");
            System.out.println("*********************************");


           for (int i = 0; i < bookingList.size(); i++) {
                System.out.println(bookingList.get(i).toString());
            }

        }




    //This method displays both list of all boookings and individual bookings
    public void CheckInMethod() {
        boolean option = true;
        while (option) {
            System.out.println("Select Booking details");
            System.out.println("***********************");
            System.out.println("1.List of all bookings");
            System.out.println("2.Individual bookings");
            System.out.print("Select the option to display : ");
            int select=getUserInt();
            if(select==1) {

                ArrayList<Booking>bookingArrayList = new ArrayList<Booking>();

                bookingArrayList = readBooking();

                for (int i = 0; i < bookingArrayList.size(); i++){
              //  for (int i = 0; i < bookingList.size(); i++) {
                   // System.out.println("Booking find : " +bookingList.get(i).toString());
                    System.out.println("Booking find : Name : " +  bookingArrayList.get(i).getAnimals().animal_name + " " + "Room Number " + bookingArrayList.get(i).getRoom().room_number  );
                }
                option=false;
            }
            else if(select==2){
                System.out.print("Enter the Room number : ");
                String room_number=getUserString();

                ArrayList<Booking>bookingArrayList = new ArrayList<Booking>();

                bookingArrayList = readBooking();


                for (int i = 0; i < bookingArrayList.size(); i++) {
                    if( bookingArrayList.get(i).getRoom().getRoom_number().equalsIgnoreCase(room_number))
                        System.out.println("Please find your booking  "  +bookingArrayList.get(i).toString());;
                }
                option=false;
            }

        }
    }

    //This is a checkout method where we will do the cancellation for the animals who had booked already
    public void CancelMethod(){
        System.out.print("Enter the name : ");
        String name=getUserString();
        System.out.print("Enter the Room number : ");
        String number=getUserString();

        ArrayList<Booking> bookingArray=new ArrayList<Booking>();
        bookingArray=readBooking();

        for(int i=0;i<bookingArray.size();i++){
            if(name.equals(bookingArray.get(i).getAnimals().animal_name)){
                bookingArray.remove(i);
                System.out.println("Booking Cancelled ");
            }
            break;
        }

        for (int i = 0; i < bookingArray.size(); i++) {
            if (bookingArray.size() != 0)
                System.out.println(bookingArray.get(i).toString());
            else
                System.out.println("No Booking.");
        }
        writeBooking(bookingArray);
    }

    public void writeBooking(ArrayList<Booking> bookingList1) {
        try {
            FileWriter myObj = new FileWriter("C:\\assignment\\filename.txt", true);
          /*  if (!myObj.exists()){
                    myObj.createNewFile() ;
                System.out.println("File created : " + myObj.getName());
            } else {
                System.out.println("File already exists");
            }*/
        } catch (IOException e) {
            System.out.println("An error occured " + e);
        }

        try {
            FileOutputStream saveFile = new FileOutputStream("C:\\assignment\\filename.txt");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(bookingList1);
            save.flush();
            save.close();
        } catch (IOException e) {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
    }

        public ArrayList<Booking> readBooking( ){

            ArrayList<Booking> booking2 =new ArrayList<Booking>();
        try{
            FileInputStream readData = new FileInputStream("C:\\assignment\\filename.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

             booking2 = (ArrayList<Booking>) readStream.readObject();
            readStream.close();

            //System.out.println(booking2.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return booking2;
    }

}



//booking.setRoom(RoomArray.get(i).Room1);
//booking.room.setRoom_quantity(quantity);
//booking.setRoom(RoomArray.get(i));
// if (RoomArray.get(i).getRoom_quantity() > 0) {
                        //bookingList.get(i).setRoom(room2);
                          //      bookingList.get(i).getAnimals().setFavourite_activity(activity);
                            //    if (bookingList.get(i).getRoom().getRoom_quantity() <= 0) {
                              //  System.out.println(bookingList.get(i).getRoom().getRoom_quantity());
                                //System.out.println("No rooms are available");
                                //bookingList.remove(i).getRoom();
                                //bookingList.get(i).getRoom();
                                //bookingList.get(i).setRoom();
                                //}
                       /* } else {
                            System.out.println("No rooms are available");
                            break;
                        }*/