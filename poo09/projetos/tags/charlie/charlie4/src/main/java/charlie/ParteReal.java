package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 */
public class ParteReal implements Adicionador {
  
   /**
    * M�todo que adiciona a parte real ao operando.
    * @param operando
    */
   public void adicionaParteReal(int i, Numero operando, Adicionador montador) {
       montador.adicionaParteReal(i, operando, montador);
   }

   /**
    * M�todo que adiciona a parte imagin�ria ao operando.
    * @param operando
    */
   public void adicionaParteImaginaria(int i, Numero operando, Adicionador montador) {
   }
}
