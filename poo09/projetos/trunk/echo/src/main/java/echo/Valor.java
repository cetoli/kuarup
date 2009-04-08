package echo;


/**
 * Write a description of class Valor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Valor implements Cloneable
{
    protected int valor;

    /**
     * Constructor for objects of class Valor
     */
    public Valor()
    {

        valor = 0;
    }

    public Valor(int novo)
    {

        valor = novo;
    }

    public Object clone () {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    public String limparValor(){
        valor= 0;

        return converterEmString ();
    }

    public int getValor() {
        return valor;
    }

    public String adicionarDigito (String digito) {
        String str= converterEmString () + digito;

        valor= Integer.parseInt (str);

        return converterEmString ();
    }

    public void setValor(String novo) {
        valor = Integer.parseInt (novo);
    }

    public String converterEmString() {
        return String.valueOf(valor);
    }

    public void somar(Valor objOp2){
        int op2= objOp2.getValor ();

        valor+= op2;

    }

}
