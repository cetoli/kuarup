/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

import labase.poo.ICalculadoraVetorial;

/**
 * Classe que implementa a calculadora.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public class Calculadora implements ICalculadoraVetorial{

    /**
     * Atributos que guardam o acumulador, o operando e o display.
     */
    private Operando acumulador, operando;
    private String display;
    
    /**
     * Construtor para objetos da classe Calculadora
     */
    public Calculadora() {
        limpa();
    }
    
    /**
     * Limpa o acumulador
     * @return conte�do do acumulador
     */
    public String limpa() {
        acumulador = new Nulo();
        operando = new Simples(0);
        display = acumulador.mostra();
        return display;
    }

    /**
     * Entra a tecla um
     * @return cont�udo do operando na base especificada.
     */
    public String entraUm() {
        display = operando.entraUm();
        return display;
    }
    
    /**
     * Entra o comando soma.
     * @return cont�udo do acumulador na base especificada.
     */
    public String comandoSoma() { //throws CalculadoraException 
        //try {
        acumulador = acumulador.soma(operando);
        operando = new Simples(0);
        operando.setBase(acumulador.getBase());
        display = acumulador.mostra();
        //} catch (CalculadoraException e){
        //    display = e.getMessage();
        //}
        return display;
    }
    
    /**
     * Entra o comando subtra��o.
     * @return cont�udo do acumulador na base especificada.
     */
    public String comandoSubtrai()  { //throws CalculadoraException
        //try {
        acumulador = acumulador.sub(operando);
        operando = new Simples(0);
        operando.setBase(acumulador.getBase());
        display = acumulador.mostra();
        //} catch (CalculadoraException e){
        //    display = e.getMessage();
        //}
        return display;
    }
    
    /**
     * Entra a base decimal.
     * @return cont�udo do operando na base especificada.
     */
    public void modoDec() {
        operando.setBase(new DecimalStrategy());
        acumulador.setBase(new DecimalStrategy());
    }
    
    /**
     * Entra a base bin�ria.
     * @return cont�udo do operando na base especificada.
     */
    public void modoBin() {
        operando.setBase(new BinariaStrategy());
        acumulador.setBase(new BinariaStrategy());
    }
    
    /**
     * Entra a base hexadecimal.
     * @return cont�udo do operando na base especificada.
     */
    public void modoHex() {
        operando.setBase(new HexadecimalStrategy());
        acumulador.setBase(new HexadecimalStrategy());
    }
    
    /**
     * Entra a parte imagin�ria do n�mero complexo.
     * @return cont�udo do operando na base especificada.
     */
    public void entraI() {
        operando = operando.toComplexo();
    }
    
    /**
     * Entra a parte exponencial do n�mero real ou imagin�rio.
     * @return cont�udo do operando na base especificada.
     */
    public void entraN() {
        operando = operando.toExponencial();
    }
    
    /**
     * Entra um operando vetorial.
     * @return cont�udo do operando na base especificada.
     */
    public void entraV() {
        operando = operando.toVetorial();
    }
}
