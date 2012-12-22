from com.orbit.core import EntityScript
import Level3

class Entity(EntityScript):
    
    def __init__(self):
        self.data = {}

    def onInteract(self):

        self.data['destroy'] = 'FALSE'

        return self.data
