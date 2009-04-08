package golf;


/**
 * Abstract class AbstractNumero - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractNumero{
    // instance variables - replace the example below with your own
    protected Integer valor;
    protected Integer base;

    /**
     * Converte o valor para a base correta
     * 
     */
    public abstract String converte();

    /**
     * Seta o valor da variavel valor
     * 
     * @atribute Integer x
     */
    public void setValor(Integer x){
        this.valor = x;
    }

    /**
     * Retorna o valor da variavel valor
     * 
     * @return valor
     */
    public Integer getValor(){
        return this.valor;
    }

    /**
     * Retorna o valor da variavel base
     * 
     * @return base
     */
    public Integer getBase(){
        return this.base;
    }
}
