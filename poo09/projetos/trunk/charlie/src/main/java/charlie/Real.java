package charlie;

import java.util.List;

public class Real extends Numero {

	public Real(Integer valor) {
		this.setValor(valor);
		this.setBase(new BaseDecimal());
	}

	protected void adicionaUm() {
		this.valor = base.toDecimal(base.converterBase(this.valor) + "1");
	}

	public String mostrar() {
		return base.getId() + base.converterBase(this.valor);
	}

	public Numero soma(Numero numero) {
		return numero.accept(new SomaVisitor(numero), this);
	}

	public Numero subtrai(Numero numero) {
		return numero.accept(new SubtracaoVisitor(numero), this);
	}

	protected Numero accept(IVisitor visitor, Real real) {
		return visitor.visitReal(real);
	}

	protected Numero accept(IVisitor visitor, Complexo complexo) {
		return visitor.visitReal(complexo);
	}

	protected Numero accept(IVisitor visitor, Cientifico cientifico) {
		return visitor.visitReal(cientifico);
	}

	protected Numero accept(IVisitor visitor, Vetorial vetorial) {
		return visitor.visitReal(vetorial);
	}

	public Numero getParteImaginaria() {
		return null;
	}

	public Numero getParteReal() {
		return null;
	}

	public void setParteImaginaria(Numero parteImaginaria) {

	}

	public void setParteReal(Numero parteReal) {

	}

	public List<Numero> getVetorNumeros() {
		return null;
	}

	public void setVetorNumeros(List<Numero> vetor) {

	}

	public StrategyBase getBase() {
		return base;
	}

	public void setBase(StrategyBase base) {
		this.base = base;
	}

	public Numero getExpoente() {
		return null;
	}

	public void setExpoente(Numero numero) {

	}
}