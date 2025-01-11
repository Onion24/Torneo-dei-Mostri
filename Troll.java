public class Troll extends Mostro {
    private static final int attacco = 7;
    private static final int attacco_critico = 12;

    public Troll(String nome, int pv) {
        super(nome, pv, attacco);
    }

    @Override
    public int attacca(Mostro m) {
        boolean critico = (int) (Math.random() * 100) < 15;
        int danno = critico ? attacco_critico : attacco;
        if (critico == true) {
            System.out.println("Il Troll " + this.getNome() + " sferra un colpo critico !!!");
        }
        this.setDado(danno);
        return (super.attacca(m));
    }

}
