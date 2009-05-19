package alpha;

/**.
 * Descrição:
 * The test class CalculadoraTest.
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Diego Mury G. de Lima
 *
 * @version 5     Data 19/05/2009
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
		alpha.Calculadora calculad2 = new alpha.Calculadora();
		calculad2.entraUm();
		assertEquals("11", calculad2.entraUm());
	}

	/**.
	 * teste
	 */
	public void testEntraUmLimpaAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.entraUm();
		assertEquals("0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testEntraUmTresVezesAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("111", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testUmMaisUmAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		assertEquals("0", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testEntraUmAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		assertEquals("1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testLimparAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		assertEquals("0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testEntraOnzeSomarSomarAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		assertEquals("0x11", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testHexEntraUmLimpaAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoHex();
		calculad1.entraUm();
		assertEquals("0x0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testHexEntraUmTresVezesAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoHex();
		assertEquals("0x0", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testHexEntraUmAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testHexLimparAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoHex();
		assertEquals("0x0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testHexEntraOnzeSomarSomarAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b11", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testBinEntraUmLimpaAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testBinEntraUmTresVezesAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoBin();
		assertEquals("0b0", calculad1.comandoSoma());
	}

	/**.
	 * teste
	 */
	public void testBinEntraUmAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
	}

	/**.
	 * teste
	 */
	public void testBinLimparAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
		calculad1.modoBin();
		assertEquals("0b0", calculad1.limpa());
	}

	/**.
	 * teste
	 */
	public void testBinEntraOnzeSomarSomarAPartirDoRepouso()
	{
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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
		alpha.Calculadora calculad1 = new alpha.Calculadora();
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

	/**.
     * Teste Vetorial
     */
    public final void testeEntraD1N1VB11sai0b1N1V0b11() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraN();
        calculad1.entraUm();
        calculad1.entraV();
        calculad1.modoBin();
        calculad1.entraUm();
        assertEquals("0b1N1V0b11", calculad1.entraUm());
    }
}














