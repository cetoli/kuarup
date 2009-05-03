package alpha;

/**
 * Classe que trata dos numeros Reais.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Marcio Reis Teixeira
 * @version 1.0
 */
public class NumeroRealState implements INumeroState
{
    /**
     * Metodo que executa a entrada de numeros reais.
     */
    public String entraUm(INumeroStrategy operador, INumeroStrategy operadorImaginario) {
        operador.entraUm();
        return operador.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    }
    /**
     * Metodo que executa a soma de numeros reais.
     */
    public String soma(INumeroStrategy operador, INumeroStrategy operadorImaginario, INumeroStrategy acumulador, INumeroStrategy acumuladorImaginario) {
        Integer temp = operador.converteEmNumeroDecimal().intValue()
                + acumulador.converteEmNumeroDecimal().intValue();
        operador.converterValorParaBase(temp, acumulador);
        return acumulador.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    }
}
