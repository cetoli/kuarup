/*------------------------------------------------------------------------------
    Copyright � 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;

/**
 * Classe do operando exponencial/com nota��o cient�fica.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumEngenharia implements OperadorComposite {
    
    private OperadorComposite mantissa;
    private OperadorComposite expoente;
    
    /**
     * M�todo construtor.
     */
    public NumEngenharia(OperadorComposite operando) {
        this.mantissa = operando;
        this.expoente = new NumExpoente(0);
        this.expoente.setBase(this.mantissa.getBase());
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        this.expoente.entraUm();
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        return this.mantissa.mostra()+"N"+this.expoente.mostra();
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
        this.mantissa.setBase(base);
        this.expoente.setBase(base);
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
     * M�todo herdado de Operando.
     */
    public void setParteMantissa(OperadorComposite operando) {
        this.mantissa = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteExponencial(OperadorComposite operando) {
        this.expoente = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public BaseStrategy getBase() {
        return this.expoente.getBase();
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
        return this.mantissa;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteExponencial() {
        return this.expoente;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toComplexo() {
        return new NumComplexo(this);
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
        return new NumVetorial(this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitExponencial(operando);
    }
}
