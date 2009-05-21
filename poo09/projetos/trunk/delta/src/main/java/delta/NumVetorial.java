/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Classe do operando vetorial.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumVetorial implements OperadorComposite {
    
    private LinkedList vetor;

    /**
     * M�todo construtor.
     */
    public NumVetorial(OperadorComposite operando) {
        vetor = new LinkedList();
        vetor.addLast(operando);
        OperadorComposite aux = new NumReal(0);
        aux.setBase(operando.getBase());
        vetor.addLast(aux);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String entraUm() {
        ((OperadorComposite) vetor.getLast()).entraUm();
        return mostra();
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public String mostra() {
        OperadorComposite operando;
        Iterator it = vetor.iterator();
        operando = (OperadorComposite)it.next();
        String str = operando.mostra();
        while (it.hasNext()) {
            operando = (OperadorComposite)it.next();
            str += "V" + operando.mostra();
        }
        return str;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite soma(OperadorComposite operando) {
        return operando.accept(new SomaVisitor(operando), this);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite sub(OperadorComposite operando) {
        return operando.accept(new SubtracaoVisitor(operando), this);
    }
    
    
    /**
     * M�todo herdado de Operando.
     */
    public void setBase(BaseStrategy base) {
        OperadorComposite operando;
        Iterator it = vetor.iterator();
        operando = (OperadorComposite)it.next();
        operando.setBase(base);
        while (it.hasNext()) {
            operando = (OperadorComposite)it.next();
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
    public void setParteReal(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteImaginaria(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteMantissa(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setParteExponencial(OperadorComposite operando) {
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public BaseStrategy getBase() {
        return ((OperadorComposite) vetor.getLast()).getBase();
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
    public OperadorComposite getParteReal() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteImaginaria() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteMantissa() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite getParteExponencial() {
        return null;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toComplexo() {
        OperadorComposite operando = (OperadorComposite)vetor.removeLast();
        operando = operando.toComplexo();
        vetor.addLast(operando);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toExponencial() {
        OperadorComposite operando = (OperadorComposite)vetor.removeLast();
        operando = operando.toExponencial();
        vetor.addLast(operando);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite toVetorial() {
        OperadorComposite operando = new NumReal(0);
        vetor.addLast(operando);
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando) {
        return visitor.visitVetorial(operando);
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando) {
        return visitor.visitVetorial(operando);
    }
}
