package bravo;


/**
 * Write a description of interface ITipoNumeroState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface ITipoNumeroState
{
   String entraUm(StrategyBase base, Numero operador, Numero operadorImaginario);
   
   String soma(StrategyBase base,Numero operador, Numero operadorImaginario, Numero acumulador, Numero acumuladorImaginario);
}
