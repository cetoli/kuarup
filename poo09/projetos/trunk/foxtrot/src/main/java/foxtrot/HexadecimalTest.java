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
public class HexadecimalTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste testbaseHexa
     */
    public HexadecimalTest() {
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
    public void testConversaoDecimalUm(){
        Hexadecimal base = new Hexadecimal();
        assertEquals(1, base.toDecimal("1"));
    }    

    /**
     * Testa a conversão de 11 em binário para decimal 
     * O retorno esperado é 17
     */ 
    public void testConversaoDecimalUmUm(){
        Hexadecimal base = new Hexadecimal();
        assertEquals(17, base.toDecimal("11"));
    }    

    /**
     * Testa a visualização concatenando com D do valor 10 
     * O retorno esperado é H10
     */ 
    public void testDesconversaoHexadecimal() {
        Hexadecimal base = new Hexadecimal();
        assertEquals("0x11", base.getId()+"11");
    }
    
    /**
     * Testa a conversão do valor 11 em Decimal para base Hexadecimal
     * O retorno esperado é 
     */
    public void testDesconversaoParaBaseDecimal() {
        Hexadecimal base = new Hexadecimal();
        assertEquals("B", base.toBase(11));
    }
}
