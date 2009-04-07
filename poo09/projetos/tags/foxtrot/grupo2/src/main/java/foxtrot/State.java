package foxtrot;



/**
 * Descri��o:
 * Design Pattern State
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferr�o
 * 
 * Vers�o 2     Data 07/04/2009
 */
public interface State
{
    public String entraUm(Calculadora calc);
    public String limpa(Calculadora calc);
    public String comandoSoma(Calculadora calc);
}
