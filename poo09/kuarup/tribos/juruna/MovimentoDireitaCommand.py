from Command import *

class MovimentoDireitaCommand (Command):
    def executar (self, peixe, tela):
        pos= peixe.getPosicao ()
        pos.setVetorSentido (1,0,0)
        incremento= peixe.getIncrementoNado ()

        posC= pos.getPontoCima ()
        posB= pos.getPontoBaixo ()

        if pos.permitidoPeixeMover (peixe, incremento, tela) != 0:
            posicao= peixe.getPosicao ()
            peixe.nadar (incremento)