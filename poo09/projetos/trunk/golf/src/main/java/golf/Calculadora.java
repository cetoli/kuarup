/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/

package golf;

import labase.poo.ICalculadoraEngenharia;

/**
 * Classe que implementa a calculadora.
 * @author  Gustavo Taveira
 * @version 2.0 28/04/2009 Gustavo Taveira
 * @since   2.0 IncluÌdas as funcionalidades: numeros binarios e
 * hexadecimais.
 * @version 1.0 31/03/2009 AndrÈ Sion e Thiago Silva de Souza
 * @since   1.0 IncluÌdas as implementaÁıes dos mÈtodos limpa(), entraUm() e
 * comandoSoma().
 */
public class Calculadora implements ICalculadoraEngenharia {

    // Estado da Caculadora
    /**
     * Constante real.
     **/
    private final int real = 0;
    /**
     * Constante complexo.
     **/
    private final int complexo = 1;
    /**
     * Atributo acumulador guarda os resultados da soma.
     **/
    private ComponentNum acumulador;
    /**
     * Atributo operando guarda o contÈudo do operando.
     **/
    private ComponentNum operando;
    /**
     * Atributo operando guarda o contÈudo do operando.
     **/
    private int tipo;

    /**
     * Construtor para objetos da classe Calculadora.
     **/
    public Calculadora() {
        inicializa();
        tipo = real;
    }

    /**
     * Inicializa ambas as variáveis como reais de valor = 0.
     **/
    public void inicializa() {
        // inicializa vari·veis de instância
        acumulador = new Real(); //Default começa apenas como real
        operando = new Real(); //Default começa apenas como real
    }

    /**
     * Limpa o acumulador.
     * @return conte˙do do acumulador
     **/
    public final String limpa() {
        inicializa();
        return "0";
    }

    /**
     * Entra a tecla um.
     * @return conte˙do do operador
     **/
    public String entraUm() {
        //operando.entraUm(tipo);
        operando.entraUm();
        return operando.writeNum();
    }

    /**
     * Entra o comando soma.
     * @return conte˙do do acumulador
     **/
    public String comandoSoma() {
        //PROBLEMA!!!!!
        for(int i = 0; i < operando.getComponentCount(); i++){
            acumulador.setValue(i, acumulador.getValue(i) + operando.getValue(i));
        }
        tipo = real;
        operando = new Real();
        operando.setBase(acumulador.getBase());
        return acumulador.writeNum();
    }

    /**
     * Entra a base decimal.
     */
    public void modoDec() {
        operando.modoDec();
        acumulador.modoDec();
    }

    /**
     * Entra a base bin·ria.
     */
    public void modoBin() {
        operando.modoBin();
        acumulador.modoBin();
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        operando.modoHex();
        acumulador.modoHex();
    }

    /**
     * Entra a base parte complexa do numero.
     */
    public void entraI() {
/*        
        ComponentNum aux1 = new CompositeNum(); //Default começa apenas como real
        aux1.initialize(operando.getBase());
        for(int i = 0; i < operando.getComponentCount(); i++){
            aux1.setValue(i, operando.getValue(i));
        }
        operando = aux1;

        ComponentNum aux2 = new CompositeNum(); //Default começa apenas como real
        aux2.initialize(acumulador.getBase());
        for(int i = 0; i < acumulador.getComponentCount(); i++){
            aux2.setValue(i, acumulador.getValue(i));
        }
        acumulador = aux2;
        
        tipo = complexo;
*/
        
        ComponentNum composite = new ComplexNum();
        ComponentNum aux = new Imaginario();
        composite.addComponent(operando);
        composite.addComponent(aux);
        operando = composite;
    }

    /**
     * Entra a base parte complexa do numero.
     */
    public void entraN() {
        //ComponentNum root = new EngenhariaNum();
        ComponentNum composite = new Exponent();
        composite.addComponent(operando);
        composite.addComponent(composite);
        operando = composite;
    }

}
