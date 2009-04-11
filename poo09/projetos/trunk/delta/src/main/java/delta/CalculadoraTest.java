/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package charlie;

/**
 * Classe que testa o funcionamento da calculadora.
 *
 * @author Diego Ara�jo e Helmar
 * @version 1.0
 * @since 1.0 (24/03/2007):
 *    1 - Montagem de quatro testes para cada m�todo existente na 
 *    classe claculadora.
 *    1.1 - Teste do m�todo entraUm() da classe Calculadora:
 *      Simula o acionamento da tecla "um" da calculadora de um a 
 *      quatro vezes e verifica se o resultado do acionamento est� 
 *      sendo visualizado no display.
 *    1.2 - Teste do m�todo limpa() da classe Calculadora:
 *      Simula o acionamento da tecla "limpa" da calculadora de um a 
 *      quatro vezes e verifica se o resultado do acionamento est� 
 *      sendo visualizado no display.
 *    1.3 - Teste do m�todo comandoSoma() da classe Calculadora:
 *      Simula o acionamento da tecla "soma" da calculadora de um a 
 *      quatro vezes e verifica se o resultado do acionamento est� 
 *      sendo visualizado no display.
 * */
public class CalculadoraTest extends junit.framework.TestCase {
    
    private Calculadora calculadora;

    /**
     * Construtor para objetos da classe CalculadoraTest.
     * 
     * */
    public CalculadoraTest() {
    }

    // Testes para o m�todo EntraUm
    /**
     * 1� Teste para EntraUm
     * Caso: digitar o n�mero 1 
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 1.
     * */
    public void testeEntraUmDigitar1() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("1", calculadora.getDisplay());
    }
    
    /**
     * 2� Teste para EntraUm
     * Caso: digitar o n�mero 11
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 11.
     * */
    public void testeEntraUmDigitar11() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("11", calculadora.getDisplay());
    }

    /**
     * 3� Teste para EntraUm
     * Caso: digitar o n�mero 111
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 111.
     * */
    public void testeEntraUmDigitar111() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("111", calculadora.getDisplay());
    }

    /**
     * 4� Teste para EntraUm
     * Caso: digitar o n�mero 1111
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 1111.
     * */
    public void testeEntraUmDigitar1111() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("1111", calculadora.getDisplay());
    }
    
    // Testes para o m�todo Limpa
    /**
     * 1� Teste para Limpa
     * Caso: clicar em limpar. 
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 0.
     * */
     public void testeLimpaLimpar() {
         calculadora = new Calculadora();
         calculadora.limpa();
         assertEquals("0", calculadora.getDisplay());
    }
    
    /**
     * 2� Teste para Limpa
     * Caso: digitar o n�mero 1 e clicar em limpar. 
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 0.
     * */
    public void testeLimpaDigitar1Limpar() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.limpa();
        assertEquals("0", calculadora.getDisplay());
    }
    
    /**
     * 3� Teste para Limpa
     * Caso: digitar o n�mero 11 e clicar em limpar. 
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 0.
     * */
    public void testeLimpaDigitar11Limpar() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.limpa();
        assertEquals("0", calculadora.getDisplay());
    }
    
    /**
     * 4� Teste para Limpa
     * 
     * Caso: somar 1 + 1 e clicar em limpar. 
     * Confere o resultado do m�todo com o valor esperado no display: 0.
     * */
    public void testeLimpaSomar1e1Limpar() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.limpa();
        assertEquals("0", calculadora.getDisplay());
    }
    
    // Testes para o m�todo ComandoSoma
    /**
     * 1� Teste para ComandoSoma
     * 
     * Caso: clicar em somar.
     * Confere o resultado do m�todo com o valor esperado no display: 0.
     * */
    public void testeComandoSomaSomar() {
        calculadora = new Calculadora();
        calculadora.comandoSoma();
        assertEquals("0", calculadora.getDisplay()); 
    }
    
    /**
     * 2� Teste para ComandoSoma
     * Caso: digitar n�mero 1 e clicar em somar.
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 1.
     * */
    public void testeComandoSomaDigitar1Somar() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("1", calculadora.getDisplay()); 
    }
    
    /**
     * 3� Teste para ComandoSoma
     * Caso: somar 1 + 11
     * 
     * Confere o resultado do m�todo com o valor esperado no display: 12.
     * */
    public void testeComandoSomaSomar1e11() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("12", calculadora.getDisplay());
    }
    
    /**
     * 4� Teste para ComandoSoma
     * Caso: somar 11 + 1111.
     * 
     * Confere o resultado do m�todo com o valor esperado no display 1122.
     * */
    public void testeComandoSomaSomar11e1111() {
        calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("1122", calculadora.getDisplay()); 
    }
    
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp(){
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown() {
    }
}