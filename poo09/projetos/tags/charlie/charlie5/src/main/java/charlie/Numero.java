package charlie;

import java.util.List;

public abstract class Numero {

	StrategyBase base;
	Integer valor = new Integer(0);

	public abstract String mostrar();

	public abstract Numero soma(Numero numero);

	public abstract Numero subtrai(Numero numero);

	protected abstract void adicionaUm();

	public String entraUm() {
		adicionaUm();
		return mostrar();
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public abstract StrategyBase getBase();

	public abstract void setBase(StrategyBase base);

	public abstract Numero getExpoente();

	public abstract void setExpoente(Numero numero);

	public abstract Numero getParteReal();

	public abstract void setParteReal(Numero parteReal);

	public abstract Numero getParteImaginaria();

	public abstract List<Numero> getVetorNumeros();

	public abstract void setVetorNumeros(List<Numero> vetor);

	public abstract void setParteImaginaria(Numero parteImaginaria);

	protected abstract Numero accept(IVisitor visitor, Real real);

	protected abstract Numero accept(IVisitor visitor, Complexo complexo);

	protected abstract Numero accept(IVisitor visitor, Cientifico cientifico);

	protected abstract Numero accept(IVisitor visitor, Vetorial vetorial);
}