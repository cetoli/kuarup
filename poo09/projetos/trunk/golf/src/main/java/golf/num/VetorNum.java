package golf.num;
import golf.bases.*;
import java.util.ArrayList;


/**
 * Adição e Subtração usando vetores.
 * 
 * @author Gustavo Taveira
 * @version 5.0
 */
public class VetorNum extends ComponentNum{

    private ArrayList elements = new ArrayList();

    /**
     * Metodo que responsavel por alterar o valor de um componente especifico.
     * @param  index    o indice do componente a ser alterado.
     * @param  valor    valor a ser colocado no componente especifico.
     */
    public void setValue(int index, int x) {
        ComponentNum aux = getComponent(index);
        aux.setValue(index, x);
    }

    /**
     * Metodo que retorna o valor de um componente especifico.
     * @param  index    o indice do valor a ser retornado.
     */
    public int getValue(int index) {
        ComponentNum aux = getComponent(index);
        return aux.getValue(index);
    }

    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        base = new DecimalStrategy();
        for(int i = 0; i < elements.size(); i++){
            ComponentNum elem = getComponent(i);
            elem.modoDec();
        }
    }

    /**
     * Entra a base binaria.
     */
    public void modoBin() {
        base = new BinariaStrategy();
        for(int i = 0; i < elements.size(); i++){
            ComponentNum elem = getComponent(i);
            elem.modoBin();
        }
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new HexadecimalStrategy();
        for(int i = 0; i < elements.size(); i++){
            ComponentNum elem = getComponent(i);
            elem.modoHex();
        }
    }

    /**
     * Metodo que realiza o entra um.
     * @param  base    a base atual do numero.
     */
    public void entraUm() {
        ComponentNum elem = getComponent(elements.size()-1);
        elem.entraUm();
    }

    /**
     * Metodo que responsavel por adicionar um componente.
     * @param  componente    o elemento a ser adicionado.
     */
    public void addComponent(ComponentNum componente) {
        elements.add(componente);
    }

    /**
     * Metodo que responsavel por remover um componente.
     * @param  componente    o elemento a ser adicionado.
     */
    public void removeComponent() {
        elements.remove(elements.size()-1);
    }

    /**
     * Metodo que responsavel por retornar um componente.
     * @param  index    o indice do componente a ser retornado.
     * @result ComponentNum.
     */
    public ComponentNum getComponent(int index) {
        return (ComponentNum) elements.get(index);
    }

    /**
     * Metodo que responsavel por alterar um componente especifico.
     * @param  index    o indice do componente a ser alterado.
     * @param  componente    componente a ser colocado na posicao especifica.
     */
    public void setComponent(int index, ComponentNum componente) {
        elements.set(index, componente);
    }

    /**
     * Metodo que responsavel por retornar o numero de componentes.
     * @param  componente    o elemento a ser adicionado.
     * @result int.
     */
    public int getComponentCount() {
        return elements.size();
    }

    /**
     * Metodo que responsavel por retornar o prefixo do componente.
     * @result String.
     */
    public String getPrefix() {
        return "";
    }

    /**
     * Metodo responsavel por escrever o numero corretamente.
     * @result String.
     */
    public String writeNum() {
        String num = "";
        for(int i = 0; i < elements.size(); i++){
            ComponentNum elem = getComponent(i);
            num = num + elem.writeNum();
        }
        return num;
    }
}
