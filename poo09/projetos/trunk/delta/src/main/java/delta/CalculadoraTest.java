/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;

/**
 * Classe de teste da calculadora.
 * @author  Carlos Felippe Cardoso e Andre Sion
 * @version 5.0
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
        assertEquals("0", calculadora.limpa());
    }
  
    /**
     * Teste do metodo limpa sendo chamado sem ter entrado 
     * com um operador.
     */
    public void testLimpaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.limpa());
    }
  
    /** 
     * Teste do metodo limpa apos uma soma ser efetuada
     * limpando o acumulador e o operador.
     */
    public void testLimpaAcumuladorSomaUmOperador() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("0", calculadora.limpa());
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
        assertEquals("0", calculadora.limpa());
        assertEquals("1", calculadora.entraUm()); // testa se operador foi limpo
    }
  
    /** 
     * Entra com valor 1 em Hexadecimal
     * Retorno esperado é H1.
     */
    public void testEntraHexaEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Hexadecimal
     * Retorno esperado é H11.
     */
    public void testEntraHexaEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x11", calculadora.entraUm());
    }

    /** 
     * Entra com valor 1 em Binário
     * Retorno esperado é B1.
     */
    public void testEntraBinarioEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Binário
     * Retorno esperado é B1011.
     */
    public void testEntraBinarioEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b11", calculadora.entraUm());
    }

    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado é D1.
     */
    public void testEntraDecimalEntraUm() {
       Calculadora calculadora = new Calculadora();
       calculadora.modoDec();
       assertEquals("1",  calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Decimal
     * Retorno esperado é D11.
     */
    public void testEntraDecimalEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("11",calculadora.comandoSoma());
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
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.modoHex();        
        calculadora.entraUm();
        calculadora.modoDec();        
        assertEquals("369",calculadora.comandoSoma());
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
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0x11", calculadora.comandoSoma());
        calculadora.modoHex();
        calculadora.entraUm();
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
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("11", calculadora.comandoSoma());
        calculadora.modoDec();
        calculadora.entraUm();
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
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b11", calculadora.comandoSoma());
        calculadora.modoBin();
        calculadora.entraUm();
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
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b11", calculadora.comandoSoma());
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b100", calculadora.comandoSoma());
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0x15", calculadora.comandoSoma());
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("32", calculadora.comandoSoma());       
    }        
  
    /** 
     * Testes Para Números Complexos
     **/
    public void testEntraUmEntraIEntraUm() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        a.entraUm();
        assertEquals("1I1", a.comandoSoma());
    }  
  
    public void testEntraIBinario() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        a.modoBin();
        a.entraUm();
        assertEquals("0b1I0b1", a.comandoSoma());
    }  
    
    public void testEntraIHexa() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        a.modoHex();
        a.entraUm();
        assertEquals("0x1I0x1", a.comandoSoma());
    }  

    public void testEntraISoma() {
        Calculadora b = new Calculadora();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        assertEquals("2I1", b.comandoSoma());
    }

    public void testEntraISomaI() {
        Calculadora b = new Calculadora();
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
        Calculadora b = new Calculadora();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraI();
        b.entraUm();
        assertEquals("0I2", b.comandoSoma());
    }

    public void testEntraISomaBinario() {
        Calculadora b = new Calculadora();
        b.modoBin();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        assertEquals("0b10I0b1", b.comandoSoma());
    }

    public void testEntraISomaIBinario() {
        Calculadora b = new Calculadora();
        b.modoBin();
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
        Calculadora b = new Calculadora();
        b.modoBin();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraI();
        b.entraUm();
        assertEquals("0b0I0b10", b.comandoSoma());
    }

    public void testEntraISomaHexa() {
        Calculadora b = new Calculadora();
        b.modoHex();
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
        Calculadora b = new Calculadora();
        b.modoHex();
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
        Calculadora b = new Calculadora();
        b.modoHex();
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
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("11N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Entrada: IMAGINÁRIO
     */
    public void testEntraID11EB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b0I0b1011N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Entrada: COMPLEXO
     */
    public void testEntraB1ED1ID1B1EH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x1N1I0x3N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: REAL+REAL
     */
    public void testSomaD11ED1eD11ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("22N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: REAL+IMAGINÁRIO
     */
    public void testSomaD11ED1eID1EB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1011N1I0b1N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: IMAGINÁRIO+IMAGINÁRIO
     */
    public void testSomaID1EB1eID1EH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x0I0x2N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: REAL+COMPLEXO
     */
    public void testSomaH1EH1eB1EB1ID1ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("2N1I1N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: IMAGINÁRIO+COMPLEXO
     */
    public void testSomaID11ED1eH1EH1IB1EB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("0b1N1I0b1100N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: COMPLEXO+COMPLEXO
     */
    public void testSomaH1EH1ID1ED1eB1EB1IH1EH1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("0x2N1I0x2N1", calculadora.comandoSoma());
    }
    
    /**
     * EXTRA: Teste de Soma: COMPLEXO+COMPLEXO
     */
    public void testSomaD1ED1ID11ED1eD11ED1ID11ED1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("12N1I22N1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma de expoentes diferentes
     * D1E1 + B1E11 = B1EB11
     */
    public void testSomaOperandosExpoentesDiferentes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b1N11", calculadora.comandoSoma());
    }
    
    /**
     * Trabalho 5: Casos de testes para números vetoriais.
     * Testes de Entrada: 1D, 2D, 3D.
     * Testes de Soma:    VETOR1DREAL+REAL, 
     *                    VETOR1DREAL+COMPLEXO,
     *                    VETOR2DREALREAL+REAL, 
     *                    VETOR2DREALEXPOENCIAL+COMPLEXO, 
     *                    EXPONENCIAL+VETOR2DREALCOMPLEXO, 
     *                    VETOR3DREALREALREAL+REAL, 
     *                    VETOR3DREALCOMPLEXOEXPONENCIAL+REAL, 
     *                    COMPLEXO+VETOR3DREALCOMPLEXOEXPONENCIAL, 
     *                    VETOR3DREALCOMPLEXOEXPONENCIAL+EXPONENCIAL
     */
    
    /**
     * Teste de Entrada: 1D
     */
    public void testEntraVetor1D() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("11", calculadora.entraUm());
    }
    
    /**
     * Teste de Entrada: 2D
     */
    public void testEntraVetor2D() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1011V0b1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Entrada: 3D
     */
    public void testEntraVetor3D() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0xBV0x1V0x1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: VETOR1DREAL+REAL
     */ 
    public void testSomaVetor1DRealEReal() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("12", calculadora.comandoSoma());
    }
      
    /**
     * Teste de Soma: VETOR1DREAL+COMPLEXO
     */
    public void testSomaVetor1DRealEComplexo() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0b10I0b1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: VETOR2DREALREAL+REAL
     */
    public void testSomaVetor2DRealRealEReal() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x2V0x2", calculadora.comandoSoma()); 
    }
      
    /**
     * Teste de Soma: VETOR2DREALEXPOENCIAL+COMPLEXO
     */
    public void testSomaVetor2DRealExponencialEComplexo() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("2I1V1N1I1", calculadora.comandoSoma()); 
    }
    
    /**
     * Teste de Soma: EXPONENCIAL+VETOR2DREALCOMPLEXO
     */
    public void testSomaExponencialEVetor2DRealComplexo() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0x1N1V0x1N1I0x1", calculadora.comandoSoma()); 
    }
    
    /**
     * Teste de Soma: VETOR3REALREALREAL+REAL
     */
    public void testSomaVetor3DRealRealRealEReal() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b10V0b10V0b10", calculadora.comandoSoma()); 
    }
        
    /**
     * Teste de Soma: VETOR3DREALCOMPLEXOEXPONENCIAL+REAL
     */
    public void testSomaVetor3DRealComplexoExponencialEReal() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x2V0x2I0x1V0x1N1", calculadora.comandoSoma());
    }
    
     /**
     * Teste de Soma: COMPLEXO+VETOR3DREALCOMPLEXOEXPONENCIAL 
     */
    public void testSomaComplexoEVetor3DRealComplexoExponencial() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();    
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("2I1V2I2V1N1I1", calculadora.comandoSoma());
    }
 
     /** 
     * Teste de Soma: VETOR3DREALCOMPLEXOEXPONENCIAL+EXPONENCIAL
     */
    public void testSomaVetor3DRealComplexoExponencialEExponencial() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("0b1N1V0b1N1I0b1V0b10N1", calculadora.comandoSoma());
    }
    
    /**
     * Trabalho 6: Casos de testes para operações subtração.
     * Testes de Subtração: REAL-REAL, REAL-IMAGINÁRIO, IMAGINÁRIO-IMAGINÁRIO,
     *                      REAL-COMPLEXO, IMAGINÁRIO-COMPLEXO, COMPLEXO-COMPLEXO.
     *                      VETOR1DREAL-REAL, 
     *                      VETOR1DREAL-COMPLEXO,
     *                      VETOR2DREALREAL-REAL, 
     *                      VETOR2DREALEXPOENCIAL-COMPLEXO, 
     *                      EXPONENCIAL-VETOR2DREALCOMPLEXO, 
     *                      VETOR3DREALREALREAL-REAL, 
     *                      VETOR3DREALCOMPLEXOEXPONENCIAL-REAL, 
     *                      COMPLEXO-VETOR3DREALCOMPLEXOEXPONENCIAL, 
     *                      VETOR3DREALCOMPLEXOEXPONENCIAL-EXPONENCIAL
     */                      
     
    /**
     * Teste de Subtração: REAL-REAL
     */
    public void testSubD11ED1eD11ED1() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai ();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN ();
        calculadora.entraUm();
        assertEquals("0N1", calculadora.comandoSubtrai());
    }
    
    /**
     * Teste de Subtração: REAL-IMAGINÁRIO
     */
    public void testSubD11ED1eID1EB1() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm ();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai ();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1011N1I0b1N1", calculadora.comandoSubtrai());
    }
    
    /**
     * Teste de Subtração: IMAGINÁRIO-IMAGINÁRIO 
     */
    public void testSubID1EB1eID1EH1() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraN ();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x0I0x0N1", calculadora.comandoSubtrai());
    }
    
    /**
     * Teste de Subtração: REAL-COMPLEXO 
     */
    public void testSubH1EH1eB1EB1ID1ED1() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.modoHex();
        calculadora.entraUm(); 
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraN ();
        calculadora.entraUm();
        assertEquals("0N1I1N1", calculadora.comandoSubtrai());
    }
    
    /**
     * Teste de Subtração: IMAGINÁRIO-COMPLEXO
     */
    public void testSubID11ED1eH1EH1IB1EB1() { 
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm ();
        calculadora.comandoSubtrai();
        calculadora.modoHex ();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("0b11111111111111111111111111111111N1I0b1010N1", calculadora.comandoSubtrai ());
    }
    
    /**
     * Teste de Subtração: COMPLEXO-COMPLEXO 
     */
    public void testSubH1EH1ID1ED1eB1EB1IH1EH1() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.modoHex();
        calculadora.entraUm ();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN ();
        calculadora.entraUm();
        calculadora.entraI ();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("0x0N1I0x0N1", calculadora.comandoSubtrai()); 
    }
    
    /**
     * EXTRA Teste de Subtração: COMPLEXO-COMPLEXO
     */
    public void testSubD1ED1ID11ED1eD11ED1ID11ED1() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN ();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("-10N1I0N1", calculadora.comandoSubtrai ());
    }
    
    /**
     * Teste de Subtração de expoentes diferentes
     * D1E1 - B1E11 = B1EB11
     */
    public void testSubOperandosExpoentesDiferentes() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b11111111111111111111111111111111N11", calculadora.comandoSubtrai());
    }
    
    /**
     * Teste de Subtração: VETOR1DREAL-REAL
     */ 
    public void testSubVetor1DRealEReal() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm (); 
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.entraUm();
        assertEquals("10", calculadora.comandoSubtrai());
    }
      
    /**
     * Teste de Subtração: VETOR1DREAL-COMPLEXO 
     */
    public void testSubVetor1DRealEComplexo() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0b0I0b1", calculadora.comandoSubtrai());
    }
     
    /**
     * Teste de Subtração: VETOR2DREALREAL-REAL
     */
    public void testSubVetor2DRealRealEReal() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x0V0x0", calculadora.comandoSubtrai()); 
    }
      
    /**
     * Teste de Subtração: VETOR2DREALEXPOENCIAL-COMPLEXO
     */
    public void testSubVetor2DRealExponencialEComplexo() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0I1V1N1I1", calculadora.comandoSubtrai()); 
    } 
    
    /**
     * Teste de Subtração: EXPONENCIAL-VETOR2DREALCOMPLEXO
     */
    public void testSubExponencialEVetor2DRealComplexo() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.modoHex ();   
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("0x1N1V0x1N1I0x1", calculadora.comandoSubtrai()); 
    }
    
    /**
     * Teste de Subtração: VETOR3REALREALREAL-REAL 
     */
    public void testSubVetor3DRealRealRealEReal() { 
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.modoBin ();
        calculadora.entraUm();
        assertEquals("0b0V0b0V0b0", calculadora.comandoSubtrai()); 
    }
        
    /**
     * Teste de Subtração: VETOR3DREALCOMPLEXOEXPONENCIAL-REAL
     */
    public void testSubVetor3DRealComplexoExponencialEReal() { 
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm ();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm ();
        calculadora.comandoSubtrai();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x0V0x0I0x1V0x1N1", calculadora.comandoSubtrai());
    }
    
    /** 
     * Teste de Subtração: COMPLEXO-VETOR3DREALCOMPLEXOEXPONENCIAL 
     */
    public void testSubComplexoEVetor3DRealComplexoExponencial() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraUm();    
        calculadora.entraI(); 
        calculadora.entraUm();
        calculadora.comandoSubtrai();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm ();
        calculadora.entraV();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm ();
        assertEquals("0I1V0I0V-1N1I1", calculadora.comandoSubtrai()); 
    }
 
    /** 
     * Teste de Subtração: VETOR3DREALCOMPLEXOEXPONENCIAL-EXPONENCIAL 
     */
    public void testSubVetor3DRealComplexoExponencialEExponencial() {
        Calculadora calculadora = new Calculadora(); 
        calculadora.entraUm();
        calculadora.entraV ();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraV();
        calculadora.entraUm ();
        calculadora.entraN();
        calculadora.entraUm ();
        calculadora.comandoSubtrai();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.entraUm();
        assertEquals("0b11111111111111111111111111111111N1V0b11111111111111111111111111111111N1I0b1V0b0N1", calculadora.comandoSubtrai());    
        
    }
    
    /////////////////////////////////////////////
    // TESTES DO CARLO DA CALCULADORA COMPLEXO //
    /////////////////////////////////////////////
    /**
     * Teste: somar b11111id11+h111ib111+ -> 0b100110000I0b10010.
     */
    public void testeSoma0b11111ID11e0x111I0b111sai0b100110000I0b10010() {
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

    /**
     * Teste: somar h11+Ib11+ -> 0b10001I0b11.
     */
    public void testeSoma0x11eI0b11sai0b10001I0b11() {
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
     * Teste: somar 11id1+id1+ -> 11I2.
     */
    public void testeSomaD11ID1eID1sai11I2() {
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
     * Teste: somar 1i1+1+ -> 2I1.
     */
    public void testeSomaD1ID1eD1sai2I1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2I1", calculadora.comandoSoma());
    }

    /**
     * Teste: somar Ib11+Ih11 -> 0x0I0x14.
     */
    public void testeSomaI0b11eI0x11sai0x0I0x14() {
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

    ///////////////////////////////////////////////
    // TESTES DO CARLO DA CALCULADORA ENGENHARIA //
    ///////////////////////////////////////////////
    /**
     *         Teste: entrar com o número D1N1IB11 (1e1+0b11i) -> 0b1N1I0b11.
     */
    public void testeEntraD1N1IB11sai0b1N1I0b11() {
    	// entrar com o número D1N1 IB11 (1e1+0b11i)

    	Calculadora calculad2 = new Calculadora();

    	// D1N1
    	calculad2.modoDec();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	// IB11
    	calculad2.entraI();
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();

    	assertEquals("0b1N1I0b11",calculad2.comandoSoma());
    }

    /**
     *         Teste: entrar com o número D1IB11N1 (1+0b11e1) -> 0b1I0b11N0b1.
     */
    public void testeEntraD1IB11N1sai0b1I0b11N1() {
    	// entrar com o número D1 IB11N1 (1+0b11e1)

    	Calculadora calculad2 = new Calculadora();

    	// D1
    	calculad2.modoDec();
    	calculad2.entraUm();

    	// IB11N1
    	calculad2.entraI();
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	assertEquals("0b1I0b11N1",calculad2.comandoSoma());
    }

    /**
     *         Teste: entrar com o número D1N11IH11N1 (1e11+ 0x11e1i) -> 0x1N11I0x11N1.
     */
    public void testeEntraD1N11IH11N1sai0x1NBI0x11N1() {
    	// entrar com o número D1N11 IH11N1 (1e11+ 0x11e1i)

    	Calculadora calculad2 = new Calculadora();

    	// D1N11
    	calculad2.modoDec();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();
    	calculad2.entraUm();

    	// IH11N1
    	calculad2.entraI();
    	calculad2.modoHex();
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	assertEquals("0x1NBI0x11N1",calculad2.comandoSoma());
    }

    /**
     *         Teste: entrar com o número B1NB11IB11ND1 (0b1e0b11 + 0b11e1i) -> 1N3I3N1.
     */
    public void testeEntraB1IB11sai1N3I3N1() {
    	// entrar com o número B1NB11 IB11ND1 (0b1e0b11 + 0b11e1i)

    	Calculadora calculad2 = new Calculadora();

    	// B1NB11
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();

    	// IB11ND1
    	calculad2.entraI();
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.modoDec();
    	calculad2.entraUm();

    	assertEquals("1N3I3N1",calculad2.comandoSoma());
    }

    /**
     *         Teste: Somar 1N1 mais 11N1 (1e1 + 11e1) -> 12N1.
     */
    public void testeSoma1N1mais11N1sai12N1() {
    	// Somar 1N1 mais 11N1 (1e1 + 11e1)

    	Calculadora calculad2 = new Calculadora();

    	// 1N1
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	calculad2.comandoSoma();

    	// 11N1
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	assertEquals("12N1",calculad2.comandoSoma());
    }

    /**
 	 * Teste: Somar 11N1 mais 1N11 (11e1 + 1e11) -> 1N11.
     */
    public void testeSoma11N1mais1N11sai1N11() {
    	// Somar 11N1 mais 1N11 (11e1 + 1e11)

    	Calculadora calculad2 = new Calculadora();

    	// 11N1
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	calculad2.comandoSoma();

    	// 1N11
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();
    	calculad2.entraUm();

    	assertEquals("1N11",calculad2.comandoSoma());
    }

    /**
     *         Teste: Somar 11NB11 mais B1NB11 (11e0b11 + 0b1e0b11) -> 0b1100N11.
     */
    public void testeSoma11NB11maisB1NB11sai0b1100N11() {
    	// Somar 11NB11 mais B1NB11 (11e0b11 + 0b1e0b11)

    	Calculadora calculad2 = new Calculadora();

    	//11NB11
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();

    	calculad2.comandoSoma();

    	// B1NB11
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();

    	assertEquals("0b1100N11",calculad2.comandoSoma());
    }

    /**
     *         Teste: Somar H1N1ID11N1 mais B11N11H (0x1e0x1+11e1i + 0b11e0b11) -> 0x3N3I0xBN1.
     */
    public void testeSomaH1N1ID11N1maisB11N11Hsai0x3N3I0xBN1() {
    	// H1N1 ID11N1 mais B11N11H (0x1e0x1 + 11e1i + 0b11e0b11)

    	Calculadora calculad2 = new Calculadora();

    	// H1N1
    	calculad2.modoHex();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();
    	calculad2.modoDec();
    	calculad2.comandoSoma();

    	// ID11N1
    	calculad2.entraI();
    	calculad2.modoDec();
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();

    	calculad2.comandoSoma();

    	// B11N11H
    	calculad2.modoBin();
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.entraN();
    	calculad2.entraUm();
    	calculad2.entraUm();
    	calculad2.modoHex();

    	assertEquals("0x3N3I0xBN1",calculad2.comandoSoma());
    }

    ///////////////////////////////////////////////
    // TESTES DO CARLO DA CALCULADORA ENGENHARIA //
    ///////////////////////////////////////////////
    
    /**
     *         Teste: entrar com o vetor D1N1VB11 (1e1,0b11i) -> 0b1N1V0b11.
     */
    public void testeEntraD1N1VB11sai0b1N1V0b11() {
    	Calculadora calc = new Calculadora();

    	// D1N1VB11
    	calc.modoDec();
    	calc.entraUm();
    	calc.entraN();
    	calc.entraUm();
    	calc.entraV();
    	calc.modoBin();
    	calc.entraUm();
    	
    	assertEquals("0b1N1V0b11",calc.entraUm());
    }
    
    /**
     *         Teste: somar um ao vetor D1VB11I1 (1+[1,0b11+1i]) -> 0b10V0b100I0b1.
     */
    public void testeSoma1aD1VB11I1sai0b10V0b100I1() {
    	Calculadora calc = new Calculadora();
    	
    	// 1
    	calc.entraUm();

    	calc.comandoSoma();
    	
    	// D1VB11I1
    	calc.modoDec();
    	calc.entraUm();
    	calc.entraV();
    	calc.modoBin();
    	calc.entraUm();
    	calc.entraUm();
    	calc.entraI();
    	calc.entraUm();

    	assertEquals("0b10V0b100I0b1",calc.comandoSoma());
    }
    
    /**
     *         Teste: subtrair 1N1 de D11N1VH11N1 ([11e1+ 0x11e1i]-1e1) -> 10N1V16N1.
     */
    public void testeSubtrai1N1deD11N1VH11N1sai10N1V16N1() {
    	Calculadora calc = new Calculadora();

    	// D11N1VH11N1
    	calc.modoDec();
    	calc.entraUm();
    	calc.entraUm();
    	calc.entraN();
    	calc.entraUm();
    	calc.entraV();
    	calc.modoHex();
    	calc.entraUm();
    	calc.entraUm();
    	calc.entraN();
    	calc.entraUm();
    	
    	calc.comandoSubtrai();

    	// 1N1
    	calc.modoDec();
    	calc.entraUm();
    	calc.entraN();
    	calc.entraUm();

    	assertEquals("10N1V16N1",calc.comandoSubtrai());
    }
}
