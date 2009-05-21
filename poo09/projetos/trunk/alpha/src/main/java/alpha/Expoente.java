package alpha;
import java.util.LinkedList;

/**
 * Define o expoente dos numeros.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 1.0
 */
public class Expoente implements INumero {
    private int valor;
    private BaseStrategy base;
    /**
     * M�todo construtor.
     */
    public Expoente(int valor) {
        this.valor = valor;
        this.base = new BaseDecimalStrategy();
    }
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        this.valor = base.toDecimal(base.toBase(this.valor) + "1");
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
    public INumero soma(INumero operando) {
        return operando.accept(new SomaVisitor(operando), this); 
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero sub(INumero operando) {
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
    public void setParteReal(INumero operando) {
    }
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(INumero operando) {
    }
    /**
     * M�todo que adiciona a parte mantissa do operando.
     * @param escalar
     */
    public void setParteMantissa(INumero operando) {
    }
    /**
     * M�todo herdado de Operando.
     */
    public void setParteExponencial(INumero operando) {
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
    public INumero getParteReal() {
        return this;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero getParteImaginaria() {
        return null;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero getParteMantissa() {
        return null;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero getParteExponencial() {
        return null;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero toComplexo() {
        return new Complexo(this);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero toExponencial() {
        return new Exponencial(this);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero toVetorial() {
        return new Vetorial(this);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Real operando) {
        return visitor.visitReal(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return visitor.visitReal(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return visitor.visitReal(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return visitor.visitReal(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return visitor.visitReal(operando);
    }
}
