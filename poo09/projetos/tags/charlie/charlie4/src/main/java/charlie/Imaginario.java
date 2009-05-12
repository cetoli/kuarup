package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 */
public class Imaginario implements Numero
{
   private int valor;
   private Numero exponencial;
    
   /**
    * M�todo herdado de Operando.
    */
   public Imaginario(int valor) {
      this.valor = valor;
      this.exponencial = new Nulo();
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
      this.exponencial = operando;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public String mostra(StrategyBase base) {
      return "I"+base.getId()+base.converterBase(this.valor)+this.exponencial.mostra(base);
   }
    
   /**
    * M�todo herdado de Operando.
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
      return this;
   }
    
   /**
    * M�todo herdado de Operando.
    */
   public Numero getParteExponencial() {
      return this.exponencial;
   }
}