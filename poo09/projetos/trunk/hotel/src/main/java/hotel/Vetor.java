package hotel;

import java.util.Iterator;
import java.util.LinkedList;

public class Vetor extends ValorBase {

    private ValorBase escalar;

    private LinkedList<ValorBase> vetor;

    public Vetor(ValorBase valor) {
	escalar = (ValorBase) valor.clone();
	vetor = new LinkedList<ValorBase>();
	vetor.addLast(new Valor());
	// vetor = (ValorBase) valor.clone();
	// vetor.limparValor();

	impressao = new ImpressaoVetorStrategy();
    }

    /**
         * Limpa o valor.
         */
    public String limparValor() {
	escalar.limparValor();

	/*
         * Iterator<ValorBase> it = vetor.iterator();
         * 
         * while (it.hasNext()) it.next().limparValor();
         */

	vetor.clear();

	return "0";
    }

    public ValorBase aceitarVisita(Visitor visitor, Valor acumulador) {
	ValorBase resEscalar = escalar.aceitarVisita(visitor, acumulador);

	Iterator<ValorBase> it = vetor.iterator();

	Vetor vetor = new Vetor(resEscalar);

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resVetor = it.next().aceitarVisita(visitor, acumulador);
	    vetor.setVetor(cont, resVetor);

	}

	return vetor;
    }

    public ValorBase aceitarVisita(Visitor visitor, Complexo acumulador) {
	ValorBase resEscalar = escalar.aceitarVisita(visitor, acumulador);

	Iterator<ValorBase> it = vetor.iterator();

	Vetor vetor = new Vetor(resEscalar);

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resVetor = it.next().aceitarVisita(visitor, acumulador);
	    vetor.setVetor(cont, resVetor);

	}

	return vetor;
    }

    public ValorBase aceitarVisita(Visitor visitor, Engenharia acumulador) {
	ValorBase resEscalar = escalar.aceitarVisita(visitor, acumulador);

	Iterator<ValorBase> it = vetor.iterator();

	Vetor vetor = new Vetor(resEscalar);

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resVetor = it.next().aceitarVisita(visitor, acumulador);
	    vetor.setVetor(cont, resVetor);
	}

	return vetor;
    }

    // nao existe essa opcao.
    public ValorBase aceitarVisita(Visitor visitor, Vetor acumulador) {
	return this;
    }

    public String adicionarDigito(String digito, ImpressaoStrategy modo,
	    ImpressaoStrategy modoImpressao) {

	vetor.getLast().adicionarDigito(digito, modo, modoImpressao);

	return impressao.imprimir(this);
    }

    public Object clone() {
	Vetor v = new Vetor((ValorBase) escalar.clone());

	try {

	    Iterator<ValorBase> it = vetor.iterator();

	    while (it.hasNext()) {
		ValorBase proximo = it.next();
		ValorBase obj = (ValorBase) proximo.clone();
		obj.impressao = (ImpressaoStrategy) proximo.impressao.clone();
		vetor.add(obj);
	    }

	} catch (CloneNotSupportedException er) {
	    er.printStackTrace();
	}

	return v;
    }

    public String converterEmString() {

	String str = escalar.converterEmString();

	Iterator<ValorBase> it = vetor.iterator();

	while (it.hasNext()) {
	    str += "V" + it.next().converterEmString();
	}

	return str;
    }

    public ImpressaoStrategy getModoImpressao() {
	return impressao;
    }

    public void impressaoBin() {
	escalar.impressaoBin();

	Iterator<ValorBase> it = vetor.iterator();

	while (it.hasNext()) {
	    it.next().impressaoBin();
	}

    }

    public void impressaoDec() {
	escalar.impressaoDec();

	Iterator<ValorBase> it = vetor.iterator();

	while (it.hasNext()) {
	    it.next().impressaoDec();
	}
    }

    public void impressaoHexa() {
	escalar.impressaoHexa();

	Iterator<ValorBase> it = vetor.iterator();

	while (it.hasNext()) {
	    it.next().impressaoHexa();
	}
    }

    public ValorBase instanciarComplexo() {
	vetor.set(vetor.size() - 1, vetor.getLast().instanciarComplexo());

	return this;
    }

    public ValorBase instanciarEngenharia() {
	vetor.set(vetor.size() - 1, vetor.getLast().instanciarEngenharia());

	return this;
    }

    public ValorBase modoBin() {
	vetor.getLast().modoBin();

	return this;
    }

    public void modoComplexo() {

    }

    public ValorBase modoDec() {
	vetor.getLast().modoDec();

	return this;
    }

    public ValorBase modoHexa() {
	vetor.getLast().modoHexa();

	return this;
    }

    public void modoInteiro() {

    }

    public ValorBase somar(ValorBase obj) {
	Visitor visitor = new VisitorSoma();

	return obj.aceitarVisita(visitor, this);
    }

    public ValorBase instanciarVetor() {

	vetor.addLast((ValorBase) vetor.getLast().clone());
	vetor.getLast().limparValor();

	return this;
    }

    public void setEscalar(ValorBase escalar) {
	this.escalar = escalar;
    }

    public void setVetor(ValorBase vetor) {
	this.vetor.add(vetor);
    }

    public ValorBase getEscalar() {
	return escalar;
    }

    public ValorBase getVetor() {
	return vetor.getLast();
    }

    public ValorBase getVetorIndice(int indice) {
	return vetor.get(indice);
    }

    public ValorBase subtrair(ValorBase atual) {
	Visitor visitor = new VisitorSubtracao();

	return atual.aceitarVisita(visitor, this);
    }

    public String toString() {
	return converterEmString();
    }

    public ValorBase aceitarVisitaOperador(Visitor visitor, Valor operador) {
	ValorBase resEscalar = escalar.aceitarVisita(visitor, operador);

	Vetor vetorResp = new Vetor(resEscalar);

	Iterator<ValorBase> it = vetor.iterator();

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resElem = it.next().aceitarVisita(visitor, operador);
	    vetorResp.setVetor(cont, resElem);

	}

	return vetorResp;
    }

    public ValorBase aceitarVisitaOperador(Visitor visitor, Complexo operador) {
	ValorBase resEscalar = escalar.aceitarVisita(visitor, operador);

	Vetor vetorResp = new Vetor(resEscalar);

	Iterator<ValorBase> it = vetor.iterator();

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resElem = it.next().aceitarVisita(visitor, operador);
	    vetorResp.setVetor(cont, resElem);

	}

	return vetorResp;
    }

    public void setVetor(int cont, ValorBase respElem) {
	vetor.set(cont, respElem);
    }

    public ValorBase aceitarVisitaOperador(Visitor visitor, Engenharia operador) {
	ValorBase resEscalar = escalar.aceitarVisita(visitor, operador);

	Vetor vetorResp = new Vetor(resEscalar);

	Iterator<ValorBase> it = vetor.iterator();

	for (int cont = 0; it.hasNext(); cont++) {
	    ValorBase resElem = it.next().aceitarVisita(visitor, operador);
	    vetorResp.setVetor(cont, resElem);

	}

	return vetorResp;
    }

    public Iterator<ValorBase> getIterator() {
	return vetor.iterator();
    }

    public void removerUltimoVetor() {
	vetor.removeLast();
    }
}
