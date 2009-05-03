package golf;

import java.util.ArrayList;

/**
 * Write a description of class CompositeNum here.
 * @author  Gustavo Taveira
 * @version 2.0 28/04/2009 Gustavo Taveira
 */
public class CompositeNum extends ComponentNum {

    private ArrayList elements = new ArrayList();

    /**
     * Metodo que inicializa os valores dos atributos da instancia
     */
    public void initialize(BaseStrategy umaBase) {
        //Adiciona uma parte real e uma parte complexa ao numero
        ComponentNum aux1 = new RealNum();
        ComponentNum aux2 = new ComplexNum();
        addComponent(aux1);
        addComponent(aux2);
        base = umaBase;
    }

    /**
     * Metodo que respons‡vel por alterar o valor de um componente especifico
     * @param  index    o indice do componente a ser alterado
     * @param  valor    valor a ser colocado no componente especifico
     */
    public void setValue(int index, int x) {
        ComponentNum aux = getComponent(index);
        aux.setValue(index, x);
    }

    /**
     * Metodo que retorna o valor de um componente especifico
     * @param  index    o indice do valor a ser retornado
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
            elem.setBase(base);
        }
    }

    /**
     * Entra a base binária.
     */
    public void modoBin() {
        base = new BinariaStrategy();
        for(int i = 0; i < elements.size(); i++){
            ComponentNum elem = getComponent(i);
            elem.setBase(base);
        }
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new HexadecimalStrategy();
        for(int i = 0; i < elements.size(); i++){
            ComponentNum elem = getComponent(i);
            elem.setBase(base);
        }
    }

    /**
     * Metodo que realiza o entra um
     * @param  base    a base atual do numero
     */
    public void entraUm(int index) {
        ComponentNum elem = getComponent(index);
        elem.entraUm(index);
    }

    /**
     * Metodo que respons‡vel por adicionar um componente
     * @param  componente    o elemento a ser adicionado
     */
    public void addComponent(ComponentNum componente) {
        elements.add(componente);
    }

    /**
     * Metodo que respons‡vel por remover um componente
     * @param  componente    o elemento a ser adicionado
     */
    public void removeComponent() {
        elements.remove(elements.size()-1);
    }
    
    /**
     * Metodo que respons‡vel por retornar um componente
     * @param  index    o indice do componente a ser retornado
     * @result ComponentNum
     */
    public ComponentNum getComponent(int index) {
        return (ComponentNum) elements.get(index);
    }

    /**
     * Metodo que respons‡vel por alterar um componente especifico
     * @param  index    o indice do componente a ser alterado
     * @param  componente    componente a ser colocado na posicao especifica
     */
    public void setComponent(int index, ComponentNum componente) {
        elements.set(index, componente);
    }

    /**
     * Metodo que respons‡vel por retornar o nœmero de componentes
     * @param  componente    o elemento a ser adicionado
     * @result int
     */
    public int getComponentCount() {
        return elements.size();
    }

    /**
     * Metodo que respons‡vel por retornar o prefixo do componente
     * @result String
     */
    public String getPrefix() {
        return "";
    }

    /**
     * Metodo respons‡vel por escrever o numero corretamente
     * @result String
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
