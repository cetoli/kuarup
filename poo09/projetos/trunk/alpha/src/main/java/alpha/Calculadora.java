/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package alpha;
import labase.poo.ICalculadoraVetorial;

/**
 * Esta é a classe principal da calculadora do time alpha.
 *
 * @author  Diego Mury Gomes de Lima  $Author$
 * @author  Carlos Henrique P. Rodriguez  $Author$
 * @version 5.0    $Revision$ 2.0      $Date$ 20/05/09
 * @since   4.0 Calculadora Exponencial
 */
public class Calculadora implements ICalculadoraVetorial {
    /**
     * Atributos que guardam o acumulador, o operando e o display.
     */
    private INumero operando;
    private INumero acumulador;
    private String display;
    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
        limpa();
    }
    /**
     * Limpa o acumulador.
     * @return conteúdo do acumulador.
     */
    public String limpa() {
        acumulador = new Nulo();
        operando = new Real(0);
        display = acumulador.mostra();
        return display;
    }
    /**
     * Entra a tecla um.
     * @return contéudo do operando na base especificada.
     */
    public String entraUm() {
        display = operando.entraUm();
        return display;
    }
    /**
     * Entra o comando soma.
     * @return contéudo do acumulador na base especificada.
     */
    public String comandoSoma() { 
        acumulador = acumulador.soma(operando);
        operando = new Real(0);
        operando.setBase(acumulador.getBase());
        display = acumulador.mostra();
        return display;
    }
    /**
     * Entra o comando subtração.
     * @return contéudo do acumulador na base especificada.
     */
    public String comandoSubtrai()  { 
        acumulador = acumulador.sub(operando);
        operando = new Real(0);
        operando.setBase(acumulador.getBase());
        display = acumulador.mostra();
        return display;
    }
    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        operando.setBase(new BaseDecimalStrategy());
        acumulador.setBase(new BaseDecimalStrategy());
    }
    /**
     * Entra a base binária.
     */
    public void modoBin() {
        operando.setBase(new BaseBinariaStrategy());
        acumulador.setBase(new BaseBinariaStrategy());
    }
    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        operando.setBase(new BaseHexadecimalStrategy());
        acumulador.setBase(new BaseHexadecimalStrategy());
    }
    /**
     * Entra a parte imaginária do número complexo.
     */
    public void entraI() {
        operando = operando.toComplexo();
    }
    /**
     * Entra a parte exponencial do número real ou imaginário.
     */
    public void entraN() {
        operando = operando.toExponencial();
    }
    /**
     * Entra um operando vetorial.
     */
    public void entraV() {
        operando = operando.toVetorial();
    }
}
