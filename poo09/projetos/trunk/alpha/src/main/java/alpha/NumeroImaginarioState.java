package alpha;

/**
 * Classe que trata dos numeros Imaginarios.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Marcio Reis Teixeira
 * @version 1.0
 */
public class NumeroImaginarioState implements INumeroState {
	/**
     * Metodo que executa a entrada de numeros Imaginarios.
     */
    public String entraUm(INumeroStrategy operador, INumeroStrategy operadorImaginario, INumeroStrategy operadorExpoente, INumeroStrategy operadorImaginarioExpoente) {
        operadorImaginario.entraUm();
        return operadorImaginario.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    }
    /**
     * Metodo que executa a soma de numeros reais.
     */
    public String soma(INumeroStrategy operador, INumeroStrategy operadorImaginario, INumeroStrategy acumulador, INumeroStrategy acumuladorImaginario, INumeroStrategy operadorExpoente, INumeroStrategy operadorImaginarioExpoente, INumeroStrategy acumuladorExpoente, INumeroStrategy acumuladorImaginarioExpoente) {
        Integer temp = operador.converteEmNumeroDecimal().intValue()
                + acumulador.converteEmNumeroDecimal().intValue();   
        operador.converterValorParaBase(temp, acumulador);
        temp = operadorImaginario.converteEmNumeroDecimal().intValue()
                + acumuladorImaginario.converteEmNumeroDecimal().intValue();
        operador.converterValorParaBase(temp, acumuladorImaginario);

        return acumulador.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay() + "I" + acumuladorImaginario.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    }

    public INumeroState getNextState() {
		return new NumeroImaginarioExpoenteState();
	}
}
