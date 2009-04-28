package hotel;

/**
 * Write a description of interface BaseState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class BaseState
{
    String entraUm(Calculadora calc);
    String entraI(Calculadora calc);
    String comandoSoma(Calculadora calc);
    String limpa(Calculadora calc);
    
    public String converte() {
        return converteReal() + converteImaginario();
    }
    
    public abstract String converteReal();
    
    public abstract String converteImaginario();
}
