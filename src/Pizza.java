public class Pizza {
    static final double PRECO_BASE;
	static final int MAXIMO_INGREDIENTES;
	static final double VALOR_INGREDIENTE;

    static int pizzasVendidas;

    int quantidadeIngredientes;

    /**
     * Bloco estático que inicializa as constantes da classe Pizza.
     */
    static{
        PRECO_BASE = 29;
	    MAXIMO_INGREDIENTES = 8;
	    VALOR_INGREDIENTE = 5;
        pizzasVendidas = 0;
    }

    /**
     * Inicializa a pizza com a quantidade de ingredientes adicionais
     * e incrementa o contador de pizzas vendidas.
     * @param adicionais Quantidade de ingredientes adicionais.
     */
    void init(int adicionais) {
		 adicionarIngredientes(adicionais);
         pizzasVendidas++;
    }

    /**
     * Construtor da classe Pizza, que inicializa a quantidade de ingredientes adicionais como 0.
     */
	public Pizza() {
		init(0);
	}

    /**
     * Construtor da classe Pizza, que inicializa a quantidade de ingredientes adicionais.
     * @param adicionais Quantidade de ingredientes adicionais.
     */
	public Pizza(int adicionais) {
		init(adicionais);
	}

    /**
     * Calcula o valor final da pizza, somando o preço base com o valor dos adicionais.
     * @return Valor final da pizza.
     */
	public double calcularValorFinal() {
		return PRECO_BASE + calcularValorAdicionais();
	}

    /**
     * Calcula o valor dos adicionais da pizza, com base na quantidade de ingredientes.
     * @return Valor dos adicionais.
     */
	public double calcularValorAdicionais() {
		return quantidadeIngredientes * VALOR_INGREDIENTE;
	}

    /**
     * Gera o cupom fiscal da pizza, com os valores detalhados.
     * @return String com o cupom fiscal.
     */
	public String gerarCupom() {
		String cupom = "Xulambs Pizza!!!\n";
        
        cupom += String.format("Pizza com %d ingredientes\n",      quantidadeIngredientes);

        cupom += String.format("\tPreço base: R$ %.2f\n", PRECO_BASE);
        cupom += String.format("\tAdicionais: R$ %.2f\n", calcularValorAdicionais());
        cupom += String.format("VALOR A PAGAR: R$ %.2f", calcularValorFinal());

        return cupom;
	}

    /**
     * Verifica se a quantidade de ingredientes passada pode
     * ser adicionada na pizza, retornando true/false 
     * confore o resultado.
     * @param quantidade Ingredientes a serem adicionados
     * @return TRUE se a quantidade for >=0 e o total <=8, FALSE para casos contrários.
     */
	public boolean podeAdicionar(int quantidade) {
        return quantidade >=0
               && quantidade + quantidadeIngredientes <= MAXIMO_INGREDIENTES;
    }

    /**
     * Adiciona a quantidade de ingredientes passada na pizza,
     * caso seja possível, e retorna a quantidade final de ingredientes.
     * @param quantidade Ingredientes a serem adicionados
     * @return Quantidade final de ingredientes na pizza.
     */
	public int adicionarIngredientes(int quantidade) {
		if(podeAdicionar(quantidade)){
            quantidadeIngredientes += quantidade;
        }
        return quantidadeIngredientes;
	}
}
