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
public class CompositorParteRealTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste CompositorParteRealTest.
     */
    public CompositorParteRealTest() {
    }

    /**
     * Chamado antes de cada metodo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado apus cada mutodo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste para numeros complexos so com a parte real.
     */
    public void testCompor25e125() {
        Complexo complexo = new Complexo();
        CompositorParteReal compositor = new CompositorParteReal();
        compositor.adicionaParteReal(25, complexo);
        assertEquals(25, complexo.getParteReal().getValor());
        compositor.adicionaParteReal(125, complexo);
        assertEquals(125, complexo.getParteReal().getValor());
    }

    /**
     * Teste para numeros complexos decimais
     */
    public void testCompor10I100e100I1000() {
        Complexo complexo = new Complexo();
        CompositorParteReal compositor = new CompositorParteReal();
        compositor.adicionaParteReal(10, complexo);
        compositor.adicionaParteImaginaria(100, complexo);
        assertEquals(10, complexo.getParteReal().getValor());
        compositor.adicionaParteReal(100, complexo);
        compositor.adicionaParteImaginaria(1000, complexo);
        assertEquals(100, complexo.getParteReal().getValor());
    }

    /**
     * Teste para numeros complexos binarios
     */
    public void testComporB1IB11eB11IB111() {
        Base base = new BaseBinaria();
        Complexo complexo = new Complexo();
        CompositorParteReal compositor = new CompositorParteReal();
        compositor.adicionaParteReal(base.converteBaseParaDecimal("1"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("11"), complexo);
        assertEquals(1, complexo.getParteReal().getValor());
        compositor.adicionaParteReal(base.converteBaseParaDecimal("11"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("111"), complexo);
        assertEquals(3, complexo.getParteReal().getValor());
    }

    /**
     * Teste para numeros complexos binarios
     */
    public void testComporH1IH11eH11IH101() {
        Base base = new BaseHexadecimal();
        Complexo complexo = new Complexo();
        CompositorParteReal compositor = new CompositorParteReal();
        compositor.adicionaParteReal(base.converteBaseParaDecimal("1"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("11"), complexo);
        assertEquals(1, complexo.getParteReal().getValor());
        compositor.adicionaParteReal(base.converteBaseParaDecimal("11"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("101"), complexo);
        assertEquals(17, complexo.getParteReal().getValor());
    }
}
