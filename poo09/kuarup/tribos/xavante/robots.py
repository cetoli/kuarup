#!/usr/bin/python

import visual
from peixe_xavante import *
from tubarao import *

import random

class Cross:

    def __init__ (self, frame=None, pos=(0,0,0)):
        if frame == None:
            self.frame = visual.frame()
        else:
            self.frame = frame

        pos = (pos[0], pos[1], 0.4)
        self.ver = visual.box(frame=self.frame, pos=pos, length=0.1, height=0.1, width=0.8)
        pos = (pos[0], pos[1], 0.6)
        self.hor = visual.box(frame=self.frame, pos=pos, length=0.5, height=0.1, width=0.1)


class Robots (threading.Thread):

    def __init__ (self, width=16, height=16, num_sharks=10):
        threading.Thread.__init__(self)

        self.width      = width
        self.height     = height
        self.sharks     = {}
        self.pos_fish   = (0,0,-1)
        self.num_dead   = 0
        self.num_sharks = num_sharks

        self.draw_board()

        self.fish = PeixeXavante(velocidade=5, material=materials.marble)
        self.pos_fish = self.random_pos()
        self.fish.rotate(angle=pi/2, axis=(0,0,1))
        self.fish.move(self.pos_fish)
        self.fish.start_moving()
        self.fish.angle = 0

        for i in range(num_sharks):
            s = Tubarao(escala=0.02)
            pos_shark = self.random_pos()
            s.angle = 0
            s.rotate(angle=pi/2, axis=(1,0,0))

            self.rotate_shark(s, pos_shark)
            s.move(pos_shark)
            self.sharks[s] = pos_shark


    def random_pos (self):
        while true:
            pos_shark = (float(random.randint(0,self.width-1)), float(random.randint(0,self.height-1)), 0.0)
            if self.free_pos(pos_shark):
                break
        return pos_shark


    def free_pos (self, pos):
        for t, p in self.sharks.iteritems():
            if p == pos:
                return false
        if pos == self.pos_fish:
            return false
        if 0 <= pos[0] < self.width and 0 <= pos[1] < self.height:
            return true
        return  false


    def draw_board (self):

        for i in range(self.width+1):
            visual.curve ( pos=[ (i-0.5,-0.5), (i-0.5,self.height-0.5) ] )
        for i in range(self.height+1):
            visual.curve ( pos=[ (-0.5,i-0.5), (self.width-0.5,i-0.5) ] )


    def start_game (self):
        self.start()


    def run (self):
        pass
        while 1:
            rate(100)
            if scene.kb.keys:
                s = scene.kb.getkey()

                dx=dy=a=0

                if   s == "1" or s == "z":
                    a = -(3*pi)/4
                    dx = -1
                    dy = -1
                elif s == "2" or s == "x":
                    a = -pi/2
                    dx =  0
                    dy = -1
                elif s == "3" or s == "c":
                    a = -pi/4
                    dx = +1
                    dy = -1
                elif s == "4" or s == "a":
                    a = pi
                    dx = -1
                    dy =  0
                elif s == "5" or s == "s":
                    a = 0
                    dx =  0
                    dy =  0
                elif s == "6" or s == "d":
                    a = 0
                    dx = +1
                    dy =  0
                elif s == "7" or s == "q":
                    a = (3*pi)/4
                    dx = -1
                    dy = +1
                elif s == "8" or s == "w":
                    a = pi/2
                    dx =  0
                    dy = +1
                elif s == "9" or s == "e":
                    a = pi/4
                    dx = +1
                    dy = +1
                elif s == "t":
                    self.teleport()
                else:
                    return

                ret = self.move_fish(dx,dy,a)
                if ret:
                    self.move_sharks()

                    if self.fish_caught():
                        self.game_over()
                        exit()

                    self.check_deaths()
                    
                    if self.num_dead == self.num_sharks:
                        self.you_win()


    def teleport (self):
        self.pos_fish = self.random_pos()
        self.fish.move(self.pos_fish)


    def move_fish(self, dx, dy, ang):
        if dx or dy:
            new_pos = ( self.pos_fish[0] + dx, self.pos_fish[1] + dy, 0 )
            if self.free_pos(new_pos):
                self.pos_fish = new_pos
                self.fish.rotate(angle=ang-self.fish.angle, axis=(0,0,1))
                self.fish.angle = ang
                self.fish.move(self.pos_fish)
                return true
            else:
                return false
        return true


    def fish_caught (self):
        for s, p in self.sharks.iteritems():
            if p == self.pos_fish:
                return true
        return false


    def rotate_shark (self, shark, pos):
        if pos[0] != self.pos_fish[0]:
            tg = (pos[1]-self.pos_fish[1]) / (pos[0]-self.pos_fish[0])
            ang = arctan(tg)
            if self.pos_fish[0] < pos[0]:
                ang += pi
        else:
            if self.pos_fish[1] > pos[1]:
                ang = pi/2
            else:
                ang = -pi/2
        shark.rotate(angle=ang+shark.angle, axis=(0,0,1))
        shark.angle = -ang


    def move_sharks (self):
        for s, p in self.sharks.iteritems():
            if not s.visible:
                continue

            dx=dy=0
            if   p[0] > self.pos_fish[0]:
                dx = -1
            elif p[0] < self.pos_fish[0]:
                dx =  1
            if   p[1] > self.pos_fish[1]:
                dy = -1
            elif p[1] < self.pos_fish[1]:
                dy =  1

            p = (p[0]+dx, p[1]+dy, 0)
            self.rotate_shark(s, p)
            s.move(p)
            self.sharks[s]=p

    def check_deaths (self):
        for s1, p1 in self.sharks.iteritems():
            for s2, p2 in self.sharks.iteritems():
                if s1 != s2 and p1 == p2 and (s1.visible or s2.visible):

                    if s1.visible and s2.visible:
                        self.num_dead += 2
                    else:
                        self.num_dead += 1

                    s1.set_visible(false)
                    s2.set_visible(false)

                    Cross(pos=p1)


    def you_win (self):
        label (pos = (self.width/2, self.height/2, 0), text="Yahoo!!", height=40)


    def game_over (self):
        self.fish.stop_moving()
        self.fish.rotate(angle=-pi/2, axis=(1,0,0))
        self.fish.move( (self.pos_fish[0], self.pos_fish[1], 1) )

        for s, p in self.sharks.iteritems():
            if p == self.pos_fish:
                s.rotate(angle=-pi/2, axis=(1,0,0))
                s.move( (p[0], p[1], 0.5) )

        label (pos = (self.width/2, self.height/2, 0), text="Game Over", height=40)



if __name__ == "__main__":
    
        
    scene.title     = "Xavante"
    scene.width     = 600 +  9
    scene.height    = 600 + 30
    scene.autocenter= 1
    scene.autoscale = 1

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)
    
    scene.forward = (0,1,-3)
    scene.scale = (0.21,0.21,0.21)

    jogo = Robots(width=8, height=8, num_sharks=5)
    jogo.start_game()
    
    scene.autocenter = 0
    scene.autoscale  = 0

    #os.system ("import -window Xavante img%03d.jpg" % i)
