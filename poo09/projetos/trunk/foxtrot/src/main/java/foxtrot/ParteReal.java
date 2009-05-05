/*------------------------------------------------------------------------------
    Copyright © 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Incluídas as funcionalidades: números com notação científica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Incluídas as funcionalidades: números complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
 */
public class ParteReal implements Adicionador {
  
    /**
     * Método que adiciona a parte real ao operando.
     * @param operando
     */
    public void adicionaParteReal(int i, Operando operando, Adicionador montador) {
        montador.adicionaParteReal(i, operando, montador);
    }

    /**
     * Método que adiciona a parte imaginária ao operando.
     * @param operando
     */
    public void adicionaParteImaginaria(int i, Operando operando, Adicionador montador) {
    }
}
