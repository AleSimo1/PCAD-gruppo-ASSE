/*
	Gruppo 18: Un viaggio
	Componenti:
		* Alessandro Simoni S5029301
		* Simone Lutero S4801326
		* Eleonora Fabbri S4842235
		* Samuele Osti S4816869
*/

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        //Creazione della lista di eventi, della lista thread users e di quella thread admins
        ListaEventi eventi = new ListaEventi();
        List<ThreadsUsers> users = new ArrayList<>();
        List<ThreadsAdmin> admins = new ArrayList<>();
        //Creazione del semaforo per la sincronizzazione
        Semaphore lock = new Semaphore(1);

        //Creazione dei thread users e admins e inserimento nelle rispettive liste
        admins.add(new ThreadsAdmin(eventi, "Evento1", 10, lock));
        admins.add(new ThreadsAdmin(eventi, "Evento2", 20, lock));
        admins.add(new ThreadsAdmin(eventi, "Evento3", 30, lock));
        admins.add(new ThreadsAdmin(eventi, "Evento4", 40, lock));

        users.add(new ThreadsUsers(eventi, "Evento1", 5, lock));
        users.add(new ThreadsUsers(eventi, "Evento2", 10, lock));
        users.add(new ThreadsUsers(eventi, "Evento3", 15, lock));
        users.add(new ThreadsUsers(eventi, "Evento4", 20, lock));

        //Creazione del thread pool e inserimento dei thread users e admins
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 16, 30, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(5));
            try {
                for (int i = 0; i < 4; i++) {
                    //Esecuzione dei thread users e admins
                    executor.execute(users.get(i));
                    executor.execute(admins.get(i));
                }
            } catch (Exception e) {
                //Stampa dell'eccezione e chiusura del thread pool
                System.out.println(e.getMessage());
                executor.close();
            } finally {
                //Chiusura del thread pool al termine dell'esecuzione
                executor.shutdown();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
