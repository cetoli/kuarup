package alpha;

/**
 * Classe que trata a parte real do numero.
 * 
 * @author Diego Mury G. de Lima 
 * @version 1.0
 */
public class ParteRealComposite implements Composite {
    /**
     * Método que adiciona a parte real ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteReal(int valorDecimal, INumero operando, Composite montador) {
        montador.adicionaParteReal(valorDecimal, operando, montador);
    }
    /**
     * Método que adiciona a parte imaginária ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteImaginaria(int valorDecimal, INumero operando, Composite montador) {
    }
}
