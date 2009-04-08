package alpha;


/**
 * Write a description of interface INumero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface INumero
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    public void entraUm();
    
    public Integer converteEmNumeroDecimal();
    
    public INumero converterParaBase(Integer num);
    
    public String mostraNumeroNaMinhaRepresentacaoBase();
    
    public void zeraRepresentacaoNumerica();
}
