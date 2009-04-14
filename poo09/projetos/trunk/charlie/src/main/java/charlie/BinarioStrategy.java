package charlie;

/**
 * Classe concreta Binario.
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarioStrategy implements BaseStrategy {
    /**
     * Variavel que define a base a ser utilizada.
     */
    private final int baseDois = 2;

    /**
     * Tecla numero Um.
     * @param integer entra um.
     * @return retorna um.
     */
    public final Integer entraUm(final Integer integer) {
        return integer * baseDois + 1;
    }

    /**
     * Conversor de numero para String.
     * @param integer inteiro a ser convertido.
     * @return retorna inteiro convertido.
     */
    public final String toString(final Integer integer) {
        return "0b" + Integer.toBinaryString(integer);
    }
}
