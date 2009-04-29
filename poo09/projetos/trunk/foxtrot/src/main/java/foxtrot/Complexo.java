package foxtrot;

/**
 * Write a description of class Complexo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complexo extends Valor
{
    private Valor[] valores;
    private int indiceAtual;

    private static final int INDICE_INT= 0;
    private static final int INDICE_COMPLEXO= 1;

    private static final int TAM_VETOR= 2;


    /**
     * Constructor for objects of class Complexo
     */
    public Complexo(Valor valorNovo) {
    	//* anterior sendo inteiro
    	valores= new Valor[TAM_VETOR];
        valores[INDICE_INT] = (Valor)valorNovo.clone();
        System.out.println ("inteiro: "+ valorNovo.valor);
        valores[INDICE_COMPLEXO]= (Valor)valorNovo.clone();
        valores[INDICE_COMPLEXO].valor= 0;
        //*/

    	/* Anterior sendo Complexo
        valorI = valorNovo;
        System.out.println ("Complexo: "+ valorNovo.valor);
        valorInt= (Valor)valorInt.clone();
        valorInt.valor= 0;
		*/

        indiceAtual= INDICE_COMPLEXO;
    }

    /**
     * Valor atual.
     *
     * @return retorna o valor selecionado atualmente.
     */
    private Valor getValorAtual() {
    	return valores[indiceAtual];
    }

    /**
     * Converte objeto em String.
     */
    public String toString() {
        return converterEmString();
    }

    /**
     * Gera String.
     */
    public String converterEmString() {
        return valores[INDICE_INT].toString() + "I" + valores[INDICE_COMPLEXO].toString();
    }

    /**
     * Limpa o valor.
     */
    public String limparValor() {
    	Valor valorI= valores[INDICE_COMPLEXO];
        valorI.limparValor();
        valorI.valor= 0;

        Valor valorInt= valores[INDICE_INT];
        valorInt.limparValor();
        valorInt.valor= 0;

        return "0";
    }

    /**
     * seleciona o Modo.
     */
    public Valor modoHexa() {
    	valores[INDICE_INT]= new ValorHex(valores[INDICE_INT].valor);
    	valores[INDICE_COMPLEXO]= new ValorHex(valores[INDICE_COMPLEXO].valor);

        return this;
    }

    /**
     * seleciona o Modo.
     */
    public Valor modoDec() {
    	valores[INDICE_INT]= new Valor(valores[INDICE_INT].valor);
    	valores[INDICE_COMPLEXO]= new Valor(valores[INDICE_COMPLEXO].valor);

        return this;
    }

    /**
     * seleciona o Modo.
     */
    public Valor modoBin() {
    	valores[INDICE_INT]= new ValorBin(valores[INDICE_INT].valor);
    	valores[INDICE_COMPLEXO]= new ValorBin(valores[INDICE_COMPLEXO].valor);

        return this;
    }

    /**
     * Calcula em cima do operador a soma.
     * @param o acumulador.
     */
    public void somar(Valor op) {
    	Complexo c= (Complexo)op;
    	Valor valor= getValorAtual();
        valor.somar(c.getValorAtual());
    }

    /**
     * Adiciona um digito a direita do valor atual.
     * @param d�gito a ser acrescentado.
     * @return retorna o valor armazenado no formato String.
     */
    public String adicionarDigito(String digito) {
    	Valor valorAtual= getValorAtual();
        valorAtual.adicionarDigito(digito);
        return toString();
    }

    /**
     * Funcao que clona o  elemento.
     * @return Retorna o objeto Valor clonado.
     */
    public Object clone () {
        Complexo c= new Complexo(valores[INDICE_INT]);

		c.valores[INDICE_COMPLEXO]= (Valor)valores[INDICE_COMPLEXO].clone();

		return c;
    }

    /**
     * Copia os valores do objeto.
     */
    public Valor copiar(Valor valor) {
    	Complexo c=(Complexo) valor.clone();

    	Complexo cValor= (Complexo) valor;

    	int indice= (indiceAtual+1)%TAM_VETOR;
    	c.valores[indice]= (Valor)valores[indice].clone();

    	return c;
    }

    /**
     * Modo inteiro.
     */
    public void modoInteiro() {
    	indiceAtual = INDICE_INT;
    }

    /**
     * Modo complexo.
     */
    public void modoComplexo() {
    	indiceAtual = INDICE_COMPLEXO;
    }

    /**
     * Instancia objeto Complexo.
     */
    public Complexo instanciarComplexo() {
    	modoComplexo();
    	return this;
    }

    /**
     * Soma todos os valores.
     */
    public void somarTudo(Valor atual) {
    	Complexo c= (Complexo) atual;
    	valores[INDICE_COMPLEXO].somar(c.valores[INDICE_COMPLEXO]);
    	valores[INDICE_INT].somar(c.valores[INDICE_INT]);
    }
}
