package alpha;

/**
 * Classe que trata a parte imaginaria do numero.
 * 
 * @author Diego Mury G. de Lima 
 * @version 1.0
 */
public class ParteImaginariaComposite implements Composite {
    /**
     * M�todo que adiciona a parte real ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteReal(int valorDecimal, INumero operando, Composite montador) {
    }
    /**
     * M�todo que adiciona a parte imagin�ria ao operando.
     * @param valorDecimal
     * @param operando
     * @param montador
     */
    public void adicionaParteImaginaria(int valorDecimal, INumero operando, Composite montador) {
        montador.adicionaParteImaginaria(valorDecimal, operando, montador);
    }
}
