package foxtrot;


/**
 * Write a description of class OperacaoNulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperacaoNulaState implements OperacaoState {

    public Operando fazOperacao(Operando operando1, Operando operando2) {
        return operando1;
    }
}
