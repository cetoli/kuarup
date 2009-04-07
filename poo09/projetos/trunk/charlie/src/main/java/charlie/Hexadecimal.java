package charlie;


/**
 * Write a description of class Hexadecimal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hexadecimal implements Base
{
    static int BaseDezesseis = 16;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */    
    public Integer entraUm (Integer integer){
        integer = integer * BaseDezesseis + 1;        
        return integer;
    }    
    
    public String toString (Integer integer){
        return Integer.toHexString(integer);
    }
}
