import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;


    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arranges
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void adicionaVariasPizzaCorretamente(){
        //Art
        pedido.adicionarPizza(new Pizza());
        pedido.adicionarPizza(new Pizza());
        pedido.adicionarPizza(new Pizza());
        int quantidade = pedido.adicionarPizza(new Pizza());
        //Assert
        assertEquals(5, quantidade);
    }

    @BeforeEach
    public void setUp(){
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }

    @Test
    public void calculaValorPedidoCorretamente(){
        //Act
        double preco =  pedido.precoAPagar();
        //Asset
        assertEquals(29d, preco,0.01);
    }

    @Test
    public void calcularPrecoDePedidoComVariasPizzas(){
        //Arrange
        Pizza pizza2Ingrediente = new Pizza(2);
        pedido.adicionarPizza(pizza2Ingrediente);
        //Act
        double preco = pedido.precoAPagar();
        //Assert
        assertEquals(68d, preco,0.01);
    }

    @Test
    public void gerarRelatorioDePedido(){
        //Act
        String cupom = pedido.relatorio();
        //Assert
        assertTrue(cupom.contains("29,00")&&
            cupom.contains("1 pizza")&&
            cupom.contains("aberto")
        );
    }
}
