package bravo;

/**
 * The test class BaseDecimalTest.
 *
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseDecimalTest extends junit.framework.TestCase {

    /**
     * Default constructor for test class BaseDecimalTest.
     */
    public BaseDecimalTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown() {
    }

    /**
     * Teste passando valores.
     */
    public void testPassandoValorUmRetornaStringUm() {
        bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
        assertEquals("1", baseDeci1.converterBase(1));
    }

    /**
     * Teste passando valores.
     */
    public void testPassandoValorOnzeRetornaStringOnze() {
        bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
        assertEquals("11", baseDeci1.converterBase(11));
    }

    /**
     * Teste passando valores.
     */
    public void testTestePassandoValorCentoeOnzeRetornaCentoeOnze() {
        bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
        assertEquals("111", baseDeci1.converterBase(111));
    }
}