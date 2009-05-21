/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe da base binária.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class BinariaStrategy implements BaseStrategy {

    /**
     * Método herdado de BaseStrategy.
     */
    public String getId() {
        return "0b";
    }

    /**
     * Método herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n, 2);
    }

    /**
     * Método herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return Integer.toBinaryString(v);
    }
}
