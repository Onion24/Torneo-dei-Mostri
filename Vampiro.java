public class Vampiro extends Mostro {
    private static final int attacco = 4;
    private static final int attacco_critico = 7;

    public Vampiro(String nome, int pv) {
        super(nome, pv, attacco);
    }

    @Override
    public int attacca(Mostro m) {
        boolean critico = (int) (Math.random() * 100) < 8;
        int danno = critico ? attacco_critico : attacco;

        if (critico == true) {
            System.out.println("Il vampiro " + this.getNome() + " sferra un colpo critico !!!");
            this.setDado(danno);
        }

        int rigenerazione = super.attacca(m);

        this.setPv(this.getPv() + rigenerazione);
        System.out.println("Il vampiro " + this.getNome() + " che si rigenera di " + rigenerazione + " pv.");
        return rigenerazione;
    }
}
