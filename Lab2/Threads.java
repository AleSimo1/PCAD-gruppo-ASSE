package Lab2;

public class Threads implements Runnable{
    Thread t;
    Threads(Thread t){
        t = new Thread(null, t, null, 0, false);
        t.start();
    }
    @Override
    public void run() {

    }
}