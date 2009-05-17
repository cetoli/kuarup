/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package charlie;
import labase.poo.ICalculadoraVetorial;

/**
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (5.0) (17 de maio de 2009) 
 * Esta versão trabalha com vetor
 * @since   (2.0) Esta versao trabalha om vetor
 */

public class Calculadora implements ICalculadoraVetorial {

	Numero operando;
	Numero acumulador;
	ICommand comando;

	public Calculadora() {
		comando = new SomaCommand();
		limpa();
	}

	public void entraV() {
		operando = new Vetorial(operando);
	}

	public void entraN() {
		operando = new Cientifico(operando);
	}

	public void entraI() {
		operando = new Complexo(operando);
	}

	public void modoBin() {
		operando.setBase(new BaseBinaria());
		acumulador.setBase(new BaseBinaria());
	}

	public void modoDec() {
		operando.setBase(new BaseDecimal());
		acumulador.setBase(new BaseDecimal());
	}

	public void modoHex() {
		operando.setBase(new BaseHexadecimal());
		acumulador.setBase(new BaseHexadecimal());
	}

	public String comandoSoma() {
		acumulador = comando.execute(acumulador, operando);
		comando = new SomaCommand();
		operando = new Real(0);
		operando.setBase(acumulador.getBase());
		return acumulador.mostrar();
	}

	public String comandoSubtrai() {
		acumulador = comando.execute(acumulador, operando);
		comando = new SubtracaoCommand();
		operando = new Real(0);
		operando.setBase(acumulador.getBase());
		return acumulador.mostrar();
	}

	public String entraUm() {
		return operando.entraUm();
	}

	public String limpa() {
		acumulador = new Real(0);
		operando = new Real(0);
		return "0";
	}
}