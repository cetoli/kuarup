/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

/**
 * Classe de teste da base binária.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class BinariaStrategyTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TestBinariaStrategy
     */
    public BinariaStrategyTest() {
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
    public void testConversaoDecimalUm() {
        BinariaStrategy base = new BinariaStrategy();
        assertEquals(1, base.toDecimal("1"));
    }    
    
    /**
     * Testa a conversão de 11 em binário para decimal 
     * O retorno esperado é 3
     */ 
    public void testConversaoDecimalUmUm(){
        BinariaStrategy base = new BinariaStrategy();
        assertEquals(3, base.toDecimal("11"));
    }   
    
    /**
     * Testa a visualização concatenando com D do valor 10 
     * O retorno esperado é B10
     */
    public void testDesconversaoBinario() {
        BinariaStrategy base = new BinariaStrategy(); 
        assertEquals("0b1010", base.getId()+"1010");
    }
    
    /**
     * Testa a conversão do valor 11 em Decimal para base Binária 
     * O retorno esperado é 1011
     */
    public void testDesconversaoParaBaseDecimal() {
        BinariaStrategy base = new BinariaStrategy();
        assertEquals("1011", base.toBase(11));
    }    
}
