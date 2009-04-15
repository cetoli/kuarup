package bravo;

/**
 * The test class CalculadoraTest.
 * @author  (Tiago Cruz de França) - O papagaio
 * @author  (Humberto Ferreira Ramos Junior) - O pirata
 * @version (2.0) (12 de abril de 2009)
 */
public class CalculadoraTest extends junit.framework.TestCase {

    /**
     * Default constructor for test class CalculadoraTest.
     */
    public CalculadoraTest() {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown() {
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaUmApatrirdoRepouso() {
        bravo.Calculadora c = new bravo.Calculadora();
        assertEquals("1", c.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaOnzeApartirDoRepouso() {
        bravo.Calculadora c = new bravo.Calculadora();
        c.entraUm();
        assertEquals("11", c.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testLimpaRetornaZero() {
        bravo.Calculadora c = new bravo.Calculadora();
        assertEquals("0", c.limpa());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testRetornaCentoeOnzeApartirDoZero() {
        bravo.Calculadora c = new bravo.Calculadora();
        assertEquals("1", c.entraUm());
        assertEquals("11", c.entraUm());
        assertEquals("111", c.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testUmMaisUm() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("2", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testUmMaisUmLimpar() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("0", calculad1.limpa());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraUmLimpa() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("0", calculad1.limpa());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaApartirDoRepousoRetornaZero() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("0", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaUmMaisRetornaUm() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraUmComandoSomaValorAcumulador() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("11", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testComandoSomaDigitarUmSomar() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testComandoSomaSomar11e1111() {
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
    public void testBaseHexadecimalUmMaisUm() {
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
    public void testBaseDecimalSomandoUmMaisUmRetornaDois() {
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
    public void testBaseBinariaEntraOnzeSomaEntraUmRetornaCem() {
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
    public void testBinariaOnzeSomaDecimalUmRetornaDecimalQuatro() {
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
    public void testDecimalOnzeSomaBinariaUmSomaHexaUmRetornaHexaD() {
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
    public void testeHexaUmSomaDecOnzeSomaBinOnzeRetornaEmBinMilCentoOnze() {
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

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testH1SomaB1RetornaB10() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x1", calculad1.comandoSoma());
        calculad1.modoBin();
        assertEquals("0b1", calculad1.entraUm());
        assertEquals("0b10", calculad1.comandoSoma());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraB1H1B1sai0b100011() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.modoBin();
        assertEquals("0b100011", calculad1.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraB1H1D1sai171()	{
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.modoDec();
        assertEquals("171", calculad1.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testEntraB1H1sai0x11() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.modoHex();
        assertEquals("0x11", calculad1.entraUm());
    }

    /**
     * teste de unidade, manipulacao dos metodos.
     */
    public void testSomaB111Soma111sai0b1110() {
        bravo.Calculadora calculad1 = new bravo.Calculadora();
        calculad1.comandoSoma();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0b1110", calculad1.comandoSoma());
    }
	
	/**
     * teste de unidade, manipulacao dos metodos.
     */
	public void testEntraD1ImD1SomaD1sai2I1() {
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("2I1", calculad1.comandoSoma());
	}
	
	/**
     * teste de unidade, manipulacao dos metodos.
     */
	public void testEntraD1SomaD1ImD1sai2I1() {
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		assertEquals("2I1", calculad1.comandoSoma());
	}
		/**
     * teste de unidade, manipulacao dos metodos.
     */
	public void testEntraD1ImD1SomaD1ImD1sai2I2() {
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		assertEquals("2I2", calculad1.comandoSoma());
	}
}