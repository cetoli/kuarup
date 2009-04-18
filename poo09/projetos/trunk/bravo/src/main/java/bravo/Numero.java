package bravo;


/**
 * Define  a classe número.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Numero
{
    
    private Integer x;

    /**
     * Constructor for objects of class Numero.
     */
    public Numero()
    {
        x = 0;
    }

    /**
     * Constructor for objects of class Numero.
     */    
    public Numero(Integer i)
    {
        x = i;
    }

    /**
     * Constructor for objects of class Numero.
     */    
    public Integer getX() {
        return x;
    }

    /**
     * Constructor for objects of class Numero.
     */    
    public void setX(Integer y) {
        this.x = y;
    }
}
