/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com números complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Thiago Silva de Souza)  $Author$
 * @version (3.0)    $Revision$ (28/04/09)      $Date$
 * @since   (3.0) Suporte a números complexos
 */
public class ComplexoTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste ComplexoTest.
     */
    public ComplexoTest() {
    }

    /**
     * Preparação do caso de teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado após cada método de teste de caso.
     */
    protected void tearDown() {
    }
    
    /**
     * Teste: adicionar o número 11 como parte real.
     */
    public void testAdicionarParteReal11()
	{
		Complexo operando1 = new Complexo();
		Real operando2 = new Real(11);
		operando1.adicionaParteReal(operando2);
		assertEquals(11, operando1.getParteReal().getValor());
	}
	
	/**
     * Teste: adicionar o número 101 como parte real.
     */
	public void testAdicionarParteReal101()
	{
		Complexo operando1 = new Complexo();
		Real operando2 = new Real(101);
		operando1.adicionaParteReal(operando2);
		assertEquals(101, operando1.getParteReal().getValor());
	}
	
	/**
     * Teste: adicionar o número 1101 como parte real.
     */
	public void testAdicionarParteReal1101()
	{
		Complexo operando1 = new Complexo();
		Real operando2 = new Real(1101);
		operando1.adicionaParteReal(operando2);
		assertEquals(1101, operando1.getParteReal().getValor());
	}
	
	/**
     * Teste: adicionar o número 11 como parte imaginária.
     */
	public void testAdicionarParteImaginaria11()
	{
		Complexo operando1 = new Complexo();
		Imaginario operando2 = new Imaginario(11);
		operando1.adicionaParteImaginaria(operando2);
		assertEquals(11, operando1.getParteImaginaria().getValor());
	}
	
	/**
     * Teste: adicionar o número 101 como parte imaginária.
     */
	public void testAdicionarParteImaginaria101()
	{
		Complexo operando1 = new Complexo();
		Imaginario operando2 = new Imaginario(101);
		operando1.adicionaParteImaginaria(operando2);
		assertEquals(101, operando1.getParteImaginaria().getValor());
	}
	
	/**
     * Teste: adicionar o número 1101 como parte imaginária.
     */
	public void testAdicionarParteImaginaria1101()
	{
		Complexo operando1 = new Complexo();
		Imaginario operando2 = new Imaginario(1101);
		operando1.adicionaParteImaginaria(operando2);
		assertEquals(1101, operando1.getParteImaginaria().getValor());
	}

	/**
     * Teste: somar 12I24 e 1I115 
     */
	public void testSoma12I24e1I115()
	{
		Complexo operando1 = new Complexo();
		Real operando2 = new Real(12);
		Imaginario operando3 = new Imaginario(24);
		operando1.adicionaParteReal(operando2);
		operando1.adicionaParteImaginaria(operando3);
		Complexo operando4 = new Complexo();
		Real operando5 = new Real(1);
		Imaginario operando6 = new Imaginario(115);
		operando4.adicionaParteReal(operando5);
		operando4.adicionaParteImaginaria(operando6);
		operando1.soma(operando4);
		Imaginario operando7 = (Imaginario)operando1.getParteImaginaria();
		assertEquals(139, operando7.getValor());
		Real operando8 = (Real)operando1.getParteReal();
		assertEquals(13, operando8.getValor());
		assertEquals("13I139", operando1.mostra(new BaseDecimal()));
		assertEquals("0b1101I0b10001011", operando1.mostra(new BaseBinaria()));
		assertEquals("0xdI0x8b", operando1.mostra(new BaseHexadecimal()));
	}
	
	/**
     * Teste: somar 111I10 e 101I11
     */
	public void testSoma111I10e101I11()
	{
		Complexo operando1 = new Complexo();
		Real operando2 = new Real(111);
		Imaginario operando3 = new Imaginario(10);
		operando1.adicionaParteReal(operando2);
		operando1.adicionaParteImaginaria(operando3);
		Complexo operando4 = new Complexo();
		Real operando5 = new Real(101);
		Imaginario operando6 = new Imaginario(11);
		operando4.adicionaParteReal(operando5);
		operando4.adicionaParteImaginaria(operando6);
		operando1.soma(operando4);
		Imaginario operando7 = (Imaginario)operando1.getParteImaginaria();
		assertEquals(21, operando7.getValor());
		Real operando8 = (Real)operando1.getParteReal();
		assertEquals(212, operando8.getValor());
		assertEquals("212I21", operando1.mostra(new BaseDecimal()));
		assertEquals("0b11010100I0b10101", operando1.mostra(new BaseBinaria()));
		assertEquals("0xd4I0x15", operando1.mostra(new BaseHexadecimal()));
	}
	
	/**
     * Teste: somar 85I24 e 9I13
     */
	public void testSoma85I24e9I13()
	{
		Complexo operando1 = new Complexo();
		Real operando2 = new Real(85);
		Imaginario operando3 = new Imaginario(24);
		operando1.adicionaParteReal(operando2);
		operando1.adicionaParteImaginaria(operando3);
		Complexo operando4 = new Complexo();
		Real operando5 = new Real(9);
		Imaginario operando6 = new Imaginario(13);
		operando4.adicionaParteReal(operando5);
		operando4.adicionaParteImaginaria(operando6);
		operando1.soma(operando4);
		Imaginario operando7 = (Imaginario)operando1.getParteImaginaria();
		assertEquals(37, operando7.getValor());
		Real operando8 = (Real)operando1.getParteReal();
		assertEquals(94, operando8.getValor());
		assertEquals("94I37", operando1.mostra(new BaseDecimal()));
		assertEquals("0b1011110I0b100101", operando1.mostra(new BaseBinaria()));
		assertEquals("0x5eI0x25", operando1.mostra(new BaseHexadecimal()));
	}
}
