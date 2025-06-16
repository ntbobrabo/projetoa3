import java.io.Serializable;

public class EmpresaConstrutora implements Serializable {
    private String nome;
    private String cnpj;
    public EmpresaConstrutora(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return nome + " (CNPJ: " + cnpj + ")";
    }
}