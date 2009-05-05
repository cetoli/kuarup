package bravo;


/**
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class Nulo implements Numero
{
    public void adicionaParteReal(Numero operando) {
        throw new RuntimeException("Não pode adicionar parte real a operando nulo.");
    }

    /**
     * Método herdado de Operando.
     */
    public void adicionaParteImaginaria(Numero operando) {
        throw new RuntimeException("Não pode adicionar parte imaginária a operando nulo.");
    }
    
    /**
     * Método herdado de Operando.
     */
    public void adicionaParteExponencial(Numero operando) {
        throw new RuntimeException("Não pode adicionar parte exponencial a operando nulo.");
    }

    /**
     * Método herdado de Operando.
     */
    public String mostra(StrategyBase base) {
        return "";
    }
    
    /**
     * Método herdado de Operando.
     */
    public void soma(Numero operando) {
    }

    /**
     * Método herdado de Operando.
     */
    public int getValor() {
        return 0;
    }
    
    /**
     * Método herdado de Operando.
     */
    public void setValor(int valor) {
    }

    /**
     * Método herdado de Operando.
     */
    public Numero getParteReal() {
        return this;
    }

    /**
     * Método herdado de Operando.
     */
    public Numero getParteImaginaria() {
        return this;
    }
    
    /**
     * Método herdado de Operando.
     */
    public Numero getParteExponencial() {
        return this;
    }
}