package bravo;

/**
 * The test class BaseBinariaTest.
 * A classe calculadora realiza opera��es matem�ticas com n�meros Imagin�rios.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta vers�o trabalha com os numeros Imaginarios
 */
public class BaseBinariaTest extends junit.framework.TestCase {

    /**
     * Default constructor for test class BaseBinariaTest.
     */
    public BaseBinariaTest() {
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
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoUmRetornaStringUm() {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("0b1", baseBina1.converterBase(new Numero(1)));
    }

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoOnzeRetornaStringMileOnze() {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("0b1011", baseBina1.converterBase(new Numero(11)));
    }

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoCentoeOnzeRetorna1101111() {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("0b1101111", baseBina1.converterBase(new Numero(111))); 
    }
}