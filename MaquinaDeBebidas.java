import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaDeBebidas {

    ArrayList<Bebidas> bebida = new ArrayList<>();
    ArrayList<Double> moedasValidas = new ArrayList<>();
    Double total = 0.0;
    Double troco = 0.0;
    Scanner scanner = new Scanner(System.in);

    public MaquinaDeBebidas() {

        bebida.add(new Bebidas("Café", 2.00));
        bebida.add(new Bebidas("Chocolate quente", 5.00));
        bebida.add(new Bebidas("Capuccino", 3.00));

        moedasValidas.add(0.05);
        moedasValidas.add(0.10);
        moedasValidas.add(0.25);
        moedasValidas.add(0.50);
        moedasValidas.add(1.00);
    }

    void cardapio() {
        System.out.println("\nCARDÁPIO");
        for (int i = 0; i < bebida.size(); i++) {
            System.out.print(i + " - ");
            bebida.get(i).imprimir();
        }
    }

    boolean validarMoedas(Double valor) {
        for (Double m : moedasValidas) {
            if (Double.compare(m, valor) == 0) {
                return true;
            }
        }
        return false;
    }

    void receberMoedas() {

        System.out.println("Insira moedas (ENTER para finalizar):");

        while (true) {
            String entrada = scanner.nextLine();

            if (entrada.isEmpty()) {
                break;
            }

            try {
                Double valor = Double.parseDouble(entrada);

                if (validarMoedas(valor)) {
                    total += valor;
                    System.out.printf("Total atual: R$ %.2f%n", total);
                } else {
                    System.out.println("Moeda inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }

        System.out.printf("Total disponível: R$ %.2f%n", total);
    }

    int oferecerBebida() {
        cardapio();
        System.out.print("Escolha a bebida pelo número: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    boolean saldoSuficiente(int opcao) {
        return total >= bebida.get(opcao).getValor();
    }

    void prepararBebida(int opcao) {
        System.out.println("Preparando " + bebida.get(opcao).getNome() + "...");
        System.out.println("Bebida pronta!");
    }

    void comprarBebida() {
        int opcao = oferecerBebida();

        if (opcao < 0 || opcao >= bebida.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        if (!saldoSuficiente(opcao)) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        Double preco = bebida.get(opcao).getValor();
        prepararBebida(opcao);
        devolverTroco(preco);
    }

    void devolverTroco(Double valorBebida) {
        troco = total - valorBebida;

        if (troco > 0) {
            System.out.printf("Retire seu troco: R$ %.2f%n", troco);
        }

        total = 0.0;
        troco = 0.0;
    }
}
