package charlie;

/**
 * Classe concreta Decimal.
 * @author (your name)
 * @version (a version number or a date)
 */
public class DecimalStrategy implements BaseStrategy {
    /**
     * Declaracao de variavel BaseDez.
     */
    private final int baseDez = 10;

    /**
     * Declaracao do metodo entraUm.
     * @param integer entra um.
     * @return retorna um.
     */
    public final Integer entraUm(final Integer integer) {
        return integer * baseDez + 1;
    }

    /**
     * Declaracao de metodo toString.
     * @param integer inteiro a ser convertido.
     * @return retorna inteiro convertido.
     */
    public final String toString(final Integer integer) {
        return Integer.toString(integer);
    }
}
