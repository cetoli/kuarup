package charlie;

/**
 * Classe concreta Hexadecimal.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HexadecimalStrategy implements BaseStrategy {
    /**
     * Declaracao de variavel BaseDezesseis.
     */    
    static int baseDezesseis = 16;

    /**
     * Declaracao do metodo entraUm em Hexa.
     */    
    public Integer entraUm (Integer integer) {
        integer = integer * baseDezesseis + 1;        
        return integer;
    }  
    
    /**
     * Declaracao do metodo toString em Hexa.
     */   
    public String toString (Integer integer) {
        return Integer.toHexString(integer);
    }
}
