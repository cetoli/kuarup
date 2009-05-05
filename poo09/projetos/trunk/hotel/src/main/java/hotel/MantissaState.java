package hotel;

public class MantissaState implements StateEngenharia {

	public String toString(Calculadora calc, Parte parte) {
		Strategy strategy = calc.getStrategy();
		String representacaoBase = strategy.getRepresentacao();
		return representacaoBase + strategy.converter(parte.getMantissa());
	}

	public void entraUm(int base, Parte parte) {
		int mantissa = parte.getMantissa();
		mantissa *= base;
		mantissa++;
		parte.setMantissa(mantissa);
	}

	public int getPrioridade() {
		return 0;
	}
}
