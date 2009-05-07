/*-----------------------------------------------------------------------------
    Copyright 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
-----------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com numeros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */
public class BaseBinariaStrategy implements BaseStrategy {

    /**
     * Retorna o identificador da base decimal, binaria ou hexadecimal.
     * @return o identificador da respectiva base.
     */
    public String getId() {
        return "0b";
    }

    /**
     * Retorna o valor em decimal do numero dado em base decimal, binaria ou
     * hexadecimal.
     * @param n string do numero dado na respectiva base.
     * @return o valor em decimal do numero dado.
     */
    public int converteBaseParaDecimal(String n) {
        return Integer.parseInt(n, 2);
    }

    /**
     * Retorna um numero em base decimal, binaria ou hexadecimal de acordo com
     * o valor em decimal dado.
     * @param v valor em decimal do numero dado.
     * @return a string do numero dado na respectiva base.
     */
    public String converteBase(int v) {
        return Integer.toBinaryString(v).toUpperCase();
    }
}
