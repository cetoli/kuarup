package alpha;

/**
 * The test class CalculadoraUnitTest.
 *
 * @author Diego Mury Gomes de Lima
 * @author Leandro Oliveira Gomes
 * @version 3.0
 */
public class CalculadoraTest extends junit.framework.TestCase {
    /**
     * Default constructor for test class CalculadoraUnitTest.
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
     * Testa o metodo limpa.
     */
    public final void testLimpa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        String zero = calculad1.limpa();
        assertEquals("Deveria retornar 0", "0", zero);
    }
    /**
     * Testa a soma a partir do repouso.
     */
    public final void testSomaAPartirDoRepouso() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        assertEquals("Deveria retornar 0", "0", calculad1.comandoSoma());
    }
    /**
     * Testa limpa e soma a partir do repouso.
     */
    public final void testLimpaESoma() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.limpa();
        assertEquals("Deveria retornar 0", "0", calculad1.comandoSoma());
    }
    /**
     * Testa a entrada de um numero a partir do repouso.
     */
    public final void testEntraUmAPartirDoRepouso() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        assertEquals("1", calculad1.entraUm());
    }
    /**
     * Testa a entra um e soma a partir do repouso.
     */
    public final void testSomaUmAPartirDoRepouso() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        assertEquals("1", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de um decimal com um decimal.
     */
    public final void testSomaUmComUm() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2", calculad1.comandoSoma());
    }
    /**
     * Testa a entra onze e soma a partir do repouso.
     */
    public final void testSomaOnzeAPartirDoRepouso() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("11", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de um decimal com Onze decimal.
     */
    public final void testSomaUmComOnze() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("12", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de onze decimal com cento e onze decimal.
     */
    public final void testSomaOnzeComCentoEOnze() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("122", calculad1.comandoSoma());
    }
    /**
     * Testa o overflow na entrada.
     */
    public final void testOverflowNaEntrada() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        try {
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            calculad1.entraUm();
            fail();
        } catch (NumberFormatException e) {
            assertTrue(true);
        }
    }
    /**
     * Testa a soma de um binario com um binario.
     */
    public final void testSomaUmBinarioComUmBinario() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0b10", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de um hexadecimal com um hexadecimal.
     */
    public final void testSomaUmHexaComUmHexa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0x2", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de onze hexadecimal com um hexadecimal.
     */
    public final void testSomaUmUmHexaComUmHexa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("0x12", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de um binario com um hexadecimal.
     */
    public final void testSomaUmBinarioComUmHexa() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoHex();
        calculad1.entraUm();
        assertEquals("0x2", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de um hexadecimal com um binario.
     */
    public final void testSomaUmHexaComUmUmBin() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0b100", calculad1.comandoSoma());
    }
    /**
     * Testa a soma de Onze hexadecimal com um binario.
     */
    public final void testSomaUmUmHexaComUmBin() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.modoBin();
        calculad1.entraUm();
        assertEquals("0b10010", calculad1.comandoSoma());
    }
    /**
     * Testa entrada de um hexadecimal com um binario.
     */
    public final void testEntraUmHexaComUmBin() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.modoBin();
        assertEquals("0b11", calculad1.entraUm());
    }
    /**
     * Testa entrada de onze hexadecimal com um decimal.
     */
    public final void testEntraUmUmHexaComUmDec() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.modoDec();
        assertEquals("171", calculad1.entraUm());
    }
   /**
     * Testa entrada de um binario com um hexadecimal.
     */
    public final void testEntraUmBinComUmHex() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.modoHex();
        assertEquals("0x11", calculad1.entraUm());
    }
    /**
     * Testa entrada de um binario com um hexadecimal com um Binario.
     */
    public final void testEntraUmBinUmHexUmBin() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.modoBin();
        assertEquals("0b100011", calculad1.entraUm());
    }
    /**
     * Testa entrada de um decimal real e um decimal 
     * imaginario com um decimal real.
     */
    public final void testeSomaD1ID1eD1sai2I1() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraI();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraUm();
        assertEquals("2I1", calculad1.comandoSoma());
    }
    /**
     * Testa entrada de onze decimal real e um decimal imaginario
     * com um decimal imaginario.
     */
    public final void testeSomaD11ID1eID1sai11I2() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraI();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraI();
        calculad1.entraUm();
        assertEquals("11I2", calculad1.comandoSoma());
    }
    /**
     * Testa entrada de onze binario Imaginario
     * com onze hexadecimal imaginario.
     */
    public final void testeSomaI0b11eI0x11sai0x0I0x14() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraI();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.comandoSoma();
        calculad1.entraI();
        calculad1.modoHex();
        calculad1.entraUm();
        calculad1.entraUm();
        assertEquals("0x0I0x14", calculad1.comandoSoma());
    }
    /**
     * Testa entrada de um decimal vezes 10 elevado a 
     * um com onze binario imaginario.
     */
    public final void testeEntraD1N1IB11sai0b1N1I0b11() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraN();
        calculad1.entraUm();
        calculad1.entraI();
        calculad1.modoBin();
        calculad1.entraUm();
        assertEquals("0b1N1I0b11", calculad1.entraUm());
    }
    /**
     * Testa entrada de um decimal com onze binario elevado a
     * um imaginario.
     */
    public final void testeEntraD1IB11N1sai0b1I0b11N1() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.entraUm();
        calculad1.entraI();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraN();
        assertEquals("0b1I0b11N1", calculad1.entraUm());
    }
    /**
     * Testa entrada de um decimal elevado 10 vezes onze com
     * onze hexadecimal elevado a dez vezes um imaginario.
     */
    public final void testeEntraD1N11IH11N1sai0x1NBI0x11N1() {
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
        assertEquals("0x1NBI0x11N1", calculad1.entraUm());
    }
    /**
     * Testa entrada de um binario elevado a 10 vezes onze 
     * binario com onze binario vezes 10 elevado a um imaginario.
     */
    public final void testeEntraB1NB11IB11ND1sai1N3I3N1() {
        alpha.Calculadora calculad1 = new alpha.Calculadora();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraN();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraI();
        calculad1.modoBin();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraN();
        calculad1.modoDec();
        assertEquals("1N3I3N1", calculad1.entraUm());
    }
    /**
     * Testa a soma de um decimal vezes 10 elevado a um
     * com onze decimal vezes 10 elevado a um.
     */
    public final void testeSoma1N1mais11N1sai12N1() {
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
    /**
     * Testa a soma de onze decimal vezes 10 elevado a onze
     * binario com um binario vezes 10 elevado a onze binario.
     */
    public final void testeSoma11NB11maisB1NB11sai0b1100N11() {
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
    /**
     * Testa a soma de um hexadecimal vezes 10 elevado a um
     * e onze decimal vezes 10 elevado a um imaginario com onze binario
     * vezes 10 elevado a onze esperando resultado em hexadecimal
     * binario vezes 10 elevado a onze binario.
     */
    public final void testeSomaH1N1ID11N1maisB11N11Hsai0x3N3I0xBN1() {
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
        assertEquals("0x3N3I0xBN1", calculad1.comandoSoma());
    }
}
