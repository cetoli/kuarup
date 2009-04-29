/*------------------------------------------------------------------------------
    Copyright � 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com n�meros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Thiago Silva de Souza)  $Author$
 * @version (3.0)    $Revision$ (28/04/09)      $Date$
 * @since   (3.0) Suporte a n�meros complexos
 */
public class CompositorParteImaginaria implements Compositor {
    
    /**
     * M�todo que adiciona a parte real ao operando.
     * @param operando
     */
    public void adicionaParteReal(int i, Operando operando) {
    }

    /**
     * M�todo que adiciona a parte imagin�ria ao operando.
     * @param operando
     */
    public void adicionaParteImaginaria(int i, Operando operando) {
        operando.adicionaParteImaginaria(new Imaginario(i));
    }
}
