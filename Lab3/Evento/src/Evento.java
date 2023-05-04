public class Evento {
    private String nome;
    private Integer n_posti;

    public Evento(String nome, Integer n_posti) {
        this.nome = nome;
        this.n_posti = n_posti;
    }

    public void aggiungiPosti(Integer n) {
        this.n_posti += n;
    }

    public void prenotaPosti(Integer n) {
        this.n_posti -= n;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public void setNPosti(Integer n_posti) {
        this.n_posti = n_posti;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getNPosti() {
        return this.n_posti;
    }
}
