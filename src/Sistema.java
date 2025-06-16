import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Obra> obras;
    private Usuario usuarioLogado;
    private static final String ARQUIVO_OBRAS = "obras.dat";
    private static final String ARQUIVO_USUARIO = "usuario.dat";
    public Sistema() {
        obras = new ArrayList<>();
        carregarDados();
    }

    public void executar() {
        Scanner sc = new Scanner(System.in);

        if (usuarioLogado == null) {
            registrarUsuario(sc);
        } else {
            System.out.println("Usuário carregado: " + usuarioLogado);
        }

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar Obra");
            System.out.println("2 - Listar Obras");
            System.out.println("3 - Gerar Relatório");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarObra(sc);
                case 2 -> listarObras();
                case 3 -> new Relatorio().gerar(obras);
                case 0 -> {
                    salvarDados();
                    System.out.println("Sistema encerrado e dados salvos.");
                }
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
        sc.close();
    }

    private void registrarUsuario(Scanner sc) {
        System.out.println("=== Registro de Usuário ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        usuarioLogado = new Usuario(nome, cpf);
        System.out.println("Usuário registrado com sucesso! Bem-vindo(a), " + nome + ".");
    }

    private void cadastrarObra(Scanner sc) {
        System.out.print("Nome da obra: ");
        String nome = sc.nextLine();

        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        Endereco endereco = new Endereco(rua, bairro, cidade, cep);

        System.out.print("Nome da empresa: ");
        String nomeEmpresa = sc.nextLine();
        System.out.print("CNPJ da empresa: ");
        String cnpj = sc.nextLine();
        EmpresaConstrutora empresa = new EmpresaConstrutora(nomeEmpresa, cnpj);

        System.out.print("Descrição do projeto: ");
        String descProjeto = sc.nextLine();
        System.out.print("Orçamento: ");
        double orcamento = sc.nextDouble();
        sc.nextLine();
        ProjetoObra projeto = new ProjetoObra(descProjeto, orcamento);

        Obra obra = new Obra(nome, endereco, empresa, projeto, usuarioLogado);

        System.out.print("Deseja adicionar ordens de serviço? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            String continuar;
            do {
                System.out.print("Descrição da ordem: ");
                String desc = sc.nextLine();
                System.out.print("Data de execução: ");
                String data = sc.nextLine();
                obra.adicionarOrdem(new OrdemServico(desc, data));

                System.out.print("Adicionar outra? (s/n): ");
                continuar = sc.nextLine();
            } while (continuar.equalsIgnoreCase("s"));
        }

        obras.add(obra);
        System.out.println("Obra cadastrada com sucesso!");
    }

    private void listarObras() {
        System.out.println("\n--- Obras Cadastradas ---");
        for (Obra obra : obras) {
            System.out.println(obra.getNome());
        }
    }

    private void salvarDados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_OBRAS))) {
            out.writeObject(obras);
        } catch (IOException e) {
            System.err.println("Erro ao salvar obras: " + e.getMessage());
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_USUARIO))) {
            out.writeObject(usuarioLogado);
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    private void carregarDados() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_OBRAS))) {
            obras = (List<Obra>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            obras = new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_USUARIO))) {
            usuarioLogado = (Usuario) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            usuarioLogado = null;
        }
    }
}