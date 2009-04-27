package delta;



/**
 * The test class HexadecimalStrategyTest.
 * @author  André Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 André Sion e Thiago Silva de Souza
 */
public class HexadecimalStrategyTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste HexadecimalTeste.
     */
    public HexadecimalStrategyTest() {
    }

    /**
     * Teste do método toDecValue()
     * Número na base hexadecimal utilizado: 8.
     */
    public void testeToDecValue8() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals(8, hexadecimal.toDecValue("8"));
    }

    /**
     * Teste do método toDecValue()
     * Número na base hexadecimal utilizado: 2F.
     */
    public void testeToDecValue2F() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals(47, hexadecimal.toDecValue("2F"));
    }

    /**
     * Teste do método toDecValue()
     * Número na base hexadecimal utilizado: 237.
     */
    public void testeToDecValue237() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals(567, hexadecimal.toDecValue("237"));
    }

    /**
     * Teste do método toDecValue()
     * Número na base hexadecimal utilizado: 63E.
     */
    public void testeToDecValue63E() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals(1598, hexadecimal.toDecValue("63E"));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 8.
     */
    public void testeToBase8() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals("8", hexadecimal.toBase(8));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 47.
     */
    public void testeToBase47() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals("2f", hexadecimal.toBase(47));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 567.
     */
    public void testeToBase567() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals("237", hexadecimal.toBase(567));
    }

    /**
     * Teste do método toBase()
     * Valor na base decimal utilizado: 1598.
     */
    public void testeToBase1598() {
        HexadecimalStrategy hexadecimal = new HexadecimalStrategy();
        assertEquals("63e", hexadecimal.toBase(1598));
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
