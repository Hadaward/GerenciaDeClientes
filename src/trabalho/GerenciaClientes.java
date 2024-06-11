package trabalho;

import java.util.Scanner;

public class GerenciaClientes {
    public static String pastaDeDados = "dados/";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            printMenu();
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Informe o CPF do cliente: ");
                String cpf = scanner.next();

                GerenciaArquivosTxt arquivo = new GerenciaArquivosTxt(cpf + ".txt", pastaDeDados);

                if (arquivo.verificarArquivo()) {
                    System.out.println("Cliente já cadastrado");

                    int op = 0;
                    
                    System.out.println("Escolha uma das opções:");
                    System.out.println("1 - Atualizar cadastro”");
                    System.out.println("2 - Exibir dados");
                    op = scanner.nextInt();

                    if (op == 2) {
                        exibirDados(arquivo);
                    } else {
                        cadastrarCliente(scanner, cpf, arquivo);
                    }
                } else {
                    cadastrarCliente(scanner, cpf, arquivo);
                }
            } else if (opcao == 2) {
                System.out.println("Informe o CPF do cliente: ");
                String cpf = scanner.next();

                GerenciaArquivosTxt arquivo = new GerenciaArquivosTxt(cpf + ".txt", pastaDeDados);

                if (arquivo.verificarArquivo()) {
                    exibirDados(arquivo);
                } else {
                    System.out.println("Cliente não cadastrado, deseja cadastrar?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NÃO");

                    int escolha = scanner.nextInt();

                    if (escolha == 1) {
                        cadastrarCliente(scanner, cpf, arquivo);
                    }
                }
            }
        } while (opcao != 3);

        scanner.close();
    }

    public static void exibirDados(GerenciaArquivosTxt arquivo) {
        try {
            String dados = arquivo.lerArquivo();
            System.out.println(dados);
        } catch (Exception error) {
            System.out.println("Não foi possível ler os dados do arquivo.");
            System.out.println(error);
        }
    }

    public static void cadastrarCliente(Scanner scanner, String cpf, GerenciaArquivosTxt arquivo)  {
        Pessoa pessoa = new Pessoa(cpf);

        System.out.print("Informe o nome do cliente: ");
        pessoa.setNome(scanner.next());

        System.out.print("Informe o e-mail do cliente: ");
        pessoa.setEmail(scanner.next());

        System.out.println("Informe a data de nascimento do cliente: ");

        while (true) {
            try {
                Data data = Data.parseData(scanner.next());
                pessoa.setDataNacimento(data.getData());
                break;
            } catch (Exception error) {
                System.out.println(error);
            }
        }
        
        try {
            arquivo.gravarArquivo(String.format("Nome: %s\nCPF: %s\nData de Nascimento: %s\nE-mail: %s", pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNacimento(), pessoa.getEmail()));
        } catch (Exception error) {
            System.out.println("Falha ao salvar arquivo");
            System.out.println(error);
        }
    }

    public static void printMenu() {
        System.out.println("Escolha uma das opções:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Exibir cliente");
        System.out.println("3 - Sair");
    }
}