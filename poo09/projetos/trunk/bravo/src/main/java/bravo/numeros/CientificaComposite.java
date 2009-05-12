package bravo.numeros;

import java.util.List;

import bravo.bases.BaseStrategy;
import bravo.visitor.IVisitor;
import bravo.visitor.SomaVisitor;
import bravo.visitor.SubtracaoVisitor;

/**
 * Representa um numero cientifico. Ex.: 1N1 = 1.0 * 10^1
 * 
 * @author leandrogomes e Humberto
 * 
 */
public class CientificaComposite extends Numero {

	private Numero mantissa;

	private Numero expoente;

	public CientificaComposite(Numero numero) {
		this.mantissa = numero;
		this.expoente = new Real(0);
		this.expoente.setBase(this.mantissa.getBase());
	}

	/**
	 * Entra com o digito 1
	 */
	@Override
	protected void adicionaUm() {
		this.expoente.valor = this.mantissa.getBase().toDecimal(
				this.mantissa.getBase().toBase(this.expoente.getValor()) + "1");
	}

	/**
	 * Converte para string
	 */
	@Override
	public String mostrar() {
		return this.mantissa.mostrar() + "N"
				+ this.mantissa.getBase().toBase(this.expoente.getValor());
	}

	/**
	 * Atualiza a base
	 */
	@Override
	public void setBase(BaseStrategy base) {
		this.mantissa.setBase(base);
		this.expoente.setBase(base);
	}

	/**
	 * Recupera a base
	 */
	@Override
	public BaseStrategy getBase() {
		return this.mantissa.getBase();
	}

	/**
	 * soma os dois numeros
	 */
	@Override
	public Numero soma(Numero numero) {
		return numero.accept(new SomaVisitor(numero), this);
	}

	/**
	 * subtrai dois numeros
	 */
	@Override
	public Numero subtrai(Numero numero) {
		return numero.accept(new SubtracaoVisitor(numero), this);
	}

	@Override
	protected Numero accept(IVisitor visitor, Real real) {
		return visitor.visitCientifico(real);
	}

	@Override
	protected Numero accept(IVisitor visitor, ComplexoComposite complexo) {
		return visitor.visitCientifico(complexo);
	}

	@Override
	protected Numero accept(IVisitor visitor, CientificaComposite cientifico) {
		return visitor.visitCientifico(cientifico);
	}

	@Override
	protected Numero accept(IVisitor visitor, VetorialComposite vetorial) {
		return visitor.visitCientifico(vetorial);
	}

	@Override
	public Numero getParteImaginaria() {
		return null;
	}

	@Override
	public Numero getParteReal() {
		return mantissa;
	}

	@Override
	public void setParteImaginaria(Numero parteImaginaria) {
	}

	@Override
	public void setParteReal(Numero parteReal) {
		this.mantissa = parteReal;
	}

	@Override
	public List<Numero> getVetorNumeros() {
		return null;
	}

	@Override
	public void setVetorNumeros(List<Numero> vetor) {
	}

	@Override
	public Numero getExpoente() {
		return expoente;
	}

	@Override
	public void setExpoente(Numero numero) {
		this.expoente = numero;
	}
}