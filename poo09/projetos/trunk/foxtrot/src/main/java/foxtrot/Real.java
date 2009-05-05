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
public class Real implements Operando {
    
    private int valor;
    private Operando exponencial;
    
    /**
     * Método herdado de Operando.
     */
    public Real(int valor) {
        this.valor = valor;
        this.exponencial = new Nulo();
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
    public void adicionaParteExponencial(Operando operando) {
        this.exponencial = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra(Base base) {
        return base.getId()+base.toBase(this.valor)+this.exponencial.mostra(base);
    }

    /**
     * Método herdado de Operando.
     */
    public void soma(Operando operando) {
        int valorOutro = operando.getParteReal().getValor();
        int maxExp = Math.max(this.exponencial.getValor(), operando.getParteReal().getParteExponencial().getValor());
        this.valor = this.valor/((int)Math.pow(10, maxExp-this.exponencial.getValor()));
        valorOutro = valorOutro/((int)Math.pow(10, maxExp-operando.getParteReal().getParteExponencial().getValor()));
        this.valor += valorOutro;
        this.exponencial.setValor(maxExp);
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
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Método herdado de Operando.
     */
    public Operando getParteReal() {
        return this;
    }

    /**
     * Método herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return new Nulo();
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteExponencial() {
        return this.exponencial;
    }
}
