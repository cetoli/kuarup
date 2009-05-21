/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do operando simples.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumRealTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste RealTest.
     */
    public NumRealTest() {
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
        NumReal real = new NumReal(1);
        assertEquals("1", real.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        BinariaStrategy base = new BinariaStrategy();   
        NumReal real = new NumReal(3);
        real.setBase(base);
        assertEquals("0b11", real.mostra());
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
    public void testSomaRealENumVetorial() {
        NumReal real = new NumReal(4);
        assertEquals("4", real.mostra());
        NumVetorial vetor= new NumVetorial(new NumReal(2));
        vetor.entraUm();
        assertEquals("6V5", real.soma(vetor).mostra());
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
        NumVetorial vetor= new NumVetorial(new NumReal(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("-2V-9", real.sub(vetor).mostra());
    }
}
