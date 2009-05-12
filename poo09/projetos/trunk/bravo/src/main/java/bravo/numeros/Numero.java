package bravo.numeros;

import java.util.List;

import bravo.bases.BaseStrategy;
import bravo.visitor.IVisitor;

/**
 * Representa um numero
 * 
 * @author leandrogomes e humberto
 * 
 */
public abstract class Numero {
	/**
	 * base na qual o numero está
	 */
	BaseStrategy base;

	// valor do numero
	Integer valor = new Integer(0);

	/**
	 * converte o numero para string
	 * 
	 * @return
	 */
	public abstract String mostrar();

	/**
	 * soma 2 numeros
	 * 
	 * @param numero
	 * @return
	 */
	public abstract Numero soma(Numero numero);

	/**
	 * subtrai 2 numeros
	 * 
	 * @param numero
	 * @return
	 */
	public abstract Numero subtrai(Numero numero);

	/**
	 * Entra com o digito 1
	 */
	protected abstract void adicionaUm();

	/**
	 * Entra com o digito 1 e mostra o resultado
	 */
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

	/**
	 * recupera a base
	 * 
	 * @return
	 */
	public abstract BaseStrategy getBase();

	/**
	 * atualiza a base
	 * 
	 * @param base
	 */
	public abstract void setBase(BaseStrategy base);

	/**
	 * recupera o expoente de um numero cientifico
	 * 
	 * @return
	 */
	public abstract Numero getExpoente();

	public abstract void setExpoente(Numero numero);

	/**
	 * recupera a parte real de um numero
	 * 
	 * @return
	 */
	public abstract Numero getParteReal();

	public abstract void setParteReal(Numero parteReal);

	/**
	 * recupera a parte imaginario de um numero
	 * 
	 * @return
	 */
	public abstract Numero getParteImaginaria();

	/**
	 * recupera a lista de numeros usada para representar o numero vetorial
	 * 
	 * @return
	 */
	public abstract List<Numero> getVetorNumeros();

	public abstract void setVetorNumeros(List<Numero> vetor);

	public abstract void setParteImaginaria(Numero parteImaginaria);

	/**
	 * método que diz se aceita ou nao o visitor
	 * 
	 * @param visitor
	 * @param real
	 * @return
	 */
	protected abstract Numero accept(IVisitor visitor, Real real);

	/**
	 * método que diz se aceita ou nao o visitor
	 * 
	 * @param visitor
	 * @param complexo
	 * @return
	 */
	protected abstract Numero accept(IVisitor visitor,
			ComplexoComposite complexo);

	/**
	 * método que diz se aceita ou nao o visitor
	 * 
	 * @param visitor
	 * @param cientifico
	 * @return
	 */
	protected abstract Numero accept(IVisitor visitor,
			CientificaComposite cientifico);

	/**
	 * método que diz se aceita ou nao o visitor
	 * 
	 * @param visitor
	 * @param vetorial
	 * @return
	 */
	protected abstract Numero accept(IVisitor visitor,
			VetorialComposite vetorial);
}