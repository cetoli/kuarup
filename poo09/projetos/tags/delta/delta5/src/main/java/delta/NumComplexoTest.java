/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do operando complexo.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumComplexoTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste NumComplexoTest.
     */
    public NumComplexoTest() {
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
        NumComplexo comp = new NumComplexo(new NumReal(1));
        comp.setParteImaginaria(new NumReal(1));
        assertEquals("1I1", comp.mostra());
    }
    
    /**
     * Teste: MOSTRAR NA BASE
     */
    public void testMostraBase() {
        HexadecimalStrategy base = new HexadecimalStrategy();
        NumComplexo comp = new NumComplexo(new NumReal(5));
        comp.setParteImaginaria(new NumReal(18));
        comp.setBase(base);
        assertEquals("0x5I0x12", comp.mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+REAL
     */
    public void testSomaComplexoEReal() {
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("4I4", comp.mostra());
        NumReal real = new NumReal(2);
        assertEquals("6I4", comp.soma(real).mostra());
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
}
