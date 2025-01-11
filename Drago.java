public class Drago extends Mostro {
    private int cooldown;
    private static final int attaccoSoffio = 10;
    private static final int attaccoArtiglio = 5;
    private static final int ricaricaSoffio = 3;

    public Drago(String nome, int pv) {
        super(nome, pv, attaccoSoffio);
        this.cooldown = 0;
    }

    @Override
    public int attacca(Mostro m) {
        if (cooldown == 0) {
            this.setDado(attaccoSoffio);
            cooldown = ricaricaSoffio;
            System.out.println(this.getNome() + " sferra un attacco con soffio!");
        } else {
            this.setDado(attaccoArtiglio);
            cooldown--;
            System.out.println(this.getNome() + " sferra un attacco con artiglio!");
        }
        return (super.attacca(m));
    }
}