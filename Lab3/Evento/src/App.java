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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEventi eventi = new ListaEventi();
        List<ThreadsUsers> users = new ArrayList<>();
        List<ThreadsAdmin> admins = new ArrayList<>();

        admins.add(new ThreadsAdmin(eventi, "Evento1", 10));
        admins.add(new ThreadsAdmin(eventi, "Evento2", 20));
        admins.add(new ThreadsAdmin(eventi, "Evento3", 30));
        admins.add(new ThreadsAdmin(eventi, "Evento4", 40));

        users.add(new ThreadsUsers(eventi, "Evento1", 5));
        users.add(new ThreadsUsers(eventi, "Evento2", 10));
        users.add(new ThreadsUsers(eventi, "Evento3", 15));
        users.add(new ThreadsUsers(eventi, "Evento4", 20));

        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 14, 30, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(5));
            try {
                for (ThreadsUsers user : users) {
                    executor.execute(user);
                }
                for (ThreadsAdmin admin : admins) {
                    executor.execute(admin);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                executor.shutdown();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
