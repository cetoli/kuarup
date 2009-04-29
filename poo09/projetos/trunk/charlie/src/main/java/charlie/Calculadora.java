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

    /**Acumulador da Caculadora. */
//    private Integer acumulador = new Integer(0);

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
//        acumulador = 0;
        modo = new DecimalStrategy();
        estadoSoma = estadoSomaReal;
        exibeValor = new RealExibeValorState();
    }

    /**
     * Entra a tecla um.
     * @return  conteudo do operador
     */
    public final String entraUm() {
        operador = modo.entraUm(operador);//entrar1 tem que diferenciar a cada chamada do método o operador tem que ser diferenciado entre Real e Imaginário
        return modo.toString(operador);
// se necessario, o retorno pode ser dado por exibeValor,
// depende da exigencia dos testes do professor
    }

    /**
     * Limpa o acumulador.
     * @return  conteudo do acumulador
     */
    public final String limpa() {
//        acumulador = 0;
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
        estadoSoma = estadoSomaReal;
        operador = 0;
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
