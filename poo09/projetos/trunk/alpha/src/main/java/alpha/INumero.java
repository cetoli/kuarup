package alpha;

/**
 * Interface que implementara a operacao
 * com numeros nas diversas bases.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public interface INumero
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
    public INumero converterParaBase(Integer num);
    
    /**
     * Assinatura do metodo mostraNumeroNaMinhaRepresentacaoBase.
     * 
     * @return String
     */
    public String mostraNumeroNaMinhaRepresentacaoBase();
    
    /**
     * Assinatura do metodo zeraRepresentacaoNumerica.
     */
    public void zeraRepresentacaoNumerica();
}
