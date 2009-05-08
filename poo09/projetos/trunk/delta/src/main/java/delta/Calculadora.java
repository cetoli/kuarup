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

    /**
     * Guarda os resultados da soma.
     **/
    private OperacaoComposite acumulador;

    /**
     * Guarda o conteudo do operando.
     **/
    private OperacaoComposite operando;

    /**
     * Guarda o conteudo do operando Real.
     **/
    private OperacaoComposite operandoReal;

    /**
     * Guarda o conteudo do operando Imaginario.
     **/
    private OperacaoComposite operandoImaginario;

    /**
     * Notação de Engenharia.
     **/
    private NotacaoEngenhariaComposite notacaoEngenharia;

    /**
     * Notação de Engenharia Real.
     **/
    private NotacaoEngenhariaComposite notacaoEngenhariaReal;

    /**
     * Notação de Engenharia Imaginaria.
     **/
    private NotacaoEngenhariaComposite notacaoEngenhariaImaginaria;

    /**
     * Guarda a base atual.
     **/
    private BaseStrategy base;

    /**
     * Construtor para objetos da classe Calculadora.
     **/
    public Calculadora() {
        limpa();
    }

    /**
     * Limpa acumulador e operando.
     * @return representacao de 0 na base atual.
     **/
    public final String limpa() {
        base = new DecimalStrategy();        
        operandoReal = new RealComposite();
        operandoImaginario = new ImaginarioComposite();
        expoenteReal = new RealComposite();
        expoenteImaginario = new RealComposite();
        operando = operandoReal;
        acumulador = operandoReal;
        notacaoEngenhariaReal = new NotacaoEngenhariaComposite(operandoReal);
        notacaoEngenhariaImaginaria = new NotacaoEngenhariaComposite(operandoImaginario);
        notacaoEngenharia = notacaoEngenhariaReal;
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
        this.acumulador.soma();
        this.operando = operandoReal;
        this.expoente = expoenteReal;
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
        operando = operandoImaginario;
        expoente = expoenteImaginario;
        acumulador = new ComplexoComposite(operandoReal, operandoImaginario);
    }

    /**
     * Entra numero notação de Engenharia.
     */
    public final void entraN() {
        operando = expoente;
        acumulador = notacaoEngenharia; // observar esta operacao
    }
}
