package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * Retorna uma String.
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
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