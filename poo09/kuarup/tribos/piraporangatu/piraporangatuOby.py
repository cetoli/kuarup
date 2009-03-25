from visual import *
from marine_life import *
import visual as vs
import Image

class Fish(Marine_life):
    pos = (0,0,0)

    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0]):
        l = 4.0 * scale
        h = 3.0 * scale
        w = 2.0 * scale
        ## Body
        self.body = ellipsoid(pos=(0,0,0), length=l, height=h, width=w, material=self.get_texture(file_name="fish_skin.jpg", width=256, height=256), frame=esqueleto)

        ## Eyes
        self.right_eye = Eye(pos=(3.25*scale/2,0.5*scale/2,0.6*scale/2), scale=0.25*scale, axis=[1.,1.,1.9], frame=esqueleto)
        self.left_eye = Eye(pos=(3.25*scale/2,0.5*scale/2,-0.6*scale/2), scale=0.25*scale, axis=[1.,1.,-1.9], frame=esqueleto)
        ## Mouth
        self.upperlip = ellipsoid(pos=(3.88*scale/2,-0.4*scale/2,0.), length=0.1*scale, height=0.15*scale, width=0.5*scale, color=color.red, frame=esqueleto)
        self.lowerlip = ellipsoid(pos=(3.85*scale/2,-0.6*scale/2,0.), length=0.1*scale, height=0.15*scale, width=0.5*scale, color=color.red, frame=esqueleto)
        self.rightlip = ellipsoid(pos=(3.83*scale/2,-0.45*scale/2,0.46*scale/2), length=0.1*scale, height=0.1*scale, width=0.05*scale, color=color.red, frame=esqueleto)
        self.leftlip = ellipsoid(pos=(3.83*scale/2,-0.45*scale/2,-0.46*scale/2), length=0.1*scale, height=0.1*scale, width=0.05*scale, color=color.red, frame=esqueleto)

        ## Tail
        self.tail = Fin(pos=(-8.*scale/2,0.,0.), size=(3*scale,4*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", width=256, height=256), frame=esqueleto)

        # Pelvic Fin:
        self.pelvic_fin0 = pyramid(pos=(-1.*scale/2,-2.2*scale/2,0.), size=(1*scale,2*scale,0.1*scale), axis=(1,-0.5,0), color=color.green, opacity=(0.75),material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.pelvic_fin1 = pyramid(pos=(-1.5*scale/2,-2*scale/2,0.), size=(1*scale,2*scale,0.1*scale), axis=(1,-0.5,0), color=color.green, opacity=(0.75),material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.pelvic_fin2 = pyramid(pos=(-2*scale/2,-1.8*scale/2,0.), size=(1*scale,2*scale,0.1*scale), axis=(1,-0.5,0), color=color.green, opacity=(0.75),material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)

        # Dorsal Fin:
        self.dorsal_fin0 = pyramid(pos=(-3.5*scale/2,0.8*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin1 = pyramid(pos=(-3.*scale/2,1.4*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin2 = pyramid(pos=(-2.5*scale/2,1.6*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin3 = pyramid(pos=(-2.*scale/2,1.8*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin4 = pyramid(pos=(-1.5*scale/2,2.*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin5 = pyramid(pos=(-1.*scale/2,2.2*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin6 = pyramid(pos=(-0.5*scale/2,2.4*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin7 = pyramid(pos=(0,2.4*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin8 = pyramid(pos=(0.2*scale/2,2.4*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, axis=(1,-0.25,0), opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin9 = pyramid(pos=(0.6*scale/2,2.2*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, axis=(1,-0.4,0), opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)
        self.dorsal_fin10 = pyramid(pos=(1.*scale/2,1.8*scale/2,0), size=(1.*scale,2.*scale,0.1*scale), color=color.green, axis=(1,-0.5,0), opacity=(0.75), material=self.get_texture(file_name="fish_skin.jpg", mapping_type="rectangular", width=64, height=64), frame=esqueleto)

        # Pectoral Fin:
        self.right_pectoral_fin = Fin(pos=(0.5*scale/2,0,2.7*scale/2), size=(0.75*scale,1.5*scale,0.1*scale), axis=(1,0,-1), color=color.green, opacity=(0.6), material=self.get_texture(file_name="fish_skin.jpg", width=256, height=256), frame=esqueleto)
        self.left_pectoral_fin = Fin(pos=(0.5*scale/2,0,-2.7*scale/2), size=(0.75*scale,1.5*scale,0.1*scale), axis=(1,0,1), color=color.green, opacity=(0.6), material=self.get_texture(file_name="fish_skin.jpg", width=256, height=256), frame=esqueleto)

        esqueleto.axis = axis
        esqueleto.pos = pos


    def swim(self, direction, amplitude = pi/12, speed = 0.05):
        ## Moves the tail and pactoral fins
        self.tail.shake(amplitude=amplitude, speed=speed)
        self.right_pectoral_fin.shake(amplitude=amplitude, speed=speed)
        self.left_pectoral_fin.shake(amplitude=amplitude, speed=speed)
        ## Move forward or backward
        posIncrement = 1. * speed
        if(direction == 'backward'):
            self.esqueleto.pos -= posIncrement * norm(self.esqueleto.axis)
        elif (direction == 'forward'):
            self.esqueleto.pos += posIncrement * norm(self.esqueleto.axis)


    def turn(self, angle, axis, amplitude = pi/12, speed = 0.05):
        ## Moves the tail and pactoral fins
        self.tail.shake(amplitude=amplitude, speed=speed)
        self.right_pectoral_fin.shake(amplitude=amplitude, speed=speed)
        self.left_pectoral_fin.shake(amplitude=amplitude, speed=speed)
        ## Turn angle DEGREES in axis DIRECTION
        self.esqueleto.rotate(angle=angle, axis=axis)
        

    def stop(self, amplitude = pi/12, speed = 0.01):
        ## Moves the tail and pactoral fins
        self.tail.shake(amplitude=amplitude, speed=speed)
        self.right_pectoral_fin.shake(amplitude=amplitude, speed=speed)
        self.left_pectoral_fin.shake(amplitude=amplitude, speed=speed)

    def look(self):
        pass

    def openMouth(self):
        pass

    def closeMouth(self):
        pass




class Fin():
    def __init__(self, pos, size, color, opacity, material, frame, axis = (1,0,0), sentido = True):
        self.fin = pyramid(pos=pos, size=size, color=color, opacity=opacity, material=material, frame=frame, axis=axis)

        self.setOriginalAxis(self.fin.axis)
        self.sentido = sentido

                
    def setOriginalAxis(self, axis):
        self.originalAxis = array(self.fin.axis)
        self.originalAxis = vector(self.originalAxis[0],self.originalAxis[1],self.originalAxis[2])


    def shake(self, amplitude, speed, axis = vector(0,1,0)):
        diffAngle = self.originalAxis.diff_angle(self.fin.axis)
        self

        if(diffAngle > amplitude/2.):
            self.sentido = not(self.sentido)

        if self.sentido:
            self.fin.rotate(angle = amplitude * speed, axis = axis, origin = axis*2)
        else:
            self.fin.rotate(angle = -amplitude * speed, axis = axis, origin = axis*2)

        


#inicio do programa:
        
#vs.scene = vs.display()
#vs.scene.title = "Piraporangatu Oby"
#vs.scene.background = color.blue
#peixe = Fish()
