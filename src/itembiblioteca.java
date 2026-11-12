public abstract class itembiblioteca {

    private int codigo;
    private String titulo;
    private boolean disponivel;

    public itembiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    protected void marcarEmprestado() {
        disponivel = false;
    }

    protected void marcarDisponivel() {
        disponivel = true;
    }

    public abstract int getPrazo();
    public abstract double getMulta();

    @Override
    public String toString() {
        return "Código: " + codigo +
                " | Título: " + titulo +
                " | Disponível: " + disponivel;
    }
}