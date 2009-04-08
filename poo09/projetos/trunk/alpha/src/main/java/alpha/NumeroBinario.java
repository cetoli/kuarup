package alpha;


/**
 * Write a description of class NumeroBinario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumeroBinario extends Numero
{
    private static final int BASE=2;
    /**
     * Constructor for objects of class NumeroBinario
     */
    public NumeroBinario()
    {
        // initialise instance variables
    }
    
    public Integer converteEmNumeroDecimal(){
          return Integer.valueOf(repNum, BASE);
    }
    
    public INumero converterParaBase(Integer num){
        NumeroBinario bin = new NumeroBinario();
        bin.setRepNum(Integer.toBinaryString(num));
        
        return bin;
    }
    
    public String mostraNumeroNaMinhaRepresentacaoBase(){
        Integer temp = converteEmNumeroDecimal();
        return temp.toBinaryString(temp);
    }
}
