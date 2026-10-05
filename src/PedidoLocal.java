public class PedidoLocal extends Pedido{

    private static  final double TAXA_SERVICO = 0.1d;
    
    private double valorServico(){
        return valorPizzas()* TAXA_SERVICO;
    }

    @Override
    public double precoAPagar() {
        return valorPizzas() + valorServico();
    }
    
    @Override 
    public String toString(){
        StringBuilder cupom = new StringBuilder(cabecalho());
        cupom.append("PEDIDO LOCAL\n");
        cupom.append(detalhesPedido()+"\n");
        
        cupom.append(String.format("TAXA DE SERVIÇO: R$ %.2f", 
                            valorServico()));

        cupom.append(String.format("VALOR: R$ %.2f", 
                            precoAPagar()));

        return cupom.toString();
    }
}
