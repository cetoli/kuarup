package foxtrot;


/**
 * Write a description of interface Visitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Visitor {

    Operando getOperando();

    String mostra(Base base);

    Visitor next();

    void setNext(Visitor visitor);

    Visitor getVisitorParaVetor();

    String getPrefixo();

    void somaComEscalar(Visitor visitor);

    Visitor soma(Visitor visitor);
    
    Operando entraV(Vetor vetor);
    
    Visitor descobreUltimo(Visitor visitor);
}
