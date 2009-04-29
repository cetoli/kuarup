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
public class Imaginario implements Operando {
    
    private int valor;
    
    /**
     * Método herdado de Operando.
     */
    public Imaginario(int valor) {
        this.valor = valor;    
    }
    
    /**
     * Método herdado de Operando.
     */
    public void adicionaParteReal(Operando operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void adicionaParteImaginaria(Operando operando) {    
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra(Base base) {
        return "I" + base.getId() + base.converteBase(this.valor);
    }
    
    /**
     * Método herdado de Operando.
     */
    public void soma(Operando operando) {
        this.valor += operando.getValor();
    }
    
    /**
     * Método herdado de Operando.
     */
    public int getValor() {
        return this.valor;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteReal() {
        return new Nulo();
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this;
    }
}
