package hotel;

/**
 * Write a description of class BaseDecimal here.
 * 
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (10/04/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class BaseDecimal implements BaseState
{

    public String converterParaDecimal(Integer valor){
        return valor.toString();
    }
    
    public String converterParaBinario(Integer valor){
        return Integer.toBinaryString(valor);
    }
    
    public String converterParaHexadecimal(Integer valor){
        return Integer.toHexString(valor);
    }

    public String entraUm(Calculadora calculadora){
        Integer novoOperador = new Integer(calculadora.getOperador().toString() + "1");
        calculadora.setOperador(novoOperador);
        return novoOperador.toString();
    }

    public String comandoSoma(Calculadora calculadora){
        Integer novoAcumulador = calculadora.getAcumulador() + calculadora.getOperador();
        calculadora.setAcumulador(novoAcumulador);
        calculadora.setOperador(0);
        return novoAcumulador.toString();
    }
    
    public String limpa(Calculadora calculadora){
        calculadora.setOperador(0);
        calculadora.setAcumulador(0);
        return "0";
    }
    
}
