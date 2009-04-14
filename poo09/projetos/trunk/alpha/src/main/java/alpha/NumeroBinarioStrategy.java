package alpha;

/**
 * Classe que executa operações com numeros binarios.
 * 
 * @author Diego Mury G. de Lima 
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroBinarioStrategy extends NumeroStrategy
{
    //Constante indicando a base 2.
    private static final int BASE = 2;
    
    /**
     * Construtor da classe.
     * 
     */
    public NumeroBinarioStrategy() { }
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
     * @return um INumeroStrategy com o numero convertido
     */
    public INumeroStrategy converterParaBase(Integer num) {
        NumeroBinarioStrategy bin = new NumeroBinarioStrategy();
        bin.setRepNum(Integer.toBinaryString(num));   
        return bin;
    }
    /**
     * Retorna o resultado na base corrente.
     * @return uma String com o resultado desejado
     */
    public String mostraNumeroNaMinhaRepresentacaoBase() {
        Integer temp = converteEmNumeroDecimal();
        return temp.toBinaryString(temp);
    }
    /**
     * Retorna o resultado na base corrente para exibicao no Display.
     * @return uma "0b" + String com o resultado desejado
     */
    public  String mostraNumeroNaMinhaRepresentacaoBaseParaODisplay() {
        return "0b" + mostraNumeroNaMinhaRepresentacaoBase();
    }
}
