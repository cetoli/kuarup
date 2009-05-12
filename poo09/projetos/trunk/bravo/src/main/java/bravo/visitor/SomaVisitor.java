package bravo.visitor;

import java.util.ArrayList;
import java.util.List;

import bravo.numeros.CientificaComposite;
import bravo.numeros.ComplexoComposite;
import bravo.numeros.Numero;
import bravo.numeros.Real;
import bravo.numeros.VetorialComposite;

/**
 * Implementa um visitor para operacoes de soma de modo que a operacao b‡sica de
 * soma est‡ apenas defindo na folha(real + real). O visitor percorre todo o
 * composite tentando chegar ˆs folhas resolvendo as operacoes.
 * 
 * @author leandrogomes
 * 
 */
public class SomaVisitor implements IVisitor {

	// numero que est‡ sendo visitado pelo Visitor
	private Numero visitado;

	public SomaVisitor(Numero visitado) {
		this.visitado = visitado;
	}

	/**
	 * Realiza a operacao real + real
	 */
	public Numero visitReal(Real visitante) {
		Real novo = new Real(0);
		novo.setValor(visitante.getValor() + this.visitado.getValor());
		novo.setBase(this.visitado.getBase());
		return novo;
	}

	/**
	 * Realiza a operacao complexo + real
	 */
	public Numero visitReal(ComplexoComposite visitante) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));

		novo.setParteReal(visitante.getParteReal().soma(this.visitado));
		novo.setParteImaginaria(visitante.getParteImaginaria());
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	/**
	 * Realiza a operacao real + complexo
	 */
	public Numero visitComplexo(Real visitante) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));

		novo.setParteReal(visitante.soma(this.visitado.getParteReal()));
		novo.setParteImaginaria(this.visitado.getParteImaginaria());
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	/**
	 * Realiza a operacao cientifico + real
	 */
	public Numero visitReal(CientificaComposite cientifico) {
		// coloca na mesma base
		Double d = new Double(this.visitado.getValor());
		double dividendo = Math.pow(10.0, cientifico.getExpoente().getValor());
		double quociente = d / dividendo;
		int valor = (int) Math.ceil(quociente);

		Numero visitante = new CientificaComposite(new Real(0));
		visitante.setParteReal(cientifico.getParteReal().soma(new Real(valor)));
		visitante.setExpoente(cientifico.getExpoente());
		visitante.setBase(cientifico.getParteReal().getBase());
		return visitante;
	}

	/**
	 * Realiza a operacao vetorial + real
	 */
	public Numero visitReal(VetorialComposite vetorial) {
		Numero novo = new VetorialComposite(new Real(0));
		novo.setVetorNumeros(new ArrayList<Numero>());

		List<Numero> vetorNumeros = vetorial.getVetorNumeros();
		for (Numero numero : vetorNumeros) {
			novo.getVetorNumeros().add(this.visitado.soma(numero));
		}
		return novo;
	}

	/**
	 * Realiza a operacao complexo + complexo
	 */
	public Numero visitComplexo(ComplexoComposite visitante) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));

		novo.setParteReal(visitante.getParteReal().soma(
				this.visitado.getParteReal()));
		novo.setParteImaginaria(visitado.getParteImaginaria().soma(
				visitante.getParteImaginaria()));
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	/**
	 * Realiza a operacao complexo + cientifico
	 */
	public Numero visitComplexo(CientificaComposite cientifico) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));
		return novo;
	}

	/**
	 * Realiza a operacao complexo + vetorial
	 */
	public Numero visitComplexo(VetorialComposite vetorial) {
		return null;
	}

	/**
	 * Realiza a operacao vetorial + real
	 */
	public Numero visitVetorial(Real real) {
		Numero novo = new Real(0);
		novo = this.visitado.soma(real);
		return novo;
	}

	/**
	 * Realiza a operacao complexo + vetorial
	 */
	public Numero visitVetorial(ComplexoComposite complexoComposite) {
		return null;
	}

	/**
	 * Realiza a operacao vetorial + cientifico
	 */
	public Numero visitVetorial(CientificaComposite cientifico) {
		return null;
	}

	/**
	 * Realiza a operacao complexo + complexo
	 */
	public Numero visitVetorial(VetorialComposite vetorial) {
		return null;
	}

	/**
	 * Realiza a operacao cientifico + real
	 */
	public Numero visitCientifico(Real real) {
		Numero novo = new Real(0);
		novo = this.visitado.soma(real);
		return novo;
	}

	/**
	 * Realiza a operacao cientifico + complexo
	 */
	public Numero visitCientifico(ComplexoComposite complexoComposite) {
		return null;
	}

	/**
	 * Realiza a operacao cientifico + cientifico
	 */
	public Numero visitCientifico(CientificaComposite cientifico) {
		Numero novo = new CientificaComposite(new Real(0));
		novo.setParteReal(cientifico.getParteReal().soma(
				this.visitado.getParteReal()));
		novo.setExpoente(cientifico.getExpoente());
		return novo;
	}

	/**
	 * Realiza a operacao cientifico + vetorial
	 */
	public Numero visitCientifico(VetorialComposite vetorial) {
		return null;
	}
}