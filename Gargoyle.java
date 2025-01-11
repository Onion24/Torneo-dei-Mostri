public class Gargoyle extends Mostro {
    private static final int attacco = 7;
    private static final int attacco_critico = 12;

    public Gargoyle(String nome, int pv) {
        super(nome, pv, attacco);
    }

    @Override
    public int attacca(Mostro m) {
        boolean critico = (int) (Math.random() * 100) < 8;
        int danno = critico ? attacco_critico : attacco;
        boolean paralisi = (int) (Math.random() * 100) < 40;
        if (critico == true) {
            System.out.println("Il Gargoyle " + this.getNome() + " sferra un colpo critico !!!");
        }
        if (paralisi == true) {
            System.out.println("Il Gargoyle " + this.getNome() + " paralizza " + m.getNome() + " !!!");
            m.paralizza();
        }
        this.setDado(danno);
        return (super.attacca(m));
    }

}
