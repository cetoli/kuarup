package alpha;
import java.util.LinkedList;

/**
 * Define os numeros complexos.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 2.0
 */
public class Complexo implements INumero {
    private INumero real;
    private INumero imaginario;
    /**
     * Método construtor.
     */
    public Complexo(INumero operando) {
        this.real = operando;
        this.imaginario = new Real(0);
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
        return this.real.mostra() + "I" + this.imaginario.mostra();
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
    public void setParteReal(INumero operando) {
        this.real = operando;
    }
    /**
     * Método herdado de Operando.
     */
    public void setParteImaginaria(INumero operando) {
        this.imaginario = operando;
    }
    /**
     * Método herdado de Operando.
     */
    public void setParteMantissa(INumero operando) {
    }
    /**
     * Método herdado de Operando.
     */
    public void setParteExponencial(INumero operando) {
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
    public INumero getParteReal() {
        return this.real;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero getParteImaginaria() {
        return this.imaginario;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero getParteMantissa() {
        return null;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero getParteExponencial() {
        return null;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toComplexo() {
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toExponencial() {
        this.imaginario = new Exponencial(this.imaginario);
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
        return visitor.visitComplexo(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return visitor.visitComplexo(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return visitor.visitComplexo(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return visitor.visitComplexo(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return visitor.visitComplexo(operando);
    }
}
