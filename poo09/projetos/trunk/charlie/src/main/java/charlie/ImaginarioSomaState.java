package charlie;


/**
 * Implementacao do estado da soma para valores imaginarios.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class ImaginarioSomaState implements SomaState {
    /** Atributo acumulador dos operacoes com imaginarios. */
    private Integer acumuladorImaginario = new Integer(0);

    /**
     * Implementacao do metodo soma para valores imaginarios.
     */    
    public final Integer soma(Integer operador) {
        acumuladorImaginario = acumuladorImaginario + operador;
        return acumuladorImaginario;
    }

    /**
     * Implementacao do metodo getAcumulador.
     */ 
    public final Integer getAcumulador() {
        return acumuladorImaginario;
    }
}
