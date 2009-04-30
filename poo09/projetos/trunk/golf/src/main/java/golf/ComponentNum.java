package golf;


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
    private BaseStrategy base = new DecimalStrategy();

    /**
     * Metodo que realiza o entra um
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
     * Entra a base binária.
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
     * Metodo que respons‡vel por adicionar um componente
     * @param  componente    o elemento a ser adicionado
     */
    public abstract void addComponent(ComponentNum componente);

    /**
     * Metodo que respons‡vel por remover um componente
     * @param  componente    o elemento a ser adicionado
     */
    public abstract void removeComponent();
    
    
    /**
     * Metodo que respons‡vel por retornar um componente
     * @param  index    o indice do componente a ser retornado
     * @result ComponentNum
     */
    public ComponentNum getComponent(int index) {
        return this;
    }

    /**
     * Metodo que respons‡vel por retornar o nœmero de componentes
     * @param  componente    o elemento a ser adicionado
     * @result int
     */
    public int getComponentCount() {
        return 1;
    }

    /**
     * Metodo que respons‡vel por retornar o prefixo do componente
     * @result String
     */
    public abstract String getPrefix();

    /**
     * Metodo respons‡vel por escrever o numero corretamente
     * @result String
     */
    public String writeNum() {
        return getPrefix() + base.getId() + base.toBase(valor);
    }
}
