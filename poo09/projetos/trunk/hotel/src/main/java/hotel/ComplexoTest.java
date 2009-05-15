package hotel;

/**
 * Classe de teste da ValorBin.
 * 
 * @author (Marcos de Castro) $Author$
 * @author (Rodrigo Santos Borges) $Author$
 * @version 1.0
 */
public class ComplexoTest extends junit.framework.TestCase {
    /**
         * Default constructor for test class ValorBinTest.
         */
    public ComplexoTest() {
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
         * Teste da conversão para binário.
         */
    public void testeConverterBin() {
	ValorBin valorBin1 = new ValorBin(12);
	valorBin1.modoBin();
	Complexo c = new Complexo(valorBin1);
	c.adicionarDigito("1", new ImpressaoBinarioStrategy(),
		new ImpressaoPadraoStrategy());
	assertEquals("0b1100I1", c.converterEmString());
    }

}
