public class test {
    public test(){
        Pizza pizza = new Pizza(5);
        pizza.quantidadeIngredientes=pizza.adicionarIngredientes(2);
        String resulString = pizza.gerarCupom();
    
        IO.println(resulString);
    }
}
