package foxtrot;

/**.
 * Descri��o:
 * The test class HexadecimalTest.
 *
 * @author Rodrigo Santos Borges
 * @author Carlos Eduardo Ferr�o
 *
 * @version 3     Data 20/04/2009
 */

public class HexadecimalTest extends junit.framework.TestCase {

    /**
     * Testa a entrada de valores limpeza do buffer e soma.
     */
    public void testHexadecimal() {
        foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
        Hexadecimal d= new Hexadecimal(0);
        assertEquals ( "0x1", d.entraUm (calculad2));
        assertEquals ( "0x11", d.entraUm (calculad2));
    }

}
