package alpha;



/**
 * The test class NumeroDecimalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumeroDecimalTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class NumeroDecimalTest
     */
    public NumeroDecimalTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    public void testConverte1EmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroDecimal numDec = new alpha.NumeroDecimal();
        numDec.entraUm();
        assertEquals(new Integer(1), numDec.converteEmNumeroDecimal());
    }
    
    public void testConverte11EmNumeroDecimalAPartirDoRepouso()
    {
        alpha.NumeroDecimal numDec = new alpha.NumeroDecimal();
        numDec.entraUm();
        numDec.entraUm();
        assertEquals(new Integer(11), numDec.converteEmNumeroDecimal());
    }
}


/*
public Integer converteEmNumeroDecimal(){
        return null;
    }
    
    public INumero converterParaBase(Integer num){
        NumeroDecimal dec = new NumeroDecimal();
        dec.setRepNum(num.toString());
        
        return dec;
    }
    
    public String mostraNumeroNaMinhaRepresentacaoBase(){
        return null;
    }*/

