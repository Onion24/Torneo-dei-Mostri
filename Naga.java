public class Naga extends Mostro {
    private static final int attacco = 5;
    private static final int attacco_critico = 7;

    public Naga(String nome, int pv) {
        super(nome, pv, attacco);
    }

    @Override
    public int attacca(Mostro m) {
        boolean critico = (int) (Math.random() * 100) < 8;
        int danno = critico ? attacco_critico : attacco;
        boolean veleno = (int) (Math.random() * 100) < 25;
        if (critico == true) {
            System.out.println("Il Naga " + this.getNome() + " sferra un colpo critico !!!");
        }
        if (veleno == true) {
            System.out.println("Il Naga " + this.getNome() + " avvelena " + m.getNome() + " !!!");
            m.paralizza();
        }
        this.setDado(danno);
        return (super.attacca(m));
    }

}
