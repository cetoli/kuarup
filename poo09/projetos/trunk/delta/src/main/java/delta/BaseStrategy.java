/*------------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ------------------------------------------------------------------------------*/

package delta;

/**
 * Interface que define os metodos das bases da calculadora.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrantes
 * @since   0.2 Retirado metodo getId() e acrescentado getValorBase()
 */
public interface BaseStrategy {

    /**
     *
     */
    public Integer getValorBase();

    /**
     *
     */
    public String toString(Integer integer);
}
