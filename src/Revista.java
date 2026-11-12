public class Revista extends itembiblioteca {

    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazo() {
        return 7;
    }

    @Override
    public double getMulta() {
        return 1.00;
    }
}