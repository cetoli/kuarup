package hotel;

public class ExpoenteState implements StateEngenharia {

	public String toString(Calculadora calc, Parte parte) {
		Strategy strategy = calc.getStrategy();
		String representacaoBase = strategy.getRepresentacao();
		return representacaoBase + strategy.converter(parte.getMantissa()) + "N" + strategy.converter(parte.getExpoente());
	}

	public void entraUm(int base, Parte parte) {
		int expoente = parte.getExpoente();
		expoente *= base;
		expoente++;
		parte.setExpoente(expoente);
	}
	
	public int getPrioridade() {
		return 1;
	}
}
