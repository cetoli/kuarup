/*------------------------------------------------------------------------------
    Copyright © 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Incluídas as funcionalidades: números com notação científica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Incluídas as funcionalidades: números complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
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
     * Teste: INSTANCIAR
     */
    public void testInstanciar() {
        Imaginario imaginario = new Imaginario(1);
        assertEquals(1, imaginario.getValor());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        Imaginario imaginario = new Imaginario(17);
        Hexadecimal base = new Hexadecimal();
        assertEquals("I0x11", imaginario.mostra(base));
    }
    
    /**
     * Teste: SOMA IMAGINÁRIO+IMAGINÁRIO
     */
    public void testSoma() {
        Imaginario imaginario = new Imaginario(5);
        imaginario.soma(new Imaginario(38));
        assertEquals(43, imaginario.getValor());
    }
      
    /**
     * Teste: SOMA IMAGINÁRIO+COMPLEXO
     */
    public void testSomaImaginarioEComplexo() {
        Imaginario imag1 = new Imaginario(2);
        assertEquals(2, imag1.getValor());
        Real real2 = new Real(4);
        Imaginario imag2 = new Imaginario(5);
        Complexo comp2 = new Complexo();
        comp2.adicionaParteReal(real2);
        comp2.adicionaParteImaginaria(imag2);
        imag1.soma(comp2);
        assertEquals(7, imag1.getValor());
    }
    
    /**
     * Teste: SOMA COMPLEXO+COMPLEXO
     */
    public void testSomaComplexoEComplexo() {
        Decimal base = new Decimal();
        Complexo comp1 = new Complexo();
        Real real1 = new Real(2);
        Imaginario imag1 = new Imaginario(3);
        comp1.adicionaParteReal(real1);
        comp1.adicionaParteImaginaria(imag1);
        assertEquals("2I3", comp1.mostra(base));
        Complexo comp2 = new Complexo();
        Real real2 = new Real(4);
        Imaginario imag2 = new Imaginario(5);
        comp2.adicionaParteReal(real2);
        comp2.adicionaParteImaginaria(imag2);
        comp1.soma(comp2);
        assertEquals("6I8", comp1.mostra(base));
    }
}
