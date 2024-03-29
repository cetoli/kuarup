package golf;

/**
 * Classe abstrata que representa um n�mero que ser� usado na calculadora
 * 
 * @author Gustavo Taveira
 * @version 2.0
 */
public abstract class AbstractNumero {

    protected Integer valor;

    protected Integer base;

    /**
     * Converte o valor para a base correta e com seu devido prefixo
     * 
     */
    public String converte() {
        return getBasePrefix() + converteBase();
    }
    
    /**
     * Converte o numero de acordo com a base
     */
    protected abstract String converteBase();
    
    /**
     * Recupera o prefixo da base
     */
    protected abstract String getBasePrefix();

    /**
     * Seta o valor da variavel valor
     * 
     * @atribute Integer x
     */
    public void setValor(Integer x) {
        this.valor = x;
    }

    /**
     * Retorna o valor da variavel valor
     * 
     * @return valor
     */
    public Integer getValor() {
        return this.valor;
    }

    /**
     * Retorna o valor da variavel base
     * 
     * @return base
     */
    public Integer getBase() {
        return this.base;
    }
}
