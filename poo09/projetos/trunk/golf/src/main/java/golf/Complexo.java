/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;
import java.util.LinkedList;

/**
 * Classe do operando complexo.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class Complexo implements Operando {
    
    private Operando real;
    private Operando imaginario;
    
    /**
     * M�todo construtor.
     */
    public Complexo(Operando operando) {
        this.real = operando;
        this.imaginario = new Simples(0);
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
        return this.real.mostra()+"I"+this.imaginario.mostra();
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
    public void setParteReal(Operando operando) {
        this.real = operando;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(Operando operando) {
        this.imaginario = operando;
    }
    
    /**
     * M�todo herdado de Operando.
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
    public Operando getParteReal(){
        return this.real;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this.imaginario;
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
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toExponencial() {
        this.imaginario = new Exponencial(this.imaginario);
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
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return visitor.visitComplexo(operando);
    }
}
