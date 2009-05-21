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
     * Método construtor.
     */
    public NumExpoente(int valor) {
        this.valor = valor;
        this.base = new DecimalStrategy();
    }
    
    /**
     * Método herdado de Operando.
     */
    public String entraUm() {
        this.valor = base.toDecimal(base.toBase(this.valor)+"1");
        return mostra();
    }
    
    /**
     * Método herdado de Operando.
     */
    public String mostra() {
        return base.toBase(this.valor);
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
        this.base = base;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setValor(int valor) {
        this.valor = valor;
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
     * Método que adiciona a parte mantissa do operando.
     * @param escalar
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
        return this.base;
    }
    
    /**
     * Método herdado de Operando.
     */
    public int getValor() {
        return this.valor;
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
        return this;
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
        return new NumComplexo(this);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite toExponencial() {
        return new NumEngenharia(this);
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
        return visitor.visitSimples(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitSimples(operando);
    }
}
