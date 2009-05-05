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
public class ImaginarioCompositeTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste NuloTest.
     */
    public ImaginarioCompositeTest() {
    }

    /**
     * Preparacao do caso de teste.
     *
     * Chamado antes de cada metodo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado apos cada metodo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste: adicionar o numero 5 como parte real.
     */
    public void testAdicionarParteReal5() {
        ImaginarioComposite imaginario1 = new ImaginarioComposite(1);
        RealComposite real2 = new RealComposite(5);
        imaginario1.adicionaParteReal(real2);
        assertEquals(1, imaginario1.getValor());
        assertEquals("I1", imaginario1.mostra(new BaseDecimalStrategy()));
        assertEquals("I0b1", imaginario1.mostra(new BaseBinariaStrategy()));
        assertEquals("I0x1", imaginario1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: adicionar o numero 12 como parte real.
     */
    public void testAdicionarParteReal12() {
        ImaginarioComposite imaginario1 = new ImaginarioComposite(2);
        RealComposite real2 = new RealComposite(12);
        imaginario1.adicionaParteReal(real2);
        assertEquals(2, imaginario1.getValor());
        assertEquals("I2", imaginario1.mostra(new BaseDecimalStrategy()));
        assertEquals("I0b10", imaginario1.mostra(new BaseBinariaStrategy()));
        assertEquals("I0x2", imaginario1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: adicionar o numero 130 como parte real.
     */
    public void testAdicionarParteReal130() {
        ImaginarioComposite imaginario1 = new ImaginarioComposite(5);
        RealComposite real2 = new RealComposite(130);
        imaginario1.adicionaParteReal(real2);
        assertEquals(5, imaginario1.getValor());
        assertEquals("I5", imaginario1.mostra(new BaseDecimalStrategy()));
        assertEquals("I0b101", imaginario1.mostra(new BaseBinariaStrategy()));
        assertEquals("I0x5", imaginario1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: adicionar o numero 5 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria5() {
        ImaginarioComposite imaginario1 = new ImaginarioComposite(10);
        ImaginarioComposite imaginario2 = new ImaginarioComposite(5);
        imaginario1.adicionaParteImaginaria(imaginario2);
        assertEquals(5, imaginario1.getValor());
        assertEquals("I5", imaginario1.mostra(new BaseDecimalStrategy()));
        assertEquals("I0b101", imaginario1.mostra(new BaseBinariaStrategy()));
        assertEquals("I0x5", imaginario1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: adicionar o numero 12 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria12() {
        ImaginarioComposite imaginario1 = new ImaginarioComposite(15);
        ImaginarioComposite imaginario2 = new ImaginarioComposite(12);
        imaginario1.adicionaParteImaginaria(imaginario2);
        assertEquals(12, imaginario1.getValor());
        assertEquals("I12", imaginario1.mostra(new BaseDecimalStrategy()));
        assertEquals("I0b1100", imaginario1.mostra(new BaseBinariaStrategy()));
        assertEquals("I0xC", imaginario1.mostra(new BaseHexadecimalStrategy()));
    }
}
