/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do Visitor da operação soma do operando.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class SomaVisitorTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste TestSomaVisitor.
     */
    public SomaVisitorTest() {
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
     * Teste: SOMA REAL+REAL
     */
    public void testSomaRealEReal() {
        NumReal real = new NumReal(3);
        assertEquals("20", real.soma(new NumReal(17)).mostra());
    }
      
    /**
     * Teste: SOMA REAL+COMPLEXO
     */
    public void testSomaRealEComplexo() {
        NumReal real = new NumReal(2);
        assertEquals("2", real.mostra());
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("6I4", real.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA REAL+EXPONENCIAL
     */
    public void testSomaRealEExponencial() {
        NumReal real = new NumReal(4);
        assertEquals("4", real.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", real.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA REAL+VETORIAL
     */
    public void testSomaRealEVetorial() {
        NumReal real = new NumReal(4);
        assertEquals("4", real.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        assertEquals("6V5", real.soma(vetor).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+REAL
     */
    public void testSomaComplexoEReal() {
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("4I4", comp.mostra());
        NumReal real = new NumReal(2);
        assertEquals("6I4", real.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+EXPONENCIAL
     */
    public void testSomaComplexoEExponencial() {
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("4I4", comp.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1I4", comp.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+COMPLEXO
     */
    public void testSomaComplexoEComplexo() {
        NumComplexo comp1 = new NumComplexo(new NumReal(5));
        comp1.setParteImaginaria(new NumReal(18));
        assertEquals("5I18", comp1.mostra());
        NumComplexo comp2 = new NumComplexo(new NumReal(7));
        comp2.setParteImaginaria(new NumReal(32));
        assertEquals("7I32", comp2.mostra());
        assertEquals("12I50", comp1.soma(comp2).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+VETORIAL
     */
    public void testSomaComplexoEVetorial() {
        NumComplexo comp = new NumComplexo(new NumReal(2));
        comp.setParteImaginaria(new NumReal(3));
        assertEquals("2I3", comp.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        assertEquals("4I3V3I3", comp.soma(vetor).mostra());
    }
    
    /**
     * Teste: SOMA EXPONENCIAL+REAL
     */
    public void testSomaExponencialEReal() {
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", exp.mostra());
        NumReal real = new NumReal(4);
        assertEquals("2N1", real.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA EXPONENCIAL+EXPONENCIAL
     */
    public void testSomaExponencialEExponencial() {
        NumEngenharia exp1 = new NumEngenharia(new NumReal(5));
        exp1.setParteExponencial(new NumReal(1));
        assertEquals("5N1", exp1.mostra());
        NumEngenharia exp2 = new NumEngenharia(new NumReal(15));
        exp2.setParteExponencial(new NumReal(1));
        assertEquals("15N1", exp2.mostra());
        assertEquals("20N1", exp1.soma(exp2).mostra());
    }
      
    /**
     * Teste: SOMA EXPONENCIAL+COMPLEXO
     */
    public void testSomaExponencialEComplexo() {
        NumEngenharia exp = new NumEngenharia(new NumReal(5));
        exp.setParteExponencial(new NumReal(1));
        NumComplexo comp = new NumComplexo(new NumReal(2));
        comp.setParteImaginaria(new NumReal(2));
        assertEquals("5N1I2", exp.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXOEXPONENCIAL+COMPLEXO
     */
    public void testSomaComplexoExponencialEComplexo() {
        NumComplexo comp1 = new NumComplexo(new NumReal(1));
        comp1.setParteImaginaria(new NumEngenharia(new NumReal(1)));
        comp1.getParteImaginaria().setParteExponencial(new NumReal(1));
        assertEquals("1I1N1", comp1.mostra());
        NumComplexo comp2 = new NumComplexo(new NumReal(1));
        comp2.setParteImaginaria(new NumReal(1));
        assertEquals("1I1", comp2.mostra());
        assertEquals("2I1N1", comp1.soma(comp2).mostra());
    }
    
    /**
     * Teste: SOMA EXPONENCIAL+VETORIAL
     */
    public void testSomaExponencialEVetorial() {
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", exp.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        assertEquals("2N1V2N1", exp.soma(vetor).mostra());
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
}
