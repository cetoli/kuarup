package alpha;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Define os numeros vetoriais.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 1.0
 */
public class Vetorial implements INumero {
    private LinkedList vetor;

    /**
     * Método construtor.
     */
    public Vetorial(INumero operando) {
        vetor = new LinkedList();
        vetor.addLast(operando);
        INumero aux = new Real(0);
        aux.setBase(operando.getBase());
        vetor.addLast(aux);
    }
    /**
     * Método herdado de Operando.
     */
    public String entraUm() {
        ((INumero) vetor.getLast()).entraUm();
        return mostra();
    }
    /**
     * Método herdado de Operando.
     */
    public String mostra() {
        INumero operando;
        Iterator it = vetor.iterator();
        operando = (INumero)it.next();
        String str = operando.mostra();
        while (it.hasNext()) {
            operando = (INumero)it.next();
            str += "V" + operando.mostra();
        }
        return str;
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
        INumero operando;
        Iterator it = vetor.iterator();
        operando = (INumero)it.next();
        operando.setBase(base);
        while (it.hasNext()) {
            operando = (INumero)it.next();
            operando.setBase(base);
        }
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
        this.vetor = vetor;
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
        return ((INumero) vetor.getLast()).getBase();
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
        return this.vetor;
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
        INumero operando = (INumero)vetor.removeLast();
        operando = operando.toComplexo();
        vetor.addLast(operando);
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toExponencial() {
        INumero operando = (INumero)vetor.removeLast();
        operando = operando.toExponencial();
        vetor.addLast(operando);
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toVetorial() {
        INumero operando = new Real(0);
        vetor.addLast(operando);
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Real operando) {
        return visitor.visitVetorial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return visitor.visitVetorial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return visitor.visitVetorial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return visitor.visitVetorial(operando);
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return visitor.visitVetorial(operando);
    }
}
