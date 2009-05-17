package charlie;

public interface IVisitor {

	public Numero visitReal(Real real);
	public Numero visitReal(Complexo complexo);
	public Numero visitReal(Cientifico cientifico);
	public Numero visitReal(Vetorial vetorial);

	public Numero visitComplexo(Real real);
	public Numero visitComplexo(Complexo complexoComposite);
	public Numero visitComplexo(Cientifico cientifico);
	public Numero visitComplexo(Vetorial vetorial);

	public Numero visitCientifico(Real real);
	public Numero visitCientifico(Complexo complexoComposite);
	public Numero visitCientifico(Cientifico cientifico);
	public Numero visitCientifico(Vetorial vetorial);

	public Numero visitVetorial(Real real);
	public Numero visitVetorial(Complexo complexoComposite);
	public Numero visitVetorial(Cientifico cientifico);
	public Numero visitVetorial(Vetorial vetorial);
}