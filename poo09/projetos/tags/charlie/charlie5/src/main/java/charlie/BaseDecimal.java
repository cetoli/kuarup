package charlie;

public class BaseDecimal implements StrategyBase {

    public BaseDecimal() {
    }
    
    public String getId(){
        return "";   
    }

    public int toDecimal(String numero) {
        return Integer.parseInt(numero);
    }

    public String converterBase(int valor) {
        return String.valueOf(valor);    
    }
}