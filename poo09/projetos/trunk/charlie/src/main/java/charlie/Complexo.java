package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 */
public class Complexo implements Numero
{
   private Numero real;
   private Numero imaginario;
    
   /**
    * M�todo herdado de Operando.
    */
   public Complexo() {
      this.real = new Nulo();
      this.imaginario = new Nulo();
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public void adicionaParteReal(Numero operando) {
      this.real = operando;
   }
   /**
    * M�todo herdado de Operando.
    */
   public void adicionaParteImaginaria(Numero operando) {
      this.imaginario = operando;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public void adicionaParteExponencial(Numero operando) {
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public String mostra(StrategyBase base) {
      return this.real.mostra(base)+this.imaginario.mostra(base);
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public void soma(Numero operando) {
      this.real.soma(operando.getParteReal());
      this.imaginario.soma(operando.getParteImaginaria());
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public int getValor() {
      return 0;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public void setValor(int valor) {
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteReal() {
      return this.real;
   }
   
   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteImaginaria() {
      return this.imaginario;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteExponencial() {
      return new Nulo();
   }
}
