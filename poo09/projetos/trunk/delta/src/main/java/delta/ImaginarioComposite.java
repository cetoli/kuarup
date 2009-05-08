package delta;

/**
 * Classe que realiza as operacoes reais.
 * 
 * @author (Tiago Cruz de França) - Papagaio
 * @author (Andre Sion) - Pirata
 * @version 3.0 de 03-05-2009
 */
public class ImaginarioComposite implements OperacaoComposite {
    /** Operando guarda os valores de entrada. */
    private Integer operando = new Integer(0);
    /** Operando guarda os resultados da soma. */
    private Integer acumulador = new Integer(0);
    
    /**
     * @param inteiro
     * @param base
     * @return
     */
    public final String toString(BaseStrategy base) {
        //só imprime acumulador.
        return "I" + base.toString(acumulador);
    }

    /**
     * @param inteiro
     * @param base
     * @return
     */
    public String toStringOperando(BaseStrategy base){
        return "I" + base.toString(this.operando);
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void entraUm(BaseStrategy base) {
        operando = operando * base.getValorBase() + 1;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void soma() {
        acumulador += operando;
        operando = 0;
    }

}
