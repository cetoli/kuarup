/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;

/**
 * Classe do operando exponencial/com notação científica.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumEngenharia implements OperadorComposite {
    
    private OperadorComposite mantissa;
    private OperadorComposite expoente;
    
    /**
     * Método construtor.
     */
    public NumEngenharia(OperadorComposite operando) {
        this.mantissa = operando;
        this.expoente = new NumExpoente(0);
        this.expoente.setBase(this.mantissa.getBase());
    }
    
    /**
     * Método herdado de Operando.
     */
    public String entraUm() {
        this.expoente.entraUm();
        return mostra();
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra() {
        return this.mantissa.mostra()+"N"+this.expoente.mostra();
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite soma(OperadorComposite operando) {
        return operando.accept(new SomaVisitor(operando), this);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite sub(OperadorComposite operando) {
        return operando.accept(new SubtracaoVisitor(operando), this); 
    }
    
    
    /**
     * Método herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
        this.mantissa.setBase(base);
        this.expoente.setBase(base);
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
    public void setParteReal(OperadorComposite operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteImaginaria(OperadorComposite operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteMantissa(OperadorComposite operando) {
        this.mantissa = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteExponencial(OperadorComposite operando) {
        this.expoente = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public BaseStrategy getBase() {
        return this.expoente.getBase();
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
    public OperadorComposite getParteReal() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite getParteImaginaria() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite getParteMantissa() {
        return this.mantissa;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite getParteExponencial() {
        return this.expoente;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite toComplexo() {
        return new NumComplexo(this);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite toExponencial() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite toVetorial() {
        return new NumVetorial(this);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitExponencial(operando);
    }
}
