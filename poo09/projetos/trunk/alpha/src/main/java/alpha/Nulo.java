package alpha;
import java.util.LinkedList;

/**
 * Define a parte nula dos numeros.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 2.0
 */
public class Nulo implements INumero {
    /**
     * M�todo construtor.
     */
    public Nulo() {
    }
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        return mostra();
    }
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        return "0";
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero soma(INumero operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero sub(INumero operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero multi(INumero operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
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
        return new BaseDecimalStrategy();
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
        return null;
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
        return this;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero toExponencial() {
        return this;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero toVetorial() {
        return this;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Real operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return operando;
    }
    /**
     * M�todo herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return operando;
    }
}
