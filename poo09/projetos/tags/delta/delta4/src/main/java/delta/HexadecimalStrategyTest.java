package delta;

/**
 * The test class HexadecimalStrategyTest.
 * @author  Andre Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 Andre Sion e Thiago Silva de Souza
 */
public class HexadecimalStrategyTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste HexadecimalTeste.
     */
    public HexadecimalStrategyTest() {
    }

    /**
     * Preparacao do caso de teste.
     * Chamado antes de cada metodo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     * Chamado apos cada metodo de teste de caso.
     */
    protected void tearDown() {
    }

    public final void testConverte16() {
        final int dezesseis = 16;
        delta.HexadecimalStrategy hexadeci1 = new delta.HexadecimalStrategy();
        assertEquals("0x10", hexadeci1.toString(dezesseis));
    }
}
