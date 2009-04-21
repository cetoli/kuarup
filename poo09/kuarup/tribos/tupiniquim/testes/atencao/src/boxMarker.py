#!/usr/bin/env python
# encoding: utf-8

from marinho.renderable import *
from visual import *

class BoxMarker(Renderable):
    def render(self):
        self.markedIndex = 0
        self.box = box(frame=self.frame, opacity=0.3, size=(40,30,30), color=color.blue)
