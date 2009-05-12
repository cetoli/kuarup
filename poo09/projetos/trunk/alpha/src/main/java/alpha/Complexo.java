package alpha;

/**
 * Define os numeros complexos.
 * 
 * @author Diego Mury G. de Lima
 * @author Leandro Oliveira Gomes
 * @version 1.0
 */
public class Complexo implements INumero
{
    private INumero real;
    private INumero imaginario;
    /**
     * Construtor da classe.
     */
    public Complexo() {
        this.real = new Nulo();
        this.imaginario = new Nulo();
    }
    /**
     * Adiciona a parte real do numero.
     * @param operando parte real.
     */
    public void adicionaParteReal(INumero operando) {
        this.real = operando;
    }
    /**
     * Adiciona a parte imaginaria do numero.
     * @param operando parte imaginaria.
     */
    public void adicionaParteImaginaria(INumero operando) {
        this.imaginario = operando;
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
        return this.real.mostra(base) + this.imaginario.mostra(base);
    }
    /**
     * Realiza a soma.
     * @param operando conteudo do operando
     */
    public void soma(INumero operando) {
        this.real.soma(operando.getParteReal());
        this.imaginario.soma(operando.getParteImaginaria());
    }
    /**
     * Realiza a subtracao.
     * @param operando conteudo do operando
     */
    public void subtrai(INumero operando) {
        this.real.subtrai(operando.getParteReal());
        this.imaginario.subtrai(operando.getParteImaginaria());
    } 
    /**
     * Retorna o valor.
     * @return valor.
     */
    public int getValor() {
        return 0;
    }
    /**
     * Altera o valor.
     * @param value.
     */
    public void setValor(int value) {
    } 
    /**
     * Retorna a parte real.
     * @return parte real.
     */
    public INumero getParteReal() {
        return this.real;
    }
    /**
     * Retorna a parte imaginaria.
     * @return parte imaginaria.
     */
    public INumero getParteImaginaria() {
        return this.imaginario;
    }
    /**
     * Retorna a parte exponencial.
     * @return parte exponencial.
     */
    public INumero getParteExponencial() {
        return new Nulo();
    }
}
