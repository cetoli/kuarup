from visual import *
import visual as vs
import Image

class Obj_base:

    def __init__(self):
        None

    ## Define a textura do objeto
    def get_texture(self, file_name, width, height, mapping_type="spherical"):

        im = Image.open(file_name)

        im = im.resize((width,height), Image.ANTIALIAS)

        return materials.texture(data=im, mapping=mapping_type, interpolate=False)

class Marine_life(Obj_base):

    def __init__(self, pos=(0,0,0), scale=1., axis=[1,0,0], posFrame=(0,0,0)):
        self.esqueleto = frame(pos=posFrame)
        self.draw(esqueleto=self.esqueleto, pos=pos, scale=scale, axis=axis)

    def getPosition(self):
        return self.esqueleto.pos

    def setPosition(self, newPos):
        self.esqueleto.pos = newPos

    ## Desenha o ser marinho
    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0]):
        None

    def swin(self, direction='left', speed=10):
        """docstring for swin"""
        posIncrement = 0.004 * speed

        if(direction == 'left'):
            self.esqueleto.pos -= posIncrement * norm(self.esqueleto.axis)
        elif (direction == 'rigth'):
            self.esqueleto.pos += posIncrement * norm(self.esqueleto.axis)

class Sea_turtle(Marine_life):

    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0]):

        ## Body

        self.casco1 = ellipsoid(pos=pos, length=5.*scale, height=0.7*scale, width=4.*scale, axis=(1,0.07,0), color=(0.4,0.4,0.4), frame=esqueleto)

        self.casco2 = ellipsoid(pos=(0,0.1,0), length=4.8*scale, height=1.5*scale, width=3.8*scale, axis=(1,0.07,0), color=(0.4,0.4,0.4),  frame=esqueleto)

        self.body = ellipsoid(pos=(0.10*scale/2,-0.65*scale/2,0), length=4.25*scale, height=0.8*scale, width=3.*scale, material=materials.wood, frame=esqueleto)

        self.tail = pyramid(pos=(-3.*scale/2,-0.8*scale/2,0), axis=(-1,-0.15,0), size=(1.1*scale,0.1*scale,0.8*scale), color=(0,0.15,0), frame=esqueleto)

        self.neck = cylinder(pos=(3.9*scale/2,-0.7*scale/2,0), radius=0.2*scale, axis=(0.5*scale,0.04,0), color=(0,0.15,0), frame=esqueleto)

        self.head = ellipsoid(pos=(5.5*scale/2,-0.6*scale/2,0), length=0.8*scale, height=0.65*scale, width=0.65*scale, axis=(0.5,0.04,0), color=(0,0.15,0), frame=esqueleto)

        self.front_right1 = ellipsoid(pos=(4.3*scale/2,-0.9*scale/2,1.8*scale/2), length=1.25*scale, height=0.1*scale, width=0.6*scale, axis=(1.25,-0.8,1), color=(0,0.15,0), frame=esqueleto)

        self.front_right1.rotate(angle=-pi/30, axis=(1,0,1))

        self.front_right2 = ellipsoid(pos=(4.2*scale/2,-1.1*scale/2,4.*scale/2), length=2.*scale, height=0.1*scale, width=0.5*scale, axis=(0.6,-0.2,-1), color=(0,0.15,0), frame=esqueleto)

        self.front_right2.rotate(angle=pi/7.5, axis=(0.6,-0.2,-1))

        self.front_left1 = ellipsoid(pos=(4.3*scale/2,-0.9*scale/2,-1.8*scale/2), length=1.25*scale, height=0.1*scale, width=0.6*scale, axis=(1.25,-0.8,-1), color=(0,0.15,0), frame=esqueleto)

        self.front_left1.rotate(angle=-pi/30, axis=(1,0,-1))

        self.front_left2 = ellipsoid(pos=(4.2*scale/2,-1.1*scale/2,-4.*scale/2), length=2.*scale, height=0.1*scale, width=0.5*scale, axis=(0.6,-0.2,1), color=(0,0.15,0), frame=esqueleto)

        self.front_left2.rotate(angle=-pi/7.5, axis=(0.6,-0.2,1))

        self.rear_right = ellipsoid(pos=(-4.*scale/2,-1.7*scale/2,2.5*scale/2), length=3.*scale, height=0.1*scale, width=1.*scale, axis=(1.25,0.8,-1), color=(0,0.15,0), frame=esqueleto)

        self.rear_right.rotate(angle=pi/7.5, axis=(1.25,0.8,-1))

        self.rear_left = ellipsoid(pos=(-4.*scale/2,-1.7*scale/2,-2.5*scale/2), length=3.*scale, height=0.1*scale, width=1.*scale, axis=(1.25,0.8,1), color=(0,0.15,0), frame=esqueleto)

        self.rear_left.rotate(angle=-pi/7.5, axis=(1.25,0.8,1))

        ## Face

        self.right_eye = Eye(pos=(6.05*scale/2,-0.25*scale/2,0.3*scale/2), scale=0.075*scale, axis=[1,1,1.5], frame=esqueleto)

        self.left_eye = Eye(pos=(6.05*scale/2,-0.25*scale/2,-0.3*scale/2), scale=0.075*scale, axis=[1,1,-1.5], frame=esqueleto)

        self.upper_teeth = ellipsoid(pos=(5.85*scale/2,-0.7*scale/2,0),length=0.5*scale, height=0.05*scale, width=0.3*scale, axis=(1,0.1,0), material=materials.emissive, frame=esqueleto)

        self.lower_teeth = ellipsoid(pos=(5.85*scale/2,-0.7*scale/2,0),length=0.5*scale, height=0.05*scale, width=0.3*scale, axis=(1,-0.1,0), material=materials.emissive, frame=esqueleto)


    def nextStep(self):
        pass

class Eye:

    def __init__(self, pos=(0,0,0), axis=[1.,0.,0.], frame=frame(), scale=1., color=color.black):

        self.frame = frame

        self.globe = sphere(pos=pos, radius=(1.*scale), frame=self.frame)

        self.iris = sphere(pos=(pos[0]+(0.25*scale), pos[1]+(0.0625*axis[1]*scale), pos[2]+(0.0625*axis[2]*scale)), radius=(0.8*scale), color=color, material=materials.emissive, frame=self.frame)