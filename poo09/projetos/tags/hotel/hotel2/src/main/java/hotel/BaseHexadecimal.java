package hotel;
/**
 * Write a description of class BaseHexadecimal here.
 * 
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (10/04/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class BaseHexadecimal implements BaseState
{

    public String converterParaDecimal(Integer valor){
        Integer novoValor = Integer.parseInt(valor.toString(),10);
        return novoValor.toString();
    }
    
    public String converterParaBinario(Integer valor){
        String novoValor = this.converterParaDecimal(valor);
        return Integer.toBinaryString(new Integer(novoValor));
    }
    
    public String converterParaHexadecimal(Integer valor){
        return valor.toString();
    }

    public String entraUm(Calculadora calculadora){
        Integer operador = calculadora.getOperador();
        Integer novoOperador = Integer.parseInt(Integer.toHexString(operador) + "1", 16);
        calculadora.setOperador(new Integer(this.converterParaDecimal(novoOperador)));
        return "0x" + Integer.toHexString(novoOperador);
    }

    public String comandoSoma(Calculadora calculadora){
        
        Integer acumulador = calculadora.getAcumulador();
        Integer operador = calculadora.getOperador();
        
        Integer novoAcumulador = Integer.parseInt(Integer.toHexString(acumulador + operador), 16);
        calculadora.setAcumulador(novoAcumulador);
        calculadora.setOperador(0);
        return "0x" + Integer.toHexString(novoAcumulador);
    }
    
    public String limpa(Calculadora calculadora){
        calculadora.setOperador(0);
        calculadora.setAcumulador(0);
        return "0x0";
    }
}
