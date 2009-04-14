package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
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
    public final Integer entraUm(Integer valor) {
        valor = valor * 2 + 1;
        return valor;
    }

    /**
     * Metodo conversor para base Binaria.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * Retornar a String.
     * @param valor
     * @retorno String com a representacao na base binaria do valor
     */
    public final String converterBase(Integer valor) {
        return "0b" + Integer.toBinaryString(valor);
    }
}