package alpha;

/**
 * Classe que trata dos numeros Imaginarios.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Marcio Reis Teixeira
 * @version 1.0
 */
public class NumeroImaginarioExpoenteState implements INumeroState {
    /**
     * Metodo que executa a entrada de numeros Imaginarios.
     */
    public String entraUm(INumeroStrategy operador, INumeroStrategy operadorImaginario, INumeroStrategy operadorExpoente, INumeroStrategy operadorImaginarioExpoente) {
        operadorImaginarioExpoente.entraUm();
        return operadorImaginarioExpoente.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    }
    /**
     * Metodo que executa a soma de numeros reais.
     */
    public String soma(INumeroStrategy operador, INumeroStrategy operadorImaginario, INumeroStrategy acumulador, INumeroStrategy acumuladorImaginario, INumeroStrategy operadorExpoente, INumeroStrategy operadorImaginarioExpoente, INumeroStrategy acumuladorExpoente, INumeroStrategy acumuladorImaginarioExpoente) {
        Integer temp = operadorExpoente.converteEmNumeroDecimal().intValue()
                + acumuladorExpoente.converteEmNumeroDecimal().intValue();   
        operadorExpoente.converterValorParaBase(temp, acumuladorExpoente);
        temp = operadorImaginarioExpoente.converteEmNumeroDecimal().intValue()
                + acumuladorImaginarioExpoente.converteEmNumeroDecimal().intValue();
        operadorExpoente.converterValorParaBase(temp, acumuladorImaginarioExpoente);
        return acumuladorExpoente.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay() + "I" + acumuladorImaginarioExpoente.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    }
    
    public INumeroState getNextState() {
		return null;
	}
}
