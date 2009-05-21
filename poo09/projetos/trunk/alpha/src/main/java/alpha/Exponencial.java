package alpha;
import java.util.LinkedList;

/**
 * Define a parte exponencial dos numeros.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 2.0
 */
public class Exponencial implements INumero {
    private INumero mantissa;
    private INumero expoente;
    /**
     * Método construtor.
     */
    public Exponencial(INumero operando) {
        this.mantissa = operando;
        this.expoente = new Expoente(0);
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
        return this.mantissa.mostra() + "N" + this.expoente.mostra();
    }
    /**
     * Método herdado de Operando.
     */
    public INumero soma(INumero operando) {
        return operando.accept(new SomaVisitor(operando), this);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero sub(INumero operando) {
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
    public void setParteReal(INumero operando) {
    }
    /**
     * Método herdado de Operando.
     */
    public void setParteImaginaria(INumero operando) {
    }
    /**
     * Método herdado de Operando.
     */
    public void setParteMantissa(INumero operando) {
        this.mantissa = operando;
    }
    /**
     * Método herdado de Operando.
     */
    public void setParteExponencial(INumero operando) {
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
    public INumero getParteReal() {
        return null;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero getParteImaginaria() {
        return null;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero getParteMantissa() {
        return this.mantissa;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero getParteExponencial() {
        return this.expoente;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toComplexo() {
        return new Complexo(this);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toExponencial() {
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toVetorial() {
        return new Vetorial(this);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Real operando) {
        return visitor.visitExponencial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return visitor.visitExponencial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return visitor.visitExponencial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return visitor.visitExponencial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return visitor.visitExponencial(operando);
    }
}
