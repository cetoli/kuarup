from __future__ import division
from visual import *
import Image
from Eixo import *
from Ponto import *
from SerMarinho import *
from AcaraDisco import *
from TartarugaMichelangelo import *

from AguaViva import *
from Tubarao import *

# Classe que trata do canvas
class Mar:
	animais= None
	cenario= None

	taxa= 7
	QTD_PASSOS_CURVA_ALEATORIA= 6
	QTD_PASSOS_RETA= 2
	RAIO_CURVA= 0.5

	ESCALA_TUBARAO= 0.5
	ESCALA_AGUA_VIVA= 1

	def __init__ (self):
		self.cenario= display (title='Oceano',width=700, height=500,center= (0.5,0,0),x=0, y=0, background=color.blue)
		#self.cenario= display (title='Oceano',width=150, height=150,center= (0.5,0,0),x=0, y=0, background=color.blue)
   		self.cenario.select ()
   		self.cenario.visible = 1
        #self.quadro = 0

		#scene.range = 3

	def popular (self):

		self.animais= list ()

		peixe= PeixeAcaraDisco (escala= 1, axis= (-1,0,-1), pos= (14, 0, 10))
		self.animais.append (peixe)
		peixe.desenhar ()

		aguaViva= AguaViva (escala = self.ESCALA_AGUA_VIVA, axis=(0,0,1), pos= (8,0.5,4))
		aguaViva.desenha (aguaViva.escala)
		self.animais.append (aguaViva)

	   	tubarao= Tubarao(escala= self.ESCALA_TUBARAO, axis=(1,0,1), pos= (-1, 1,-5))
	   	tubarao.desenha (tubarao.escala)
	   	self.animais.append (tubarao)

	def getQtdAnimais (self):
		return self.animais.__len__();

	def getAnimal (self, pos):
		return self.animais.__getitem__(pos)



	def baterAguaViva (self, posBatida):
		# Vai de encontro com a agua viva
		self.animais[0].nadarPara (posBatida)
		rate (self.taxa)

	def aguaVivaIndoBocaTubarao (self, posFinalAguaViva):
		# seta a velocidade para 2X maior que o normal
		self.animais[1].setVelocidadeNado (1.3)

		# Voa para a boca do tubarao
		self.animais[1].nadarPara (posFinalAguaViva)

	def peixeFugir (self, pos1Peixe, posFinalPeixe):
		self.animais[0].nadarPara (pos1Peixe)
		self.animais[0].girarPara (-30, -10, Eixo.EIXO_Y)
		rate (self.taxa)
		self.animais[0].nadarPara (posFinalPeixe)

	def tubaraoTossir (self, pos):
		listaAngulo= [10, 350]
		self.animais[2].girar (listaAngulo[pos%2], Eixo.EIXO_Z)


	def fazerGraca (self):
		cont= 0
		listaAngulo= [10, 350]

		alturaCorpo= self.animais[0].corpo.corpo.height
		msg= label(pos= self.animais[0].esqueleto.pos, text='Na na na na', xoffset=30, yoffset= alturaCorpo, space= alturaCorpo, height=15, border=3, font='sans')

		while cont < 5:
			# danca para um lado
			angulo= listaAngulo[0]

			self.animais[0].girar (angulo, Eixo.EIXO_Y)
			self.tubaraoTossir (0)
			rate (self.taxa/2)

			# danca para o outro lado
			angulo= listaAngulo[1]

			self.animais[0].girar (angulo, Eixo.EIXO_Y)
			self.tubaraoTossir (1)
			rate (self.taxa/3)


			cont+= 1

		msg.visible= 0


	def tubaraoCuspirAguaViva (self, posAguaVivaBoca, posAguaViva):
		posicao= (posAguaViva[0]+2, posAguaViva[1]-1.5, posAguaViva[2])

		cuspe= list ()
		cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
		cuspe.append (cuspeTemp)

		posicao= (posAguaViva[0]+1.8, posAguaViva[1]-2, posAguaViva[2]-1)
		cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
		cuspe.append (cuspeTemp)

		posicao= (posAguaViva[0]+2.3, posAguaViva[1]-1.5, posAguaViva[2]+0.5)
		cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
		cuspe.append (cuspeTemp)

		posicao= (posAguaViva[0]+1.8, posAguaViva[1]-2, posAguaViva[2]+1)
		cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
		cuspe.append (cuspeTemp)

		posicao= (posAguaViva[0]+1.8, posAguaViva[1]-2, posAguaViva[2]+1.5)
		cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
		cuspe.append (cuspeTemp)

		posicao= (posAguaViva[0]+1, posAguaViva[1]-2, posAguaViva[2]+1.5)
		cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
		cuspe.append (cuspeTemp)

		rate (self.taxa)

		x= (posAguaViva[0] - posAguaVivaBoca[0])/2
		y= (posAguaViva[1] - posAguaVivaBoca[1])/2
		z= (posAguaViva[2] - posAguaVivaBoca[2])/2

		# move o cuspe
		cont= 0
		while cont < 2:
			# joga a agua viva pra fora da boca
			self.animais[1].esqueleto.pos+= (self.animais[1].esqueleto.pos[0]+x, self.animais[1].esqueleto.pos[1]+y, self.animais[1].esqueleto.pos[2]+z)

			# movimenta o cuspe junto com a agua viva
			for i in range(len(cuspe)):
		 		cuspe[i].pos= (cuspe[i].pos[0] + x, cuspe[i].pos[1] + y, cuspe[i].pos[2] + z)

			rate (self.taxa)
			cont+= 1

		for i in range(len(cuspe)):
	 		cuspe[i].visible= 0

	def fugirTubarao (self):
		posTubarao= self.animais[2].esqueleto.pos
		posAguaViva= self.animais[1].esqueleto.pos

		# posTubarao e a posicao final da agua viva apos ser comida pelo tubarao
		posAguaVivaBoca= list ()
		posAguaVivaBoca.append (posTubarao[0]+ (20 * self.ESCALA_TUBARAO)/2)
		posAguaVivaBoca.append (posTubarao[1])
		posAguaVivaBoca.append (posTubarao[2]+ (23 * self.ESCALA_TUBARAO)/2)

		posBatida= list ()
		posBatida.append (posAguaViva[0] + (4 * self.ESCALA_AGUA_VIVA)/2)
		posBatida.append (posAguaViva[1])
		posBatida.append (posAguaViva[2] + (4 * self.ESCALA_AGUA_VIVA)/2)

		posFugaPeixe= list ()
		posFugaPeixe.append (posTubarao[0] * 3)
		posFugaPeixe.append (posTubarao[1])
		posFugaPeixe.append ((self.animais[0].esqueleto.pos[2] - self.animais[2].esqueleto.pos[2])/2)

		posFinalPeixe= list ()
		posFinalPeixe.append (posTubarao[0] * 19)
		posFinalPeixe.append (posTubarao[1])
		posFinalPeixe.append ((self.animais[0].esqueleto.pos[2] - self.animais[2].esqueleto.pos[2])/2)

		pos1Peixe= list ()
		pos1Peixe.append (posTubarao[0])
		pos1Peixe.append (posTubarao[1])
		pos1Peixe.append (self.animais[0].esqueleto.pos[2])


		self.baterAguaViva (posBatida)
		self.aguaVivaIndoBocaTubarao (posAguaVivaBoca)

		# vira para fugir
		self.animais[0].girar (30, Eixo.EIXO_Y)
		rate (self.taxa)

		# faz uma graca
		self.fazerGraca ()

		self.peixeFugir (pos1Peixe, posFugaPeixe)

		self.tubaraoCuspirAguaViva (posAguaVivaBoca, posAguaViva)

		self.animais[0].setVelocidade (3)
		self.animais[0].nadarPara (posFinalPeixe)

if __name__ == "__main__":
	mar= Mar ()
	mar.popular ()

	# so para preparar a gravacao
	rate (0.10)
	mar.fugirTubarao ()

	#mar.nadarAleatoriamente ()


# fim
