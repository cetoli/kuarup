package golf.num;


/**
 * Suporta operacoes com expoentes de engenharia.
 *
 * @author Gustavo Taveira
 * @version 4.0
 */
public class Exponent extends ComponentNum{

    /**
     * Metodo que responsavel por retornar o prefixo do componente
     * @result String
     */
    public String getPrefix() {
        return "N";
    }

    /**
     * Metodo responsavel por escrever o numero corretamente
     * @result String
     */
    public String writeNum() {
        return getPrefix() + base.toBase(valor);
    }
}