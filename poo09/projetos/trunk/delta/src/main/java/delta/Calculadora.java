/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package charlie;

/**
 * Classe que implementa a calculadora.
 *
 * @author Diego Ara�jo e Helmar
 * @version 1.0
 * @since 0.1 (22/03/2007) Estado inicial, n�o funcionava.
 * @since 1.0 (24/03/2007) Criado o atributo display, onde os resultados das opera��es ser�o 
 * apresentadas ao usu�rio da calculadora. Implementados os m�todos: limpa(), entraUm() e 
 * comandoSoma().
 **/
public class Calculadora {
    
    private int acumulador; // armazena temporariamente o resultado das opera��es matem�ticas feitas pelo usu�rio.
    private String operando; // armazena o n�mero digitado na calculadora pelo usu�rio.
    private String display; // armazena o cont�udo do display da calculadora.

    /**
     * Construtor para objetos da classe Calculadora.
     * 
     * */
    public Calculadora() {
        this.acumulador = 0;
        this.operando = "0";
        this.display = "0";
    }

    /**
     * Entra a tecla um.
     * 
     * */
    public void entraUm() {
        operando = display.equals("0")?"1":operando.concat("1");
        display = operando;
    }

    /**
     * Obt�m o cont�udo do display.
     * 
     * @return o conteudo do display
     * */
    public String getDisplay() {
        return display;
    }

    /**
     * Limpa o cont�udo do acumulador.
     * 
     * */
    public void limpa() {
        acumulador = 0;
        operando = "0";
        display = "0";
    }

    /** 
     * Realiza a soma do n�mero digitado na calculadora (operando) com o 
     * cont�udo do acumulador, compondo o resultado da opera��o soma.
     * 
     * */
    public void comandoSoma() {
        acumulador = acumulador + Integer.parseInt(operando);
        operando = "0";
        display = Integer.toString(acumulador);
    }
}