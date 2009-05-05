package bravo;


/**
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 */
public class Exponencial implements Numero
{
   private int valor;
    
   /**
    * M�todo herdado de Operando.
    */
   public Exponencial(int valor) {
      this.valor = valor;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public void adicionaParteReal(Numero operando) {    
   }

   /**
    * M�todo herdado de Operando.
    */
   public void adicionaParteImaginaria(Numero operando) { 
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
      return "N"+base.getId()+base.converterBase(this.valor);
   }

   /**
    * M�todo herdado de Operando.
    */
   public void soma(Numero operando) {
   }

   /**
    * M�todo herdado de Operando.
    */
   public int getValor() {
      return this.valor;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public void setValor(int valor) {
      this.valor = valor;
   }

   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteReal() {
      return new Nulo();
   }

   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteImaginaria() {
      return new Nulo();
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteExponencial() {
      return this;
   }
}