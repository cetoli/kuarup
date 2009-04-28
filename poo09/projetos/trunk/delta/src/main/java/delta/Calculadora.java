/*-----------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ---------------------------------------------------------------------------*/

package delta;

import labase.poo.ICalculadoraComplexo;

/**
 * Classe que implementa a calculadora.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrante
 * @since   0.2 Incluido suporte a numeros complexos.
 */
public class Calculadora implements ICalculadoraComplexo {

    /**
     * Guarda os resultados da soma.
     **/
    private Inteiro acumulador;

    /**
     * Guarda o conteudo do operando.
     **/
    private Inteiro operando;

    /**
     * Guarda a base atual.
     **/
    private BaseStrategy base;

    /**
     * Construtor para objetos da classe Calculadora.
     **/
    public Calculadora() {
        acumulador = new Inteiro();
        operando = new Inteiro();

        base = new DecimalStrategy();
    }

    /**
     * Limpa acumulador e operando.
     * @return representacao de 0 na base atual.
     **/
    public final String limpa() {
        acumulador = new Inteiro();
        operando = new Inteiro();
        return operando.toString(base);
    }

    /**
     * Entra a tecla um.
     * @return conteudo do operando na base atual.
     **/
    public final String entraUm() {
        operando.entraUm(base);
        return operando.toString(base);
    }

    /**
     * Entra o comando soma.
     * @return resultado da soma do acumulador e do operando.
     **/
    public final String comandoSoma() {
        acumulador.soma(operando);
        operando = new Inteiro();

        return acumulador.toString(base);
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
        operando.entraI();
    }
}
