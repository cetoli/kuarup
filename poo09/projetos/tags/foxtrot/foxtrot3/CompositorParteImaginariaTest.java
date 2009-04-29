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
 */
public class CompositorParteImaginariaTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste CompositorParteImaginariaTest.
     */
    public CompositorParteImaginariaTest() {
    }

    /**
     * Preparação do caso de teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado após cada método de teste de caso.
     */
    protected void tearDown() {
    }
    
    /**
     * Teste para números complexos só com a parte imaginária.
     */
    public void testComporI25eI125()
    {
        Complexo complexo = new Complexo();
        CompositorParteImaginaria compositor = new CompositorParteImaginaria();
        compositor.adicionaParteImaginaria(25, complexo);
        assertEquals(25, complexo.getParteImaginaria().getValor());
        compositor.adicionaParteImaginaria(125, complexo);
        assertEquals(125, complexo.getParteImaginaria().getValor());
    }
    
    /**
     * Teste para números complexos decimais.
     */
    public void testCompor10I100e100I1000()
    {
        Complexo complexo = new Complexo();
        CompositorParteImaginaria compositor = new CompositorParteImaginaria();
        compositor.adicionaParteReal(10, complexo);
        compositor.adicionaParteImaginaria(100, complexo);
        assertEquals(100, complexo.getParteImaginaria().getValor());
        compositor.adicionaParteReal(100, complexo);
        compositor.adicionaParteImaginaria(1000, complexo);
        assertEquals(1000, complexo.getParteImaginaria().getValor());
    }
    
    /**
     * Teste para números complexos binários.
     */
    public void testComporB1IB11eB11IB111()
    {
        Base base = new BaseBinaria();
        Complexo complexo = new Complexo();
        CompositorParteImaginaria compositor = new CompositorParteImaginaria();
        compositor.adicionaParteReal(base.converteBaseParaDecimal("1"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("11"), complexo);
        assertEquals(3, complexo.getParteImaginaria().getValor());
        compositor.adicionaParteReal(base.converteBaseParaDecimal("11"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("111"), complexo);
        assertEquals(7, complexo.getParteImaginaria().getValor());
    }
    
    /**
     * Teste para números complexos hexadecimais.
     */
    public void testComporH1IH11eH11IH101()
    {
        Base base = new BaseHexadecimal();
        Complexo complexo = new Complexo();
        CompositorParteImaginaria compositor = new CompositorParteImaginaria();
        compositor.adicionaParteReal(base.converteBaseParaDecimal("1"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("11"), complexo);
        assertEquals(17, complexo.getParteImaginaria().getValor());
        compositor.adicionaParteReal(base.converteBaseParaDecimal("11"), complexo);
        compositor.adicionaParteImaginaria(base.converteBaseParaDecimal("101"), complexo);
        assertEquals(257, complexo.getParteImaginaria().getValor());
    }
}
