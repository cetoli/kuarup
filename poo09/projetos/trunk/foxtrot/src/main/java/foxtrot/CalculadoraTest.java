/*------------------------------------------------------------------------------
    Copyright © 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Incluídas as funcionalidades: números com notação científica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Incluídas as funcionalidades: números complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
 */
public class CalculadoraTest extends junit.framework.TestCase {    
    /**
     * Default constructor for test class CalculadoraTest
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
     * Teste do metodo entraUm simples, certificando que 1 e retornado.
     */
    public void testEntraUmBasico() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
    }
  
    /**
     * Teste do metodo entraUm sendo executado duas vezes, certificando que 
     * 11 e retornado na sua segunda chamada.
     */
    public void testEntraUmDuasVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("11", calculadora.entraUm());
    }
  
    /**
     * Teste do metodo entraUm sendo executado tres vezes, certificando que 
     * 111 e retornado na sua terceira chamada.
     */
    public void testEntraUmTresVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("111", calculadora.entraUm());
    }
  
    /**
     * Teste do metodo entraUm certificando que altera o display.
     */
    public void testEntraUmAlteraDisplay() {
        Calculadora calculadora = new Calculadora();
        assertFalse(calculadora.entraUm()  == "0");
    }
 
    /**
     * Teste do metodo comandoSoma somente com 1 operador.
     */
    public void testComandoSomaBasico() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
        assertEquals("1", calculadora.comandoSoma());
    }
 
    /**
     * Teste do metodo comandoSoma com dois operadores.
     */
    public void testComandoSomaDoisOperadores() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
        assertEquals("1", calculadora.comandoSoma());
        assertEquals("1", calculadora.entraUm());
        assertEquals("2", calculadora.comandoSoma());
    }
  
    /**
     * Teste do metodo comandoSoma sem operador, ou seja, sem 
     * entrar nenhum numero.
     */
    public void testComandoSomaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.comandoSoma());
    }
  
    /**
     * Teste do metodo comandoSoma sendo executado duas vezes.
     */
    public void testComandoSomaDuasVezes() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
        assertEquals("1", calculadora.comandoSoma());
        assertEquals("1", calculadora.comandoSoma());
    }
  
    /** 
     * Teste do metodo limpa basico, limpando um operador 
     * digitado.
     */
    public void testLimpaBasico() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals(0, calculadora.limpa());
    }
  
    /**
     * Teste do metodo limpa sendo chamado sem ter entrado 
     * com um operador.
     */
    public void testLimpaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertFalse(calculadora.limpa() != 0);
    }
  
    /** 
     * Teste do metodo limpa apos uma soma ser efetuada
     * limpando o acumulador e o operador.
     */
    public void testLimpaAcumuladorSomaUmOperador() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals(0, calculadora.limpa());
        assertEquals("1", calculadora.entraUm()); // testa se operador foi limpo
    }  
  
    /** 
     * Teste do metodo limpa apos uma soma de dois operadores
     * for efetuada limpando o acumulador e o operador.
     */
    public void testLimpaAcumuladorSomaDoisOperadores() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals(0, calculadora.limpa());
        assertEquals("1", calculadora.entraUm()); // testa se operador foi limpo
    }
  
    /** 
     * Entra com valor 1 em Hexadecimal
     * Retorno esperado é H1.
     */
    public void testEntraHexaEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        assertEquals("0x1", calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Hexadecimal
     * Retorno esperado é H11.
     */
    public void testEntraHexaEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0x11", calculadora.entraUm());
    }

    /** 
     * Entra com valor 1 em Binário
     * Retorno esperado é B1.
     */
    public void testEntraBinarioEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        assertEquals("0b1", calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Binário
     * Retorno esperado é B1011.
     */
    public void testEntraBinarioEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        calculadora.entraUm();
        assertEquals("0b11", calculadora.entraUm());
    }

    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado é D1.
     */
    public void testEntraDecimalEntraUm() {
       Calculadora calculadora = new Calculadora();
       calculadora.entraDecimal();
       assertEquals("1",  calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Decimal
     * Retorno esperado é D11.
     */
    public void testEntraDecimalEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraDecimal();
        calculadora.entraUm();
        assertEquals("11",calculadora.entraUm());
    }
  
    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado é D1.
     * Entra com mais um valor 1 em Decimal
     * Retorno esperado é D11.
     * Muda a base para Binário
     * Retorno esperado é B1011  (Cálculo validado na calculadora cientifica do Windows)
     * Entra com valor 1 em Binário (Aqui é diferente da calculadora do Windows, pois nesta Calculadora o valor é acumulado, com isso, 
     *                               é adicionado o valor 1 no final da String, enquanto que na calculadora do Windows é substituído por 1
     *                               obs: Para funcionar como a calculadora do Windows, basta utilizar o método limpa())
     * Retorno esperado é B10111 
     * Muda a base para Hexadecimal 
     * Retorno esperado é H17    (Cálculo validado na calculadora cientifica do Windows)
     * Entra com valor 1 em Hexadecimal  (Aqui é diferente da calculadora do Windows, pois nesta Calculadora o valor é acumulado, com isso, 
     *                                    é adicionado o valor 1 no final da String, enquanto que na calculadora do Windows é substituído por 1
     *                                    obs: Para funcionar como a calculadora do Windows, basta utilizar o método limpa())
     * Retorno esperado é H171
     * Muda a base para Decimal
     * Retorno esperado é 369    (Cálculo validado na calculadora cientifica do Windows)
     **/
     public void testEntraHexaBinarioDecimal() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraDecimal();
        assertEquals("1", calculadora.entraUm());
        assertEquals("11", calculadora.entraUm());
        assertEquals("0b1011", calculadora.entraBinario());
        assertEquals("0b10111", calculadora.entraUm());        
        assertEquals("0x17", calculadora.entraHexadecimal());        
        calculadora.entraUm();
        assertEquals("369", calculadora.entraDecimal());        
    }
  
    /** 
     * Entra com valor 1 em Hexadecimal
     * Retorno esperado é H1.
     * Entra com mais um valor 1 em Hexadecimal
     * Retorno esperado é H11.
     * Realiza a soma do valor (11) em Hexadecimal
     * Retorno esperado será o valor igual a 12 em Hexadecimal.    (Cálculo validado na calculadora cientifica do Windows)
     **/
    public void testEntraSomaHexa() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        assertEquals("0x1", calculadora.entraUm());
        assertEquals("0x11", calculadora.entraUm());
        assertEquals("0x11", calculadora.comandoSoma());
        calculadora.entraHexadecimal();
        assertEquals("0x1", calculadora.entraUm()); 
        assertEquals("0x12", calculadora.comandoSoma());
    }
  
    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado é D1.
     * Entra com mais um valor 1  Decimal
     * Retorno esperado é D11.
     * Realiza a soma do valor (11) em Decimal
     * Retorno esperado será o valor do  11.
     * Entra com 1 em Decimal
     * Retorno esperado é D1.
     * 
     * Realiza a soma 
     * Retorno esperado igual a 12 em Decimal.
     **/
    public void testEntraSomaDecimal() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraDecimal();
        assertEquals("1", calculadora.entraUm());
        assertEquals("11", calculadora.entraUm());
        assertEquals("11", calculadora.comandoSoma());
        calculadora.entraDecimal();
        assertEquals("1", calculadora.entraUm()); 
        assertEquals("12", calculadora.comandoSoma());
    }    
  
    /** 
     * Entra com valor 1 em Binário
     * Retorno esperado é B1.
     * Entra com mais um valor 1 em Binário
     * Retorno esperado é B11.
     * Realiza a soma do valor (11) em Binário
     * Retorno esperado igual a 11 em Binário.
     * Entra com 1 em Binário
     * Retorno esperado é B1.
     * Realiza a soma 
     * Retorno esperado é igual 100 em Binário. (Cálculo validado na calculadora cientifica do Windows)
     **/
    public void testEntraSomaBinario() {
        Calculadora calculadora = new Calculadora();    
        calculadora.entraBinario();
        assertEquals("0b1", calculadora.entraUm());
        assertEquals("0b11", calculadora.entraUm());
        assertEquals("0b11", calculadora.comandoSoma());
        calculadora.entraBinario();
        assertEquals("0b1", calculadora.entraUm()); 
        assertEquals("0b100", calculadora.comandoSoma());
    }      
 
    /** 
     * ******* Binário **************
     * Entra com valor 1 em Binário
     * Retorno esperado é B1.
     * Entra com mais um valor 1 em Binário
     * Retorno esperado é B11.
     * Realiza a soma do valor (11) em Binário
     * Retorno esperado igual a 11.
     * Entra com 1 em Binário
     * Retorno esperado é B1.
     * Realiza a soma dos valores em binário
     * Retorno esperado é igual 100. (Cálculo validado na calculadora cientifica do Windows)
     * ********** Hexadecimal *************
     * Entra com valor 1 em Hexadecimal
     * Retorno esperado é igual H1
     * Entra com outro valor 1 em Hexadecimal
     * Retorno esperador é igual H11
     * Realiza soma do valor em Binário (100) com valor em Hexadecimal (11)
     * Retorno esperador é igual á 15 (Cálculo validado na calculadora cientifica do Windows)
     * ********* Decimal *************
     * Muda a base para Decimal
     * Entra com valor 1 em Decimal
     * Retorno esperado D1
     * Entra com outro valor 1 em Decimal
     * Retorno esperado D11
     * Realiza a soma do valor acumulado (15) em hexadecimal que passado para decimal ficou igual a (21) mais o valor (11) em decimal 
     * Retorno esperado é igual a 32 (Cálculo validado na calculadora cientifica do Windows)
     **/
    public void testEntraSomaHexaDecimalBinario() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        assertEquals("0b1", calculadora.entraUm());
        assertEquals("0b11", calculadora.entraUm());
        assertEquals("0b11", calculadora.comandoSoma());
        calculadora.entraBinario();
        assertEquals("0b1", calculadora.entraUm()); 
        assertEquals("0b100", calculadora.comandoSoma());
        calculadora.entraHexadecimal();
        assertEquals("0x1", calculadora.entraUm());
        assertEquals("0x11", calculadora.entraUm());
        assertEquals("0x15", calculadora.comandoSoma());
        calculadora.entraDecimal();
        assertEquals("1", calculadora.entraUm());
        assertEquals("11", calculadora.entraUm());
        assertEquals("32", calculadora.comandoSoma());       
    }        
  
    /** 
     * Testes Para Números Complexos
     **/
    public void testEntraUmEntraIEntraUm() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        assertEquals("1I1", a.entraUm());
    }  
  
    public void testEntraIBinario() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        a.entraBinario();
        assertEquals("0b1I0b1", a.entraUm());
    }  
    
    public void testEntraIHexa() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        a.entraHexadecimal();
        assertEquals("0x1I0x1", a.entraUm());
    }  

    public void testEntraISoma() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        assertEquals("2I1", b.comandoSoma());
    }

    public void testEntraISomaI() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        b.entraI();
        b.entraUm();
        assertEquals("2I2", b.comandoSoma());
    }

    public void testEntraISomaEntraI() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraI();
        b.entraUm();
        assertEquals("0I2", b.comandoSoma());
    }

    public void testEntraISomaBinario() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraBinario();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        assertEquals("0b10I0b1", b.comandoSoma());
    }

    public void testEntraISomaIBinario() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraBinario();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        b.entraI();
        b.entraUm();
        assertEquals("0b10I0b10", b.comandoSoma());
    }

    public void testEntraISomaEntraIBinario() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraBinario();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraI();
        b.entraUm();
        assertEquals("0b0I0b10", b.comandoSoma());
    }

    public void testEntraISomaHexa() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraHexadecimal();
        b.entraUm();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        b.entraUm();
        assertEquals("0x22I0x11", b.comandoSoma());
    }

    public void testEntraISomaIHexa() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraHexadecimal();
        b.entraUm();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.entraUm();
        assertEquals("0x22I0x22", b.comandoSoma());
    }

    public void testEntraISomaEntraIHexa() {
        Calculadora b = new foxtrot.Calculadora();
        b.entraHexadecimal();
        b.entraI();
        b.entraUm();
        b.entraUm();
        b.comandoSoma();
        b.entraI();
        b.entraUm();
        b.entraUm();
        assertEquals("0x0I0x22", b.comandoSoma());
    }
    
    /**
     * Trabalho 4: Casos de testes para números com notação científica.
     * Testes de Entrada: REAL, IMAGINÁRIO, COMPLEXO.
     * Testes de Soma:    REAL+REAL, REAL+IMAGINÁRIO, IMAGINÁRIO+IMAGINÁRIO,
     *                    REAL+COMPLEXO, IMAGINÁRIO+COMPLEXO, COMPLEXO+COMPLEXO.
     */     
    
    /**
     * Teste de Entrada: REAL
     */
    public void testEntraD11ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        assertEquals("11E1", calculadora.entraUm());
    }
    
    /**
     * Teste de Entrada: IMAGINÁRIO
     */
    public void testEntraID11EB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraBinario();
        assertEquals("0b0I0b1011E0b1", calculadora.entraUm());
    }
    
    /**
     * Teste de Entrada: COMPLEXO
     */
    public void testEntraB1ED1ID1B1EH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraHexadecimal();
        assertEquals("0x1E0x1I0x3E0x1", calculadora.entraUm());
    }
    
    /**
     * Teste de Soma: REAL+REAL
     */
    public void testSomaD11ED1eD11ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        assertEquals("22E1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: REAL+IMAGINÁRIO
     */
    public void testSomaD11ED1eID1EB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraBinario();
        calculadora.entraUm();
        assertEquals("0b1011E0b1I0b1E0b1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: IMAGINÁRIO+IMAGINÁRIO
     */
    public void testSomaID1EB1eID1EH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        assertEquals("0x0I0x2E0x1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: REAL+COMPLEXO
     */
    public void testSomaH1EH1eB1EB1ID1ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        assertEquals("2E1I1E1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: IMAGINÁRIO+COMPLEXO
     */
    public void testSomaID11ED1eH1EH1IB1EB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        assertEquals("0b1E0b1I0b1100E0b1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: COMPLEXO+COMPLEXO
     */
    public void testSomaH1EH1ID1ED1eB1EB1IH1EH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraDecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraHexadecimal();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        assertEquals("0x2E0x1I0x2E0x1", calculadora.comandoSoma());
    }
    
    /**
     * EXTRA: Teste de Soma: COMPLEXO+COMPLEXO
     */
    public void testSomaD1ED1ID11ED1eD11ED1ID11ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        assertEquals("12E1I22E1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma de expoentes diferentes
     * D1E1 + B1E11 = B1EB11
     */
    public void testSomaOperandosExpoentesDiferentes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraBinario();
        calculadora.entraUm();
        calculadora.entraE();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b1E0b11", calculadora.comandoSoma());
    }
}
