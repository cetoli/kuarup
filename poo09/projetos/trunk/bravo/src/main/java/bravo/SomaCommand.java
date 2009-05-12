package bravo;

import bravo.numeros.Numero;

public class SomaCommand implements ICommand {

	public Numero execute(Numero acumulador, Numero operando) {
		return acumulador.soma(operando);
	}

}
