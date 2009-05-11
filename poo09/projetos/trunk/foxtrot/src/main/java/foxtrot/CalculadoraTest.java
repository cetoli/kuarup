/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
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
        assertEquals("0", calculadora.limpa());
    }
  
    /**
     * Teste do metodo limpa sendo chamado sem ter entrado 
     * com um operador.
     */
    public void testLimpaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals(calculadora.limpa(), "0");
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
     * Retorno esperado � H1.
     */
    public void testEntraHexaEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Hexadecimal
     * Retorno esperado � H11.
     */
    public void testEntraHexaEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x11", calculadora.entraUm());
    }

    /** 
     * Entra com valor 1 em Bin�rio
     * Retorno esperado � B1.
     */
    public void testEntraBinarioEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Bin�rio
     * Retorno esperado � B1011.
     */
    public void testEntraBinarioEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b11", calculadora.entraUm());
    }

    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado � D1.
     */
    public void testEntraDecimalEntraUm() {
       Calculadora calculadora = new Calculadora();
       calculadora.modoDec();
       assertEquals("1",  calculadora.entraUm());
    }

    /** 
     * Entra com valor 11 em Decimal
     * Retorno esperado � D11.
     */
    public void testEntraDecimalEntraUmUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("11",calculadora.entraUm());
    }
  
    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado � D1.
     * Entra com mais um valor 1 em Decimal
     * Retorno esperado � D11.
     * Muda a base para Bin�rio
     * Retorno esperado � B1011  (C�lculo validado na calculadora cientifica do Windows)
     * Entra com valor 1 em Bin�rio (Aqui � diferente da calculadora do Windows, pois nesta Calculadora o valor � acumulado, com isso, 
     *                               � adicionado o valor 1 no final da String, enquanto que na calculadora do Windows � substitu�do por 1
     *                               obs: Para funcionar como a calculadora do Windows, basta utilizar o m�todo limpa())
     * Retorno esperado � B10111 
     * Muda a base para Hexadecimal 
     * Retorno esperado � H17    (C�lculo validado na calculadora cientifica do Windows)
     * Entra com valor 1 em Hexadecimal  (Aqui � diferente da calculadora do Windows, pois nesta Calculadora o valor � acumulado, com isso, 
     *                                    � adicionado o valor 1 no final da String, enquanto que na calculadora do Windows � substitu�do por 1
     *                                    obs: Para funcionar como a calculadora do Windows, basta utilizar o m�todo limpa())
     * Retorno esperado � H171
     * Muda a base para Decimal
     * Retorno esperado � 369    (C�lculo validado na calculadora cientifica do Windows)
     **/
     public void testEntraHexaBinarioDecimal() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
        assertEquals("11", calculadora.entraUm());
        calculadora.modoBin();
        assertEquals("0b10111", calculadora.entraUm());        
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.modoDec();
    }
  
    /** 
     * Entra com valor 1 em Hexadecimal
     * Retorno esperado � H1.
     * Entra com mais um valor 1 em Hexadecimal
     * Retorno esperado � H11.
     * Realiza a soma do valor (11) em Hexadecimal
     * Retorno esperado ser� o valor igual a 12 em Hexadecimal.    (C�lculo validado na calculadora cientifica do Windows)
     **/
    public void testEntraSomaHexa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
        assertEquals("0x11", calculadora.entraUm());
        assertEquals("0x11", calculadora.comandoSoma());
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm()); 
        assertEquals("0x12", calculadora.comandoSoma());
    }
  
    /** 
     * Entra com valor 1 em Decimal
     * Retorno esperado � D1.
     * Entra com mais um valor 1  Decimal
     * Retorno esperado � D11.
     * Realiza a soma do valor (11) em Decimal
     * Retorno esperado ser� o valor do  11.
     * Entra com 1 em Decimal
     * Retorno esperado � D1.
     * 
     * Realiza a soma 
     * Retorno esperado igual a 12 em Decimal.
     **/
    public void testEntraSomaDecimal() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
        assertEquals("11", calculadora.entraUm());
        assertEquals("11", calculadora.comandoSoma());
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm()); 
        assertEquals("12", calculadora.comandoSoma());
    }    
  
    /** 
     * Entra com valor 1 em Bin�rio
     * Retorno esperado � B1.
     * Entra com mais um valor 1 em Bin�rio
     * Retorno esperado � B11.
     * Realiza a soma do valor (11) em Bin�rio
     * Retorno esperado igual a 11 em Bin�rio.
     * Entra com 1 em Bin�rio
     * Retorno esperado � B1.
     * Realiza a soma 
     * Retorno esperado � igual 100 em Bin�rio. (C�lculo validado na calculadora cientifica do Windows)
     **/
    public void testEntraSomaBinario() {
        Calculadora calculadora = new Calculadora();    
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
        assertEquals("0b11", calculadora.entraUm());
        assertEquals("0b11", calculadora.comandoSoma());
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm()); 
        assertEquals("0b100", calculadora.comandoSoma());
    }      
 
    /** 
     * ******* Bin�rio **************
     * Entra com valor 1 em Bin�rio
     * Retorno esperado � B1.
     * Entra com mais um valor 1 em Bin�rio
     * Retorno esperado � B11.
     * Realiza a soma do valor (11) em Bin�rio
     * Retorno esperado igual a 11.
     * Entra com 1 em Bin�rio
     * Retorno esperado � B1.
     * Realiza a soma dos valores em bin�rio
     * Retorno esperado � igual 100. (C�lculo validado na calculadora cientifica do Windows)
     * ********** Hexadecimal *************
     * Entra com valor 1 em Hexadecimal
     * Retorno esperado � igual H1
     * Entra com outro valor 1 em Hexadecimal
     * Retorno esperador � igual H11
     * Realiza soma do valor em Bin�rio (100) com valor em Hexadecimal (11)
     * Retorno esperador � igual � 15 (C�lculo validado na calculadora cientifica do Windows)
     * ********* Decimal *************
     * Muda a base para Decimal
     * Entra com valor 1 em Decimal
     * Retorno esperado D1
     * Entra com outro valor 1 em Decimal
     * Retorno esperado D11
     * Realiza a soma do valor acumulado (15) em hexadecimal que passado para decimal ficou igual a (21) mais o valor (11) em decimal 
     * Retorno esperado � igual a 32 (C�lculo validado na calculadora cientifica do Windows)
     **/
    public void testEntraSomaHexaDecimalBinario() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
        assertEquals("0b11", calculadora.entraUm());
        assertEquals("0b11", calculadora.comandoSoma());
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm()); 
        assertEquals("0b100", calculadora.comandoSoma());
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
        assertEquals("0x11", calculadora.entraUm());
        assertEquals("0x15", calculadora.comandoSoma());
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
        assertEquals("11", calculadora.entraUm());
        assertEquals("32", calculadora.comandoSoma());       
    }        
  
    /** 
     * Testes Para N�meros Complexos
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
        a.modoBin();
        assertEquals("0b1I0b1", a.entraUm());
    }  
    
    public void testEntraIHexa() {
        Calculadora a = new Calculadora();
        a.entraUm();
        a.entraI();
        a.modoHex();
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
        b.modoBin();
        b.entraUm();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraUm();
        assertEquals("0b10I0b1", b.comandoSoma());
    }

    public void testEntraISomaIBinario() {
        Calculadora b = new foxtrot.Calculadora();
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
        Calculadora b = new foxtrot.Calculadora();
        b.modoBin();
        b.entraI();
        b.entraUm();
        b.comandoSoma();
        b.entraI();
        b.entraUm();
        assertEquals("0b0I0b10", b.comandoSoma());
    }

    public void testEntraISomaHexa() {
        Calculadora b = new foxtrot.Calculadora();
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
        Calculadora b = new foxtrot.Calculadora();
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
        Calculadora b = new foxtrot.Calculadora();
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
     * Trabalho 4: Casos de testes para n�meros com nota��o cient�fica.
     * Testes de Entrada: REAL, IMAGIN�RIO, COMPLEXO.
     * Testes de Soma:    REAL+REAL, REAL+IMAGIN�RIO, IMAGIN�RIO+IMAGIN�RIO,
     *                    REAL+COMPLEXO, IMAGIN�RIO+COMPLEXO, COMPLEXO+COMPLEXO.
     */     
    
    /**
     * Teste de Entrada: REAL
     */
    public void testEntraD11ND1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        assertEquals("11N1", calculadora.entraUm());
    }
    
    /**
     * Teste de Entrada: IMAGIN�RIO
     */
    public void testEntraID11NB1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraN();
        calculadora.modoBin();
        assertEquals("0b0I0b1011N0b1", calculadora.entraUm());
    }
    
    /**
     * Teste de Entrada: COMPLEXO
     */
    public void testEntraB1ND1ID1B1NH1() {
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
        assertEquals("0x1N0x1I0x3N0x1", calculadora.entraUm());
    }
    
    /**
     * Teste de Soma: REAL+REAL
     */
    public void testSomaD11ND1eD11ND1() {
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
     * Teste de Soma: REAL+IMAGIN�RIO
     */
    public void testSomaD11ND1eID1NB1() {
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
        assertEquals("0b1011N0b1I0b1N0b1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: IMAGIN�RIO+IMAGIN�RIO
     */
    public void testSomaID1NB1eID1NH1() {
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
        assertEquals("0x0I0x2N0x1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: REAL+COMPLEXO
     */
    public void testSomaH1NH1eB1EB1ID1ND1() {
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
     * Teste de Soma: IMAGIN�RIO+COMPLEXO
     */
    public void testSomaID11ND1eH1NH1IB1NB1() {
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
        assertEquals("0b1N0b1I0b1100N0b1", calculadora.comandoSoma());
    }
    
    /**
     * Teste de Soma: COMPLEXO+COMPLEXO
     */
    public void testSomaH1NH1ID1ND1eB1NB1IH1NH1() {
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
        assertEquals("0x2N0x1I0x2N0x1", calculadora.comandoSoma());
    }
    
    /**
     * EXTRA: Teste de Soma: COMPLEXO+COMPLEXO
     */
    public void testSomaD1ND1ID11ND1eD11ND1ID11ND1() {
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
        assertEquals("0b1N0b11", calculadora.comandoSoma());
    }

	public void testTestSoma1V1e1()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.entraUm();
		calculad2.entraV();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();
		assertEquals("2V2", calculad2.comandoSoma());
	}

	public void testTestSoma1V1e1V1()
	{
		foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
		calculad2.entraUm();
		calculad2.entraV();
		calculad2.entraUm();
		assertEquals("1V1", calculad2.comandoSoma());
		calculad2.entraUm();
		calculad2.entraV();
		calculad2.entraUm();
		assertEquals("2V2", calculad2.comandoSoma());
	}
}


