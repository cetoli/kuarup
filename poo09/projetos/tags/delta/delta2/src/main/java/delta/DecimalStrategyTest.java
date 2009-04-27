package delta;



/**
 * The test class DecimalStrategyTest.
 * @author  André Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 André Sion e Thiago Silva de Souza
 */
public class DecimalStrategyTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste DecimalTeste.
     */
    public DecimalStrategyTest() {
    }

    /**
     * Teste do método toDecValue()
     * Número na base decimal utilizado: 8.
     */
    public void testeToDecValue8() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals(8, decimal.toDecValue("8"));
    }

    /**
     * Teste do método toDecValue()
     * Número na base decimal utilizado: 35.
     */
    public void testeToDecValue35() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals(35, decimal.toDecValue("35"));
    }

    /**
     * Teste do método toDecValue()
     * Número na base decimal utilizado: 256.
     */
    public void testeToDecValue256() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals(256, decimal.toDecValue("256"));
    }

    /**
     * Teste do método toDecValue()
     * Número na base decimal utilizado: 1600.
     */
    public void testeToDecValue1600() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals(1600, decimal.toDecValue("1600"));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 8.
     */
    public void testeToBase8() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals("8", decimal.toBase(8));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 35.
     */
    public void testeToBase35() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals("35", decimal.toBase(35));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 256.
     */
    public void testeToBase256() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals("256", decimal.toBase(256));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 1600.
     */
    public void testeToBase1600() {
        DecimalStrategy decimal = new DecimalStrategy();
        assertEquals("1600", decimal.toBase(1600));
    }

    /**
     * Preparação do caso de teste.
     * Chamado antes de cada método de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     * Chamado após cada método de teste de caso.
     */
    protected void tearDown() {
    }
}

