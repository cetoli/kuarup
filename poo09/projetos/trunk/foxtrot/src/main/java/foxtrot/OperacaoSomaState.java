package foxtrot;


/**
 * Write a description of class OperacaoSoma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperacaoSomaState implements OperacaoState {

    public Operando fazOperacao(Operando operando1, Operando operando2) {
        operando1.soma(operando2);
        return operando1;
    }
}
