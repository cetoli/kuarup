package charlie;

public class BaseHexadecimal implements StrategyBase {

    public BaseHexadecimal() {
    }
    
    public String getId(){
        return "0x";   
    }
        
    public int toDecimal(String numero) {
        return Integer.parseInt(numero, 16);
    }

    public String converterBase(int valor) {
        return Integer.toHexString(valor).toUpperCase();
    }
}