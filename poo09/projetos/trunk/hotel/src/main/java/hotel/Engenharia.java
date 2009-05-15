package hotel;

import java.util.Iterator;

public class Engenharia extends ValorBase {
    private ValorBase[] valores;

    private int indiceAtual;

    private static final int INDICE_MANTISSA = 0;

    private static final int INDICE_EXPOENTE = 1;

    private static final int TAM_VETOR = 2;

    private ImpressaoStrategy entrada;

    /**
         * Construtor que recebe a parte multiplicadora.
         */
    public Engenharia(ValorBase valorMult) {
	valores = new ValorBase[TAM_VETOR];
	valores[INDICE_MANTISSA] = valorMult;
	valores[INDICE_EXPOENTE] = (ValorBase) valorMult.clone();

	try {
	    valores[INDICE_EXPOENTE].impressao = new ImpressaoPadraoStrategy();
	    entrada = (ImpressaoStrategy) valorMult.impressao.clone();

	} catch (CloneNotSupportedException e) {
	    e.printStackTrace();
	}

	valores[INDICE_EXPOENTE].limparValor();
	indiceAtual = INDICE_EXPOENTE;
	impressao = new ImpressaoEngenhariaStrategy();
    }

    /**
         * Converte objeto em String.
         */
    public String toString() {
	return valores[INDICE_MANTISSA].toString() + "N"
		+ valores[INDICE_EXPOENTE].toString();
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
         * Gera String.
         */
    public String converterEmString() {
	return impressao.imprimir(this);
    }

    /**
         * Modo Hexadecimal.
         */
    public ValorBase modoHexa() {
	valores[INDICE_EXPOENTE].modoHexa();

	return this;
    }

    /**
         * Modo decimal.
         */
    public ValorBase modoDec() {
	valores[INDICE_EXPOENTE].modoDec();

	return this;
    }

    /**
         * Modo binario.
         */
    public ValorBase modoBin() {
	valores[INDICE_EXPOENTE].modoBin();

	return this;
    }

    public void impressaoBin() {
	valores[INDICE_MANTISSA].impressaoBin();
	valores[INDICE_EXPOENTE].impressaoBin();
    }

    public void impressaoDec() {
	valores[INDICE_MANTISSA].impressaoDec();
	valores[INDICE_EXPOENTE].impressaoDec();
    }

    public void impressaoHexa() {
	valores[INDICE_MANTISSA].impressaoHexa();
	valores[INDICE_EXPOENTE].impressaoHexa();
    }

    /**
         * Adiciona um digito.
         */
    public String adicionarDigito(String digito, ImpressaoStrategy modo,
	    ImpressaoStrategy modoImpressao) {
	valores[INDICE_EXPOENTE].impressao = modo;
	valores[INDICE_EXPOENTE].impressao.adicionarDigito(
		valores[INDICE_EXPOENTE], digito);

	valores[INDICE_EXPOENTE].impressao = modoImpressao;

	return impressao.imprimir(this);
    }

    /**
         * Limpa o valor do armazenado.
         *
         * @return retorna o valor convertido em String.
         */
    public String limparValor() {
	valor = 0;

	valores[INDICE_EXPOENTE].limparValor();
	valores[INDICE_MANTISSA].limparValor();
	indiceAtual = INDICE_MANTISSA;

	return converterEmString();
    }

    /**
         * Entra no modo inteiro.
         */
    public void modoInteiro() {
	indiceAtual = INDICE_MANTISSA;
    }

    /**
         * instancia modo de engenharia.
         */
    public ValorBase instanciarEngenharia() {
	indiceAtual = INDICE_EXPOENTE;
	return this;
    }

    /**
         * Funcao que clona o elemento.
         *
         * @return Retorna o objeto Valor clonado.
         */
    public Object clone() {
	Engenharia e = new Engenharia((ValorBase) valores[INDICE_MANTISSA]
		.clone());

	e.valores[INDICE_EXPOENTE] = (ValorBase) valores[INDICE_EXPOENTE]
		.clone();

	e.indiceAtual = INDICE_MANTISSA;

	try {
	    e.impressao = (ImpressaoStrategy) this.impressao.clone();
	    e.valores[INDICE_MANTISSA].impressao = valores[INDICE_MANTISSA].impressao;
	    e.valores[INDICE_EXPOENTE].impressao = valores[INDICE_EXPOENTE].impressao;
	    e.entrada = entrada;
	} catch (CloneNotSupportedException er) {
	    er.printStackTrace();
	}

	return e;
    }

    /**
         * O operador chama o visitor.
         *
         * @param visitor
         *                visitor.
         * @param acumulador .
         */
    public ValorBase aceitarVisita(Visitor visitor, Valor acumulador) {
	return visitor.visitar(acumulador, this);
    }

    /**
         * O operador chama o visitor.
         *
         * @param visitor
         *                visitor.
         * @param acumulador .
         */
    public ValorBase aceitarVisita(Visitor visitor, Complexo acumulador) {
	ValorBase v = acumulador.getValorInteiro();
	ValorBase respInt = v.aceitarVisita(visitor, this);
	Engenharia e = (Engenharia) respInt;
	e.valores[INDICE_MANTISSA].impressao = valores[INDICE_MANTISSA].impressao;
	e.valores[INDICE_EXPOENTE].impressao = valores[INDICE_EXPOENTE].impressao;

	Complexo c = new Complexo(respInt);
	c.setValorComplexo((ValorBase) acumulador.getValorComplexo().clone());
	((Engenharia) c.getValorComplexo()).getValorMantissa().impressao = valores[INDICE_MANTISSA].impressao;

	return c;
    }

    /**
         * O operador chama o visitor.
         *
         * @param visitor
         *                visitor.
         * @param acumulador .
         */
    public ValorBase aceitarVisita(Visitor visitor, Engenharia acumulador) {
	return visitor.visitar(acumulador, this);
    }

    public Engenharia aceitarVisitaEngenharia(VisitorSoma soma) {
	return this;
    }

    /**
         * O operador chama o visitor.
         *
         * @param visitor
         *                visitor.
         * @param acumulador .
         */
    public ValorBase aceitarVisita(Visitor visitor, Vetor acumulador) {
	ValorBase escalar = acumulador.getEscalar().aceitarVisitaOperador(
		visitor, this);
	Vetor vetor = new Vetor(escalar);

	Iterator<ValorBase> it = acumulador.getIterator();

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resElem = it.next().aceitarVisitaOperador(visitor, this);
	    vetor.setVetor(cont, resElem);
	    vetor.instanciarVetor();
	}

	vetor.removerUltimoVetor();

	return vetor;
    }

