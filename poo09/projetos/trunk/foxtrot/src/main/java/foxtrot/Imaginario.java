/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Andre de Abrantes
 * @version 5.0 12/05/2009 Carlos Eduardo e Andre de Abrantes
 * @since   4.0 Inclu�das as funcionalidades: numeros vetoriais e subtracao
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   3.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   2.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   1.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 */
public class Imaginario implements Operando {
    
    private int valor;
    private Operando exponencial;
    
    /**
     * M�todo herdado de Operando.
     */
    public Imaginario(int valor) {
        this.valor = valor;
        this.exponencial = new Nulo();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void adicionaParteReal(Operando operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void adicionaParteImaginaria(Operando operando) {    
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void adicionaParteExponencial(Operando operando) {
        this.exponencial = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra(Base base) {
        return "I"+base.getId()+base.toBase(this.valor)+this.exponencial.mostra(base);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void soma(Operando operando) {
        int valorOutro = operando.getParteImaginaria().getValor();
        int maxExp = Math.max(this.exponencial.getValor(), operando.getParteImaginaria().getParteExponencial().getValor());
        this.valor = this.valor/((int)Math.pow(10, maxExp-this.exponencial.getValor()));
        valorOutro = valorOutro/((int)Math.pow(10, maxExp-operando.getParteImaginaria().getParteExponencial().getValor()));
        this.valor += valorOutro;
        this.exponencial.setValor(maxExp);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void subtrai(Operando operando) {
        int valorOutro = operando.getParteImaginaria().getValor();
        int maxExp = Math.max(this.exponencial.getValor(), operando.getParteImaginaria().getParteExponencial().getValor());
        this.valor = this.valor/((int)Math.pow(10, maxExp-this.exponencial.getValor()));
        valorOutro = valorOutro/((int)Math.pow(10, maxExp-operando.getParteImaginaria().getParteExponencial().getValor()));
        this.valor -= valorOutro;
        this.exponencial.setValor(maxExp);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public int getValor() {
        return this.valor;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteReal() {
        return new Nulo();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteExponencial() {
        return this.exponencial;
    }
    
    /**
     * 
     */
    public Operando entraV() {
        return this;
    }
    
    /**
     * 
     */
    public Visitor getVisitor() {
        return new OperandoEscalarVisitor(this);
    }
}
