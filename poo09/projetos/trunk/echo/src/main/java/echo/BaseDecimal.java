/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com números complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Thiago Silva de Souza)  $Author$
 * @version (3.0)    $Revision$ (28/04/09)      $Date$
 * @since   (3.0) Suporte a números complexos
 * @version (2.0)    $Revision$ (07/04/09)      $Date$
 * @since   (2.0) Botoes para entrar valores em binario, hexadecimal e decimal
 */
public class BaseDecimal implements Base {

    /**
     * Retorna o identificador da base decimal, binária ou hexadecimal.
     * @return o identificador da respectiva base.
     */
    public String getId() {
        return "";
    }

    /**
     * Retorna o valor em decimal do número dado em base decimal, binária ou
     * hexadecimal.
     * @param n string do número dado na respectiva base.
     * @return o valor em decimal do número dado.
     */
    public int converteBaseParaDecimal(String n) {
        return Integer.parseInt(n);
    }

    /**
     * Retorna um número em base decimal, binária ou hexadecimal de acordo com
     * o valor em decimal dado.
     * @param v valor em decimal do número dado.
     * @return a string do número dado na respectiva base.
     */
    public String converteBase(int v) {
        return String.valueOf(v);
    }
}