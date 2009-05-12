package alpha;

/**
 * Classe que trata a parte exponencial do numero.
 * 
 * @author Diego Mury G. de Lima 
 * @version 1.0
 */
public class ParteExponencialComposite implements Composite {
    /**
     * Método que adiciona a parte real ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteReal(int valorDecimal, INumero operando, Composite montador) {
        operando.getParteReal().adicionaParteExponencial(new Exponencial(valorDecimal));
    }
    /**
     * Método que adiciona a parte imaginária ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteImaginaria(int valorDecimal, INumero operando, Composite montador) {
        operando.getParteImaginaria().adicionaParteExponencial(new Exponencial(valorDecimal));
    }
}
