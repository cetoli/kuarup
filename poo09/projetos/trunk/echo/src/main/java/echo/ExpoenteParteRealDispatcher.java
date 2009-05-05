/*-----------------------------------------------------------------------------
    Copyright 2002-2006          Carlo E. T. Oliveira et all
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
 * @since   (3.0) Suporte a numeros complexos
 */
public class ExpoenteParteRealDispatcher implements Dispatcher {

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
        inteiro.getParteReal().adicionaExpoente(new Expoente(i));
    }
    
    /**
     * Metodo que muda o dispatcher para o expoente da parte atual do inteiro.
     * @return novo dispatcher
     */
    public Dispatcher entraExpoente() {
        return this;
    }
}
