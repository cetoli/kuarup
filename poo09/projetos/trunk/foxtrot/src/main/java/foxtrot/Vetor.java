package foxtrot;


/**
 * Write a description of class Vetor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vetor implements Operando {
    private Visitor primeiro;
    private Visitor ultimo;

    public Vetor() {
        primeiro = ultimo = new OperandoVisitor(new Complexo());
    }

    public Vetor(Operando operando) {
        primeiro = ultimo = new OperandoEscalarVisitor(operando);
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
    
    public void setPrimeiro(Visitor visitor) {
        primeiro = ultimo = visitor;
    }

    public void setUltimo(Visitor visitor) {
        ultimo = visitor;
    }
    
    public int getValor() {
        return 0;
    }
    
    public void soma(Operando operando) {
        primeiro = primeiro.soma(operando.getVisitor());
        ultimo = primeiro.descobreUltimo(primeiro);
    }
    
    public void subtrai(Operando operando) {
        primeiro = primeiro.subtrai(operando.getVisitor());
        ultimo = primeiro.descobreUltimo(primeiro);
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
        return ultimo.entraV(this);
    }

    public Visitor getVisitor() {
        return primeiro;
    }
}
