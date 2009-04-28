package foxtrot;

/**.
 * Descrição:
 * The test class DecimalTest.
 *
 * @author Rodrigo Santos Borges
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 20/04/2009
 */

public class DecimalTest  extends junit.framework.TestCase {

    /**
     * Testa a entrada de valores limpeza do buffer e soma.
     */
    public void testDecimal() {
        foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
        Decimal d= new Decimal(0);
        assertEquals ( "1", d.entraUm (calculad2));
        assertEquals ( "11", d.entraUm (calculad2));
    }

}
