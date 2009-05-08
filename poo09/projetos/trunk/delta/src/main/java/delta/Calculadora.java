/*-----------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ---------------------------------------------------------------------------*/

package delta;

import labase.poo.ICalculadoraEngenharia;

/**
 * Classe que implementa a calculadora.
 * @author  Tiago Cruz de França
 * @author  Andre Sion
 * @version 4.0 24/04/2009
 * @since   3.0 Incluido suporte a notacao de Engenharia.
 */
public class Calculadora implements ICalculadoraEngenharia {

    /** Guarda os resultados da soma. */
    private OperacaoComposite acumulador;

    /** Guarda o conteudo do operando. */
    private OperacaoComposite operando;

    /** Guarda o conteudo do operando Real. */
    private OperacaoComposite operandoReal;

    /** Guarda o conteudo do operando complexo. */
    private OperacaoComposite complexo;

    /** Guarda o conteudo do operando Real. */
    private OperacaoComposite engenhariaR;

    /** Guarda o conteudo do operando Imaginario. */
    private OperacaoComposite engenhariaI;

    /** Guarda o conteudo do operando Imaginario. */
    private OperacaoComposite engenharia;

    /** Guarda a base atual. */
    private BaseStrategy base;

    /**
     * Construtor para objetos da classe Calculadora.
     **/
    public Calculadora() {
        base = new DecimalStrategy();        
        operandoReal = new RealComposite();
        complexo = new ComplexoComposite(operandoReal);
        operando = operandoReal;
        acumulador = operandoReal;
        engenhariaR = new NotEngenRealComposite(operandoReal);
        engenhariaI = new NotEngenImaginarioComposite(complexo);
        engenharia = engenhariaR;
    }

    /**
     * Limpa acumulador e operando.
     * @return representacao de 0 na base atual.
     **/
    public final String limpa() {
        base = new DecimalStrategy();        
        operandoReal = new RealComposite();
        complexo = new ComplexoComposite(operandoReal);
        operando = operandoReal;
        acumulador = operandoReal;
        return operando.toString(base);
    }

    /**
     * Entra a tecla um.
     * @return conteudo do operando na base atual.
     **/
    public final String entraUm() {
        operando.entraUm(base);
        return acumulador.toStringOperando(base);
    }

    /**
     * Entra o comando soma.
     * @return resultado da soma do acumulador e do operando.
     **/
    public final String comandoSoma() {
        acumulador.soma();
        operando = engenhariaR.getOperando();
        return this.acumulador.toString(base);
    }

    /**
     * Entra na base decimal.
     */
    public final void modoDec() {
        base = new DecimalStrategy();
    }

    /**
     * Entra na base binaria.
     */
    public final void modoBin() {
        base = new BinariaStrategy();
    }

    /**
     * Entra na base hexadecimal.
     */
    public final void modoHex() {
        base = new HexadecimalStrategy();
    }

    /**
     * Entra numero complexo.
     */
    public final void entraI() {
        engenharia = engenhariaI;
        acumulador = complexo;
        operando = complexo.getOperando();//retorna imaginario
    }

    /**
     * Entra numero notação de Engenharia.
     */
    public final void entraN() {
        operandoReal = engenhariaR;
        ((ComplexoComposite)complexo).setReal(operandoReal);
        acumulador = engenharia.getInstancia();
        operando = engenharia.getExpoente();        
    }

}
