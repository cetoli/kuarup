package delta;



/**
 * The test class HexadecimalStrategyTest.
 * @author  Andre Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 Andr� Sion e Thiago Silva de Souza
 */
public class HexadecimalStrategyTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste HexadecimalTeste.
     */
    public HexadecimalStrategyTest() {
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

	public void testConverte16()
	{
		delta.HexadecimalStrategy hexadeci1 = new delta.HexadecimalStrategy();
		assertEquals("0x10", hexadeci1.toString(16));
	}
}

