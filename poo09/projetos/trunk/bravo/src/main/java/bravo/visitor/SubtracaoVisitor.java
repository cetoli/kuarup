package bravo.visitor;

import java.util.ArrayList;
import java.util.List;

import bravo.numeros.CientificaComposite;
import bravo.numeros.ComplexoComposite;
import bravo.numeros.Numero;
import bravo.numeros.Real;
import bravo.numeros.VetorialComposite;

/**
 * Implementa um visitor para subtracoes
 * 
 * @author leandrogomes e humberto
 * 
 */
public class SubtracaoVisitor implements IVisitor {

	// numero que est‡ sendo visitado pelo Visitor
	private Numero visitado;

	public SubtracaoVisitor(Numero visitado) {
		this.visitado = visitado;
	}

	public Numero visitReal(Real visitante) {
		Real novo = new Real(0);
		novo.setValor(visitante.getValor() - this.visitado.getValor());
		novo.setBase(this.visitado.getBase());
		return novo;
	}

	/**
	 * realiza complexo - real
	 */
	public Numero visitReal(ComplexoComposite visitante) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));

		novo.setParteReal(visitante.getParteReal().subtrai(this.visitado));
		novo.setParteImaginaria(visitante.getParteImaginaria());
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	/**
	 * realiza complexo - real
	 */
	public Numero visitComplexo(Real visitante) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));

		novo.setParteReal(visitante.subtrai(this.visitado.getParteReal()));
		novo.setParteImaginaria(this.visitado.getParteImaginaria());
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	/**
	 * realiza cientifico - real
	 */
	public Numero visitReal(CientificaComposite cientifico) {
		// coloca na mesma base
		Double d = new Double(this.visitado.getValor());
		double dividendo = Math.pow(10.0, cientifico.getExpoente().getValor());
		double quociente = d / dividendo;
		int valor = (int) Math.ceil(quociente);

		Numero visitante = new CientificaComposite(new Real(0));
		visitante.setParteReal(cientifico.getParteReal().subtrai(
				new Real(valor)));
		visitante.setExpoente(cientifico.getExpoente());
		visitante.setBase(cientifico.getParteReal().getBase());
		return visitante;
	}

	/**
	 * realiza vetorial - real
	 */
	public Numero visitReal(VetorialComposite vetorial) {
		Numero novo = new VetorialComposite(new Real(0));
		novo.setVetorNumeros(new ArrayList<Numero>());

		List<Numero> vetorNumeros = vetorial.getVetorNumeros();
		for (Numero numero : vetorNumeros) {
			novo.getVetorNumeros().add(numero.subtrai(this.visitado));
		}
		return novo;
	}

	/**
	 * realiza complexo - complexo
	 */
	public Numero visitComplexo(ComplexoComposite visitante) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));

		novo.setParteReal(visitante.getParteReal().subtrai(
				this.visitado.getParteReal()));
		novo.setParteImaginaria(visitado.getParteImaginaria().subtrai(
				visitante.getParteImaginaria()));
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	/**
	 * realiza complexo - cientifico
	 */
	public Numero visitComplexo(CientificaComposite cientifico) {
		ComplexoComposite novo = new ComplexoComposite(new Real(0));
		novo.setBase(cientifico.getBase());
		return novo;
	}

	/**
	 * realiza complexo - vetorial
	 */
	public Numero visitComplexo(VetorialComposite vetorial) {
		return null;
	}

	/**
	 * realiza vetorial - real
	 */
	public Numero visitVetorial(Real real) {
		Numero novo = new Real(0);
		novo.setBase(real.getBase());
		novo = this.visitado.subtrai(real);
		return novo;
	}

	/**
	 * realiza vetorial - complexo
	 */
	public Numero visitVetorial(ComplexoComposite complexoComposite) {
		return null;
	}

	/**
	 * realiza vetorial - cientifico
	 */
	public Numero visitVetorial(CientificaComposite cientifico) {
		return null;
	}

	/**
	 * realiza vetorial - vetorial
	 */
	public Numero visitVetorial(VetorialComposite vetorial) {
		return null;
	}

	/**
	 * realiza cientifico - real
	 */
	public Numero visitCientifico(Real real) {
		Numero novo = new Real(0);
		novo.setBase(real.getBase());
		novo = this.visitado.subtrai(real);
		return novo;
	}

	/**
	 * realiza cientifico - complexo
	 */
	public Numero visitCientifico(ComplexoComposite complexoComposite) {
		return null;
	}

	/**
	 * realiza cientifico - cientifico
	 */
	public Numero visitCientifico(CientificaComposite cientifico) {
		Numero novo = new CientificaComposite(new Real(0));
		novo.setParteReal(cientifico.getParteReal().subtrai(
				this.visitado.getParteReal()));
		novo.setExpoente(cientifico.getExpoente());
		return novo;
	}

	/**
	 * realiza vetorial - cientifico
	 */
	public Numero visitCientifico(VetorialComposite vetorial) {
		return null;
	}
}