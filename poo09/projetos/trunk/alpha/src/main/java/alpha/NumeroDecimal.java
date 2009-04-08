package alpha;

/**
 * Classe que executa operações com numeros decimais.
 * 
 * @author Diego Mury G. de Lima 
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroDecimal extends Numero
{
    /**
     * Construtor da classe.
     * 
     */
    public NumeroDecimal() { }
    
    /**
     * Converte o numero para a base Decimal.
     * 
     * @return um Integer com o numero convertido
     */
    public Integer converteEmNumeroDecimal() {
        return Integer.parseInt(repNum);
    }
    
    /**
     * Converte o numero para a base corrente.
     * 
     * @param num numero que deve ser convertido
     * @return um INumero com o numero convertido
     */
    public INumero converterParaBase(Integer num) {
        NumeroDecimal dec = new NumeroDecimal();
        dec.setRepNum(num.toString());
        return dec;
    }
    
    /**
     * Retorna o resultado na base corrente.
     * @return uma String com o resultado desejado
     */
    public String mostraNumeroNaMinhaRepresentacaoBase() {
        Integer temp = converteEmNumeroDecimal();
        return temp.toString(temp);
    }
}