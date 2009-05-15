/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe da base decimal.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class DecimalStrategy implements BaseStrategy {

    /**
     * Método herdado de BaseStrategy.
     */
    public String getId() {
        return "";
    }

    /**
     * Método herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n);
    }

    /**
     * Método herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return String.valueOf(v);
    }
}
