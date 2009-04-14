package hotel;

/**
 * Write a description of class BaseBinaria here.
 * 
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (10/04/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class BaseBinaria implements BaseState
{

    public String converterParaDecimal(Integer valor){
        Integer novoValor = Integer.parseInt(valor.toString(),2);
        return novoValor.toString();
    }
    
    public String converterParaBinario(Integer valor){
        return valor.toString();
    }
    
    public String converterParaHexadecimal(Integer valor){
        String novoValor = this.converterParaDecimal(valor);
        return Integer.toHexString(valor);
    }

    public String entraUm(Calculadora calculadora){
        Integer operador = calculadora.getOperador();
        Integer novoOperador = Integer.parseInt(Integer.toBinaryString(operador) + "1");
        calculadora.setOperador(new Integer(this.converterParaDecimal(novoOperador)));
        return "0b" + novoOperador;
    }

    public String comandoSoma(Calculadora calculadora){        
        
        Integer acumulador = calculadora.getAcumulador();
        Integer operador = calculadora.getOperador();
        
        Integer novoAcumulador = new Integer(Integer.toBinaryString(acumulador + operador));
        calculadora.setAcumulador(new Integer(this.converterParaDecimal(novoAcumulador)));
        calculadora.setOperador(0);
        return "0b" + novoAcumulador;
    }
    
    public String limpa(Calculadora calculadora){
        calculadora.setOperador(0);
        calculadora.setAcumulador(0);
        return "0b0";
    }
}
