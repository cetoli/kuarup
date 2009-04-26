from Command import *

class MovimentoBaixoCommand (Command):
    def executar (self, peixe, tela, estrategia):
        estrategia.movimentoBaixo (peixe, tela)

        """
        pos= peixe.getPosicao ()
        pos.setVetorSentido (0,-1,0)
        incremento= peixe.getIncrementoNado ()

        posC= pos.getPontoCima ()
        posB= pos.getPontoBaixo ()

        if pos.permitidoPeixeMover (peixe, incremento, tela) != 0:
            posicao= peixe.getPosicao ()
            peixe.nadar (incremento)
        """


# Fim