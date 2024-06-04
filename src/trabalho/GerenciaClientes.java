package trabalho;

import java.util.Scanner;

public class GerenciaClientes {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;

        do {
            printMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    
            }
        } while (opcao != 3);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Escolha uma das opções:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Exibir cliente");
        System.out.println("3 - Sair");
    }
}
