package bravo;



/**
 * The test class BaseBinariaTest.
 * 
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseBinariaTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class BaseBinariaTest.
     */
    public BaseBinariaTest()
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

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoUmRetornaStringUm()
    {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("1", baseBina1.converterBase(1));
    }

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoOnzeRetornaStringMileOnze()
    {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("1011", baseBina1.converterBase(11));
    }

    /**
     * Teste de Passagem de valores para o metodo.
     */
    public void testPassandoCentoeOnzeRetorna1101111()
    {
        bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
        assertEquals("1101111", baseBina1.converterBase(111));
    }
}




