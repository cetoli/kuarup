package alpha;


/**
 * Write a description of class NumeroHexadecimal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumeroHexadecimal extends Numero
{
    private static final int BASE=16;
    
    public NumeroHexadecimal()
    {
        // initialise instance variables
    }
    
    public Integer converteEmNumeroDecimal(){
        return Integer.valueOf(repNum, BASE);
    }
    
    public INumero converterParaBase(Integer num){
         NumeroHexadecimal hex = new NumeroHexadecimal();
         hex.setRepNum(Integer.toHexString(num));
        
        return hex;
    }
    
    public String mostraNumeroNaMinhaRepresentacaoBase(){
        Integer temp = converteEmNumeroDecimal();
        return temp.toHexString(temp);
    }
}
