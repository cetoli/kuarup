#!/usr/bin/python

from visual import *

class Mesh:
    "classe especializada em desenhar triangulos"
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

class Casca (Mesh):
    "classe que, dado um esqueleto, consegue desenhar uma casca ao seu redor"
    def desenha_casca (self, esqueleto=[], raio=1.0, passos=10.0, razao=0.93):

        primeiro = true
        segundo = false
        for p in esqueleto:

            circulo = []

            # Calculamos os pontos do circulo ao redor deste ponto do esqueleto.
            # Os pontos calculados nesta rodada sao guardados em "circulo".
            inicio = 0.0
            fim = 2.0*pi
            passo = (fim-inicio)/(passos)
            for t in arange(inicio, fim, passo):
                x = p[0] + cos(t) * raio
                y = p[1]
                z = p[2] + sin(t) * raio
                circulo.append( [x,y,z] )

            # Se este eh o primeiro ponto do esqueleto, guardamos os valores
            # e seguimos em frente.
            if primeiro:
                primeiro   = false
                segundo    = true
                p_anterior = p
                circulo_anterior = circulo
                continue

            # encontramos a normal ao circulo deste ponto
            normal=[0,0,0]
            for j in range(3):
                normal[j] = p_anterior[j] - p[j]

            #arrow (pos=p, axis=normal, shaftwidth=0.1)

            # encontramos o angulo teta entre a normal e o eixo y
            teta = arccos (
                    normal[1] / sqrt(normal[0]**2 + normal[1]**2 + normal[2]**2)
                    )
            if (normal[0] > 0.0):
                teta *= -1.0

            # Como o primeiro circulo nunca sera rotacionado,
            # devemos tomar cuidado.
            # Se o angulo de rotacao do segundo circulo for muito grande,
            # as faces nao vao ser construidas direto.
            if segundo:
                segundo = false
                if teta > pi/2.0:
                    fator = -pi
                elif teta < -pi/2.0:
                    fator = pi
                else:
                    fator = 0.0
            teta += fator

            # rotacionamos os pontos usando o angulo teta
            inicio = 0
            fim = pi
            for c in circulo:
                # centralizando o ponto na origem
                c[0] -= p[0]
                c[1] -= p[1]
                c[2] -= p[2]

                # fazendo a rotacao ao redor de z
                x = c[0]*cos(teta) - c[1]*sin(teta)
                y = c[0]*sin(teta) + c[1]*cos(teta)
                z = c[2]

                # reposiocionando o ponto
                c[0] = x + p[0]
                c[1] = y + p[1]
                c[2] = z + p[2]

            # desenhamos as faces usando os pontos desta rodada e da anterior
            for i in range( -1, len(circulo) - 1 ):
                self.desenha_triangulo (
                        circulo[i], circulo_anterior[i+1], circulo_anterior[i],
                        color=self.color
                        )
                self.desenha_triangulo (
                        circulo[i], circulo[i+1], circulo_anterior[i+1],
                        color=self.color
                        )

            # guardamos esta rodada para ser usada pela proxima
            p_anterior       = p
            circulo_anterior = circulo
            raio            *= razao

        self.model.material = self.material

    def DoSmoothShading(self):
        """Change a faceted model to smooth shaded, by averaging normals at
        coinciding vertices.
        
        This is a very slow and simple smooth shading
        implementation which has to figure out the connectivity of the
        model and does not attempt to detect sharp edges.

        It attempts to work even in two-sided mode where there are two
        opposite normals at each vertex.  It may fail somehow in pathological
        cases."""

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
                vertex_map_backface[tp] = normal[i] + \
                        vertex_map_backface.get(tp, (0,0,0))

        for i in range( len(pos) ):
            tp = tuple(pos[i])
            if dot(vertex_map[tp], normal[i]) >= 0:
                normal[i] = vector(vertex_map[tp]) and norm( vertex_map[ tp ] )
            else:
                normal[i] = vector(vertex_map_backface[tp]) and \
                        norm(vertex_map_backface[tp] )

