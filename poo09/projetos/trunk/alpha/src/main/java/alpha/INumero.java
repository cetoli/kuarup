package alpha;

/**
 * Interface que define numero.
 * 
 * @author Diego Mury G. de Lima
 * @author Leandro Oliveira Gomes
 * @version 3.0
 */
public interface INumero {
    /**
     * Metodo abstrato.
     * Adiciona a parte real do numero.
     */  
    public void adicionaParteReal(INumero numero);
    /**
     * Metodo abstrato.
     * Adiciona a parte imaginaria do numero.
     */  
    public void adicionaParteImaginaria(INumero numero);
    /**
     * Metodo abstrato.
     * Adiciona a parte exponencial do numero.
     */  
    public void adicionaParteExponencial(INumero numero);
    /**
     * Metodo abstrato.
     * Mostra a representacao do numero.
     */  
    public String mostra(BaseStrategy base);
    /**
     * Metodo abstrato.
     * Realiza a soma.
     */ 
    public void soma(INumero numero);
    /**
     * Metodo abstrato.
     * Retorna o valor.
     */
    public void subtrai(INumero numero);
    /**
     * Metodo abstrato.
     * Retorna o valor.
     */
    public int getValor();
    /**
     * Metodo abstrato.
     * Altera o valor.
     */
    public void setValor(int valor);
    /**
     * Metodo abstrato.
     * Retorna a parte real.
     */
    public INumero getParteReal();
    /**
     * Metodo abstrato.
     * Retorna a parte imaginaria.
     */
    public INumero getParteImaginaria();
    /**
     * Metodo abstrato.
     * Retorna a parte exponencial.
     */
    public INumero getParteExponencial();
}
