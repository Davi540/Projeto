public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(10, 10);

        // Cadastro dos itens
        Livro livro1 = new Livro(1, "Dom Casmurro");
        Livro livro2 = new Livro(2, "O Hobbit");
        Livro livro3 = new Livro(3, "1984");
        Revista revista1 = new Revista(4, "Superinteressante");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(revista1);

        // Cadastro do usuário
        Aluno aluno = new Aluno("João");

        biblioteca.cadastrarUsuario(aluno);

        // Empréstimos
        System.out.println("\n===== EMPRÉSTIMOS =====");

        biblioteca.emprestar(1, aluno);
        biblioteca.emprestar(2, aluno);
        biblioteca.emprestar(3, aluno);

        // Quarto empréstimo: será recusado
        biblioteca.emprestar(4, aluno);

        // Listar acervo
        biblioteca.listarAcervo();

        // Devolução
        System.out.println("\n===== DEVOLUÇÃO =====");

        biblioteca.devolver(1, aluno);

        biblioteca.listarAcervo();
    }
}