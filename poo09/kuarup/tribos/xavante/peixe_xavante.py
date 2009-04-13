#!/usr/bin/python

from visual import *
import threading
import os


class Mesh:
    def desenha_triangulo (self, v1, v2, v3, color=color.white):
        v1 = vector(v1)
        v2 = vector(v2)
        v3 = vector(v3)

        try:
            normal = norm( cross(v2-v1, v3-v1) )
        except:
            normal = vector(0,0,0)
        for v in (v1, v2, v3):
            self.model.append ( pos=v, color=color, normal=normal )
        for v in (v1, v3, v2):
            self.model.append ( pos=v, color=color, normal=-normal )

    def grava_esqueleto (self):
        self.t = 0
        self.x_original = []
        pos = self.model.pos
        for i in range( len(pos) ):
            self.x_original.append (pos[i][0])

    def moveModel (self):
        pos = self.model.pos
        for i in range( len(pos) ):
            y = pos[i][2] / self.tamanho
            pos[i][0] = self.x_original[i] + self.tamanho * ( sin( y + self.t * 0.1) ) / 8.0
    
    def move (self, velocidade=1):
        self.moveModel()
        self.t += velocidade * pi/2
        
        # proxima parte talvez cause flashes
        if self.t >= 1000*pi:
            self.t -= 1000*pi


class Corpo (Mesh):

    def __init__ (self, frame=None, color=color.white, material=None, tamanho=1):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.model    = faces ( frame = self.frame )
        self.color    = color
        self.material = material
        self.tamanho = tamanho

        t = self.tamanho
        
        pi2 = 2.0 * pi
        pontos = []
        raio = t
        passo = 20

        for teta in arange(0.0, ( pi + pi / passo ), pi / passo ):
            for phi in arange(0.0, pi2 + pi2 / passo, pi2 / passo ):

                if phi >= pi + pi / passo:
                    y = 0.9 * raio * sin(teta) * sin(phi)
                else:
                    y = 1.3 * raio * sin(teta) * sin(phi)

                x = 0.8 * raio * cos(teta) * sin(phi)
                z = 1.5 * raio * cos(phi)
                pontos.append( [x,y,z] )

        npontos = len(pontos)
        size = int ( sqrt( npontos ) )
        mapa = zeros ( (size, size, 3), float )

        for i in range ( npontos ):
            mapa[ int(i / size) ][ int(i % size) ] = pontos[i]

        for i in range ( size-1 ):
            for j in range ( size-1 ):
                self.desenha_triangulo (mapa[i][j], mapa[i][j+1], mapa[i+1][j+1])
                self.desenha_triangulo (mapa[i][j], mapa[i+1][j], mapa[i+1][j+1])
        
        self.model.color    = self.color
        self.model.material = self.material

        self.grava_esqueleto()


    # retirado do exemplo faces_heightfield.py que acompanha o source do visual python
    def DoSmoothShading(self):

        pos = self.model.pos
        normal = self.model.normal

        vertex_map = {}
        vertex_map_backface = {}
        for i in range( len(pos) ):
            tp = tuple(pos[i])
            old_normal = vertex_map.get( tp, (0,0,0) )
            if dot(old_normal, normal[i]) >= 0:
                vertex_map[tp] = normal[i] + old_normal
            else:
                vertex_map_backface[tp] = normal[i] + vertex_map_backface.get(tp, (0,0,0))

        for i in range( len(pos) ):
            tp = tuple(pos[i])
            if dot(vertex_map[tp], normal[i]) >= 0:
                normal[i] = vector(vertex_map[tp]) and norm( vertex_map[ tp ] )
            else:
                normal[i] = vector(vertex_map_backface[tp]) and norm(vertex_map_backface[tp] )


class Cauda (Mesh):

    def __init__ (self, frame=None, color=color.white, material=None, tamanho=1):
        
        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.model    = faces(frame=self.frame)
        self.color    = color
        self.material = material
        self.tamanho  = tamanho

        t = self.tamanho

        v1 = (0.0, 0.0    ,  0.3 * t)
        v2 = (0.0, 1.3 * t, -2.3 * t)
        v3 = (0.0, 0.0    , -1.8 * t)
        self.desenha_triangulo (v1,v2,v3)

        v2 = v3
        v3 = (0.0, -0.9 * t, -2.0 * t)
        self.desenha_triangulo (v1, v2, v3)

        self.model.color    = self.color
        self.model.material = self.material

        self.grava_esqueleto()

