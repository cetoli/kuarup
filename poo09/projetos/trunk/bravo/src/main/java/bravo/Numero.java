package bravo;


/**
 * Write a description of class Numero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Numero
{
    
    private Integer x;

    /**
     * Constructor for objects of class Numero
     */
    public Numero()
    {
        x = 0;
    }
    
     public Numero(Integer i)
    {
        x = i;
    }
    
    public Integer getX(){
        return x;
    }
    
    public void setX(Integer y){
        this.x = y;
    }
}
