package delta;

/**
 * The test class CalculadoraTest.
 *
 * @author  Andre Sion - Pirata
 * @author  Tiago Cruz de França
 * @version 4.0
 */
public class CalculadoraTest2 extends junit.framework.TestCase {

    /**
     * Default constructor for test class CalculadoraTeste.
     */
    public CalculadoraTest2() {
    }

    /**
     *   Teste: entrar com o número D1N1IB11 (1e1+0b11i) -> 0b1N1I0b11
     */
	public void testeEntraD1N1IB11sai0b1N1I0b11()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.entraN();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.modoBin();
		calculad1.entraUm();
		assertEquals("0b1N1I0b11", calculad1.entraUm());
	}

    /**
     * Teste: entrar com o número D1IB11N1 (1+0b11e1) -> 0b1I0b11N1
     */
	public void testeEntraD1IB11N1sai0b1I0b11N1()
	{
		delta.Calculadora calculad1 = new delta.Calculadora();
		calculad1.entraUm();
		calculad1.entraI();
		calculad1.modoBin();
		calculad1.entraUm();
		calculad1.entraUm();
		calculad1.entraN();
		assertEquals("0b1I0b11N1", calculad1.entraUm());
	}

    /**
     *  Teste: entrar com o número D1N11IH11N1 (1e11+ 0x11e1i) -> 0x1N11I0x11N1
     */
    public void testeEntraD1N11IH11N1sai0x1NBI0x11N1() 
    {
        delta.Calculadora calculad1 = new delta.Calculadora();
        calculad1.entraUm();
        calculad1.entraN();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraI();
        calculad1.entraH();
        calculad1.entraUm();
        calculad1.entraUm();
        calculad1.entraN();
        assertEquals("0x1NBI0x11N1", calculad1.entraUm());   
    }
    
    /**
     *  Teste: Somar 11N1 mais 1N11 (11e1 + 1e11) -> 1N11
     */
    public void testeSoma11N1mais1N11sai1N11() 
    {
        delta.Calculadora calculad1 = new delta.Calculadora();
        calculad1.entraUm();
        calculad1.entraUm();    
        calculad1.entraN();
        calculad1.entraUm();
        calculad1.soma();
        calculad1.entraUm();
        calculad1.entraN();
        calculad1.entraUm();
        assertEquals("1N11", calculad1.entraUm());
    }

}