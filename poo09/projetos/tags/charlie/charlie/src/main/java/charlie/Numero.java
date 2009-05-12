package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */

public interface Numero {
     
   public void adicionaParteReal(Numero numero);
   
   public void adicionaParteImaginaria(Numero numero);
     
   public void adicionaParteExponencial(Numero numero);
     
   public String mostra(StrategyBase base);
     
   public void soma(Numero numero);
     
   public int getValor();
     
   public void setValor(int valor);
     
   public Numero getParteReal();
    
   public Numero getParteImaginaria();
    
   public Numero getParteExponencial();
}