package foxtrot;


/**
 * Write a description of class OperandoIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperandoIterator implements Iterator {

    private Operando operando;
    private Iterator proximo;

    public OperandoIterator() {
        operando = new Nulo();
        proximo = this;
    }

    public OperandoIterator(Operando op) {
        operando = op;
        proximo = new IteratorNulo();
    }

    public String getPrefixo() {
        return "V";
    }

    public Operando getOperando() {
        return operando;
    }

    public String mostra(Base base) {
        return operando.mostra(base) + proximo.getPrefixo() + proximo.mostra(base);
    }

    public Iterator next() {
        return proximo;
    }

    public void setNext(Iterator iterator) {
        proximo = iterator;
    }

    public void soma(Iterator iterator) {
        operando.soma(iterator.getOperando());
        proximo.soma(iterator.next());
    }
}
