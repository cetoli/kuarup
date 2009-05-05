/*------------------------------------------------------------------------------
    Copyright © 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Incluídas as funcionalidades: números com notação científica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Incluídas as funcionalidades: números complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
 */
public class Complexo implements Operando {
    
    private Operando real;
    private Operando imaginario;
    
    /**
     * Método herdado de Operando.
     */
    public Complexo() {
        this.real = new Nulo();
        this.imaginario = new Nulo();
    }
    
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
    public void adicionaParteExponencial(Operando operando) {
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
    public int getValor() {
        return 0;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setValor(int valor) {
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
    public Operando getParteExponencial() {
        return new Nulo();
    }
}
