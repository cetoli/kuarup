/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Andre de Abrantes
 * @version 5.0 12/05/2009 Carlos Eduardo e Andre de Abrantes
 * @since   4.0 Inclu�das as funcionalidades: numeros vetoriais e subtracao
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   3.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   2.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   1.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
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
     * Testa a convers�o de 1 em bin�rio para decimal 
     * O retorno esperado � 1
     */
    public void testConversaoDecimalUm() {
        Binaria base = new Binaria();
        assertEquals(1, base.toDecimal("1"));
    }    
    
    /**
     * Testa a convers�o de 11 em bin�rio para decimal 
     * O retorno esperado � 3
     */ 
    public void testConversaoDecimalUmUm(){
        Binaria base = new Binaria();
        assertEquals(3, base.toDecimal("11"));
    }   
    
    /**
     * Testa a visualiza��o concatenando com D do valor 10 
     * O retorno esperado � B10
     */
    public void testDesconversaoBinario() {
        Binaria base = new Binaria(); 
        assertEquals("0b1010", base.getId()+"1010");
    }
    
    /**
     * Testa a convers�o do valor 11 em Decimal para base Bin�ria 
     * O retorno esperado � 1011
     */
    public void testDesconversaoParaBaseDecimal() {
        Binaria base = new Binaria();
        assertEquals("1011", base.toBase(11));
    }    
}
