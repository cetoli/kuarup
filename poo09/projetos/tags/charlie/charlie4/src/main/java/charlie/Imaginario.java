package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class Imaginario implements Numero
{
   private int valor;
   private Numero exponencial;
    
   /**
    * Método herdado de Operando.
    */
   public Imaginario(int valor) {
      this.valor = valor;
      this.exponencial = new Nulo();
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
      this.exponencial = operando;
   }
    
   /**
    * Método herdado de Operando.
    */
   public String mostra(StrategyBase base) {
      return "I"+base.getId()+base.converterBase(this.valor)+this.exponencial.mostra(base);
   }
    
   /**
    * Método herdado de Operando.
    */
   public void soma(Numero operando) {
      int valorOutro = operando.getParteImaginaria().getValor();
      int maxExp = Math.max(this.exponencial.getValor(), operando.getParteImaginaria().getParteExponencial().getValor());
      this.valor = this.valor/((int)Math.pow(10, maxExp-this.exponencial.getValor()));
      valorOutro = valorOutro/((int)Math.pow(10, maxExp-operando.getParteImaginaria().getParteExponencial().getValor()));
      this.valor += valorOutro;
      this.exponencial.setValor(maxExp);
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
      return this;
   }
    
   /**
    * Método herdado de Operando.
    */
   public Numero getParteExponencial() {
      return this.exponencial;
   }
}