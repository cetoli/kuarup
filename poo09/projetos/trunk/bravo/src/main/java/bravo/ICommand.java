package bravo;

import bravo.numeros.Numero;

public interface ICommand {

	public Numero execute(Numero acumulador, Numero operando);
}
