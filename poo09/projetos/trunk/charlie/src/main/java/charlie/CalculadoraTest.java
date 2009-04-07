package charlie;


/**
 * The test class CalculadoraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculadoraTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CalculadoraTest
     */
    public CalculadoraTest()
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

    public void testSomaUmAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        assertEquals("1", calculad1.comandoSoma());
    }

    public void testEntraOnzeAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        assertEquals("11", calculad1.entraUm());
    }

    public void testLimpaAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        assertEquals("0", calculad1.limpa());
    }

    public void testLimpaAposInserirUmAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    public void testLimpaAposInserirOnzeAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    public void testLimpaAposInserirCentoEOnzeAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    public void testSomaUmMaisUmAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }

    public void testSomaUmMaisUmMaisUmAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("3", calculad1.comandoSoma());
    }

    public void testSomaUmMaisOnzeAPartirDoRepouso()
    {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }

    /*
       public void testUmMaisMaisAPartirDoRepouso()
       {
       charlie.Calculadora calculad1 = new charlie.Calculadora();
       calculad1.entraUm();
       calculad1.comandoSoma();
       assertEquals("2", calculad1.comandoSoma());
       }

       public void testOnzeMaisMaisAPartirDoRepouso()
       {
       charlie.Calculadora calculad1 = new charlie.Calculadora();
       calculad1.entraUm();
       calculad1.entraUm();
       calculad1.comandoSoma();
       assertEquals("22", calculad1.comandoSoma());
       }
       */

	public void testSomaBinariaOnzeMaisUm()
	{
		charlie.Calculadora calculad1 = new charlie.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("100", calculad1.comandoSoma());
	}

	public void testSomaHexadecimalOnzeMaisUm()
	{
		charlie.Calculadora calculad1 = new charlie.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("12", calculad1.comandoSoma());
	}

	public void testSomaOnzeBinarioMaisOnze()
	{
		charlie.Calculadora calculad1 = new charlie.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("1110", calculad1.comandoSoma());
	}
}



