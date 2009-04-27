package bravo;


/**
 * Define  a classe n�mero.
 * A classe calculadora realiza opera��es matem�ticas com n�meros Imagin�rios.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta vers�o trabalha com os numeros Imaginarios
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
