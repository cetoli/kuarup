/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;
import java.util.LinkedList;

/**
 * Classe do operando nulo.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class Nulo implements Operando {
    
    /**
     * Método construtor.
     */
    public Nulo() {
    }
    
    /**
     * Método herdado de Operando.
     */
    public String entraUm() {
        return mostra();
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra() {
        return "0";
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando soma(Operando operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando sub(Operando operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando multi(Operando operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setValor(int valor) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setVetor(LinkedList vetor) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteReal(Operando operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteImaginaria(Operando operando) {
    }
    
    /**
     * Método que adiciona a parte mantissa do operando.
     * @param escalar
     */
    public void setParteMantissa(Operando operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteExponencial(Operando operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public BaseStrategy getBase() {
        return new DecimalStrategy();
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
    public LinkedList getVetor() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteReal() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteMantissa() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteExponencial() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando toComplexo() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando toExponencial() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando toVetorial() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Simples operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return operando;
    }
}
