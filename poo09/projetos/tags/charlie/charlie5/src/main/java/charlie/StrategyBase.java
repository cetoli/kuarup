package charlie;

public interface StrategyBase {
    public String getId();
    public int toDecimal(String numero);
    public String converterBase(int valor); 
}
