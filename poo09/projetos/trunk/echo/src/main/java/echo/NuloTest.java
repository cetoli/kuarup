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
public class NuloTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste NuloTest
     */
    public NuloTest() {
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
     * Teste: Soma nulo com nulo.
     */
    public void testeNuloSomaNulo()
    {
        Nulo nulo1 = new Nulo();
        Nulo nulo2 = new Nulo();
        nulo1.soma(new Nulo());
        assertEquals(0, nulo1.getValor());
        assertEquals("", nulo1.mostra(new BaseDecimal()));
        assertEquals("", nulo1.mostra(new BaseBinaria()));
        assertEquals("", nulo1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: Soma nulo com parte real.
     */
    public void testeNuloSomaReal0()
    {
        Nulo nulo1 = new Nulo();
        Real real1 = new Real(0);
        nulo1.soma(new Real(0));
        assertEquals(0, nulo1.getValor());
        assertEquals("", nulo1.mostra(new BaseDecimal()));
        assertEquals("", nulo1.mostra(new BaseBinaria()));
        assertEquals("", nulo1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: Soma nulo com parte real.
     */
    public void testeNuloSomaReal10()
    {
        Nulo nulo1 = new Nulo();
        Real real1 = new Real(10);
        real1.soma(new Nulo());
        assertEquals(10, real1.getValor());
        assertEquals("10", real1.mostra(new BaseDecimal()));
        assertEquals("0b1010", real1.mostra(new BaseBinaria()));
        assertEquals("0xa", real1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: Soma nulo com parte imaginária.
     */
    public void testeNuloSomaImaginario0()
    {
        Nulo nulo1 = new Nulo();
        Imaginario imaginario1 = new Imaginario(0);
        nulo1.soma(new Imaginario(0));
        assertEquals(0, nulo1.getValor());
        assertEquals("", nulo1.mostra(new BaseDecimal()));
        assertEquals("", nulo1.mostra(new BaseBinaria()));
        assertEquals("", nulo1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: Soma nulo com parte imaginária.
     */
    public void testeNuloSomaImaginario10()
    {
        Nulo nulo1 = new Nulo();
        Imaginario imaginario1 = new Imaginario(10);
        imaginario1.soma(new Nulo());
        assertEquals(10, imaginario1.getValor());
        assertEquals("I10", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b1010", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0xa", imaginario1.mostra(new BaseHexadecimal()));
    }
    
}
