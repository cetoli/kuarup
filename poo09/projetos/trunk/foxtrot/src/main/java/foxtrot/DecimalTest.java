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
public class DecimalTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class DecimalTest
     */
    public DecimalTest()
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
     * Testa a conversão de 1 em decimal para decimal 
     * O retorno esperado é 1
     */
    public void testConversaoDecimalUm(){
        Decimal base = new Decimal();
        assertEquals(1, base.toDecimal("1"));
    }

    /**
     * Testa a conversão de 1 em decimal para decimal 
     * O retorno esperado é 11
     */
    public void testConversaoDecimalUmUm(){
        Decimal base = new Decimal();
        assertEquals(11, base.toDecimal("11"));
    }    
     
    /**
     * Testa a visualização concatenando com D do valor 10 
     * O retorno esperado é D10
     */
    public void testDesconversaoDecimal() {
        Decimal base = new Decimal();
        assertEquals("10", base.getId()+"10");
    }
    
    /**
     * Testa a conversão para base decimal 
     * O retorno esperado é D10
     */
    public void testDesconversaoParaBaseDecimal() {
        Decimal base = new Decimal();
        assertEquals("10", base.toBase(10));
    }
}
