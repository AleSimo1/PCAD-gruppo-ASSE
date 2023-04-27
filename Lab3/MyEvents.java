package Lab3;

public class MyEvents {
    private String name;
    private String n_seats;

    public MyEvents(String name, String n_seats) {
        this.name = name;
        this.n_seats = n_seats;
    }

    public String getName() {
        return name;
    }

    public String getN_seats() {
        return n_seats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setN_seats(String n_seats) {
        this.n_seats = n_seats;
    }

    public String toString() {
        return "Event: " + name + " - " + n_seats + " seats";
    }
    
}
