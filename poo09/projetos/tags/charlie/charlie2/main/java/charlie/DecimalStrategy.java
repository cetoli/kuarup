package charlie;

/**
 * Classe concreta Decimal.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecimalStrategy implements BaseStrategy {
    /**
     * Declaracao de variavel BaseDez.
     */
    static int baseDez = 10;
    
    /**
     * Declaracao do metodo entraUm.
     */
    public Integer entraUm (Integer integer) {
        integer = integer * baseDez + 1;        
        return integer;
    }    
    
    /**
     * Declaracao de metodo toString.
     */
    public String toString (Integer integer) {
        return Integer.toString(integer);
    }
}
