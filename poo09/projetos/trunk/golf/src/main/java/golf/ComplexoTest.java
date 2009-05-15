/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

/**
 * Classe de teste do operando complexo.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
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
     * Teste: INSTANCIAR
     */
    public void testInstanciar() {
        Complexo comp = new Complexo(new Simples(1));
        comp.setParteImaginaria(new Simples(1));
        assertEquals("1I1", comp.mostra());
    }
    
    /**
     * Teste: MOSTRAR NA BASE
     */
    public void testMostraBase() {
        HexadecimalStrategy base = new HexadecimalStrategy();
        Complexo comp = new Complexo(new Simples(5));
        comp.setParteImaginaria(new Simples(18));
        comp.setBase(base);
        assertEquals("0x5I0x12", comp.mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+REAL
     */
    public void testSomaComplexoEReal() {
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("4I4", comp.mostra());
        Simples real = new Simples(2);
        assertEquals("6I4", comp.soma(real).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+EXPONENCIAL
     */
    public void testSomaComplexoEExponencial() {
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("4I4", comp.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1I4", comp.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+COMPLEXO
     */
    public void testSomaComplexoEComplexo() {
        Complexo comp1 = new Complexo(new Simples(5));
        comp1.setParteImaginaria(new Simples(18));
        assertEquals("5I18", comp1.mostra());
        Complexo comp2 = new Complexo(new Simples(7));
        comp2.setParteImaginaria(new Simples(32));
        assertEquals("7I32", comp2.mostra());
        assertEquals("12I50", comp1.soma(comp2).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+VETORIAL
     */
    public void testSomaComplexoEVetorial() {
        Complexo comp = new Complexo(new Simples(2));
        comp.setParteImaginaria(new Simples(3));
        assertEquals("2I3", comp.mostra());
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        assertEquals("4I3V3I3", comp.soma(vetor).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-REAL
     */
    public void testSubComplexoEReal() {
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(2));
        assertEquals("4I2", comp.mostra());
        Simples real = new Simples(4);
        assertEquals("0I2", real.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-EXPONENCIAL
     */
    public void testSubComplexoEExponencial() {
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("4I4", comp.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("-2N1I4", comp.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-COMPLEXO
     */
    public void testSubComplexoEComplexo() {
        Complexo comp1 = new Complexo(new Simples(7));
        comp1.setParteImaginaria(new Simples(50));
        assertEquals("7I50", comp1.mostra());
        Complexo comp2 = new Complexo(new Simples(5));
        comp2.setParteImaginaria(new Simples(18));
        assertEquals("5I18", comp2.mostra());
        assertEquals("2I32", comp1.sub(comp2).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXO-VETORIAL
     */
    public void testSubComplexoEVetorial() {
        Complexo comp = new Complexo(new Simples(2));
        comp.setParteImaginaria(new Simples(3));
        assertEquals("2I3", comp.mostra());
        Vetorial vetor = new Vetorial(new Simples(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("-2I3V-9I3", comp.sub(vetor).mostra());
    }
}
