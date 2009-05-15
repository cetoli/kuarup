/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
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
     * M�todo construtor.
     */
    public Nulo() {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        return "0";
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando soma(Operando operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando sub(Operando operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando multi(Operando operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setValor(int valor) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setVetor(LinkedList vetor) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteReal(Operando operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(Operando operando) {
    }
    
    /**
     * M�todo que adiciona a parte mantissa do operando.
     * @param escalar
     */
    public void setParteMantissa(Operando operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteExponencial(Operando operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public BaseStrategy getBase() {
        return new DecimalStrategy();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public int getValor() {
        return 0;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public LinkedList getVetor() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteReal() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteMantissa() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteExponencial() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toComplexo() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toExponencial() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toVetorial() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Simples operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return operando;
    }
}
