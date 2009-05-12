package foxtrot;


/**
 * Write a description of class OperandoVisitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperandoVisitor implements Visitor {

    private Operando operando;
    private Visitor proximo;

    public OperandoVisitor(Operando operando) {
        this.operando = operando;
        this.proximo = new VisitorNulo();
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

    public Visitor next() {
        return proximo;
    }

    public void setNext(Visitor visitor) {
        proximo = visitor;
    }

    public Visitor somaComEscalar(Visitor visitor) {
        return soma(visitor);
    }
    
    public Visitor somaComEscalarDeVerdade(Visitor visitor) {
        return soma(visitor);
    }

    public Visitor soma(Visitor visitor) {
        operando.soma(visitor.getOperando());
        proximo = proximo.soma(visitor.next());
        return this;
    }
    
    public Visitor subtraiDeEscalar(Visitor visitor) {
        return subtrai(visitor);
    }
    
    public Visitor subtraiDeEscalarDeVerdade(Visitor visitor) {
        return subtrai(visitor);
    }
    
    public Visitor subtrai(Visitor visitor) {
        operando.subtrai(visitor.getOperando());
        proximo = proximo.subtrai(visitor.next());
        return this;
    }
    
    public Operando entraV(Vetor vetor) {
        proximo = new OperandoVisitor(new Complexo());
        vetor.setUltimo(proximo);
        return vetor;
    }
    
    public Visitor descobreUltimo(Visitor visitor) {
        return proximo.descobreUltimo(this);
    }
}
