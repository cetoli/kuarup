package alpha;


/**
 * Write a description of class NumeroDecimal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumeroDecimal extends Numero
{
    /**
     * Constructor for objects of class NumeroDecimal
     */
    public NumeroDecimal()
    {
        // initialise instance variables
    }
    
    public Integer converteEmNumeroDecimal(){
        return Integer.parseInt(repNum);
    }
    
    public INumero converterParaBase(Integer num){
        NumeroDecimal dec = new NumeroDecimal();
        dec.setRepNum(num.toString());
        return dec;
    }
    
    public String mostraNumeroNaMinhaRepresentacaoBase(){
        Integer temp = converteEmNumeroDecimal();
        return temp.toString(temp);
    }
}
