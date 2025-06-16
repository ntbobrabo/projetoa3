import java.io.Serializable;

public class OrdemServico implements Serializable {
    private String descricao;
    private String dataExecucao;
    public OrdemServico(String descricao, String dataExecucao) {
        this.descricao = descricao;
        this.dataExecucao = dataExecucao;
    }

    @Override
    public String toString() {
        return descricao + " (Execução: " + dataExecucao + ")";
    }
}