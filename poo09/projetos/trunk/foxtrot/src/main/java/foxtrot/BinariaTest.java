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
public class BinariaTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class BinariaTest
     */
    public BinariaTest()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Testa a conversão de 1 em binário para decimal 
     * O retorno esperado é 1
     */
    public void testConversaoDecimalUm() {
        Binaria base = new Binaria();
        assertEquals(1, base.toDecimal("1"));
    }    
    
    /**
     * Testa a conversão de 11 em binário para decimal 
     * O retorno esperado é 3
     */ 
    public void testConversaoDecimalUmUm(){
        Binaria base = new Binaria();
        assertEquals(3, base.toDecimal("11"));
    }   
    
    /**
     * Testa a visualização concatenando com D do valor 10 
     * O retorno esperado é B10
     */
    public void testDesconversaoBinario() {
        Binaria base = new Binaria(); 
        assertEquals("0b1010", base.getId()+"1010");
    }
    
    /**
     * Testa a conversão do valor 11 em Decimal para base Binária 
     * O retorno esperado é 1011
     */
    public void testDesconversaoParaBaseDecimal() {
        Binaria base = new Binaria();
        assertEquals("1011", base.toBase(11));
    }    
}
