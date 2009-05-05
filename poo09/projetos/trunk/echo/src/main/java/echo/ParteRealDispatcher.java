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
public class ParteRealDispatcher implements Dispatcher {

    /**
     * Metodo que adiciona a parte real ao inteiro.
     * @param inteiro
     */
    public void adicionaParteReal(int i, Inteiro inteiro) {
        inteiro.adicionaParteReal(new RealComposite(i));
    }

    /**
     * Metodo que adiciona a parte imaginaria ao inteiro.
     * @param inteiro
     */
    public void adicionaParteImaginaria(int i, Inteiro inteiro) {
        inteiro.adicionaParteImaginaria(new Nulo());
    }

    /**
     * Metodo que adiciona expoente ao inteiro.
     * @param inteiro
     */
    public void adicionaExpoente(int i, Inteiro inteiro) {
        inteiro.getParteReal().adicionaExpoente(new Nulo());
    }

    /**
     * Metodo que muda o dispatcher para o expoente da parte atual do inteiro.
     * @return novo dispatcher
     */
    public Dispatcher entraExpoente() {
        return new ExpoenteParteRealDispatcher();
    }
}
