/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do Visitor da operação subtração do operando.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class SubtracaoVisitorTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste TestSomaVisitor.
     */
    public SubtracaoVisitorTest() {
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
     * Teste: SUBTRAÇÃO REAL-REAL
     */
    public void testSubRealEReal() {
        NumReal real = new NumReal(3);
        assertEquals("-14", real.sub(new NumReal(17)).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO REAL-COMPLEXO
     */
    public void testSubRealEComplexo() {
        NumReal real = new NumReal(4);
        assertEquals("4", real.mostra());
        NumComplexo comp = new NumComplexo(new NumReal(2));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("2I4", real.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO REAL-EXPONENCIAL
     */
    public void testSubRealEExponencial() {
        NumReal real = new NumReal(4);
        assertEquals("4", real.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("-2N1", real.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO REAL-VETORIAL
     */
    public void testSubRealEVetorial() {
        NumReal real = new NumReal(2);
        assertEquals("2", real.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("-2V-9", real.sub(vetor).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-REAL
     */
    public void testSubComplexoEReal() {
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(2));
        assertEquals("4I2", comp.mostra());
        NumReal real = new NumReal(4);
        assertEquals("0I2", real.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-EXPONENCIAL
     */
    public void testSubComplexoEExponencial() {
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("4I4", comp.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("-2N1I4", comp.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-COMPLEXO
     */
    public void testSubComplexoEComplexo() {
        NumComplexo comp1 = new NumComplexo(new NumReal(7));
        comp1.setParteImaginaria(new NumReal(50));
        assertEquals("7I50", comp1.mostra());
        NumComplexo comp2 = new NumComplexo(new NumReal(5));
        comp2.setParteImaginaria(new NumReal(18));
        assertEquals("5I18", comp2.mostra());
        assertEquals("2I32", comp1.sub(comp2).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-VETORIAL
     */
    public void testSubComplexoEVetorial() {
        NumComplexo comp = new NumComplexo(new NumReal(2));
        comp.setParteImaginaria(new NumReal(3));
        assertEquals("2I3", comp.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("-2I3V-9I3", comp.sub(vetor).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-REAL
     */
    public void testSubExponencialEReal() {
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", exp.mostra());
        NumReal real = new NumReal(4);
        assertEquals("-2N1", real.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-EXPONENCIAL
     */
    public void testSubExponencialEExponencial() {
        NumEngenharia exp1 = new NumEngenharia(new NumReal(5));
        exp1.setParteExponencial(new NumReal(1));
        assertEquals("5N1", exp1.mostra());
        NumEngenharia exp2 = new NumEngenharia(new NumReal(15));
        exp2.setParteExponencial(new NumReal(1));
        assertEquals("15N1", exp2.mostra());
        assertEquals("-10N1", exp1.sub(exp2).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-COMPLEXO
     */
    public void testSubExponencialEComplexo() {
        NumEngenharia exp = new NumEngenharia(new NumReal(5));
        exp.setParteExponencial(new NumReal(1));
        NumComplexo comp = new NumComplexo(new NumReal(2));
        comp.setParteImaginaria(new NumReal(2));
        assertEquals("5N1I2", exp.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXOEXPONENCIAL-COMPLEXO
     */
    public void testSubComplexoExponencialEComplexo() {
        NumComplexo comp1 = new NumComplexo(new NumReal(1));
        comp1.setParteImaginaria(new NumEngenharia(new NumReal(1)));
        comp1.getParteImaginaria().setParteExponencial(new NumReal(1));
        assertEquals("1I1N1", comp1.mostra());
        NumComplexo comp2 = new NumComplexo(new NumReal(1));
        comp2.setParteImaginaria(new NumReal(1));
        assertEquals("1I1", comp2.mostra());
        assertEquals("0I1N1", comp1.sub(comp2).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-VETORIAL
     */
    public void testSubExponencialEVetorial() {
        NumEngenharia exp = new NumEngenharia(new NumReal(4));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("4N1", exp.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("4N1V3N1", exp.sub(vetor).mostra());
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
