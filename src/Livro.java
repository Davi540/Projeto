public class Livro extends itembiblioteca {

    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazo() {
        return 14;
    }

    @Override
    public double getMulta() {
        return 0.50;
    }
}