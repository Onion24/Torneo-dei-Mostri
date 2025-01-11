
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
import java.util.ArrayList;
import java.util.Random;

public class Torneo {
    static Random r = new Random();
    private ArrayList<Mostro> mostri;
    private ArrayList<Mostro> morti;
    private int turno;

    public Torneo() {
        this.mostri = new ArrayList<>();
        this.morti = new ArrayList<>();
        this.turno = 0;
    }

    public void aggiungiMostro(Mostro m) {
        mostri.add(m);
    }

    public void eseguiTurno() {
        if (mostri.size() <= 1)
            return;

        Mostro attaccante = mostri.get(turno);

        if (attaccante.isParalizzato()) {
            System.out.println("Il mostro " + attaccante.getNome() + " è paralizzato e salta il turno!");
            attaccante.togli_paralizza();
        } else {
            Mostro attaccato;
            int indiceAttaccato;
            if (attaccante.isAvvelenato()) {
                System.out.println("Il mostro " + attaccante.getNome() + " è avvelenato e perde 2 pv!");
                attaccante.setPv(attaccante.getPv() - 2);
                attaccante.togli_avvelenamento();
            }
            // Determina casualmente il bersaglio diverso dall'attaccante

            do {
                indiceAttaccato = r.nextInt(mostri.size());
                attaccato = mostri.get(indiceAttaccato);
            } while (attaccato == attaccante);

            // L'attaccante esegue l'attacco
            attaccante.attacca(attaccato);

            // Se il bersaglio è morto, lo rimuove
            if (!attaccato.isAlive()) {
                morti.add(attaccato);
                mostri.remove(indiceAttaccato);
                System.out.println("Il mostro " + attaccato.getNome() + " è stato eliminato!");
                if (indiceAttaccato < turno)
                    turno--;
            }
        }

        // Passa al turno successivo
        if (mostri.size() > 0) {
            turno = (turno + 1) % mostri.size();
        }
    }

    public void iniziaTorneo() {
        while (mostri.size() > 1) {
            eseguiTurno();
            System.out.println(" ");
            System.out.println(" ----<<< FINE TURNO >>>----");
            System.out.println(" ");
        }
        System.out.println("Il vincitore del torneo è: " + mostri.get(0).getNome());
    }
}
