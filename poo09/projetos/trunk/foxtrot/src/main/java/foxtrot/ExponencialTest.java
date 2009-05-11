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
public class ExponencialTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste NuloTest.
     */
    public ExponencialTest() {
    }

    /**
     * Prepara��o do caso de teste.
     *
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado ap�s cada m�todo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste: INSTANCIAR
     */
    public void testInstanciar() {
        Exponencial exponencial = new Exponencial(1);
        assertEquals(1, exponencial.getValor());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        Exponencial exponencial = new Exponencial(17);
        Hexadecimal base = new Hexadecimal();
        assertEquals("N0x11", exponencial.mostra(base));
    }
    
    /**
     * Teste: SOMA EXPONENCIAL+EXPONENCIAL
     */
    public void testSoma() {
        Exponencial exponencial = new Exponencial(5);
        exponencial.soma(new Exponencial(15));
        assertEquals(5, exponencial.getValor());
    }
      
    /**
     * Teste: SOMA EXPONENCIAL+COMPLEXO
     */
    public void testSomaExponencialEComplexo() {
        Exponencial exponencial = new Exponencial(5);
        assertEquals(5, exponencial.getValor());
        Real real2 = new Real(4);
        Imaginario imag2 = new Imaginario(5);
        Complexo comp2 = new Complexo();
        comp2.adicionaParteReal(real2);
        comp2.adicionaParteImaginaria(imag2);
        exponencial.soma(comp2);
        assertEquals(5, exponencial.getValor());
    }
}
