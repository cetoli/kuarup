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
    
    public Visitor somaComEscalar(Visitor visitor) {
        return visitor.somaEscalarComEscalar(this);
    }
    
    public Visitor somaEscalarComEscalar(Visitor visitor) {
        operando.soma(visitor.getOperando());
        return this;
    }

    public Visitor soma(Visitor visitor) {
        return visitor.somaComEscalar(this);
    }
    
    public Visitor subtraiDeEscalar(Visitor visitor) {
        return visitor.subtraiEscalarDeEscalar(this);
    }
    
    public Visitor subtraiEscalarDeEscalar(Visitor visitor) {
        operando.subtrai(visitor.getOperando());
        return this;
    }
    
    public Visitor subtrai(Visitor visitor) {
        return visitor.subtraiDeEscalar(this);
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
