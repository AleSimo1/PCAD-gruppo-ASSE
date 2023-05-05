import java.util.concurrent.Semaphore;

//Creazione della classe dei thread admins
public class ThreadsAdmin extends Thread{
    //Creazione degli attributi: Lista di eventi, nome dell'evento, numero di posti disponibili e semaforo
    private ListaEventi eventi;
    private String nomeEvento;
    private int posti;
    private Semaphore lock;
    
    //Costruttore
    public ThreadsAdmin(ListaEventi eventi, String nomeEvento, int posti, Semaphore lock){
        this.eventi = eventi;
        this.nomeEvento = nomeEvento;
        this.posti = posti;
        this.lock = lock;
    }

    //Metodo run del thread admin
    public void run(){
        //Sincronizzazione del thread admin su lock
        synchronized(lock){
            try{
                //Impostazione della priorità del thread admin
                this.setPriority(2);
                System.out.println("Admin crea " + nomeEvento + " con " + posti + " posti");
                eventi.creaEvento(nomeEvento, posti);
                //Notifica che il thread admin ha finito di creare l'evento
                lock.notify();
                //Addormenta il thread admin per 1 secondo
                sleep(1000);
                System.out.println("Admin aggiunge " + posti + " posti");
                //Aggiunge i posti all'evento
                eventi.aggiungiPosti(nomeEvento, posti);
                eventi.stampaEventi();
                sleep(1000);
                //Aspetta che il thread user abbia finito di prenotare i posti
                lock.wait();
                System.out.println("Admin elimina " + nomeEvento + "\n");
                //Elimina l'evento
                eventi.eliminaEvento(nomeEvento);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}
