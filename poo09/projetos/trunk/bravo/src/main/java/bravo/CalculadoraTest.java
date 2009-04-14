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
     * Default constructor for test class CalculadoraTest.
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
    
    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaUmApatrirdoRepouso()
    {
        bravo.Calculadora c = new bravo.Calculadora();
        assertEquals("1", c.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaOnzeApartirDoRepouso()
    {
        bravo.Calculadora c = new bravo.Calculadora();
        c.entraUm();
        assertEquals("11", c.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testLimpaRetornaZero()
    {
        bravo.Calculadora c = new bravo.Calculadora();
        assertEquals("0", c.limpa());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testRetornaCentoeOnzeApartirDoZero()
    {
        bravo.Calculadora c = new bravo.Calculadora();
        assertEquals("1", c.entraUm());
        assertEquals("11", c.entraUm());
        assertEquals("111", c.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testUmMaisUm()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("2", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testUmMaisUmLimpar()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("0", calculad1.limpa());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraUmLimpa()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("0", calculad1.limpa());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaApartirDoRepousoRetornaZero()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("0", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaUmMaisRetornaUm()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraUmComandoSomaValorAcumulador()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("11", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testComandoSomaDigitarUmSomar()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testComandoSomaSomar11e1111()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("11", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("111", calculad1.entraUm());
        assertEquals("1111", calculad1.entraUm());
        assertEquals("1122", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testBaseHexadecimalUmMaisUm()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x1", calculad1.comandoSoma());
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x2", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testBaseDecimalSomandoUmMaisUmRetornaDois()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("2", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testBaseBinariaEntraOnzeSomaEntraUmRetornaCem()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoBin();
        assertEquals("0b1", calculad1.entraUm());
        assertEquals("0b11", calculad1.entraUm());
        assertEquals("0b11", calculad1.comandoSoma());
        assertEquals("0b1", calculad1.entraUm());
        assertEquals("0b100", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testBinariaOnzeSomaDecimalUmRetornaDecimalQuatro()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoBin();
        assertEquals("0b1", calculad1.entraUm());
        assertEquals("0b11", calculad1.entraUm());
        assertEquals("0b11", calculad1.comandoSoma());
        calculad1.modoDec();
        assertEquals("1", calculad1.entraUm());
        assertEquals("4", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testDecimalOnzeSomaBinariaUmSomaHexaUmRetornaHexaD()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoDec();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("11", calculad1.comandoSoma());
        calculad1.modoBin();
        assertEquals("0b1", calculad1.entraUm());
        assertEquals("0b1100", calculad1.comandoSoma());
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0xd", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testeHexaUmSomaDecOnzeSomaBinOnzeRetornaEmBinMilCentoOnze()
    {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x1", calculad1.comandoSoma());
        calculad1.modoDec();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.comandoSoma();
        calculad1.modoBin();
        assertEquals("0b1", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("0b11", calculad1.entraUm());
        assertEquals("0b1111", calculad1.comandoSoma());
    }
    

	public void testH1SomaB1RetornaB10()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x1", calculad1.comandoSoma());
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b10", calculad1.comandoSoma());
	}
}

