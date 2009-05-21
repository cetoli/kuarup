/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do operando nulo.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class OperandoNaoPreenchidoTest extends junit.framework.TestCase
{   
    /**
     * Construtor default para a classe de teste RealTest.
     */
    public OperandoNaoPreenchidoTest() {
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
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        BinariaStrategy base = new BinariaStrategy();   
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        nulo.setBase(base);
        assertEquals("0", nulo.mostra());
    }
    
    /**
     * Teste: SOMA NULO+REAL
     */
    public void testSomaNuloEReal() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        assertEquals("17", nulo.soma(new NumReal(17)).mostra());
    }
      
    /**
     * Teste: SOMA NULO+COMPLEXO
     */
    public void testSomaNuloEComplexo() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("4I4", nulo.soma(comp).mostra());
    }
    
    /**
     * Teste: SOMA NULO+EXPONENCIAL
     */
    public void testSomaNuloEExponencial() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", nulo.soma(exp).mostra());
    }
    
    /**
     * Teste: SOMA NULO+VETORIAL
     */
    public void testSomaNuloEVetorial() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        assertEquals("2V1", nulo.soma(vetor).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO NULO-REAL
     */
    public void testSubNuloEReal() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        assertEquals("17", nulo.sub(new NumReal(17)).mostra());
    }
      
    /**
     * Teste: SUBTRAÇÃO NULO-COMPLEXO
     */
    public void testSubNuloEComplexo() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumComplexo comp = new NumComplexo(new NumReal(2));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("2I4", nulo.sub(comp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO NULO-EXPONENCIAL
     */
    public void testSubNuloEExponencial() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", nulo.sub(exp).mostra());
    }
    
    /**
     * Teste: SUBTRAÇÃO NULO-VETORIAL
     */
    public void testSubNuloEVetorial() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(4));
        vetor.entraUm();
        vetor.entraUm();
        assertEquals("4V11", nulo.sub(vetor).mostra());
    }
    
    /**
     * Teste: MULTIPLIÇÃO NULO*REAL
     */
    public void testMultiNuloEReal() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        assertEquals("10", nulo.multi(new NumReal(10)).mostra());
    }
      
    /**
     * Teste: MULTIPLIÇÃO NULO*COMPLEXO
     */
    public void testMultiNuloEComplexo() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumComplexo comp = new NumComplexo(new NumReal(4));
        comp.setParteImaginaria(new NumReal(4));
        assertEquals("4I4", nulo.multi(comp).mostra());
    }
    
    /**
     * Teste: MULTIPLIÇÃO NULO*EXPONENCIAL
     */
    public void testMultiNuloEExponencial() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumEngenharia exp = new NumEngenharia(new NumReal(2));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("2N1", nulo.multi(exp).mostra());
    }
    
    /**
     * Teste: MULTIPLIÇÃO NULO*VETORIAL
     */
    public void testMultiNuloEVetorial() {
        OperandoNaoPreenchido nulo = new OperandoNaoPreenchido();
        assertEquals("0", nulo.mostra());
        NumVetorial vetor = new NumVetorial(new NumReal(2));
        vetor.entraUm();
        assertEquals("2V1", nulo.multi(vetor).mostra());
    }
}
