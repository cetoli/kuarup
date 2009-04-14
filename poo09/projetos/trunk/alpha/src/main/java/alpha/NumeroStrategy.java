package alpha;

/**
 * Classe abstrata que sera extendida para operacao
 * com numeros nas diversas bases.
 * 
 * @author Diego Mury Gomes de Lima
 * @author  Carlos Felippe Cardoso de Resende
 * @version 1.0
 */
public abstract class NumeroStrategy implements INumeroStrategy {
    
    String repNum = "0"; 
    
    /**
     * Metodo que processa a entrada de um numero.
     */
    public void entraUm() {
        repNum += "1";
    }
    
    /**
     * Metodo abstrato que ira converter a entrada em base decimal.
     */
    public abstract Integer converteEmNumeroDecimal();
    
    /**
     * Metodo abstrato que ira converter o numero em 
     * base decimal para a base corrente.
     */
    public abstract INumeroStrategy converterParaBase(Integer num);
    
    /**
     * Metodo abstrato que ira exibir o numero na base corrente.
     */
    public abstract String mostraNumeroNaMinhaRepresentacaoBase();
    
    /**
     * Metodo abstrato que ira exibir o numero na base
     * corrente para exibicao no display.
     */
    public abstract String mostraNumeroNaMinhaRepresentacaoBaseParaODisplay();
    
    /**
     * Metodo que ira proceder alteracoes na representacao numerica.
     */
    public void setRepNum(String num) {
        this.repNum = num;
    }
    
    /**
     * Metodo que ira retornar a representacao numerica.
     */
    public String getRepNum() {
        return repNum;
    }
    
    /**
     * Metodo que ira zerar a representacao numerica 
     * para obtencao do segundo parametro.
     */
    public void zeraRepresentacaoNumerica() {
        setRepNum("0");
    }
}