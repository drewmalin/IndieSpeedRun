from com.orbit.core import EntityScript
import Level3

class Entity(EntityScript):
    
    def __init__(self):
        self.data = {}

    def setPosition(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def onInteract(self):
        
        if ('mass' not in self.data.keys()):
            if (self.x >= 191 and self.x <= 201):
                if (self.y >= 217 and self.y <= 227):
                    ret = Level3.update(2)
                    if (ret == True):
                        self.data['mass'] = 1
                        self.data['destroyOther'] = ['res/entities/3/Door3_1.xml', 'res/entities/3/Door3_2.xml']

        return self.data
