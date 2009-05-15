/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe de teste da base decimal.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class DecimalStrategyTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TestDecimalStrategy
     */
    public DecimalStrategyTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown() {
    }
 
    /**
     * Testa a conversão de 1 em decimal para decimal 
     * O retorno esperado é 1
     */
    public void testConversaoDecimalUm(){
        DecimalStrategy base = new DecimalStrategy();
        assertEquals(1, base.toDecimal("1"));
    }

    /**
     * Testa a conversão de 1 em decimal para decimal 
     * O retorno esperado é 11
     */
    public void testConversaoDecimalUmUm(){
        DecimalStrategy base = new DecimalStrategy();
        assertEquals(11, base.toDecimal("11"));
    }    
     
    /**
     * Testa a visualização concatenando com D do valor 10 
     * O retorno esperado é D10
     */
    public void testDesconversaoDecimal() {
        DecimalStrategy base = new DecimalStrategy();
        assertEquals("10", base.getId()+"10");
    }
    
    /**
     * Testa a conversão para base decimal 
     * O retorno esperado é D10
     */
    public void testDesconversaoParaBaseDecimal() {
        DecimalStrategy base = new DecimalStrategy();
        assertEquals("10", base.toBase(10));
    }
}
