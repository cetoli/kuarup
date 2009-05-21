/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;

/**
 * Classe do operando simples/real.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumReal implements OperadorComposite {
    
    private int valor;
    private BaseStrategy base;
    
    /**
     * M�todo construtor.
     */
    public NumReal(int valor) {
        this.valor = valor;
        this.base = new DecimalStrategy();
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public String entraUm() {
        this.valor = base.toDecimal(base.toBase(this.valor)+"1");
        return mostra();
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public String mostra() {
        return base.getId()+base.toBase(this.valor);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite soma(OperadorComposite operando) {
        return operando.accept(new SomaVisitor(operando), this); 
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite sub(OperadorComposite operando) {
        return operando.accept(new SubtracaoVisitor(operando), this); 
    }
        
    /**
     * M�todo herdado de OperadorComposite.
     */
    public void setBase(BaseStrategy base) {
        this.base = base;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public void setVetor(LinkedList vetor) {
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public void setParteReal(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public void setParteImaginaria(OperadorComposite operando) {
    }
    
    /**
     * M�todo que adiciona a parte mantissa do OperadorComposite.
     * @param escalar
     */
    public void setParteMantissa(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public void setParteExponencial(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public BaseStrategy getBase() {
        return this.base;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public int getValor() {
        return this.valor;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public LinkedList getVetor() {
        return null;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite getParteReal() {
        return this;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite getParteImaginaria() {
        return null;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite getParteMantissa() {
        return null;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite getParteExponencial() {
        return null;
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite toComplexo() {
        return new NumComplexo(this);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite toExponencial() {
        return new NumEngenharia(this);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite toVetorial() {
        return new NumVetorial(this);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de OperadorComposite.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitSimples(operando);
    }
}
