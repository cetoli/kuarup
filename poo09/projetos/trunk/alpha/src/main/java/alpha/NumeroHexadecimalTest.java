package alpha;

/**
 * The test class NumeroHexadecimalTest.
 *
 * @author  Diego Mury G. de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroHexadecimalTest extends junit.framework.TestCase
{
    /**
     * Construtor da classe NumeroHexadecimalTest.
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
    
    /**
     * Testa a entrada do numero 1 em hexadecimal a partir do repouso.
     */
    public void testConverteUmHexaEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroHexadecimal numHex = new alpha.NumeroHexadecimal();
        numHex.entraUm();
        assertEquals(new Integer(1), numHex.converteEmNumeroDecimal());
    }
    
    /**
     * Testa a entrada do numero 11 em hexadecimal a partir do repouso.
     */
    public void testConverteUmUmHexaEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroHexadecimal numHex = new alpha.NumeroHexadecimal();
        numHex.entraUm();
        numHex.entraUm();
        assertEquals(new Integer(17), numHex.converteEmNumeroDecimal());
    }
    
    /**
     * Testa a exibicao do numero 11 em hexadecimal.
     */
    public void testMostraNumeroEmHexadecimalDepoisDeSomar()
    {
        alpha.NumeroHexadecimal numHex = new alpha.NumeroHexadecimal();
        numHex.entraUm();
        numHex.entraUm();
        assertEquals("11", numHex.mostraNumeroNaMinhaRepresentacaoBase());
    }
}
