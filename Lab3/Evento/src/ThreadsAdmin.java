public class ThreadsAdmin extends Thread{
    private ListaEventi eventi;
    private String nomeEvento;
    private int posti;
    
    public ThreadsAdmin(ListaEventi eventi, String nomeEvento, int posti){
        this.eventi = eventi;
        this.nomeEvento = nomeEvento;
        this.posti = posti;
    }

    public void run(){
        synchronized(eventi){
            try{
                System.out.println("Admin crea " + nomeEvento + " con " + posti + " posti");
                eventi.creaEvento(nomeEvento, posti);
                eventi.stampaEventi();
                System.out.println("Admin aggiunge " + posti + " posti");
                eventi.aggiungiPosti(nomeEvento, posti);
                eventi.stampaEventi();
                System.out.println("Admin elimina " + nomeEvento);
                eventi.eliminaEvento(nomeEvento);
                eventi.stampaEventi();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}
