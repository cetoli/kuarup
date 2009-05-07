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
public interface Inteiro {

    /**
     * Metodo que soma um inteiro a outro inteiro.
     * @param inteiro
     */
    public void soma(Inteiro inteiro);

    /**
     * Metodo que adiciona uma parte real a um inteiro.
     * @param inteiro
     */
    public void adicionaParteReal(Inteiro inteiro);

    /**
     * Metodo que adiciona uma parte imaginaria a um inteiro.
     * @param inteiro
     */
    public void adicionaParteImaginaria(Inteiro inteiro);

    /**
     * Metodo que adiciona um expoente a um inteiro.
     * @param inteiro
     */
    public void adicionaExpoente(Inteiro inteiro);

    /**
     * Metodo que mostra o inteiro na base especificada.
     * @param base
     * @return valor do inteiro na base especificada
     */
    public String mostra(BaseStrategy base);

    /**
     * Metodo que retorna a parte real do inteiro.
     * @return inteiro
     */
    public Inteiro getParteReal();

    /**
     * Metodo que retorna a parte imaginaria do inteiro.
     * @return inteiro
     */
    public Inteiro getParteImaginaria();

    /**
     * Metodo que retorna o expoente do inteiro.
     * @return inteiro
     */
    public Inteiro getExpoente();

    /**
     * Metodo que retorna o valor em decimal da parte real ou 
     * imaginaria do inteiro
     * @return valor em decimal
     */
    public int getValor();
}
