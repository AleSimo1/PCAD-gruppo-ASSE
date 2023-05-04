public class ThreadsUsers extends Thread{
    private ListaEventi eventi;
    private String nomeEvento;
    private int posti;

    public ThreadsUsers(ListaEventi eventi, String nomeEvento, int posti){
        this.eventi = eventi;
        this.nomeEvento = nomeEvento;
        this.posti = posti;
    }

    public void run(){
        synchronized(eventi){
            try{
                System.out.println("User prenota nell'" + nomeEvento + " " + posti + " posti");
                eventi.prenotaPosti(nomeEvento, posti);
                eventi.stampaEventi();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
