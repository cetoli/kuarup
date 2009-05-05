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
public class RealTest extends junit.framework.TestCase {
    /**
     * Construtor default para a classe de teste RealTest.
     */
    public RealTest() {
    }

    /**
     * Preparauuo do caso de teste.
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
        Real real1 = new Real(1);
        Real real2 = new Real(5);
        real1.adicionaParteReal(real2);
        assertEquals(1, real1.getValor());
        assertEquals("1", real1.mostra(new BaseDecimal()));
        assertEquals("0b1", real1.mostra(new BaseBinaria()));
        assertEquals("0x1", real1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o numero 12 como parte real.
     */
    public void testAdicionarParteReal12() {
        Real real1 = new Real(2);
        Real real2 = new Real(12);
        real1.adicionaParteReal(real2);
        assertEquals(2, real1.getValor());
        assertEquals("2", real1.mostra(new BaseDecimal()));
        assertEquals("0b10", real1.mostra(new BaseBinaria()));
        assertEquals("0x2", real1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o numero 130 como parte real.
     */
    public void testAdicionarParteReal130() {
        Real real1 = new Real(5);
        Real real2 = new Real(130);
        real1.adicionaParteReal(real2);
        assertEquals(5, real1.getValor());
        assertEquals("5", real1.mostra(new BaseDecimal()));
        assertEquals("0b101", real1.mostra(new BaseBinaria()));
        assertEquals("0x5", real1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o numero 5 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria5() {
        Real real1 = new Real(10);
        Imaginario real2 = new Imaginario(5);
        real1.adicionaParteImaginaria(real2);
        assertEquals(10, real1.getValor());
        assertEquals("10", real1.mostra(new BaseDecimal()));
        assertEquals("0b1010", real1.mostra(new BaseBinaria()));
        assertEquals("0xa", real1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o numero 12 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria12() {
        Real real1 = new Real(15);
        Imaginario real2 = new Imaginario(12);
        real1.adicionaParteImaginaria(real2);
        assertEquals(15, real1.getValor());
        assertEquals("15", real1.mostra(new BaseDecimal()));
        assertEquals("0b1111", real1.mostra(new BaseBinaria()));
        assertEquals("0xf", real1.mostra(new BaseHexadecimal()));
    }
    
    /**
     * Teste: adicionar o numero 130 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria130() {
        Real real1 = new Real(30);
        Imaginario real2 = new Imaginario(130);
        real1.adicionaParteImaginaria(real2);
        assertEquals(30, real1.getValor());
        assertEquals("30", real1.mostra(new BaseDecimal()));
        assertEquals("0b11110", real1.mostra(new BaseBinaria()));
        assertEquals("0x1e", real1.mostra(new BaseHexadecimal()));
    }
}
