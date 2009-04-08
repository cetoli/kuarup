package alpha;



/**
 * The test class CalculadoraUnitTest.
 *
 * @author Diego Mury Gomes de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public class CalculadoraTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CalculadoraUnitTest.
     */
    
    public CalculadoraTest() {
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
     * Testa o metodo limpa .
     *
     */
    public void testLimpa()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        String zero = calculad1.limpa();
        assertEquals("Deveria retornar 0", "0", zero);
    }
    
    /**
     * Testa a soma a partir do repouso.
     *
     */
    public void testSomaAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        assertEquals("Deveria retornar 0", "0", calculad1.comandoSoma());
    }
    
    /**
     * Testa limpa e soma a partir do repouso.
     *
     */
    public void testLimpaESoma()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.limpa();
        assertEquals("Deveria retornar 0", "0", calculad1.comandoSoma());
    }
    
    /**
     * Testa a entrada de um numero a partir do repouso.
     *
     */
    public void testEntraUmAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        assertEquals("1", calculad1.entraUm());
    }
    
    /**
     * Testa a entra um e soma a partir do repouso.
     *
     */
    public void testSomaUmAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        assertEquals("1", calculad1.comandoSoma());
    }

    /**
     * Testa a soma de um com um.
     *
     */
    public void testSomaUmComUm()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }
    
    /**
     * Testa a entra onze e soma a partir do repouso.
     *
     */
    public void testSomaOnzeAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("11", calculad1.comandoSoma());
    }
    
    
    /**
     * Testa a soma de um com Onze.
     *
     */
    public void testSomaUmComOnze()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }
    
    /**
     * Testa a soma de onze com cento e onze.
     *
     */
    public void testSomaOnzeComCentoEOnze()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("122", calculad1.comandoSoma());
    }
    
    /**
     * Testa o overflow na entrada.
     *
     */
    public void testOverflowNaEntrada()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        try {
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            fail();
        }
        catch (NumberFormatException e) {
            assertTrue(true);
        }
    }
    
    /**
     * Testa a soma de um binario com um binario.
     *
     */
    public void testSomaUmBinarioComUmBinario() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("10", calculad1.comandoSoma());
    }
    
    /**
     * Testa a soma de um hexadecimal com um hexadecimal.
     *
     */
    public void testSomaUmHexaComUmHexa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }
    
    /**
     * Testa a soma de onze hexadecimal com um hexadecimal.
     *
     */
    public void testSomaUmUmHexaComUmHexa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }
    
    /**
     * Testa a soma de um binario com um hexadecimal.
     *
     */
    public void testSomaUmBinarioComUmHexa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoHex();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }
    
    /**
     * Testa a soma de um hexadecimal com um binario.
     *
     */
    public void testSomaUmHexaComUmUmBin() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("100", calculad1.comandoSoma());
    }
    
    /**
     * Testa a soma de Onze hexadecimal com um binario.
     *
     */
    public void testSomaUmUmHexaComUmBin() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoBin();
        calculad1.entraUm();
        assertEquals("10010", calculad1.comandoSoma());
    }
}