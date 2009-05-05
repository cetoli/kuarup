package bravo;


/**
 * Interface IExibicaoValorState.
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 */

public interface IExibicaoValorState
{
    /**
     * Assinatura do metodo que vai retornar o valor baseado no estado
     *  que a calculadora se encontrar. Para o caso da mesma estar num estado
     *  imaginario ou real.

     * @param  acumuladorReal - Acumulador real gerado pela soma.
     * @param  acumuladorImaginario - Acumul Imag gerado pela soma.
     * @param  baseNumericaUsada - qual a estrat de base numérica q a ser usada.
     * @return - retorna uma String com o devido valor preenchido
     */
    public String retornaValor(Numero acumuladorReal,
                    Numero acumuladorImaginario, 
                    StrategyBase baseNumericaUsada);
}
