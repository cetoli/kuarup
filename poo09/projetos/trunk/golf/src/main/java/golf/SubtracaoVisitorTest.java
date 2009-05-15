/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

/**
 * Classe de teste do Visitor da operação subtração do operando.
 * @author  Gustavo Taveira e Thiago Silva de Souza
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
        Simples real = new Simples(3);
        assertEquals("-14", real.sub(new Simples(17)).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO REAL-COMPLEXO
     */
    public void testSubRealEComplexo() {
        Simples real = new Simples(4);
        assertEquals("4", real.mostra());
        Complexo comp = new Complexo(new Simples(2));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("2I4", real.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO REAL-EXPONENCIAL
     */
    public void testSubRealEExponencial() {
        Simples real = new Simples(4);
        assertEquals("4", real.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("-2N1", real.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO REAL-VETORIAL
     */
    public void testSubRealEVetorial() {
        Simples real = new Simples(2);
        assertEquals("2", real.mostra());
        Vetorial vetor = new Vetorial(new Simples(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("-2V-9", real.sub(vetor).mostra());
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
    
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-REAL
     */
    public void testSubExponencialEReal() {
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", exp.mostra());
        Simples real = new Simples(4);
        assertEquals("-2N1", real.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-EXPONENCIAL
     */
    public void testSubExponencialEExponencial() {
        Exponencial exp1 = new Exponencial(new Simples(5));
        exp1.setParteExponencial(new Simples(1));
        assertEquals("5N1", exp1.mostra());
        Exponencial exp2 = new Exponencial(new Simples(15));
        exp2.setParteExponencial(new Simples(1));
        assertEquals("15N1", exp2.mostra());
        assertEquals("-10N1", exp1.sub(exp2).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-COMPLEXO
     */
    public void testSubExponencialEComplexo() {
        Exponencial exp = new Exponencial(new Simples(5));
        exp.setParteExponencial(new Simples(1));
        Complexo comp = new Complexo(new Simples(2));
        comp.setParteImaginaria(new Simples(2));
        assertEquals("5N1I2", exp.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO COMPLEXOEXPONENCIAL-COMPLEXO
     */
    public void testSubComplexoExponencialEComplexo() {
        Complexo comp1 = new Complexo(new Simples(1));
        comp1.setParteImaginaria(new Exponencial(new Simples(1)));
        comp1.getParteImaginaria().setParteExponencial(new Simples(1));
        assertEquals("1I1N1", comp1.mostra());
        Complexo comp2 = new Complexo(new Simples(1));
        comp2.setParteImaginaria(new Simples(1));
        assertEquals("1I1", comp2.mostra());
        assertEquals("0I1N1", comp1.sub(comp2).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO EXPONENCIAL-VETORIAL
     */
    public void testSubExponencialEVetorial() {
        Exponencial exp = new Exponencial(new Simples(4));
        exp.setParteExponencial(new Simples(1));
        assertEquals("4N1", exp.mostra());
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("4N1V3N1", exp.sub(vetor).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO VETOR1DREAL-REAL
     */
    public void testSubVetor1DRealEReal() {
        Simples vetor = new Simples(17);
        assertEquals("17", vetor.mostra());
        assertEquals("14", vetor.sub(new Simples(3)).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO VETOR1DREAL-COMPLEXO
     */
    public void testSubVetor1DRealEComplexo() {
        Simples vetor = new Simples(6);
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(5));
        assertEquals("2I5", vetor.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO VETOR2DREALREAL-REAL
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
     * Teste: SUBTRAÇÃO VETOR2DREALEXPOENCIAL-COMPLEXO
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
