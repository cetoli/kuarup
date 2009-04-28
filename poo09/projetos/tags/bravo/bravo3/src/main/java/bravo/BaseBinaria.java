package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 */
public class BaseBinaria implements StrategyBase {

    /**
     * Constructor for objects of class BaseBinaria.
     */
    public BaseBinaria() {
    }

    /**
     * Metodo de Entrada para Binários.
     * Entrada de valores.
     */
    public Numero entraUm(Numero valor) {
        valor.setX( valor.getX() * 2 + 1);
        return valor;
    }

    /**
     * Metodo conversor para base Binaria.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * Retornar a String.
     * @param valor
     * @retorno String com a representacao na base binaria do valor
     */
    public String converterBase(Numero valor) {
        return "0b" + Integer.toBinaryString(valor.getX());
    }
}