/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

/**
 * Classe de teste do Visitor da operação soma do operando.
 * @author  Gustavo Taveira e Thiago Silva de Souza
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
        Simples real = new Simples(3);
        assertEquals("20", real.soma(new Simples(17)).mostra());
    }
      
    /**
     * Teste: SOMA REAL+COMPLEXO
     */
    public void testSomaRealEComplexo() {
        Simples real = new Simples(2);
        assertEquals("2", real.mostra());
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("6I4", real.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA REAL+EXPONENCIAL
     */
    public void testSomaRealEExponencial() {
        Simples real = new Simples(4);
        assertEquals("4", real.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", real.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA REAL+VETORIAL
     */
    public void testSomaRealEVetorial() {
        Simples real = new Simples(4);
        assertEquals("4", real.mostra());
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        assertEquals("6V5", real.soma(vetor).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXO+REAL
     */
    public void testSomaComplexoEReal() {
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("4I4", comp.mostra());
        Simples real = new Simples(2);
        assertEquals("6I4", real.soma(comp).mostra());
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
     * Teste: SOMA EXPONENCIAL+REAL
     */
    public void testSomaExponencialEReal() {
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", exp.mostra());
        Simples real = new Simples(4);
        assertEquals("2N1", real.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA EXPONENCIAL+EXPONENCIAL
     */
    public void testSomaExponencialEExponencial() {
        Exponencial exp1 = new Exponencial(new Simples(5));
        exp1.setParteExponencial(new Simples(1));
        assertEquals("5N1", exp1.mostra());
        Exponencial exp2 = new Exponencial(new Simples(15));
        exp2.setParteExponencial(new Simples(1));
        assertEquals("15N1", exp2.mostra());
        assertEquals("20N1", exp1.soma(exp2).mostra());
    }
      
    /**
     * Teste: SOMA EXPONENCIAL+COMPLEXO
     */
    public void testSomaExponencialEComplexo() {
        Exponencial exp = new Exponencial(new Simples(5));
        exp.setParteExponencial(new Simples(1));
        Complexo comp = new Complexo(new Simples(2));
        comp.setParteImaginaria(new Simples(2));
        assertEquals("5N1I2", exp.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA COMPLEXOEXPONENCIAL+COMPLEXO
     */
    public void testSomaComplexoExponencialEComplexo() {
        Complexo comp1 = new Complexo(new Simples(1));
        comp1.setParteImaginaria(new Exponencial(new Simples(1)));
        comp1.getParteImaginaria().setParteExponencial(new Simples(1));
        assertEquals("1I1N1", comp1.mostra());
        Complexo comp2 = new Complexo(new Simples(1));
        comp2.setParteImaginaria(new Simples(1));
        assertEquals("1I1", comp2.mostra());
        assertEquals("2I1N1", comp1.soma(comp2).mostra());
    }
    
    /**
     * Teste: SOMA EXPONENCIAL+VETORIAL
     */
    public void testSomaExponencialEVetorial() {
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", exp.mostra());
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        assertEquals("2N1V2N1", exp.soma(vetor).mostra());
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
}
