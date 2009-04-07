package foxtrot;


/**
 * Descrição:
 * Design Pattern State - Estado Hexadecimal
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferrão
 * 
 * Versão 2     Data 07/04/2009
 */
public class Hexadecimal implements State
{
    public String entraUm(Calculadora calc) {
      Integer operador = calc.getOperador();
      String hexadecimal = Integer.toHexString(operador);
      hexadecimal += "1";
      operador = Integer.parseInt(hexadecimal, 16);
      calc.setOperador(operador);
      return "0x" + Integer.toHexString(operador);
    }
    
    public String limpa(Calculadora calc) {
      calc.setAcumulador(0);
      calc.setOperador(0);
      return "0x0";
    }
    
    public String comandoSoma(Calculadora calc) {
      Integer acumulador = calc.getAcumulador();
      Integer operador = calc.getOperador();
      acumulador += operador ;
      operador = 0;
      calc.setAcumulador(acumulador);
      calc.setOperador(operador);
      return "0x" + Integer.toHexString(acumulador);
    }
}
