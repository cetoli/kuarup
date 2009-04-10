package charlie;

/**
 * Write a description of class Dec here.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecimalStrategy implements BaseStrategy
{
    /**
     * Declaracao de variavel BaseDez.
     */
    static int BaseDez = 10;
    
    /**
     * Declaracao do metodo entraUm.
     */
    public Integer entraUm (Integer integer){
        integer = integer * BaseDez + 1;        
        return integer;
    }    
    
    /**
     * Declaracao de metodo toString.
     */
    public String toString (Integer integer){
        return Integer.toString(integer);
    }
}
