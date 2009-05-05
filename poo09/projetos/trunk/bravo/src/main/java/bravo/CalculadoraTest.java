package bravo;



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

	public void testEntraB1H1D1sai171()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		calculad1.modoHex();
		assertEquals("0x11", calculad1.entraUm());
		calculad1.modoDec();
		assertEquals("171", calculad1.entraUm());
	}

	public void testSomaB11eH11eD11sai31()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b11", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x14", calculad1.comandoSoma());
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("31", calculad1.comandoSoma());
	}

	public void testSomaD11ID1eID1sai11I2()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		calculad1.entraI();
		assertEquals("11I1", calculad1.entraUm());
		assertEquals("11I1", calculad1.comandoSoma());
		calculad1.entraI();
		assertEquals("0I1", calculad1.entraUm());
		assertEquals("11I2", calculad1.comandoSoma());
	}

	public void testSomaI0b11eI0x11sai0x0I0x14()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.entraI();
		calculad1.modoBin();
		assertEquals("0b0I0b1", calculad1.entraUm());
		assertEquals("0b0I0b11", calculad1.entraUm());
		assertEquals("0b0I0b11", calculad1.comandoSoma());
		calculad1.entraI();
		calculad1.modoHex();
		assertEquals("0x0I0x1", calculad1.entraUm());
		assertEquals("0x0I0x11", calculad1.entraUm());
		assertEquals("0x0I0x14", calculad1.comandoSoma());
	}

	public void testSomaELimpa()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("12", calculad1.comandoSoma());
		assertEquals("0", calculad1.limpa());
	}

	public void testEntraD1IB11N1sai0b1I0b11N1()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		calculad1.entraI();
		calculad1.modoBin();
		assertEquals("0b1I0b1", calculad1.entraUm());
		assertEquals("0b1I0b11", calculad1.entraUm());
		calculad1.entraN();
		assertEquals("0b1I0b11N1", calculad1.entraUm());
	}

	public void testSoma11N1mais1N11sai1N11()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		calculad1.entraN();
		assertEquals("11N1", calculad1.entraUm());
		assertEquals("11N1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		calculad1.entraN();
		assertEquals("1N1", calculad1.entraUm());
		assertEquals("1N11", calculad1.entraUm());
		assertEquals("1N11", calculad1.comandoSoma());
	}
}







