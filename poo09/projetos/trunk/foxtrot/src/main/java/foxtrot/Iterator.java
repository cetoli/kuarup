package foxtrot;


/**
 * Write a description of interface Iterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Iterator {

    Operando getOperando();

    String mostra(Base base);
    
    Iterator next();

    void setNext(Iterator iterator);

    String getPrefixo();
    
    void soma(Iterator iterator);
}
