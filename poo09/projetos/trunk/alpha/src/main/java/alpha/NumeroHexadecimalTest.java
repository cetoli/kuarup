package alpha;



/**
 * The test class NumeroHexadecimalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumeroHexadecimalTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class NumeroHexadecimalTest
     */
    public NumeroHexadecimalTest()
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
    
    public void testConverte1HexaEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroHexadecimal numHex = new alpha.NumeroHexadecimal();
        numHex.entraUm();
        assertEquals(new Integer(1), numHex.converteEmNumeroDecimal());
    }
    
    public void testConverte11EmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroHexadecimal numHex = new alpha.NumeroHexadecimal();
        numHex.entraUm();
        numHex.entraUm();
        assertEquals(new Integer(17), numHex.converteEmNumeroDecimal());
    }
    
    public void testMostraNumeroEmHexadecimalDepoisDeSomar()
    {
        alpha.NumeroHexadecimal numHex = new alpha.NumeroHexadecimal();
        numHex.entraUm();
        numHex.entraUm();
        assertEquals("11", numHex.mostraNumeroNaMinhaRepresentacaoBase());
    }
}
