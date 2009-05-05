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
public class CompositorExpoente implements Compositor {

    /**
     * Metodo que adiciona a parte real ao operando.
     * @param operando
     */
    public void adicionaParteReal(int i, Operando operando) {
    }
    
    /**
     * Metodo que adiciona a parte imaginaria ao operando.
     * @param operando
     */
    public void adicionaParteImaginaria(int i, Operando operando) {
    }

    /**
     * Metodo que adiciona expoente ao operando.
     * @param operando
     */
    public void adicionaExpoente(int i, Operando operando) {
        operando.adicionaExpoente(new Expoente(i));
    }
}
