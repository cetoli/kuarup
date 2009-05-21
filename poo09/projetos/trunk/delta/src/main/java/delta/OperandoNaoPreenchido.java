/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;

/**
 * Classe do operando nulo.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class OperandoNaoPreenchido implements OperadorComposite {
    
    /**
     * M�todo construtor.
     */
    public OperandoNaoPreenchido() {
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
    public OperadorComposite soma(OperadorComposite operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite sub(OperadorComposite operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite multi(OperadorComposite operando) {
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
    public void setParteReal(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(OperadorComposite operando) {
    }
    
    /**
     * M�todo que adiciona a parte mantissa do operando.
     * @param escalar
     */
    public void setParteMantissa(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteExponencial(OperadorComposite operando) {
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
    public OperadorComposite getParteReal() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteImaginaria() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteMantissa() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteExponencial() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toComplexo() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toExponencial() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toVetorial() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return operando;
    }
}
