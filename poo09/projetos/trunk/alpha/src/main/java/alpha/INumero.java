package alpha;
import java.util.LinkedList;

/**
 * Interface que define numero.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public interface INumero {
    /**
     * Método que adiciona o número 1 ao operando.
     * @return valor do operando na base especificada.
     */
    public String entraUm();
    /**
     * Método que mostra o operando na base especificada.
     * @return valor do operando na base especificada
     */
    public String mostra();
    /**
     * Método que soma um operando a outro operando.
     * @param operando
     * @return operando
     */
    public INumero soma(INumero operando);
    /**
     * Método que subtrai um operando de outro operando.
     * @param operando
     * @return operando
     */
    public INumero sub(INumero operando);
    /**
     * Método que especifica a base escolhida no operando.
     * @param base
     */
    public void setBase(BaseStrategy base);
    /**
     * Método que adiciona um valor em decimal a parte real,
     * imaginária ou exponencial do operando
     */
    public void setValor(int valor);
    /**
     * Método que adiciona um vetor ao operando vetorial.
     */
    public void setVetor(LinkedList vetor);
    /**
     * Método que adiciona uma parte real ao operando.
     */
    public void setParteReal(INumero operando);
    /**
     * Método que adiciona uma parte imaginária ao operando.
     */
    public void setParteImaginaria(INumero operando);
    /**
     * Método que adiciona uma parte mantissa ao operando.
     */
    public void setParteMantissa(INumero operando);
    /**
     * Método que adiciona a parte exponencial ao operando.
     */
    public void setParteExponencial(INumero operando);
    /**
     * Método que retorna a base do operando.
     * @return base
     */
    public BaseStrategy getBase();
    /**
     * Método que retorna o valor em decimal da parte real ou 
     * imaginária do operando
     * @return valor em decimal
     */
    public int getValor();
    /**
     * Método que retorna o vetor do operando vetorial.
     * @return vetor
     */
    public LinkedList getVetor();
    /**
     * Método que retorna a parte real do operando.
     * @return operando
     */
    public INumero getParteReal();
    /**
     * Método que retorna a parte imaginária do operando.
     * @return operando
     */
    public INumero getParteImaginaria();
    /**
     * Método que retorna a parte mantissa do operando.
     * @return operando
     */
    public INumero getParteMantissa();
    /**
     * Método que retorna a parte exponencial do operando.
     * @return operando
     */
    public INumero getParteExponencial();
    /**
     * Método que transforma o operando em operando complexo.
     * @return operando
     */
    public INumero toComplexo();
    /**
     * Método que transforma o operando em operando científico.
     * @return operando
     */
    public INumero toExponencial();
    /**
     * Método que transforma o operando em operando vetorial.
     * @return operando
     */
    public INumero toVetorial();
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número simples/real.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Real operando);
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número expoente/real.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Expoente operando);
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número complexo.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Complexo operando);
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número exponencial/científico.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Exponencial operando);
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número vetorial.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Vetorial operando);
}
