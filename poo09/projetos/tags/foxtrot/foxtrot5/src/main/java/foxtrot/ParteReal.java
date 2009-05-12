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
public class ParteReal implements Adicionador {

    /**
     * M�todo que adiciona a parte real ao operando.
     * @param operando
     */
    public void adicionaParteReal(int i, Operando operando, Adicionador montador) {
        montador.adicionaParteReal(i, operando, montador);
    }

    /**
     * M�todo que adiciona a parte imagin�ria ao operando.
     * @param operando
     */
    public void adicionaParteImaginaria(int i, Operando operando, Adicionador montador) {
    }
}
