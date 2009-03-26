from visual import * 
# Eh necessario instalar o PIL
import Image
from tartaruga_pirapongatu import *
from random import random, randrange
from renderable import *
from mathHelper import *
from caracol import *
from marine import *
from animator import FishAnimator, CaracolAnimator, TurtleAnimator

class Eye():
    """Constroi um olho"""
    def __init__(self, frame, pos, radius, formColor, scale):
        self.pos = pos*scale
        self.radius = radius * scale
        self.color = formColor

        posPupila = self.pos + vector(0,0,self.pos.z*0.1)
        radiusPupila = self.radius*0.8

        self.globo = sphere(frame=frame, pos=self.pos,radius=self.radius,color=self.color)
        posPupila = self.pos + vector(0,0,self.pos.z*0.1)
        self.pupila = sphere(frame=frame, pos=posPupila,radius=self.radius*0.8,color=color.black)
        

class FishBody():
    """Constroi o corpo do peixinho"""
    def __init__(self, frame, pos, size, radius, scale, formColor):
        self.size = size * scale
        self.scale = scale
        self.radius = radius * scale
        self.pos = pos*scale
        self.color = formColor

        self.bodyCentral = ellipsoid(frame=frame,size=self.size,pos=self.pos,color=self.color)
        posBodySphere = self.pos + vector(-1,-1,1.3) * scale
        
        self.bodyPart1 = sphere(frame=frame, pos=posBodySphere,radius=self.radius,color=self.color)

        posBodySphere2 = self.pos + vector(-1,-1,-1.3) * scale
        self.bodyPart2 = sphere(frame=frame, pos=posBodySphere2,radius=self.radius,color=self.color)

class Fin():
    """Representa uma barbatana do peixinho"""
    def __init__(self, frame, pos, size, scale, formColor=color.orange):
        self.pos = pos*scale
        self.size = size * scale
        self.color = formColor

        self.fin = pyramid(frame=frame,pos=self.pos, size=self.size, color=self.color)

        self.setOriginalAxis(self.fin.axis)
        
        self.sentido = True
        
    def setOriginalAxis(self, axis):
        self.originalAxis = array(self.fin.axis)
        self.originalAxis = vector(self.originalAxis[0],self.originalAxis[1],self.originalAxis[2])

    def shake(self, speed, axis, amplitude):
        diffAngle = self.originalAxis.diff_angle(self.fin.axis)

        if(diffAngle > amplitude/2):
            self.sentido = not(self.sentido)

        if self.sentido:
            self.fin.rotate(angle = 0.005 * speed, axis=axis,  origin = axis*2)
        else:
            self.fin.rotate(angle = -0.005 * speed, axis=axis, origin = axis*2)


class FishMouth():
    """Representa a boca do peixinho"""
    def __init__(self, frame, pos, axis, thickness, radius, scale, formColor=color.white):
        self.pos = pos*scale
        self.axis = axis
        self.color = formColor
        self.thickness = thickness
        self.radius = radius
        self.scale = scale

        self.upLip = ring(frame=frame,pos=self.pos, axis=self.axis, radius=self.radius * self.scale, thickness=self.thickness * self.scale, color=self.color)
        self.downLip = ring(frame=frame,pos=self.pos, axis=self.axis, radius=self.radius * self.scale, thickness=self.thickness * self.scale, color=self.color)
        self.downLip.rotate(frame=frame, angle=THETA_90, axis=(0,0,1))
        self.tongue = sphere(frame=frame, pos=self.pos, radius=1.5 * self.scale, color=color.red)

class Fish(Marine):
    """"Representa um peixinho"""
    def render(self):
        self.body = FishBody(frame=self.frame, pos=vector(0,0,0), size=vector(25,10,8), radius=3.5, scale=self.scale, formColor=color.orange)
        self.rightEye = Eye(frame=self.frame, pos=vector(-7,0,3), radius=1, formColor=color.white, scale=self.scale)
        self.leftEye  = Eye(frame=self.frame, pos=vector(-7,0,-3), radius=1, formColor=color.white, scale=self.scale)
        
        self.mouth = FishMouth(self.frame, vector(-11,0,0), (1,2,0), 0.6, 1.3, self.scale, color.white)

        self.dorsalFin = Fin(frame=self.frame, pos=vector(0.3,2,0), size=vector(7,6,1.5), scale=self.scale)
        self.dorsalFin2 = Fin(frame=self.frame, pos=vector(-1.7,2,0), size=vector(7,6,1.5), scale=self.scale)
        self.dorsalFin3 = Fin(frame=self.frame, pos=vector(-3.7,2,0), size=vector(7,6,1.5), scale=self.scale)

        self.caudalFin = Fin(frame=self.frame, pos=vector(17,0,0), size=vector(7,14,0.7), scale=self.scale)

        self.pelvicFin = Fin(frame=self.frame, pos=vector(9,-5.8,0), size=vector(4,0.7,6), scale=self.scale)

        self.leftPectoralFin = Fin(frame=self.frame, pos=vector(-1.5,-4,8), size=vector(7,0.7,6), scale=self.scale)
        self.rightPectoralFin = Fin(frame=self.frame, pos=vector(-1.5,-4,-8), size=vector(7,0.7,6), scale=self.scale)
        
        self.adjustFins()

    def adjustFins(self):
        """Ajusta as nadadeiras"""
        self.dorsalFin.fin.rotate(angle=THETA_45, axis=(0,0,1))
        self.dorsalFin2.fin.rotate(angle=THETA_45, axis=(0,0,1))
        self.dorsalFin3.fin.rotate(angle=THETA_45, axis=(0,0,1))

        self.caudalFin.fin.rotate(angle=-THETA_90, axis=(0,0,1))
        self.caudalFin.fin.rotate(angle=-THETA_90, axis=(0,0,1))
        self.caudalFin.setOriginalAxis(self.caudalFin.fin.axis)

        self.pelvicFin.fin.rotate(angle=-math.pi, axis=(0,0,1))
        self.pelvicFin.fin.rotate(angle=-THETA_90, axis=(1,0,0))
        self.pelvicFin.fin.rotate(angle=-math.pi/5, axis=(0,0,1))

        self.leftPectoralFin.fin.rotate(angle=THETA_90, axis=(0,1,0))
        self.leftPectoralFin.fin.rotate(angle=THETA_30, axis=(1,0,0))
        self.leftPectoralFin.setOriginalAxis(self.leftPectoralFin.fin.axis)

        self.rightPectoralFin.fin.rotate(angle=-THETA_90, axis=(0,1,0))
        self.rightPectoralFin.fin.rotate(angle=-THETA_30, axis=(1,0,0))
        self.rightPectoralFin.setOriginalAxis(self.rightPectoralFin.fin.axis)

    def shakeCaudalFin(self, speed):
        self.caudalFin.shake(speed=speed, axis=Y_AXIS, amplitude=math.pi/6)
    
    def shakeLateralFins(self, speed):
        self.leftPectoralFin.shake(speed,  X_AXIS, amplitude=math.pi/10)
        self.rightPectoralFin.shake(speed, X_AXIS, amplitude=math.pi/10)