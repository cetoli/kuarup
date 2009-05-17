package charlie;

import java.util.List;

public class Complexo extends Numero {

	private Numero parteReal;
	private Numero parteImaginaria;

	public Complexo(Numero numero) {
		this.parteReal = numero;
		this.base = numero.getBase();
		this.parteImaginaria = new Real(0);
		this.parteImaginaria.setBase(this.parteReal.getBase());
	}

	public Numero getParteReal() {
		return parteReal;
	}

	public void setParteReal(Numero parteReal) {
		this.parteReal = parteReal;
	}

	public Numero getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(Numero parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	public void setBase(StrategyBase base) {
		this.base = base;
		this.parteReal.setBase(base);
		this.parteImaginaria.setBase(base);
	}

	public StrategyBase getBase() {
		return this.base;
	}

	protected void adicionaUm() {
		this.parteImaginaria.valor = parteImaginaria.getBase().toDecimal(
				parteImaginaria.getBase().converterBase(
						this.parteImaginaria.getValor())
						+ "1");
	}

	public String mostrar() {
		return parteReal.mostrar() + "I" + parteImaginaria.mostrar();
	}

	public Numero soma(Numero numero) {
		return numero.accept(new SomaVisitor(numero), this);
	}

	public Numero subtrai(Numero numero) {
		return numero.accept(new SubtracaoVisitor(numero), this);
	}

	protected Numero accept(IVisitor visitor, Real real) {
		return visitor.visitComplexo(real);
	}

	protected Numero accept(IVisitor visitor, Complexo complexo) {
		return visitor.visitComplexo(complexo);
	}

	protected Numero accept(IVisitor visitor, Cientifico cietifico) {
		return null;
	}

	protected Numero accept(IVisitor visitor, Vetorial vetorial) {
		return null;
	}

	public List<Numero> getVetorNumeros() {
		return null;
	}

	public void setVetorNumeros(List<Numero> vetor) {

	}

	public Numero getExpoente() {
		return null;
	}

	public void setExpoente(Numero numero) {

	}
}