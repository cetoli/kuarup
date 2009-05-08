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
}



