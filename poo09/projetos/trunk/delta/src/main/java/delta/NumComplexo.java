/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;

/**
 * Classe do operando complexo.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumComplexo implements OperadorComposite {
    
    private OperadorComposite real;
    private OperadorComposite imaginario;
    
    /**
     * Método construtor.
     */
    public NumComplexo(OperadorComposite operando) {
        this.real = operando;
        this.imaginario = new NumReal(0);
        this.imaginario.setBase(this.real.getBase());
    }
    
    /**
     * Método herdado de Operando.
     */
    public String entraUm() {
        this.imaginario.entraUm();
        return mostra();
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra() {
        return this.real.mostra()+"I"+this.imaginario.mostra();
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
        this.real.setBase(base);
        this.imaginario.setBase(base);
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
        this.real = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteImaginaria(OperadorComposite operando) {
        this.imaginario = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteMantissa(OperadorComposite operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteExponencial(OperadorComposite operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public BaseStrategy getBase() {
        return this.imaginario.getBase();
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
    public OperadorComposite getParteReal(){
        return this.real;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite getParteImaginaria() {
        return this.imaginario;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite getParteMantissa() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite getParteExponencial() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite toComplexo() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite toExponencial() {
        this.imaginario = new NumEngenharia(this.imaginario);
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
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitComplexo(operando);
    }
}
