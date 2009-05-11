/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 */
public interface Operando {
    
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
     * M�todo herdado de Operando.
     */
    public void adicionaParteExponencial(Operando operando);
    
    /**
     * M�todo que mostra o operando na base especificada.
     * @param base
     * @return valor do operando na base especificada
     */
    public String mostra(Base base);
    
    /**
     * M�todo que soma um operando a outro operando.
     * @param operando
     */
    public void soma(Operando operando);

    /**
     * M�todo que retorna o valor em decimal da parte real ou 
     * imagin�ria do operando
     * @return valor em decimal
     */
    public int getValor();
    
    /**
     * M�todo que adiciona o valor em decimal da parte real ou 
     * imagin�ria do operando
     */
    public void setValor(int valor);
    
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
     * M�todo que retorna a parte imagin�ria do operando.
     * @return operando
     */
    public Operando getParteExponencial();

    Operando entraV();
    
    Visitor getVisitor();
}
