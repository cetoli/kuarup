package golf;



/**
 * The test class BinariaStrategyTest.
 * @author  Andr� Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 Andr� Sion e Thiago Silva de Souza
 */
public class BinariaStrategyTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste BinariaTeste.
     */
    public BinariaStrategyTest() {
    }

    /**
     * Teste do m�todo toDecValue()
     * N�mero na base bin�ria utilizado: 101.
     */
    public void testeToDecValue101() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals(5, binaria.toDecValue("101"));
    }

     /**
     * Teste do m�todo toDecValue()
     * N�mero na base bin�ria utilizado: 10110.
     */
    public void testeToDecValue10110() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals(22, binaria.toDecValue("10110"));
    }

     /**
     * Teste do m�todo toDecValue()
     * N�mero na base bin�ria utilizado: 100000010.
     */
    public void testeToDecValue100000010() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals(258, binaria.toDecValue("100000010"));
    }

    /**
     * Teste do m�todo toDecValue()
     * N�mero na base bin�ria utilizado: 11001000000.
     */
    public void testeToDecValue11001000000() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals(1600, binaria.toDecValue("11001000000"));
    }

    /**
     * Teste do m�todo toBase()
     * Valor na base decimal utilizado: 5.
     */
    public void testeToBase5() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals("101", binaria.toBase(5));
    }

    /**
     * Teste do m�todo toBase()
     * Valor na base decimal utilizado: 22.
     */
    public void testeToBase22() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals("10110", binaria.toBase(22));
    }

    /**
     * Teste do m�todo toBase()
     * Valor na base decimal utilizado: 258.
     */
    public void testeToBase258() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals("100000010", binaria.toBase(258));
    }

    /**
     * Teste do m�todo toBase()
     * Valor na base decimal utilizado: 1600.
     */
    public void testeToBase1600() {
        BinariaStrategy binaria = new BinariaStrategy();
        assertEquals("11001000000", binaria.toBase(1600));
    }

    /**
     * Prepara��o do caso de teste.
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     * Chamado ap�s cada m�todo de teste de caso.
     */
    protected void tearDown() {
    }
}