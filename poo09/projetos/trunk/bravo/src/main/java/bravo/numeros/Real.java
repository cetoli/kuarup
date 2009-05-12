package bravo.numeros;

import java.util.List;

import bravo.bases.BaseDecimalStrategy;
import bravo.bases.BaseStrategy;
import bravo.visitor.IVisitor;
import bravo.visitor.SomaVisitor;
import bravo.visitor.SubtracaoVisitor;

/**
 * Representa um numero real
 * 
 * @author leandrogomes
 * 
 */
public class Real extends Numero {

	public Real(Integer valor) {
		this.setValor(valor);
		this.setBase(new BaseDecimalStrategy());
	}

	@Override
	protected void adicionaUm() {
		this.valor = base.toDecimal(base.toBase(this.valor) + "1");
	}

	@Override
	public String mostrar() {
		return base.getPrefix() + base.toBase(this.valor);
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
		return visitor.visitReal(real);
	}

	@Override
	protected Numero accept(IVisitor visitor, ComplexoComposite complexo) {
		return visitor.visitReal(complexo);
	}

	@Override
	protected Numero accept(IVisitor visitor, CientificaComposite cientifico) {
		return visitor.visitReal(cientifico);
	}

	@Override
	protected Numero accept(IVisitor visitor, VetorialComposite vetorial) {
		return visitor.visitReal(vetorial);
	}

	@Override
	public Numero getParteImaginaria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Numero getParteReal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParteImaginaria(Numero parteImaginaria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParteReal(Numero parteReal) {

	}

	@Override
	public List<Numero> getVetorNumeros() {
		return null;
	}

	@Override
	public void setVetorNumeros(List<Numero> vetor) {
		// TODO Auto-generated method stub

	}

	@Override
	public BaseStrategy getBase() {
		return base;
	}

	@Override
	public void setBase(BaseStrategy base) {
		this.base = base;
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