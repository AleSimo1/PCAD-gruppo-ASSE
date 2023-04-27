package Lab3;

public class MyThreads extends Thread {
    int id;
    String type;

    public MyThreads(int id, String type){
        this.id = id;
        this.type = type;
    }

    public void run(){
        System.out.println("Thread " + id + " - " + type);
    }

    
}
