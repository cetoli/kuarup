package bravo;


/**
 * Write a description of class TipoNumeroImaginarioState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TipoNumeroImaginarioState implements ITipoNumeroState
{
     private StrategyBase base = new BaseDecimal();
    /**
     * Constructor for objects of class TipoNumeroImaginarioState
     */
    public TipoNumeroImaginarioState()
    {}

    public String entraUm(StrategyBase base,Numero operador, Numero operadorImaginario){
        operadorImaginario = base.entraUm(operadorImaginario);
        return base.converterBase(operadorImaginario);
        
    }

    
    public String soma(StrategyBase base,Numero operador, Numero operadorImaginario, Numero acumulador, Numero acumuladorImaginario){
       
         acumuladorImaginario.setX(acumuladorImaginario.getX() + operadorImaginario.getX());
         acumulador.setX(acumulador.getX() + operador.getX());
        return base.converterBase(acumulador) + "I"+ base.converterBase(acumuladorImaginario);
    }
}
