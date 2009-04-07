package echo;


/**
 * Write a description of class ValorBin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValorBin extends Valor
{
     public ValorBin(int novo) {
       super(novo);
    }
    
    public void setValor(String novo) {
       valor = Integer.parseInt(novo, 2);
    }
    
    public String converterEmString() {
        return Integer.toBinaryString(valor);
    }
}
