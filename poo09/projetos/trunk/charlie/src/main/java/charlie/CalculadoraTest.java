package charlie;

/**
 * The test class CalculadoraTest.
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculadoraTest extends junit.framework.TestCase {
    /**
     * Construtor da Classe Calculadora.
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
     * Teste testSomaUmAPartirDoRepouso.
     */
    public final void testSomaUmAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        assertEquals("1", calculad1.comandoSoma());
    }

    /**
     * Teste testEntraOnzeAPartirDoRepouso.
     */
    public final void testEntraOnzeAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        assertEquals("11", calculad1.entraUm());
    }

    /**
     * Teste testLimpaAPartirDoRepouso.
     */
    public final void testLimpaAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        assertEquals("0", calculad1.limpa());
    }

    /**
     * Teste testLimpaAposInserirUmAPartirDoRepouso.
     */
    public final void testLimpaAposInserirUmAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    /**
     * Teste testLimpaAposInserirOnzeAPartirDoRepouso.
     */
    public final void testLimpaAposInserirOnzeAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    /**
     * Teste testLimpaAposInserirCentoEOnzeAPartirDoRepouso.
     */
    public final void testLimpaAposInserirCentoEOnzeAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    /**
     * Teste testSomaUmMaisOnzeAPartirDoRepouso.
     */
    public final void testSomaUmMaisUmAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }

    /**
     * Teste testSomaUmMaisOnzeAPartirDoRepouso.
     */
    public final void testSomaUmMaisUmMaisUmAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("3", calculad1.comandoSoma());
    }

    /**
     * Teste testSomaUmMaisOnzeAPartirDoRepouso.
     */
    public final void testSomaUmMaisOnzeAPartirDoRepouso() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }

    /*
       public void testUmMaisMaisAPartirDoRepouso()
       {
       charlie.Calculadora calculad1 = new charlie.Calculadora();
       calculad1.entraUm();
       calculad1.comandoSoma();
       assertEquals("2", calculad1.comandoSoma());
       }

       public void testOnzeMaisMaisAPartirDoRepouso()
       {
       charlie.Calculadora calculad1 = new charlie.Calculadora();
       calculad1.entraUm();
       calculad1.entraUm();
       calculad1.comandoSoma();
       assertEquals("22", calculad1.comandoSoma());
       }
       */

    /**
     * Teste testSomaBinariaOnzeMaisUm.
     */
	public final void testSomaBinariaOnzeMaisUm() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0b100", calculad1.comandoSoma());
    }

    /**
     * Teste testSomaHexadecimalOnzeMaisUm.
     */
    public final void testSomaHexadecimalOnzeMaisUm() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0x12", calculad1.comandoSoma());
    }

    /**
     * Teste testSomaOnzeBinarioMaisOnze.
     */
    public final void testSomaOnzeBinarioMaisOnze() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0b1110", calculad1.comandoSoma());
    }

    /**
     * Teste testHexadecimal11Binario1Retorna0b100011.
     */
    public final void testHexadecimal11Binario1Retorna0b100011() {
        charlie.Calculadora calculad1 = new charlie.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.modoBin();
        assertEquals("0b100011", calculad1.entraUm());
    }
}
