/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Classe do operando vetorial.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class Vetorial implements Operando {
    
    private LinkedList vetor;

    /**
     * M�todo construtor.
     */
    public Vetorial(Operando operando) {
        vetor = new LinkedList();
        vetor.addLast(operando);
        Operando aux = new Simples(0);
        aux.setBase(operando.getBase());
        vetor.addLast(aux);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        ((Operando) vetor.getLast()).entraUm();
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        Operando operando;
        Iterator it = vetor.iterator();
        operando = (Operando)it.next();
        String str = operando.mostra();
        while (it.hasNext()) {
            operando = (Operando)it.next();
            str += "V" + operando.mostra();
        }
        return str;
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
        Operando operando;
        Iterator it = vetor.iterator();
        operando = (Operando)it.next();
        operando.setBase(base);
        while (it.hasNext()) {
            operando = (Operando)it.next();
            operando.setBase(base);
        }
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
        this.vetor = vetor;
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
        return ((Operando) vetor.getLast()).getBase();
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
        return this.vetor;
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
        Operando operando = (Operando)vetor.removeLast();
        operando = operando.toComplexo();
        vetor.addLast(operando);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toExponencial() {
        Operando operando = (Operando)vetor.removeLast();
        operando = operando.toExponencial();
        vetor.addLast(operando);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando toVetorial() {
        Operando operando = new Simples(0);
        vetor.addLast(operando);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Simples operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando) {
        return visitor.visitVetorial(operando);
    }
}