class Cabeca (Mesh):

    def __init__ (self, color=color.white, material=None, frame=None, model=None, tamanho=5.0):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.tamanho = tamanho
        self.color = color
        self.material = material
        
        if model == None:
            self.model = faces ( frame = self.frame )
        else:
            self.model = model

    def desenha (self):

        d = self.tamanho

        # o formato da cabeca
        cranio = cone (
                frame=self.frame, pos=(0.92*d, 2.38*d, 0),
                axis=(-0.6*d, -0.3*d, 0), radius=0.2*d,
                color=self.color, material=self.material
                )

        boca =  cylinder (
                frame=self.frame, pos=(0.92*d, 2.38*d, 0),
                axis=(-0.6*d, -0.3*d, 0), radius=0.04*d,
                color=self.color, material=self.material
                )

        # os olhos
        pupila_esq = sphere (
                frame=self.frame, pos=(0.7*d, 2.4*d,  0.09*d), radius=0.03*d,
                color=color.black
                )
        pupila_dir = sphere (
                frame=self.frame, pos=(0.7*d, 2.4*d, -0.09*d), radius=0.03*d,
                color=color.black
                )

        olho_esq = sphere (
                frame=self.frame, pos=(0.7*d, 2.4*d,  0.09*d), radius=0.03*d,
                color=self.color, opacity=0.3
                )
        olho_dir = sphere (
                frame=self.frame, pos=(0.7*d, 2.4*d, -0.09*d), radius=0.03*d,
                color=self.color, opacity=0.3
                )

        # uma especie de chifre feito com triangulos
        v1 = (0.6 *d, 2.2 *d,  0.0  )
        v2 = (1.0 *d, 2.64*d, -0.2*d)
        v3 = (0.96*d, 2.64*d,  0.0  )
        self.desenha_triangulo ( v1,v2,v3, self.color )
        
        v2 = (1.0 *d, 2.64*d, 0.2*d)
        v3 = (0.96*d, 2.64*d, 0.0  )
        self.desenha_triangulo ( v1,v2,v3, self.color )

        self.model.material = self.material

class Corpo (Casca):

    def __init__ (self, color=color.white, material=None, frame=None, model=None, tamanho=5.0):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.tamanho = tamanho
        self.color = color
        self.material = material
        
        if model == None:
            self.model = faces ( frame = self.frame )
        else:
            self.model = model

    def desenha (self):
        esqueleto = []

        d      = self.tamanho
        passos = 10.0
        raio   = 0.4*d

        # primeira parte do corpo, mais grossa
        # seu esqueleto eh como uma reta ligeiramente inclinada
        inicio =       d
        fim    = 2.0 * d
        passo = (fim-inicio)/passos
        for y in arange (inicio, fim, passo):
            x = 0.9*d + 0.1*y
            esqueleto.append( (x,y,0) )

        # a segunda parte do corpo eh o pescoco
        # seu esqueleto eh circular
        x0 = esqueleto[-1][0]
        y0 = esqueleto[-1][1]

        inicio = 0.0
        fim    = pi/1.7
        passo_anterior = passo
        passo = (fim-inicio)/passos
        for t in arange (inicio, fim, passo): 
            x = x0 + cos(t)*(d/5.0) - 1.0*(d/5.0)
            y = y0 + 2.0*sin(t)*(d/5.0) + passo_anterior
            esqueleto.append( (x,y,0) )

        self.desenha_casca(esqueleto, raio, passos, 0.95)

        # barbatana traseira do cavalo marinho, chato de fazer usando piramides
        # mas triangulos nao tem transparencia...
        base = (1.36*d, 1.26*d, 0)
        p = pyramid ( frame=self.frame, pos=base, size=(0.4*d, 0.4*d, 0), \
                opacity=0.3 )
        base = (1.76*d, 1.26*d, 0)
        p.rotate(angle=pi*0.34, axis=(0,0,1), origin=base)

        base = (1.36*d, 1.26*d, 0)
        p = pyramid ( frame=self.frame, pos=base, size=(0.4*d, 0.4*d, 0), \
                opacity=0.3 )
        base = (1.76*d, 1.26*d, 0)
        p.rotate(angle=pi*0.045, axis=(0,0,1), origin=base)
        
        base = (1.36*d, 1.26*d, 0)
        p = pyramid ( frame=self.frame, pos=base, size=(0.4*d, 0.4*d, 0), \
                opacity=0.3 )
        base = (1.76*d, 1.26*d, 0)
        p.rotate(angle=pi*1.75, axis=(0,0,1), origin=base)

