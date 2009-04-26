package charlie;

/**
 * Implementacao do estado da soma para valores reais.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class RealSomaState implements SomaState {
    /** Atributo acumulador dos operacoes com reais. */
    private Integer acumuladorReal = new Integer(0);

    /**
     * Implementacao do metodo soma para valores reais.
     */    
    public final Integer soma(Integer operador) {
        return acumuladorReal += operador;
    }

    /**
     * Implementacao do metodo getAcumulador.
     */ 
    public final Integer getAcumulador() {
        return acumuladorReal;
    }
}
