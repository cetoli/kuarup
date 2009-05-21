package alpha;

/**
 * Define os métodos do Visitor das operações.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 1.0
 */
public interface IVisitor {
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitReal(Real operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitReal(Expoente operando);
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public INumero visitReal(Complexo operando);
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public INumero visitReal(Exponencial operando);
    /**
     * Visita operando vetorial.
     * @param operando vetorial visitado
     * @return operando
     */
    public INumero visitReal(Vetorial operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitComplexo(Real operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitComplexo(Expoente operando);
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public INumero visitComplexo(Complexo operando);
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public INumero visitComplexo(Exponencial operando);
    /**
     * Visita operando vetorial.
     * @param operando vetorial visitado
     * @return operando
     */
    public INumero visitComplexo(Vetorial operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitExponencial(Real operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitExponencial(Expoente operando);
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public INumero visitExponencial(Complexo operando);
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public INumero visitExponencial(Exponencial operando);
    /**
     * Visita operando vetorial.
     * @param operando vetorial visitado
     * @return operando
     */
    public INumero visitExponencial(Vetorial operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitVetorial(Real operando);
    /**
     * Visita operando simples.
     * @param operando simples visitado
     * @return operando
     */
    public INumero visitVetorial(Expoente operando);
    /**
     * Visita operando complexo.
     * @param operando complexo visitado
     * @return operando
     */
    public INumero visitVetorial(Complexo operando);
    /**
     * Visita operando com notação científica.
     * @param operando com notação científica visitado
     * @return operando
     */
    public INumero visitVetorial(Exponencial operando);
    /**
     * Visita operando vetorial.
     * @param operando vetorial visitado
     * @return operando
     */
    public INumero visitVetorial(Vetorial operando);
}
