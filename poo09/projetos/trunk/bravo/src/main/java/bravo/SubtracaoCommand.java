package bravo;

import bravo.numeros.Numero;

public class SubtracaoCommand implements ICommand {

	public Numero execute(Numero acumulador, Numero operando) {
		return acumulador.subtrai(operando);
	}

}
