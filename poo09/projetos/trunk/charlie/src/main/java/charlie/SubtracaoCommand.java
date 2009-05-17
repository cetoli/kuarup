package charlie;

public class SubtracaoCommand implements ICommand {

	public Numero execute(Numero acumulador, Numero operando) {
		return acumulador.subtrai(operando);
	}

}
