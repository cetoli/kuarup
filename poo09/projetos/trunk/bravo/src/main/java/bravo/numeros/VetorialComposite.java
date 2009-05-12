package bravo.numeros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bravo.bases.BaseStrategy;
import bravo.visitor.IVisitor;
import bravo.visitor.SomaVisitor;
import bravo.visitor.SubtracaoVisitor;

/**
 * Representa um numero vetorial
 * 
 * @author leandrogomes e Humberto
 * 
 */
public class VetorialComposite extends Numero {

	private static final String VETORIAL_PREFIX = "V";
	private List<Numero> numeros;

	public VetorialComposite(Numero numero) {
		this.base = numero.getBase();
		numeros = new ArrayList<Numero>();
		numeros.add(numero);
		numeros.add(new Real(0));
		this.setBase(base);
	}

	/**
	 * Atualiza a base
	 */
	@Override
	public void setBase(BaseStrategy base) {
		this.base = base;
		for (Numero numero : numeros) {
			numero.setBase(base);
		}
	}

	/**
	 * Recupera a base
	 */
	@Override
	public BaseStrategy getBase() {
		return this.base;
	}

	@Override
	protected Numero accept(IVisitor visitor, Real real) {
		return visitor.visitVetorial(real);
	}

	@Override
	protected Numero accept(IVisitor visitor, ComplexoComposite complexo) {
		return visitor.visitVetorial(complexo);
	}

	@Override
	protected Numero accept(IVisitor visitor, CientificaComposite cientifico) {
		return visitor.visitVetorial(cientifico);
	}

	@Override
	protected Numero accept(IVisitor visitor, VetorialComposite vetorial) {
		return visitor.visitVetorial(vetorial);
	}

	@Override
	protected void adicionaUm() {
		Numero ultimoNumero = numeros.get(numeros.size() - 1);
		ultimoNumero.entraUm();
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

	/**
	 * Converte para strings
	 */
	@Override
	public String mostrar() {
		StringBuilder resultado = new StringBuilder("");

		Iterator<Numero> numerosIterator = numeros.iterator();
		Numero primeiraParte = numerosIterator.next();
		resultado.append(primeiraParte.mostrar());

		for (; numerosIterator.hasNext();) {
			Numero numero = numerosIterator.next();
			resultado.append(VETORIAL_PREFIX);
			resultado.append(numero.mostrar());
		}

		return resultado.toString();
	}

	@Override
	public void setParteImaginaria(Numero parteImaginaria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParteReal(Numero parteReal) {
		// TODO Auto-generated method stub

	}

	/**
	 * soma 2 numeros
	 */
	@Override
	public Numero soma(Numero numero) {
		return numero.accept(new SomaVisitor(numero), this);
	}

	/**
	 * subtrai 2 numeros
	 */
	@Override
	public Numero subtrai(Numero numero) {
		return numero.accept(new SubtracaoVisitor(numero), this);
	}

	@Override
	public List<Numero> getVetorNumeros() {
		return numeros;
	}

	@Override
	public void setVetorNumeros(List<Numero> vetor) {
		this.numeros = vetor;
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