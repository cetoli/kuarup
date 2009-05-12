package bravo.numeros;

import java.util.List;

import bravo.bases.BaseStrategy;
import bravo.visitor.IVisitor;
import bravo.visitor.SomaVisitor;
import bravo.visitor.SubtracaoVisitor;

/**
 * Representa um numero complexo
 * 
 * @author leandrogomes
 * 
 */
public class ComplexoComposite extends Numero {

	private Numero parteReal;

	private Numero parteImaginaria;

	public ComplexoComposite(Numero numero) {
		this.parteReal = numero;
		this.base = numero.getBase();
		this.parteImaginaria = new Real(0);
		this.parteImaginaria.setBase(this.parteReal.getBase());
	}

	/**
	 * recupera a parte real do numero complexo
	 */
	public Numero getParteReal() {
		return parteReal;
	}

	public void setParteReal(Numero parteReal) {
		this.parteReal = parteReal;
	}

	/**
	 * recupera a parte imaginaria do complexo
	 */
	public Numero getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(Numero parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	/**
	 * Atualiza a base
	 */
	@Override
	public void setBase(BaseStrategy base) {
		this.base = base;
		this.parteReal.setBase(base);
		this.parteImaginaria.setBase(base);
	}

	/**
	 * recupera a base
	 */
	@Override
	public BaseStrategy getBase() {
		return this.base;
	}

	/**
	 * entra com o digito 1
	 */
	@Override
	protected void adicionaUm() {
		this.parteImaginaria.valor = parteImaginaria.getBase().toDecimal(
				parteImaginaria.getBase().toBase(
						this.parteImaginaria.getValor())
						+ "1");
	}

	/**
	 * converte para string
	 */
	@Override
	public String mostrar() {
		return parteReal.mostrar() + "I" + parteImaginaria.mostrar();
	}

	@Override
	public Numero soma(Numero numero) {
		return numero.accept(new SomaVisitor(numero), this);
	}

	@Override
	public Numero subtrai(Numero numero) {
		return numero.accept(new SubtracaoVisitor(numero), this);
	}

	@Override
	protected Numero accept(IVisitor visitor, Real real) {
		return visitor.visitComplexo(real);
	}

	@Override
	protected Numero accept(IVisitor visitor, ComplexoComposite complexo) {
		return visitor.visitComplexo(complexo);
	}

	@Override
	protected Numero accept(IVisitor visitor, CientificaComposite cietifico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Numero accept(IVisitor visitor, VetorialComposite vetorial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Numero> getVetorNumeros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVetorNumeros(List<Numero> vetor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Numero getExpoente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExpoente(Numero numero) {
		// TODO Auto-generated method stub

	}
}