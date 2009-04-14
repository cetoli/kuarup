package echo;

/**
 * Classe de teste da classe Calculadora.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version (1.0)    $Revision$ (01/04/09)      $Date$
 */

public class CalculadoraTest extends junit.framework.TestCase {
  /**
   * constructor Padrao.
   */
  public CalculadoraTest() {
  }

  /**
   * Sets up the test fixture.
   *
   * Called before every test case method.
   */
  protected void setUp() {
  }

  /**
   * Tears down the test fixture.
   *
   * Called after every test case method.
   */
  protected void tearDown() {
  }

  /**
   * Digita 1 vez o numero 1 e depois soma. Resultado= 1.
   */
  public void testSomaUmApartirDoRepouso() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.entraUm();
    assertEquals("1", calculad1.comandoSoma());
  }

  /**
   * Digita o numero 11 e depois soma.  Resultado= 11.
   */
  public void testTesteOnze() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.entraUm();
    calculad1.entraUm();
    assertEquals("11", calculad1.comandoSoma());
  }

  /**
   * Digita 11, soma, 11 e soma. Resultado= 22.
   */
  public void testTest11E11() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("22", calculad1.comandoSoma());
  }

  /**
   * Digita 1, soma, manda limpar, 1 e soma. Resultado= 1.
   */
  public void testLimpa() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    assertEquals("1", calculad1.entraUm());
    assertEquals("1", calculad1.comandoSoma());
    assertEquals("0", calculad1.limpa());
    assertEquals("1", calculad1.entraUm());
    assertEquals("1", calculad1.comandoSoma());
  }

  /**
   * Digita 11, soma, 111 e soma. Resultado= 122.
   */
  public void test11E111() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("111", calculad1.entraUm());
    assertEquals("122", calculad1.comandoSoma());
  }

  /**
   * Digita 1, soma, 1, soma, 1 e soma. Resultado= 3.
   */
  public void testVariasEntradas() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    assertEquals("1", calculad1.entraUm());
    assertEquals("1", calculad1.comandoSoma());
    assertEquals("1", calculad1.entraUm());
    assertEquals("2", calculad1.comandoSoma());
    assertEquals("1", calculad1.entraUm());
    assertEquals("3", calculad1.comandoSoma());
  }

  /* Teste do trabalho 2 */

  /**
   * Botao de cimal: Digita 1, soma. Resultado= 1.
   */
  public void testSomaUmApartirDoRepousoDec() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoDec();
    calculad1.entraUm();
    assertEquals("1", calculad1.comandoSoma());
  }

  /**
   * Botao decimal: Digita 11, soma. 
   * Botao decimal: Digita 11, soma.
   * Resultado= 22.
   */
  public void testTest11E11Dec() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("22", calculad1.comandoSoma());
  }

  /**
   * Botao decimal: Digita 11, soma. 
   * Botao binario: Digita 11, soma.
   * Resultado= 1110.
   */
  public void test11DecE11Bin() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());

    assertEquals("1110", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma. 
   * Botao decimal: Digita 11, soma.
   * Resultado= 14.
   */
  public void test11BinE11Dec() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("14", calculad1.comandoSoma());
  }

  /**
   * Botao decimal: Digita 11, soma. 
   * Botao hexadecimal: Digita 11, soma.
   * Resultado= 1c.
   */
  public void test11DecE11Hex() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("1c", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma. 
   * Botao decimal: Digita 11, soma.
   * Resultado= 28.
   */
  public void test11HexE11Dec() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("28", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma. 
   * Botao hexadecimal: Digita 11, soma.
   * Resultado= 14.
   */
  public void test11BinE11Hex() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("14", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma. 
   * Botao binario: Digita 11, soma.
   * Resultado= 10100.
   */
  public void test11HexE11Bin() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("10100", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma. 
   * Botao binario: Digita 11, soma.
   * Resultado= 110.
   */
  public void test11BinE11Bin() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("110", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma, Digita 11, soma.
   * Resultado= 110.
   */
  public void test11BinE11() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoBin();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());

    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("110", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma. 
   * Botao hexadecimal: Digita 11, soma.
   * Resultado= 22.
   */
  public void test11HexE11Hex() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("22", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma, Digita 11, soma.
   * Resultado= 22.
   */
  public void test11HexE11() {
    echo.Calculadora calculad1 = new echo.Calculadora();
    calculad1.modoHex();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());

    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("22", calculad1.comandoSoma());
  }
}
