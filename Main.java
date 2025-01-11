/*Descrizione del Gioco
Al torneo dei mostri partecipano un numero predefinito di mostri.
Un mostro viene sconfitto quando i suoi punti vita si riducono a zero.
Caratteristiche dei mostri:
Ogni mostro ha un nome, punti vita, un valore di attacco.
I mostri sono organizzati in una gerarchia: una classe base Mostro e sottoclassi per mostri specifici (es. Drago, Troll, Goblin, Ghoul, Minotauro).
Il gioco procede a turni, e i mostri attaccano a turno scegliendo:
Quale mostro attaccare
un'azione di attacco tra quelle disponibili (attacco normale o abilità speciale).
 */
public class Main {
    public static void main(String[] args) {
        Torneo t = new Torneo();

        Drago d = new Drago("Smaug", 25);
        Vampiro dv = new Vampiro("Dracula", 15);
        Troll tr = new Troll("Groteus", 20);
        Gargoyle g = new Gargoyle("Bell", 18);
        Naga n = new Naga("Gorga", 15);

        t.aggiungiMostro(d);
        t.aggiungiMostro(dv);
        t.aggiungiMostro(tr);
        t.aggiungiMostro(g);
        t.aggiungiMostro(n);

        t.iniziaTorneo();

    }

}
