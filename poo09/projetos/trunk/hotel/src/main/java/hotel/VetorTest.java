package hotel;

public class VetorTest extends junit.framework.TestCase {
    /**
         * Default constructor for test class VetorTest.
         */
    public VetorTest() {

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

    public void testeVetorDecimal() {
	Valor valor = new Valor(10);
	Vetor v = new Vetor(valor);

	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();
	v.adicionarDigito("1", impressao, impressao);

	assertEquals("10V1", v.converterEmString());
    }

    public void testeVetorEngenhariaDecimal() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	Valor valor = new Valor(10);
	Engenharia e = new Engenharia(valor);
	e.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(e);

	v.adicionarDigito("1", impressao, impressao);

	assertEquals("10N1V1", v.converterEmString());
    }

    public void testeVetorComplexoDecimal() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	Valor valor = new Valor(10);
	Complexo c = new Complexo(valor);
	c.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(c);

	v.adicionarDigito("1", impressao, impressao);

	assertEquals("10I1V1", v.converterEmString());
    }
}
