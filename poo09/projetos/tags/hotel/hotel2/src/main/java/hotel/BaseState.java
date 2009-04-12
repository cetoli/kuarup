package hotel;

/**
 * Write a description of interface BaseState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface BaseState
{
    String entraUm(Calculadora calc);
    String comandoSoma(Calculadora calc);
    String limpa(Calculadora calc);
    //void converterValores(Calculadora calc);
    String converterParaDecimal(Integer valor);
    String converterParaBinario(Integer valor);
    String converterParaHexadecimal(Integer valor);
}
