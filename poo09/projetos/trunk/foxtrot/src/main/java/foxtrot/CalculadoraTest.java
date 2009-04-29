package foxtrot;

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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.entraUm();
    assertEquals("1", calculad1.comandoSoma());
  }

  /**
   * Digita o numero 11 e depois soma.  Resultado= 11.
   */
  public void testTesteOnze() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.entraUm();
    calculad1.entraUm();
    assertEquals("11", calculad1.comandoSoma());
  }

  /**
   * Digita 11, soma, 11 e soma. Resultado= 22.
   */
  public void testTest11E11() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());

    assertEquals("0b1110", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma.
   * Botao decimal: Digita 11, soma.
   * Resultado= 14.
   */
  public void test11BinE11Dec() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b11", calculad1.comandoSoma());
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoDec();
    assertEquals("1", calculad1.entraUm());
    assertEquals("11", calculad1.entraUm());
    assertEquals("11", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x1c", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma.
   * Botao decimal: Digita 11, soma.
   * Resultado= 28.
   */
  public void test11HexE11Dec() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x11", calculad1.comandoSoma());
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
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b11", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x14", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma.
   * Botao binario: Digita 11, soma.
   * Resultado= 10100.
   */
  public void test11HexE11Bin() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b10100", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma.
   * Botao binario: Digita 11, soma.
   * Resultado= 110.
   */
  public void test11BinE11Bin() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b110", calculad1.comandoSoma());
  }

  /**
   * Botao binario: Digita 11, soma, Digita 11, soma.
   * Resultado= 110.
   */
  public void test11BinE11() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b11", calculad1.comandoSoma());

    assertEquals("0b1", calculad1.entraUm());
    assertEquals("0b11", calculad1.entraUm());
    assertEquals("0b110", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma.
   * Botao hexadecimal: Digita 11, soma.
   * Resultado= 22.
   */
  public void test11HexE11Hex() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x11", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x22", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma, Digita 11, soma.
   * Resultado= 22.
   */
  public void test11HexE11() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoHex();
    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x11", calculad1.comandoSoma());

    assertEquals("0x1", calculad1.entraUm());
    assertEquals("0x11", calculad1.entraUm());
    assertEquals("0x22", calculad1.comandoSoma());
  }

    /**
   * Botao hexadecimal: Digita 11, soma, Digita 11, soma.
   * Resultado= 22.
   */
  public void testEntraB1H1Sai0x11() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    //assertEquals("0b1", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("0x11", calculad1.entraUm());
    //assertEquals("0x11", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma, Digita 11, soma.
   * Resultado= 22.
   */
  public void testEntraB1H1B1Sai0b100011() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    //assertEquals("0b1", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("0x11", calculad1.entraUm());
    //assertEquals("0x11", calculad1.comandoSoma());
    calculad1.modoBin();
    assertEquals("0b100011", calculad1.entraUm());
    //assertEquals("0b100011", calculad1.comandoSoma());
  }

  /**
   * Botao hexadecimal: Digita 11, soma, Digita 11, soma.
   * Resultado= 22.
   */
  public void testEntraB1H1D1Sai171() {
    foxtrot.Calculadora calculad1 = new foxtrot.Calculadora();
    calculad1.modoBin();
    assertEquals("0b1", calculad1.entraUm());
    //assertEquals("0b1", calculad1.comandoSoma());
    calculad1.modoHex();
    assertEquals("0x11", calculad1.entraUm());
    //assertEquals("0x11", calculad1.comandoSoma());
    calculad1.modoDec();
    assertEquals("171", calculad1.entraUm());
    //assertEquals("171", calculad1.comandoSoma());
  }

  	/**
	 *  Teste: somar b11111id11+h111ib111+ -> 0b100110000I0b10010
	 */
	public void testeSoma0b11111ID11e0x111I0b111sai0b100110000I0b10010() {
		Calculadora calculad2 = new Calculadora();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();

		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();

		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0b100110000I0b10010",calculad2.comandoSoma());
	}

   /**
    *  Teste: somar h11+Ib11+ -> 0b10001I0b11
    */
    public void testeSoma0x11eI0b11sai0b10001I0b11() {
    	Calculadora calculad2 = new Calculadora();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0b10001I0b11",calculad2.comandoSoma());
    }

    /**
     * Teste: somar 11id1+id1+ -> 11I2
     */
    public void testeSomaD11ID1eID1sai11I2() {
    	Calculadora calculad2 = new Calculadora();
    	calculad2.entraUm();
    	calculad2.entraUm();
		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();

		calculad2.comandoSoma();
		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();
		assertEquals("11I2",calculad2.comandoSoma());
    }

    /**
     * Teste: somar 1i1+1+ -> 2I1
     */
    public void testeSomaD1ID1eD1sai2I1() {
        System.out.println ("#########");
    	Calculadora calculad2 = new Calculadora();
    	calculad2.entraUm();

    	// Modo I
    	calculad2.entraI();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();

		assertEquals("2I1",calculad2.comandoSoma());
    }

    /**
     *  Teste: somar Ib11+Ih11 -> 0x0I0x14
     */
    public void testeSomaI0b11eI0x11sai0x0I0x14() {
    	Calculadora calculad2 = new Calculadora();
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraI();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0x0I0x14",calculad2.comandoSoma());
    }


}
