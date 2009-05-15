/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;
import java.util.LinkedList;

/**
 * Interface que define os métodos do operando.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public interface Operando {
    
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
    public Operando soma(Operando operando);
    
    /**
     * Método que subtrai um operando de outro operando.
     * @param operando
     * @return operando
     */
    public Operando sub(Operando operando);
        
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
    public void setParteReal(Operando operando);
    
    /**
     * Método que adiciona uma parte imaginária ao operando.
     */
    public void setParteImaginaria(Operando operando);
   
    /**
     * Método que adiciona uma parte mantissa ao operando.
     */
    public void setParteMantissa(Operando operando);
    
    /**
     * Método que adiciona a parte exponencial ao operando.
     */
    public void setParteExponencial(Operando operando);
    
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
    public Operando getParteReal();
    
    /**
     * Método que retorna a parte imaginária do operando.
     * @return operando
     */
    public Operando getParteImaginaria();
    
    /**
     * Método que retorna a parte mantissa do operando.
     * @return operando
     */
    public Operando getParteMantissa();
    
    /**
     * Método que retorna a parte exponencial do operando.
     * @return operando
     */
    public Operando getParteExponencial();
    
    /**
     * Método que transforma o operando em operando complexo.
     * @return operando
     */
    public Operando toComplexo();
    
    /**
     * Método que transforma o operando em operando científico.
     * @return operando
     */
    public Operando toExponencial();
    
    /**
     * Método que transforma o operando em operando vetorial.
     * @return operando
     */
    public Operando toVetorial();
    
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número simples/real.
     * @return operando
     */
    public Operando accept(OperacaoVisitor visitor, Simples operando);
    
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número expoente/real.
     * @return operando
     */
    public Operando accept(OperacaoVisitor visitor, Expoente operando);
    
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número complexo.
     * @return operando
     */
    public Operando accept(OperacaoVisitor visitor, Complexo operando);
    
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número exponencial/científico.
     * @return operando
     */
    public Operando accept(OperacaoVisitor visitor, Exponencial operando);
    
    /**
     * Método accept do Visitor da operação soma, subtração ou multiplicação, tendo como visitante
     * um número vetorial.
     * @return operando
     */
    public Operando accept(OperacaoVisitor visitor, Vetorial operando);
}
