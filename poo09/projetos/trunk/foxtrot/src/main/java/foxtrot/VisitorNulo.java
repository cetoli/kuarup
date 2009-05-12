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
