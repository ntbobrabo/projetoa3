import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Obra implements ObraInterface, Serializable {
    private String nome;
    private Endereco endereco;
    private EmpresaConstrutora empresa;
    private ProjetoObra projeto;
    private List<OrdemServico> ordens;
    private Usuario responsavel;
    public Obra(String nome, Endereco endereco, EmpresaConstrutora empresa, ProjetoObra projeto, Usuario responsavel) {
        this.nome = nome;
        this.endereco = endereco;
        this.empresa = empresa;
        this.projeto = projeto;
        this.ordens = new ArrayList<>();
        this.responsavel = responsavel;
    }

    public void adicionarOrdem(OrdemServico ordem) {
        ordens.add(ordem);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void exibirDados() {
        System.out.println("Obra: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Empresa: " + empresa);
        System.out.println("Projeto: " + projeto);
        System.out.println("Responsável pelo cadastro: " + responsavel);
        System.out.println("Ordens de Serviço:");
        for (OrdemServico os : ordens) {
            System.out.println(" - " + os);
        }
        System.out.println("----------------------------------");
    }
}