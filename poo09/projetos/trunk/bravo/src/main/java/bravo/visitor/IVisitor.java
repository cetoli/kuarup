package bravo.visitor;

import bravo.numeros.CientificaComposite;
import bravo.numeros.ComplexoComposite;
import bravo.numeros.Numero;
import bravo.numeros.Real;
import bravo.numeros.VetorialComposite;

/**
 * Interface que representa um visitor para realizar operacoes com todos os
 * tipos de numero
 * 
 * @author leandrogomes e humberto
 * 
 */
public interface IVisitor {
	// Reais
	public Numero visitReal(Real real);

	public Numero visitReal(ComplexoComposite complexo);

	public Numero visitReal(CientificaComposite cientifico);

	public Numero visitReal(VetorialComposite vetorial);

	// Complexos
	public Numero visitComplexo(Real real);

	public Numero visitComplexo(ComplexoComposite complexoComposite);

	public Numero visitComplexo(CientificaComposite cientifico);

	public Numero visitComplexo(VetorialComposite vetorial);

	// Cientifico
	public Numero visitCientifico(Real real);

	public Numero visitCientifico(ComplexoComposite complexoComposite);

	public Numero visitCientifico(CientificaComposite cientifico);

	public Numero visitCientifico(VetorialComposite vetorial);

	// Vetoriais
	public Numero visitVetorial(Real real);

	public Numero visitVetorial(ComplexoComposite complexoComposite);

	public Numero visitVetorial(CientificaComposite cientifico);

	public Numero visitVetorial(VetorialComposite vetorial);
}