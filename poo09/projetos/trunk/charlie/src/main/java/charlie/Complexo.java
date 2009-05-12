package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class Complexo implements Numero
{
   private Numero real;
   private Numero imaginario;
    
   /**
    * Método herdado de Operando.
    */
   public Complexo() {
      this.real = new Nulo();
      this.imaginario = new Nulo();
   }
    
   /**
    * Método herdado de Operando.
    */
   public void adicionaParteReal(Numero operando) {
      this.real = operando;
   }
   /**
    * Método herdado de Operando.
    */
   public void adicionaParteImaginaria(Numero operando) {
      this.imaginario = operando;
   }
    
   /**
    * Método herdado de Operando.
    */
   public void adicionaParteExponencial(Numero operando) {
   }
    
   /**
    * Método herdado de Operando.
    */
   public String mostra(StrategyBase base) {
      return this.real.mostra(base)+this.imaginario.mostra(base);
   }
    
   /**
    * Método herdado de Operando.
    */
   public void soma(Numero operando) {
      this.real.soma(operando.getParteReal());
      this.imaginario.soma(operando.getParteImaginaria());
   }
    
   /**
    * Método herdado de Operando.
    */
   public int getValor() {
      return 0;
   }
    
   /**
    * Método herdado de Operando.
    */
   public void setValor(int valor) {
   }
    
   /**
    * Método herdado de Operando.
    */
   public Numero getParteReal() {
      return this.real;
   }
   
   /**
    * Método herdado de Operando.
    */
   public Numero getParteImaginaria() {
      return this.imaginario;
   }
    
   /**
    * Método herdado de Operando.
    */
   public Numero getParteExponencial() {
      return new Nulo();
   }
}
