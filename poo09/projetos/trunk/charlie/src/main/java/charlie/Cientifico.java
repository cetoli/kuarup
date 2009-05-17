package charlie;

import java.util.List;

public class Cientifico extends Numero {

	private Numero mantissa;

	private Numero expoente;

	public Cientifico(Numero numero) {
		this.mantissa = numero;
		this.expoente = new Real(0);
		this.expoente.setBase(this.mantissa.getBase());
	}

	protected void adicionaUm() {
		this.expoente.valor = this.mantissa.getBase().toDecimal(
				this.mantissa.getBase().converterBase(this.expoente.getValor()) + "1");
	}

	public String mostrar() {
		return this.mantissa.mostrar() + "N"
				+ this.mantissa.getBase().converterBase(this.expoente.getValor());
	}

	public void setBase(StrategyBase base) {
		this.mantissa.setBase(base);
		this.expoente.setBase(base);
	}

	public StrategyBase getBase() {
		return this.mantissa.getBase();
	}

	public Numero soma(Numero numero) {
		return numero.accept(new SomaVisitor(numero), this);
	}

	public Numero subtrai(Numero numero) {
		return numero.accept(new SubtracaoVisitor(numero), this);
	}

	protected Numero accept(IVisitor visitor, Real real) {
		return visitor.visitCientifico(real);
	}

	protected Numero accept(IVisitor visitor, Complexo complexo) {
		return visitor.visitCientifico(complexo);
	}

	protected Numero accept(IVisitor visitor, Cientifico cientifico) {
		return visitor.visitCientifico(cientifico);
	}

	protected Numero accept(IVisitor visitor, Vetorial vetorial) {
		return visitor.visitCientifico(vetorial);
	}

	public Numero getParteImaginaria() {
		return null;
	}

	public Numero getParteReal() {
		return mantissa;
	}

	public void setParteImaginaria(Numero parteImaginaria) {
	}

	public void setParteReal(Numero parteReal) {
		this.mantissa = parteReal;
	}

	public List<Numero> getVetorNumeros() {
		return null;
	}

	public void setVetorNumeros(List<Numero> vetor) {
	}

	public Numero getExpoente() {
		return expoente;
	}

	public void setExpoente(Numero numero) {
		this.expoente = numero;
	}
}
