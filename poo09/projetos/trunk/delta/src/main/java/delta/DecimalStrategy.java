/*------------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ------------------------------------------------------------------------------*/

package delta;

/**
 * Classe da base decimal.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 07/04/2009 Andr� Sion e Thiago Silva de Souza
 */
public class DecimalStrategy implements BaseStrategy {

    /**
     *
     */
    private final int valorBase = 10;

    /**
     *
     */
    public final int getValorBase() {
        return valorBase;
    }

    /**
     *
     */
    public final String toString(final int integer) {
        return Integer.toString(integer);
    }
}
