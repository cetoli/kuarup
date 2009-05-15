/*------------------------------------------------------------------------------
 Copyright  2002-2009        Carlo E. T. Oliveira et all
 ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

 This software is licensed as described in the file LICENSE.txt,
 which you should have received as part of this distribution.
 ------------------------------------------------------------------------------*/
package hotel;

import labase.poo.ICalculadoraVetorial;

/**
 * Calculadora com tres botoes.
 * 
 * @author (Marcos de Castro) $Author$
 * @author (Rodrigo Santos Borges) $Author$
 * @version (2.0) $Revision$ (07/04/09) $Date$
 * @since (2.0) Botoes para entrar valores em binario, hexadecimal e decimal
 */
public class Calculadora implements ICalculadoraVetorial {
    /**
         * Acumulador da Caculadora.
         */

    // private ValorBase acumulador = new Valor(0);
    private static final int TAM_VETOR = 2;

    /***********************************************************************
         * Acumulador da ultimo valor.
         */
    // private ValorBase operando = new Valor(0);
    private static final int INDICE_ACUMULADOR = 0;

    private static final int INDICE_OPERANDO = 1;

    private int indiceAtual;

    // private ValorBase atual = valores[INDICE_ACUMULADOR];

    private ValorBase[] valores;

    private ImpressaoStrategy proximoModoEntrada;

    private ImpressaoStrategy proximoModoImpressao;

    /**
         * Construtor para objetos da classe Calculadora.
         */
    public Calculadora() {
	proximoModoEntrada = new ImpressaoPadraoStrategy();
	proximoModoImpressao = new ImpressaoPadraoStrategy();

	valores = new ValorBase[TAM_VETOR];
	valores[INDICE_ACUMULADOR] = new Valor(0);
	valores[INDICE_OPERANDO] = new Valor(0);

	indiceAtual = INDICE_ACUMULADOR;
    }

    /**
         * Modo Complexo.
         */
    public void entraI() {
	proximoModoImpressao = new ImpressaoPadraoStrategy();

	valores[indiceAtual] = valores[indiceAtual].instanciarComplexo();

    }

    /**
         * Modo Engenharia.
         */
    public void entraN() {
	proximoModoImpressao = new ImpressaoPadraoStrategy();

	valores[indiceAtual] = valores[indiceAtual].instanciarEngenharia();
    }

    public void entraV() {
	valores[indiceAtual] = valores[indiceAtual].instanciarVetor();

    }

    /**
         * Botao para entrada de valores em hexadecimal.
         */
    public void modoHex() {
	proximoModoEntrada = new ImpressaoHexadecimalStrategy();
	proximoModoImpressao = new ImpressaoHexadecimalStrategy();

	// valores[indiceAtual] = valores[indiceAtual].modoHexa();
	valores[INDICE_OPERANDO] = valores[INDICE_OPERANDO].modoHexa();

	valores[indiceAtual].impressaoHexa();
	valores[INDICE_OPERANDO].impressaoHexa();
    }

    /**
         * Botao para entrada de valores em binario.
         */
    public void modoBin() {
	proximoModoEntrada = new ImpressaoBinarioStrategy();
	proximoModoImpressao = new ImpressaoBinarioStrategy();
	// valores[indiceAtual] = valores[indiceAtual].modoBin();

	valores[INDICE_OPERANDO] = valores[INDICE_OPERANDO].modoBin();

	valores[indiceAtual].impressaoBin();
	valores[INDICE_OPERANDO].impressaoBin();
    }

    /**
         * Botao para entrada de valores em decimal.
         */
    public void modoDec() {
	proximoModoEntrada = new ImpressaoDecimalStrategy();
	proximoModoImpressao = new ImpressaoDecimalStrategy();

	valores[indiceAtual] = valores[indiceAtual].modoDec();
	valores[INDICE_OPERANDO] = valores[INDICE_OPERANDO].modoDec();

	valores[indiceAtual].impressaoDec();
	valores[INDICE_OPERANDO].impressaoDec();
    }

    /**
         * Entra a tecla um.
         * 
         * @return conteudo do operador
         */
    public final String entraUm() {
	return valores[indiceAtual].adicionarDigito("1", proximoModoEntrada,
		proximoModoImpressao);
    }

    /**
         * Limpa o acumulador.
         * 
         * @return conteudo do acumulador
         */
    public final String limpa() {
	valores[indiceAtual].limparValor();
	return valores[INDICE_ACUMULADOR].limparValor();
    }

    /**
         * Entra o comando soma.
         * 
         * @return conteudo do acumulador
         */
    public final String comandoSoma() {
	valores[INDICE_ACUMULADOR] = valores[INDICE_ACUMULADOR]
		.somar(valores[INDICE_OPERANDO]);

	valores[INDICE_OPERANDO].limparValor();

	valores[INDICE_OPERANDO] = new Valor();
	indiceAtual = INDICE_OPERANDO;

	valores[INDICE_OPERANDO].impressao = valores[INDICE_ACUMULADOR]
		.getModoImpressao();

	return valores[INDICE_ACUMULADOR].converterEmString();
    }

    public String comandoSubtrai() {
	valores[INDICE_ACUMULADOR] = valores[INDICE_ACUMULADOR]
		.subtrair(valores[INDICE_OPERANDO]);

	valores[INDICE_OPERANDO].limparValor();

	valores[INDICE_OPERANDO] = new Valor();
	indiceAtual = INDICE_OPERANDO;
	valores[INDICE_OPERANDO].impressao = valores[INDICE_ACUMULADOR]
		.getModoImpressao();

	return valores[INDICE_ACUMULADOR].converterEmString();
    }
}
