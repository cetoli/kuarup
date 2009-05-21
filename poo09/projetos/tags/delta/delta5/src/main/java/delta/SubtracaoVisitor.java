/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Classe do Visitor da operação subtração do operando.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class SubtracaoVisitor implements IOperacaoVisitor {
    
    private OperadorComposite operando;

    /**
     * Método construtor.
     */
    public SubtracaoVisitor(OperadorComposite operando) {
        this.operando = operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitSimples(NumReal operando) {
        OperadorComposite visitante = new NumReal(0);
        visitante.setValor(operando.getValor()-this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitComplexo(NumReal operando) {
        OperadorComposite visitante = new NumComplexo(new NumReal(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitExponencial(NumReal operando) {
        int valor = operando.getValor()/((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        OperadorComposite visitante = new NumEngenharia(new NumReal(0));
        visitante.getParteMantissa().setValor(valor-this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitVetorial(NumReal operando) {
        OperadorComposite elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitSimples(NumExpoente operando) {
        OperadorComposite visitante = new NumExpoente(0);
        visitante.setValor(operando.getValor()-this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitComplexo(NumExpoente operando) {
        OperadorComposite visitante = new NumComplexo(new NumReal(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitExponencial(NumExpoente operando) {
        int valor = operando.getValor()/((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        OperadorComposite visitante = new NumEngenharia(new NumReal(0));
        visitante.getParteMantissa().setValor(valor-this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitVetorial(NumExpoente operando) {
        OperadorComposite elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitSimples(NumComplexo operando) {
        OperadorComposite visitante = new NumComplexo(new NumReal(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitComplexo(NumComplexo operando) {
        OperadorComposite visitante = new NumComplexo(new NumReal(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(operando.getParteImaginaria().sub(this.operando.getParteImaginaria()));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitExponencial(NumComplexo operando) {
        OperadorComposite visitante = new NumComplexo(new NumReal(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitVetorial(NumComplexo operando) {
        OperadorComposite elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitSimples(NumEngenharia operando) {
        int valorOutro = this.operando.getValor()/((int)Math.pow(10, operando.getParteExponencial().getValor()));
        OperadorComposite visitante = new NumEngenharia(new NumReal(0));
        visitante.getParteMantissa().setValor(operando.getParteMantissa().getValor()-valorOutro);
        visitante.setParteExponencial(operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitComplexo(NumEngenharia operando) {
        OperadorComposite visitante = new NumComplexo(new NumReal(0));
        visitante.setParteReal(operando.sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitExponencial(NumEngenharia operando) {
        int maxExp = Math.max(operando.getParteExponencial().getValor(), this.operando.getParteExponencial().getValor());
        int valor = operando.getParteMantissa().getValor()/((int)Math.pow(10, maxExp-operando.getParteExponencial().getValor()));
        int valorOutro = this.operando.getParteMantissa().getValor()/((int)Math.pow(10, maxExp-this.operando.getParteExponencial().getValor()));
        OperadorComposite visitante = new NumEngenharia(new NumReal(0));
        visitante.getParteMantissa().setValor(valor-valorOutro);
        visitante.setParteExponencial(new NumExpoente(maxExp));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitVetorial(NumEngenharia operando) {
        OperadorComposite elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitSimples(NumVetorial operando) {
        OperadorComposite elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(elemento.sub(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitComplexo(NumVetorial operando) {
        OperadorComposite elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(elemento.sub(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitExponencial(NumVetorial operando) {
        OperadorComposite elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (OperadorComposite)it.next();
            lista.add(elemento.sub(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    
    /**
     * Método herdado de IOperacaoVisitor.
     */
    public OperadorComposite visitVetorial(NumVetorial operando) {
        return null;
    }
}
