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

    public Visitor getVisitorParaVetor() {
        return this;
    }

    public String mostra(Base base) {
        return "";
    }

    public void somaComEscalar(Visitor visitor) {
    }

    public Visitor soma(Visitor visitor) {
        return visitor.getVisitorParaVetor();
    }
    
    public Operando entraV(Vetor vetor) {
        return new Nulo();
    }
    
    public Visitor descobreUltimo(Visitor visitor) {
        return visitor;
    }
}
