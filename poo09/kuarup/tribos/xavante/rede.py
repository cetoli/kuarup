#!/usr/bin/python

from visual import *

if __name__ == "__main__":

    c = curve(pos=(0,0,0), color=color.red, radius=1)
    for i in range(1,11):
        rate(3)
        c.append(pos=(0,i,0))
