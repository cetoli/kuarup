#!/usr/bin/python

import visual
from peixe_xavante import *
from cavalo_marinho import *

def init_window ():
    scene.title      = "Memoria"
    scene.width      = 600 +  9
    scene.height     = 600 + 30

    scene.autocenter = 1
    scene.autoscale  = 1

    scene.forward = (0, 1, -1)
    #scene.scale   = (0.095, 0.095, 0.095)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)


if __name__ == "__main__":

    init_window()
    
    peixe1a = PeixeXavante(color=color.red)
    peixe1b = PeixeXavante(color=color.red)

    peixe2a = PeixeXavante(color=color.blue)
    peixe2b = PeixeXavante(color=color.blue)

    peixe3a = PeixeXavante(color=color.green)
    peixe3b = PeixeXavante(color=color.green)

    peixe4a = PeixeXavante(color=color.yellow)
    peixe4b = PeixeXavante(color=color.yellow)
    
    cavalo1a = CavaloMarinho(color=color.red)
    cavalo1b = CavaloMarinho(color=color.red)

    cavalo2a = CavaloMarinho(color=color.blue)
    cavalo2b = CavaloMarinho(color=color.blue)

    cavalo3a = CavaloMarinho(color=color.green)
    cavalo3b = CavaloMarinho(color=color.green)

    cavalo4a = CavaloMarinho(color=color.yellow)
    cavalo4b = CavaloMarinho(color=color.yellow)


    peixe1a.move (
            (0,-1,0) )
    peixe4a.move (
            (1,-1,0) )
    cavalo3a.move(
            (2,-1,0) )
    cavalo2b.move(
            (3,-1,0) )
    
    peixe1b.move (
            (0, 1,0) )
    cavalo2a.move(
            (1, 1,0) )
    cavalo1a.move(
            (2, 1,0) )
    peixe4b.move (
            (3, 1,0) )


    cavalo3b.move(
            (0, 0,0) )
    peixe2a.move (
            (1, 0,0) )
    peixe2b.move (
            (2, 0,0) )
    cavalo4b.move(
            (3, 0,0) )
    
    peixe3a.move (
            (0, 2,0) )
    cavalo1b.move(
            (1, 2,0) )
    peixe3b.move (
            (2, 2,0) )
    cavalo4a.move(
            (3, 2,0) )
