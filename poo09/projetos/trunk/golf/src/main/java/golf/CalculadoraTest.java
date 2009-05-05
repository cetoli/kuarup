/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package golf;
/**
 * The test class CalculadoraTest.
 *
 * @author  André Sion
 * @author  Thiago Silva de Souza
 * @version 2.0 07/04/2009 André Sion e Thiago Silva de Souza
 * @since   2.0 Incluídas os testes das funcionalidades: números em bases binárias e
 * hexadecimais.
 * @version 1.0 31/03/2009 André Sion e Thiago Silva de Souza
 * @since   1.0 Incluídos os testes dos métodos limpa(), entraUm() e
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
     * Teste do método limpa().
     */
    public void testeLimpa() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do método entraUm()
     * Validação do método testeEntraUmaVez() utilizando apenas uma chamada do
     * método entraUm().
     */
    public void testeEntraUmUmaVez() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Teste do método entraUm()
     * Validação do método testeEntraDuasVezes() utilizando duas chamadas do
     * método entraUm().
     */
    public void testeEntraUmDuasVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("11", calculadora.entraUm());
    }

    /**
     * Teste do método entraUm()
     * Validação do método testeEntraTresVezes() utilizando três chamadas do
     * método entraUm().
     */
    public void testeEntraUmTresVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("111", calculadora.entraUm());
    }

    /**
     * Teste do método comandoSoma()
     * Validação do método testeSomaSemOperador() utilizando apenas uma chamada
     * do método comandoSoma().
     */
    public void testeSomaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Teste do método comandoSoma()
     * Validação do método testeSomaComUmOperador() utilizando apenas uma
     * chamada do método entraUm() e uma chamada do método comandoSoma().
     */
    public void testeSomaComUmOperador() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("1", calculadora.comandoSoma());
    }

    /**
     * Teste do método comandoSoma()
     * Validação do método testeSomaComDoisOperadores() utilizando duas chamadas
     * do método entraUm() e duas chamadas do método comandoSoma().
     */
    public void testeSomaComDoisOperadores() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2", calculadora.comandoSoma());
    }

    /**
     * Teste do método comandoSoma()
     * Validação do método testeLimpaAposSoma() através da chamda do método
     * limpa() após duas chamadas do método entraUm() e duas chamadas do método
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
     * Teste do método comandoSoma()
     * Validação do método testeSomaAposLima() através da chamada do método
     * comandoSoma() após duas chamadas do método entraUm() e uma chamada do
     * método comandoSoma().
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
     * Validação dos métodos testeEntraBaseXLimpa()
     * O objetivo é verificar se o método limpa() executará de forma correta
     * após uma chamada do método entraBaseX().
     */
    public void testeEntraBaseDecLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Validação dos métodos testeEntraBaseXLimpa()
     * O objetivo é verificar se o método limpa() executará de forma correta
     * após uma chamada do método entraBaseX().
     */
    public void testeEntraBaseBinLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Validação dos métodos testeEntraBaseXLimpa()
     * O objetivo é verificar se o método limpa() executará de forma correta
     * após uma chamada do método entraBaseX().
     */
    public void testeEntraBaseHexLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Validação dos métodos testeEntraBaseXSoma()
     * O objetivo é verificar se o método comandoSoma() retornará o valor zero
     * na base especificada após uma chamada do método entraBaseX().
     */
    public void testeEntraBaseDecSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Validação dos métodos testeEntraBaseXSoma()
     * O objetivo é verificar se o método comandoSoma() retornará o valor zero
     * na base especificada após uma chamada do método entraBaseX().
     */
    public void testeEntraBaseBinSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b0", calculadora.comandoSoma());
    }

    /**
     * Validação dos métodos testeEntraBaseXSoma()
     * O objetivo é verificar se o método comandoSoma() retornará o valor zero
     * na base especificada após uma chamada do método entraBaseX().
     */
    public void testeEntraBaseHexSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x0", calculadora.comandoSoma());
    }

    /**
     * Validação dos métodos testeEntraBaseXEntraUm()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
     */
    public void testeEntraBaseDecEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Validação dos métodos testeEntraBaseXEntraUm()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
     */
    public void testeEntraBaseBinEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Validação dos métodos testeEntraBaseXEntraUm()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
     */
    public void testeEntraBaseHexEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Validação dos métodos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
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
     * Validação dos métodos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
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
     * Testa a soma de 1 + 1 binário.
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
     * Testa a soma de 11 + 11 binário.
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
     * Testa a soma de 111 + 111 binário.
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
     * Validação dos métodos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
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
     * Validação dos métodos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
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
     * Validação dos métodos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
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
     * Validação dos métodos testeEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo é verificar se as entradas dos operandos nas bases decimal,
     * binária e hexadecimal estão corretas.
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
     * Validação dos métodos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo é verificar se a soma entre operandos em diferentes bases
     * estão sendo realizadas de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm()
     * em uma base apenas (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo é verificar se a soma entre operandos em diferentes bases
     * estão sendo realizadas de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm()
     * em uma base apenas (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo é verificar se a soma entre operandos em diferentes bases
     * estão sendo realizadas de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm()
     * em uma base apenas (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo é verificar se a soma entre operandos em diferentes bases
     * estão sendo realizadas de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm()
     * em uma base apenas (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo é verificar se a soma entre operandos em diferentes bases
     * estão sendo realizadas de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm()
     * em uma base apenas (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBaseXEOpBaseY()
     * O objetivo é verificar se a soma entre operandos em diferentes bases
     * estão sendo realizadas de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm()
     * em uma base apenas (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo é verificar se a formação de um operando, utilizando chamadas
     * entraUm() em diferentes bases, está sendo feita de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo é verificar se a formação de um operando, utilizando chamadas
     * entraUm() em diferentes bases, está sendo feita de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo é verificar se a formação de um operando, utilizando chamadas
     * entraUm() em diferentes bases, está sendo feita de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo é verificar se a formação de um operando, utilizando chamadas
     * entraUm() em diferentes bases, está sendo feita de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeEntraOpBaseXEntraOpBaseY()
     * O objetivo é verificar se a formação de um operando, utilizando chamadas
     * entraUm() em diferentes bases, está sendo feita de forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo é verificar se a soma entre operandos, formados pela
     * combinação de entraUm() em diferentes bases, está sendo realizada de
     * forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo é verificar se a soma entre operandos, formados pela
     * combinação de entraUm() em diferentes bases, está sendo realizada de
     * forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo é verificar se a soma entre operandos, formados pela
     * combinação de entraUm() em diferentes bases, está sendo realizada de
     * forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo é verificar se a soma entre operandos, formados pela
     * combinação de entraUm() em diferentes bases, está sendo realizada de
     * forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo é verificar se a soma entre operandos, formados pela
     * combinação de entraUm() em diferentes bases, está sendo realizada de
     * forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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
     * Validação dos métodos testeSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo é verificar se a soma entre operandos, formados pela
     * combinação de entraUm() em diferentes bases, está sendo realizada de
     * forma correta.
     * Nestes testes o operando é formado por chamadas ao método entraUm() em
     * diferentes bases (decimal, binária ou hexadecimal).
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

    /*
     * Teste Engenharia.
     */


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

    	assertEquals("0b1I0b11N0b1",calculad2.comandoSoma());
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

    	assertEquals("0x1N11I0x11N1",calculad2.comandoSoma());
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
