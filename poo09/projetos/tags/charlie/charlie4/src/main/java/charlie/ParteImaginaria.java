package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class ParteImaginaria implements Adicionador {
    
   /**
    * Método que adiciona a parte real ao operando.
    * @param operando
    */
   public void adicionaParteReal(int i, Numero operando, Adicionador montador) {
   }

   /**
    * Método que adiciona a parte imaginária ao operando.
    * @param operando
    */
   public void adicionaParteImaginaria(int i, Numero operando, Adicionador montador) {
       montador.adicionaParteImaginaria(i, operando, montador);
   }
}