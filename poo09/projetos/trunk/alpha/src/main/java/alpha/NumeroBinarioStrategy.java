package alpha;

/**
 * Classe que executa operações com numeros binarios.
 * 
 * @author Diego Mury G. de Lima 
 * @author  Marcio Reis Teixeira
 * @version 2.0
 */
public class NumeroBinarioStrategy extends NumeroStrategy
{
    //Constante indicando a base 2.
    private static final int BASE = 2;
    /**
     * Construtor da classe.
     * 
     */
    public NumeroBinarioStrategy() {
    }
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
     * Converte apenas o valor para a base corrente.
     * 
     * @param num numero que deve ser convertido
     * @param iNum INumeroStrategy
     */
    public void converterValorParaBase(Integer num, INumeroStrategy iNum) {
        iNum.setRepNum(Integer.toBinaryString(num));
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
