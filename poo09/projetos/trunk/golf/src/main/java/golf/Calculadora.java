/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package golf;

import labase.poo.ICalculadoraComplexo;

/**
 * Classe que implementa a calculadora.
 * @author  Gustavo Taveira
 * @version 2.0 28/04/2009 Gustavo Taveira
 * @since   2.0 Incluídas as funcionalidades: numeros binarios e
 * hexadecimais.
 * @version 1.0 31/03/2009 André Sion e Thiago Silva de Souza
 * @since   1.0 Incluídas as implementações dos métodos limpa(), entraUm() e
 * comandoSoma().
 */
public class Calculadora implements ICalculadoraComplexo {

    // Estado da Caculadora
    /**
     * Atributo acumulador guarda os resultados da soma.
     **/
    private int acumulador;
    /**
     * Atributo operando guarda o contéudo do operando.
     **/
    private int operando;
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
        this.operando = 0;
        this.base = new DecimalStrategy(); // base default
    }

    /**
     * Limpa o acumulador.
     * @return conteúdo do acumulador
     **/
    public final String limpa() {
        this.operando = 0;
        this.acumulador = 0;
        return "0";
    }

    /**
     * Entra a tecla um.
     * @return conteúdo do operador
     **/
    public String entraUm() {
        operando = operando * base.getBase() + 1;
        return base.getId() + base.toBase(operando);
    }

    /**
     * Entra o comando soma.
     * @return conteúdo do acumulador
     **/
    public String comandoSoma() {
        acumulador = acumulador + operando;
        String soma = base.getId() + base.toBase(acumulador);
        operando = 0;
        return soma;
    }

    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        base = new DecimalStrategy();
    }

    /**
     * Entra a base binária.
     */
    public void modoBin() {
        base = new BinariaStrategy();
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new HexadecimalStrategy();
    }

    /**
     * Entra a base hexadecimal.
     */
    public void entraI() {
    }
}
