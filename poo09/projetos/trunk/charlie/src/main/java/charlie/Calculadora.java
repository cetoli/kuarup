/*----------------------------------------------------------------------------
  Copyright  2002-2009        Carlo E. T. Oliveira et all
  ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

  This software is licensed as described in the file LICENSE.txt,
  which you should have received as part of this distribution.
  ----------------------------------------------------------------------------*/
package charlie;
import labase.poo.ICalculadoraBase;

/**
 * Esta eh a primeira versao da Calculadora.
 * Nao possui nenhum design pattern ainda.
 * @author  Andre Abrantes  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0    $Revision$ 31/03/2009      $Date$
 * @since   1.0   Esta versao soma um mais um
 */
public class Calculadora implements ICalculadoraBase {
    /**Operador da Caculadora. */
    private Integer operador = new Integer(0);

    /**Acumulador da Caculadora. */
    private Integer acumulador = new Integer(0);

    /**Declaracao de variavel modo de operacao. */
    private BaseStrategy modo;

    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
        // inicializa variaveis de instancia
        operador = 0;
        acumulador = 0;
        modo = new DecimalStrategy();
    }

    /**
     * Entra a tecla um.
     * @return  conteudo do operador
     */
    public final String entraUm() {
        operador = modo.entraUm(operador);
        return modo.toString(operador);
    }

    /**
     * Limpa o acumulador.
     * @return  conteudo do acumulador
     */
    public final String limpa() {
        acumulador = 0;
        operador = 0;
        return operador.toString();
    }

    /**
     * Entra o comando soma.
     * @return  conteudo do acumulador
     */
    public final String comandoSoma() {
        acumulador = acumulador + operador;
        operador = 0;
        return modo.toString(acumulador);
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
}
