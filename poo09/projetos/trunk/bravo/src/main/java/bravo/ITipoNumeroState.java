package bravo;


/**
 * Interface de Estado.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ITipoNumeroState {
    /**
     * String entraUm.
     */        
    String entraUm(StrategyBase base, Numero operador, Numero operadorImaginario);
    /**
     * String soma.
     */      
    String soma(StrategyBase base, Numero operador, Numero operadorImaginario, Numero acumulador, Numero acumuladorImaginario);
}
