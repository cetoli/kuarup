package charlie;

/**
 * Write a description of class Binario here.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinarioStrategy implements BaseStrategy {
    /**
     * Variavel que define a base a ser utilizada.
     */  
    static int BaseDois = 2;

    /**
     * Tecla numero Um.
     */    
    public Integer entraUm(Integer integer) {
        integer = integer * BaseDois + 1;        
        return integer;
    }    
    
    /**
     * Conversor de numero para String.
     */  
    public String toString(Integer integer) {
        return Integer.toBinaryString(integer);
    }
}