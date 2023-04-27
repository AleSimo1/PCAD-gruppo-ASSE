package Lab3;

import java.util.*;

public class Main {

    //Profile types (Threads types)
    private final String ADMIN = "admin";
    private final String USER = "user";

    public static void main(String[] args){
        //Create an ArrayList of MyEvents
        ArrayList<MyEvents> events = new ArrayList<>();

        //Create events
        CreateEvent(events, "Concert", "100");
        CreateEvent(events, "Cinema", "50");
        CreateEvent(events, "Theatre", "30");
        CreateEvent(events, "Concert", "100");

        //Stamp events
        ReadEvent(events);

        //Add seats to events
        AddSeats(events, "Concert", "50");
        AddSeats(events, "Cinema", "50");
        AddSeats(events, "Theatre", "50");

        //Stamp events
        ReadEvent(events);

        //Reserve seats to events
        ReserveSeats(events, "Concert", "50");
        ReserveSeats(events, "Cinema", "50");
        ReserveSeats(events, "Theatre", "50");

        //Stamp events
        ReadEvent(events);

        //Delete events
        DeleteEvent(events, "Concert");
        DeleteEvent(events, "Cinema");
        DeleteEvent(events, "Concert");

        //Stamp events
        ReadEvent(events);
    }

    //Create event only if it doesn't exist
    public static void CreateEvent(ArrayList<MyEvents> events, String name, String n_seats){
        boolean exits = false;
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getName().equals(name)){
                exits = true;
            }
        }
        
        if(!exits){
            events.add(new MyEvents(name, n_seats));
        }else{
            System.out.println("Event already exists");
        }
    }

    //Add seats to event
    public static void AddSeats(ArrayList<MyEvents> events, String name, String n_seats){
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getName().equals(name)){
                int seats = Integer.parseInt(events.get(i).getN_seats());
                seats += Integer.parseInt(n_seats);
                events.get(i).setN_seats(Integer.toString(seats));
            }
        }
    }

    //Reserve seats to event
    public static void ReserveSeats(ArrayList<MyEvents> events, String name, String n_seats){
        int index = -1;
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getName().equals(name)){
                if(Integer.parseInt(events.get(i).getN_seats()) < Integer.parseInt(n_seats)){
                    index = i;
                }
            }
        }

        if(index != -1){
            int seats = Integer.parseInt(events.get(index).getN_seats());
            seats -= Integer.parseInt(n_seats);
            events.get(index).setN_seats(Integer.toString(seats));
        }else{
            System.out.println("Not enough seats");
        }       
    }

    //Read events
    public static void ReadEvent(ArrayList<MyEvents> events){
        for(int i=0; i<events.size(); i++){
            System.out.println(events.get(i).toString());
        }
    }

    //Delete event only if it exists
    public static void DeleteEvent(ArrayList<MyEvents> events, String name){
        int index = -1;
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getName().equals(name)){
                index = i;
            }
        }

        if(index != -1){
            events.remove(index);
        }else{
            System.out.println("Event not found");
        }
    }

}
