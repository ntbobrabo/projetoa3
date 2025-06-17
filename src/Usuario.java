import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String nome;
    protected String cpf;

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public abstract String toString();  // obriga subclasses a implementar
}
