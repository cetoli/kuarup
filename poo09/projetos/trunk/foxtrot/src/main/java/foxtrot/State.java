package foxtrot;

/**.
 * Descrição:
 * Design Pattern State
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 14/04/2009
 */

public interface State
{
    /**.
     * entra o valor 1 no operador
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc);

    /**.
     * limpa o acumulador e o operador
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc);

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @return conteúdo do acumulador
     */
    public String comandoSoma(Calculadora calc);
}
