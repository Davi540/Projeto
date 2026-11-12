public class Biblioteca {

    private itembiblioteca[] acervo;
    private Usuario[] usuarios;

    private int quantidadeItens;
    private int quantidadeUsuarios;

    public Biblioteca(int tamanhoAcervo, int tamanhoUsuarios) {
        acervo = new itembiblioteca[tamanhoAcervo];
        usuarios = new Usuario[tamanhoUsuarios];

        quantidadeItens = 0;
        quantidadeUsuarios = 0;
    }

    public void cadastrarItem(itembiblioteca item) {
        if (quantidadeItens < acervo.length) {
            acervo[quantidadeItens] = item;
            quantidadeItens++;

            System.out.println("Item cadastrado: " + item.getTitulo());
        } else {
            System.out.println("Acervo cheio.");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (quantidadeUsuarios < usuarios.length) {
            usuarios[quantidadeUsuarios] = usuario;
            quantidadeUsuarios++;

            System.out.println("Usuário cadastrado: " + usuario.getNome());
        } else {
            System.out.println("Limite de usuários atingido.");
        }
    }

    public boolean emprestar(int codigoItem, Usuario usuario) {

        itembiblioteca item = buscarItem(codigoItem);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return false;
        }

        if (!item.isDisponivel()) {
            System.out.println("Item indisponível.");
            return false;
        }

        if (usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()) {
            System.out.println(
                    "Empréstimo recusado: " +
                            usuario.getNome() +
                            " atingiu o limite de " +
                            usuario.getLimiteItens() +
                            " itens."
            );

            return false;
        }

        item.marcarEmprestado();
        usuario.adicionarEmprestimo();

        System.out.println(
                "Empréstimo realizado: " +
                        item.getTitulo() +
                        " para " +
                        usuario.getNome()
        );

        return true;
    }

    public boolean devolver(int codigoItem, Usuario usuario) {

        itembiblioteca item = buscarItem(codigoItem);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return false;
        }

        if (item.isDisponivel()) {
            System.out.println("Esse item já está disponível.");
            return false;
        }

        item.marcarDisponivel();
        usuario.removerEmprestimo();

        System.out.println(
                "Item devolvido: " +
                        item.getTitulo()
        );

        return true;
    }

    private itembiblioteca buscarItem(int codigo) {

        for (int i = 0; i < quantidadeItens; i++) {

            if (acervo[i].getCodigo() == codigo) {
                return acervo[i];
            }
        }

        return null;
    }

    public void listarAcervo() {

        System.out.println("\n===== ACERVO =====");

        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println(acervo[i]);
        }
    }
}