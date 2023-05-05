import java.util.concurrent.Semaphore;

public class ThreadsAdmin extends Thread{
    private ListaEventi eventi;
    private String nomeEvento;
    private int posti;
    private Semaphore lock;
    
    public ThreadsAdmin(ListaEventi eventi, String nomeEvento, int posti, Semaphore lock){
        this.eventi = eventi;
        this.nomeEvento = nomeEvento;
        this.posti = posti;
        this.lock = lock;
    }

    public void run(){
        synchronized(lock){
            try{
                this.setPriority(2);
                System.out.println("Admin crea " + nomeEvento + " con " + posti + " posti");
                eventi.creaEvento(nomeEvento, posti);
                lock.notify();
                sleep(1000);
                System.out.println("Admin aggiunge " + posti + " posti");
                eventi.aggiungiPosti(nomeEvento, posti);
                eventi.stampaEventi();
                sleep(1000);
                lock.wait();
                System.out.println("Admin elimina " + nomeEvento + "\n");
                eventi.eliminaEvento(nomeEvento);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}
