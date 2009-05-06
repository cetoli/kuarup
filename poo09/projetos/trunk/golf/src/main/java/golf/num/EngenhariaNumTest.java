package golf.num;



/**
 * The test class EngenhariaNumTest.
 *
 * @author  Gustavo Taveira
 * @version 4.0
 */
public class EngenhariaNumTest extends junit.framework.TestCase{
    /**
     * Default constructor for test class EngenhariaNumTest
     */
    public EngenhariaNumTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown(){
    }

    /**
     * Testa se entra 1N1 e sai 1N1.
     */
	public void testEntra1N1(){
		golf.num.EngenhariaNum engenhar1 = new golf.num.EngenhariaNum();
		golf.num.Real real1 = new golf.num.Real();
		engenhar1.addComponent(real1);
		engenhar1.entraUm();
		golf.num.Exponent exponent1 = new golf.num.Exponent();
		engenhar1.addComponent(exponent1);
		engenhar1.entraUm();
		assertEquals("1N1", engenhar1.writeNum());
	}

    /**
     * Testa se entra 11N11B e sai 0b1011N1011.
     */
	public void testEntra11N11eMostraBin(){
		golf.num.EngenhariaNum engenhar1 = new golf.num.EngenhariaNum();
		golf.num.Real real1 = new golf.num.Real();
		engenhar1.addComponent(real1);
		engenhar1.entraUm();
		engenhar1.entraUm();
		golf.num.Exponent exp1 = new golf.num.Exponent();
		engenhar1.addComponent(exp1);
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.modoBin();
		assertEquals("0b1011N1011", engenhar1.writeNum());
	}

    /**
     * Testa se entra 111N111H e sai 0x6fN6f.
     */
	public void testEntra111N111eMostraHex(){
		golf.num.EngenhariaNum engenhar1 = new golf.num.EngenhariaNum();
		golf.num.Real real1 = new golf.num.Real();
		engenhar1.addComponent(real1);
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.entraUm();
		golf.num.Exponent exp1 = new golf.num.Exponent();
		engenhar1.addComponent(exp1);
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.modoHex();
		assertEquals("0x6fN6f", engenhar1.writeNum());
	}

    /**
     * Testa se entra 1I1N1 e sai 1I1N1.
     */
	public void testEntra1I1N1(){
		golf.num.EngenhariaNum engenhar1 = new golf.num.EngenhariaNum();
		golf.num.ComplexNum complex1 = new golf.num.ComplexNum();
		golf.num.Real real1 = new golf.num.Real();
		complex1.addComponent(real1);
		complex1.entraUm();
		golf.num.Imaginario imag1 = new golf.num.Imaginario();
		complex1.addComponent(imag1);
		complex1.entraUm();
		engenhar1.addComponent(complex1);
		golf.num.Exponent exp1 = new golf.num.Exponent();
		engenhar1.addComponent(exp1);
		engenhar1.entraUm();
		assertEquals("1I1N1", engenhar1.writeNum());
	}

    /**
     * Testa se entra 11I11N11B e sai 0b1011I0b1011N1011.
     */
	public void testEntra11I11N11eMostraBin(){
		golf.num.EngenhariaNum engenhar1 = new golf.num.EngenhariaNum();
		golf.num.ComplexNum complex1 = new golf.num.ComplexNum();
		golf.num.Real real1 = new golf.num.Real();
		complex1.addComponent(real1);
		complex1.entraUm();
		complex1.entraUm();
		golf.num.Imaginario imag1 = new golf.num.Imaginario();
		complex1.addComponent(imag1);
		complex1.entraUm();
		complex1.entraUm();
		engenhar1.addComponent(complex1);
		golf.num.Exponent exp1 = new golf.num.Exponent();
		engenhar1.addComponent(exp1);
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.modoBin();
		assertEquals("0b1011I0b1011N1011", engenhar1.writeNum());
	}

    /**
     * Testa se entra 111I111N111H e sai 0x6fI0x6fN6f.
     */
	public void testEntra111I111N111eMostraHex(){
		golf.num.EngenhariaNum engenhar1 = new golf.num.EngenhariaNum();
		golf.num.ComplexNum complex1 = new golf.num.ComplexNum();
		golf.num.Real real1 = new golf.num.Real();
		complex1.addComponent(real1);
		complex1.entraUm();
		complex1.entraUm();
		complex1.entraUm();
		golf.num.Imaginario imag1 = new golf.num.Imaginario();
		complex1.addComponent(imag1);
		complex1.entraUm();
		complex1.entraUm();
		complex1.entraUm();
		engenhar1.addComponent(complex1);
		golf.num.Exponent exp1 = new golf.num.Exponent();
		engenhar1.addComponent(exp1);
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.entraUm();
		engenhar1.modoHex();
		assertEquals("0x6fI0x6fN6f", engenhar1.writeNum());
	}
}






