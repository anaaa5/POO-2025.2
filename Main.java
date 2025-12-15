import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaquinaDeBebidas maquina = new MaquinaDeBebidas();

        int opcao;

        do {
            System.out.println("\nMÁQUINA DE BEBIDAS");
            System.out.println("1 - Inserir moedas");
            System.out.println("2 - Comprar bebida");
            System.out.println("3 - Retirar dinheiro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    maquina.receberMoedas();
                    break;

                case 2:
                    maquina.comprarBebida();
                    break;

                case 3:
                    maquina.devolverTroco(0.0);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
