/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package charlie;

/**
 * Classe que implementa a calculadora.
 *
 * @author Diego Araújo e Helmar
 * @version 1.0
 * @since 0.1 (22/03/2007) Estado inicial, não funcionava.
 * @since 1.0 (24/03/2007) Criado o atributo display, onde os resultados das operações serão 
 * apresentadas ao usuário da calculadora. Implementados os métodos: limpa(), entraUm() e 
 * comandoSoma().
 **/
public class Calculadora {
    
    private int acumulador; // armazena temporariamente o resultado das operações matemáticas feitas pelo usuário.
    private String operando; // armazena o número digitado na calculadora pelo usuário.
    private String display; // armazena o contéudo do display da calculadora.

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
     * Obtém o contéudo do display.
     * 
     * @return o conteudo do display
     * */
    public String getDisplay() {
        return display;
    }

    /**
     * Limpa o contéudo do acumulador.
     * 
     * */
    public void limpa() {
        acumulador = 0;
        operando = "0";
        display = "0";
    }

    /** 
     * Realiza a soma do número digitado na calculadora (operando) com o 
     * contéudo do acumulador, compondo o resultado da operação soma.
     * 
     * */
    public void comandoSoma() {
        acumulador = acumulador + Integer.parseInt(operando);
        operando = "0";
        display = Integer.toString(acumulador);
    }
}