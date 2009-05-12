/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Andre de Abrantes
 * @version 5.0 12/05/2009 Carlos Eduardo e Andre de Abrantes
 * @since   4.0 Inclu�das as funcionalidades: numeros vetoriais e subtracao
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   3.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   2.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   1.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 */
public class ParteRealTest extends junit.framework.TestCase {
  
    /**
     * Construtor default para a classe de teste CompositorParteRealTest.
     */
    public ParteRealTest() {
    }

    /**
     * Prepara��o do caso de teste.
     *
     * Chamado antes de cada m�todo de caso de teste.
     */
    protected void setUp() {
    }

    /**
     * Limpeza do caso de teste.
     *
     * Chamado ap�s cada m�todo de teste de caso.
     */
    protected void tearDown() {
    }
  
    /**
     * Testes de Entrada: ADICIONAR PARTE MANTISSA A N�MERO REAL,
     *                    ADICIONAR PARTE EXPONENCIAL A N�MERO REAL,
     *                    ADICIONAR PARTE MANTISSA E EXPONENCIAL A N�MERO REAL,
     *                    ADICIONAR PARTE MANTISSA E EXPONENCIAL A N�MERO COMPLEXO.
     */     
    
    /**
     * Teste de Entrada: ADICIONAR PARTE MANTISSA A N�MERO REAL.
     */
    public void testEntraD11() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteReal();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteReal(11, operando, montador);
        assertEquals(11, operando.getParteReal().getValor());
    }
    
    /**
     * Teste de Entrada: ADICIONAR PARTE EXPONENCIAL A N�MERO REAL.
     */
    public void testEntraD11ED1() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteReal();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteReal(11, operando, montador);
        montador = new ParteExponencial();
        adicionador.adicionaParteReal(1, operando, montador);
        assertEquals(1, operando.getParteReal().getParteExponencial().getValor());
    }
    
    /**
     * Teste de Entrada: ADICIONAR PARTE MANTISSA E EXPONENCIAL A N�MERO REAL.
     */
    public void testEntraD110ED10() {
        Complexo operando = new Complexo();
        Adicionador adicionador = new ParteReal();
        Adicionador montador = new ParteMantissa();
        adicionador.adicionaParteReal(110, operando, montador);
        assertEquals(110, operando.getParteReal().getValor());
        montador = new ParteExponencial();
        adicionador.adicionaParteReal(10, operando, montador);
        assertEquals(10, operando.getParteReal().getParteExponencial().getValor());
    }
    
    /**
     * Teste de Entrada: ADICIONAR PARTE MANTISSA E EXPONENCIAL A N�MERO COMPLEXO.
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
        assertEquals(11, operando.getParteReal().getValor());
        assertEquals(1, operando.getParteReal().getParteExponencial().getValor());
    }
}
