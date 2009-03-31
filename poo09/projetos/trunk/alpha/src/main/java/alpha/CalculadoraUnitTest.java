package alpha;



/**
 * The test class CalculadoraUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculadoraUnitTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CalculadoraUnitTest
     */
    
    public CalculadoraUnitTest()
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

    public void testLimpa()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        String zero = calculad1.limpa();
        assertEquals("Deveria retornar 0", "0", zero);
    }
    
    public void testSomaAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        assertEquals("Deveria retornar 0", "0", calculad1.comandoSoma());
    }
    
    public void testLimpaESoma()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.limpa();
        assertEquals("Deveria retornar 0", "0", calculad1.comandoSoma());
    }
    
    public void testEntraUmAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        assertEquals("1", calculad1.entraUm());
    }
    
    public void testSomaUmaAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        assertEquals("1", calculad1.comandoSoma());
    }

    public void testSomaUmComUm()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }
    
    public void testSomaOnzeAPartirDoRepouso()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("11", calculad1.comandoSoma());
    }
    
    public void testSomaUmComOnze()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }
    
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
    
    public void testOverflowNaEntrada()
    {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        try{
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
        catch(NumberFormatException e){
            assertTrue(true);
        }
    }
}



