package foxtrot;


/**
 * Write a description of class Vetor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vetor implements Operando {
    private Iterator primeiro;
    private Iterator ultimo;

    public Vetor() {
        primeiro = ultimo = new OperandoIterator();
    }

    public Vetor(Operando operando) {
        primeiro = ultimo = new OperandoIterator(operando);
    }
    
    public Operando getParteExponencial() {
        return ultimo.getOperando().getParteExponencial();
    }
    
    public Operando getParteImaginaria() {
        return ultimo.getOperando().getParteImaginaria();
    }
    
    public Operando getParteReal() {
        return ultimo.getOperando().getParteReal();
    }
    
    public void setValor(int i) {
    }
    
    public int getValor() {
        return 0;
    }
    
    public void soma(Operando operando) {
        primeiro.soma(operando.getIterator());
    }

    public String mostra(Base base) {
        return primeiro.mostra(base);
    }
    
    public void adicionaParteExponencial(Operando operando) {
        ultimo.getOperando().adicionaParteExponencial(operando);
    }
    
    public void adicionaParteImaginaria(Operando operando) {
        ultimo.getOperando().adicionaParteImaginaria(operando);
    }
    
    public void adicionaParteReal(Operando operando) {
        ultimo.getOperando().adicionaParteReal(operando);
    }
    
    /**
     * 
     */
    public Operando entraV() {
        ultimo.setNext(new OperandoIterator(new Complexo()));
        ultimo = ultimo.next();
        return this;
    }

    public Iterator getIterator() {
        return primeiro;
    }
}
