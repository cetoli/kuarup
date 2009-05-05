package bravo;


/**
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 */
public class Nulo implements Numero
{
    public void adicionaParteReal(Numero operando) {
        throw new RuntimeException("N�o pode adicionar parte real a operando nulo.");
    }

    /**
     * M�todo herdado de Operando.
     */
    public void adicionaParteImaginaria(Numero operando) {
        throw new RuntimeException("N�o pode adicionar parte imagin�ria a operando nulo.");
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void adicionaParteExponencial(Numero operando) {
        throw new RuntimeException("N�o pode adicionar parte exponencial a operando nulo.");
    }

    /**
     * M�todo herdado de Operando.
     */
    public String mostra(StrategyBase base) {
        return "";
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void soma(Numero operando) {
    }

    /**
     * M�todo herdado de Operando.
     */
    public int getValor() {
        return 0;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public void setValor(int valor) {
    }

    /**
     * M�todo herdado de Operando.
     */
    public Numero getParteReal() {
        return this;
    }

    /**
     * M�todo herdado de Operando.
     */
    public Numero getParteImaginaria() {
        return this;
    }
    
    /**
     * M�todo herdado de Operando.
     */
    public Numero getParteExponencial() {
        return this;
    }
}