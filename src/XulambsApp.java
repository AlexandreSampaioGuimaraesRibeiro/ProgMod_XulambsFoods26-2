import java.util.LinkedList;
import java.util.List;

public class XulambsApp {

    static List<Pizza> pizzas; 

    public void pausa(){
        IO.readln();
    }

    public int lerInteiro(String mensagem){
        return Integer.parseInt(IO.readln(mensagem));
    }

    private void cabecalho(){
        IO.println("XULANOS PIZZA v0.1");
        IO.println("==================");
    }

    public int menuprincipal() {
        cabecalho();
        IO.println("1- Comprar Pizza");
        IO.println("2- Mostrar Pizzas vendidas");
        IO.println("0- Sair");
        return lerInteiro("Digite sua opição:");
    }

    public void comprarPizza(){
        cabecalho();
        IO.println("Comprando uma pizza:");
        int adicionais = lerInteiro("Digite a quantidade de ingredientes: ");
        Pizza novaPizza = new Pizza(adicionais);
        mostrarNota(novaPizza);
        pizzas.add(novaPizza);
        pausa();
    }

    private void mostrarNota(Pizza novaPizza){
        IO.println("######################");
        IO.println(novaPizza.gerarCupom());
        IO.println("######################");
        pausa();
    }

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