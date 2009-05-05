package bravo;

/**
 * The test class BaseDecimalTest.
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseDecimalTest extends junit.framework.TestCase {
   /**
    * Constante para representar o numero 1.
    */
    private static final int NUMERO_1 = 1;
   /**
    * Constante para representar o numero 11.
    */
    private static final int NUMERO_11 = 11;
   /**
    * Constante para representar o numero 111.
    */
    private static final int NUMERO_111 = 111;
    /**
     * Default constructor for test class BaseDecimalTest.
     */
    public BaseDecimalTest() {
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
     * Teste passando valores.
     */
    public void testPassandoValorUmRetornaStringUm() {
        bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
        assertEquals("1", baseDeci1.converterBase(new Numero(NUMERO_1)));
    }

    /**
     * Teste passando valores.
     */
    public void testPassandoValorOnzeRetornaStringOnze() {
        bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
        assertEquals("11", baseDeci1.converterBase(new Numero(NUMERO_11)));
    }

    /**
     * Teste passando valores.
     */
    public void testTestePassandoValorCentoeOnzeRetornaCentoeOnze() {
        bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
        assertEquals("111", baseDeci1.converterBase(new Numero(NUMERO_111)));
    }
}