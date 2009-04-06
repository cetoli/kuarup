package golf;



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

	public void test_digita_um_em_repouso()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.limpa();
		assertEquals("1", calculad1.entraUm());
	}

	public void test_digita_um_duas_vezes()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.entraUm();
		assertEquals("11", calculad1.entraUm());
	}

	public void test_limpa_conteudo()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.entraUm();
		assertEquals("0", calculad1.limpa());
	}

	public void test_soma_um_mais_um()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("2", calculad1.comandoSoma());
	}

	public void test_digita_mais_em_repouso()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		assertEquals("0", calculad1.comandoSoma());
	}

	public void test_digita_soma_um()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.comandoSoma();
		assertEquals("1", calculad1.entraUm());
	}

	public void test_digita_um_tres_vezes()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("111", calculad1.entraUm());
	}

	public void test_soma_limpa_soma()
	{
		golf.Calculadora calculad1 = new golf.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.limpa();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("2", calculad1.comandoSoma());
	}
}








