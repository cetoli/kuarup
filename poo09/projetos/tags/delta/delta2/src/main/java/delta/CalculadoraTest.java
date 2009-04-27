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
 * @author  Andr� Sion
 * @author  Thiago Silva de Souza
 * @version 2.0 07/04/2009 Andr� Sion e Thiago Silva de Souza
 * @since   2.0 Inclu�das os testes das funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 * @version 1.0 31/03/2009 Andr� Sion e Thiago Silva de Souza
 * @since   1.0 Inclu�dos os testes dos m�todos limpa(), entraUm() e
 * comandoSoma().
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
    public void testeLimpa() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do m�todo entraUm()
     * Valida��o do m�todo testeEntraUmaVez() utilizando apenas uma chamada do
     * m�todo entraUm().
     */
    public void testeEntraUmUmaVez() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Teste do m�todo entraUm()
     * Valida��o do m�todo testeEntraDuasVezes() utilizando duas chamadas do
     * m�todo entraUm().
     */
    public void testeEntraUmDuasVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("11", calculadora.entraUm());
    }

    /**
     * Teste do m�todo entraUm()
     * Valida��o do m�todo testeEntraTresVezes() utilizando tr�s chamadas do
     * m�todo entraUm().
     */
    public void testeEntraUmTresVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("111", calculadora.entraUm());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testeSomaSemOperador() utilizando apenas uma chamada
     * do m�todo comandoSoma().
     */
    public void testeSomaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testeSomaComUmOperador() utilizando apenas uma
     * chamada do m�todo entraUm() e uma chamada do m�todo comandoSoma().
     */
    public void testeSomaComUmOperador() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("1", calculadora.comandoSoma());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testeSomaComDoisOperadores() utilizando duas chamadas
     * do m�todo entraUm() e duas chamadas do m�todo comandoSoma().
     */
    public void testeSomaComDoisOperadores() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2", calculadora.comandoSoma());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testeLimpaAposSoma() atrav�s da chamda do m�todo
     * limpa() ap�s duas chamadas do m�todo entraUm() e duas chamadas do m�todo
     * comandoSoma().
     */
    public void testeLimpaAposSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do m�todo comandoSoma()
     * Valida��o do m�todo testeSomaAposLima() atrav�s da chamada do m�todo
     * comandoSoma() ap�s duas chamadas do m�todo entraUm() e uma chamada do
     * m�todo comandoSoma().
     */
    public void testeSomaAposLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.limpa();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXLimpa()
     * O objetivo � verificar se o m�todo limpa() executar� de forma correta
     * ap�s uma chamada do m�todo entraBaseX().
     */
    public void testeEntraBaseDecLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXLimpa()
     * O objetivo � verificar se o m�todo limpa() executar� de forma correta
     * ap�s uma chamada do m�todo entraBaseX().
     */
    public void testeEntraBaseBinLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXLimpa()
     * O objetivo � verificar se o m�todo limpa() executar� de forma correta
     * ap�s uma chamada do m�todo entraBaseX().
     */
    public void testeEntraBaseHexLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXSoma()
     * O objetivo � verificar se o m�todo comandoSoma() retornar� o valor zero
     * na base especificada ap�s uma chamada do m�todo entraBaseX().
     */
    public void testeEntraBaseDecSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXSoma()
     * O objetivo � verificar se o m�todo comandoSoma() retornar� o valor zero
     * na base especificada ap�s uma chamada do m�todo entraBaseX().
     */
    public void testeEntraBaseBinSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXSoma()
     * O objetivo � verificar se o m�todo comandoSoma() retornar� o valor zero
     * na base especificada ap�s uma chamada do m�todo entraBaseX().
     */
    public void testeEntraBaseHexSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x0", calculadora.comandoSoma());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXEntraUm()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraBaseDecEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXEntraUm()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraBaseBinEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraBaseXEntraUm()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraBaseHexEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraOpDecSomaEntraOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraOpDecSomaEntraOpHex() {
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
    public void testeSomaB1eB1sai0b10() {
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
    public void testeSomaB11eB11sai0b110() {
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
    public void testeSomaB111eB111sai0b1110() {
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
    public void testeSomaH1eH1sai0x2() {
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
    public void teste2SomaH11eH11sai0x22() {
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
    public void testeSomaH1eH111sai0x112() {
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
     * Valida��o dos m�todos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraOpBinSomaEntraOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraOpBinSomaEntraOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraOpHexSomaEntraOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo � verificar se as entradas dos operandos nas bases decimal,
     * bin�ria e hexadecimal est�o corretas.
     */
    public void testeEntraOpHexSomaEntraOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaEntreOpDecEOpBin() {
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
     * Valida��o dos m�todos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaEntreOpDecEOpHex() {
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
     * Valida��o dos m�todos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaEntreOpBinEOpDec() {
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
     * Valida��o dos m�todos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaEntreOpBinEOpHex() {
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
     * Valida��o dos m�todos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaEntreOpHexEOpBin() {
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
     * Valida��o dos m�todos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo � verificar se a soma entre operandos em diferentes bases
     * est�o sendo realizadas de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm()
     * em uma base apenas (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaEntreOpHexEOpDec() {
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
     * Valida��o dos m�todos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeEntraD11B1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        assertEquals("0b10111", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeEntraB11D1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        assertEquals("31", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeEntraH11B1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        assertEquals("0b100011", calculadora.entraUm());
    }

    /**
     * Valida��o dos m�todos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeEntraD11B1H1() {
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
     * Valida��o dos m�todos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo � verificar se a forma��o de um operando, utilizando chamadas
     * entraUm() em diferentes bases, est� sendo feita de forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeEntraH11B1H1() {
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
     * Valida��o dos m�todos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaD11B1eB11D1() {
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
     * Valida��o dos m�todos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaD11B1eH11D1() {
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
     * Valida��o dos m�todos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaD11B1eB11H1() {
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
     * Valida��o dos m�todos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaH11B1eD11H1() {
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
     * Valida��o dos m�todos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaD11B1H1eB11D1H1() {
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
     * Valida��o dos m�todos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo � verificar se a soma entre operandos, formados pela
     * combina��o de entraUm() em diferentes bases, est� sendo realizada de
     * forma correta.
     * Nestes testes o operando � formado por chamadas ao m�todo entraUm() em
     * diferentes bases (decimal, bin�ria ou hexadecimal).
     */
    public void testeSomaB11D1H1eH11B1D1() {
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
