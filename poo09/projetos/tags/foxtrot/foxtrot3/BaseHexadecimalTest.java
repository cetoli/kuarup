/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Classe de teste da base hexadecimal.
 * @author  Cristiane e Diego Araújo
 * @version 0.3 29/03/2007 Cristiane e Diego Araújo
 * @since   0.3 Adicionados novos métodos.
 * @version 0.2 29/03/2007 Cristiane e Márcio Maia
 * @since   0.2 Adicionados novos métodos.
 */
public class BaseHexadecimalTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste testbaseHexa.
     */
    public BaseHexadecimalTest() {
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
     * Teste: converter para base hexadecimal um número na base decimal.
     */
    public void testConverterBase1()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals("1", baseHexa1.converteBase(1));
    }
 
    /**
     * Teste: converter para base hexadecimal um número na base decimal.
     */
    public void testConverterBase11()
    {
        echo.BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals("b", baseHexa1.converteBase(11));
    }
    
    /**
     * Teste: converter para base hexadecimal um número na base decimal.
     */
    public void testConverterBase15()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals("f", baseHexa1.converteBase(15));
    }
      
    /**
     * Teste: converter para base hexadecimal um número na base decimal.
     */
    public void testConverterBase111()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals("6f", baseHexa1.converteBase(111));
    }

    /**
     * Teste: converter para base decimal um número na base hexadecimal.
     */
    public void testConverterParaDecimal1()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals(1, baseHexa1.converteBaseParaDecimal("1"));
    }

    /**
     * Teste: converter para base decimal um número na base hexadecimal.
     */
    public void testConverterParaDecimal11()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals(17, baseHexa1.converteBaseParaDecimal("11"));
    }

    /**
     * Teste: converter para base decimal um número na base hexadecimal.
     */
    public void testConverterParaDecimal111()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals(273, baseHexa1.converteBaseParaDecimal("111"));
    }

    /**
     * Teste: converter para base decimal um número na base hexadecimal.
     */
    public void testConverterParaDecimal1111()
    {
        BaseHexadecimal baseHexa1 = new echo.BaseHexadecimal();
        assertEquals(4369, baseHexa1.converteBaseParaDecimal("1111"));
    }
}
