
#! /usr/bin/env python

# -*- coding: UTF8 -*-

from visual import *
from marine import *

class Caracol(Marine):

    def render(self):
        s = self.scale
        esqueleto = self.frame

        self.corpo = ellipsoid(frame = esqueleto, pos=(2*s,-4*s,0), length=7*s, height=s, width=4*s, color=color.yellow)

        casco1 = ellipsoid(frame = esqueleto, pos=(0,0,0), length=8*s, height=8*s, width=2*s, color=color.orange, material=materials.wood)

        casco2 = ellipsoid(frame = esqueleto, pos=(0,0,0), length=6*s, height=6*s, width=3*s, color=color.red, material=materials.wood)

        casco3 = ellipsoid(frame = esqueleto, pos=(0,0,0), length=4*s, height=4*s, width=3.5*s, color=color.yellow, material=materials.wood)

        antenaE = cylinder(frame = esqueleto, pos=(3*s,-4*s,-1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)

        antenaD = cylinder(frame = esqueleto, pos=(3*s,-4*s,1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)

        olhoE = sphere(frame = esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.white, radius = 1.5*s, opacity=0.6)

        olhoD = sphere(frame = esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.white, radius = 1.5*s, opacity=0.6)

        pupilaE = sphere(frame = esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.black, radius = 1*s)

        pupilaD = sphere(frame = esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.black, radius = 1*s)