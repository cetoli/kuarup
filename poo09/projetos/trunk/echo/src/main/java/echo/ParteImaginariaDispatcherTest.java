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
public class ParteImaginariaDispatcherTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste ParteImaginariaDispatcherTest.
     */
    public ParteImaginariaDispatcherTest() {
    }

    /**
     * Preparacao do caso de teste.
     *
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado ap�s cada m�todo de teste de caso.
     */
    protected void tearDown() {
    }
    
    /**
     * Teste para numeros complexos so com a parte imaginaria.
     */
    public void testComporI25eI125() {
        ComplexoComposite complexo = new ComplexoComposite();
        ParteImaginariaDispatcher dispatcher = new ParteImaginariaDispatcher();
        dispatcher.adicionaParteImaginaria(25, complexo);
        assertEquals(25, complexo.getParteImaginaria().getValor());
        dispatcher.adicionaParteImaginaria(125, complexo);
        assertEquals(125, complexo.getParteImaginaria().getValor());
    }
    
    /**
     * Teste para numeros complexos decimais.
     */
    public void testCompor10I100e100I1000() {
        ComplexoComposite complexo = new ComplexoComposite();
        ParteImaginariaDispatcher dispatcher = new ParteImaginariaDispatcher();
        dispatcher.adicionaParteReal(10, complexo);
        dispatcher.adicionaParteImaginaria(100, complexo);
        assertEquals(100, complexo.getParteImaginaria().getValor());
        dispatcher.adicionaParteReal(100, complexo);
        dispatcher.adicionaParteImaginaria(1000, complexo);
        assertEquals(1000, complexo.getParteImaginaria().getValor());
    }
    
    /**
     * Teste para numeros complexos binarios.
     */
    public void testComporB1IB11eB11IB111() {
        BaseStrategy base = new BaseBinariaStrategy();
        ComplexoComposite complexo = new ComplexoComposite();
        ParteImaginariaDispatcher dispatcher = new ParteImaginariaDispatcher();
        dispatcher.adicionaParteReal(base.converteBaseParaDecimal("1"), complexo);
        dispatcher.adicionaParteImaginaria(base.converteBaseParaDecimal("11"), complexo);
        assertEquals(3, complexo.getParteImaginaria().getValor());
        dispatcher.adicionaParteReal(base.converteBaseParaDecimal("11"), complexo);
        dispatcher.adicionaParteImaginaria(base.converteBaseParaDecimal("111"), complexo);
        assertEquals(7, complexo.getParteImaginaria().getValor());
    }
    
    /**
     * Teste para numeros complexos hexadecimais.
     */
    public void testComporH1IH11eH11IH101() {
        BaseStrategy base = new BaseHexadecimalStrategy();
        ComplexoComposite complexo = new ComplexoComposite();
        ParteImaginariaDispatcher dispatcher = new ParteImaginariaDispatcher();
        dispatcher.adicionaParteReal(base.converteBaseParaDecimal("1"), complexo);
        dispatcher.adicionaParteImaginaria(base.converteBaseParaDecimal("11"), complexo);
        assertEquals(17, complexo.getParteImaginaria().getValor());
        dispatcher.adicionaParteReal(base.converteBaseParaDecimal("11"), complexo);
        dispatcher.adicionaParteImaginaria(base.converteBaseParaDecimal("101"), complexo);
        assertEquals(257, complexo.getParteImaginaria().getValor());
    }
}