class Boca:
  
    def __init__ (self, frame=None, color=color.white, material=None, tamanho=1):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.frame    = frame
        self.color    = color
        self.material = material
        self.tamanho  = tamanho

        t = self.tamanho

        self.cima = ring ( frame=self.frame, pos = (0.0, 0.05 * t, 1.4 * t), radius = 0.12 * t, thickness = 0.12 * t )
        self.cima.rotate ( angle = pi / 2.0, axis = (0, 1, 0) )
        self.cima.rotate ( angle = pi / 8.0, axis = (1, 0, 0) )

        self.baixo = self.cima.__copy__()
        self.baixo.rotate ( angle = -pi / 4., axis = (1, 0, 0) )

        self.cima.color    = self.baixo.color    = self.color
        self.cima.material = self.baixo.material = self.material
        
        self.t = 0
        self.pos_original_baixo = self.baixo.pos[0]
        self.pos_original_cima  = self.cima.pos[0]


    def move(self, velocidade=1):
        y = self.baixo.pos[2] / self.tamanho
        self.baixo.pos[0] = self.pos_original_baixo + \
                self.tamanho * ( sin( y + self.t * 0.1) ) / 8.0

        y = self.cima.pos[2]  / self.tamanho
        self.cima.pos[0]  = self.pos_original_cima  + \
                self.tamanho * ( sin( y + self.t * 0.1) ) / 8.0

        self.t += velocidade * pi/2


class Barbatana (Mesh):
    pass


class BarbatanaLateral (Barbatana):
    
    def __init__ (self, frame=None, color=color.white, material=None, lado=1, tamanho=1):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.frame    = frame
        self.model    = faces (frame=self.frame)
        self.color    = color
        self.material = material
        self.lado     = lado
        self.tamanho  = tamanho

        l = self.lado
        t = self.tamanho

        v1 = (l * 0.7 * t,  0.0    ,  0.6 * t)
        v2 = (l * 0.9 * t,  0.3 * t, -0.2 * t)
        v3 = (l * 0.9 * t, -0.3 * t, -0.2 * t)
        self.desenha_triangulo (v1, v2, v3)

        self.frame.rotate ( angle = l * -pi / 8.0, axis = (0, 1, 0) )
        self.model.color    = self.color
        self.model.material = self.material

        self.grava_esqueleto()

class BarbatanaSuperior (Barbatana):

    def __init__ (self, frame=None, color=color.white, material=None, tamanho=1):
        
        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.frame    = frame
        self.model    = faces (frame = self.frame)
        self.color    = color
        self.material = material
        self.tamanho  = tamanho

        t = self.tamanho

        v1 = (0.0,       t, 0.6 * t)
        v2 = (0.0, 1.4 * t, 0.0    )
        v3 = (0.0,       t, 0.0    )
        self.desenha_triangulo (v1, v2, v3)

        v1 = v3
        v2 = v2
        v3 = (0.0, 1.6 * t, -0.9 * t)
        self.desenha_triangulo (v1, v2, v3)

        self.model.color    = self.color
        self.model.material = self.material
        
        self.grava_esqueleto()

class BarbatanaInferior (Barbatana):

    def __init__ (self, frame=None, color=color.white, material=None, tamanho=1):
        
        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.frame    = frame
        self.model    = faces (frame = self.frame)
        self.color    = color
        self.material = material
        self.tamanho  = tamanho

        t = self.tamanho

        v1 = (0.0, -0.8 * t,  0.1 * t)
        v2 = (0.0, -1.0 * t, -0.5 * t)
        v3 = (0.0, -0.8 * t, -0.5 * t)
        self.desenha_triangulo (v1, v2, v3)

        v1 = v3
        v2 = v2
        v3 = (0.0, -1.3 * t, -0.9 * t)
        self.desenha_triangulo (v1, v2, v3)

        self.model.color    = self.color
        self.model.material = self.material

        self.grava_esqueleto()

