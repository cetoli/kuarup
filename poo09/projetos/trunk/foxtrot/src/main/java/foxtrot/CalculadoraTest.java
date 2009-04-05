package foxtrot;



/**
 * The test class CalculadoraTest.
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferrão
 * 
 * Versão 1     Data 31/03/2009
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

	public void testEntraOnzeAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.entraUm();
		assertEquals("11", calculad2.entraUm());
	}

	public void testEntraUmLimpaAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		assertEquals("0", calculad1.limpa());
	}

	public void testEntraUmTresVezesAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("111", calculad1.entraUm());
	}

	public void testUmMaisUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("2", calculad1.comandoSoma());
	}

	public void testOnzeMaisUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("12", calculad1.comandoSoma());
	}

	public void testOnzeMaisOnzeAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("22", calculad1.comandoSoma());
	}

	public void testEntraUmEntraUmLimpaEntra1APartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("1", calculad1.entraUm());
	}

	public void testSomarAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		assertEquals("0", calculad1.comandoSoma());
	}

	public void testEntraUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		assertEquals("1", calculad1.entraUm());
	}

	public void testLimparAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		assertEquals("0", calculad1.limpa());
	}

	public void testEntraOnzeSomarSomarAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		assertEquals("11", calculad1.comandoSoma());
	}
}











