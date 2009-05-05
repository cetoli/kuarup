package alpha;

public class NumeroExpoenteState implements INumeroState {

	public String entraUm(INumeroStrategy operador,
			INumeroStrategy operadorImaginario,
			INumeroStrategy operadorExpoente,
			INumeroStrategy operadorImaginarioExpoente) {
		return operadorImaginario
				.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
	}

	public String soma(INumeroStrategy operador,
			INumeroStrategy operadorImaginario, INumeroStrategy acumulador,
			INumeroStrategy acumuladorImaginario,
			INumeroStrategy operadorExpoente,
			INumeroStrategy operadorImaginarioExpoente,
			INumeroStrategy acumuladorExpoente,
			INumeroStrategy acumuladorImaginarioExpoente) {
		return acumulador.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay()
				+ "I"
				+ acumuladorImaginario
						.mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
	}

	public INumeroState getNextState() {
		return new NumeroImaginarioState();
	}

}