class Olho:
    
    def __init__ (self, frame=None, lado=1, tamanho=1):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.frame   = frame
        self.lado    = lado
        self.tamanho = tamanho

        l = self.lado
        t = self.tamanho

        self.globo = sphere (frame=self.frame, radius = 0.10 * t, pos = (l * 0.5 * t, 0.4 * t, t), opacity = 0.5)
        self.iris  = sphere (frame=self.frame, radius = 0.06 * t, pos = (l * 0.5 * t, 0.4 * t, t), color = color.black)

        self.t = 0
        self.pos_original_globo = self.globo.pos[0]
        self.pos_original_iris  = self.iris.pos[0]


    def move(self, velocidade=1):
        y = self.globo.pos[2] / self.tamanho
        self.globo.pos[0] = self.pos_original_globo + \
                self.tamanho * ( sin( y + self.t * 0.1) ) / 8.0

        y = self.iris.pos[2]  / self.tamanho
        self.iris.pos[0]  = self.pos_original_iris  + \
                self.tamanho * ( sin( y + self.t * 0.1) ) / 8.0

        self.t += velocidade * pi/2

class PeixeXavante (threading.Thread):

    def __init__ (self, color=color.white, material=None, tamanho=1, velocidade=1):

        threading.Thread.__init__(self)
        self._move_lock = threading.Lock()

        self.frame      = frame()
        self.color      = color
        self.material   = material
        self.tamanho    = tamanho/5.0 #para caber num quadrado 1x1
        self.velocidade = velocidade
        
        self.corpo           = Corpo (frame=self.frame, color=self.color, material=self.material, tamanho=self.tamanho)
        self.corpo.DoSmoothShading()

        self.cauda           = Cauda (frame=self.frame, color=self.color, material=self.material, tamanho=self.tamanho)

        self.barbatana_esq   = BarbatanaLateral (frame=self.frame, color=self.color, material=self.material, lado= 1, tamanho=self.tamanho)
        self.barbatana_dir   = BarbatanaLateral (frame=self.frame, color=self.color, material=self.material, lado=-1, tamanho=self.tamanho)

        self.barbatana_cima  = BarbatanaSuperior (frame=self.frame, color=self.color, material=self.material, tamanho=self.tamanho)
        self.barbatana_baixo = BarbatanaInferior (frame=self.frame, color=self.color, material=self.material, tamanho=self.tamanho)

        self.olho_esq        = Olho (frame=self.frame, lado= 1, tamanho=self.tamanho)
        self.olho_dir        = Olho (frame=self.frame, lado=-1, tamanho=self.tamanho)

        self.boca            = Boca (frame=self.frame, color = self.color, material = self.material, tamanho=self.tamanho)

        self.rotate(angle=pi/2, axis=(1,0,0))


    def move(self, pos=None):
        if pos != None:
            self._move_lock.acquire()
            self.frame.pos = pos
            self._move_lock.release()


    def rotate (self, angle=0.0, axis=(0,0,0), origin=(0,0,0)):
        self._move_lock.acquire()
        p = (self.frame.pos[0], self.frame.pos[1], self.frame.pos[2])
        self.frame.rotate(angle=angle, axis=axis, origin=origin)
        self.frame.pos = p
        self._move_lock.release()


    def start_moving (self):
        self.moving = true
        self.start()

    
    def stop_moving (self):
        self.moving = false


    def keep_moving(self):
        i = 1
        while self.moving:
            rate(30)

            self._move_lock.acquire()

            self.corpo.move           (velocidade=self.velocidade)
            self.cauda.move           (velocidade=self.velocidade)
            self.barbatana_esq.move   (velocidade=self.velocidade)
            self.barbatana_dir.move   (velocidade=self.velocidade)
            self.barbatana_cima.move  (velocidade=self.velocidade)
            self.barbatana_baixo.move (velocidade=self.velocidade)

            self.olho_esq.move(velocidade=self.velocidade)
            self.olho_dir.move(velocidade=self.velocidade)
            self.boca.move    (velocidade=self.velocidade)
            
            #os.system ("import -window Xavante img%03d.jpg" % i)
            i += 1

            self._move_lock.release()


    def run (self):
        self.keep_moving()


    def set_visible (self, v):
        self.frame.visible = v



if __name__ == "__main__":

    cm = 255.0
    scene.background = (128/cm,128/cm,255/cm)
    #material_global  = None
    material_global  = materials.marble

    peixe = PeixeXavante (color=color.white, material=material_global, tamanho=1, velocidade=2)
    peixe.start_moving()

    #os.system ("import -window VPython img%02d.jpg" % i)
