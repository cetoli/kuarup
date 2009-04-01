from visual import *
from piraporangatuOby import *
from tubarao_tupinamba import *
from submarino_ticuna import *
import Image
import ImageGrab


class Cenario:

    
    def __init__(self):
        self.scene = display(title = "Movimentos Piraporangatu", width=500, height=500, center= (0,0,0), x=0, y=0)
        self.scene.x, self.scene.y = 0, 0
        self.scene.select()
        self.scene.autoscale = 0

    def principal(self):
        fish0 = Fish(pos=(15,0,0))
        fish1 = Fish(pos=(15,4,0))
        fish2 = Fish(pos=(15,-4,0))
        fish3 = Fish(pos=(15,0,4))
        fish4 = Fish(pos=(15,0,-4))
        submarino = Submarino(escala=4, axis=(1,0,0), pos= (-20,0,0))
        tubarao = Tubarao(escala=0.5, axis=(-1,0,0), pos=(100,1,0))

        self.frame = 0
        self.scene.autoscale = 0
        ## Altera posição da camera
        self.scene.forward = (-3,-1,-1)

        while 1:

            if(self.frame>0 and self.frame%10==0):
                im = ImageGrab.grab((24,30,250-4,250-4))
                fn = "gif/Kuarup"+str(self.frame)+".gif"
                im.save(fn)                
            rate(30)
            ## Aponta a camera em direção ao cardume
            self.scene.center = (fish1.esqueleto.pos[0],0,fish1.esqueleto.pos[2])

            if self.frame == 450:
                ## Altera posição da camera
                self.scene.forward = (-1,-0.25,0)
            if self.frame == 600:
                ## Altera posição da camera
                self.scene.forward = (3,-1,-1)
            if 0 <= self.frame <= 900:
                ## Cardume passeando
                fish0.swim(direction='forward', speed = 0.1)
                fish1.swim(direction='forward', speed = 0.1)
                fish2.swim(direction='forward', speed = 0.1)
                fish3.swim(direction='forward', speed = 0.1)
                fish4.swim(direction='forward', speed = 0.1)
            if self.frame == 700:
                ## Desvia do tubarão, um morre!
                fish1.turn(angle=pi/4, axis=(0,0,1))
                fish2.turn(angle=pi/4, axis=(0,0,-1))
                fish3.turn(angle=pi/4, axis=(0,-1,0))
                fish4.turn(angle=pi/4, axis=(0,1,0))
            if self.frame == 800:
                ## Retorna a formação de cardume
                fish1.turn(angle=pi/2, axis=(0,0,-1))
                fish2.turn(angle=pi/2, axis=(0,0,1))
                fish3.turn(angle=pi/2, axis=(0,1,0))
                fish4.turn(angle=pi/2, axis=(0,-1,0))
            if self.frame == 900:
                ## Retorna a formação de cardume
                fish1.turn(angle=pi/4, axis=(0,0,1))
                fish2.turn(angle=pi/4, axis=(0,0,-1))
                fish3.turn(angle=pi/4, axis=(0,-1,0))
                fish4.turn(angle=pi/4, axis=(0,1,0))
            if 700 < self.frame < 1100:
                ## Acelera o cardume
                fish1.swim(direction='forward', speed = 0.2)
                fish2.swim(direction='forward', speed = 0.2)
                fish3.swim(direction='forward', speed = 0.2)
                fish4.swim(direction='forward', speed = 0.2)
            if 1100 <= self.frame <= 1300:
                ## Para o cardume e olha para tras
                fish1.turn(angle=pi/195, axis=(0,1,0))
                fish2.turn(angle=pi/195, axis=(0,-1,0))
                fish3.turn(angle=pi/195, axis=(0,-1,0))
                fish4.turn(angle=pi/195, axis=(0,1,0))
            if 1300 < self.frame <= 1600:
                ## Fica parado olhando para tras
                fish1.stop()
                fish2.stop()
                fish3.stop()
                fish4.stop()


            self.frame += 1

            

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
