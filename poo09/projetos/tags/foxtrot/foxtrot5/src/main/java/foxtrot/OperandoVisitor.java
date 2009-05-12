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
    
    public Visitor somaEscalarComEscalar(Visitor visitor) {
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
    
    public Visitor subtraiEscalarDeEscalar(Visitor visitor) {
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
