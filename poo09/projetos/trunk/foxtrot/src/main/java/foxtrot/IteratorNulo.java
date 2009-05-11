package foxtrot;


/**
 * Write a description of class IteratorNulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IteratorNulo implements Iterator {

    public Operando getOperando() {
        return new Nulo();
    }

    public String getPrefixo() {
        return "";
    }

    public Iterator next() {
        return this;
    }

    public void setNext(Iterator iterator) {
    }

    public String mostra(Base base) {
        return "";
    }
    
    public void soma(Iterator iterator) {
    }
}
