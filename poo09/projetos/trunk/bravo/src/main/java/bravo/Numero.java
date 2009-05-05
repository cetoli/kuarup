package bravo;

/**
 * Define  a classe n�mero.
 * A classe calculadora realiza opera��es matem�ticas com n�meros Imagin�rios.
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
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