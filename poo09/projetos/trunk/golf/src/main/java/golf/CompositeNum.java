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
     * Metodo que realiza o entra um
     * @param  base    a base atual do numero
     */
    public void entraUm() {
        ComponentNum elem = getComponent(elements.size()-1);
        elem.entraUm();
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
