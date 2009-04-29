package foxtrot;



/**
 * Classe de teste da ValorBin.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class ValorBinTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class ValorBinTest.
     */
    public ValorBinTest()
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
     * Teste da conversão para binário.
     */
	public void testConverterBin()
	{
		foxtrot.ValorBin valorBin1 = new foxtrot.ValorBin(12);
		assertEquals("0b1100", valorBin1.converterEmString());
	}

	/**
	 * Teste da adição de dígitos.
	 */
	public void testAdicionarDigito()
	{
		foxtrot.ValorBin valorBin1 = new foxtrot.ValorBin(0);
		assertEquals("0b1", valorBin1.adicionarDigito("1"));
		assertEquals("0b11", valorBin1.adicionarDigito("1"));
		assertEquals (3, valorBin1.getValor());
	}
}


