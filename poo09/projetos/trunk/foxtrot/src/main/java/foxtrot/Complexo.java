package foxtrot;

public class Complexo extends State{

	/**
	 * Valor complexo.
	 */
    private State valorI;
    /**
     * Valor inteiro.
     */
    private State valorNormal;

    /**
     * Construtor.
     * @param inicial valor inicial.
     * @param estado valor do inteiro.
     * @throws CloneNotSupportedException se não for suportada a clonagem do objeto.
     */
    public Complexo(int inicial, State estado) throws CloneNotSupportedException {
        //str= "";
        valorI = (State)estado.clone();
        valorNormal = (State)estado.clone();
        valorI.valor = 0;
    }

    /**
     * Soma 2 valores.
     */
    public String comandoSoma(Calculadora calc) {
        //State acumulador = calc.getAcumulador();

        valorI.comandoSoma(calc);

        //calc.setAcumulador(new Complexo (calc.getAcumulador().intValue()));
        //calc.setAcumulador(acumulador);

        return toString();
    }

    /**
     * retorna a representação em String.
     */
    public String toString() {
    	return valorNormal.toString () + "+" + valorI.toString() + "I";
    }

    /**.
     * Muda pro estado Binário
     */
     public State modoBin() {
         valorI = new Binario(valorI.intValue());
         valorNormal = new Binario(valorNormal.intValue());
         return this;
     }

     /**.
     * Muda pro estado Decimal
     */
     public State modoDec() {
         valorI = new Decimal(valorI.intValue());
         valorNormal = new Decimal(valorNormal.intValue());
         return this;
     }

     /**.
     * Muda pro operador Hexadecimal
     */
     public State modoHex() {
         valorI = new Hexadecimal(valorI.intValue());
         valorNormal = new Hexadecimal(valorNormal.intValue());
         return this;
     }

    public String entraUm(Calculadora calc) {
    	String str= valorI.entraUm(calc);

    	return str + "I";
    }

    public String limpa(Calculadora calc) {
    	valorNormal.limpa(calc);
        return valorI.limpa(calc);
    }

	public Integer intValue() {
		return valorI.intValue();
	}


}
