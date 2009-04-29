/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package golf;

/**
 * Interface que define os m�todos das bases da calculadora.
 * @author  Andr� Sion
 * @author  Thiago Silva de Souza
 * @version 2.0 07/04/2009 Andr� Sion e Thiago Silva de Souza
 * @since   2.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 * @version 1.0 31/03/2009 Andr� Sion e Thiago Silva de Souza
 * @since   1.0 Inclu�das as implementa��es dos m�todos limpa(), entraUm() e
 * comandoSoma().
 */
public interface BaseStrategy {

    /**
     * Retorna o identificador da base decimal, bin�ria ou hexadecimal.
     * @return o identificador da respectiva base.
     */
    public String getId();

    /**
     * Retorna o valor em decimal do n�mero dado em base decimal, bin�ria ou
     * hexadecimal.
     * @param n string do n�mero dado na respectiva base.
     * @return o valor em decimal do n�mero dado.
     */
    public int toDecValue(String n);

    /**
     * Retorna um n�mero em base decimal, bin�ria ou hexadecimal de acordo com
     * o valor em decimal dado.
     * @param v valor em decimal do n�mero dado.
     * @return a string do n�mero dado na respectiva base.
     */
    public String toBase(int v);

    /**
     * Retorna o valor em decimal da base decimal, binaria ou
     * hexadecimal.
     * @return o valor em decimal do n�mero dado.
     */
    public int getBase();

}
