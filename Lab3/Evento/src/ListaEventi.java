import java.util.*;

//Creazione della classe che contiene la lista degli eventi
public class ListaEventi {
    //Creazione della lista di eventi
    private List<Evento> eventi;
    
    //Costruttore
    public ListaEventi() {
        eventi = new ArrayList<Evento>();
    }

    //Metodi per la creazione, aggiunta, prenotazione ed eliminazione degli eventi dalla lista
    public void creaEvento(String nome, Integer n_posti) {
        //Controllo se l'evento è già presente
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                break;
            }
        }
        if(trovato) {
            //Se è presente stampo un messaggio di errore
            System.out.println(nome + " già esistente");
        }else{
            //Altrimenti creo l'evento e lo aggiungo alla lista
            Evento e = new Evento(nome, n_posti);
            eventi.add(e);
        }
    }

    public void aggiungiPosti(String nome, Integer n) {
        //Controllo se l'evento è presente
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                //Se è presente aggiungo i posti
                trovato = true;
                e.aggiungiPosti(n);
                break;
            }
        }
        if(!trovato) {
            //Se non è presente stampo un messaggio di errore
            System.out.println(nome + " non esistente");
        }
    }

    public void prenotaPosti(String nome, Integer n) throws InterruptedException {
        //Controllo se l'evento è presente
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                if(e.getNPosti() < n){
                    //Se non ci sono abbastanza posti stampo un messaggio di errore
                    System.out.println("Posti non disponibili");
                }
                //Altrimenti prenoto i posti
                e.prenotaPosti(n);
                System.out.println("User ha prenotato nell'" + nome + " " + n + " posti");
                break;
            }
        }
        if(!trovato) {
            //Se l'evento non è presente stampo un messaggio di errore
            System.out.println(nome + " non esistente");
        }
    }

    public void eliminaEvento(String nome) {
        //Controllo se l'evento è presente
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                //Se è presente lo elimino
                trovato = true;
                eventi.remove(e);
                break;
            }
        }
        if(!trovato) {
            //Se non è presente stampo un messaggio di errore
            System.out.println(nome + " non esistente");
        }
    }

    //Metodo per stampare la lista degli eventi
    public void stampaEventi() {
        if(eventi.isEmpty()){
            System.out.println("Nessun evento presente\n");
        }else{
            for (Evento e : eventi) {
                System.out.println("Nome Evento: " + e.getNome() + " con " + e.getNPosti() + " posti");
            }
        }
    }
}
