from visual import *
from piraporangatuOby import *
from goal import *
from field import *
from ball import *
from commands import *
import Image
#import ImageGrab


class Cenario:

    
    def __init__(self):
        self.scene = display(title = "Piraporangatu", width=250, height=250, center= (0,0,0), x=0, y=0)
        self.scene.x, self.scene.y = 0, 0
        self.scene.select()
        self.scene.autoscale = 0

    def filmando(self):
        " só funciona no linux, e requer a instalação do ImageMagick"
        if(self.frame>0 and self.frame%10==0):
            tmp = getoutput('/usr/sbin/screencapture gif/Piraporangatu.%04d.png' % self.frame)


    def principal(self):
        goal = Goal(pos = (0,0,-30), scale = 2.5)
        field = Field(pos = (0,-3.25,0), scale = 15)
        ball = Ball(pos=(0,-0.35,35), scale = 4.5)
        fish = Fish(pos=(0,0,40), axis = (0,0,-1))

        
        self.frame = 0
        self.scene.autoscale = 0
        ## Altera posição da camera
        self.scene.forward = (0,-2.5,-4)
        self.scene.center = fish.esqueleto.pos

        while 1:

#            if(self.frame>0 and self.frame%10==0):
#                im = ImageGrab.grab((24,30,250-4,250-4))
#                fn = "gif/Kuarup"+str(self.frame)+".gif"
#                im.save(fn)                
            rate(30)
            if self.frame <= 1760:
                self.filmando()
            ## Inicia os movimentos
            if 0 <= self.frame <= 400:
                fish.stop()
            if self.frame == 100:
                ## Inicio
                start = label(pos=(0,-1,fish.esqueleto.pos[2] - 5), height = 20, text='Start')
            if self.frame == 250:
                ## Some com o label
                start.visible = 0
            if 400 < self.frame <= 450:
                fish.turn(angle=pi/195, axis=(0,1,0))
            if 500 < self.frame <= 515:
                fish.swim(direction='forward', speed = 0.2)
            if 520 < self.frame <= 620:
                fish.turn(angle=pi/195, axis=(0,-1,0))
            if 620 < self.frame <= 670:
                ball.roll(axis=fish.esqueleto.axis, speed = 0.2)
                fish.swim(direction='forward', speed = 0.2)
            if 670 < self.frame <= 710:
                fish.turn(angle=pi/195, axis=(0,-1,0))
            if 710 < self.frame <= 730:
                fish.swim(direction='forward', speed = 0.2)
            if 730 < self.frame <= 830:
                ball.roll(axis=(0,0,-1), speed = 0.025)
                fish.turn(angle=pi/195, axis=(0,1,0))
            if 830 < self.frame <= 840:
                fish.swim(direction='forward', speed = 0.2)
            if 840 < self.frame <= 860:
                ball.roll(axis=(0,0,-1), speed = 0.025)
                fish.turn(angle=pi/195, axis=(0,1,0))
            if 860 < self.frame <= 960:
                ball.roll(axis=fish.esqueleto.axis, speed = 0.2)
                fish.swim(direction='forward', speed = 0.2)
            if 960 < self.frame <= 1040:
                fish.turn(angle=pi/195, axis=(0,-1,0))
            if 1040 < self.frame <= 1050:
                fish.swim(direction='forward', speed = 0.2)
            if 1050 < self.frame <= 1160:
                ball.roll(axis=(-2,0,-1), speed = 0.005)
                fish.turn(angle=pi/195, axis=(0,1,0))
            if 1160 < self.frame <= 1210:
                ball.roll(axis=fish.esqueleto.axis, speed = 0.2)
                fish.swim(direction='forward', speed = 0.2)
            if 1210 < self.frame <= 1250:
                fish.turn(angle=pi/195, axis=(0,1,0))
            if 1250 < self.frame <= 1260:
                ball.roll(axis=(0,0,-1), speed = 0.02)
                fish.swim(direction='forward', speed = 0.2)
            if 1260 < self.frame <= 1330:
                ball.roll(axis=(0,0,-1), speed = 0.008)
                fish.turn(angle=pi/195, axis=(0,-1,0))
            if 1330 < self.frame <= 1410:
                fish.turn(angle=pi/195, axis=(0,1,0))
            if 1410 < self.frame <= 1425:
                fish.swim(direction='forward', speed = 0.2)
            if 1425 < self.frame <= 1555:
                ball.roll(axis=(0,0,-1), speed = 0.003)
                fish.turn(angle=pi/195, axis=(0,-1,0))
            if 1555 < self.frame <= 1730:
                ball.roll(axis=fish.esqueleto.axis, speed = 0.2)
                fish.swim(direction='forward', speed = 0.2)
            if self.frame == 1730:
                ## Goal
                goal = label(pos=(0,-1,ball.esqueleto.pos[2] - 10), height = 40, text='GOAL!!!', color=(1,0,0))
            if self.frame == 1760:
                print 'Converting files (%s).' % ctime(time())
                tmp = getoutput('/sw/bin/convert -delay 01 -loop 0 -crop 250x250+5+5 gif/Piraporangatu.*.png animated.piraporangatu.gif')
                print 'File written to "animated.pendulum.gif".  If you like it, you can delete the PNG files'
                getoutput('rm gif/Piraporangatu.*.png ')

            
            


            self.scene.center = fish.esqueleto.pos
            self.frame += 1

            

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
