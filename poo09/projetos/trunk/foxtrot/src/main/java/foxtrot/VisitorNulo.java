package foxtrot;


/**
 * Write a description of class VisitorNulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VisitorNulo implements Visitor {

    public Operando getOperando() {
        return new Nulo();
    }

    public String getPrefixo() {
        return "";
    }

    public Visitor next() {
        return this;
    }

    public void setNext(Visitor visitor) {
    }

    public String mostra(Base base) {
        return "";
    }

    public Visitor somaComEscalar(Visitor visitor) {
        return new VisitorNulo();
    }
    
    public Visitor somaEscalarComEscalar(Visitor visitor) {
        return new VisitorNulo();
    }

    public Visitor soma(Visitor visitor) {
        return this;
    }
    
    public Visitor subtraiDeEscalar(Visitor visitor) {
        return new VisitorNulo();
    }
    
    public Visitor subtraiEscalarDeEscalar(Visitor visitor) {
        return new VisitorNulo();
    }
    
    public Visitor subtrai(Visitor visitor) {
        return this;
    }
    
    public Operando entraV(Vetor vetor) {
        return new Nulo();
    }
    
    public Visitor descobreUltimo(Visitor visitor) {
        return visitor;
    }
}