    /**
         * Retorna o valor expoente.
         *
         * @return valor expoente.
         */
    public ValorBase getValorExpoente() {
	return valores[INDICE_EXPOENTE];
    }

    /**
         * Retorna o valor mantissa.
         *
         * @return valor mantissa.
         */
    public ValorBase getValorMantissa() {
	return valores[INDICE_MANTISSA];
    }

    /**
         * Guarda o valor do expoente.
         *
         * @param novo
         *                valor expoente.
         */
    public void setValorExpoente(ValorBase novo) {
	valores[INDICE_EXPOENTE] = novo;
    }

    /**
         * Guarda o valor da mantissa.
         *
         * @param novo
         *                valor mantissa.
         */
    public void setValorMantissa(ValorBase novo) {
	valores[INDICE_MANTISSA] = novo;
    }

    public ValorBase instanciarComplexo() {
	return new Complexo(this);
    }

    public void modoComplexo() {

    }

    public ValorBase somar(ValorBase obj) {
	Visitor visitor = new VisitorSoma();
	return obj.aceitarVisita(visitor, this);
    }

    public ImpressaoStrategy getModoImpressao() {
	return valores[INDICE_EXPOENTE].getModoImpressao();
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

    public int getValor() {
	return (int) (valores[INDICE_MANTISSA].getValor()); // *Math.pow(10,
	// valores[INDICE_EXPOENTE].getValor()));
    }

}
