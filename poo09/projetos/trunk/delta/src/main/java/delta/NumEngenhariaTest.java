/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste do operando com notação científica.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class NumEngenhariaTest extends junit.framework.TestCase
{
    /**
     * Construtor default para a classe de teste NuloTest.
     */
    public NumEngenhariaTest() {
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
        NumEngenharia exp = new NumEngenharia(new NumReal(1));
        exp.setParteExponencial(new NumReal(1));
        assertEquals("1N1", exp.mostra());
    }

    /**
     * Teste: MOSTRA NA BASE
     */
    public void testMostraBase() {
        HexadecimalStrategy base = new HexadecimalStrategy();
        NumEngenharia exp = new NumEngenharia(new NumReal(1));
        exp.setParteExponencial(new NumReal(17));
        exp.setBase(base);
        assertEquals("0x1N0x11", exp.mostra());
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
}
