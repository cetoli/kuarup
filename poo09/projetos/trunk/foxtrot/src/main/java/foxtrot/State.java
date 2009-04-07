package foxtrot;



/**
 * Descrição:
 * Design Pattern State
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferrão
 * 
 * Versão 2     Data 07/04/2009
 */
public interface State
{
    public String entraUm(Calculadora calc);
    public String limpa(Calculadora calc);
    public String comandoSoma(Calculadora calc);
}
