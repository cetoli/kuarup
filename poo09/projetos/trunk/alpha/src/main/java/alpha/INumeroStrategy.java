package alpha;

/**
 * Interface que implementara a operacao
 * com numeros nas diversas bases.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Marcio Reis Teixeira
 * @version 2.0
 */
public interface INumeroStrategy
{
    /**
     * Assinatura do metodo entraUm.
     */
    public void entraUm();
    /**
     * Assinatura do metodo converteEmNumeroDecimal.
     * 
     * @return Integer
     */
    public Integer converteEmNumeroDecimal();
    /**
     * Assinatura do metodo converterParaBase.
     * 
     * @param num
     * @return INumero
     */
    public INumeroStrategy converterParaBase(Integer num);
    /**
     * Assinatura do metodo converterValorParaBase.
     * 
     * @param num 
     * @param INum
     */
    public void converterValorParaBase(Integer num, INumeroStrategy iNum);
    /**
     * Assinatura do metodo mostraNumeroNaMinhaRepresentacaoBase.
     * 
     * @return String
     */
    public String mostraNumeroNaMinhaRepresentacaoBase();
     /**
     * Assinatura do metodo mostraNumeroNaMinhaRepresentacaoBaseParaODisplay.
     * 
     * @return String
     */
    public String mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    /**
     * Assinatura do metodo zeraRepresentacaoNumerica.
     */
    public void zeraRepresentacaoNumerica();
    /**
     * Assinatura do metodo setRepNum, que altera a representacao numerica.
     */
    public void setRepNum(String num);
}
