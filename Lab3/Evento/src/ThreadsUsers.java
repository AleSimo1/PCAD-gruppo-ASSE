import java.util.concurrent.Semaphore;

//Creazione della classe dei thread users
public class ThreadsUsers extends Thread{
    //Creazione degli attributi: Lista di eventi, nome dell'evento, numero di posti disponibili e semaforo
    private ListaEventi eventi;
    private String nomeEvento;
    private int posti;
    private Semaphore lock;

    //Costruttore
    public ThreadsUsers(ListaEventi eventi, String nomeEvento, int posti, Semaphore lock){
        this.eventi = eventi;
        this.nomeEvento = nomeEvento;
        this.posti = posti;
        this.lock = lock;
    }

    //Metodo run del thread user
    public void run(){
        //Sincronizzazione del thread user su lock
        synchronized(lock){
            try{
                //Impostazione della priorità del thread user
                this.setPriority(8);
                System.out.println("User sta prenotando nell'" + nomeEvento + " " + posti + " posti");
                //Aspetta che il thread admin abbia finito di creare l'evento
                lock.wait();
                eventi.prenotaPosti(nomeEvento, posti);
                //Notifica che il thread user ha finito di prenotare i posti
                lock.notify();
                eventi.stampaEventi();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
