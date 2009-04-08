package foxtrot;


/**
 * Descrição:
 * Design Pattern State - Estado Binário
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferrão
 * 
 * Versão 2     Data 07/04/2009
 */
public class Binario implements State
{
    public String entraUm(Calculadora calc) {
      Integer operador = calc.getOperador();
      String operadorBin = Integer.toBinaryString(operador.intValue());
      operadorBin += "1";
      operador = Integer.parseInt(operadorBin, 2);
      calc.setOperador(operador);
      return "bx" + Integer.toBinaryString(operador.intValue());
    }
    
    public String limpa(Calculadora calc) {
      calc.setAcumulador(0);
      calc.setOperador(0);
      return "bx0";
    }
    
    public String comandoSoma(Calculadora calc) {
      Integer acumulador = calc.getAcumulador();
      Integer operador = calc.getOperador();
      acumulador += operador ;
      operador = 0;
      calc.setAcumulador(acumulador);
      calc.setOperador(operador);      
      return "bx" + Integer.toBinaryString(acumulador.intValue());
    }
}
