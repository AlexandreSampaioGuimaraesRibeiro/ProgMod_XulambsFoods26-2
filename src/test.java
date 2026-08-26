public class test {
    /**
     * Testa a funcionalidade de adicionar ingredientes a uma pizza e gerar o cupom fiscal.
     */
    public test(){
        Pizza pizza = new Pizza(5);
        pizza.quantidadeIngredientes=pizza.adicionarIngredientes(2);
        String resulString = pizza.gerarCupom();
    
        IO.println(resulString);
    }
}
