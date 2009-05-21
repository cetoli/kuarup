/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
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
     * M�todo construtor.
     */
    public NumComplexo(OperadorComposite operando) {
        this.real = operando;
        this.imaginario = new NumReal(0);
        this.imaginario.setBase(this.real.getBase());
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        this.imaginario.entraUm();
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        return this.real.mostra()+"I"+this.imaginario.mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite soma(OperadorComposite operando) {
        return operando.accept(new SomaVisitor(operando), this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite sub(OperadorComposite operando) {
        return operando.accept(new SubtracaoVisitor(operando), this);
    }
        
    /**
     * M�todo herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
        this.real.setBase(base);
        this.imaginario.setBase(base);
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
        this.real = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(OperadorComposite operando) {
        this.imaginario = operando;
    }
    
    /**
     * M�todo herdado de Operando.
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
        return this.imaginario.getBase();
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
    public OperadorComposite getParteReal(){
        return this.real;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteImaginaria() {
        return this.imaginario;
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
        this.imaginario = new NumEngenharia(this.imaginario);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toVetorial() {
        return new NumVetorial(this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitComplexo(operando);
    }
}
