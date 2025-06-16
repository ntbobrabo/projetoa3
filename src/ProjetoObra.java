import java.io.Serializable;

public class ProjetoObra implements Serializable {
    private String descricao;
    private double orcamento;
    public ProjetoObra(String descricao, double orcamento) {
        this.descricao = descricao;
        this.orcamento = orcamento;
    }

    @Override
    public String toString() {
        return descricao + " - Orçamento: R$" + orcamento;
    }
}