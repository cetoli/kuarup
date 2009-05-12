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
