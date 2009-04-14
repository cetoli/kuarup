package foxtrot;



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

	public void testHexEntraOnzeAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		assertEquals("0x11", calculad1.entraUm());
	}

	public void testHexEntraUmLimpaAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		assertEquals("0x0", calculad1.limpa());
	}

	public void testHexEntraUmTresVezesAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0x111", calculad1.entraUm());
	}

	public void testHexUmMaisUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0x2", calculad1.comandoSoma());
	}

	public void testHexOnzeMaisUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0x12", calculad1.comandoSoma());
	}

	public void testHexUmMaisUmOnzeVezesAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0xb", calculad1.comandoSoma());
	}

	public void testHexEntraUmEntraUmLimpaEntraUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("0x1", calculad1.entraUm());
	}

	public void testHexSomarAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		assertEquals("0x0", calculad1.comandoSoma());
	}

	public void testHexEntraUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
	}

	public void testHexLimparAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		assertEquals("0x0", calculad1.limpa());
	}

	public void testHexEntraOnzeSomarSomarAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		assertEquals("0x11", calculad1.comandoSoma());
	}
	
	public void testBinEntraOnzeAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b11", calculad1.entraUm());
	}

	public void testBinEntraUmLimpaAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b0", calculad1.limpa());
	}

	public void testBinEntraUmTresVezesAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0b111", calculad1.entraUm());
	}

	public void testBinUmMaisUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0b10", calculad1.comandoSoma());
	}

	public void testBinOnzeMaisUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0b100", calculad1.comandoSoma());
	}

	public void testBinUmMaisUmOnzeVezesAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0b1011", calculad1.comandoSoma());
	}

	public void testBinEntraUmEntraUmLimpaEntraUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("0b1", calculad1.entraUm());
	}

	public void testBinSomarAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		assertEquals("0b0", calculad1.comandoSoma());
	}

	public void testBinEntraUmAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
	}

	public void testBinLimparAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		assertEquals("0b0", calculad1.limpa());
	}

	public void testBinEntraOnzeSomarSomarAPartirDoRepouso()
	{
		foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		assertEquals("0b11", calculad1.comandoSoma());
	}
}













