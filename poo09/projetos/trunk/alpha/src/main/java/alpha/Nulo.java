package alpha;

/**
 * Define a parte nula dos numeros.
 * 
 * @author Diego Mury G. de Lima 
 * @version 1.0
 */
public class Nulo implements INumero
{
    /**
     * Adiciona a parte real do numero.
     * @param operando parte real.
     */
    public void adicionaParteReal(INumero operando) {
        throw new RuntimeException("Não pode adicionar parte real a operando nulo.");
    }
    /**
     * Adiciona a parte imaginaria do numero.
     * @param operando parte imaginaria.
     */
    public void adicionaParteImaginaria(INumero operando) {
        throw new RuntimeException("Não pode adicionar parte imaginária a operando nulo.");
    }
    /**
     * Adiciona a parte exponencial do numero.
     * @param operando parte exponencial.
     */
    public void adicionaParteExponencial(INumero operando) {
        throw new RuntimeException("Não pode adicionar parte exponencial a operando nulo.");
    }
    /**
     * Mostra a representacao do numero.
     * @param base corrente.
     * @return representacao do numero na base corrente.
     */
    public String mostra(BaseStrategy base) {
        return "";
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
        return this;
    }
    /**
     * Retorna a parte imaginaria.
     * @return parte imaginaria.
     */
    public INumero getParteImaginaria() {
        return this;
    }
    /**
     * Retorna a parte exponencial.
     * @return parte exponencial.
     */
    public INumero getParteExponencial() {
        return this;
    }
}
