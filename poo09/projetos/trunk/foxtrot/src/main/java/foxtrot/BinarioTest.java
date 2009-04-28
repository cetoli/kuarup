package foxtrot;

/**.
 * Descrição:
 * The test class BinarioTest.
 *
 * @author Rodrigo Santos Borges
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 20/04/2009
 */

public class BinarioTest  extends junit.framework.TestCase {

    /**
     * Testa a entrada de valores limpeza do buffer e soma.
     */
    public void testBinario() {
        foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
        Binario d= new Binario(0);
        assertEquals ( "0b1", d.entraUm (calculad2));
        assertEquals ( "0b11", d.entraUm (calculad2));
    }

}