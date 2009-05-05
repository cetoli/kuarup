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
public class ComplexoTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste ComplexoTest.
     */
    public ComplexoTest() {
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
        Decimal base = new Decimal();
        Complexo complexo = new Complexo();
        complexo.adicionaParteReal(new Real(0));
        complexo.adicionaParteImaginaria(new Imaginario(0));
        assertEquals("0I0", complexo.mostra(base));
    }
    
    /**
     * Teste: INSTANCIAR 2
     */
    public void testInstanciar2() {
        Decimal base = new Decimal();
        Complexo complexo = new Complexo();
        complexo.adicionaParteReal(new Real(3));
        complexo.adicionaParteImaginaria(new Imaginario(111));
        assertEquals("3I111", complexo.mostra(base));
    }
    
    /**
     * Teste: MOSTRAR NA BASE
     */
    public void testMostraBase()
    {
        Hexadecimal base = new Hexadecimal();
        Complexo complexo = new Complexo();
        Real real = new Real(5);
        Imaginario imag = new Imaginario(18);
        complexo.adicionaParteReal(real);
        complexo.adicionaParteImaginaria(imag);
        assertEquals("0x5I0x12", complexo.mostra(base));
    }
    
    /**
     * Teste: SOMA COMPLEXO+COMPLEXO
     */
    public void testSomaComplexoEComplexo() {
        Decimal base = new Decimal();
        Complexo complexo1 = new Complexo();
        Real real1 = new Real(5);
        Imaginario imag1 = new Imaginario(18);
        complexo1.adicionaParteReal(real1);
        complexo1.adicionaParteImaginaria(imag1);
        Complexo complexo2 = new Complexo();
        Real real2 = new Real(7);
        Imaginario imag2 = new Imaginario(32);
        complexo2.adicionaParteReal(real2);
        complexo2.adicionaParteImaginaria(imag2);
        complexo1.soma(complexo2);
        assertEquals("12I50", complexo1.mostra(base));
    }
    
    /**
     * Teste: SOMA COMPLEXO+COMPLEXO 2
     */
    public void testSomaComplexoEComplexo2() {
        Decimal base = new Decimal();
        Complexo complexo1 = new Complexo();
        Real real1 = new Real(1);
        Imaginario imag1 = new Imaginario(1);
        complexo1.adicionaParteReal(real1);
        complexo1.adicionaParteImaginaria(imag1);
        Complexo complexo2 = new Complexo();
        Real real2 = new Real(1);
        Imaginario imag2 = new Imaginario(1);
        complexo2.adicionaParteReal(real2);
        complexo2.adicionaParteImaginaria(imag2);
        complexo1.soma(complexo2);
        assertEquals("2I2", complexo1.mostra(base));
    }
}
