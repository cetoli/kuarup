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
    def __init__(self, pos=(0,0,0), scale=1., axis=[1,0,0]):
        self.esqueleto = frame()
        self.draw(esqueleto=self.esqueleto, pos=pos, scale=scale, axis=axis)

    ## Desenha o ser marinho
    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0]):
        None

class Eye:
    def __init__(self, pos=(0,0,0), axis=[1.,0.,0.], frame=frame(), scale=1., color=color.black):
        self.frame = frame
        self.globe = sphere(pos=pos, radius=(1.*scale), frame=self.frame)
        self.iris = sphere(pos=(pos[0]+(0.25*scale), pos[1]+(0.0625*axis[1]*scale), pos[2]+(0.0625*axis[2]*scale)), radius=(0.8*scale), color=color, material=materials.emissive, frame=self.frame)
        
        

