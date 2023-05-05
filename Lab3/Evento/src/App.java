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
        ListaEventi eventi = new ListaEventi();
        List<ThreadsUsers> users = new ArrayList<>();
        List<ThreadsAdmin> admins = new ArrayList<>();
        Semaphore lock = new Semaphore(1);

        admins.add(new ThreadsAdmin(eventi, "Evento1", 10, lock));
        admins.add(new ThreadsAdmin(eventi, "Evento2", 20, lock));
        admins.add(new ThreadsAdmin(eventi, "Evento3", 30, lock));
        admins.add(new ThreadsAdmin(eventi, "Evento4", 40, lock));

        users.add(new ThreadsUsers(eventi, "Evento1", 5, lock));
        users.add(new ThreadsUsers(eventi, "Evento2", 10, lock));
        users.add(new ThreadsUsers(eventi, "Evento3", 15, lock));
        users.add(new ThreadsUsers(eventi, "Evento4", 20, lock));

        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 16, 30, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(5));
            try {
                for (int i = 0; i < 4; i++) {
                    executor.execute(users.get(i));
                    executor.execute(admins.get(i));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                executor.close();
            } finally {
                executor.shutdown();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
