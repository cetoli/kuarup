/*-----------------------------------------------------------------------------
    Copyright 2002-2006          Carlo E. T. Oliveira et all
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
public class RealCompositeTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste RealCompositeTest.
     */
    public RealCompositeTest() {
    }

    /**
     * Preparacao do caso de teste.
     *
     * Chamado antes de cada mutodo de caso de teste.
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
     * Teste: adicionar o numero 5 como parte real.
     */
    public void testAdicionarParteReal5() {
        RealComposite real1 = new RealComposite(1);
        RealComposite real2 = new RealComposite(5);
        real1.adicionaParteReal(real2);
        assertEquals(5, real1.getValor());
        assertEquals("5", real1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b101", real1.mostra(new BaseBinariaStrategy()));
        assertEquals("0x5", real1.mostra(new BaseHexadecimalStrategy()));
    }
    
    /**
     * Teste: adicionar o numero 12 como parte real.
     */
    public void testAdicionarParteReal12() {
        RealComposite real1 = new RealComposite(2);
        RealComposite real2 = new RealComposite(12);
        real1.adicionaParteReal(real2);
        assertEquals(12, real1.getValor());
        assertEquals("12", real1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b1100", real1.mostra(new BaseBinariaStrategy()));
        assertEquals("0xC", real1.mostra(new BaseHexadecimalStrategy()));
    }
    
    /**
     * Teste: adicionar o numero 5 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria5() {
        RealComposite real1 = new RealComposite(10);
        ImaginarioComposite real2 = new ImaginarioComposite(5);
        real1.adicionaParteImaginaria(real2);
        assertEquals(10, real1.getValor());
        assertEquals("10", real1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b1010", real1.mostra(new BaseBinariaStrategy()));
        assertEquals("0xA", real1.mostra(new BaseHexadecimalStrategy()));
    }
    
    /**
     * Teste: adicionar o numero 12 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria12() {
        RealComposite real1 = new RealComposite(15);
        ImaginarioComposite real2 = new ImaginarioComposite(12);
        real1.adicionaParteImaginaria(real2);
        assertEquals(15, real1.getValor());
        assertEquals("15", real1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b1111", real1.mostra(new BaseBinariaStrategy()));
        assertEquals("0xF", real1.mostra(new BaseHexadecimalStrategy()));
    }
    
    /**
     * Teste: adicionar o numero 130 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria130() {
        RealComposite real1 = new RealComposite(30);
        ImaginarioComposite real2 = new ImaginarioComposite(130);
        real1.adicionaParteImaginaria(real2);
        assertEquals(30, real1.getValor());
        assertEquals("30", real1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b11110", real1.mostra(new BaseBinariaStrategy()));
        assertEquals("0x1E", real1.mostra(new BaseHexadecimalStrategy()));
    }
}
