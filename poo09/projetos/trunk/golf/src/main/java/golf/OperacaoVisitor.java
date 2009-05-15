/*------------------------------------------------------------------------------
    Copyright © 2002-2006          Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Interface que define os métodos do Visitor das operações.
 * @author  Gustavo Taveira e Thiago Silva de Souza
 * @version 5.0
 */
public interface OperacaoVisitor {
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitSimples(Simples operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitSimples(Expoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public Operando visitSimples(Complexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public Operando visitSimples(Exponencial operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public Operando visitSimples(Vetorial operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitComplexo(Simples operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitComplexo(Expoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public Operando visitComplexo(Complexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public Operando visitComplexo(Exponencial operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public Operando visitComplexo(Vetorial operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitExponencial(Simples operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitExponencial(Expoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public Operando visitExponencial(Complexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public Operando visitExponencial(Exponencial operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public Operando visitExponencial(Vetorial operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitVetorial(Simples operando);
    
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public Operando visitVetorial(Expoente operando);
    
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public Operando visitVetorial(Complexo operando);
    
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public Operando visitVetorial(Exponencial operando);
    
    /**
     * Visita operando vetorial
     * @param operando vetorial visitado
     * @return operando
     */
    public Operando visitVetorial(Vetorial operando);
}
