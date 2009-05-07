/*-----------------------------------------------------------------------------
    Copyright 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
-----------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com numeros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */
public class ComplexoCompositeTest extends junit.framework.TestCase {

    /**
     * Construtor default para a classe de teste ComplexoCompositeTest.
     */
    public ComplexoCompositeTest() {
    }

    /**
     * Preparauuo do caso de teste.
     *
     * Chamado antes de cada metodo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado apus cada metodo de teste de caso.
     */
    protected void tearDown() {
    }

    /**
     * Teste: adicionar o numero 11 como parte real.
     */
    public void testAdicionarParteReal11() {
        ComplexoComposite operando1 = new ComplexoComposite();
        RealComposite operando2 = new RealComposite(11);
        operando1.adicionaParteReal(operando2);
        assertEquals(11, operando1.getParteReal().getValor());
    }

    /**
     * Teste: adicionar o numero 101 como parte real.
     */
    public void testAdicionarParteReal101() {
        ComplexoComposite operando1 = new ComplexoComposite();
        RealComposite operando2 = new RealComposite(101);
        operando1.adicionaParteReal(operando2);
        assertEquals(101, operando1.getParteReal().getValor());
    }

    /**
     * Teste: adicionar o numero 1101 como parte real.
     */
    public void testAdicionarParteReal1101() {
        ComplexoComposite operando1 = new ComplexoComposite();
        RealComposite operando2 = new RealComposite(1101);
        operando1.adicionaParteReal(operando2);
        assertEquals(1101, operando1.getParteReal().getValor());
    }

    /**
     * Teste: adicionar o numero 11 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria11() {
        ComplexoComposite operando1 = new ComplexoComposite();
        ImaginarioComposite operando2 = new ImaginarioComposite(11);
        operando1.adicionaParteImaginaria(operando2);
        assertEquals(11, operando1.getParteImaginaria().getValor());
    }

    /**
     * Teste: adicionar o numero 101 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria101() {
        ComplexoComposite operando1 = new ComplexoComposite();
        ImaginarioComposite operando2 = new ImaginarioComposite(101);
        operando1.adicionaParteImaginaria(operando2);
        assertEquals(101, operando1.getParteImaginaria().getValor());
    }

    /**
     * Teste: adicionar o numero 1101 como parte imaginaria.
     */
    public void testAdicionarParteImaginaria1101() {
        ComplexoComposite operando1 = new ComplexoComposite();
        ImaginarioComposite operando2 = new ImaginarioComposite(1101);
        operando1.adicionaParteImaginaria(operando2);
        assertEquals(1101, operando1.getParteImaginaria().getValor());
    }

    /**
     * Teste: somar 12I24 e 1I115 
     */
    public void testSoma12I24e1I115() {
        ComplexoComposite operando1 = new ComplexoComposite();
        RealComposite operando2 = new RealComposite(12);
        ImaginarioComposite operando3 = new ImaginarioComposite(24);
        operando1.adicionaParteReal(operando2);
        operando1.adicionaParteImaginaria(operando3);
        ComplexoComposite operando4 = new ComplexoComposite();
        RealComposite operando5 = new RealComposite(1);
        ImaginarioComposite operando6 = new ImaginarioComposite(115);
        operando4.adicionaParteReal(operando5);
        operando4.adicionaParteImaginaria(operando6);
        operando1.soma(operando4);
        ImaginarioComposite operando7 = (ImaginarioComposite)operando1.getParteImaginaria();
        assertEquals(139, operando7.getValor());
        RealComposite operando8 = (RealComposite)operando1.getParteReal();
        assertEquals(13, operando8.getValor());
        assertEquals("13I139", operando1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b1101I0b10001011", operando1.mostra(new BaseBinariaStrategy()));
        assertEquals("0xDI0x8B", operando1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: somar 111I10 e 101I11
     */
    public void testSoma111I10e101I11() {
        ComplexoComposite operando1 = new ComplexoComposite();
        RealComposite operando2 = new RealComposite(111);
        ImaginarioComposite operando3 = new ImaginarioComposite(10);
        operando1.adicionaParteReal(operando2);
        operando1.adicionaParteImaginaria(operando3);
        ComplexoComposite operando4 = new ComplexoComposite();
        RealComposite operando5 = new RealComposite(101);
        ImaginarioComposite operando6 = new ImaginarioComposite(11);
        operando4.adicionaParteReal(operando5);
        operando4.adicionaParteImaginaria(operando6);
        operando1.soma(operando4);
        ImaginarioComposite operando7 = (ImaginarioComposite)operando1.getParteImaginaria();
        assertEquals(21, operando7.getValor());
        RealComposite operando8 = (RealComposite)operando1.getParteReal();
        assertEquals(212, operando8.getValor());
        assertEquals("212I21", operando1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b11010100I0b10101", operando1.mostra(new BaseBinariaStrategy()));
        assertEquals("0xD4I0x15", operando1.mostra(new BaseHexadecimalStrategy()));
    }

    /**
     * Teste: somar 85I24 e 9I13
     */
    public void testSoma85I24e9I13() {
        ComplexoComposite operando1 = new ComplexoComposite();
        RealComposite operando2 = new RealComposite(85);
        ImaginarioComposite operando3 = new ImaginarioComposite(24);
        operando1.adicionaParteReal (operando2);
        operando1.adicionaParteImaginaria(operando3);
        ComplexoComposite operando4 = new ComplexoComposite();
        RealComposite operando5 = new RealComposite(9);
        ImaginarioComposite operando6 = new ImaginarioComposite(13);
        operando4.adicionaParteReal(operando5);
        operando4.adicionaParteImaginaria(operando6);
        operando1.soma(operando4);
        ImaginarioComposite operando7 = (ImaginarioComposite)operando1.getParteImaginaria();
        assertEquals(37, operando7.getValor());
        RealComposite operando8 = (RealComposite)operando1.getParteReal();
        assertEquals(94, operando8.getValor());
        assertEquals("94I37", operando1.mostra(new BaseDecimalStrategy()));
        assertEquals("0b1011110I0b100101", operando1.mostra(new BaseBinariaStrategy()));
        assertEquals("0x5EI0x25", operando1.mostra(new BaseHexadecimalStrategy()));
    }
}
