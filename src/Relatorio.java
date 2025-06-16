import java.util.List;

public class Relatorio {
    public void gerar(List<Obra> obras) {
        System.out.println("===== RELATÓRIO DE OBRAS =====");
        for (Obra obra : obras) {
            obra.exibirDados();
        }
    }
}

