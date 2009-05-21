/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Interface que define os métodos do Visitor das operações.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
 */
public interface IOperacaoVisitor {
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitSimples(NumReal operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitSimples(NumExpoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public OperadorComposite visitSimples(NumComplexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public OperadorComposite visitSimples(NumEngenharia operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public OperadorComposite visitSimples(NumVetorial operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitComplexo(NumReal operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitComplexo(NumExpoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public OperadorComposite visitComplexo(NumComplexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public OperadorComposite visitComplexo(NumEngenharia operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public OperadorComposite visitComplexo(NumVetorial operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitExponencial(NumReal operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitExponencial(NumExpoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public OperadorComposite visitExponencial(NumComplexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public OperadorComposite visitExponencial(NumEngenharia operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public OperadorComposite visitExponencial(NumVetorial operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitVetorial(NumReal operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public OperadorComposite visitVetorial(NumExpoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public OperadorComposite visitVetorial(NumComplexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public OperadorComposite visitVetorial(NumEngenharia operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public OperadorComposite visitVetorial(NumVetorial operando);
}
