public class Bebidas {

    String nome;
    Double valor;

    Bebidas (String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
    }

    String getNome() {
        return nome;
    }

    Double getValor() {
        return valor;
    }

    void imprimir (){
        System.out.printf("%s - R$%.2f\n", nome, valor);
    }
    
}
