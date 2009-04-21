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
 * @author  Andr� Sion
 * @author  Thiago Silva de Souza
 * @version 0.1 07/04/2009 Andr� Sion e Thiago Silva de Souza
 * @since   0.2 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 * @version 0.1 31/03/2009 Andr� Sion e Thiago Silva de Souza
 * @since   0.1 Inclu�das as implementa��es dos m�todos limpa(), entraUm() e
 * comandoSoma().
 */
public class Calculadora implements ICalculadoraBase {

    // Estado da Caculadora
    /**
     * Atributo acumulador guarda os resultados da soma.
     **/
    private int acumulador;
    /**
     * Atributo operando guarda o cont�udo do operando.
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
        // inicializa vari�veis de inst�ncia
        this.acumulador = 0;
        this.operando = "0";
        this.base = new DecimalStrategy(); // base default
    }

    /**
     * Limpa o acumulador.
     * @return conte�do do acumulador
     **/
    public final String limpa() {
        this.operando = "0";
        this.acumulador = 0;
        return "0";
    }

    /**
     * Entra a tecla um.
     * @return conte�do do operador
     **/
    public String entraUm() {
        operando = operando + "1";
        return base.getId() + base.toBase(base.toDecValue(operando));
    }

    /**
     * Entra o comando soma.
     * @return conte�do do acumulador
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
     * Entra a base bin�ria.
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
