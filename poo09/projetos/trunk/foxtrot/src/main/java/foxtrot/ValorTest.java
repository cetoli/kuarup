package foxtrot;



/**
 * Classe ValorTest para testar a classe Valor.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */ 
public class ValorTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class ValorTest.
     */
    public ValorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /**
     * Testa a conversao de um valor decimal para o tipo do Valor. 
     * No caso, será decimal também. Suas subclasses é que terão
     * retorno em formato diferente.
     */
    public void testConversaoValorDecimal()
    {
        foxtrot.Valor valor1 = new foxtrot.Valor(40);
        assertEquals(40, valor1.getValor());
    }

    /**
     * Testa o método de limpeza do valor.
     */
    public void testLimparValor()
    {
        foxtrot.Valor valor1 = new foxtrot.Valor(21);
        assertEquals("0", valor1.limparValor());
        assertEquals(0, valor1.getValor());
    }

    /**
     * Teste de insercao de digitos.
     */
    public void testAdicionarDigito()
    {
        foxtrot.Valor valor1 = new foxtrot.Valor();
        assertEquals("1", valor1.adicionarDigito("1"));
        assertEquals("11", valor1.adicionarDigito("1"));
        assertEquals("111", valor1.adicionarDigito("1"));
    }

    /**
     * testa o método setValor e a conversao que este faz para a 
     * representacao escolhida.
     */
    public void testSetValor()
    {
        foxtrot.Valor valor1 = new foxtrot.Valor();
        valor1.setValor("11");
        assertEquals(11, valor1.getValor());
    }
    
    /**
     * Testa a conversao para String.
     */
    public void testConverterEmString()
    {
        foxtrot.Valor valor1 = new foxtrot.Valor(1234);
        assertEquals("1234", valor1.converterEmString());
    }
    
    /**
     * Testa a soma de 2 valores.
     */
    public void testSomar()
    {
        foxtrot.Valor valor1 = new foxtrot.Valor(13);
        foxtrot.Valor valor2 = new foxtrot.Valor(12);
        valor1.somar(valor2);
        assertEquals("25", valor1.converterEmString());
    }
}






