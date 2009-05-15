/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Classe do Visitor da operação soma do operando.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class SomaVisitor implements OperacaoVisitor {
    
    private Operando operando;
    
    /**
     * Método construtor.
     */
    public SomaVisitor(Operando operando) {
        this.operando = operando;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitSimples(Simples operando) {
        Operando visitante = new Simples(0);
        visitante.setValor(operando.getValor()+this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitComplexo(Simples operando) {
        Operando visitante = new Complexo(new Simples(0));
        visitante.setParteReal(operando.soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitExponencial(Simples operando) {
        int valor = operando.getValor()/((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        Operando visitante = new Exponencial(new Simples(0));
        visitante.getParteMantissa().setValor(valor+this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitVetorial(Simples operando) {
        return this.operando.soma(operando);
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitSimples(Expoente operando) {
        Operando visitante = new Expoente(0);
        visitante.setValor(operando.getValor()+this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitComplexo(Expoente operando) {
        Operando visitante = new Complexo(new Simples(0));
        visitante.setParteReal(operando.soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitExponencial(Expoente operando) {
        int valor = operando.getValor()/((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        Operando visitante = new Exponencial(new Simples(0));
        visitante.getParteMantissa().setValor(valor+this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitVetorial(Expoente operando) {
        return this.operando.soma(operando);
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitSimples(Complexo operando) {
        Operando visitante = new Complexo(new Simples(0));
        visitante.setParteReal(operando.getParteReal().soma(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitComplexo(Complexo operando) {
        Operando visitante = new Complexo(new Simples(0));
        visitante.setParteReal(operando.getParteReal().soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(operando.getParteImaginaria().soma(this.operando.getParteImaginaria()));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitExponencial(Complexo operando) {
        Operando visitante = new Complexo(new Simples(0));
        visitante.setParteReal(operando.getParteReal().soma(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitVetorial(Complexo operando) {
        return this.operando.soma(operando);
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitSimples(Exponencial operando) {
        int valorOutro = this.operando.getValor()/((int)Math.pow(10, operando.getParteExponencial().getValor()));
        Operando visitante = new Exponencial(new Simples(0));
        visitante.getParteMantissa().setValor(operando.getParteMantissa().getValor()+valorOutro);
        visitante.setParteExponencial(operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitComplexo(Exponencial operando) {
        Operando visitante = new Complexo(new Simples(0));
        visitante.setParteReal(operando.soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitExponencial(Exponencial operando) {
        int maxExp = Math.max(operando.getParteExponencial().getValor(), this.operando.getParteExponencial().getValor());
        int valor = operando.getParteMantissa().getValor()/((int)Math.pow(10, maxExp-operando.getParteExponencial().getValor()));
        int valorOutro = this.operando.getParteMantissa().getValor()/((int)Math.pow(10, maxExp-this.operando.getParteExponencial().getValor()));
        Operando visitante = new Exponencial(new Simples(0));
        visitante.getParteMantissa().setValor(valor+valorOutro);
        visitante.setParteExponencial(new Expoente(maxExp));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitVetorial(Exponencial operando) {
        return this.operando.soma(operando);
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitSimples(Vetorial operando) {
        Operando elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (Operando)it.next();
            lista.add(elemento.soma(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitComplexo(Vetorial operando) {
        Operando elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (Operando)it.next();
            lista.add(elemento.soma(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitExponencial(Vetorial operando) {
        Operando elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (Operando)it.next();
            lista.add(elemento.soma(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    
    /**
     * Método herdado de OperacaoVisitor.
     */
    public Operando visitVetorial(Vetorial operando) {
        return null;
    }
}
