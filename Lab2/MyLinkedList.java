package Lab2;

import java.util.concurrent.LinkedBlockingQueue;

public class MyLinkedList<E> extends LinkedBlockingQueue<E> {
    private boolean finished = false;

    MyLinkedList(){super();}

    public boolean isFinished(){return finished;}

    public boolean isNull(){return this == null;}

    public void setFinished(boolean finished){this.finished = finished;}
    
}
