package bravo;


/**
 * Write a description of class TipoNumeroRealState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TipoNumeroRealState implements ITipoNumeroState
{
   
    /**
     * Constructor for objects of class TipoNumeroRealState
     */
    public TipoNumeroRealState()
    {
        // initialise instance variables

    }
    
    public  String entraUm(StrategyBase base, Numero operador, Numero operadorImaginario){
        operador = base.entraUm(operador);
        return base.converterBase(operador);
    }

    public String soma(StrategyBase base, Numero operador, Numero operadorImaginario, Numero acumulador, Numero acumuladorImaginario){
         acumulador.setX(acumulador.getX() + operador.getX());
         operadorImaginario = new Numero();
         acumuladorImaginario=new Numero();
         return base.converterBase(acumulador);
    }
   
}