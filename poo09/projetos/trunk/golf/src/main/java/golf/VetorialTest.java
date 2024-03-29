/*------------------------------------------------------------------------------
    Copyright � 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

/**
 * Classe de teste do operando vetorial.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class VetorialTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste RealTest.
     */
    public VetorialTest() {
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
        Vetorial vetor = new Vetorial(new Simples(1));
        vetor.entraUm();
        assertEquals("1V1", vetor.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        BinariaStrategy base = new BinariaStrategy();   
        Vetorial vetor = new Vetorial(new Simples(3));
        vetor.entraUm();
        vetor.setBase(base);
        assertEquals("0b11V0b1", vetor.mostra());
    }
    
    /**
     * Teste: SOMA VETOR1DREAL+REAL
     */
    public void testSomaVetor1DRealEReal() {
        Simples vetor = new Simples(3);
        assertEquals("3", vetor.mostra());
        assertEquals("20", vetor.soma(new Simples(17)).mostra());
    }
      
    /**
     * Teste: SOMA VETOR1DREAL+COMPLEXO
     */
    public void testSomaVetor1DRealEComplexo() {
        Simples vetor = new Simples(2);
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(5));
        assertEquals("6I5", vetor.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA VETOR2DREALREAL+REAL
     */
    public void testSomaVetor2DRealRealEReal() {
        Vetorial vetor = new Vetorial(new Simples(3));
        vetor.entraUm();
        assertEquals("3V1", vetor.mostra());
        vetor.soma(new Simples(17));
        assertEquals("20V18", vetor.mostra());
    }
      
    /**
     * Teste: SOMA VETOR2DREALEXPOENCIAL+COMPLEXO
     */
    public void testSomaVetor2DRealExponencialEComplexo() {
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        vetor.toExponencial();
        vetor.entraUm();
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(5));
        assertEquals("6I5V1N1I5", vetor.soma(comp).mostra());
    }
    
    /**
     * Teste: SUBTRA��O VETOR1DREAL-REAL
     */
    public void testSubVetor1DRealEReal() {
        Simples vetor = new Simples(17);
        assertEquals("17", vetor.mostra());
        assertEquals("14", vetor.sub(new Simples(3)).mostra());
    }
      
    /**
     * Teste: SUBTRA��O VETOR1DREAL-COMPLEXO
     */
    public void testSubVetor1DRealEComplexo() {
        Simples vetor = new Simples(6);
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(5));
        assertEquals("2I5", vetor.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRA��O VETOR2DREALREAL-REAL
     */
    public void testSubVetor2DRealRealEReal() {
        Vetorial vetor = new Vetorial(new Simples(5));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("5V11", vetor.mostra());
        vetor.sub(new Simples(3));
        assertEquals("2V8", vetor.mostra());
    }
      
    /**
     * Teste: SUBTRA��O VETOR2DREALEXPOENCIAL-COMPLEXO
     */
    public void testSubVetor2DRealExponencialEComplexo() {
        Vetorial vetor = new Vetorial(new Simples(6));
        vetor.entraUm();
        vetor.toExponencial();
        vetor.entraUm();
        Complexo comp = new Complexo(new Simples(1));
        comp.setParteImaginaria(new Simples(5));
        assertEquals("5I5V1N1I5", vetor.sub(comp).mostra());
    }
}
