import java.util.*;

public class ListaEventi {
    private List<Evento> eventi;
    
    public ListaEventi() {
        eventi = new ArrayList<Evento>();
    }

    public void creaEvento(String nome, Integer n_posti) {
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                break;
            }
        }
        if(trovato) {
            System.out.println("Evento già esistente");
        }else{
            Evento e = new Evento(nome, n_posti);
            eventi.add(e);
        }
    }

    public void aggiungiPosti(String nome, Integer n) {
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                e.aggiungiPosti(n);
                break;
            }
        }
        if(!trovato) {
            System.out.println("Evento non esistente");
        }
    }

    public void prenotaPosti(String nome, Integer n) {
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                e.prenotaPosti(n);
                break;
            }
        }
        if(!trovato) {
            System.out.println("Evento non esistente");
        }
    }

    public void eliminaEvento(String nome) {
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                eventi.remove(e);
                break;
            }
        }
        if(!trovato) {
            System.out.println("Evento non esistente");
        }
    }

    public void stampaEventi() {
        if(eventi.isEmpty()){
            System.out.println("Nessun evento");
        }else{
            for (Evento e : eventi) {
                System.out.println(e.getNome() + " " + e.getNPosti());
            }
        }
    }
}
