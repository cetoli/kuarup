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
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */
public interface Operando {

    /**
     * Metodo que soma um operando a outro operando.
     * @param operando
     */
    public void soma(Operando operando);

    /**
     * Metodo que adiciona uma parte real a um operando.
     * @param operando
     */
    public void adicionaParteReal(Operando operando);

    /**
     * Metodo que adiciona uma parte imaginaria a um operando.
     * @param operando
     */
    public void adicionaParteImaginaria(Operando operando);

    /**
     * Metodo que adiciona um expoente a um operando.
     * @param operando
     */
    public void adicionaExpoente(Operando operando);

    /**
     * Metodo que mostra o operando na base especificada.
     * @param base
     * @return valor do operando na base especificada
     */
    public String mostra(Base base);

    /**
     * Metodo que retorna a parte real do operando.
     * @return operando
     */
    public Operando getParteReal();

    /**
     * Metodo que retorna a parte imaginaria do operando.
     * @return operando
     */
    public Operando getParteImaginaria();

    /**
     * Metodo que retorna o expoente do operando.
     * @return operando
     */
    public Operando getExpoente();

    /**
     * Metodo que retorna o valor em decimal da parte real ou 
     * imaginaria do operando
     * @return valor em decimal
     */
    public int getValor();
}
