package foxtrot;


/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Andre de Abrantes
 * @version 5.0 12/05/2009 Carlos Eduardo e Andre de Abrantes
 * @since   4.0 Inclu�das as funcionalidades: numeros vetoriais e subtracao
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   3.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   2.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   1.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 */
public interface Visitor {

    Operando getOperando();

    String mostra(Base base);

    Visitor next();

    void setNext(Visitor visitor);

    String getPrefixo();

    Visitor somaComEscalar(Visitor visitor);
    
    Visitor somaEscalarComEscalar(Visitor visitor);

    Visitor soma(Visitor visitor);
    
    Visitor subtraiDeEscalar(Visitor visitor);
    
    Visitor subtraiEscalarDeEscalar(Visitor visitor);

    Visitor subtrai(Visitor visitor);
    
    Operando entraV(Vetor vetor);
    
    Visitor descobreUltimo(Visitor visitor);
}
