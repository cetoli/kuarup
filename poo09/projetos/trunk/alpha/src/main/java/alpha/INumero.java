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
     * M�todo que adiciona o n�mero 1 ao operando.
     * @return valor do operando na base especificada.
     */
    public String entraUm();
    /**
     * M�todo que mostra o operando na base especificada.
     * @return valor do operando na base especificada
     */
    public String mostra();
    /**
     * M�todo que soma um operando a outro operando.
     * @param operando
     * @return operando
     */
    public INumero soma(INumero operando);
    /**
     * M�todo que subtrai um operando de outro operando.
     * @param operando
     * @return operando
     */
    public INumero sub(INumero operando);
    /**
     * M�todo que especifica a base escolhida no operando.
     * @param base
     */
    public void setBase(BaseStrategy base);
    /**
     * M�todo que adiciona um valor em decimal a parte real,
     * imagin�ria ou exponencial do operando
     */
    public void setValor(int valor);
    /**
     * M�todo que adiciona um vetor ao operando vetorial.
     */
    public void setVetor(LinkedList vetor);
    /**
     * M�todo que adiciona uma parte real ao operando.
     */
    public void setParteReal(INumero operando);
    /**
     * M�todo que adiciona uma parte imagin�ria ao operando.
     */
    public void setParteImaginaria(INumero operando);
    /**
     * M�todo que adiciona uma parte mantissa ao operando.
     */
    public void setParteMantissa(INumero operando);
    /**
     * M�todo que adiciona a parte exponencial ao operando.
     */
    public void setParteExponencial(INumero operando);
    /**
     * M�todo que retorna a base do operando.
     * @return base
     */
    public BaseStrategy getBase();
    /**
     * M�todo que retorna o valor em decimal da parte real ou 
     * imagin�ria do operando
     * @return valor em decimal
     */
    public int getValor();
    /**
     * M�todo que retorna o vetor do operando vetorial.
     * @return vetor
     */
    public LinkedList getVetor();
    /**
     * M�todo que retorna a parte real do operando.
     * @return operando
     */
    public INumero getParteReal();
    /**
     * M�todo que retorna a parte imagin�ria do operando.
     * @return operando
     */
    public INumero getParteImaginaria();
    /**
     * M�todo que retorna a parte mantissa do operando.
     * @return operando
     */
    public INumero getParteMantissa();
    /**
     * M�todo que retorna a parte exponencial do operando.
     * @return operando
     */
    public INumero getParteExponencial();
    /**
     * M�todo que transforma o operando em operando complexo.
     * @return operando
     */
    public INumero toComplexo();
    /**
     * M�todo que transforma o operando em operando cient�fico.
     * @return operando
     */
    public INumero toExponencial();
    /**
     * M�todo que transforma o operando em operando vetorial.
     * @return operando
     */
    public INumero toVetorial();
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero simples/real.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Real operando);
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero expoente/real.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Expoente operando);
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero complexo.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Complexo operando);
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero exponencial/cient�fico.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Exponencial operando);
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero vetorial.
     * @return operando
     */
    public INumero accept(IVisitor visitor, Vetorial operando);
}
