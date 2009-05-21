package alpha;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Classe do Visitor da operação soma do operando.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 1.0
 */
public class SomaVisitor implements IVisitor {
    private INumero operando;
    /**
     * Método construtor.
     */
    public SomaVisitor(INumero operando) {
        this.operando = operando;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitReal(Real operando) {
        INumero visitante = new Real(0);
        visitante.setValor(operando.getValor() + this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Real operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Real operando) {
        int valor = operando.getValor() / ((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(valor + this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Real operando) {
        return this.operando.soma(operando);
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitReal(Expoente operando) {
        INumero visitante = new Expoente(0);
        visitante.setValor(operando.getValor() + this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Expoente operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Expoente operando) {
        int valor = operando.getValor() / ((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(valor + this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Expoente operando) {
        return this.operando.soma(operando);
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitReal(Complexo operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().soma(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
   /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Complexo operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(operando.getParteImaginaria().soma(this.operando.getParteImaginaria()));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Complexo operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().soma(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Complexo operando) {
        return this.operando.soma(operando);
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitReal(Exponencial operando) {
        int valorOutro = this.operando.getValor() / ((int)Math.pow(10, operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(operando.getParteMantissa().getValor() + valorOutro);
        visitante.setParteExponencial(operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Exponencial operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.soma(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Exponencial operando) {
        int maxExp = Math.max(operando.getParteExponencial().getValor(), this.operando.getParteExponencial().getValor());
        int valor = operando.getParteMantissa().getValor() / ((int)Math.pow(10, maxExp - operando.getParteExponencial().getValor()));
        int valorOutro = this.operando.getParteMantissa().getValor() / ((int)Math.pow(10, maxExp - this.operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(valor + valorOutro);
        visitante.setParteExponencial(new Expoente(maxExp));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Exponencial operando) {
        return this.operando.soma(operando);
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitReal(Vetorial operando) {
        INumero elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(elemento.soma(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Vetorial operando) {
        INumero elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(elemento.soma(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Vetorial operando) {
        INumero elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(elemento.soma(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    /**
     * Método herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Vetorial operando) {
        return null;
    }
}
