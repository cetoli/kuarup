package alpha;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Classe do Visitor da opera��o subtracao do operando.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 1.0
 */
public class SubtracaoVisitor implements IVisitor {
    private INumero operando;
    /**
     * M�todo construtor.
     */
    public SubtracaoVisitor(INumero operando) {
        this.operando = operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitReal(Real operando) {
        INumero visitante = new Real(0);
        visitante.setValor(operando.getValor() - this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Real operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Real operando) {
        int valor = operando.getValor() / ((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(valor - this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Real operando) {
        INumero elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitReal(Expoente operando) {
        INumero visitante = new Expoente(0);
        visitante.setValor(operando.getValor() - this.operando.getValor());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Expoente operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Expoente operando) {
        int valor = operando.getValor() / ((int)Math.pow(10, this.operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(valor - this.operando.getParteMantissa().getValor());
        visitante.setParteExponencial(this.operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Expoente operando) {
        INumero elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitReal(Complexo operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Complexo operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(operando.getParteImaginaria().sub(this.operando.getParteImaginaria()));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Complexo operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.getParteReal().sub(this.operando));
        visitante.setParteImaginaria(operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Complexo operando) {
        INumero elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitReal(Exponencial operando) {
        int valorOutro = this.operando.getValor() / ((int)Math.pow(10, operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(operando.getParteMantissa().getValor() - valorOutro);
        visitante.setParteExponencial(operando.getParteExponencial());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Exponencial operando) {
        INumero visitante = new Complexo(new Real(0));
        visitante.setParteReal(operando.sub(this.operando.getParteReal()));
        visitante.setParteImaginaria(this.operando.getParteImaginaria());
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Exponencial operando) {
        int maxExp = Math.max(operando.getParteExponencial().getValor(), this.operando.getParteExponencial().getValor());
        int valor = operando.getParteMantissa().getValor() / ((int)Math.pow(10, maxExp - operando.getParteExponencial().getValor()));
        int valorOutro = this.operando.getParteMantissa().getValor() / ((int)Math.pow(10, maxExp - this.operando.getParteExponencial().getValor()));
        INumero visitante = new Exponencial(new Real(0));
        visitante.getParteMantissa().setValor(valor - valorOutro);
        visitante.setParteExponencial(new Expoente(maxExp));
        visitante.setBase(this.operando.getBase());
        return visitante;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Exponencial operando) {
        INumero elemento;
        Iterator it = this.operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(operando.sub(elemento));
        }
        this.operando.setVetor(lista);
        return this.operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitReal(Vetorial operando) {
        INumero elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(elemento.sub(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitComplexo(Vetorial operando) {
        INumero elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(elemento.sub(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitExponencial(Vetorial operando) {
        INumero elemento;
        Iterator it = operando.getVetor().iterator();
        LinkedList lista = new LinkedList();
        while (it.hasNext()) {
            elemento = (INumero)it.next();
            lista.add(elemento.sub(this.operando));
        }
        operando.setVetor(lista);
        return operando;
    }
    /**
     * M�todo herdado de OperacaoVisitor.
     */
    public INumero visitVetorial(Vetorial operando) {
        return null;
    }
}
