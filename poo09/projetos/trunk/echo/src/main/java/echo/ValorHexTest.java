package echo;



/**
 * Classe de teste da classe ValorHex.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class ValorHexTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class ValorHexTest.
     */
    public ValorHexTest()
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
     * testa conversão para hexadecimal.
     */
	public void testConverterHex()
	{
		echo.ValorHex valor1 = new echo.ValorHex(0);
		valor1.setValor ("2a");
		assertEquals ("0x2a", valor1.converterEmString ());
	}

	/**
	 * Testa a adição de dígitos.
	 */
	public void testAdicionarDigito()
	{
		echo.ValorHex valorHex1 = new echo.ValorHex(0);
		assertEquals("0x1", valorHex1.adicionarDigito("1"));
		assertEquals("0x11", valorHex1.adicionarDigito("1"));
		assertEquals("0x111", valorHex1.adicionarDigito("1"));
		assertEquals("0x111", valorHex1.converterEmString());
		assertEquals (273, valorHex1.getValor());
	}
}


