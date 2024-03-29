package delta;

/**
 * The test class BinariaStrategyTest.
 * @author  Andre Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 Andre Sion e Thiago Silva de Souza
 */
public class BinariaStrategyTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste BinariaTeste.
     */
    public BinariaStrategyTest() {
    }

    /**
     * Preparacao do caso de teste.
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     * Chamado apos cada metodo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Limpeza do caso de teste.
     * Chamado apos cada metodo de teste de caso.
     */
    public final void testConverte2() {
        delta.BinariaStrategy binariaS1 = new delta.BinariaStrategy();
        assertEquals("0b10", binariaS1.toString(2));
    }
}
