public class PedidoEntrega extends Pedido{
    public static final int MAX_PIZZAS =8;
    
    private ETaxaEntrega taxaEntrega;
    private double distanciaEntrega;

    public PedidoEntrega(double distancia){
        super();
        if(distancia < 0.1)
            distancia = 0.1;
        distanciaEntrega = distancia;
        taxaEntrega = ETaxaEntrega.definirEntrega(distancia);
    }

    @Override 
    protected boolean podeAdicionar(){
        return super.podeAdicionar() && pizzas.size() < MAX_PIZZAS;
    }

    @Override 
    public double precoAPagar(){
        double valorPizzas = super.precoAPagar();
        return valorPizzas + taxaEntrega.valorTaxa();
    }

    @Override 
    public String relatorio(){
        String linhaEntrega  =
            String.format("TAXA ENTREGA: R$ %.2f (%.1f km)", 
                            taxaEntrega.valorTaxa(), distanciaEntrega);
        return super.relatorio() + "\n" + linhaEntrega;
    }
}
