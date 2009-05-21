/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

import labase.poo.ICalculadoraVetorial;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public class Calculadora implements ICalculadoraVetorial{

    /**
     * Atributos que guardam o acumulador, o operador e o display.
     */
    private OperadorComposite acumulador, operador;
    private String display;
    
    /**
     * Construtor para objetos da classe Calculadora
     */
    public Calculadora() {
        limpa();
    }
    
    /**
     * Limpa o acumulador
     * @return conteúdo do acumulador
     */
    public String limpa() {
        acumulador = new OperandoNaoPreenchido();
        operador = new NumReal(0);
        display = acumulador.mostra();
        return display;
    }

    /**
     * Entra a tecla um
     * @return contéudo do operador na base especificada.
     */
    public String entraUm() {
        display = operador.entraUm();
        return display;
    }
    
    /**
     * Entra o comando soma.
     * @return contéudo do acumulador na base especificada.
     */
    public String comandoSoma() { //throws CalculadoraException 
        acumulador = acumulador.soma(operador);
        operador = new NumReal(0);
        operador.setBase(acumulador.getBase());
        display = acumulador.mostra();
        
        return display;
    }
    
    /**
     * Entra o comando subtração.
     * @return contéudo do acumulador na base especificada.
     */
    public String comandoSubtrai()  { //throws CalculadoraException
        acumulador = acumulador.sub(operador);
        operador = new NumReal(0);
        operador.setBase(acumulador.getBase());
        display = acumulador.mostra();
        return display;
    }
    
    /**
     * Entra a base decimal.
     * @return contéudo do operador na base especificada.
     */
    public void modoDec() {
        operador.setBase(new DecimalStrategy());
        acumulador.setBase(new DecimalStrategy());
    }
    
    /**
     * Entra a base binária.
     * @return contéudo do operador na base especificada.
     */
    public void modoBin() {
        operador.setBase(new BinariaStrategy());
        acumulador.setBase(new BinariaStrategy());
    }
    
    /**
     * Entra a base hexadecimal.
     * @return contéudo do operador na base especificada.
     */
    public void modoHex() {
        operador.setBase(new HexadecimalStrategy());
        acumulador.setBase(new HexadecimalStrategy());
    }
    
    /**
     * Entra a parte imaginária do número complexo.
     * @return contéudo do operador na base especificada.
     */
    public void entraI() {
        operador = operador.toComplexo();
    }
    
    /**
     * Entra a parte exponencial do número real ou imaginário.
     * @return contéudo do operador na base especificada.
     */
    public void entraN() {
        operador = operador.toExponencial();
    }
    
    /**
     * Entra um operador vetorial.
     * @return contéudo do operador na base especificada.
     */
    public void entraV() {
        operador = operador.toVetorial();
    }
}
