package golf;

/**
 * The test class CalculadoraTest.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class CalculadoraTest extends junit.framework.TestCase {
    /**
     * Default constructor for test class CalculadoraTest
     */
    public CalculadoraTest() {
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

    /**
     * Testa o resultado de digitar um quando esta em repouso.
     * 
     * @return 1
     */
    public void testDigitaUmEmRepouso() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.limpa();
        assertEquals("1", calculad1.entraUm());
    }

    /**
     * Testa o resultado de digitar um duas vezes.
     * 
     * @return 11
     */
    public void testDigitaUmDuasVezes() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.entraUm();
        assertEquals("11", calculad1.entraUm());
    }

    /**
     * Testa o que sobra no operador apos limpar o seu conteudo.
     * 
     * @return 0
     */
    public void testLimpaConteudo() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    /**
     * Testa o o resultado da soma 1 + 1.
     * 
     * @return 2
     */
    public void testSomaUmMaisUm() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se digitar diretamente a tecla de soma em repouso.
     * 
     * @return 0
     */
    public void testDigitaMaisEmRepouso() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        assertEquals("0", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se digitar diretamente a tecla de soma e a tecla 1.
     * 
     * @return 1
     */
    public void testDigitaSomaUm() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.comandoSoma();
        assertEquals("1", calculad1.entraUm());
    }

    /**
     * Testa o que acontece se digitar a tecla 1 tres vezes.
     * 
     * @return 111
     */
    public void testDigitaUmTresVezes() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("111", calculad1.entraUm());
    }

    /**
     * Testa o que acontece se somar 1 + 1, limpar e somar 1 + 1 novamente.
     * 
     * @return 2
     */
    public void testSomaLimpaSoma() {
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

    /**
     * Testa o que acontece se somar 1 + 1 no modo Binario.
     * 
     * @return 10
     */
    public void testSomaUmMaisUmBin() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0b10", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se digitar + em repouso no modo Binario.
     * 
     * @return 0
     */
    public void testDigitaMaisEmRepousoBin() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.modoBin();
        assertEquals("0b0", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se somar 1 + 1 + 1, no modo Binario.
     * 
     * @return 11
     */
    public void testUmMaisUmMaisUmMaisBin() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0b11", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se somar 11 + 11, no modo Hexadecimal.
     * 
     * @return 22
     */
    public void testSomaOnzeMaisOnzeHex() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0x22", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se somar 11 + 1, no modo Hexadecimal.
     * 
     * @return 12
     */
    public void testSomaOnzeMaisUmHex() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0x12", calculad1.comandoSoma());
    }

    /**
     * Testa o que acontece se digitar + em repouso no modo Hexadecimal.
     * 
     * @return 0
     */
    public void testDigitaMaisEmRepousoHex() {
        golf.Calculadora calculad1 = new golf.Calculadora();
        calculad1.modoHex();
        assertEquals("0x0", calculad1.comandoSoma());
    }
    
    public void testEntraB1H1sai0x11() {
        Calculadora calc = new Calculadora();
        calc.modoBin();
        calc.entraUm();
        
        calc.modoHex();

        assertEquals("0x11", calc.entraUm());
    }
}
