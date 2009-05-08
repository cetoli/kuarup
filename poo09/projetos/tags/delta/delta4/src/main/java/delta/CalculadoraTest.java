package delta;

/**
 * The test class CalculadoraTest.
 *
 * @author  Andre Sion - Pirata
 * @author  Tiago Cruz de França
 * @version 4.0
 */
public class CalculadoraTest extends junit.framework.TestCase {

    /**
     * Default constructor for test class CalculadoraTeste.
     */
    public CalculadoraTest() {
    }

    /**
     * Teste do metodo limpa().
     */
    public final void testLimpa() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do metodo entraUm()
     * Validacao do metodo testEntraUmaVez() utilizando apenas uma chamada do
     * metodo entraUm().
     */
    public final void testEntraUmUmaVez() {
        Calculadora calculadora = new Calculadora();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Teste do metodo entraUm()
     * Validacao do metodo testEntraDuasVezes() utilizando duas chamadas do
     * metodo entraUm().
     */
    public final void testEntraUmDuasVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("11", calculadora.entraUm());
    }

    /**
     * Teste do metodo entraUm()
     * Validacao do metodo testEntraTresVezes() utilizando tres chamadas do
     * metodo entraUm().
     */
    public final void testEntraUmTresVezes() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraUm();
        assertEquals("111", calculadora.entraUm());
    }

    /**
     * Teste do metodo comandoSoma()
     * Validacao do metodo testSomaSemOperador() utilizando apenas uma chamada
     * do metodo comandoSoma().
     */
    public final void testSomaSemOperador() {
        Calculadora calculadora = new Calculadora();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Teste do metodo comandoSoma()
     * Validacao do metodo testSomaComUmOperador() utilizando apenas uma
     * chamada do metodo entraUm() e uma chamada do metodo comandoSoma().
     */
    public final void testSomaComUmOperador() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        assertEquals("1", calculadora.comandoSoma());
    }

    /**
     * Teste do metodo comandoSoma()
     * Validacao do metodo testSomaComDoisOperadores() utilizando duas chamadas
     * do metodo entraUm() e duas chamadas do metodo comandoSoma().
     */
    public final void testSomaComDoisOperadores() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2", calculadora.comandoSoma());
    }

    /**
     * Teste do metodo comandoSoma()
     * Validacao do metodo testLimpaAposSoma() atraves da chamda do metodo
     * limpa() apos duas chamadas do metodo entraUm() e duas chamadas do metodo
     * comandoSoma().
     */
    public final void testLimpaAposSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.comandoSoma();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Teste do metodo comandoSoma()
     * Validacao do metodo testSomaAposLima() atraves da chamada do metodo
     * comandoSoma() apos duas chamadas do metodo entraUm() e uma chamada do
     * metodo comandoSoma().
     */
    public final void testSomaAposLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.limpa();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Validacao dos metodos testEntraBaseDecLimpa()
     * O objetivo e verificar se o metodo limpa() executara de forma correta
     * apos uma chamada do metodo modoDec().
     */
    public final void testEntraBaseDecLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Validacao dos metodos testEntraBaseBinLimpa()
     * O objetivo e verificar se o metodo limpa() executara de forma correta
     * apos uma chamada do metodo modoBin().
     */
    public final void testEntraBaseBinLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Validacao dos metodos testEntraBaseHexLimpa()
     * O objetivo e verificar se o metodo limpa() executara de forma correta
     * apos uma chamada do metodo modoHex().
     */
    public final void testEntraBaseHexLimpa() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0", calculadora.limpa());
    }

    /**
     * Validacao dos metodos testEntraBaseDecSoma()
     * O objetivo e verificar se o metodo comandoSoma() retornara o valor zero
     * na base especificada apos uma chamada do metodo modoDec().
     */
    public final void testEntraBaseDecSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("0", calculadora.comandoSoma());
    }

    /**
     * Validacao dos metodos testEntraBaseBinSoma()
     * O objetivo e verificar se o metodo comandoSoma() retornara o valor zero
     * na base especificada apos uma chamada do metodo modoBin().
     */
    public final void testEntraBaseBinSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b0", calculadora.comandoSoma());
    }

    /**
     * Validacao dos metodos testEntraBaseHexSoma()
     * O objetivo e verificar se o metodo comandoSoma() retornara o valor zero
     * na base especificada apos uma chamada do metodo modoHex().
     */
    public final void testEntraBaseHexSoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x0", calculadora.comandoSoma());
    }

    /**
     * Validacao dos metodos testEntraBaseDecEntraUm()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraBaseDecEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraBaseXEntraUm()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraBaseBinEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraBaseXEntraUm()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraBaseHexEntraUm() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraOpDecSomaEntraOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraOpDecSomaEntraOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Testa a soma de 1 + 1 binario.
     */
    public final void testSomaB1eB1sai0b10() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("0b10", calculadora.comandoSoma());
    }

    /**
     * Testa a soma de 11 + 11 binario.
     */
    public final void testSomaB11eB11sai0b110() {
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
     * Testa a soma de 111 + 111 binario.
     */
    public final void testSomaB111eB111sai0b1110() {
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
    public final void testSomaH1eH1sai0x2() {
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
    public final void test2SomaH11eH11sai0x22() {
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
    public final void testSomaH1eH111sai0x112() {
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
     * Validacao dos metodos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraOpBinSomaEntraOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraOpBinSomaEntraOpHex() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoHex();
        assertEquals("0x1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraOpHexSomaEntraOpBin() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoBin();
        assertEquals("0b1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXSomaEntraOpBaseY()
     * O objetivo e verificar se as entradas dos operandos nas bases decimal,
     * binaria e hexadecimal estao corretas.
     */
    public final void testEntraOpHexSomaEntraOpDec() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.modoDec();
        assertEquals("1", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo e verificar se a soma entre operandos em diferentes bases
     * estao sendo realizadas de forma correta.
     * Nestes testes, o operando e formado por chamadas ao metodo entraUm()
     * em uma base apenas (decimal, binaria ou hexadecimal).
     */
    public final void testSomaEntreOpDecEOpBin() {
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
     * Validacao dos metodos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo e verificar se a soma entre operandos em diferentes bases
     * estao sendo realizadas de forma correta.
     * Nestes testes o operando a formado por chamadas ao metodo entraUm()
     * em uma base apenas (decimal, binaria ou hexadecimal).
     */
    public final void testSomaEntreOpDecEOpHex() {
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
     * Validacao dos metodos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo e verificar se a soma entre operandos em diferentes bases
     * estao sendo realizadas de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm()
     * em uma base apenas (decimal, binaria ou hexadecimal).
     */
    public final void testSomaEntreOpBinEOpDec() {
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
     * Validacao dos metodos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo e verificar se a soma entre operandos em diferentes bases
     * estao sendo realizadas de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm()
     * em uma base apenas (decimal, binaria ou hexadecimal).
     */
    public final void testSomaEntreOpBinEOpHex() {
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
     * Validacao dos metodos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo e verificar se a soma entre operandos em diferentes bases
     * estao sendo realizadas de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm()
     * em uma base apenas (decimal, binaria ou hexadecimal).
     */
    public final void testSomaEntreOpHexEOpBin() {
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
     * Validacao dos metodos testSomaEntreOpBaseXEOpBaseY()
     * O objetivo e verificar se a soma entre operandos em diferentes bases
     * esteo sendo realizadas de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm()
     * em uma base apenas (decimal, binaria ou hexadecimal).
     */
    public final void testSomaEntreOpHexEOpDec() {
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
     * Validacao dos metodos testEntraOpBaseXEntraOpBaseY()
     * O objetivo e verificar se a formaeeo de um operando, utilizando chamadas
     * entraUm() em diferentes bases, este sendo feita de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testEntraD11B1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoDec();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        assertEquals("0b10111", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXEntraOpBaseY()
     * O objetivo e verificar se a formaeeo de um operando, utilizando chamadas
     * entraUm() em diferentes bases, este sendo feita de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testEntraB11D1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoBin();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoDec();
        assertEquals("31", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXEntraOpBaseY()
     * O objetivo e verificar se a formaeeo de um operando, utilizando chamadas
     * entraUm() em diferentes bases, este sendo feita de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testEntraH11B1() {
        Calculadora calculadora = new Calculadora();
        calculadora.modoHex();
        calculadora.entraUm();
        calculadora.entraUm();
        calculadora.modoBin();
        assertEquals("0b100011", calculadora.entraUm());
    }

    /**
     * Validacao dos metodos testEntraOpBaseXEntraOpBaseY()
     * O objetivo e verificar se a formaeeo de um operando, utilizando chamadas
     * entraUm() em diferentes bases, este sendo feita de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testEntraD11B1H1() {
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
     * Validacao dos metodos testEntraOpBaseXEntraOpBaseY()
     * O objetivo e verificar se a formaeeo de um operando, utilizando chamadas
     * entraUm() em diferentes bases, este sendo feita de forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testEntraH11B1H1() {
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
     * Validacao dos metodos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo e verificar se a soma entre operandos, formados pela
     * combinacao de entraUm() em diferentes bases, este sendo realizada de
     * forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testSomaD11B1eB11D1() {
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
     * Validacao dos metodos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo e verificar se a soma entre operandos, formados pela
     * combinacao de entraUm() em diferentes bases, este sendo realizada de
     * forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testSomaD11B1eH11D1() {
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
     * Validacao dos metodos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo e verificar se a soma entre operandos, formados pela
     * combinacao de entraUm() em diferentes bases, este sendo realizada de
     * forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testSomaD11B1eB11H1() {
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
     * Validacao dos metodos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo e verificar se a soma entre operandos, formados pela
     * combinacao de entraUm() em diferentes bases, este sendo realizada de
     * forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testSomaH11B1eD11H1() {
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
     * Validacao dos metodos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo e verificar se a soma entre operandos, formados pela
     * combinacao de entraUm() em diferentes bases, este sendo realizada de
     * forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testSomaD11B1H1eB11D1H1() {
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
     * Validacao dos metodos testSomaEntreOpBasesDiversasEOpBasesDiversas()
     * O objetivo e verificar se a soma entre operandos, formados pela
     * combinacao de entraUm() em diferentes bases, este sendo realizada de
     * forma correta.
     * Nestes testes o operando e formado por chamadas ao metodo entraUm() em
     * diferentes bases (decimal, binaria ou hexadecimal).
     */
    public final void testSomaB11D1H1eH11B1D1() {
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
     *
     */
    public final void test1I1() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        assertEquals("1I1", calculadora.entraUm());
    }

    /**
     *
     */
    public final void testISoma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraI();
        assertEquals("0I0", calculadora.comandoSoma());
    }

    /**
     *
     */
    public final void test1I1Soma1I1Soma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("2I2", calculadora.comandoSoma());
    }

    /**
     *
     */
    public final void test1I1Soma1Soma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        assertEquals("2I1", calculadora.comandoSoma());
    }

    /**
     *
     */
    public final void test1Soma1I1Soma() {
        Calculadora calculadora = new Calculadora();
        calculadora.entraUm();
        calculadora.comandoSoma();
        calculadora.entraUm();
        calculadora.entraI();
        calculadora.entraUm();
        assertEquals("2I1", calculadora.comandoSoma());
    }

    /**
     *
     */
    public final void testBin11111IDec11SomaHex111IB111Soma() {
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
     *
     */
    public final void testHex11SomaIBin11() {
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
     *
     */
    public final void test11IDec1SomaIDec1Soma() {
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
     *
     */
    public final void testIBin11SomaIHex11Soma() {
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
