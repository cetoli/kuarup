#!/usr/bin/env python
# encoding: utf-8

from visual import *

scene.height=400
scene.width=400

scene.autoscale=1
scene.background=color.black

class Barril:
    def __init__(self):
        corpoBarril = cylinder(pos=(0,-2,1), axis=(0,5,0), radius=1.9, color=(50,50,50), material=materials.rough)

        anelBarril1 = ring(pos=(0,3,1), axis=(0,5,0), radius=2, thickness=0.1, color=(108,123,139), material=materials.rough)

        anelBarrilMeio1 = ring(pos=(0,1.25,1), axis=(0,5,0), radius=2, thickness=0.1, color=(108,123,139), material=materials.rough)

        anelBarrilMeio2 = ring(pos=(0,-0.5,1), axis=(0,5,0), radius=2, thickness=0.1, color=(108,123,139), material=materials.rough)

        anelBarril3 = ring(pos=(0,-2,1), axis=(0,5,0), radius=2, thickness=0.1, color=(108,123,139), material=materials.rough)

if __name__ == "__main__":
    Barril()