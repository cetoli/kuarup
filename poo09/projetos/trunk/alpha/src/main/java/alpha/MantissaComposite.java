package alpha;

/**
 * Classe que trata a mantissa do numero.
 * 
 * @author Diego Mury G. de Lima 
 * @version 1.0
 */
public class MantissaComposite implements Composite {
    /**
     * Método que adiciona a parte real ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteReal(int valorDecimal, INumero operando, Composite montador) {
        operando.adicionaParteReal(new Real(valorDecimal));
    }
    /**
     * Método que adiciona a parte imaginária ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteImaginaria(int valorDecimal, INumero operando, Composite montador) {
        operando.adicionaParteImaginaria(new Imaginario(valorDecimal));
    }
}
