public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf + " (Administrador)";
    }
}