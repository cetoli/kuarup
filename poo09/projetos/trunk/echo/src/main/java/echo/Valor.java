package echo;


/**
 * Write a description of class Valor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Valor
{
    protected int valor;

    /**
     * Constructor for objects of class Valor
     */
    public Valor()
    {
        
        valor = 0;
    }
    
    public Valor(int novo)
    {
        
        valor = novo;
    }

    public int getValor() {
        return valor;
    }
    
    public void adicionarDigito (String digito) {
    
        
    }
    
    public void setValor(String novo) {
        valor = Integer.parseInt (novo);
    }
    
    public String converterEmString() {
        return new Integer(valor).toString();
    }
}
