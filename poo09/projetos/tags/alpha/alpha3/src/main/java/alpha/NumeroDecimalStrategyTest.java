package alpha;

/**
 * The test class NumeroDecimalTest.
 *
 * @author  Diego Mury G. de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroDecimalStrategyTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class NumeroDecimalStrategyTest.
     */
    public NumeroDecimalStrategyTest() {
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
     * Testa a entrada do numero 1 em Decimal a partir do repouso.
     */
    public void testConverteUmEmNumeroDecimalAPartirDoRepouso() {
        alpha.NumeroDecimalStrategy numDec = new alpha.NumeroDecimalStrategy();
        numDec.entraUm();
        assertEquals(new Integer(1), numDec.converteEmNumeroDecimal());
    }
    /**
     * Testa a entrada do numero 11 em Decimal a partir do repouso.
     */
    public void testConverteUmUmEmNumeroDecimalAPartirDoRepouso() {
        alpha.NumeroDecimalStrategy numDec = new alpha.NumeroDecimalStrategy();
        numDec.entraUm();
        numDec.entraUm();
        assertEquals(new Integer(11), numDec.converteEmNumeroDecimal());
    }
}
