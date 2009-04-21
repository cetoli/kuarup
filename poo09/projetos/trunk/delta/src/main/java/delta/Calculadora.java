/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package delta;

import labase.poo.ICalculadoraBase;

/**
 * Classe que implementa a calculadora.
 * @author  André Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 André Sion e Thiago Silva de Souza
 * @since   0.2 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
 * @version 0.1 31/03/2009 André Sion e Thiago Silva de Souza
 * @since   0.1 Incluídas as implementações dos métodos limpa(), entraUm() e
 * comandoSoma().
 */
public class Calculadora implements ICalculadoraBase {

    // Estado da Caculadora
    /**
     * Atributo acumulador guarda os resultados da soma.
     **/
    private int acumulador;
    /**
     * Atributo operando guarda o contéudo do operando.
     **/
    private String operando;
    /**
     * Atributo base especifica a base utilizada.
     **/
    private BaseStrategy base = null;

    /**
     * Construtor para objetos da classe Calculadora.
     **/
    public Calculadora() {
        // inicializa variáveis de instância
        this.acumulador = 0;
        this.operando = "0";
        this.base = new DecimalStrategy(); // base default
    }

    /**
     * Limpa o acumulador.
     * @return conteúdo do acumulador
     **/
    public final String limpa() {
        this.operando = "0";
        this.acumulador = 0;
        return "0";
    }

    /**
     * Entra a tecla um.
     * @return conteúdo do operador
     **/
    public String entraUm() {
        operando = operando + "1";
        return base.getId() + base.toBase(base.toDecValue(operando));
    }

    /**
     * Entra o comando soma.
     * @return conteúdo do acumulador
     **/
    public String comandoSoma() {
        acumulador = acumulador + base.toDecValue(operando);
        String soma = base.getId() + base.toBase(acumulador);
        operando = "0";
        //base = new DecimalStrategy();
        return soma;
    }

    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        operando = Integer.toString(base.toDecValue(operando));
        base = new DecimalStrategy();
        operando = base.toBase(Integer.parseInt(operando));
    }

    /**
     * Entra a base binária.
     */
    public void modoBin() {
        operando = Integer.toString(base.toDecValue(operando));
        base = new BinariaStrategy();
        operando = base.toBase(Integer.parseInt(operando));
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        operando = Integer.toString(base.toDecValue(operando));
        base = new HexadecimalStrategy();
        operando = base.toBase(Integer.parseInt(operando));
    }
}
