package alpha;



/**
 * The test class NumeroBinarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumeroBinarioTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class NumeroBinarioTest
     */
    public NumeroBinarioTest()
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
    
    
      public void testConverte1BinarioEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroBinario numBin = new alpha.NumeroBinario();
        numBin.entraUm();
        assertEquals(new Integer(1), numBin.converteEmNumeroDecimal());
    }
    
    public void testConverte11BinarioEmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroBinario numBin = new alpha.NumeroBinario();
        numBin.entraUm();
        numBin.entraUm();
        assertEquals(new Integer(3), numBin.converteEmNumeroDecimal());
    }
    
    public void testMostraNumeroEmBinarioAposEntradaApartirDoRepouso()
    {
        alpha.NumeroBinario numBin = new alpha.NumeroBinario();
        numBin.entraUm();
        numBin.entraUm();
        assertEquals("11", numBin.mostraNumeroNaMinhaRepresentacaoBase());
    }
}