class Cauda (Casca):

    def __init__ (self, color=color.white, material=None, frame=None, model=None, tamanho=5.0):

        if frame == None:
            self.frame = frame()
        else:
            self.frame = frame

        self.tamanho  = tamanho
        self.color    = color
        self.material = material

        if model == None:
            self.model = faces ( frame = self.frame )
        else:
            self.model = model

    def desenha (self):
        esqueleto = []

        d      = self.tamanho
        passos = 10.0
        raio   = 0.4*d

        # primeira parte da cauda
        # esta eh a parte mais grossa e vertical
        inicio = d
        fim    = 0.0
        x      = d
        for y in arange (inicio, fim, (fim-inicio)/(2.0*passos)):
            esqueleto.append( [x,y,0] )

        # segunda parte da cauda
        # esta parte ainda eh bem grossa e eh como um quarto de um circulo ao redor da origem com raio d
        inicio = pi
        fim    = 1.5*pi
        for t in arange (inicio, fim, (fim-inicio)/passos):
            x = -d * cos ( t )
            y =  d * sin ( t )
            esqueleto.append ( [x,y,0] )

        # terceira parte da cauda
        # esta parte eh como um circulo ao redor do ponto (0, 0.75) de raio d/4
        inicio = 1.5*pi
        fim    = 2.5*pi
        for t in arange (inicio, fim, (fim-inicio)/passos):
            x = -d/4. * cos(t)
            y = d/4. * sin(t) - 0.75 * d
            esqueleto.append ( [x,y,0] )

        # quarta parte da cauda
        # esta parte eh como um circulo ao redor do ponto (0, 0.75-0.125) de raio d/8
        inicio = 2.5*pi
        fim    = 3.5*pi
        for t in arange (inicio, fim, (fim-inicio)/passos):
            x = -d/8. * cos(t)
            y = d/8. * sin(t) - (0.75-0.125) * d
            esqueleto.append ( [x,y,0] )

        # desenhamos a casca ao redor do esqueleto
        self.desenha_casca(esqueleto, raio, passos, 0.93)

class CavaloMarinho:

    def __init__ (self, color=color.white, material=None, tamanho=1.0):
        self.frame = frame()
        self.model = faces ( frame=self.frame )

        self.color    = color
        self.material = material
        self.tamanho  = tamanho * 0.15

        cabeca = Cabeca (self.color, self.material, self.frame, \
                self.model, self.tamanho)
        cabeca.desenha()

        corpo = Corpo   (self.color, self.material, self.frame, \
                self.model, self.tamanho)
        corpo.desenha()
        corpo.DoSmoothShading()

        cauda = Cauda   (self.color, self.material, self.frame, \
                self.model, self.tamanho)
        cauda.desenha()
        cauda.DoSmoothShading()

        self.rotate(axis=(1,0,0), angle=pi/2)
        self.rotate(axis=(0,0,1), angle=pi/2)
        self.move( (0,0,0) )

    def move (self, pos=(0,0,0)):
        self.frame.pos = pos

    def rotate (self, angle=0.0, axis=(0,0,0), origin=(0,0,0)):
        self.frame.rotate (angle=angle, axis=axis, origin=origin)

"""
MAIN

if __name__ == "__main__":
    scene.background = color.blue
    scene.autocenter = true

    cor_padrao = (0.8, 0.6, 0.0)
    #material_padrao = materials.marble
    material_padrao = None

    cavaloMarinho1 = CavaloMarinho (cor_padrao, material_padrao, 10)

    cavaloMarinho2 = CavaloMarinho (cor_padrao, material_padrao, 5, pos=(10,0,5))
    cavaloMarinho2.rotate (angle=pi/2.0, axis=(0,1,0))

    cavaloMarinho3 = CavaloMarinho (cor_padrao, material_padrao, 3, pos=(25,20,0))
    cavaloMarinho3.rotate (angle=-pi/2.0, axis=(0,1,0))
"""
