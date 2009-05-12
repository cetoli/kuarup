package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class BaseBinaria implements StrategyBase {

    /**
     * Constructor for objects of class BaseBinaria.
     */
    public BaseBinaria() {
    }
    
    public String getId(){
        return "0b";   
    }

    public int toDecimal(String numero) {
        return Integer.parseInt(numero, 2);
    }

    /**
     * Metodo conversor para base Binaria.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * Retornar a String.
     * @param valor
     * @return String com a representacao na base binaria do valor
     */
    public String converterBase(int valor) {
        return Integer.toBinaryString(valor);
    }
}