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
            System.out.println(nome + " già esistente");
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
            System.out.println(nome + " non esistente");
        }
    }

    public void prenotaPosti(String nome, Integer n) throws InterruptedException {
        boolean trovato = false;
        for (Evento e : eventi) {
            if (e.getNome().equals(nome)) {
                trovato = true;
                if(e.getNPosti() < n){
                    System.out.println("Posti non disponibili");
                }
                e.prenotaPosti(n);
                System.out.println("User ha prenotato nell'" + nome + " " + n + " posti");
                break;
            }
        }
        if(!trovato) {
            System.out.println(nome + " non esistente");
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
            System.out.println(nome + " non esistente");
        }
    }

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
