/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

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
     * Atributo acumulador guarda os resultados da soma.
     **/
    private Inteiro acumulador;

    /**
     * Atributo operando guarda o conteudo do operando.
     **/
    private Inteiro operando;

    /**
     * Construtor para objetos da classe Calculadora.
     **/
    public Calculadora() {
        acumulador = new Inteiro();
        operando = new Inteiro();
    }

    /**
     * Limpa o acumulador.
     * @return conteudo do acumulador
     **/
    public final String limpa() {
        acumulador.limpa();
        operando.limpa();
        return "0";
    }

    /**
     * Entra a tecla um.
     * @return conteudo do operador
     **/
    public String entraUm() {
        operando.entraUm();
        return operando.toString();
    }

    /**
     * Entra o comando soma.
     * @return conteudo do acumulador
     **/
    public String comandoSoma() {
        acumulador.soma(operando);
        operando.limpa();

        return acumulador.toString();
    }

    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        acumulador.modoDec();
    }

    /**
     * Entra a base binaria.
     */
    public void modoBin() {
        acumulador.modoBin();
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        acumulador.modoHex();
    }
    
    /**
     * Entra numero complexo.
     */
    public void entraI() {
        // TODO
    }
}
