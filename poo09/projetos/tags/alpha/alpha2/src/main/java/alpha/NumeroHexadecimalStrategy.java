package alpha;

/**
 * Classe que executa operações com numeros hexadecimais.
 * 
 * @author Diego Mury G. de Lima 
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroHexadecimalStrategy extends NumeroStrategy
{
    //Constante indicando a base 16.
    private static final int BASE = 16;
    /**
     * Construtor da classe.
     * 
     */
    public NumeroHexadecimalStrategy() { }
    /**
     * Converte o numero para a base Decimal.
     * 
     * @return um Integer com o numero convertido
     */
    public Integer converteEmNumeroDecimal() {
        return Integer.valueOf(repNum, BASE);
    }
    /**
     * Converte o numero para a base corrente.
     * 
     * @param num numero que deve ser convertido
     * @return um INumero com o numero convertido
     */
    public INumeroStrategy converterParaBase(Integer num) {
        NumeroHexadecimalStrategy hex = new NumeroHexadecimalStrategy();
        hex.setRepNum(Integer.toHexString(num));
        return hex;
    }
    /**
     * Retorna o resultado na base corrente.
     * @return uma String com o resultado desejado
     */
    public String mostraNumeroNaMinhaRepresentacaoBase() {
        Integer temp = converteEmNumeroDecimal();
        return temp.toHexString(temp);
    }
    /**
     * Retorna o resultado na base corrente para exibicao no Display.
     * @return uma "0x" + String com o resultado desejado
     */
    public  String mostraNumeroNaMinhaRepresentacaoBaseParaODisplay() {
        return "0x" + mostraNumeroNaMinhaRepresentacaoBase();
    }
}
