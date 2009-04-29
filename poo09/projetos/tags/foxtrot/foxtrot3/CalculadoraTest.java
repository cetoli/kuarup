/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com números complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Thiago Silva de Souza)  $Author$
 * @version (3.0)    $Revision$ (28/04/09)      $Date$
 * @since   (3.0) Suporte a números complexos
 */

public class CalculadoraTest extends junit.framework.TestCase
{
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
     * Teste para o método EntraUm()
     */
    public void testEntraUm() {
        Calculadora calc = new Calculadora();
        assertEquals("1", calc.entraUm());
    }

    /**
     * Teste para o método Limpa()
     */
    public void testEntraUmLimpa() {
        Calculadora calc = new Calculadora();
        assertEquals("1", calc.entraUm());
        assertEquals(0, calc.limpa());
    }
    
    /**
     * Teste para o método EntraUm()
     */
    public void testEntraUmUm() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        assertEquals("11", calc.entraUm());
    }

    /**
     * Teste para o método EntraUm()
     */
    public void testEntraUmUmUm() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        calc.entraUm();
        assertEquals("111", calc.entraUm());
    }

    /**
     * Teste para o método Soma()
     */
    public void testSoma() {
        Calculadora calc = new Calculadora();
        assertEquals("0",calc.comandoSoma());
    }
    
    /**
     * Teste para o método Soma()
     */
    public void testSomaUm() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        assertEquals("1",calc.comandoSoma());
    }
    
    /**
     * Teste para o método Limpa()
     */
    public void testSomaUmLimpa() {
        Calculadora calc = new Calculadora();
        calc.entraUm();
        assertEquals("1",calc.comandoSoma());
        calc.entraUm();
        assertEquals("2",calc.comandoSoma());
        assertEquals(0, calc.limpa());
    }    
    
    /**
     * Teste para o método Limpa()
     */
    public void testLimpa() {
        Calculadora calc = new Calculadora();
        assertEquals(0, calc.limpa());
    }
    
    /**
    * Teste para operações em outras bases
    */
    
    /**
    * Testes Binarios
    */
    public void testSomaSomenteBinario() {
        Calculadora calc = new Calculadora();
        calc.entraBinario();
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
        calc.entraBinario();
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
         calc.entraBinario();
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
         calc.entraHexadecimal();
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
         calc.entraHexadecimal();
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
         calc.entraHexadecimal();
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
        calc.entraBinario();
        calc.entraUm();
        calc.entraHexadecimal();
        assertEquals("0x11", calc.entraUm());
     }    
   
     /**
      * Testes Binarios com Hexa
      */
     public void testSomaBinarioHexaUmAlgarismo() {
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.comandoSoma();
         calc.entraHexadecimal();
         calc.entraUm();
         assertEquals("0x2", calc.comandoSoma());
     }    
   
     /**
      * Testes Binarios com Hexa
      */
     public void testSomaBinarioHexaDoisAlgarismos() {
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();
         calc.entraHexadecimal();
         calc.entraUm();
         calc.entraUm();
         assertEquals("0x14", calc.comandoSoma());
     }   
   
     /**
      * Testes Binarios com Hexa
      */
     public void testEntraUmBinarioHexaBinario(){
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.entraHexadecimal();
         calc.entraUm();
         calc.entraBinario();
         assertEquals("0b100011", calc.entraUm());
     }   
          
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testEntraUmBinarioHexaDecimal() {
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.entraHexadecimal();
         calc.entraUm();
         calc.entraDecimal();
         assertEquals("171", calc.entraUm());
     }   
     
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testSomaBinarioHexaDecimal() {
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.comandoSoma();      
         calc.entraHexadecimal();
         calc.entraUm();
         calc.comandoSoma();      
         calc.entraDecimal();
         calc.entraUm();
         assertEquals("3", calc.comandoSoma());
     }   
     
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testSomaBinarioHexaDecimal1() {
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.entraHexadecimal();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.entraDecimal();
         calc.entraUm();
         calc.entraUm();
         assertEquals("31", calc.comandoSoma());
     }
     
     /**
      * Testes Binarios com Hexa com Decimal
      */
     public void testSomaBinarioHexaDecimal11() {
         Calculadora calc = new Calculadora();
         calc.entraBinario();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.entraHexadecimal();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         calc.comandoSoma();      
         calc.entraDecimal();
         calc.entraUm();
         calc.entraUm();
         calc.entraUm();
         assertEquals("391", calc.comandoSoma());
     }
   
    /**
     * TESTE NOVOS PARA O TRABALHO 3
     */
    
    /**
     * TESTE ENTRA()
     */
    /**
     * Teste: entrar com o número D1ID11
     */
    public void testeEntraD1ID11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraBinario();
        calculadora.entraUm();
        assertEquals("0b1I0b11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o número D1IB11
     */
    public void testeEntraD1IB11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraBinario();
        calculadora.entraUm();
        assertEquals("0b1I0b11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o número D1IH11
     */
    public void testeEntraD1IH11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0x1I0x11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o número B1IB11
     */
    public void testeEntraB1IB11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraBinario();
        calculadora.entraUm();
        assertEquals("0b1I0b11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o número B1IH11
     */
    public void testeEntraB1IH11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0x1I0x11", calculadora.entraUm());
    }
    
    /**
     * Teste: entrar com o número H1IH11
     */
    public void testeEntraH1IH11() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0x1I0x11", calculadora.entraUm());
    }
    
    /**
     * TESTE COMANDOSOMA()
     */
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
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraBinario();
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
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0xcI0x2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar B11IB1 e B1IB1
     */
    public void testeSomaB11IB1eB1IB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
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
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0x4I0x2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar H11IH1 e H1IH1
     */
    public void testeSomaH11IH1eH1IH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
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
     * TESTE COMANDOSOMA() COM NÚMEROS COMPLEXOS INCOMPLETOS
     */
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
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.entraDecimal();
        calculadora.entraUm();
        assertEquals("11I2", calculadora.comandoSoma());
    }
    
    /**
     * Teste: somar H11 e IB11
     */
    public void testeSomaH11eIB11()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.entraBinario();
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
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0x0I0x14", calculadora.comandoSoma());
    }
      
    /**
     * TESTE COMANDOSOMA()
     */
    /**
     * Teste: somar B11111ID11 e H111IB111
     */
    public void testeSomaB11111ID11eH111IB111()
    {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b100110000I0b10010", calculadora.comandoSoma());
    }
}