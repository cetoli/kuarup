/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
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
public interface Operando {
    
    /**
     * M�todo que soma um operando a outro operando.
     * @param operando
     */
    public void soma(Operando operando);
    
    /**
     * M�todo que adiciona uma parte real a um operando.
     * @param operando
     */
    public void adicionaParteReal(Operando operando);
    
    /**
     * M�todo que adiciona uma parte imagin�ria a um operando.
     * @param operando
     */
    public void adicionaParteImaginaria(Operando operando);
    
    /**
     * M�todo que mostra o operando na base especificada.
     * @param base
     * @return valor do operando na base especificada
     */
    public String mostra(Base base);
    
    /**
     * M�todo que retorna a parte real do operando.
     * @return operando
     */
    public Operando getParteReal();
    
    /**
     * M�todo que retorna a parte imagin�ria do operando.
     * @return operando
     */
    public Operando getParteImaginaria();
    
    /**
     * M�todo que retorna o valor em decimal da parte real ou 
     * imagin�ria do operando
     * @return valor em decimal
     */
    public int getValor();
}
