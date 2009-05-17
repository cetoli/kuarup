package charlie;

import java.util.ArrayList;
import java.util.List;

public class SubtracaoVisitor implements IVisitor {

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

	public Numero visitReal(Complexo visitante) {
		Complexo novo = new Complexo(new Real(0));

		novo.setParteReal(visitante.getParteReal().subtrai(this.visitado));
		novo.setParteImaginaria(visitante.getParteImaginaria());
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	public Numero visitComplexo(Real visitante) {
		Complexo novo = new Complexo(new Real(0));

		novo.setParteReal(visitante.subtrai(this.visitado.getParteReal()));
		novo.setParteImaginaria(this.visitado.getParteImaginaria());
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	public Numero visitReal(Cientifico cientifico) {
		Double d = new Double(this.visitado.getValor());
		double dividendo = Math.pow(10.0, cientifico.getExpoente().getValor());
		double quociente = d / dividendo;
		int valor = (int) Math.ceil(quociente);

		Numero visitante = new Cientifico(new Real(0));
		visitante.setParteReal(cientifico.getParteReal().subtrai(
				new Real(valor)));
		visitante.setExpoente(cientifico.getExpoente());
		visitante.setBase(cientifico.getParteReal().getBase());
		return visitante;
	}

	public Numero visitReal(Vetorial vetorial) {
		Numero novo = new Vetorial(new Real(0));
		novo.setVetorNumeros(new ArrayList<Numero>());

		List<Numero> vetorNumeros = vetorial.getVetorNumeros();
		for (Numero numero : vetorNumeros) {
			novo.getVetorNumeros().add(numero.subtrai(this.visitado));
		}
		return novo;
	}

	public Numero visitComplexo(Complexo visitante) {
		Complexo novo = new Complexo(new Real(0));

		novo.setParteReal(visitante.getParteReal().subtrai(
				this.visitado.getParteReal()));
		novo.setParteImaginaria(visitado.getParteImaginaria().subtrai(
				visitante.getParteImaginaria()));
		novo.setBase(this.visitado.getBase());

		return novo;
	}

	public Numero visitComplexo(Cientifico cientifico) {
		Complexo novo = new Complexo(new Real(0));
		novo.setBase(cientifico.getBase());
		return novo;
	}

	public Numero visitComplexo(Vetorial vetorial) {
		return null;
	}

	public Numero visitVetorial(Real real) {
		Numero novo = new Real(0);
		novo.setBase(real.getBase());
		novo = this.visitado.subtrai(real);
		return novo;
	}

	public Numero visitVetorial(Complexo complexoComposite) {
		return null;
	}

	public Numero visitVetorial(Cientifico cientifico) {
		return null;
	}

	public Numero visitVetorial(Vetorial vetorial) {
		return null;
	}

	public Numero visitCientifico(Real real) {
		Numero novo = new Real(0);
		novo.setBase(real.getBase());
		novo = this.visitado.subtrai(real);
		return novo;
	}

	public Numero visitCientifico(Complexo complexoComposite) {
		return null;
	}

	public Numero visitCientifico(Cientifico cientifico) {
		Numero novo = new Cientifico(new Real(0));
		novo.setParteReal(cientifico.getParteReal().subtrai(
				this.visitado.getParteReal()));
		novo.setExpoente(cientifico.getExpoente());
		return novo;
	}

	public Numero visitCientifico(Vetorial vetorial) {
		return null;
	}
}