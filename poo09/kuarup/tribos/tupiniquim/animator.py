#!/usr/bin/env python
# encoding: utf-8

from math import *
from mathHelper import *
"""
animator.py

Created by Leandro Gomes on 2009-03-24.
Copyright (c) 2009 __MyCompanyName__. All rights reserved.
"""

class Animator():
    def __init__(self, animatedBeing):
        self.animatedBeing = animatedBeing


class FishAnimator(Animator):
    
    def animate(self, frameNumber):
        self.animatedBeing.shakeCaudalFin(speed=3)
        self.animatedBeing.shakeLateralFins(speed=3)
        
        if(frameNumber > 0 and frameNumber < 600):
            self.animatedBeing.swin(direction="left")
        
        if(frameNumber > 600 and frameNumber < 800):
            self.animatedBeing.rotate(angle=-math.pi/500.0, axis=Y_AXIS)

        if(frameNumber > 800 and frameNumber < 1000):
            self.animatedBeing.swin(direction="left")
        
        if(frameNumber > 1000 and frameNumber < 1300):
            self.animatedBeing.rotate(angle=-math.pi/500.0, axis=(3,3,0))
        
        if(frameNumber > 1300 and frameNumber < 1600):
            self.animatedBeing.swin(direction="left")

        if(frameNumber > 1600 and frameNumber < 1800):
            self.animatedBeing.rotate(angle=math.pi/500.0, axis=Z_AXIS)
        
        if(frameNumber > 1800 and frameNumber < 2000):
            self.animatedBeing.swin(direction="left")

        if(frameNumber > 2000 and frameNumber < 3200):
            self.animatedBeing.swin(direction="left")
            self.animatedBeing.rotate(angle=math.pi/800.0, axis=Z_AXIS)

        if(frameNumber > 3200 and frameNumber < 3280):
            self.animatedBeing.swin(direction="left")
            self.animatedBeing.rotate(angle=math.pi/500.0, axis=X_AXIS)
            
        if(frameNumber > 3280 and frameNumber < 3600):
            self.animatedBeing.swin(direction="left")
            self.animatedBeing.rotate(angle=math.pi/800.0, axis=Z_AXIS)
            
        if(frameNumber > 3600 and frameNumber < 3700):
            self.animatedBeing.swin(direction="left")
            self.animatedBeing.rotate(angle=math.pi/500.0, axis=X_AXIS)

        if(frameNumber > 3700 and frameNumber < 3900):
            self.animatedBeing.swin(direction="left")

class CaracolAnimator(Animator):
    def animate(self, frameNumber):
        if(frameNumber > 0 and frameNumber < 600):
            self.animatedBeing.swin(direction="rigth")
        
        if(frameNumber > 800 and frameNumber < 1000):
            self.animatedBeing.swin(direction="rigth")

        if(frameNumber > 1300 and frameNumber < 1600):
            self.animatedBeing.swin(direction="rigth")                
        
        if(frameNumber > 1800 and frameNumber < 2000):
            self.animatedBeing.swin(direction="rigth")
    

class TurtleAnimator(Animator):
    def animate(self, frameNumber):
        if(frameNumber > 0 and frameNumber < 600):
            self.animatedBeing.swin(direction="rigth")
        
        if(frameNumber > 800 and frameNumber < 1000):
            self.animatedBeing.swin(direction="rigth")

        if(frameNumber > 1300 and frameNumber < 1600):
            self.animatedBeing.swin(direction="rigth")                
        
        if(frameNumber > 1800 and frameNumber < 2000):
            self.animatedBeing.swin(direction="rigth")