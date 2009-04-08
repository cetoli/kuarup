package alpha;


/**
 * Abstract class Numero - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Numero implements INumero{
    
     String repNum = "0"; 
    
    public void entraUm() {
        repNum += "1";
    }
    
    public abstract Integer converteEmNumeroDecimal();
    
    public abstract INumero converterParaBase(Integer num);
    
    public abstract String mostraNumeroNaMinhaRepresentacaoBase();
    
     public void setRepNum(String num){
        this.repNum=num;
    }
    
    public String getRepNum(){
        return repNum;
    }
    
    public void zeraRepresentacaoNumerica(){
        setRepNum("0");
    }
}