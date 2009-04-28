package hotel;

/**
 * Write a description of class BaseBinaria here.
 * 
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (10/04/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class BaseBinaria extends BaseState
{

    private static final int BASE_BINARIA = 2;

	@Override
    protected String converte(Integer novoOperador) {
		return "0b" + Integer.toBinaryString(novoOperador);
	}

	@Override
	protected int getBase() {
		return BASE_BINARIA;
	}

	@Override
	protected String toString(Integer valor) {
		return Integer.toBinaryString(valor);
	}
}