package echo;


/**
 * Write a description of class ValorHex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValorHex extends Valor
{
   public ValorHex(int novo) {
       super(novo);
    }
   
   public void setValor(String novo) {
       valor = Integer.parseInt(novo, 16);
    }
    
    public String converterEmString() {
        return Integer.toHexString(valor);
    }
}
