package bravo;


/**
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class ParteExponencial implements Adicionador {
    
   /**
    * Método que adiciona a parte real ao operando.
    * @param operando
    */
   public void adicionaParteReal(int i, Numero operando, Adicionador montador) {
       operando.getParteReal().adicionaParteExponencial(new Exponencial(i));
   }

   /**
    * Método que adiciona a parte imaginária ao operando.
    * @param operando
    */
   public void adicionaParteImaginaria(int i, Numero operando, Adicionador montador) {
       operando.getParteImaginaria().adicionaParteExponencial(new Exponencial(i));
   }
}
