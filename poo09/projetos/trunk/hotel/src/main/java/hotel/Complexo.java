package hotel;

import java.util.Iterator;

/**
 * Write a description of class Complexo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complexo extends ValorBase {
    private ValorBase[] valores;

    private int indiceAtual;

    private static final int INDICE_INT = 0;

    private static final int INDICE_COMPLEXO = 1;

    private static final int TAM_VETOR = 2;

    /**
         * Constructor for objects of class Complexo
         */
    public Complexo(ValorBase valorNovo) {

	valores = new ValorBase[TAM_VETOR];
	valores[INDICE_INT] = valorNovo;
	valores[INDICE_COMPLEXO] = new Valor();
	valores[INDICE_COMPLEXO].impressao = new ImpressaoPadraoStrategy();

	indiceAtual = INDICE_COMPLEXO;

	impressao = new ImpressaoComplexoStrategy();
    }

    /**
         * Valor atual.
         * 
         * @return retorna o valor selecionado atualmente.
         */
    private ValorBase getValorAtual() {
	return valores[indiceAtual];
    }

    /**
         * Converte objeto em String.
         */
    public String toString() {
	return valores[INDICE_INT].toString() + "I"
		+ valores[INDICE_COMPLEXO].toString();
    }

    /**
         * Gera String.
         */
    public String converterEmString() {
	return impressao.imprimir(this);
    }

    /**
         * Limpa o valor.
         */
    public String limparValor() {
	ValorBase valorI = valores[INDICE_COMPLEXO];
	valorI.limparValor();
	valorI.valor = 0;

	ValorBase valorInt = valores[INDICE_INT];
	valorInt.limparValor();
	valorInt.valor = 0;

	return "0";
    }

    /**
         * seleciona o Modo.
         */
    public ValorBase modoHexa() {
	valores[INDICE_COMPLEXO].modoHexa();

	return this;
    }

    /**
         * seleciona o Modo.
         */
    public ValorBase modoDec() {
	valores[INDICE_COMPLEXO].modoDec();

	return this;
    }

    /**
         * seleciona o Modo.
         */
    public ValorBase modoBin() {
	valores[INDICE_COMPLEXO].modoBin();

	return this;
    }

    public void impressaoBin() {
	valores[INDICE_INT].impressaoBin();
	valores[INDICE_COMPLEXO].impressaoBin();
    }

    public void impressaoDec() {
	valores[INDICE_INT].impressaoDec();
	valores[INDICE_COMPLEXO].impressaoDec();
    }

    public void impressaoHexa() {
	valores[INDICE_INT].impressaoHexa();
	valores[INDICE_COMPLEXO].impressaoHexa();
    }

    /**
         * Adiciona um digito a direita do valor atual.
         * 
         * @param d�gito
         *                a ser acrescentado.
         * @return retorna o valor armazenado no formato String.
         */
    public String adicionarDigito(String digito, ImpressaoStrategy modo,
	    ImpressaoStrategy modoImpressao) {
	valores[INDICE_COMPLEXO].adicionarDigito(digito, modo, modoImpressao);

	return impressao.imprimir(this);
    }

    /**
         * Funcao que clona o elemento.
         * 
         * @return Retorna o objeto Valor clonado.
         */
    public Object clone() {
	Complexo c = new Complexo((ValorBase) valores[INDICE_INT].clone());

	c.valores[INDICE_COMPLEXO] = (ValorBase) valores[INDICE_COMPLEXO]
		.clone();

	try {
	    c.impressao = (ImpressaoStrategy) this.impressao.clone();
	    c.valores[INDICE_INT].impressao = valores[INDICE_INT].impressao;
	    c.valores[INDICE_COMPLEXO].impressao = valores[INDICE_COMPLEXO].impressao;
	} catch (CloneNotSupportedException er) {
	    er.printStackTrace();
	}

	return c;
    }

    /**
         * Copia os valores do objeto.
         */
    public ValorBase copiar(ValorBase valor) {
	Complexo c = (Complexo) valor.clone();

	int indice = (indiceAtual + 1) % TAM_VETOR;
	c.valores[indice] = (ValorBase) valores[indice].clone();

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
    public ValorBase instanciarComplexo() {
	modoComplexo();
	return this;
    }

    public ValorBase instanciarEngenharia() {
	valores[INDICE_COMPLEXO] = valores[INDICE_COMPLEXO]
		.instanciarEngenharia();

	return this;
    }

    /**
         * O operador chama o visitor.
         * 
         * @param visitor
         *                visitor.
         * @param acumulador.
         */
    public ValorBase aceitarVisita(Visitor visitor, Valor acumulador) {

	ValorBase v = this.getValorInteiro();
	v.aceitarVisita(visitor, acumulador);

	return visitor.visitar(acumulador, this);
    }

    /**
         * O operador chama o visitor.
         * 
         * @param visitor
         *                visitor.
         * @param acumulador.
         */
    public ValorBase aceitarVisita(Visitor visitor, Complexo acumulador) {

	return visitor.visitar(acumulador, this);
    }

    /**
         * O operador chama o visitor.
         * 
         * @param visitor
         *                visitor.
         * @param acumulador.
         */
    public ValorBase aceitarVisita(Visitor visitor, Engenharia acumulador) {

	ValorBase v = this.getValorInteiro();
	ValorBase respInt = v.aceitarVisita(visitor, acumulador);

	Complexo c = new Complexo(respInt);
	c.setValorComplexo((ValorBase) getValorComplexo().clone());

	return c;
    }

    /**
         * O operador chama o visitor.
         * 
         * @param visitor
         *                visitor.
         * @param acumulador.
         */
    public ValorBase aceitarVisita(Visitor visitor, Vetor acumulador) {
	ValorBase escalar = acumulador.getEscalar()
		.aceitarVisita(visitor, this);
	Vetor vetor = new Vetor(escalar);

	Iterator<ValorBase> it = acumulador.getIterator();

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resElem = it.next().aceitarVisita(visitor, this);
	    vetor.setVetor(cont, resElem);
	    vetor.instanciarVetor();
	}

	vetor.removerUltimoVetor();

	return vetor;
    }

    /**
         * Retorna o valor inteiro.
         * 
         * @return valor inteiro.
         */
    public ValorBase getValorInteiro() {
	return valores[INDICE_INT];
    }

    /**
         * Retorna o valor complexo.
         * 
         * @return valor complexo.
         */
    public ValorBase getValorComplexo() {
	return valores[INDICE_COMPLEXO];
    }

    /**
         * Altera o valor inteiro.
         * 
         * @param novo
         *                valor inteiro.
         */
    public void setValorInteiro(ValorBase novo) {
	valores[INDICE_INT] = novo;
    }

    /**
         * Altera o valor complexo.
         * 
         * @param novo
         *                valor complexo.
         */
    public void setValorComplexo(ValorBase novo) {
	valores[INDICE_COMPLEXO] = novo;
    }

    public ValorBase somar(ValorBase obj) {
	Visitor visitor = new VisitorSoma();
	return obj.aceitarVisita(visitor, this);
    }

    public ImpressaoStrategy getModoImpressao() {
	return valores[INDICE_COMPLEXO].getModoImpressao();
    }

    public ValorBase instanciarVetor() {
	return new Vetor(this);
    }

    public ValorBase subtrair(ValorBase atual) {
	Visitor visitor = new VisitorSubtracao();

	return atual.aceitarVisita(visitor, this);
    }

    public ValorBase aceitarVisitaOperador(Visitor visitor, Valor operador) {
	return visitor.visitar(this, operador);
    }

    public ValorBase aceitarVisitaOperador(Visitor visitor, Complexo operador) {
	return visitor.visitar(this, operador);
    }

    public ValorBase aceitarVisitaOperador(Visitor visitor, Engenharia operador) {
	return visitor.visitar(this, operador);
    }
}
