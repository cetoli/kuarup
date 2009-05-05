package golf.num;

import golf.bases.BaseStrategy;
import golf.bases.BinariaStrategy;
import golf.bases.DecimalStrategy;
import golf.bases.HexadecimalStrategy;


/**
 * Abstract class ComponentNum - write a description of the class here
 * @author  Gustavo Taveira
 * @version 2.0 28/04/2009 Gustavo Taveira
 */
public abstract class ComponentNum {

    /**
     * Atributo valor.
     **/
    protected int valor = 0;

    /**
     * Atributo base especifica a base utilizada.
     **/
    protected BaseStrategy base = new DecimalStrategy();

    /**
     * Metodo que inicializa os valores dos atributos da instancia.
     */
    public void initialize(BaseStrategy umaBase) {
        base = umaBase;
    }

    /**
     * Metodo que retorna o contendo do atributo valor.
     * @result valor
     */
    public int getValue(int index) {
        return valor;
    }

    /**
     * Metodo que atualiza o contendo do atributo valor.
     * @param  x    novo valor
     */
    public void setValue(int index, int x) {
        valor = x;
    }

    /**
     * Metodo que retorna o conte�do do atributo valor.
     * @result valor
     */
    public BaseStrategy getBase() {
        return base;
    }

    /**
     * Metodo que atualiza o conte�do do atributo valor.
     * @param  x    novo valor
     */
    public void setBase(BaseStrategy b) {
        base = b;
    }

    /**
     * Metodo que realiza o entra um.
     */
    public void entraUm() {
        valor = valor * base.getBase() + 1;
    }

    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        base = new DecimalStrategy();
    }

    /**
     * Entra a base binaria.
     */
    public void modoBin() {
        base = new BinariaStrategy();
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new HexadecimalStrategy();
    }

    /**
     * Metodo que responsavel por adicionar um componente.
     * @param  componente    o elemento a ser adicionado.
     */
    public void addComponent(ComponentNum componente) {
        //n�o faz nada
    }

    /**
     * Metodo que responsavel por remover um componente.
     * @param  componente    o elemento a ser adicionado.
     */
    public void removeComponent() {
        //n�o faz nada
    }

    /**
     * Metodo que responsavel por retornar um componente.
     * @param  index    o indice do componente a ser retornado.
     * @result ComponentNum.
     */
    public ComponentNum getComponent(int index) {
        return this;
    }

    /**
     * Metodo que responsavel por alterar um componente especifico.
     * @param  index    o indice do componente a ser alterado.
     * @param  componente    componente a ser colocado na posicao especifica.
     */
    public void setComponent(int index, ComponentNum componente) {
        //nao faz nada
    }

    /**
     * Metodo que responsavel por retornar o numero de componentes.
     * @param  componente    o elemento a ser adicionado.
     * @result int.
     */
    public int getComponentCount() {
        return 1;
    }

    /**
     * Metodo responsavel por escrever o numero corretamente.
     * @result String.
     */
    public String writeNum() {
        return getPrefix() + base.getId() + base.toBase(valor);
    }

    /**
     * Metodo que responsavel por retornar o prefixo do componente.
     * @result String.
     */
    public abstract String getPrefix();
}
