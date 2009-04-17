#!/usr/bin/env python
# encoding: utf-8

from visual import *
import Image
from mathHelper import *

"""
renderable.py

Created by Leandro Gomes on 2009-03-22.
Copyright (c) 2009 __MyCompanyName__. All rights reserved.

Alterado por Tiago Cruz de França em 16-04-2009
"""

class Renderable:
    """Classe que representa um objeto que pode ser renderizado no universo"""
    def __init__(self, scale=1, speed=50.0,coord=(0,0), **args):
        self.frame = frame(**args)
        self.speed = speed
        self.scale = scale
        self.stateNotChanged = 0
        self.moveDirection = ''
        self.newPosition = ()
        self.render()
        self.rotateMe = 1
        self.coord_x = 0
        self.coord_z = 0

        self.coord = vector(coord)

    def getPosition(self):
        return self.frame.pos

    def setPosition(self, newPos):
        self.frame.pos = newPos

    def render(self):
        None

    @classmethod
    def loadTexture(self, path , keyName):
        """Carrega uma textura a partir de um arquivo jpg"""
        width = 1024
        height = 1024
        im = Image.open(path)
        im = im.resize((width,height), Image.ANTIALIAS)
        materials.saveTGA(keyName,im)

    def rotate(self, axis, angle):
        """Rotaciona um objeto"""
        self.frame.rotate(angle=angle, axis=axis)

    def move(self):
        if(self.moveDirection == 'ahead'):
            self.moveAhead()

        if(self.moveDirection == 'back'):
            self.moveBack()

        if(self.moveDirection == 'up'):
            self.moveUp()

        if(self.moveDirection == 'down'):
            self.moveDown()

        if(self.moveDirection == 'backwards'):
            self.moveBackwards()

        if(self.moveDirection == 'upwards'):
            self.moveUpwards()

    def moveAhead(self):
        self.moveDirection = 'ahead'
        self.stateNotChanged = 1

        self.rotateMe = self.frame.axis.diff_angle(X_AXIS)
        if(self.coord_z == 0):
            self.coord_z = self.frame.axis[2]
        if(self.rotateMe):
            self.frame.rotate(angle = (self.coord_z *pi)/150, axis = Y_AXIS)

        if(self.rotateMe == 0):
            currentPosition = array(self.getPosition())
            newPosition = array(self.newPosition)
            currentPosition[0] -= self.speed/500
            if currentPosition[0] <= newPosition[0]:
                currentPosition[0] = newPosition[0]
                self.stateNotChanged = 0
                self.moveDirection = ''
                self.coord_z=0
                self.coord[0] -= 1
            self.setPosition((currentPosition[0], currentPosition[1], currentPosition[2]))

    def moveBack(self):
        self.moveDirection = 'back'
        self.stateNotChanged = 1

        self.rotateMe = self.frame.axis.diff_angle(MINUS_X_AXIS)
        if(self.coord_z == 0):
            self.coord_z = self.frame.axis[2]
        if(self.rotateMe):
            self.frame.rotate(angle = (self.coord_z *pi)/150, axis = Y_AXIS)

        if(self.rotateMe == 0):
            currentPosition = array(self.getPosition())
            newPosition = array(self.newPosition)
            currentPosition[0] += self.speed/500
            if currentPosition[0] >= newPosition[0]:
                currentPosition[0] = newPosition[0]
                self.stateNotChanged = 0
                self.moveDirection = ''
                self.coord_z=0
                self.coord[0] += 1
            self.setPosition((currentPosition[0], currentPosition[1], currentPosition[2]))

    def moveBackwards(self):
        self.moveDirection = 'backwards'
        self.stateNotChanged = 1

        currentPosition = array(self.getPosition())
        newPosition = array(self.newPosition)
        currentPosition[0] += self.speed/500
        if currentPosition[0] >= newPosition[0]:
            currentPosition[0] = newPosition[0]
            self.stateNotChanged = 0
            self.moveDirection = ''
            self.coord[0] += 1
        self.setPosition((currentPosition[0], currentPosition[1], currentPosition[2]))

    def moveUp(self):
        self.moveDirection = 'up'
        self.stateNotChanged = 1

        self.rotateMe = self.frame.axis.diff_angle(Z_AXIS)
        if(self.coord_x == 0):
            self.coord_x = self.frame.axis[0]

        if(self.rotateMe):
            self.frame.rotate(angle = (-self.coord_x*pi)/200, axis = Y_AXIS)

        if(self.rotateMe == 0):
            currentPosition = array(self.getPosition())
            newPosition = array(self.newPosition)
            currentPosition[2] -= self.speed/500
            if currentPosition[2] <= newPosition[2]:
                currentPosition[2] = newPosition[2]
                self.stateNotChanged = 0
                self.moveDirection = ''
                self.coord_x = 0
                self.coord[1] -= 1

            self.setPosition((currentPosition[0], currentPosition[1], currentPosition[2]))


    def moveUpwards(self):
        self.moveDirection = 'upwards'
        self.stateNotChanged = 1

        if(self.rotateMe == 0):
            currentPosition = array(self.getPosition())
            newPosition = array(self.newPosition)
            currentPosition[2] -= self.speed/500
            if currentPosition[2] <= newPosition[2]:
                currentPosition[2] = newPosition[2]
                self.stateNotChanged = 0
                self.moveDirection = ''
                self.coord_x = 0
                self.coord[1] -= 1

            self.setPosition((currentPosition[0], currentPosition[1], currentPosition[2]))

    def moveDown(self):
        self.moveDirection = 'down'
        self.stateNotChanged = 1

        self.rotateMe = self.frame.axis.diff_angle(MINUS_Z_AXIS)
        if(self.coord_x == 0):
            self.coord_x = self.frame.axis[0]

        if(self.rotateMe):
            self.frame.rotate(angle = (self.coord_x*pi)/150, axis = Y_AXIS)

        if(self.rotateMe == 0):
            currentPosition = array(self.getPosition())
            newPosition = array(self.newPosition)
            currentPosition[2] += self.speed/500
            if currentPosition[2] >= newPosition[2]:
                currentPosition[2] = newPosition[2]
                self.stateNotChanged = 0
                self.moveDirection = ''
                self.coord_x=0
                self.coord[1] += 1
            self.setPosition((currentPosition[0], currentPosition[1], currentPosition[2]))

    def nextStep(self):
        self.move()
