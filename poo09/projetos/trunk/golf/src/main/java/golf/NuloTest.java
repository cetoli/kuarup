/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe de teste do operando nulo.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class NuloTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste RealTest.
     */
    public NuloTest() {
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
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        BinariaStrategy base = new BinariaStrategy();   
        Nulo nulo = new Nulo();
        nulo.setBase(base);
        assertEquals("0", nulo.mostra());
    }
    
    /**
     * Teste: SOMA NULO+REAL
     */
    public void testSomaNuloEReal() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        assertEquals("17", nulo.soma(new Simples(17)).mostra());
    }
      
    /**
     * Teste: SOMA NULO+COMPLEXO
     */
    public void testSomaNuloEComplexo() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("4I4", nulo.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA NULO+EXPONENCIAL
     */
    public void testSomaNuloEExponencial() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", nulo.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA NULO+VETORIAL
     */
    public void testSomaNuloEVetorial() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        assertEquals("2V1", nulo.soma(vetor).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO NULO-REAL
     */
    public void testSubNuloEReal() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        assertEquals("17", nulo.sub(new Simples(17)).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO NULO-COMPLEXO
     */
    public void testSubNuloEComplexo() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Complexo comp = new Complexo(new Simples(2));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("2I4", nulo.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO NULO-EXPONENCIAL
     */
    public void testSubNuloEExponencial() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", nulo.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO NULO-VETORIAL
     */
    public void testSubNuloEVetorial() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Vetorial vetor = new Vetorial(new Simples(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("4V11", nulo.sub(vetor).mostra());
    }
    
    /**
     * Teste: MULTIPLIÇÃO NULO*REAL
     */
    public void testMultiNuloEReal() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        assertEquals("10", nulo.multi(new Simples(10)).mostra());
    }
      
    /**
     * Teste: MULTIPLIÇÃO NULO*COMPLEXO
     */
    public void testMultiNuloEComplexo() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Complexo comp = new Complexo(new Simples(4));
        comp.setParteImaginaria(new Simples(4));
        assertEquals("4I4", nulo.multi(comp).mostra());
    }
    
    /**
     * Teste: MULTIPLIÇÃO NULO*EXPONENCIAL
     */
    public void testMultiNuloEExponencial() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Exponencial exp = new Exponencial(new Simples(2));
        exp.setParteExponencial(new Simples(1));
        assertEquals("2N1", nulo.multi(exp).mostra());
    }
    
    /**
     * Teste: MULTIPLIÇÃO NULO*VETORIAL
     */
    public void testMultiNuloEVetorial() {
        Nulo nulo = new Nulo();
        assertEquals("0", nulo.mostra());
        Vetorial vetor = new Vetorial(new Simples(2));
        vetor.entraUm();
        assertEquals("2V1", nulo.multi(vetor).mostra());
    }
}
