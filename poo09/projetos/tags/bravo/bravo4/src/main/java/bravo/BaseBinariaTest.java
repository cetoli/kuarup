package bravo;

/**
 * The test class BaseBinariaTest.
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 */
public class BaseBinariaTest extends junit.framework.TestCase {
   /**
    * Constante para representar o numero 1.
    */
    private static final int NUMERO_1 = 1;
   /**
    * Constante para representar o numero 11.
    */
    private static final int NUMERO_11 = 11;
   /**
    * Constante para representar o numero 111.
    */
    private static final int NUMERO_111 = 111;
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
        assertEquals("0b1", baseBina1.converterBase(new Numero(NUMERO_1)));
    }

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoOnzeRetornaStringMileOnze() {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("0b1011", baseBina1.converterBase(new Numero(NUMERO_11)));
    }

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoCentoeOnzeRetorna1101111() {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("0b1101111", baseBina1.converterBase(new Numero(NUMERO_111))); 
    }
}