import java.io.Serializable;

public class LightRoom extends Room implements Serializable {

       public LightRoom(String type,String number, String dimension, int quantity,boolean check ){
              super(type,number,dimension,quantity,check);
       }

       public String describe(){
              room_description="It is a LightRoom where the  animals can play " ;
              // System.out.println(room_description);
              return  room_description;

       }

       public String toString(){
              //return room_number + " " + "Room_Description = " + describe() + " " + getRoom_quantity();
              return room_number + " " + "Room_Type : " + room_type + " " + "Room_Description : " + describe();
       }

       public String getRoom_description(){
              return room_description;
       }

       public void setRoom_description(String description){
              this.room_description=description;
       }

       public String getRoom_number(){
              return room_number;
       }

       public void setRoom_number(String number){
              this.room_number=number;
       }

       public String getRoom_type(){
              return room_type;
       }

       public void setRoom_type(String type){
              this.room_type=type;
       }

       public int getRoom_quantity(){
              return room_quantity;
       }

       public void setRoom_quantity(int quantity){
              this.room_quantity=quantity;
       }
}