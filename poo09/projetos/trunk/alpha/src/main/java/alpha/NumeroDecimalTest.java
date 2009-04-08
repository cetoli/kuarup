package alpha;

/**
 * The test class NumeroDecimalTest.
 *
 * @author  Diego Mury G. de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroDecimalTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class NumeroDecimalTest.
     */
    public NumeroDecimalTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    /**
     * Testa a entrada do numero 1 em Decimal a partir do repouso.
     */
    public void testConverteUmEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroDecimal numDec = new alpha.NumeroDecimal();
        numDec.entraUm();
        assertEquals(new Integer(1), numDec.converteEmNumeroDecimal());
    }
    
    /**
     * Testa a entrada do numero 11 em Decimal a partir do repouso.
     */
    public void testConverteUmUmEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroDecimal numDec = new alpha.NumeroDecimal();
        numDec.entraUm();
        numDec.entraUm();
        assertEquals(new Integer(11), numDec.converteEmNumeroDecimal());
    }
}

