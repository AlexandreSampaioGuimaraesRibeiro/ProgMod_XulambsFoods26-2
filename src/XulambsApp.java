import java.util.LinkedList;
import java.util.List;

public class XulambsApp {

    static List<Pizza> pizzas; 

    /**
     * Pausa a execução do programa até que o usuário pressione Enter.
     */
    public void pausa(){
        IO.readln();
    }

    /**
     * Lê um número inteiro do usuário, exibindo a mensagem fornecida.
     * @param mensagem Mensagem a ser exibida para o usuário.
     * @return Número inteiro lido do usuário.
     */
    public int lerInteiro(String mensagem){
        return Integer.parseInt(IO.readln(mensagem));
    }

    /**
     * Exibe o cabeçalho da aplicação.
     */
    private void cabecalho(){
        IO.println("XULANOS PIZZA v0.1");
        IO.println("==================");
    }

    /**
     * Exibe o menu principal da aplicação e retorna a opção escolhida pelo usuário.
     * @return Opção escolhida pelo usuário.
     */
    public int menuprincipal() {
        cabecalho();
        IO.println("1- Comprar Pizza");
        IO.println("2- Mostrar Pizzas vendidas");
        IO.println("0- Sair");
        return lerInteiro("Digite sua opção: ");
    }

    /**
     * Compra uma pizza, solicitando a quantidade de ingredientes adicionais,
     * e exibe o cupom fiscal da pizza comprada.
     */
    public void comprarPizza(){
        cabecalho();
        IO.println("Comprando uma pizza:");
        int adicionais = lerInteiro("Digite a quantidade de ingredientes: ");
        Pizza novaPizza = new Pizza(adicionais);
        mostrarNota(novaPizza);
        pizzas.add(novaPizza);
        pausa();
    }

    /**
     * Mostra o cupom fiscal da pizza passada como parâmetro.
     * @param novaPizza Pizza a ser exibida.
     */
    private void mostrarNota(Pizza novaPizza){
        IO.println("######################");
        IO.println(novaPizza.gerarCupom());
        IO.println("######################");
        pausa();
    }

    /**
     * Mostra todas as pizzas vendidas, com seus respectivos cupons fiscais.
     */
    public void mostrarPizzas(){
        cabecalho();
        for (Pizza pizza : pizzas) {
            mostrarNota(pizza);
            IO.println();
        }
    }

    void main(){
        int opicao;
        pizzas = new LinkedList<>();
        do {
            opicao=menuprincipal();
            switch (opicao) {
                case 1 -> comprarPizza();
                case 2 -> mostrarPizzas();
                case 0 -> IO.println("Encerrando!");
                default -> IO.println("Opção invalida.");
            }
        } while (opicao!=0);
    }
}