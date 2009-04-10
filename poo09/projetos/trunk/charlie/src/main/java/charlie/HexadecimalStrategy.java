package charlie;

/**
 * Write a description of class Hexadecimal here.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HexadecimalStrategy implements BaseStrategy
{
    /**
     * Declaracao dde variavel BaseDezesseis.
     */    
    static int BaseDezesseis = 16;

    /**
     * Declaracao do metodo entraUm em Hexa.
     */    
    public Integer entraUm (Integer integer){
        integer = integer * BaseDezesseis + 1;        
        return integer;
    }  
    
    /**
     * Declaracao do metodo toString em Hexa.
     */   
    public String toString (Integer integer){
        return Integer.toHexString(integer);
    }
}
