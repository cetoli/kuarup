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

	taxa= 5
	QTD_PASSOS_CURVA_ALEATORIA= 6
	QTD_PASSOS_RETA= 2
	RAIO_CURVA= 0.5

	ESCALA_TUBARAO= 0.5
	ESCALA_AGUA_VIVA= 1

	def __init__ (self):
		self.cenario= display (title='Oceano',width=700, height=500,center= (0.5,0,0),x=0, y=0, background=color.blue)
		#self.cenario= display (title='Oceano',width=150, height=150,center= (0.5,0,0),x=0, y=0, background=color.blue)
		#self.cenario.autoscale= 1
		#self.cenario.scale= (0.8,0.8,1.5)
		#self.cenario.scale= (1.5,1.5,1.5)
   		#self.cenario.x, self.cenario.y =0,0
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
		self.animais.append (aguaViva)

	   	tubarao= Tubarao(escala= self.ESCALA_TUBARAO, axis=(1,0,1), pos= (-1, 1,-5))
	   	self.animais.append (tubarao)

	def getQtdAnimais (self):
		return self.animais.__len__();

	def getAnimal (self, pos):
		return self.animais.__getitem__(pos)

	"""
		Premissas:
		pos da batida= (10, 5, 6) => 		posBatida.append (posAguaViva[0] + (4 * self.ESCALA_AGUA_VIVA)/2)
											posBatida.append (posAguaViva[1])
											posBatida.append (posAguaViva[2] + (4 * self.ESCALA_AGUA_VIVA)/2)



	"""
	def fugirTubarao (self):
		posTubarao= self.animais[2].esqueleto.pos
		posAguaViva= self.animais[1].esqueleto.pos

		# posTubarao e a posicao final da agua viva apos ser comida pelo tubarao
		posFinalAguaViva= list ()
		posFinalAguaViva.append (posTubarao[0]+ (20 * self.ESCALA_TUBARAO)/2)
		posFinalAguaViva.append (posTubarao[1])
		posFinalAguaViva.append (posTubarao[2]+ (23 * self.ESCALA_TUBARAO)/2)

		posBatida= list ()
		posBatida.append (posAguaViva[0] + (4 * self.ESCALA_AGUA_VIVA)/2)
		posBatida.append (posAguaViva[1])
		posBatida.append (posAguaViva[2] + (4 * self.ESCALA_AGUA_VIVA)/2)

		posFinalPeixe= list ()
		posFinalPeixe.append (posTubarao[0]/2)
		posFinalPeixe.append (posTubarao[1])
		posFinalPeixe.append (self.animais[0].esqueleto.pos[2] - self.animais[2].esqueleto.pos[2])

		pos1Peixe= list ()
		pos1Peixe.append (posTubarao[0])
		pos1Peixe.append (posTubarao[1])
		pos1Peixe.append (self.animais[0].esqueleto.pos[2])

		#print "pos peixe %f %f %f\n" % (self.animais[0].esqueleto.pos[0], self.animais[0].esqueleto.pos[1], self.animais[0].esqueleto.pos[2])
		#print "pos agua viva %f %f %f\n" % (self.animais[1].esqueleto.pos[0], self.animais[1].esqueleto.pos[1], self.animais[1].esqueleto.pos[2])
		print "pos batida %f %f %f\n" % (posBatida[0], posBatida[1], posBatida[2])

		# Vai de encontro com a agua viva
		self.animais[0].nadarPara (posBatida)

		print "pos FINAL do peixe %f %f %f\n" % (self.animais[0].esqueleto.pos[0], self.animais[0].esqueleto.pos[1], self.animais[0].esqueleto.pos[2])

		# seta a velocidade para 2X maior que o normal
		self.animais[1].setVelocidadeNado (1.3)

		#print "pos agua viva antes %f %f %f\n" % (self.animais[1].esqueleto.pos[0], self.animais[1].esqueleto.pos[1], self.animais[1].esqueleto.pos[2])

		# Voa para a boca do tubarao
		self.animais[1].nadarPara (posFinalAguaViva)

		print "agua viva na boca \n"

		# vira para fugir
		self.animais[0].girar (7, Eixo.EIXO_Y)
		rate (self.taxa)

		# faz uma graca
		"""
		cont= 0
		listaAngulo= [0.5, 359.5]

		while cont < 10:
			if cont % 2 == 0:
				angulo= listaAngulo[0]
				eixo= (0,0,1)
			else:
				angulo= listaAngulo[1]
				eixo= (0,0,-1)

			print "angulo %f\n" % (angulo)

			self.animais[0].girar (angulo, eixo)
			rate (self.taxa)
			cont+= 1
		"""
		print "Fugir!\n"
		# foge
		self.animais[0].nadarPara (pos1Peixe)
		#self.animais[0].girar (350, Eixo.EIXO_Y)
		rate (self.taxa)
		print "final\n"
		self.animais[0].nadarPara (posFinalPeixe)




		#print "pos final AV %f %f %f\n" % (posFinalAguaViva[0], posFinalAguaViva[1], posFinalAguaViva[2])
		#print "pos agua viva depois %f %f %f\n" % (self.animais[1].esqueleto.pos[0], self.animais[1].esqueleto.pos[1], self.animais[1].esqueleto.pos[2])

		print "pos final peixe %f %f %f\n" % (self.animais[0].esqueleto.pos[0], self.animais[0].esqueleto.pos[1], self.animais[0].esqueleto.pos[2])

		print "\n------\nTUBARAO %f %f %f\n" % (self.animais[2].esqueleto.pos[0], self.animais[2].esqueleto.pos[1], self.animais[2].esqueleto.pos[2])



		"""
	def nadarDireita (self, animal):
		movimento= 0
		# se movimenta em um sentido
		while movimento < self.QTD_PASSOS_RETA:
			incremento= Ponto (1, 0, 0)
			animal.nadar (incremento)
			rate (self.taxa)

			movimento+= 1

	def virarParaEsquerda (self, animal):
		incremento= list ()
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 1) * (5/100), 0, 0))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 2) * (5/100), 0, 2/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 3) * (5/100), 0, 3/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 4) * (5/100), 0, -3/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 5) * (5/100), 0, -1/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 6) * (5/100), 0, -1/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))

		eixo= Eixo ()
		angulo= eixo.converterGrausRadiano (330)

		movimento= 0
		while movimento < self.QTD_PASSOS_CURVA_ALEATORIA:
			#incremento= Ponto (1/6, 0, 0)
			animal.nadar (incremento[movimento])
			animal.girar (angulo, Eixo.EIXO_Y)
			rate (self.taxa)

			movimento+= 1

	def nadarEsquerda (self, animal):
		movimento= 0
		while movimento < self.QTD_PASSOS_RETA:
			incremento= Ponto (-1, 0, 0)
			animal.nadar (incremento)
			rate (self.taxa)

			movimento+= 1

	def virarParaDireita (self, animal):
		incremento= list ()
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 1) * (- 5/100), 0, 0))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 2) * (- 5/100), 0, 2/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 3) * (- 5/100), 0, 3/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 4) * (- 5/100), 0, -3/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 5) * (- 5/100), 0, -1/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))
		incremento.append (Ponto ( (self.QTD_PASSOS_CURVA_ALEATORIA - 6) * (- 5/100), 0, -1/self.QTD_PASSOS_CURVA_ALEATORIA * self.RAIO_CURVA))

		eixo= Eixo ()
		angulo= eixo.converterGrausRadiano (30)

		movimento= 0
		while movimento < 6:
			#incremento= Ponto (-1/6, 0, 0)
			animal.nadar (incremento[movimento])
			animal.girar (angulo, Eixo.EIXO_Y)
			rate (self.taxa)

			movimento+= 1


	def nadarAleatoriamente (self):
		qtd= self.getQtdAnimais ()
		print "pos= %d\n" % (qtd)

		animal= self.getAnimal (0)
		print "esqueleto inicial: %f | %f  | %f\n" % (animal.esqueleto.pos[0], animal.esqueleto.pos[1], animal.esqueleto.pos[2])

		# inicializa dando um espaco de diferenca
		cont= 0
		while cont < qtd:
			animal= self.getAnimal (cont)
			incremento= Ponto (1, 0, 0)
			animal.nadar (incremento)
			rate (self.taxa)
			cont+= 1


		while 1:
			cont= 0
			while cont < qtd:
				animal= self.getAnimal (cont)

				print "---------- RETO 1 ----------- \n"
				self.nadarDireita (animal)


				print "---------- Girando 1 ----------- \n"
				# vira o animal
				self.virarParaEsquerda (animal)

				print "---------- RETO 2 ----------- \n"
				self.nadarEsquerda (animal)



				print "---------- Girando 2 ----------- \n"
				# vira o animal
				self.virarParaDireita (animal)

				cont+= 1

			#break

if __name__ == "__main__":
	mar= Mar ()
	mar.popular ()

	#mar.nadarAleatoriamente ()
            """

if __name__ == "__main__":
	mar= Mar ()
	mar.popular ()
	rate (0.15)
	mar.fugirTubarao ()

	#mar.nadarAleatoriamente ()


# fim
