package alpha;

/**
 * Define a parte exponencial dos numeros.
 * 
 * @author Diego Mury G. de Lima 
 * @version 1.0
 */
public class Exponencial implements INumero
{
    private int valor;
    /**
     * Construtor da classe.
     * @param value.
     */
    public Exponencial(int value) {
        this.valor = value;
    }
    /**
     * Adiciona a parte real do numero.
     * @param operando parte real.
     */
    public void adicionaParteReal(INumero operando) {    
    }
    /**
     * Adiciona a parte imaginaria do numero.
     * @param operando parte imaginaria.
     */
    public void adicionaParteImaginaria(INumero operando) { 
    }
    /**
     * Adiciona a parte exponencial do numero.
     * @param operando parte exponencial.
     */
    public void adicionaParteExponencial(INumero operando) {
    }
    /**
     * Mostra a representacao do numero.
     * @param base corrente.
     * @return representacao do numero na base corrente.
     */
    public String mostra(BaseStrategy base) {
        return "N" + base.converterBase(this.valor);
    }
    /**
     * Realiza a soma.
     * @param operando conteudo do operando
     */
    public void soma(INumero operando) {
    }
    /**
     * Retorna o valor.
     * @return valor.
     */
    public int getValor() {
        return this.valor;
    }
    /**
     * Altera o valor.
     * @param value.
     */
    public void setValor(int value) {
        this.valor = value;
    }
    /**
     * Retorna a parte real.
     * @return parte real.
     * Nulo em caso de numero exponencial.
     */
    public INumero getParteReal() {
        return new Nulo();
    }
    /**
     * Retorna a parte imaginaria.
     * @return parte imaginaria.
     * Nulo em caso de numero exponencial.
     */
    public INumero getParteImaginaria() {
        return new Nulo();
    }    
    /**
     * Retorna a parte exponencial.
     * @return parte exponencial.
     */
    public INumero getParteExponencial() {
        return this;
    }
}
