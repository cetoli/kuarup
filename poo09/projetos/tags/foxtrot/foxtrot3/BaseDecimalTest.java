/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com números complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Thiago Silva de Souza)  $Author$
 * @version (3.0)    $Revision$ (28/04/09)      $Date$
 * @since   (3.0) Suporte a números complexos
 * @version (2.0)    $Revision$ (07/04/09)      $Date$
 * @since   (2.0) Botoes para entrar valores em binario, hexadecimal e decimal
 */
public class BaseDecimalTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste BaseDecimalTest.
     */
    public BaseDecimalTest() {
    }
 
    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    protected void setUp() {
    }
 
    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    protected void tearDown() {
    }
 
	/**
     * Teste: converter para base decimal um número na base decimal.
     */
    public void testConverterBase0()
	{
		BaseDecimal baseDeci1 = new BaseDecimal();
		assertEquals("0", baseDeci1.converteBase(0));
	}

    /**
     * Teste: converter para base decimal um número na base decimal.
     */
	public void testConverterBase1()
    {
        echo.BaseDecimal baseDeci1 = new echo.BaseDecimal();
        assertEquals("1", baseDeci1.converteBase(1));
    }

    /**
     * Teste: converter para base decimal um número na base decimal.
     */
    public void testConverterBasel11()
    {
        BaseDecimal baseDeci1 = new echo.BaseDecimal();
        assertEquals("11", baseDeci1.converteBase(11));
    }
    
    /**
     * Teste: converter para base decimal um número na base decimal.
     */
    public void testConverterBasel111()
    {
        BaseDecimal baseDeci1 = new echo.BaseDecimal();
        assertEquals("111", baseDeci1.converteBase(111));
    }
 
	/**
     * Teste: converter para base decimal um número na base decimal.
     */
    public void testConverterParaDecimal1()
	{
		BaseDecimal baseDeci1 = new echo.BaseDecimal();
		assertEquals(1, baseDeci1.converteBaseParaDecimal("1"));
	}
 
	/**
     * Teste: converter para base decimal um número na base decimal.
     */
	public void testConverterParaDecimal11()
	{
		BaseDecimal baseDeci1 = new echo.BaseDecimal();
		assertEquals(11, baseDeci1.converteBaseParaDecimal("11"));
	}
 
	/**
     * Teste: converter para base decimal um número na base decimal.
     */
	public void testConverterParaDecimal111()
	{
		BaseDecimal baseDeci1 = new echo.BaseDecimal();
		assertEquals(111, baseDeci1.converteBaseParaDecimal("111"));
	}
 
	/**
     * Teste: converter para base decimal um número na base decimal.
     */
	public void testConverterParaDecimal1111()
	{
		BaseDecimal baseDeci1 = new echo.BaseDecimal();
		assertEquals(1111, baseDeci1.converteBaseParaDecimal("1111"));
	}
}