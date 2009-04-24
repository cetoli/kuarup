package delta;


/**
 * Write a description of class Inteiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inteiro
{
    /**
     * Variavel que guarda o valor do Inteiro aqui representado.
     */
    private Integer valor;

    /**
     *
     */
    private BaseStrategy base;


    /**
     *
     */
    public Inteiro() {
        valor = 0;
        base = new DecimalStrategy();
    }

    /**
     *
     */
    public Integer getValor() {
        return valor;
    }

    /**
     *
     */
    public String toString() {
        return base.toString(valor);
    }

    /**
     *
     */
    public void limpa() {
        valor = 0;
    }

    /**
     *
     */
    public void entraUm() {
        valor = valor * base.getValorBase() + 1;
    }

    /**
     *
     */
    public void soma(Inteiro inteiro) {
        valor += inteiro.getValor();
    }

    /**
     *
     */
    public void modoBin() {
        base = new BinariaStrategy();
    }

    /**
     *
     */
    public void modoDec() {
        base = new DecimalStrategy();
    }

    /**
     *
     */
    public void modoHex() {
        base = new HexadecimalStrategy();
    }
}
