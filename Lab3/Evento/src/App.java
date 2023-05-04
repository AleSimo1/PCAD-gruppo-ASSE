public class App {
    public static void main(String[] args) throws Exception {
        ListaEventi eventi = new ListaEventi();

        //crea thread admin
        ThreadsAdmin admin1 = new ThreadsAdmin(eventi, "evento1", 10);
        ThreadsAdmin admin2 = new ThreadsAdmin(eventi, "evento1", 2);
        ThreadsAdmin admin3 = new ThreadsAdmin(eventi, "evento2", 7);

        //crea thread user
        ThreadsUsers user1 = new ThreadsUsers(eventi, "evento1", 5);
        ThreadsUsers user2 = new ThreadsUsers(eventi, "evento2", 1);
        ThreadsUsers user3 = new ThreadsUsers(eventi, "evento1", 20);

        //start threads
        user1.start();
        admin1.start();
        user2.start();
        admin2.start();
        user3.start();
        admin3.start();
    }
    
}
