/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe da base hexadecimal.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class HexadecimalStrategy implements BaseStrategy {

    /**
     * Método herdado de BaseStrategy.
     */
    public String getId() {
        return "0x";
    }

    /**
     * Método herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n, 16);
    }

    /**
     * Método herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return Integer.toHexString(v).toUpperCase();
    }
}
