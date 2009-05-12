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

    String getPrefixo();

    Visitor somaComEscalar(Visitor visitor);
    
    Visitor somaComEscalarDeVerdade(Visitor visitor);

    Visitor soma(Visitor visitor);
    
    Visitor subtraiDeEscalar(Visitor visitor);
    
    Visitor subtraiDeEscalarDeVerdade(Visitor visitor);

    Visitor subtrai(Visitor visitor);
    
    Operando entraV(Vetor vetor);
    
    Visitor descobreUltimo(Visitor visitor);
}
