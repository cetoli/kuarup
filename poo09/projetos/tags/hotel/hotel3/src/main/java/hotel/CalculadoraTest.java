package hotel;

/**.
 * Descrição:
 * The test class CalculadoraTest.
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public class CalculadoraTest extends junit.framework.TestCase
{
    /**.
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


	/**.
	 * teste
	 */
	public void testEntraOnzeAPartirDoRepouso()
	{
		hotel.Calculadora calculad2 = new hotel.Calculadora();
		calculad2.entraUm();
		assertEquals("11", calculad2.entraUm());
	}

	/**.
	 * teste
	 */
	public void testEntraUmLimpaAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		assertEquals("0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testEntraUmTresVezesAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("111", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testUmMaisUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("2", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testOnzeMaisUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("12", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testOnzeMaisOnzeAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("22", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testEntraUmEntraUmLimpaEntra1APartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testSomarAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		assertEquals("0", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testEntraUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		assertEquals("1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testLimparAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		assertEquals("0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testEntraOnzeSomarSomarAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		assertEquals("11", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testHexEntraOnzeAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		assertEquals("0x11", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testHexEntraUmLimpaAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		assertEquals("0x0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testHexEntraUmTresVezesAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0x111", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testHexUmMaisUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0x2", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testHexOnzeMaisUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0x12", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testHexUmMaisUmOnzeVezesAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
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

	/**.
	 * teste
	 */
	public void testHexEntraUmEntraUmLimpaEntraUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("0x1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testHexSomarAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		assertEquals("0x0", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testHexEntraUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testHexLimparAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		assertEquals("0x0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testHexEntraOnzeSomarSomarAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		assertEquals("0x11", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testBinEntraOnzeAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b11", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testBinEntraUmLimpaAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testBinEntraUmTresVezesAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0b111", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testBinUmMaisUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0b10", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testBinOnzeMaisUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		assertEquals("0b100", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testBinUmMaisUmOnzeVezesAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
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

	/**.
	 * teste
	 */
	public void testBinEntraUmEntraUmLimpaEntraUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.limpa();
		assertEquals("0b1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testBinSomarAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		assertEquals("0b0", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testBinEntraUmAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testBinLimparAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		assertEquals("0b0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testBinEntraOnzeSomarSomarAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		assertEquals("0b11", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testComplexoBin11I111Soma11I11APartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0b110I0b1010", calculad1.comandoSoma());
	}
	/**.
	 * teste
	 */
	public void testComplexoOnzeMaisOnzeAPartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("22", calculad1.comandoSoma());
	}
	/**.
	 * teste
	 */
	public void testComplexoHex11I111Soma11I11APartirDoRepouso()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0x22I0x122", calculad1.comandoSoma());
	}
	/**.
	 * teste
	 */
	public void testeEntraD1IB11N1sai0b1I0b11N1() 
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		assertEquals("0b1I0b11N1", calculad1.entraUm());
	}
	
	/**.
	 * teste
	 */
	public void testeEntraD1N11IH11N1sai0x1NBI0x11N1()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		assertEquals("0x1NbI0x11N1", calculad1.entraUm());
	}
	
	/**.
	 * teste
	 */
	public void testeEntraD1N1IB11sai0b1N1I0b11() 
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b1N1I0b11", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testeSoma11N1mais1N11sai1N11() 
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("1N11", calculad1.comandoSoma());
	}
	/**.
	 * teste
	 */
	public void testeSoma11NB11maisB1NB11sai0b1100N11() 
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("0b1100N11", calculad1.comandoSoma());
	}
	/**.
	 * teste
	 */
	public void testeSoma1N1mais11N1sai12N1() 
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		assertEquals("12N1", calculad1.comandoSoma());
	}
	
	/**.
	 * teste
	 */
	public void testeSomaH1N1ID11N1maisB11N11Hsai0x3N3I0xBN1() 
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.modoDec();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.modoHex();
		assertEquals("0x3N3I0xbN1", calculad1.comandoSoma());
	}	
}














