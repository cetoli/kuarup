package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 */
public class BaseHexadecimal implements StrategyBase {

    /**
     * Constructor for objects of class BaseHexadecimal.
     */
    public BaseHexadecimal() {
    }
    
    public String getId(){
        return "0x";   
    }
        
    public int toDecimal(String numero) {
        return Integer.parseInt(numero, 16);
    }

    /**
     * Metodo conversor para base Binaria.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * Retornar a String.
     * @param valor
     * @return String com a representacao na base hexadecimal do valor
     */
    public String converterBase(int valor) {
        return Integer.toHexString(valor).toUpperCase();
    }
}