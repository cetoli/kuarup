/*------------------------------------------------------------------------------
    Copyright � 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;
import java.util.LinkedList;

/**
 * Classe do operando exponencial/com nota��o cient�fica.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class Exponencial implements Operando {
    
    private Operando mantissa;
    private Operando expoente;
    
    /**
     * M�todo construtor.
     */
    public Exponencial(Operando operando) {
        this.mantissa = operando;
        this.expoente = new Expoente(0);
        this.expoente.setBase(this.mantissa.getBase());
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        this.expoente.entraUm();
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        return this.mantissa.mostra()+"N"+this.expoente.mostra();
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
        this.mantissa.setBase(base);
        this.expoente.setBase(base);
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
    public void setParteReal(Operando operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(Operando operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteMantissa(Operando operando) {
        this.mantissa = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteExponencial(Operando operando) {
        this.expoente = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public BaseStrategy getBase() {
        return this.expoente.getBase();
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
    public Operando getParteReal() {
        return null;
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
        return this.mantissa;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteExponencial() {
        return this.expoente;
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
        return this;
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
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return visitor.visitExponencial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return visitor.visitExponencial(operando);
    }
}
