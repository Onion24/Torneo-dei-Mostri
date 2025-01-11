/**
 * Al torneo dei mostri partecipano un numero predefinito di mostri.
 * Un mostro viene sconfitto quando i suoi punti vita si riducono a zero.
 * Caratteristiche dei mostri:
 * Ogni mostro ha un nome, punti vita, un valore di attacco.
 * I mostri sono organizzati in una gerarchia: una classe base Mostro e
 * sottoclassi per mostri specifici (es. Drago, Troll, Goblin, Ghoul,
 * Minotauro).
 * Il gioco procede a turni, e i mostri attaccano a turno scegliendo:
 * Quale mostro attaccare
 * un'azione di attacco tra quelle disponibili (attacco normale o abilità
 * speciale).
 */
interface Paralizzabile {
    public void paralizza();

    public void togli_paralizza();
}

interface Avvelenabile {
    public void avvelena();

    public void togli_avvelenamento();
}

public abstract class Mostro implements Paralizzabile, Avvelenabile {
    protected String nome;
    protected int pv;
    protected int pvMax; // Aggiunto per memorizzare la vita massima
    protected int dado;
    protected boolean paralizzato;
    protected boolean avvelenato;

    public Mostro(String nome, int pv, int dado) {
        this.nome = nome;
        this.pv = pv;
        this.pvMax = pv;
        this.dado = dado;
        this.paralizzato = false;
        this.avvelenato = false;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = Math.min(pv, pvMax);
    }

    public int getPvMax() {
        return pvMax;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public boolean isParalizzato() {
        return paralizzato;
    }

    public boolean isAvvelenato() {
        return avvelenato;
    }

    public void paralizza() {
        this.paralizzato = true;
    }

    public void togli_paralizza() {
        this.paralizzato = false;
    }

    public void avvelena() {
        this.avvelenato = true;
    }

    public void togli_avvelenamento() {
        this.avvelenato = false;
    }

    public boolean isAlive() {
        if (pv > 0)
            return true;
        return false;
    }

    public int attacca(Mostro m) {
        int danno = (int) (Math.random() * dado) + 1;
        m.setPv(m.getPv() - danno);
        System.out.println("Il mostro " + this.nome + " ha attaccato " + m.nome + " e ha inflitto " + danno
                + " danni e gli rimangono " + m.pv + " punti vita.");
        return danno;
    }
}
