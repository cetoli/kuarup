package foxtrot;


/**
 * Descrição:
 * Design Pattern State - Estado Decimal
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferrão
 * 
 * Versão 2     Data 07/04/2009
 */
public class Decimal implements State
{
    public String entraUm(Calculadora calc) {
      Integer operador = calc.getOperador();
      operador *= 10;
      operador++;
      calc.setOperador(operador);
      return operador.toString();
    }
    
    public String limpa(Calculadora calc) {
      calc.setAcumulador(0);
      calc.setOperador(0);
      return "0";
    }
    
    public String comandoSoma(Calculadora calc) {
      Integer acumulador = calc.getAcumulador();
      Integer operador = calc.getOperador();
      acumulador += operador ;
      operador = 0;
      calc.setOperador(operador);
      calc.setAcumulador(acumulador);
      return acumulador.toString();
    }
}
