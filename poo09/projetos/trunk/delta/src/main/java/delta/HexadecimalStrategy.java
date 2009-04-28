/*------------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ------------------------------------------------------------------------------*/

package delta;

/**
 * Classe da base hexadecimal.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrantes
 */
public class HexadecimalStrategy implements BaseStrategy {

    /**
     *
     */
    private final Integer valorBase = 16;

    /**
     *
     */
    private final String prefixoBase = "0x";

    /**
     *
     */
    public Integer getValorBase() {
        return valorBase;
    }

    /**
     *
     */
    public String toString(Integer integer) {
        return prefixoBase + Integer.toHexString(integer);
    }
}
