import java.io.Serializable;

public class Endereco implements Serializable {
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    public Endereco(String rua, String bairro, String cidade, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return rua + ", " + bairro + ", " + cidade + " - CEP: " + cep;
    }
}

