package golf;
import java.util.LinkedList;


/**
 * Write a description of class Expoente here.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class Expoente implements Operando{
    
    private int valor;
    private BaseStrategy base;
    
    /**
     * M�todo construtor.
     */
    public Expoente(int valor) {
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
    public Operando soma(Operando operando) {
        return operando.accept(new SomaVisitor(operando), this); 
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando sub(Operando operando) {
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
    public Operando getParteReal() {
        return this;
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
        return new Complexo(this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toExponencial() {
        return new Exponencial(this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toVetorial() {
        return new Vetorial(this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Simples operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return visitor.visitSimples(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return visitor.visitSimples(operando);
    }
}
