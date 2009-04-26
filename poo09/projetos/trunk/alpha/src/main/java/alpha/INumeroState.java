package alpha;

/**
 * Interface que implementa o estado
 * dos numeros: real ou imaginario.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Marcio Reis Teixeira
 * @version 1.0
 */
public interface INumeroState {
    /**
     * Assinatura do metodo entraUm.
     */
    public String entraUm(INumeroStrategy operador, INumeroStrategy operadorImaginario);
    /**
     * Assinatura do metodo soma.
     */
    public String soma(INumeroStrategy operador, INumeroStrategy operadorImaginario, INumeroStrategy acumulador, INumeroStrategy acumuladorImaginario);
}
