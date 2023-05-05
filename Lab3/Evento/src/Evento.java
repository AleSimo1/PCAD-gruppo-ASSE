//Creazione della classe Evento
public class Evento {
    //Creazione degli attributi: Nome dell'evento e numero di posti disponibili
    private String nome;
    private Integer n_posti;

    //Costruttore
    public Evento(String nome, Integer n_posti) {
        this.nome = nome;
        this.n_posti = n_posti;
    }

    //Metodi aggiunta e prenotazione posti
    public void aggiungiPosti(Integer n) {
        this.n_posti += n;
    }

    public void prenotaPosti(Integer n) {
        this.n_posti -= n;
    }

    //Inserisce il nome dell'evento
    public void setName(String nome) {
        this.nome = nome;
    }

    //Inserisce il numero di posti disponibili
    public void setNPosti(Integer n_posti) {
        this.n_posti = n_posti;
    }

    //Restituisce il nome dell'evento
    public String getNome() {
        return this.nome;
    }

    //Restituisce il numero di posti disponibili
    public Integer getNPosti() {
        return this.n_posti;
    }
}
