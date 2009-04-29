/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
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
public class ImaginarioTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste NuloTest.
     */
    public ImaginarioTest() {
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
     * Teste: adicionar o número 5 como parte real.
     */
    public void testAdicionarParteReal5()
    {
        Imaginario imaginario1 = new Imaginario(1);
        Real real2 = new Real(5);
        imaginario1.adicionaParteReal(real2);
        assertEquals(1, imaginario1.getValor());
        assertEquals("I1", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b1", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0x1", imaginario1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o número 12 como parte real.
     */
    public void testAdicionarParteReal12()
    {
        Imaginario imaginario1 = new Imaginario(2);
        Real real2 = new Real(12);
        imaginario1.adicionaParteReal(real2);
        assertEquals(2, imaginario1.getValor());
        assertEquals("I2", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b10", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0x2", imaginario1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o número 130 como parte real.
     */
    public void testAdicionarParteReal130()
    {
        Imaginario imaginario1 = new Imaginario(5);
        Real real2 = new Real(130);
        imaginario1.adicionaParteReal(real2);
        assertEquals(5, imaginario1.getValor());
        assertEquals("I5", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b101", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0x5", imaginario1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o número 5 como parte imaginária.
     */
    public void testAdicionarParteImaginaria5()
    {
        Imaginario imaginario1 = new Imaginario(10);
        Imaginario imaginario2 = new Imaginario(5);
        imaginario1.adicionaParteImaginaria(imaginario2);
        assertEquals(10, imaginario1.getValor());
        assertEquals("I10", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b1010", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0xa", imaginario1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o número 12 como parte imaginária.
     */
    public void testAdicionarParteImaginaria12()
    {
        Imaginario imaginario1 = new Imaginario(15);
        Imaginario imaginario2 = new Imaginario(12);
        imaginario1.adicionaParteImaginaria(imaginario2);
        assertEquals(15, imaginario1.getValor());
        assertEquals("I15", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b1111", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0xf", imaginario1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o número 130 como parte imaginária.
     */
    public void testAdicionarParteImaginaria130()
    {
        Imaginario imaginario1 = new Imaginario(30);
        Imaginario imaginario2 = new Imaginario(130);
        imaginario1.adicionaParteImaginaria(imaginario2);
        assertEquals(30, imaginario1.getValor());
        assertEquals("I30", imaginario1.mostra(new BaseDecimal()));
        assertEquals("I0b11110", imaginario1.mostra(new BaseBinaria()));
        assertEquals("I0x1e", imaginario1.mostra(new BaseHexadecimal()));
    }
}
