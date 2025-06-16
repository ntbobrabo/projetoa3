import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String cpf;
    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf;
    }
}

