package delta;
/**
 * The test class CalculadoraTest.
 *
 * @author  André Sion e Thiago Silva de Souza
 * @version 1.0
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
	public void testeEntraUmDigitar1()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		assertEquals("1", calculad1.entraUm());
	}
	public void testeEntraUmDigitar11()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		assertEquals("11", calculad1.entraUm());
	}
	public void testeEntraUmDigitar111()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("111", calculad1.entraUm());
	}
	public void testeEntraUmDigitar1111()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("1111", calculad1.entraUm());
	}
	public void testeComandoSomaDigitar1Somar()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("2", calculad1.comandoSoma());
	}
	public void testeComandoSomaSomar1e11()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("12", calculad1.comandoSoma());
	}
	public void testeComandoSomaSomar11e1111()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("1122", calculad1.comandoSoma());
	}
	public void testeComandoLimpar()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		assertEquals("0", calculad1.limpa());
	}
	public void testeComandoSomarApartirRepouso()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		assertEquals("0", calculad1.comandoSoma());
	}
	public void testeComandoLimparEntraUm()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("1", calculad1.entraUm());
	}
}
