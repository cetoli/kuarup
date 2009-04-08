package golf;


/**
 * Write a description of class NumeroDec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumeroDec extends AbstractNumero{
    public final Integer decimal = 10;
    
    /**
     * Constructor for objects of class NumeroDec
     * 
     * @atribute Integer x
     */
    public NumeroDec(Integer x){
        this.valor = x;
        this.base = decimal;
    }

    /**
     * Converte o valor para decimal
     */
    public String converte(){
        return valor.toString();
    }
}
