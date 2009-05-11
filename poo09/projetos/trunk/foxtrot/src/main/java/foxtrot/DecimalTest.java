/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
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
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }
 
    /**
     * Tears down the test fixture.
     *
     * Chamado ap�s cada m�todo de teste de caso.
     */
    protected void tearDown() {
    }
 
    /**
     * Testa a convers�o de 1 em decimal para decimal 
     * O retorno esperado � 1
     */
    public void testConversaoDecimalUm(){
        Decimal base = new Decimal();
        assertEquals(1, base.toDecimal("1"));
    }

    /**
     * Testa a convers�o de 1 em decimal para decimal 
     * O retorno esperado � 11
     */
    public void testConversaoDecimalUmUm(){
        Decimal base = new Decimal();
        assertEquals(11, base.toDecimal("11"));
    }    
     
    /**
     * Testa a visualiza��o concatenando com D do valor 10 
     * O retorno esperado � D10
     */
    public void testDesconversaoDecimal() {
        Decimal base = new Decimal();
        assertEquals("10", base.getId()+"10");
    }
    
    /**
     * Testa a convers�o para base decimal 
     * O retorno esperado � D10
     */
    public void testDesconversaoParaBaseDecimal() {
        Decimal base = new Decimal();
        assertEquals("10", base.toBase(10));
    }
}
