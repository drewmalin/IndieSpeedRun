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
            if (self.x >= 122 and self.x <= 132):
                if (self.y >= 155 and self.y <= 165):
                    ret = Level3.update(0)
                    if (ret == True):
                        self.data['mass'] = 1
                        self.data['destroyOther'] = ['res/entities/3/Door3_1.xml', 'res/entities/3/Door3_2.xml']

        return self.data
