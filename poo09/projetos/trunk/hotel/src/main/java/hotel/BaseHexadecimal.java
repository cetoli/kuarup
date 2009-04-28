package hotel;
/**
 * Write a description of class BaseHexadecimal here.
 * 
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (10/04/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class BaseHexadecimal extends BaseState
{   
    private static final int BASE_HEXA = 16;
    
	@Override
    protected String converte(Integer novoOperador) {
		return "0x" + toString(novoOperador);
	}

	protected String toString(Integer valor) {
		return Integer.toHexString(valor);
	}

	@Override
	protected int getBase() {
		return BASE_HEXA;
	}
}