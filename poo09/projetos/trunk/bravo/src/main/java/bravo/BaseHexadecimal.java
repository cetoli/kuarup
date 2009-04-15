package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * Retorna uma String.
 * @author (Tiago C. de Fran�a) O papagaio
 * @author (Humberto Ferreira Ramos Junior) O pirata
 * @version 2.0 em 12 de abril de 2009
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