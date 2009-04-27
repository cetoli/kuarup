package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * Retorna uma String.
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 */
public class BaseHexadecimal implements StrategyBase {

    /**
     * Constructor for objects of class BaseHexadecimal.
     */
    public BaseHexadecimal() {
    }

    /**
     * Metodo de Entrada para HexaDecimal.
     */    
    public Numero entraUm(Numero valor) {
        valor.setX( valor.getX() * 16 + 1);
        return valor;
    }

    /**
     * Metodo conversor para base Hexadecimal.
     * @param valor
     * @retorno String com a representacao na base hexadecimal do valor
     */
    public String converterBase(Numero valor) {
        return "0x" + Integer.toHexString(valor.getX());
    }
}