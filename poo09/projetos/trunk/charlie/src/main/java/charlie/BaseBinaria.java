package charlie;

public class BaseBinaria implements StrategyBase {

    public BaseBinaria() {
    }
    
    public String getId(){
        return "0b";   
    }

    public int toDecimal(String numero) {
        return Integer.parseInt(numero, 2);
    }

    public String converterBase(int valor) {
        return Integer.toBinaryString(valor);
    }
}