/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
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
     * Método construtor.
     */
    public Complexo(Operando operando) {
        this.real = operando;
        this.imaginario = new Simples(0);
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
        return this.real.mostra()+"I"+this.imaginario.mostra();
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando soma(Operando operando) {
        return operando.accept(new SomaVisitor(operando), this);
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando sub(Operando operando) {
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
    public void setParteReal(Operando operando) {
        this.real = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteImaginaria(Operando operando) {
        this.imaginario = operando;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteMantissa(Operando operando) {
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setParteExponencial(Operando operando) {
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
    public Operando getParteReal(){
        return this.real;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this.imaginario;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteMantissa() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando getParteExponencial() {
        return null;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando toComplexo() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando toExponencial() {
        this.imaginario = new Exponencial(this.imaginario);
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando toVetorial() {
        return new Vetorial(this);
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Simples operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return visitor.visitComplexo(operando);
    }
    
    /**
     * Método herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return visitor.visitComplexo(operando);
    }
}
