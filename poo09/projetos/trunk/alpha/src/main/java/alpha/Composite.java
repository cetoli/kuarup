package alpha;

/**
 * Interface trata as partes do numero.
 * 
 * @author Diego Mury G. de Lima 
 * @author Leandro Oliveira Gomes
 * @version 1.0
 */
public interface Composite {
   /**
    * Metodo abstrato.
    * Adiciona a parte real ao operando.
    * @param valorDecimal
    * @param operando
    * @param montador
    */
    public void adicionaParteReal(int valorDecimal, INumero operando, Composite montador);
   /**
    * Metodo abstrato.
    * Adiciona a parte imaginária ao operando.
    * @param valorDecimal
    * @param operando
    * @param montador
    */
    public void adicionaParteImaginaria(int valorDecimal, INumero operando, Composite montador);
}
