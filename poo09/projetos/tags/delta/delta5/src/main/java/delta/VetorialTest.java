/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do operando vetorial.
 * @author  Carlos Felippe Cardoso e Andre Sion
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
     * Teste: INSTANCIAR
     */
    public void testInstanciar() {
        NumVetorial vetor = new NumVetorial(new NumReal(1));
        vetor.entraUm();
        assertEquals("1V1", vetor.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        BinariaStrategy base = new BinariaStrategy();   
        NumVetorial vetor = new NumVetorial(new NumReal(3));
        vetor.entraUm();
        vetor.setBase(base);
        assertEquals("0b11V0b1", vetor.mostra());
    }
    
    /**
     * Teste: SOMA VETOR1DREAL+REAL
     */
    public void testSomaVetor1DRealEReal() {
        NumReal vetor = new NumReal(3);
        assertEquals("3", vetor.mostra());
        assertEquals("20", vetor.soma(new NumReal(17)).mostra());
    }
      
    /**
     * Teste: SOMA VETOR1DREAL+COMPLEXO
     */
    public void testSomaVetor1DRealEComplexo() {
        NumReal vetor = new NumReal(2);
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(5));
        assertEquals("6I5", vetor.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA VETOR2DREALREAL+REAL
     */
    public void testSomaVetor2DRealRealEReal() {
        NumVetorial vetor = new NumVetorial(new NumReal(3));
        vetor.entraUm();
        assertEquals("3V1", vetor.mostra());
        vetor.soma(new NumReal(17));
        assertEquals("20V18", vetor.mostra());
    }
      
    /**
     * Teste: SOMA VETOR2DREALEXPOENCIAL+COMPLEXO
     */
    public void testSomaVetor2DRealExponencialEComplexo() {
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        vetor.toExponencial();
        vetor.entraUm();
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(5));
        assertEquals("6I5V1N1I5", vetor.soma(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO VETOR1DREAL-REAL
     */
    public void testSubVetor1DRealEReal() {
        NumReal vetor = new NumReal(17);
        assertEquals("17", vetor.mostra());
        assertEquals("14", vetor.sub(new NumReal(3)).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO VETOR1DREAL-COMPLEXO
     */
    public void testSubVetor1DRealEComplexo() {
        NumReal vetor = new NumReal(6);
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(5));
        assertEquals("2I5", vetor.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO VETOR2DREALREAL-REAL
     */
    public void testSubVetor2DRealRealEReal() {
        NumVetorial vetor = new NumVetorial(new NumReal(5));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("5V11", vetor.mostra());
        vetor.sub(new NumReal(3));
        assertEquals("2V8", vetor.mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO VETOR2DREALEXPOENCIAL-COMPLEXO
     */
    public void testSubVetor2DRealExponencialEComplexo() {
        NumVetorial vetor = new NumVetorial(new NumReal(6));
        vetor.entraUm();
        vetor.toExponencial();
        vetor.entraUm();
        NumComplexo comp = new NumComplexo(new NumReal(1));
        comp.setParteImaginaria(new NumReal(5));
        assertEquals("5I5V1N1I5", vetor.sub(comp).mostra());
    }
}
