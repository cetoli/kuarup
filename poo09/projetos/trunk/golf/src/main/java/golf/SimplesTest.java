/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

/**
 * Classe de teste do operando simples.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class SimplesTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste RealTest.
     */
    public SimplesTest() {
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
        Simples real = new Simples(1);
        assertEquals("1", real.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        BinariaStrategy base = new BinariaStrategy();   
        Simples real = new Simples(3);
        real.setBase(base);
        assertEquals("0b11", real.mostra());
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
}
