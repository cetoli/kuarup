/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package delta;

/**
 * Interface que define os métodos das bases da calculadora.
 * @author  André Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 André Sion e Thiago Silva de Souza
 * @since   0.1 Incluídas as implementações dos métodos toBase() e
 * toDecValue().
 */
public interface BaseStrategy {

    /**
     * Retorna o identificador da base decimal, binária ou hexadecimal.
     * @return o identificador da respectiva base.
     */
    public String getId();

    /**
     * Retorna o valor em decimal do número dado em base decimal, binária ou
     * hexadecimal.
     * @param n string do número dado na respectiva base.
     * @return o valor em decimal do número dado.
     */
    public int toDecValue(String n);

    /**
     * Retorna um número em base decimal, binária ou hexadecimal de acordo com
     * o valor em decimal dado.
     * @param v valor em decimal do número dado.
     * @return a string do número dado na respectiva base.
     */
    public String toBase(int v);
}
