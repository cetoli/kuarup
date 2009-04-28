package hotel;

/**
 * Write a description of class BaseDecimal here.
 * 
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (10/04/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class BaseDecimal extends BaseState
{

    private static final int BASE_DECIMAL = 10;
    
	protected String converte(Integer novoAcumulador) {
		return novoAcumulador.toString();
	}

	@Override
	protected int getBase() {
		return BASE_DECIMAL;
	}

	@Override
	protected String toString(Integer valor) {
		return valor.toString();
	}   
}