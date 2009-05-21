/*------------------------------------------------------------------------------
    Copyright � 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import java.util.LinkedList;

/**
 * Interface que define os m�todos do operando.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public interface OperadorComposite {
    
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
    public OperadorComposite soma(OperadorComposite operando);
    
    /**
     * M�todo que subtrai um operando de outro operando.
     * @param operando
     * @return operando
     */
    public OperadorComposite sub(OperadorComposite operando);
        
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
    public void setParteReal(OperadorComposite operando);
    
    /**
     * M�todo que adiciona uma parte imagin�ria ao operando.
     */
    public void setParteImaginaria(OperadorComposite operando);
   
    /**
     * M�todo que adiciona uma parte mantissa ao operando.
     */
    public void setParteMantissa(OperadorComposite operando);
    
    /**
     * M�todo que adiciona a parte exponencial ao operando.
     */
    public void setParteExponencial(OperadorComposite operando);
    
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
    public OperadorComposite getParteReal();
    
    /**
     * M�todo que retorna a parte imagin�ria do operando.
     * @return operando
     */
    public OperadorComposite getParteImaginaria();
    
    /**
     * M�todo que retorna a parte mantissa do operando.
     * @return operando
     */
    public OperadorComposite getParteMantissa();
    
    /**
     * M�todo que retorna a parte exponencial do operando.
     * @return operando
     */
    public OperadorComposite getParteExponencial();
    
    /**
     * M�todo que transforma o operando em operando complexo.
     * @return operando
     */
    public OperadorComposite toComplexo();
    
    /**
     * M�todo que transforma o operando em operando cient�fico.
     * @return operando
     */
    public OperadorComposite toExponencial();
    
    /**
     * M�todo que transforma o operando em operando vetorial.
     * @return operando
     */
    public OperadorComposite toVetorial();
    
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero simples/real.
     * @return operando
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumReal operando);
    
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero expoente/real.
     * @return operando
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumExpoente operando);
    
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero complexo.
     * @return operando
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumComplexo operando);
    
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero exponencial/cient�fico.
     * @return operando
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumEngenharia operando);
    
    /**
     * M�todo accept do Visitor da opera��o soma, subtra��o ou multiplica��o, tendo como visitante
     * um n�mero vetorial.
     * @return operando
     */
    public OperadorComposite accept(IOperacaoVisitor visitor, NumVetorial operando);
}
