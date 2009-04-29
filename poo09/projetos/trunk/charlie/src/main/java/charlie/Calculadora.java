/*----------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ----------------------------------------------------------------------------*/
package charlie;
import labase.poo.ICalculadoraComplexo;

/**
 * Esta eh a primeira versao da Calculadora.
 * Nao possui nenhum design pattern ainda.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 2.0    $Revision$ 15/04/2009      $Date$
 * @since   2.0   Esta versão opera com números complexos
 */
public class Calculadora implements ICalculadoraComplexo {
    /**Operador da Caculadora. */
    private Integer operador = new Integer(0);

    /**Declaracao de variavel modo de operacao. */
    private BaseStrategy modo;

    /**Declaracao do atributo do estado da soma. */
    private SomaState estadoSoma;

    /**Declaracao do atributo do estado real da soma. */
    private SomaState estadoSomaReal = new RealSomaState();

    /**Declaracao do atributo do estado imaginario da soma. */
    private SomaState estadoSomaImaginario = new ImaginarioSomaState();

    /**Declaracao do atributo do estado da impressao do resultado. */
    private ExibeValorState exibeValor;

    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
        // inicializa variaveis de instancia
        operador = 0;
        modo = new DecimalStrategy();
        estadoSoma = estadoSomaReal;
        exibeValor = new RealExibeValorState();
    }

    /**
     * Entra a tecla um.
     * @return  conteudo do operador
     */
    public final String entraUm() {
        operador = estadoSoma.getOperador();
        operador = modo.entraUm(operador);
        estadoSoma.setOperador(operador);
        return modo.toString(operador);// esses métodos estão funcionado, mas não estão legais
    }

    /**
     * Limpa o acumulador.
     * @return  conteudo do acumulador
     */
    public final String limpa() {
        operador = 0;
        estadoSomaReal = new RealSomaState();
        estadoSomaImaginario = new ImaginarioSomaState();
        estadoSoma = estadoSomaReal;
        exibeValor = new RealExibeValorState();
        return operador.toString();
    }

    /**
     * Entra o comando soma.
     */
    public final String comandoSoma() {
        estadoSoma.soma(operador);
        operador = 0;
        estadoSoma.setOperador(operador); // este método funciona, mas...
        estadoSoma = estadoSomaReal;
        Integer acumulReal = estadoSomaReal.getAcumulador();
        Integer acumulImag = estadoSomaImaginario.getAcumulador();
        return exibeValor.imprimeResultado(acumulReal, acumulImag, modo);
    }

    /**
     * Entra no modo Hexadecimal.
     */
    public final void modoHex() {
        modo = new HexadecimalStrategy();
    }

    /**
     * Entra no modo Binario.
     */
    public final void modoBin() {
        modo = new BinarioStrategy();
    }

    /**
     * Entra no modo Decimal.
     */
    public final void modoDec() {
        modo = new DecimalStrategy();
    }

    /**
     * Entra no estado Complexo.
     */ 
    public final void entraI() {
        estadoSoma = estadoSomaImaginario;
        exibeValor = new ImaginarioExibeValorState();
    }

}
