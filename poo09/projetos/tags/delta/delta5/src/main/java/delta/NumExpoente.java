package delta;
import java.util.LinkedList;


/**
 * Write a description of class NumExpoente here.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumExpoente implements OperadorComposite{
    
    private int valor;
    private BaseStrategy base;
    
    /**
     * M�todo construtor.
     */
    public NumExpoente(int valor) {
        this.valor = valor;
        this.base = new DecimalStrategy();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        this.valor = base.toDecimal(base.toBase(this.valor)+"1");
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        return base.toBase(this.valor);
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
        this.base = base;
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
        return this.base;
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
    public LinkedList getVetor() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteReal() {
        return this;
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
        return new NumComplexo(this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toExponencial() {
        return new NumEngenharia(this);
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
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitSimples(operando);
    }
}
