package foxtrot;


/**
 * Write a description of class OperacaoSubtracao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperacaoSubtracaoState implements OperacaoState {

    public Operando fazOperacao(Operando operando1, Operando operando2) {
        operando1.subtrai(operando2);
        return operando1;
    }
}
