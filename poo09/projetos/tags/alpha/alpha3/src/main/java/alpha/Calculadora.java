/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package alpha;
import labase.poo.ICalculadoraComplexo;

/**
 * Esta é a classe principal da calculadora do time alpha.
 *
 * @author  Diego Mury Gomes de Lima  $Author$
 * @author  Marcio Reis Teixeira  $Author$
 * @version 3.0    $Revision$ 2.0      $Date$ 26/04/09
 * @since   2.0 Calculadora com numeros decimais, binarios e hexadecimais
 */
public class Calculadora implements ICalculadoraComplexo {
    /**Acumulador da Caculadora. */
    private INumeroStrategy acumulador = new NumeroDecimalStrategy();
    /**Operador da Caculadora. */
    private INumeroStrategy operador = new NumeroDecimalStrategy();
    /**Acumulador Imaginario da Caculadora. */
    private INumeroStrategy acumuladorImaginario = new NumeroDecimalStrategy();
    /**Operador Imaginario da Caculadora. */
    private INumeroStrategy operadorImaginario = new NumeroDecimalStrategy();
    /**Estado do Numero.*/
    private INumeroState state = new NumeroRealState();
    /**Estado anterior do Numero. Auxilia em casos de o primeiro
     * operador ser imaginario e o segundo nao.
     */
    private INumeroState previousState = state;
    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
    // inicializa variaveis de instância
    }
    /**
     * Limpa o acumulador.
     *
     * @return  o conteudo zerado
     */
    public final String limpa() {
        return "0";
    }
    /**
     * Entra a tecla um.
     *
     * @return  conteudo do operador
     */
    public final String entraUm() {
        String retorno = state.entraUm(operador, operadorImaginario);
        return retorno;
    }
    /**
     * Entra o comando soma.
     *
     *@return conteudo do acumulador tratado para ir a tela
     */
    public final String comandoSoma() {
        String retorno = previousState.soma(operador, operadorImaginario, acumulador, acumuladorImaginario);
        operador.zeraRepresentacaoNumerica();
        operadorImaginario.zeraRepresentacaoNumerica();
        state = new NumeroRealState();
        return retorno;
    }
    /**
     * * Opera em modo hexadecimal.
     */
    public final void modoHex() {
        INumeroStrategy temp = operador;
        Integer i = temp.converteEmNumeroDecimal();
        operador = new NumeroHexadecimalStrategy();
        operador = operador.converterParaBase(i);
        temp = operadorImaginario;
        i = temp.converteEmNumeroDecimal();
        operadorImaginario = new NumeroHexadecimalStrategy();
        operadorImaginario = operadorImaginario.converterParaBase(i);
        temp = acumulador;
        i = temp.converteEmNumeroDecimal();
        acumulador = new NumeroHexadecimalStrategy();
        acumulador = acumulador.converterParaBase(i);
        temp = acumuladorImaginario;
        i = temp.converteEmNumeroDecimal();
        acumuladorImaginario = new NumeroHexadecimalStrategy();
        acumuladorImaginario = acumuladorImaginario.converterParaBase(i);
    }
    /**
     * Opera em modo binario.
     */
    public final void modoBin() {
        INumeroStrategy temp = operador;
        Integer i = temp.converteEmNumeroDecimal();
        operador = new NumeroBinarioStrategy();
        operador = operador.converterParaBase(i);
        temp = operadorImaginario;
        i = temp.converteEmNumeroDecimal();
        operadorImaginario = new NumeroBinarioStrategy();
        operadorImaginario = operadorImaginario.converterParaBase(i);
        temp = acumulador;
        i = temp.converteEmNumeroDecimal();
        acumulador = new NumeroBinarioStrategy();
        acumulador = acumulador.converterParaBase(i);
        temp = acumuladorImaginario;
        i = temp.converteEmNumeroDecimal();
        acumuladorImaginario = new NumeroBinarioStrategy();
        acumuladorImaginario = acumuladorImaginario.converterParaBase(i);
    }
    /**
     * Opera em modo decimal.
     */
    public final void modoDec() {
        INumeroStrategy temp = operador;
        Integer i = temp.converteEmNumeroDecimal();
        operador = new NumeroDecimalStrategy();
        operador = operador.converterParaBase(i);
        temp = operadorImaginario;
        i = temp.converteEmNumeroDecimal();
        operadorImaginario = new NumeroDecimalStrategy();
        operadorImaginario = operadorImaginario.converterParaBase(i);
        temp = acumulador;
        i = temp.converteEmNumeroDecimal();
        acumulador = new NumeroDecimalStrategy();
        acumulador = acumulador.converterParaBase(i);
        temp = acumuladorImaginario;
        i = temp.converteEmNumeroDecimal();
        acumuladorImaginario = new NumeroDecimalStrategy();
        acumuladorImaginario = acumuladorImaginario.converterParaBase(i);
    }
    /**
     * Habilita numeros complexos.
     *
     */
    public void entraI() {
        state = new NumeroImaginarioState();
        previousState = state;
    }
}
