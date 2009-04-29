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
 */
public class Complexo implements Operando {
    
    private Operando real;
    private Operando imaginario;
    
    /**
     * Método herdado de Operando.
     */
    public void adicionaParteReal(Operando operando) {
        this.real = operando;
    }
    /**
     * Método herdado de Operando.
     */
    public void adicionaParteImaginaria(Operando operando) {
        this.imaginario = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra(Base base) {
        return this.real.mostra(base)+this.imaginario.mostra(base);
    }
    
    /**
     * Método herdado de Operando.
     */
    public void soma(Operando operando) {
        this.real.soma(operando.getParteReal());
        this.imaginario.soma(operando.getParteImaginaria());
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteReal() {
        return this.real;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this.imaginario;
    }
    
    /**
     * Método herdado de Operando.
     */
    public int getValor() {
        return 0;
    }
}
