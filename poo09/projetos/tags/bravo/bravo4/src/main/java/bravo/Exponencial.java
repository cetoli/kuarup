package bravo;


/**
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class Exponencial implements Numero
{
   private int valor;
    
   /**
    * Método herdado de Operando.
    */
   public Exponencial(int valor) {
      this.valor = valor;
   }
    
   /**
    * Método herdado de Operando.
    */
   public void adicionaParteReal(Numero operando) {    
   }

   /**
    * Método herdado de Operando.
    */
   public void adicionaParteImaginaria(Numero operando) { 
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
      return "N"+base.getId()+base.converterBase(this.valor);
   }

   /**
    * Método herdado de Operando.
    */
   public void soma(Numero operando) {
   }

   /**
    * Método herdado de Operando.
    */
   public int getValor() {
      return this.valor;
   }
    
   /**
    * Método herdado de Operando.
    */
   public void setValor(int valor) {
      this.valor = valor;
   }

   /**
    * Método herdado de Operando.
    */
   public Numero getParteReal() {
      return new Nulo();
   }

   /**
    * Método herdado de Operando.
    */
   public Numero getParteImaginaria() {
      return new Nulo();
   }
    
   /**
    * Método herdado de Operando.
    */
   public Numero getParteExponencial() {
      return this;
   }
}