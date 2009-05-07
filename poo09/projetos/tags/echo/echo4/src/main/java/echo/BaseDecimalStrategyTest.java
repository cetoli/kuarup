/*-----------------------------------------------------------------------------
  Copyright 2002-2006        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
-----------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com numeros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */
public class BaseDecimalStrategyTest extends junit.framework.TestCase {
    /**
     * Construtor default para a classe de teste BaseDecimalTest.
     */
    public BaseDecimalStrategyTest() {
    }

    /**
     * Chamado antes de cada metodo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado apos cada metodo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterBase0() {
        BaseDecimalStrategy baseDeci1 = new BaseDecimalStrategy();
        assertEquals("0", baseDeci1.converteBase(0));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterBase1() {
        BaseDecimalStrategy baseDeci1 = new BaseDecimalStrategy();
        assertEquals("1", baseDeci1.converteBase(1));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterBasel11() {
        BaseDecimalStrategy baseDeci1 = new echo.BaseDecimalStrategy();
        assertEquals("11", baseDeci1.converteBase(11));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterBasel111() {
        BaseDecimalStrategy baseDeci1 = new echo.BaseDecimalStrategy();
        assertEquals("111", baseDeci1.converteBase(111));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterParaDecimal1() {
        BaseDecimalStrategy baseDeci1 = new echo.BaseDecimalStrategy();
        assertEquals(1, baseDeci1.converteBaseParaDecimal("1"));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterParaDecimal11() {
        BaseDecimalStrategy baseDeci1 = new BaseDecimalStrategy();
        assertEquals(11, baseDeci1.converteBaseParaDecimal("11"));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterParaDecimal111() {
        BaseDecimalStrategy baseDeci1 = new echo.BaseDecimalStrategy();
        assertEquals(111, baseDeci1.converteBaseParaDecimal("111"));
    }

    /**
     * Teste: converter para base decimal um numero na base decimal.
     */
    public void testConverterParaDecimal1111() {
        BaseDecimalStrategy baseDeci1 = new echo.BaseDecimalStrategy();
        assertEquals(1111, baseDeci1.converteBaseParaDecimal("1111"));
    }
}
