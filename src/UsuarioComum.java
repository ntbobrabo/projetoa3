public class UsuarioComum extends Usuario {
    public UsuarioComum(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf + " (Usuário Comum)";
    }
}
