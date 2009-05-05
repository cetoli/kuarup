/*------------------------------------------------------------------------------
    Copyright © 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Incluídas as funcionalidades: números com notação científica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Incluídas as funcionalidades: números complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
 */
public class ParteImaginariaTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste CompositorParteImaginariaTest.
     */
    public ParteImaginariaTest() {
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
     * Testes de Entrada: ADICIONAR PARTE MANTISSA A NÚMERO IMAGINÁRIO,
     *                    ADICIONAR PARTE EXPONENCIAL A NÚMERO IMAGINÁRIO,
     *                    ADICIONAR PARTE MANTISSA E EXPONENCIAL A NÚMERO IMAGINÁRIO,
     *                    ADICIONAR PARTE MANTISSA E EXPONENCIAL A NÚMERO COMPLEXO.
     */     
    
    /**
     * Teste de Entrada: ADICIONAR PARTE MANTISSA A NÚMERO IMAGINÁRIO.
     */
    public void testEntraID11() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteImaginaria();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteImaginaria(11, operando, montador);
        assertEquals(11, operando.getParteImaginaria().getValor());
    }
    
    /**
     * Teste de Entrada: ADICIONAR PARTE EXPONENCIAL A NÚMERO IMAGINÁRIO.
     */
    public void testEntraID11ED1() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteImaginaria();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteImaginaria(11, operando, montador);
        montador = new ParteExponencial();
        adicionador.adicionaParteImaginaria(1, operando, montador);
        assertEquals(1, operando.getParteImaginaria().getParteExponencial().getValor());
    }
    
    /**
     * Teste de Entrada: ADICIONAR PARTE MANTISSA E EXPONENCIAL A NÚMERO IMAGINÁRIO.
     */
    public void testEntraID110ED10() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteImaginaria();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteImaginaria(110, operando, montador);
        assertEquals(110, operando.getParteImaginaria().getValor());
        montador = new ParteExponencial();
        adicionador.adicionaParteImaginaria(10, operando, montador);
        assertEquals(10, operando.getParteImaginaria().getParteExponencial().getValor());
    }
    
    /**
     * Teste de Entrada: ADICIONAR PARTE MANTISSA E EXPONENCIAL A NÚMERO COMPLEXO.
     */
    public void testEntraD11ED1ID10ED11() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteReal();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteReal(11, operando, montador);
        montador = new ParteExponencial();
        adicionador.adicionaParteReal(1, operando, montador);
        adicionador = new ParteImaginaria();
        montador = new ParteMantissa();
        adicionador.adicionaParteImaginaria(10, operando, montador);
        montador = new ParteExponencial();
        adicionador.adicionaParteImaginaria(11, operando, montador);
        assertEquals(10, operando.getParteImaginaria().getValor());
        assertEquals(11, operando.getParteImaginaria().getParteExponencial().getValor());
    }
}
