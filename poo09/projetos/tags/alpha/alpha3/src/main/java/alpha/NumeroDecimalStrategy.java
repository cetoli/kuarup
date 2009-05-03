package alpha;

/**
 * Classe que executa operações com numeros decimais.
 * 
 * @author Diego Mury G. de Lima 
 * @author Marcio Reis Teixeira
 * @version 2.0
 */
public class NumeroDecimalStrategy extends NumeroStrategy
{
    /**
     * Construtor da classe.
     * 
     */
    public NumeroDecimalStrategy() { }
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
     * @return um INumeroStrategy com o numero convertido
     */
    public INumeroStrategy converterParaBase(Integer num) {
        NumeroDecimalStrategy dec = new NumeroDecimalStrategy();
        dec.setRepNum(num.toString());
        return dec;
    }
    /**
     * Converte apenas o valor para a base corrente.
     * 
     * @param num numero que deve ser convertido
     * @param iNum INumeroStrategy
     */
    public void converterValorParaBase(Integer num, INumeroStrategy iNum) {
        iNum.setRepNum(num.toString());
    }
    /**
     * Retorna o resultado na base corrente.
     * @return uma String com o resultado desejado
     */
    public String mostraNumeroNaMinhaRepresentacaoBase() {
        Integer temp = converteEmNumeroDecimal();
        return temp.toString(temp);
    }    
    /**
     * Metodo que ira exibir o numero na base corrente para exibicao no display.
     */
    public  String mostraNumeroNaMinhaRepresentacaoBaseParaODisplay() {
        return mostraNumeroNaMinhaRepresentacaoBase();
    }
}
