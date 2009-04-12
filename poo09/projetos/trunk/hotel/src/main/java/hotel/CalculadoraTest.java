package hotel;

/**
 * The test class CalculadoraTest.
 *
 * @author  (Alexandre Louzada & Marcio Reis)
 * @version (1.0)
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

    public void testLimpaDisplay()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    public void testeAcumulaDigitoUm()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("111", calculad1.entraUm());
        assertEquals("1111", calculad1.entraUm());
        assertEquals("11111", calculad1.entraUm());
        assertEquals("111111", calculad1.entraUm());
        assertEquals("1111111", calculad1.entraUm());
    }


    public void testSomaUmAPartirDoRepouso()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
    }

    public void testTeclaSomaAPartirDoRepouso()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("0", calculad1.comandoSoma());
    }
    
    public void testSomaVariosNumerosUm()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("2", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("3", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("4", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("5", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("6", calculad1.comandoSoma());
    }

    public void testSomaUmComDezena()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("12", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("13", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("14", calculad1.comandoSoma());
    }

    public void testSomaDezenaComDezena()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("11", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("22", calculad1.comandoSoma());
    }

    public void testEntraUmLimpaESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("0", calculad1.limpa());
        assertEquals("0", calculad1.comandoSoma());
    }

    public void testLimpaAposEntrarOnze()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("0", calculad1.limpa());
    }

    public void testSomaDezenaConCentena()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("11", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("111", calculad1.entraUm());
        assertEquals("122", calculad1.comandoSoma());
    }

    public void testMudaBaseDecimalParaHexa()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoHex();
        assertEquals("0xb1", calculad1.entraUm());
        assertEquals("0xb11", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("28331", calculad1.entraUm());
    }
        

    public void testMudaBaseDecimalParaHexaESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoHex();
        assertEquals("0xb1", calculad1.entraUm());
        assertEquals("0xb11", calculad1.entraUm());
        assertEquals("0xb11", calculad1.comandoSoma());
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x11", calculad1.entraUm());
        assertEquals("0x111", calculad1.entraUm());
        assertEquals("0xc22", calculad1.comandoSoma());
        calculad1.modoDec();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("3117", calculad1.comandoSoma());
    }
    
    public void testMudaBaseHexaParaDecimal()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x11", calculad1.entraUm());
        assertEquals("0x111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("2731", calculad1.entraUm());
        assertEquals("27311", calculad1.entraUm());
        calculad1.modoHex();
        assertEquals("0x6aaf1", calculad1.entraUm());
    }
    
    public void testMudaBaseHexaParaDecimalESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x11", calculad1.entraUm());
        assertEquals("0x111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("273", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoHex();
        assertEquals("0x11c", calculad1.comandoSoma());
    }
    
    public void testMudaBaseDecimalParaBinaria()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10111", calculad1.entraUm());
        assertEquals("bx101111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("471", calculad1.entraUm());
    }
        
    
    public void testMudaBaseDecimalParaBinariaESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10111", calculad1.entraUm());
        assertEquals("bx101111", calculad1.entraUm());
        assertEquals("bx101111", calculad1.comandoSoma());
        assertEquals("bx1", calculad1.entraUm());
        assertEquals("bx11", calculad1.entraUm());
        assertEquals("bx111", calculad1.entraUm());
        assertEquals("bx110110", calculad1.comandoSoma());
        calculad1.modoDec();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("65", calculad1.comandoSoma());
    }
    
    public void testMudaBaseBinariaParaDecimal()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoBin();
        assertEquals("bx1", calculad1.entraUm());
        assertEquals("bx11", calculad1.entraUm());
        assertEquals("bx111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("71", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10001111", calculad1.entraUm());
    }
    
    public void testMudaBaseBinariaParaDecimalESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoBin();
        assertEquals("bx1", calculad1.entraUm());
        assertEquals("bx11", calculad1.entraUm());
        assertEquals("bx111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("7", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10010", calculad1.comandoSoma());
    }
    
    public void testMudaBaseHexaDecimalParaBinaria()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoHex();
        assertEquals("0x1", calculad1.entraUm());
        assertEquals("0x11", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx100011", calculad1.entraUm());
        assertEquals("bx1000111", calculad1.entraUm());
        calculad1.modoHex();
        assertEquals("0x471", calculad1.entraUm());
    }
        
    
    public void testMudaBaseHexaDecimalParaBinariaESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10111", calculad1.entraUm());
        assertEquals("bx101111", calculad1.entraUm());
        assertEquals("bx101111", calculad1.comandoSoma());
        assertEquals("bx1", calculad1.entraUm());
        assertEquals("bx11", calculad1.entraUm());
        assertEquals("bx111", calculad1.entraUm());
        assertEquals("bx110110", calculad1.comandoSoma());
        calculad1.modoDec();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("65", calculad1.comandoSoma());
    }
    
    public void testMudaBaseBinariaParaHexaDecimal()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoBin();
        assertEquals("bx1", calculad1.entraUm());
        assertEquals("bx11", calculad1.entraUm());
        assertEquals("bx111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("71", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10001111", calculad1.entraUm());
    }
    
    public void testMudaBaseBinariaParaHexaDecimalESoma()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.modoBin();
        assertEquals("bx1", calculad1.entraUm());
        assertEquals("bx11", calculad1.entraUm());
        assertEquals("bx111", calculad1.entraUm());
        calculad1.modoDec();
        assertEquals("7", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        calculad1.modoBin();
        assertEquals("bx10010", calculad1.comandoSoma());
    }
    
}














