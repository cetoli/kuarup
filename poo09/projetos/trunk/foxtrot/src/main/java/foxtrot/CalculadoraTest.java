package foxtrot;

/**.
 * Descrição:
 * The test class CalculadoraTest.
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 14/04/2009
 */

public class CalculadoraTest extends junit.framework.TestCase {
    /**.
     * Default constructor for test class CalculadoraTest
     */
    public CalculadoraTest()  {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown() {
    }


    /**.
     * teste
     */
    public void testEntraOnzeAPartirDoRepouso() {
        foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
        calculad2.entraUm();
        assertEquals("11", calculad2.entraUm());
    }

    /**.
     * teste
     */
    public void testEntraUmLimpaAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    /**.
     * teste
     */
    public void testEntraUmTresVezesAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("111", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testUmMaisUmAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }

    /**.
     * teste
     */
    public void testOnzeMaisUmAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }

    /**.
     * teste
     */
    public void testOnzeMaisOnzeAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    public void testEntraUmEntraUmLimpaEntra1APartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.limpa();
        assertEquals("1", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testSomarAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        assertEquals("0", calculad1.comandoSoma());
    }

    /**.
     * teste
     */
    public void testEntraUmAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        assertEquals("1", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testLimparAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        assertEquals("0", calculad1.limpa());
    }

    /**.
     * teste
     */
    public void testEntraOnzeSomarSomarAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        assertEquals("11", calculad1.comandoSoma());
    }

    /**.
     * teste
     */
    public void testHexEntraOnzeAPartirDoRepouso() {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        assertEquals("0x11", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testHexEntraUmLimpaAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        assertEquals("0x0", calculad1.limpa());
    }

    /**.
     * teste
     */
    public void testHexEntraUmTresVezesAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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

    /**.
     * teste
     */
    public void testHexEntraUmEntraUmLimpaEntraUmAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoHex();
        assertEquals("0x0", calculad1.comandoSoma());
    }

    /**.
     * teste
     */
    public void testHexEntraUmAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testHexLimparAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoHex();
        assertEquals("0x0", calculad1.limpa());
    }

    /**.
     * teste
     */
    public void testHexEntraOnzeSomarSomarAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        assertEquals("0b11", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testBinEntraUmLimpaAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        assertEquals("0b0", calculad1.limpa());
    }

    /**.
     * teste
     */
    public void testBinEntraUmTresVezesAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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

    /**.
     * teste
     */
    public void testBinEntraUmEntraUmLimpaEntraUmAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoBin();
        assertEquals("0b0", calculad1.comandoSoma());
    }

    /**.
     * teste
     */
    public void testBinEntraUmAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoBin();
        assertEquals("0b1", calculad1.entraUm());
    }

    /**.
     * teste
     */
    public void testBinLimparAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoBin();
        assertEquals("0b0", calculad1.limpa());
    }

    /**.
     * teste
     */
    public void testBinEntraOnzeSomarSomarAPartirDoRepouso()
    {
        foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        assertEquals("0b11", calculad1.comandoSoma());
    }

	public void testDecimalComplexo ()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoComplexo();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();

		assertEquals("0+2I", calculad2.comandoSoma());
	}

	public void testBinarioComplexo ()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoComplexo();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();

		assertEquals("0b0+0b10I", calculad2.comandoSoma());
	}

	public void testHexadecimalComplexo ()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoComplexo();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();

		assertEquals("0x0+0x2I", calculad2.comandoSoma());
	}

	public void testDecimalNormalMaisComplexo ()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		calculad2.comandoSoma();

		calculad2.modoComplexo();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		assertEquals("2+12I", calculad2.comandoSoma());
	}

	public void testBinarioNormalMaisComplexo ()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		calculad2.comandoSoma();

		calculad2.modoComplexo();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();

		assertEquals("0b10+0b100I", calculad2.comandoSoma());
	}

	public void testHexadecimalNormalMaisComplexo ()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		calculad2.comandoSoma();

		calculad2.modoComplexo();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		assertEquals("0x2+0x12I", calculad2.comandoSoma());
	}

	/**
	 *  Teste: somar b11111id11+h111ib111+ -> 0b100110000I0b10010
	 */
	public void testeSoma0b11111ID11e0x111I0b111sai0b100110000I0b10010() {
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.modoComplexo();
		calculad2.modoDec();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.modoComplexo();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0b100110000I0b10010",calculad2.comandoSoma());
	}

   /**
    *  Teste: somar h11+Ib11+ -> 0b10001I0b11
    */
    public void testeSoma0x11eI0b11sai0b10001I0b11() {
    	foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.modoComplexo();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0b10001I0b11",calculad2.comandoSoma());
    }

    /**
     * Teste: somar 11id1+id1+ -> 11I2
     */
    public void testeSomaD11ID1eID1sai11I2() {
    	foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
    	calculad2.entraUm();
    	calculad2.entraUm();
		calculad2.modoComplexo();
		calculad2.modoDec();
		calculad2.entraUm();

		calculad2.comandoSoma();
		calculad2.modoComplexo();
		calculad2.modoDec();
		calculad2.entraUm();
		assertEquals("11I2",calculad2.comandoSoma());
    }

    /**
     * Teste: somar 1i1+1+ -> 2I1
     */
    public void testeSomaD1ID1eD1sai2I1() {
    	foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
    	calculad2.entraUm();
    	calculad2.modoComplexo();

		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		assertEquals("2I1",calculad2.comandoSoma());
    }

    /**
     *  Teste: somar Ib11+Ih11 -> 0x0I0x14
     */
    public void testeSomaI0b11eI0x11sai0x0I0x14() {
    	foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.modoComplexo();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.modoComplexo();
		calculad2.modoHex();
		calculad2.entraUm();
		assertEquals("0x0I0x14",calculad2.entraUm());
    }

}













