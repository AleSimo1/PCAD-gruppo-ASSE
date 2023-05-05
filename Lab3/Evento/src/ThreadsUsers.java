import java.util.concurrent.Semaphore;

public class ThreadsUsers extends Thread{
    private ListaEventi eventi;
    private String nomeEvento;
    private int posti;
    private Semaphore lock;

    public ThreadsUsers(ListaEventi eventi, String nomeEvento, int posti, Semaphore lock){
        this.eventi = eventi;
        this.nomeEvento = nomeEvento;
        this.posti = posti;
        this.lock = lock;
    }

    public void run(){
        synchronized(lock){
            try{
                this.setPriority(8);
                System.out.println("User sta prenotando nell'" + nomeEvento + " " + posti + " posti");
                lock.wait();
                eventi.prenotaPosti(nomeEvento, posti);
                lock.notify();
                eventi.stampaEventi();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
