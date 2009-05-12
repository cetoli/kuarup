package bravo;

import labase.poo.ICalculadoraVetorial;
import bravo.bases.BaseBinariaStrategy;
import bravo.bases.BaseDecimalStrategy;
import bravo.bases.BaseHexadecimalStrategy;
import bravo.numeros.CientificaComposite;
import bravo.numeros.ComplexoComposite;
import bravo.numeros.Numero;
import bravo.numeros.Real;
import bravo.numeros.VetorialComposite;

/**
 * 
 * Calculadora
 * 
 * versao 5 = Leandro e Humberto
 * 
 */
public class Calculadora implements ICalculadoraVetorial {

	Numero operando;

	Numero acumulador;

	ICommand comando;

	public Calculadora() {
		comando = new SomaCommand();
		limpa();
	}

	/**
	 * Entra um vetor
	 */
	public void entraV() {
		operando = new VetorialComposite(operando);
	}

	/**
	 * Entra um numero cientifico
	 */
	public void entraN() {
		operando = new CientificaComposite(operando);
	}

	/**
	 * Entra um numero complexo
	 */
	public void entraI() {
		operando = new ComplexoComposite(operando);
	}

	/**
	 * Passa para o modo binario
	 */
	public void modoBin() {
		operando.setBase(new BaseBinariaStrategy());
		acumulador.setBase(new BaseBinariaStrategy());
	}

	/**
	 * Passa para o modo decimal
	 */
	public void modoDec() {
		operando.setBase(new BaseDecimalStrategy());
		acumulador.setBase(new BaseDecimalStrategy());
	}

	/**
	 * Passa para o modo hexadecimal
	 */
	public void modoHex() {
		operando.setBase(new BaseHexadecimalStrategy());
		acumulador.setBase(new BaseHexadecimalStrategy());
	}

	/**
	 * Soma o operando com o acumulador
	 */
	public String comandoSoma() {
		acumulador = comando.execute(acumulador, operando);
		comando = new SomaCommand();

		operando = new Real(0);
		operando.setBase(acumulador.getBase());

		return acumulador.mostrar();
	}

	/**
	 * Subtrai o operando do acumulador
	 */
	public String comandoSubtrai() {
		acumulador = comando.execute(acumulador, operando);
		comando = new SubtracaoCommand();

		operando = new Real(0);
		acumulador.setBase(new BaseDecimalStrategy());

		return acumulador.mostrar();
	}

	/**
	 * Entra com o d’gito 1
	 */
	public String entraUm() {
		return operando.entraUm();
	}

	/**
	 * Limpa os valores
	 */
	public String limpa() {
		acumulador = new Real(0);
		operando = new Real(0);
		return "0";
	}
}