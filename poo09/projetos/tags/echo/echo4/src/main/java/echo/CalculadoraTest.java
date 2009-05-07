/*-----------------------------------------------------------------------------
    Copyright 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
-----------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com numeros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */

public class CalculadoraTest extends junit.framework.TestCase {

    /**
     * Default constructor for test class CalculadoraTest.
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
     * Teste para o metodo EntraUm()
     */
    public void testEntraUm() {
        Calculadora calc = new Calculadora();
        assertEquals("1", calc.entraUm());
    }

    /**
     * Teste para o metodo Limpa()
     */
    public void testEntraUmLimpa() {
        Calculadora calc = new Calculadora();
        assertEquals("1", calc.entraUm());
        assertEquals("0", calc.limpa());
    }
    
    /**
     * Teste para o metodo EntraUm()
     */
    public void testEntraUmUm() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        assertEquals("11", calc.entraUm());
    }

    /**
     * Teste para o metodo EntraUm()
     */
    public void testEntraUmUmUm() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        calc.entraUm();
        assertEquals("111", calc.entraUm());
    }

    /**
     * Teste para o metodo Soma()
     */
    public void testSoma() {
        Calculadora calc = new Calculadora();
        assertEquals("0",calc.comandoSoma());
    }
    
    /**
     * Teste para o metodo Soma()
     */
    public void testSomaUm() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        assertEquals("1",calc.comandoSoma());
    }
    
    /**
     * Teste para o metodo Limpa()
     */
    public void testSomaUmLimpa() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        assertEquals("1",calc.comandoSoma());
        calc.entraUm();
        assertEquals("2",calc.comandoSoma());
        assertEquals("0", calc.limpa());
    }    
    
    /**
     * Teste para o metodo Limpa()
     */
    public void testLimpa() {
        Calculadora calc = new Calculadora();
        assertEquals("0", calc.limpa());
    }
    
    /**
    * Testes Binarios
    */
    public void testSomaSomenteBinario() {
        Calculadora calc = new Calculadora();
        calc.modoBin();
        calc.entraUm();
        calc.comandoSoma();
        calc.entraUm();
        assertEquals("0b10", calc.comandoSoma());
    }
   
    /**
     * Testes Binarios
     */
    public void testSomaSomenteBinarioDoisAlgarismos() {
        Calculadora calc = new Calculadora();
        calc.modoBin();
        calc.entraUm();
        calc.entraUm();
        calc.comandoSoma();
        calc.entraUm();
        calc.entraUm();
        assertEquals("0b110", calc.comandoSoma());
     }
   
     /**
     * Testes Binarios
     */
     public void testSomaSomenteBinarioTresAlgarismos() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         assertEquals("0b1110", calc.comandoSoma());
     }    
    
     /**
      * Testes Hexadecimal
      */
     public void testSomaSomenteHexa() {
         Calculadora calc = new Calculadora();
         calc.modoHex();
         calc.entraUm();
         calc.comandoSoma();
         calc.entraUm();
         assertEquals("0x2", calc.comandoSoma());
     }
   
     /**
      * Testes Hexadecimal
      */
     public void testSomaSomenteHexaDoisAlgarismos() {
         Calculadora calc = new Calculadora();
         calc.modoHex();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();
         calc.entraUm();
         calc.entraUm();
         assertEquals("0x22", calc.comandoSoma());
     }
   
     /**
      * Testes Hexadecimal
      */
     public void testSomaSomenteHexaTresAlgarismos() {
         Calculadora calc = new Calculadora();
         calc.modoHex();
         calc.entraUm();
         calc.comandoSoma();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         assertEquals("0x112", calc.comandoSoma());
     }    
   
    /**
     * Testes Binarios com Hexa
     */
    public void testEntraUmBinarioHexa() {
        Calculadora calc = new Calculadora();
        calc.modoBin();
        calc.entraUm();
        calc.modoHex();
        assertEquals("0x11", calc.entraUm());
     }    
   
     /**
      * Testes Binarios com Hexa
      */
     public void testSomaBinarioHexaUmAlgarismo() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.comandoSoma();
         calc.modoHex();
         calc.entraUm();
         assertEquals("0x2", calc.comandoSoma());
     }    
   
     /**
      * Testes Binarios com Hexa
      */
     public void testSomaBinarioHexaDoisAlgarismos() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();
         calc.modoHex();
         calc.entraUm();
         calc.entraUm();
         assertEquals("0x14", calc.comandoSoma());
     }   
   
     /**
      * Testes Binarios com Hexa
      */
     public void testEntraUmBinarioHexaBinario(){
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.modoHex();
         calc.entraUm();
         calc.modoBin();
         assertEquals("0b100011", calc.entraUm());
     }   
          
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testEntraUmBinarioHexaDecimal() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.modoHex();
         calc.entraUm();
         calc.modoDec();
         assertEquals("171", calc.entraUm());
     }   
     
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testSomaBinarioHexaDecimal() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.comandoSoma();      
         calc.modoHex();
         calc.entraUm();
         calc.comandoSoma();      
         calc.modoDec();
         calc.entraUm();
         assertEquals("3", calc.comandoSoma());
     }   
     
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testSomaBinarioHexaDecimal1() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.modoHex();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.modoDec();
         calc.entraUm();
         calc.entraUm();
         assertEquals("31", calc.comandoSoma());
     }
     
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testSomaBinarioHexaDecimal11() {
         Calculadora calc = new Calculadora();
         calc.modoBin();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.modoHex();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.modoDec();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         assertEquals("391", calc.comandoSoma());
     }
   
    /**
     * Teste: entrar com o numero D1ID11
     */
    public void testeEntraD1ID11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1I0b11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o numero D1IB11
     */
    public void testeEntraD1IB11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1I0b11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o numero D1IH11
     */
    public void testeEntraD1IH11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x1I0x11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o numero B1IB11
     */
    public void testeEntraB1IB11() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1I0b11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o numero B1IH11
     */
    public void testeEntraB1IH11() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x1I0x11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o numero H1IH11
     */
    public void testeEntraH1IH11() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x1I0x11", calculadora.entraUm());
    }
    
    /**
     * Teste: somar D111ID11 e D111ID11
     */
    public void testeSomaD111ID11eD111ID11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("222I22", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar D11IB1 e D1IB1
     */
    public void testeSomaD11IB1eD1IB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1100I0b10", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar D11IH1 e D1IH1
     */
    public void testeSomaD11IH1eD1IH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0xCI0x2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar B11IB1 e B1IB1
     */
    public void testeSomaB11IB1eB1IB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0b100I0b10", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar B11IH1 e B1IH1
     */
    public void testeSomaB11IH1eB1IH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x4I0x2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar H11IH1 e H1IH1
     */
    public void testeSomaH11IH1eH1IH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0x12I0x2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar D1ID1 e D1
     */
    public void testeSomaD1ID1eD1()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2I1", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar D11ID1 e ID1
     */
    public void testeSomaD11ID1eID1()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("11I2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar H11 e IB11
     */
    public void testeSomaH11eIB11()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b10001I0b11", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar IB11 e IH11
     */
    public void testeSomaIB11eIH11()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0x0I0x14", calculadora.comandoSoma());
    }
      
    /**
     * Teste: somar B11111ID11 e H111IB111
     */
    public void testeSomaB11111ID11eH111IB111()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b100110000I0b10010", calculadora.comandoSoma());
    }

	public void testTestEntra1N1()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		assertEquals("1N1", calculad1.entraUm());
	}

	public void testTestSoma1N1e1N1()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		assertEquals("2N1", calculad1.comandoSoma());
	}

	public void testTestSoma1N1I1N1e1N1I1N1()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.comandoSoma();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		assertEquals("2N1I2N1", calculad1.comandoSoma());
	}
}



