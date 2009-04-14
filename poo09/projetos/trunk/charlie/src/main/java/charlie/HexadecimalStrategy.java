package charlie;

/**
 * Classe concreta Hexadecimal.
 * @author (your name)
 * @version (a version number or a date)
 */
public class HexadecimalStrategy implements BaseStrategy {
    /**
     * Declaracao de variavel BaseDezesseis.
     */
    private final int baseDezesseis = 16;

    /**
     * Declaracao do metodo entraUm em Hexa.
     * @param integer entra um.
     * @return retorna um.
     */
    public final Integer entraUm(final Integer integer) {
        return integer * baseDezesseis + 1;
    }

    /**
     * Declaracao do metodo toString em Hexa.
     * @param integer inteiro a ser convertido.
     * @return retorna inteiro convertido.
     */
    public final String toString(final Integer integer) {
        return "0x" + Integer.toHexString(integer);
    }
}
