package alpha;

/**
 * Define a parte imaginaria do numero complexo.
 * 
 * @author Diego Mury G. de Lima
 * @author Leandro Oliveira Gomes
 * @version 1.0
 */
public class Imaginario implements INumero
{
    private int valor;
    private INumero exponencial;
    /**
     * Construtor da classe.
     * @param value
     */
    public Imaginario(int value) {
        this.valor = value;
        this.exponencial = new Nulo();
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
        this.exponencial = operando;
    }
    /**
     * Mostra a representacao do numero.
     * @param base corrente.
     * @return representacao do numero na base corrente.
     */
    public String mostra(BaseStrategy base) {
        return "I" + base.getId() + base.converterBase(this.valor) + this.exponencial.mostra(base);
    }
    /**
     * Realiza a soma.
     * @param operando conteudo do operando
     */
    public void soma(INumero operando) {
        int valorOutro = operando.getParteImaginaria().getValor();
        int maxExp = Math.max(this.exponencial.getValor(), operando.getParteImaginaria().getParteExponencial().getValor());
        this.valor = this.valor / ((int)Math.pow(10, maxExp - this.exponencial.getValor()));
        valorOutro = valorOutro / ((int)Math.pow(10, maxExp - operando.getParteImaginaria().getParteExponencial().getValor()));
        this.valor += valorOutro;
        this.exponencial.setValor(maxExp);
    }
    /**
     * Realiza a subtracao.
     * @param operando conteudo do operando
     */
    public void subtrai(INumero operando) {
        int valorOutro = operando.getParteImaginaria().getValor();
        int maxExp = Math.max(this.exponencial.getValor(), operando.getParteImaginaria().getParteExponencial().getValor());
        this.valor = this.valor / ((int)Math.pow(10, maxExp - this.exponencial.getValor()));
        valorOutro = valorOutro / ((int)Math.pow(10, maxExp - operando.getParteImaginaria().getParteExponencial().getValor()));
        this.valor -= valorOutro;
        this.exponencial.setValor(maxExp);
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
     * Nulo em caso de parte imaginaria.
     */
    public INumero getParteReal() {
        return new Nulo();
    }
    /**
     * Retorna a parte imaginaria.
     * @return parte imaginaria.
     * Valor em caso de parte imaginaria.
     */
    public INumero getParteImaginaria() {
        return this;
    }
    /**
     * Retorna a parte exponencial.
     * @return parte exponencial.
     */
    public INumero getParteExponencial() {
        return this.exponencial;
    }
}
