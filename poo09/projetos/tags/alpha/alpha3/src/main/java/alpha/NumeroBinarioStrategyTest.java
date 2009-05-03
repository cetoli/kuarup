package alpha;

/**
 * The test class NumeroDecimalTest.
 *
 * @author  Diego Mury G. de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class NumeroBinarioStrategyTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class NumeroBinarioStrategyTest.
     */
    public NumeroBinarioStrategyTest() {
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
     * Testa a entrada do numero 1 em binario a partir do repouso.
     */
    public void testConverteUmBinarioEmNumeroDecimalAPartirDoRepouso() {
        alpha.NumeroBinarioStrategy numBin = new alpha.NumeroBinarioStrategy();
        numBin.entraUm();
        assertEquals(new Integer(1), numBin.converteEmNumeroDecimal());
    }
    /**
     * Testa a entrada do numero 11 em binario a partir do repouso.
     */
    public void testConverteUmUmBinarioEmNumeroDecimalAPartirDoRepouso() {
        alpha.NumeroBinarioStrategy numBin = new alpha.NumeroBinarioStrategy();
        numBin.entraUm();
        numBin.entraUm();
        assertEquals(new Integer(3), numBin.converteEmNumeroDecimal());
    }
     /**
     * Testa a exibicao do numero 11 em binario.
     */
    public void testMostraNumeroUmUmEmBinarioAposEntradaApartirDoRepouso() {
        alpha.NumeroBinarioStrategy numBin = new alpha.NumeroBinarioStrategy();
        numBin.entraUm();
        numBin.entraUm();
        assertEquals("11", numBin.mostraNumeroNaMinhaRepresentacaoBase());
    }
}
