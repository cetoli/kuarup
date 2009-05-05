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
 * @version (4.0)    $Revision$ (02/05/09)      $Date$
 * @since   (4.0) Suporte a notacao de engenharia
 */
public class ExpoenteDispatcher implements Dispatcher {

    /**
     * Metodo que adiciona a parte real ao inteiro.
     * @param inteiro
     */
    public void adicionaParteReal(int i, Inteiro inteiro) {
    }
    
    /**
     * Metodo que adiciona a parte imaginaria ao inteiro.
     * @param inteiro
     */
    public void adicionaParteImaginaria(int i, Inteiro inteiro) {
    }

    /**
     * Metodo que adiciona expoente ao inteiro.
     * @param inteiro
     */
    public void adicionaExpoente(int i, Inteiro inteiro) {
        inteiro.adicionaExpoente(new Expoente(i));
    }
}
