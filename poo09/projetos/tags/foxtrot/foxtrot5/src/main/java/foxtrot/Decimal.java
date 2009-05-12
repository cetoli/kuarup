/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Andre de Abrantes
 * @version 5.0 12/05/2009 Carlos Eduardo e Andre de Abrantes
 * @since   4.0 Inclu�das as funcionalidades: numeros vetoriais e subtracao
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   3.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   2.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   1.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 */
public class Decimal implements Base {

    /**
     * Retorna o identificador da base decimal, bin�ria ou hexadecimal.
     * @return o identificador da respectiva base.
     */
    public String getId() {
        return "";
    }

    /**
     * Retorna o valor em decimal do n�mero dado em base decimal, bin�ria ou
     * hexadecimal.
     * @param n string do n�mero dado na respectiva base.
     * @return o valor em decimal do n�mero dado.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n);
    }

    /**
     * Retorna um n�mero em base decimal, bin�ria ou hexadecimal de acordo com
     * o valor em decimal dado.
     * @param v valor em decimal do n�mero dado.
     * @return a string do n�mero dado na respectiva base.
     */
    public String toBase(int v) {
        return String.valueOf(v);
    }
}
