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
     * Método construtor.
     */
    public Nulo() {
    }
    /**
     * Método herdado de Operando.
     */
    public String entraUm() {
        return mostra();
    }
    /**
     * Método herdado de Operando.
     */
    public String mostra() {
        return "0";
    }
    /**
     * Método herdado de Operando.
     */
    public INumero soma(INumero operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero sub(INumero operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero multi(INumero operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
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
     * Método que adiciona a parte mantissa do operando.
     * @param escalar
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
        return new BaseDecimalStrategy();
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
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero toVetorial() {
        return this;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Real operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Expoente operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Complexo operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Exponencial operando) {
        return operando;
    }
    /**
     * Método herdado de Operando.
     */
    public INumero accept(IVisitor visitor, Vetorial operando) {
        return operando;
    }
}
