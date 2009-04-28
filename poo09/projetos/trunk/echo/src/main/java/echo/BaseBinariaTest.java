/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Classe de teste da base bin�ria.
 * @author  Cristiane e Diego Ara�jo
 * @version 0.3 29/03/2007 Cristiane e Diego Ara�jo
 * @since   0.3 Adicionados novos m�todos.
 * @version 0.2 29/03/2007 Cristiane e M�rcio Maia
 * @since   0.2 Adicionados novos m�todos.
 */
public class BaseBinariaTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste BaseBinariaTest.
     */
    public BaseBinariaTest() {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado ap�s cada m�todo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste: converter para base decimal um n�mero na base bin�ria.
     */
    public void testConverterParaDecimal()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals(1, baseBina1.converteBaseParaDecimal("1"));
    }
 
    /**
     * Teste: converter para base decimal um n�mero na base bin�ria.
     */
    public void testConverterParaDecimal1()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals(3, baseBina1.converteBaseParaDecimal("11"));
    }

    /**
     * Teste: converter para base decimal um n�mero na base bin�ria.
     */
    public void testConverterParaDecimal11()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals(7, baseBina1.converteBaseParaDecimal("111"));
    }
    
    /**
     * Teste: converter para base decimal um n�mero na base bin�ria.
     */
    public void testConverterParaDecimal111()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals(15, baseBina1.converteBaseParaDecimal("1111"));
    }
    
    /**
     * Teste: converter para base bin�ria um n�mero na base decimal.
     */
    public void testConverterBase1()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals("1", baseBina1.converteBase(1));
    }

    /**
     * Teste: converter para base bin�ria um n�mero na base decimal.
     */
    public void testConverterBase10()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals("1010", baseBina1.converteBase(10));
    }
    
    /**
     * Teste: converter para base bin�ria um n�mero na base decimal.
     */
    public void testConverteBase11()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals("1011", baseBina1.converteBase(11));
    }
   
    /**
     * Teste: converter para base bin�ria um n�mero na base decimal.
     */
    public void testConverterBase111()
    {
        BaseBinaria baseBina1 = new echo.BaseBinaria();
        assertEquals("1101111", baseBina1.converteBase(111));
    }
}
