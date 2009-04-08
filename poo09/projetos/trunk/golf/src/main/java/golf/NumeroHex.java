package golf;


/**
 * Write a description of class NumeroHex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumeroHex extends AbstractNumero{
    public final Integer hexadecimal = 16;
    
    /**
     * Constructor for objects of class NumeroHex
     * 
     * @atribute Integer x
     */
    public NumeroHex(Integer x){
        this.valor = x;
        this.base = hexadecimal;
    }

    /**
     * Converte o valor para Hexadecimal
     */
    public String converte(){
        String buffer = Integer.toHexString(valor);
        return buffer.toUpperCase();
    }
}
