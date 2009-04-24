/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package delta;
/**
 * The test class CalculadoraTest.
 *
 * @author  Thiago Silva de Souza
 * @author  Andre Sion
 * @version 1.0 (Testes iniciais da calculadora)
 */
public class CalculadoraTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CalculadoraTeste.
     */
    public CalculadoraTest() {
    }

    /**
     * Teste do m�todo limpa().
     */
    public void testLimpa() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do m�todo entraUm()
     * Valida��o do m�todo testEntraUmaVez() utilizando apenas uma chamada do
     * m�todo entraUm().
     */
    public void testEntraUmUmaVez() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Teste do m�todo entraUm()
     * Valida��o do m�todo testEntraDuasVezes() utilizando duas chamadas do
     * m�todo entraUm().
     */
    public void testEntraUmDuasVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("11", calculadora.entraUm());
    }

    /**
     * Teste do m�todo entraUm()
     * Valida��o do m�todo testEntraTresVezes() utilizando tr�s chamadas do
     * m�todo entraUm().
     */
    public void testEntraUmTresVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("111", calculadora.entraUm());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testSomaSemOperador() utilizando apenas uma chamada
     * do m�todo comandoSoma().
     */
    public void testSomaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testSomaComUmOperador() utilizando apenas uma
     * chamada do m�todo entraUm() e uma chamada do m�todo comandoSoma().
     */
    public void testSomaComUmOperador() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("1", calculadora.comandoSoma());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testSomaComDoisOperadores() utilizando duas chamadas
     * do m�todo entraUm() e duas chamadas do m�todo comandoSoma().
     */
    public void testSomaComDoisOperadores() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2", calculadora.comandoSoma());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testLimpaAposSoma() atrav�s da chamda do m�todo
     * limpa() ap�s duas chamadas do m�todo entraUm() e duas chamadas do m�todo
     * comandoSoma().
     */
    public void testLimpaAposSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testSomaAposLima() atrav�s da chamada do m�todo
     * comandoSoma() ap�s duas chamadas do m�todo entraUm() e uma chamada do
     * m�todo comandoSoma().
     */
    public void testSomaAposLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.limpa();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXLimpa()
     * O objetivo � verificar se o m�todo limpa() executar� de forma correta
     * ap�s uma chamada do m�todo entraBaseX().
     */
    public void testEntraBaseDecLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXLimpa()
     * O objetivo � verificar se o m�todo limpa() executar� de forma correta
     * ap�s uma chamada do m�todo entraBaseX().
     */
    public void testEntraBaseBinLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXLimpa()
     * O objetivo � verificar se o m�todo limpa() executar� de forma correta
     * ap�s uma chamada do m�todo entraBaseX().
     */
    public void testEntraBaseHexLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXSoma()
     * O objetivo � verificar se o m�todo comandoSoma() retornar� o valor zero
     * na base especificada ap�s uma chamada do m�todo entraBaseX().
     */
    public void testEntraBaseDecSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXSoma()
     * O objetivo � verificar se o m�todo comandoSoma() retornar� o valor zero
     * na base especificada ap�s uma chamada do m�todo entraBaseX().
     */
    public void testEntraBaseBinSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXSoma()
     * O objetivo � verificar se o m�todo comandoSoma() retornar� o valor zero
     * na base especificada ap�s uma chamada do m�todo entraBaseX().
     */
    public void testEntraBaseHexSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXEntraUm()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraBaseDecEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXEntraUm()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraBaseBinEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraBaseXEntraUm()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraBaseHexEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraOpDecSomaEntraOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraOpDecSomaEntraOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

     /**
     * Testa a soma de 1 + 1 bin�rio.
     */
    public void testSomaB1eB1sai0b10() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("0b10", calculadora.comandoSoma());
    }
    
     /**
     * Testa a soma de 11 + 11 bin�rio.
     */
    public void testSomaB11eB11sai0b110() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b110", calculadora.comandoSoma());
    }
    
     /**
     * Testa a soma de 111 + 111 bin�rio.
     */
    public void testSomaB111eB111sai0b1110() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0b1110", calculadora.comandoSoma());
    }
    
     /**
     * Testa a soma de 1 + 1 hexadecimal.
     */
    public void testSomaH1eH1sai0x2() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("0x2", calculadora.comandoSoma());
    }
    
     /**
     * Testa a soma de 11 + 11 hexadecimal.
     */
    public void test2SomaH11eH11sai0x22() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0x22", calculadora.comandoSoma());
    }
    
     /**
     * Testa a soma de 1 + 111 hexadecimal.
     */
    public void testSomaH1eH111sai0x112() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("0x112", calculadora.comandoSoma());
    }
    
    
    /**
     * Valida��o dos m�todos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraOpBinSomaEntraOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraOpBinSomaEntraOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraOpHexSomaEntraOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testEntraOpHexSomaEntraOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes, o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaEntreOpDecEOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b1100", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaEntreOpDecEOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0xc", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaEntreOpBinEOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("4", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaEntreOpBinEOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x4", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaEntreOpHexEOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        assertEquals("0b10010", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaEntreOpHexEOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("18", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testEntraD11B1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        assertEquals("0b10111", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testEntraB11D1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        assertEquals("31", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testEntraH11B1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        assertEquals("0b100011", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testEntraD11B1H1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.modoHex();
        assertEquals("0x171", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testEntraH11B1H1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.modoHex();
        assertEquals("0x231", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaD11B1eB11D1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("54", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaD11B1eH11D1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("194", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaD11B1eB11H1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x48", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaH11B1eD11H1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0xd4", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaD11B1H1eB11D1H1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.modoHex();
        calculadora.entraUm();
        assertEquals("0x362", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testSomaB11D1H1eH11B1D1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.modoDec();
        calculadora.entraUm();
        assertEquals("848", calculadora.comandoSoma());
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp() {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown() {
    }
}
