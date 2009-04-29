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
public interface Operando {
    
    /**
     * Método que soma um operando a outro operando.
     * @param operando
     */
    public void soma(Operando operando);
    
    /**
     * Método que adiciona uma parte real a um operando.
     * @param operando
     */
    public void adicionaParteReal(Operando operando);
    
    /**
     * Método que adiciona uma parte imaginária a um operando.
     * @param operando
     */
    public void adicionaParteImaginaria(Operando operando);
    
    /**
     * Método que mostra o operando na base especificada.
     * @param base
     * @return valor do operando na base especificada
     */
    public String mostra(Base base);
    
    /**
     * Método que retorna a parte real do operando.
     * @return operando
     */
    public Operando getParteReal();
    
    /**
     * Método que retorna a parte imaginária do operando.
     * @return operando
     */
    public Operando getParteImaginaria();
    
    /**
     * Método que retorna o valor em decimal da parte real ou 
     * imaginária do operando
     * @return valor em decimal
     */
    public int getValor();
}
