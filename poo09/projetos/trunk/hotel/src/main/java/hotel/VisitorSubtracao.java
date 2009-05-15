package hotel;

public class VisitorSubtracao implements Visitor {
    public ValorBase visitar(Valor ac, Valor op) {
	ValorBase resultado = (ValorBase) op.clone();

	resultado.setValor(ac.getValor() - op.getValor());

	resultado.impressao = op.impressao;

	return resultado;
    }

    private Complexo calcularDiferencaComplexo(ValorBase modoInt,
	    ValorBase modoCompl, int intAc, int complAc, int intOp, int complOp) {

	int ac = intAc - intOp;
	int compl = complAc - complOp;

	modoInt.setValor(ac);
	Complexo c = new Complexo(modoInt);

	modoCompl.setValor(compl);
	c.setValorComplexo(modoCompl);

	return c;
    }

    /**
         * TESTAR para o modo complexo do vetor. Ex: 11N1 V11N1 I1N1 + 30.
         * Conferir o getValor do Engenharia. Talvez deva retornar s� a
         * mantissa.
         */
    public ValorBase visitar(Valor ac, Complexo op) {

	ValorBase modoInt = (ValorBase) op.getValorInteiro().clone();
	modoInt.impressao = op.getValorInteiro().impressao;

	ValorBase modoCompl = (ValorBase) op.getValorComplexo().clone();
	modoCompl.impressao = op.getValorComplexo().impressao;

	ValorBase resultado = calcularDiferencaComplexo(modoInt, modoCompl, ac
		.getValor(), 0, op.getValorInteiro().getValor(), op
		.getValorComplexo().getValor());

	return resultado;
    }

    public ValorBase visitar(Complexo ac, Valor op) {
	ValorBase modoInt = (ValorBase) ac.getValorInteiro().clone();
	modoInt.impressao = op.impressao;
	ValorBase modoCompl = (ValorBase) ac.getValorComplexo().clone();
	modoCompl.impressao = op.impressao;

	ValorBase resultado = calcularDiferencaComplexo(modoInt, modoCompl, ac
		.getValorInteiro().getValor(),
		ac.getValorComplexo().getValor(), op.getValor(), 0);

	return resultado;
    }

    public ValorBase visitar(Complexo ac, Complexo op) {

	ValorBase modoInt = (ValorBase) op.getValorInteiro().clone();
	modoInt.impressao = op.getModoImpressao();
	ValorBase modoCompl = (ValorBase) op.getValorComplexo().clone();
	modoCompl.impressao = op.getModoImpressao();

	ValorBase resultado = calcularDiferencaComplexo(modoInt, modoCompl, ac
		.getValorInteiro().getValor(),
		ac.getValorComplexo().getValor(), op.getValorInteiro()
			.getValor(), op.getValorComplexo().getValor());

	return resultado;
    }

    private Engenharia calcularDiferencaEngenharia(ValorBase modoMant,
	    ValorBase modoExp, int intAc, int expAc, int intOp, int expOp) {
	int exp = Math.max(expAc, expOp);

	/*
         * int ac = (int) (intAc * (Math.pow(10, expAc) / Math.pow(10, exp)));
         * int op = (int) (intOp * (Math.pow(10, expOp) / Math.pow(10, exp)));
         * ac -= op;
         * 
         * modoMant.setValor(ac); Engenharia resultado = new
         * Engenharia(modoMant);
         * 
         * modoExp.setValor(exp); resultado.setValorExpoente(modoExp);
         */

	int ac = (int) (intAc * (Math.pow(10, expAc)));
	int op = (int) (intOp * (Math.pow(10, expOp)));
	ac -= op;

	ac = (int) (ac / Math.pow(10, exp));

	modoMant.setValor(ac);
	Engenharia resultado = new Engenharia(modoMant);

	modoExp.setValor(exp);
	resultado.setValorExpoente(modoExp);

	return resultado;
    }

    public ValorBase visitar(Complexo ac, Engenharia op) {
	ValorBase resultado = (ValorBase) ac.clone();

	resultado.setValor(ac.getValor() - op.getValor());

	((Complexo) resultado).getValorInteiro().impressao = op
		.getValorMantissa().impressao;

	((Complexo) resultado).getValorInteiro().impressao = op
		.getValorMantissa().impressao;

	return resultado;

    }

    public ValorBase visitar(Engenharia ac, Complexo op) {
	Complexo resultado = (Complexo) op.clone();

	resultado.getValorInteiro().setValor(
		ac.getValor() - op.getValorInteiro().getValor());

	resultado.getValorComplexo().setValor(op.getValorComplexo().getValor());

	(resultado).getValorInteiro().impressao = op.getValorInteiro()
		.getModoImpressao();

	(resultado).getValorComplexo().impressao = op.getValorComplexo()
		.getModoImpressao();

	return resultado;
    }

    public ValorBase visitar(Engenharia ac, Valor op) {
	ValorBase resultado = (ValorBase) ac.clone();

	ValorBase modoMant = (ValorBase) ac.getValorMantissa().clone();
	modoMant.impressao = op.impressao;

	ValorBase modoExp = (ValorBase) ac.getValorExpoente().clone();
	modoExp.impressao = op.impressao;

	resultado = calcularDiferencaEngenharia(modoMant, modoExp, ac
		.getValorMantissa().getValor(), ac.getValorExpoente()
		.getValor(), op.getValor(), 0);

	// ((Engenharia)resultado).getValorMantissa().impressao = op.impressao;

	return resultado;
    }

    public ValorBase visitar(Valor ac, Engenharia op) {
	ValorBase resultado = (ValorBase) op.clone();

	ValorBase modoMant = (ValorBase) op.getValorMantissa().clone();
	modoMant.impressao = op.getValorMantissa().impressao;

	ValorBase modoExp = (ValorBase) op.getValorExpoente().clone();
	modoExp.impressao = op.getValorExpoente().impressao;

	resultado = calcularDiferencaEngenharia(modoMant, modoExp, ac
		.getValor(), 0, op.getValorMantissa().getValor(), op
		.getValorExpoente().getValor());

	return resultado;
    }

    public ValorBase visitar(Engenharia ac, Engenharia op) {

	/*
         * Converte o valor para o mesmo expoente.
         */
	ValorBase vExpAc = ac.getValorExpoente();
	ValorBase vExpOp = op.getValorExpoente();

	ValorBase vMantAc = ac.getValorMantissa();
	ValorBase vMantOp = op.getValorMantissa();

	ValorBase modoMant = (ValorBase) op.getValorMantissa().clone();
	modoMant.impressao = op.getValorMantissa().impressao;

	ValorBase modoExp = (ValorBase) op.getValorExpoente().clone();
	modoExp.impressao = op.getValorExpoente().impressao;

	Engenharia e = this.calcularDiferencaEngenharia(modoMant, modoExp,
		vMantAc.getValor(), vExpAc.getValor(), vMantOp.getValor(),
		vExpOp.getValor());

	e.getValorMantissa().impressao = op.getValorMantissa().impressao;
	e.getValorExpoente().impressao = op.getValorExpoente().impressao;

	return e;
    }

}
