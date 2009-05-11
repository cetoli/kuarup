package foxtrot;


/**
 * Write a description of class OperandoVisitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperandoEscalarVisitor implements Visitor {

    private Operando operando;

    public OperandoEscalarVisitor(Operando operando) {
        this.operando = operando;
    }

    public String getPrefixo() {
        return "";
    }

    public Operando getOperando() {
        return operando;
    }

    public String mostra(Base base) {
        return operando.mostra(base);
    }

    public Visitor next() {
        return this;
    }

    public void setNext(Visitor visitor) {
    }

    public Visitor getVisitorParaVetor() {
        return new VisitorNulo();
    }
    
    public void somaComEscalar(Visitor visitor) {
        operando.soma(visitor.getOperando());
    }

    public Visitor soma(Visitor visitor) {
        visitor.somaComEscalar(this);
        return visitor;
    }
    
    public Operando entraV(Vetor v) {
        Vetor vetor = new Vetor();
        vetor.setPrimeiro(new OperandoVisitor(operando));
        vetor.entraV();
        return vetor;
    }
    
    public Visitor descobreUltimo(Visitor visitor) {
        return this;
    }
}
