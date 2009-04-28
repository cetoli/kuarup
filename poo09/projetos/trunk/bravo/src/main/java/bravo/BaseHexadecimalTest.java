package bravo;

/**
 * The test class BaseHexadecimalTest.
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseHexadecimalTest extends junit.framework.TestCase {
   /**
    * Constante para representar o numero 1.
    */
    private static final int NUMERO_1 = 1;
   /**
    * Constante para representar o numero 11.
    */
    private static final int NUMERO_11 = 11;
   /**
    * Constante para representar o numero 12.
    */
    private static final int NUMERO_12 = 12;
    /**
     * Default constructor for test class BaseHexadecimalTest.
     */
    public BaseHexadecimalTest() {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown() {
    }

    /**
     * Metodo de teste passando valores.
     */
    public void testePassandoUmRotornaStringUm() {
        bravo.BaseHexadecimal baseHexa1 = new bravo.BaseHexadecimal();
        assertEquals("0x1", baseHexa1.converterBase(new Numero(NUMERO_1)));
    }

    /**
     * Metodo de teste passando valores.
     */
    public void testPassandoOnzeRetornaStringB() {
        bravo.BaseHexadecimal baseHexa1 = new bravo.BaseHexadecimal();
        assertEquals("0xb", baseHexa1.converterBase(new Numero(NUMERO_11)));
    }

    /**
     * Metodo de teste passando valores.
     */
    public void testEntraDozeRetornaC() {
        bravo.BaseHexadecimal baseHexa1 = new bravo.BaseHexadecimal();
        assertEquals("0xc", baseHexa1.converterBase(new Numero(NUMERO_12)));
    }
}