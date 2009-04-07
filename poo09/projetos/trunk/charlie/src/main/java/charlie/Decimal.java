package charlie;


/**
 * Write a description of class Dec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Decimal implements Base
{
    static int BaseDez = 10;
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Integer entraUm (Integer integer){
        integer = integer * BaseDez + 1;        
        return integer;
    }    
    
    public String toString (Integer integer){
        return Integer.toString(integer);
    }
}
