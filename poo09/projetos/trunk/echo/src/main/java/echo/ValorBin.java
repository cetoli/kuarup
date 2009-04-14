package echo;


/**
 * Classe que é um parser do valor em binário.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class ValorBin extends Valor
{
  private final int BASE= 2;

    /**
     * Construtor que armazena um valor decimal.
     * 
     * @param novo valor em decimal a ser armazenado.
     */
    public ValorBin(int novo) {
       super(novo);
    }

    /**
     * Converte o valor de binário para decimal.
     * 
     * @param  str Valor em binário.
     * 
     * @return valor em decimal.
     */
    private int converterBin (String str) {
        return Integer.parseInt(str, BASE);
    }

   /**
    * Converte para decimal e armazena o valor passado.
    * 
    * @param novo valor em binário.
    */
    public void setValor(String novo) {
        valor = converterBin (novo);
    }

    /**
     * Converte o valor armazenado em String binária.
     * 
     * @return String binária.
     */
    public String converterEmString() {
        return Integer.toBinaryString(valor);
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


        valor = converterBin (str);

        return converterEmString ();
    }

}
