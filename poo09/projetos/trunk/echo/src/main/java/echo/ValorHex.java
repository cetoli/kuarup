package echo;


/**
 * Classe que é um parser do valor em hexadecimal.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class ValorHex extends Valor
{
    /**
     * Construtor que armazena um valor decimal.
     * 
     * @param novo valor em decimal a ser armazenado.
     */
    public ValorHex(int novo) {
        super(novo);
    }

    /**
     * Converte o valor de hexadecimal para decimal.
     * 
     * @param  str Valor em hexadecimal.
     * 
     * @return valor em decimal.
     */
    private int converterHex (String str) {
        return Integer.parseInt(str, 16);
    }

    /**
    * Converte para decimal e armazena o valor passado.
    * 
    * @param novo valor em hexadecimal.
    */
    public void setValor(String novo) {
        valor = converterHex (novo);
    }
    
    /**
     * Converte o valor armazenado em String hexadecimal.
     * 
     * @return String hexadecimal.
     */
    public String converterEmString() {
        return Integer.toHexString(valor);
    }
    
    /**
     * Adiciona um novo dígito a direita do valor armazenado.
     * 
     * @param digito String com o valor do dígito a ser inserido.
     * 
     * @return valor atualizado do objeto.
     */
    public String adicionarDigito (String digito) {
        String str = converterEmString () + digito;

        valor = converterHex (str);

        return converterEmString ();
    }
}
