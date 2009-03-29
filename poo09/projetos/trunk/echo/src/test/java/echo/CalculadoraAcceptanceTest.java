/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;
import labase.poo.CalculadoraFactory;
import labase.poo.ICalculadora;
import junit.framework.Test;
import junit.framework.TestSuite;
/**
 * Classe que testa o funcionamento da calculadora.
 *
 * @author Carlo
 * @version 1.0
 * @since 1.0 (07/04/2008):
 * */
class CalcFactory  extends CalculadoraFactory{
  public CalcFactory(){
    installFactory(this);
  }

  /**
   * Cria instancia
   */
  public ICalculadora createCalculadora() {
    return new Calculadora();
  }
}

public class CalculadoraAcceptanceTest extends junit.framework.TestCase{
    
    public static Test suite() {
      new CalcFactory();
      TestSuite suite= new TestSuite(CalculadoraTest.class);
      suite.addTest(labase.poo.CalculadoraTest.suite());
      return suite;
    }
}
