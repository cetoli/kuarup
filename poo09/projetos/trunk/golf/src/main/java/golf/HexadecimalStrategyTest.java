/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe de teste da base hexadecimal.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class HexadecimalStrategyTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TestHexadecimalStrategy
     */
    public HexadecimalStrategyTest() {
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
     * Testa a conversão de 1 em binário para decimal 
     * O retorno esperado é 1
     */
    public void testConversaoDecimalUm(){
        HexadecimalStrategy base = new HexadecimalStrategy();
        assertEquals(1, base.toDecimal("1"));
    }    

    /**
     * Testa a conversão de 11 em binário para decimal 
     * O retorno esperado é 17
     */ 
    public void testConversaoDecimalUmUm(){
        HexadecimalStrategy base = new HexadecimalStrategy();
        assertEquals(17, base.toDecimal("11"));
    }    

    /**
     * Testa a visualização concatenando com D do valor 10 
     * O retorno esperado é H10
     */ 
    public void testDesconversaoHexadecimal() {
        HexadecimalStrategy base = new HexadecimalStrategy();
        assertEquals("0x11", base.getId()+"11");
    }
    
    /**
     * Testa a conversão do valor 11 em Decimal para base Hexadecimal
     * O retorno esperado é 
     */
    public void testDesconversaoParaBaseDecimal() {
        HexadecimalStrategy base = new HexadecimalStrategy();
        assertEquals("B", base.toBase(11));
    }
}
