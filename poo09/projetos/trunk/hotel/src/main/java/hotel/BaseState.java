package hotel;

/**
 * Write a description of interface BaseState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class BaseState
{
	
	/**Acumulador da Caculadora. */
	private Integer acumulador = new Integer(0);

	/**Operador da Caculadora. */
	private Integer operador = new Integer(0);
	
	/**Acumulador da Caculadora. */
	private Integer acumuladorImaginario = new Integer(0);

	/**Operador da Caculadora. */
	private Integer operadorImaginario = new Integer(0);
	
	private IConverterStrategy converterStrategy;
	
	private IEntraNumeroStrategy entraNumeroStrategy;
	
	public BaseState() {
		converterStrategy =  new ConverterRealStrategy();
		entraNumeroStrategy = new EntraNumeroRealStrategy();
	}

	public IConverterStrategy getConverterStrategy() {
		return converterStrategy;
	}

	public void setConverterStrategy(IConverterStrategy converterStrategy) {
		this.converterStrategy = converterStrategy;
	}

	public IEntraNumeroStrategy getEntraNumeroStrategy() {
		return entraNumeroStrategy;
	}

	public void setEntraNumeroStrategy(IEntraNumeroStrategy entraNumeroStrategy) {
		this.entraNumeroStrategy = entraNumeroStrategy;
	}

	public Integer getAcumuladorImaginario() {
		return acumuladorImaginario;
	}

	public void setAcumuladorImaginario(Integer acumuladorImaginario) {
		this.acumuladorImaginario = acumuladorImaginario;
	}

	public Integer getOperadorImaginario() {
		return operadorImaginario;
	}

	public void setOperadorImaginario(Integer operadorImaginario) {
		this.operadorImaginario = operadorImaginario;
	}

	public Integer getAcumulador() {
		return acumulador;
	}

	public void setAcumulador(Integer acumulador) {
		this.acumulador = acumulador;
	}

	public Integer getOperador() {
		return operador;
	}

	public void setOperador(Integer operador) {
		this.operador = operador;
	}

	public void init(BaseState baseInicial) {
		setAcumulador(baseInicial.getAcumulador());
		setOperador(baseInicial.getOperador());
	}

    /**
     * Retorna a base na qual o numero est‡ representado
     * @return
     */
    protected abstract int getBase();    
    
    /**
     * Converte um nœmero na sua respectiva base para decimal
     * @param valor
     * @param base
     * @return
     */
    public Integer converterParaBase(Integer valor, Integer base){
        Integer novoValor = Integer.parseInt(valor.toString(),base);
        return novoValor;
    }
    
	/**
	 * Soma 2 numeros e retorna sua representacao String
	 * @param calculadora
	 * @return
	 */
    public String comandoSoma(Calculadora calculadora){
        Integer acumulador = getAcumuladorImaginario();
        Integer operador = getOperadorImaginario();
        
        Integer novoAcumulador = acumulador + operador;
        setOperadorImaginario(0);
        setAcumuladorImaginario(novoAcumulador);
        
    	acumulador = getAcumulador();
        operador = getOperador();
        
        novoAcumulador = acumulador + operador;
        setOperador(0);
        setAcumulador(novoAcumulador);
        
        String retorno = converterStrategy.converteAcumulador(this);
        
        converterStrategy =  new ConverterRealStrategy();
		entraNumeroStrategy = new EntraNumeroRealStrategy();
		
		return retorno;
    }
    
	
	/**
     * Entra com o nœmero 1 na calculadora
     * @param calc
     * @return
     */
    public String entraUm(Calculadora calculadora) {
    	entraNumeroStrategy.entraNumeroUm(this);
        return converterStrategy.converteOperador(this);
    }    
	
    protected abstract String toString(Integer valor);

	/**
     * Limpa o acumulador e o operador
     * @param calculadora
     * @return
     */
    public String limpa(Calculadora calculadora){
        setOperador(0);
        setAcumulador(0);       
        return converterStrategy.converteOperador(this);
    }

	protected abstract String converte(Integer novoOperador);
}