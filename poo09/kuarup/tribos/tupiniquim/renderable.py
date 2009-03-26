#!/usr/bin/env python
# encoding: utf-8

from visual import * 
import Image

"""
renderable.py

Created by Leandro Gomes on 2009-03-22.
Copyright (c) 2009 __MyCompanyName__. All rights reserved.
"""

class Renderable:
    """Classe que representa um objeto que pode ser renderizado no universo"""
    def __init__(self, scale=1, speed=50, **args):
        self.frame = frame(**args)
        self.speed = speed
        self.scale = scale
        
        self.render()
    
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