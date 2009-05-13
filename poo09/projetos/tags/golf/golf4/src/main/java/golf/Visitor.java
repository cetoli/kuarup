package golf;

public interface Visitor {

	//public ValorBase visitarElemento(ValorBase acumulador, ValorBase atual);


	public ValorBase visitar(Valor acumulador, Valor atual);
	public ValorBase visitar(Complexo acumulador, Complexo atual);
	public ValorBase visitar(Engenharia acumulador, Engenharia atual);

	public ValorBase visitar (Valor ac, Complexo op);
	public ValorBase visitar (Complexo ac, Valor op);
	public ValorBase visitar (Complexo ac, Engenharia op);
	public ValorBase visitar (Engenharia ac, Complexo op);
	public ValorBase visitar (Engenharia ac, Valor op);
	public ValorBase visitar (Valor ac, Engenharia op);
}
