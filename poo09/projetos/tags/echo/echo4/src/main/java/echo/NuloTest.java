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
public class NuloTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste NuloTest
     */
    public NuloTest() {
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
     * Chamado apus cada metodo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste: Soma nulo com nulo.
     */
    public void testeNuloSomaNulo() {
        Nulo nulo1 = new Nulo();
        Nulo nulo2 = new Nulo();
        nulo1.soma(new Nulo());
        assertEquals(0, nulo1.getValor());
        assertEquals("", nulo1.mostra(new BaseDecimalStrategy()));
        assertEquals("", nulo1.mostra(new BaseBinariaStrategy()));
        assertEquals("", nulo1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: Soma nulo com parte real.
     */
    public void testeNuloSomaReal0() {
        Nulo nulo1 = new Nulo();
        RealComposite real1 = new RealComposite(0);
        nulo1.soma(new RealComposite(0));
        assertEquals(0, nulo1.getValor());
        assertEquals("", nulo1.mostra(new BaseDecimalStrategy()));
        assertEquals("", nulo1.mostra(new BaseBinariaStrategy()));
        assertEquals("", nulo1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: Soma nulo com parte real.
     */
    public void testeNuloSomaReal10() {
        Nulo nulo1 = new Nulo();
        RealComposite real1 = new RealComposite(10);
        real1.soma(new Nulo());
        assertEquals(10, real1.getValor());
        assertEquals("10", real1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b1010", real1.mostra(new BaseBinariaStrategy()));
        assertEquals("0xA", real1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: Soma nulo com parte imaginaria.
     */
    public void testeNuloSomaImaginario0() {
        Nulo nulo1 = new Nulo();
        ImaginarioComposite imaginario1 = new ImaginarioComposite(0);
        nulo1.soma(new ImaginarioComposite(0));
        assertEquals(0, nulo1.getValor());
        assertEquals("", nulo1.mostra(new BaseDecimalStrategy()));
        assertEquals("", nulo1.mostra(new BaseBinariaStrategy()));
        assertEquals("", nulo1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: Soma nulo com parte imaginaria.
     */
    public void testeNuloSomaImaginario10() {
        Nulo nulo1 = new Nulo();
        ImaginarioComposite imaginario1 = new ImaginarioComposite(10);
        imaginario1.soma(new Nulo());
        assertEquals(10, imaginario1.getValor());
        assertEquals("I10", imaginario1.mostra(new BaseDecimalStrategy()));
        assertEquals("I0b1010", imaginario1.mostra(new BaseBinariaStrategy()));
        assertEquals("I0xA", imaginario1.mostra(new BaseHexadecimalStrategy()));
    }
}
