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
     * M�todo construtor.
     */
    public Complexo(INumero operando) {
        this.real = operando;
        this.imaginario = new Real(0);
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
        return this.real.mostra() + "I" + this.imaginario.mostra();
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
    public void setParteReal(INumero operando) {
        this.real = operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(INumero operando) {
        this.imaginario = operando;
    }
    /**
     * M�todo herdado de Operando.
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
    public INumero getParteReal() {
        return this.real;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero getParteImaginaria() {
        return this.imaginario;
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
        return this;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero toExponencial() {
        this.imaginario = new Exponencial(this.imaginario);
        return this;
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
        return visitor.visitComplexo(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return visitor.visitComplexo(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return visitor.visitComplexo(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return visitor.visitComplexo(operando);
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return visitor.visitComplexo(operando);
    }
}
